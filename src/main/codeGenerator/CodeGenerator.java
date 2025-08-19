package main.codeGenerator;

import main.ast.nodes.Statement.IterationStatement.*;
import main.ast.nodes.Statement.JumpStatement.*;
import main.ast.nodes.Statement.SelectionStatement;
import main.ast.nodes.declaration.*;
import main.ast.nodes.expr.*;
import main.ast.nodes.expr.operator.BinaryOperator;
import main.ast.nodes.expr.operator.UnaryOperator;
import main.ast.nodes.expr.primitives.*;
import main.visitor.Visitor;

import java.util.*;

public class CodeGenerator extends Visitor<CodeObject> {
    private boolean insideFunction = false;
    public final RegisterManager registerManager;
    public final MemoryManager memoryManager;
    public final InstructionEmitter emitter;
    public final LabelManager labelManager;
    public final NameManager nameManager;
    private final Deque<String> loopEndLabels = new ArrayDeque<>();
    private final Deque<String> loopContinueLabels = new ArrayDeque<>();
    private String currentFunctionEndLabel;

    private final Register ZR;
    private final Register RA;
    private final Register RT;
    private final Register FP;
    private final Register SP;

    public CodeGenerator(MemoryManager memoryManager) {
        this.memoryManager = memoryManager;
        registerManager = new RegisterManager(memoryManager);
        emitter = new InstructionEmitter();
        labelManager = new LabelManager();
        nameManager = new NameManager();
        ZR = registerManager.ZR;
        RA = registerManager.RA;
        RT = registerManager.RT;
        FP = registerManager.FP;
        SP = registerManager.SP;
    }

    @Override
    protected void merge(CodeObject into, CodeObject from) {
        if (into != null && from != null) {
            into.addCode(from);
        }
    }

    @Override
    protected CodeObject defaultResult() {
        return new CodeObject();
    }


    /** Register commands:*/
    private Register getRegisterForRead(CodeObject code, String... varNames){
        if(varNames.length>2){
            throw new RuntimeException("More than two varNames passed");
        }
        List<RegisterAction> actions = new ArrayList<>();

        Register reg;
        if (varNames.length == 1)
            reg = registerManager.allocateForRead(varNames[0], actions);
        else
            reg = registerManager.allocateTwoForRead(varNames[0], varNames[1], actions);

        generateRegActionCode(actions, code);
        return reg;
    }

    private Register getRegisterForWrite( CodeObject code, String... varNames){
        if(varNames.length>2){
            throw new RuntimeException("More than two varNames passed");
        }
        List<RegisterAction> actions = new ArrayList<>();
        Register reg;
        if (varNames.length == 1)
            reg = registerManager.allocateForWrite(varNames[0], actions);
        else
            reg = registerManager.getFreeRegister(Arrays.asList(varNames), actions);

        generateRegActionCode(actions, code);
        return reg;
    }

    public void generateRegActionCode(List<RegisterAction> actions, CodeObject code){
        for (RegisterAction action : actions) {
            switch (action.type) {
                case SPILL_L -> code.addCode(emitter.SW(action.register, action.offset, FP));
                case LOAD_L  -> code.addCode(emitter.LW(action.register, action.offset, FP));
                case SPILL_G -> code.addCode(emitter.STI(action.register, action.address));
                case LOAD_G -> code.addCode(emitter.LDI(action.address, action.register));
            }
        }
    }

    public CodeObject visit(Declaration declaration) {
        CodeObject code = new CodeObject();
        for (InitDeclarator initDeclarator : declaration.getInitDeclarators()) {

            String varName = initDeclarator.getDeclarator().getSpecialName();
            CodeObject exprCode;

            if(initDeclarator.getDeclarator().isArray()) {
                int array_size = initDeclarator.getDeclarator().getDirectDeclarator().getArraySize();
            }
            else {

                if(initDeclarator.getInitializer() == null)
                    continue;
                if (initDeclarator.getInitializer().getExpr() != null)
                    exprCode = initDeclarator.getInitializer().getExpr().accept(this);
                else
                    throw new RuntimeException("Initializer List not supported");


                code.addCode(exprCode);
                String resultVar = exprCode.getResultVar();
                Register resultReg = getRegisterForRead(code , resultVar);
                if (!insideFunction) {
                    String addressVar = nameManager.newTmpVarName();
                    Register addressReg = getRegisterForWrite(code, addressVar);
                    int address = memoryManager.allocateGlobal(varName, 2);

                    code.addCode(emitter.MSI(address, addressReg));
                    code.addCode(emitter.STR(resultReg, addressReg));


                    this.registerManager.freeRegister(resultVar);
                    this.registerManager.freeRegister(addressVar);

                } else {
                    if(nameManager.isTmp(resultVar)){
                        registerManager.freeRegister(resultVar);
                        registerManager.assignRegister(resultReg, varName);
                    }
                    else{
                        Register desReg = getRegisterForWrite(code, varName);
                        code.addCode(emitter.ADR(ZR, resultReg, desReg));
                    }
                }
            }

            this.memoryManager.printState();
        }

        return code;
    }

    @Override
    public CodeObject visit(ArrayExpr arrayExpr) {
        CodeObject code = new CodeObject();
        CodeObject Inside = arrayExpr.getInside().accept(this);
        code.addCode(Inside);

        String resultInside = Inside.getResultVar();
        Register regInside =  getRegisterForRead(code, resultInside);
        regInside.lock();

        //Todo: handle the cases outExpr is not identifier
        String array_name = ((Identifier)arrayExpr.getOutside()).getSpecialName();
        String tmpVar = nameManager.newTmpVarName();
        Register tmpReg = getRegisterForWrite(code, tmpVar);

        code.addCode(emitter.MSI(memoryManager.getLocalStart(array_name), tmpReg));
        code.addCode(emitter.ADR(regInside, regInside, regInside));
        code.addCode(emitter.SUR(regInside, tmpReg, tmpReg));
        code.addCode(emitter.ADR(tmpReg, FP, tmpReg));
        code.setAddress(tmpVar);

        tmpReg.lock();
        regInside.unlock();

        String addressVarName = nameManager.newTmpVarName();
        Register addressVarReg = getRegisterForWrite(code, addressVarName);
        code.addCode(emitter.ADR(ZR, tmpReg, addressVarReg));
        code.addCode(emitter.LDR(tmpReg, tmpReg));
        code.setResultVar(tmpVar);
        code.setAddress(addressVarName);

        tmpReg.unlock();
        registerManager.freeRegister(tmpVar);

        return code;
    }

    public CodeObject ArrayStore(Register operand1reg, String address, boolean isArray) {
        CodeObject code = new CodeObject();
        if(isArray) {
            Register reg = getRegisterForWrite(code, address);
            code.addCode(emitter.STR(operand1reg, reg));
        }
        return code;

    }

    /// generate code for Function:
    /// 1 - generate a label for the beginning of function definition
    /// 2 - store the current frame-pointer to the stack
    /// 3 - as new function is called another frame should be initialized so the fp is updated to current stack-pointer
    /// 4 - move the sp to point to the clear cell of memory
    /// 5 - store the used registers
    ///
    /// stack state during call: <p>
    /// <pre>
    ///     |              |
    ///     |  ...         |
    ///     |  locals      |
    ///     |  reg 11(RA)  |
    ///     |  ...         |
    ///     |  reg 2       |
    ///     |  reg 1       |
    ///     |  old fp      | <- new fp pointing here
    ///     |  arg n       |
    ///     |  ... .       |
    ///     |  arg2        |
    ///     |  arg1        |
    /// </pre>
    /// @param functionDefinition : function definition node
    @Override
    public CodeObject visit(FunctionDefinition functionDefinition) {
        insideFunction = true;
        CodeObject code = new CodeObject();

        memoryManager.beginFunction(functionDefinition.getName());
        registerManager.clearRegisters();
        currentFunctionEndLabel = labelManager.generateFunctionReturnLabel(functionDefinition.getName());
        List<Declaration> args = functionDefinition.getArgDeclarations();
        for(int i = 0; i < args.size(); i++){
            Declaration arg = args.get(i);
            memoryManager.setFunctionArgOffset(arg.getSpecialName(), args.size() - i);
        }

        CodeObject bodyCode = functionDefinition.getBody().accept(this);
        List<Register> bodyUsedReg = bodyCode.getUsedRegisters();
        bodyUsedReg.add(RA);



        code.addCode(emitter.emitLabel(labelManager.generateFunctionLabel(functionDefinition.getName())));
        code.addCode(emitter.STR(FP, SP));
        code.addCode(emitter.ADR(ZR, SP, FP));
        code.addCode(emitter.ADI(-2, SP));

        if(!functionDefinition.getName().equals( "main")){
            for (Register reg : bodyUsedReg) {
                code.addCode(emitter.STR( reg, SP));
                code.addCode(emitter.ADI( -2, SP));
            }
        }

        code.addCode(bodyCode);


        code.addCode(emitter.emitLabel(currentFunctionEndLabel));
        //set the SP to the (FP - bodyUsedReg.size()) to the begin of registers stored in stack
        code.addCode(emitter.ADR(ZR,FP, SP));
        if(!functionDefinition.getName().equals( "main"))
            code.addCode(emitter.ADI(-bodyUsedReg.size() * 2, SP));


        if(!functionDefinition.getName().equals( "main")) {
            for (int i = bodyUsedReg.size() - 1; i >= 0; i--) {
                Register reg = bodyUsedReg.get(i);
                code.addCode(emitter.ADI(2, SP));
                code.addCode(emitter.LDR(SP, reg));
            }
        }

        code.addCode(emitter.LDR(FP, FP));

        code.addCode(emitter.JMR(RA));


        return code;
    }

    @Override
    public CodeObject visit(ReturnStatement returnStatement) {
        CodeObject code = new CodeObject();
        if(returnStatement.getExpr() != null) {
            CodeObject retStCode = returnStatement.getExpr().accept(this);
            code.addCode(retStCode);
            String resultVar = retStCode.getResultVar();
            Register regResult =  getRegisterForRead(code, resultVar);
            code.addCode(emitter.ADR(ZR, regResult, RT));
            if(nameManager.isTmp(resultVar)) registerManager.freeRegister(resultVar);
        }
        code.addCode(emitter.JMP(currentFunctionEndLabel));
        return code;
    }

    @Override
    public CodeObject visit(FunctionExpr functionExpr) {
        CodeObject code = new CodeObject();
        code.addCode(emitter.emitComment("FunctionCall", InstructionEmitter.Color.GREEN));
        List<Expr> arguments = functionExpr.getArguments();
        List<Integer> tempOffsets = new ArrayList<>();
        for (int i = 0; i< arguments.size(); i++) {
            Expr arg = arguments.get(i);
            CodeObject argCode = arg.accept(this);

            code.addCode(emitter.emitComment("arg_" + i, InstructionEmitter.Color.BLUE));
            code.addCode(argCode);

            Register resultReg = getRegisterForRead(code, argCode.getResultVar());


            int offset = memoryManager.allocateLocal(".arg_"+ i,2);
            tempOffsets.add(offset);

            code.addCode(emitter.SW(resultReg, offset, FP));
        }


        for (int offset : tempOffsets) {
            String tmpName = nameManager.newTmpVarName();
            Register tmpReg = getRegisterForWrite(code, tmpName);
            code.addCode(emitter.LW(FP, offset, tmpReg));

            code.addCode(emitter.STR(tmpReg, SP));
            code.addCode(emitter.ADI(-2, SP));

            registerManager.freeRegister(tmpName);
        }

        String funcLabel = labelManager.generateFunctionLabel(functionExpr.getName());
        code.addCode(emitter.JMPS(funcLabel, RA));
        code.addCode(emitter.ADI(2 * tempOffsets.size(), SP));


        String tmpVar = nameManager.newTmpVarName();
        Register tmpReg = getRegisterForWrite(code, tmpVar);
        code.addCode(emitter.ADR(ZR, RT, tmpReg));
        code.setResultVar(tmpVar);

        code.addCode(emitter.emitComment("FunctionCall_END", InstructionEmitter.Color.GREEN));
        return code;
    }


    public CodeObject visit(WhileStatement whileStatement){
        CodeObject code = new CodeObject();
        String condLabel = labelManager.generateWhileConditionLabel();
        String bodyLabel = labelManager.generateWhileBodyLabel();
        String endLabel = labelManager.generateWhileEndLabel();

        loopEndLabels.push(endLabel);
        loopContinueLabels.push(condLabel);

        code.addCode(emitter.emitLabel(condLabel));
        if(whileStatement.getCondition() != null) {
            code.addCode(branch(whileStatement.getCondition(), bodyLabel, endLabel));
        }
        else {
            code.addCode(emitter.JMP(bodyLabel));
        }


        code.addCode(emitter.emitLabel(bodyLabel));
        if (whileStatement.getBody() != null) {
            code.addCode(whileStatement.getBody().accept(this));
        }
        code.addCode(emitter.JMP(condLabel));

        code.addCode(emitter.emitLabel(endLabel));

        loopEndLabels.pop();
        loopContinueLabels.pop();


        return code;
    }


    @Override
    public CodeObject visit(ForStatement forStatement) {
        CodeObject code = new CodeObject();
        String condLabel = labelManager.generateForConditionLabel();
        String bodyLabel = labelManager.generateForBodyLabel();
        String endLabel = labelManager.generateForEndLabel();
        String stepLabel = labelManager.generateForStepLabel();

        loopEndLabels.push(endLabel);
        loopContinueLabels.push(stepLabel);

        if (forStatement.getForCondition().getDeclaration() != null) {
            code.addCode(forStatement.getForCondition().getDeclaration().accept(this));
        }
        else if (forStatement.getForCondition().getExpr() != null) {
            code.addCode(forStatement.getForCondition().getExpr().accept(this));
        }


        code.addCode(emitter.emitLabel(condLabel));
        code.addCode(branchFromAndList(forStatement.getForCondition().getConditions(), bodyLabel, endLabel));

        code.addCode(emitter.emitLabel(bodyLabel));
        if (forStatement.getBody() != null) {
            code.addCode(forStatement.getBody().accept(this));
        }
        code.addCode(emitter.JMP(stepLabel));

        code.addCode(emitter.emitLabel(stepLabel));
        if (forStatement.getForCondition().getSteps() != null) {
            for (Expr step : forStatement.getForCondition().getSteps()) {
                code.addCode(step.accept(this));
            }
        }
        code.addCode(emitter.JMP(condLabel));

        code.addCode(emitter.emitLabel(endLabel));

        loopEndLabels.pop();
        loopContinueLabels.pop();

        return code;
    }


    private CodeObject branchFromAndList(List<Expr> conditions, String trueLabel, String falseLabel) {
        CodeObject code = new CodeObject();

        if (conditions == null || conditions.isEmpty()) {
            code.addCode(emitter.JMP(trueLabel));
            return code;
        }

        List<String> intermediateLabels = new ArrayList<>();
        for (int i = 0; i < conditions.size() - 1; i++) {
            intermediateLabels.add(labelManager.generateAndChainLabel());
        }

        for (int i = 0; i < conditions.size(); i++) {
            Expr cond = conditions.get(i);
            String nextTrueLabel = (i == conditions.size() - 1) ? trueLabel : intermediateLabels.get(i);
            code.addCode(branch(cond, nextTrueLabel, falseLabel));
            if (i < intermediateLabels.size()) {
                code.addCode(emitter.emitLabel(intermediateLabels.get(i)));
            }
        }

        return code;
    }

    @Override
    public CodeObject visit(BreakStatement breakStatement) {
        CodeObject code = new CodeObject();
        String endLabel = loopEndLabels.peek();
        code.addCode(emitter.JMP(endLabel));
        return code;
    }

    public CodeObject visit(ContinueStatement continueStmt) {
        CodeObject code = new CodeObject();
        String stepLabel = loopContinueLabels.peek();
        code.addCode(emitter.JMP(stepLabel));
        return code;
    }

    public CodeObject branch(Expr expr, String trueLabel, String falseLabel) {
        CodeObject code = new CodeObject();

        if(expr instanceof UnaryExpr unaryexpr) {
            if(unaryexpr.getOperator() == UnaryOperator.NOT) {
                code.addCode(branch(unaryexpr.getOperand(), falseLabel, trueLabel));
                return code;
            }
        }//base case where it reaches compare operations:
        else if(expr instanceof BinaryExpr binaryExpr) {
            if(binaryExpr.getOperator() == BinaryOperator.ANDAND){
                String nextLabel = labelManager.generateNextLabel();
                code.addCode(branch(binaryExpr.getFirstOperand(), nextLabel, falseLabel));
                code.addCode(emitter.emitLabel(nextLabel));
                code.addCode(branch(binaryExpr.getSecondOperand(), trueLabel, falseLabel));
                return code;
            }
            else if(binaryExpr.getOperator() == BinaryOperator.OROR) {
                String nextLabel = labelManager.generateNextLabel();
                code.addCode(branch(binaryExpr.getFirstOperand(), trueLabel, nextLabel));
                code.addCode(emitter.emitLabel(nextLabel));
                code.addCode(branch(binaryExpr.getSecondOperand(), trueLabel, falseLabel));
                return code;
            }
            else if(binaryExpr.getOperator().isCompare()){
                if (binaryExpr.getFirstOperand() instanceof IntVal intVal){
                    CodeObject right = binaryExpr.getSecondOperand().accept(this);
                    String resultVar = right.getResultVar();
                    Register rightReg = getRegisterForRead(code, resultVar);
                    code.addCode(emitter.CMI(intVal.getInt(), rightReg));
                    code.addCode(emitter.BRR(binaryExpr.getOperator().getSymbol(), trueLabel));

                    if(nameManager.isTmp(resultVar)) registerManager.freeRegister(resultVar);
                }
                else if(binaryExpr.getSecondOperand() instanceof IntVal intVal){
                    CodeObject left = binaryExpr.getFirstOperand().accept(this);
                    String resultVar = left.getResultVar();
                    Register leftReg = getRegisterForRead(code, resultVar);
                    code.addCode(emitter.CMI(intVal.getInt(), leftReg));
                    code.addCode(emitter.BRR(binaryExpr.getOperator().flip().getSymbol(), trueLabel));

                    if(nameManager.isTmp(resultVar)) registerManager.freeRegister(resultVar);
                }
                else{
                    CodeObject left = binaryExpr.getFirstOperand().accept(this);
                    CodeObject right = binaryExpr.getSecondOperand().accept(this);
                    String leftVar = left.getResultVar();
                    String rightVar = right.getResultVar();
                    Register leftReg = getRegisterForRead(code, leftVar);
                    leftReg.lock();
                    Register rightReg = getRegisterForRead(code, rightVar);
                    leftReg.unlock();
                    code.addCode(emitter.CMR(leftReg, rightReg));
                    code.addCode(emitter.BRR(binaryExpr.getOperator().getSymbol(), trueLabel));

                    if(nameManager.isTmp(leftVar)) registerManager.freeRegister(leftVar);
                    if(nameManager.isTmp(rightVar)) registerManager.freeRegister(rightVar);
                }

                code.addCode(emitter.JMP(falseLabel));
                return code;
            }
        }
        //base case where it reaches other expressions:
        CodeObject resultCode = expr.accept(this);
        code.addCode(resultCode);
        String resultVar = resultCode.getResultVar();
        Register resultReg = getRegisterForRead(code, resultVar);
        code.addCode(emitter.CMI(0,resultReg));
        code.addCode(emitter.BRR("!=", trueLabel));
        code.addCode(emitter.JMP(falseLabel));
        return code;
    }

    public CodeObject visit(SelectionStatement selectionStatement) {
        CodeObject code= new CodeObject();
        String ifLabel = labelManager.generateIfLabel();
        String elseLabel = labelManager.generateElseLabel();
        String afterIfLabel = labelManager.generateAfterIfLabel();


        code.addCode(branch(selectionStatement.getCondition(), ifLabel,selectionStatement.getElseStatement() != null? elseLabel: afterIfLabel));

        code.addCode(emitter.emitLabel(ifLabel));
        code.addCode(selectionStatement.getIfStatement().accept(this));
        code.addCode(emitter.JMP(afterIfLabel));


        if (selectionStatement.getElseStatement() != null) {
            code.addCode(emitter.emitLabel(elseLabel));
            code.addCode(selectionStatement.getElseStatement().accept(this));
        }
        code.addCode(emitter.emitLabel(afterIfLabel));
        return code;
    }
    public CodeObject visit(UnaryExpr unaryExpr) {
        CodeObject code = new CodeObject();
        UnaryOperator op = unaryExpr.getOperator();

        if(op == UnaryOperator.NOT ){
            String trueLabel = labelManager.generateTrueLabel();
            String falseLabel = labelManager.generateFalseLabel();
            String endLabel = labelManager.generateEndLabel();
            code.addCode(branch(unaryExpr, trueLabel, falseLabel));

            String destVar = nameManager.newTmpVarName();
            Register destReg = getRegisterForWrite(code, destVar);

            code.setResultVar(destVar);
            code.addCode(emitter.emitLabel(trueLabel));
            code.addCode(emitter.MSI(1, destReg));
            code.addCode(emitter.JMP(endLabel));
            code.addCode(emitter.emitLabel(falseLabel));
            code.addCode(emitter.MSI(0, destReg));
            code.addCode(emitter.emitLabel(endLabel));
            return code;
        }

        CodeObject operandCode = unaryExpr.getOperand().accept(this);
        String operandVar = operandCode.getResultVar();
        Register operandReg = getRegisterForRead(code, operandVar);
        operandReg.lock();
        code.addCode(operandCode);

        String address = null;
        boolean isArray = false;
        if(unaryExpr.getOperand() instanceof ArrayExpr) {
            isArray = true;
            address = operandCode.getAddress();
        }

        String destVar;
        Register destReg;



        switch (op) {
            case UnaryOperator.PRE_INC:
                code.addCode(emitter.ADI(1 , operandReg));
                code.addCode(ArrayStore(operandReg, address, isArray));
                code.setResultVar(operandVar);
                break;

            case UnaryOperator.PRE_DEC:
                code.addCode(emitter.SUI(1 , operandReg));
                code.addCode(ArrayStore(operandReg, address, isArray));
                code.setResultVar(operandVar);
                break;

            case UnaryOperator.POST_INC:
                destVar = nameManager.newTmpVarName();
                destReg = this.getRegisterForWrite(code, destVar);
                destReg.lock();

                code.addCode(emitter.ADR(ZR, operandReg, destReg));
                code.addCode(emitter.ADI(1 , operandReg));
                code.addCode(ArrayStore(operandReg, address, isArray));
                destReg.unlock();
                code.setResultVar(destVar);
                break;

            case UnaryOperator.POST_DEC:
                destVar = nameManager.newTmpVarName();
                destReg = this.getRegisterForWrite(code, destVar);
                destReg.lock();
                code.addCode(emitter.ADR(ZR, operandReg, destReg));
                code.addCode(emitter.SUI(1 , operandReg));

                code.addCode(ArrayStore(operandReg, address, isArray));
                destReg.unlock();
                code.setResultVar(destVar);
                break;

            case UnaryOperator.TILDE:
                destVar = nameManager.newTmpVarName();
                destReg = this.getRegisterForWrite(code, destVar);

                code.addCode(emitter.NTR( operandReg, destReg));
                code.setResultVar(destVar);
                if(nameManager.isTmp(operandVar)){
                    registerManager.freeRegister(operandVar);
                }
                break;

            case UnaryOperator.MINUS:
                destVar = nameManager.newTmpVarName();
                destReg = this.getRegisterForWrite(code, destVar);

                code.addCode(emitter.NTR2( operandReg, destReg));
                code.setResultVar(destVar);
                if(nameManager.isTmp(operandVar)){
                    registerManager.freeRegister(operandVar);
                }
                break;
            case UnaryOperator.AND:
                throw new RuntimeException("Pointers Unsupported");
//                if(memoryManager.isGlobal(operandVar)){
//                    code.setResultVar(String.valueOf((memoryManager.getGlobalAddress(operandVar))));
//                }else {
//                    destVar = nameManager.newTmpVarName();
//                    destReg = this.getRegisterForWrite(code, destVar);
//
//                    List<RegisterAction> actions = new ArrayList<>();
//                    List<Register> spillRegs = new ArrayList<>();
//                    spillRegs.add(operandReg);
//
//                    registerManager.handleSpill(null, spillRegs, actions);
//                    this.generateRegActionCode(actions, code);
//                    code.addCode(emitter.MSI(memoryManager.getLocalOffset(operandVar), destReg));
//
//                    code.setResultVar(destVar);
//
//                    if(nameManager.isTmp(operandVar)){
//                        registerManager.freeRegister(operandVar);
//                    }
//                }
//                break;
            case UnaryOperator.STAR:
                throw new RuntimeException("Pointers Unsupported");
//                String offsetVar;
//                Register offsetReg;
//                destVar = nameManager.newTmpVarName();
//                destReg = this.getRegisterForWrite(code, destVar);
//
//                offsetVar = nameManager.newTmpVarName();
//                offsetReg = this.getRegisterForWrite(code, offsetVar);
//                code.addCode(emitter.MSI(memoryManager.getLocalOffset(operandVar), offsetReg));
//
//                code.addCode(emitter.LDR(destReg, offsetReg));
//                code.setResultVar(destVar);
//                if(nameManager.isTmp(operandVar)){
//                    registerManager.freeRegister(operandVar);
//                }
//                registerManager.freeRegister(offsetVar);

        }
        operandReg.unlock();

        return code;
    }

    private String resolveDesVar(List<String> needFree){
        if(needFree.isEmpty()){
            return nameManager.newTmpVarName();
        }
        return needFree.removeFirst();
    }
    public CodeObject visit(BinaryExpr binaryExpr) {
        CodeObject code = new CodeObject();
        BinaryOperator op = binaryExpr.getOperator();

        if(op == BinaryOperator.ANDAND || op==BinaryOperator.OROR || op.isCompare()){

            String trueLabel = labelManager.generateTrueLabel();
            String falseLabel = labelManager.generateFalseLabel();
            String endLabel = labelManager.generateEndLabel();
            code.addCode(branch(binaryExpr, trueLabel, falseLabel));

            String destVar = nameManager.newTmpVarName();
            Register destReg = getRegisterForWrite(code, destVar);
            code.setResultVar(destVar);
            code.addCode(emitter.emitLabel(trueLabel));
            code.addCode(emitter.MSI(1, destReg));
            code.addCode(emitter.JMP(endLabel));
            code.addCode(emitter.emitLabel(falseLabel));
            code.addCode(emitter.MSI(0, destReg));
            code.addCode(emitter.emitLabel(endLabel));

            return code;
        }

        CodeObject operand1Code = binaryExpr.getFirstOperand().accept(this);
        code.addCode(operand1Code);

        String address = null;
        boolean isArray = false;
        if(binaryExpr.getFirstOperand() instanceof ArrayExpr) {
            isArray = true;
            address = operand1Code.getAddress();
        }

        CodeObject operand2Code = binaryExpr.getSecondOperand().accept(this);
        code.addCode(operand2Code);

        String operand1 = operand1Code.getResultVar();
        String operand2 = operand2Code.getResultVar();
        String helperVar = null;
        Register helperReg = null;

        Register operand1reg, operand2reg;
        List<String> needFree = new ArrayList<>();
        if(op == BinaryOperator.DIVASSIGN || op==BinaryOperator.STARASSIGN) {
            helperVar = nameManager.newTmpVarName();
            operand1reg = getRegisterForRead(code, operand1, helperVar);
            helperReg = registerManager.getNextReg(operand1reg);
            helperReg.lock();
            needFree.add(helperVar);
        }
        else if (op==BinaryOperator.MODASSIGN) {
            helperVar = nameManager.newTmpVarName();
            helperReg = getRegisterForRead(code, helperVar, operand1);
            operand1reg = registerManager.getNextReg(helperReg);
            helperReg.lock();
            needFree.add(helperVar);
        }
        else {
            operand1reg = getRegisterForRead(code, operand1);
        }
        operand1reg.lock();
        operand2reg = getRegisterForRead(code, operand2);
        operand2reg.lock();

        if(nameManager.isTmp(operand1)) needFree.add(operand1);
        if(nameManager.isTmp(operand2)) needFree.add(operand2);


        switch (op) {
            case BinaryOperator.PLUS: {
                String destVar = resolveDesVar(needFree);
                Register destReg = getRegisterForWrite(code, destVar);
                code.addCode(emitter.ADR(operand1reg, operand2reg, destReg));
                code.setResultVar(destVar);
                break;
            }
            case BinaryOperator.MINUS: {
                String destVar = resolveDesVar(needFree);
                Register destReg = getRegisterForWrite(code, destVar);
                code.addCode(emitter.SUR(operand1reg, operand2reg, destReg));
                code.setResultVar(destVar);
                break;
            }
            case BinaryOperator.MULT: {
                //Todo: try to use one of the temp registers of operands if possible for these three op
                String destVar = nameManager.newTmpVarName();
                String destVar2 = nameManager.newTmpVarName();
                Register destReg = getRegisterForWrite(code, destVar, destVar2);

                code.addCode(emitter.MUL(operand2reg, operand1reg, destReg));
                needFree.add(destVar2);
                code.setResultVar(destVar);
                break;
            }
            case BinaryOperator.DIVIDE: {
                String destVar = nameManager.newTmpVarName();
                String destVar2 = nameManager.newTmpVarName();
                Register destReg = getRegisterForWrite(code, destVar, destVar2);
                code.addCode(emitter.DIV(operand1reg, operand2reg, destReg));
                needFree.add(destVar2);
                code.setResultVar(destVar);
                break;
            }
            case BinaryOperator.MOD: {
                String destVar = nameManager.newTmpVarName();
                String destVar2 = nameManager.newTmpVarName();
                Register destReg = getRegisterForWrite(code, destVar, destVar2);
                code.addCode(emitter.DIV(operand1reg, operand2reg, destReg));
                needFree.add(destVar);
                code.setResultVar(destVar2);
                break;
            }
            case BinaryOperator.LEFTSHIFT: {
                String destVar = resolveDesVar(needFree);
                Register destReg = getRegisterForWrite(code, destVar);
                code.addCode(emitter.NTR2(operand2reg, destReg));
                code.addCode(emitter.SAR(destReg, operand1reg, destReg));
                code.setResultVar(destVar);
                break;
            }
            case BinaryOperator.RIGHTSHIFT: {
                String destVar = resolveDesVar(needFree);
                Register destReg = getRegisterForWrite(code, destVar);
                code.addCode(emitter.SAR(operand2reg, destReg, operand1reg));
                code.setResultVar(destVar);
                break;
            }
            case BinaryOperator.AND:{
                String destVar = resolveDesVar(needFree);
                Register destReg = getRegisterForWrite(code, destVar);
                code.addCode(emitter.ANR(operand1reg, operand2reg, destReg));
                code.setResultVar(destVar);
                break;
            }
            case BinaryOperator.XOR: {
                String destVar = nameManager.newTmpVarName();
                Register destReg = getRegisterForWrite(code, destVar);
                destReg.lock();
                String tmpVar = nameManager.newTmpVarName();
                Register tmpReg = getRegisterForWrite(code, tmpVar);
                code.addCode(emitter.NTR(operand1reg, tmpReg));
                code.addCode(emitter.NTR(operand2reg, destReg));
                code.addCode(emitter.ANR(tmpReg, destReg, tmpReg));
                code.addCode(emitter.NTR(tmpReg, tmpReg));
                code.addCode(emitter.ANR(operand1reg, operand2reg, destReg));
                code.addCode(emitter.NTR(destReg, destReg));
                code.addCode(emitter.ANR(tmpReg, destReg, destReg));
                code.setResultVar(destVar);
                needFree.add(tmpVar);
                destReg.unlock();
                break;
            }
            case BinaryOperator.OR: {
                String destVar = resolveDesVar(needFree);
                Register destReg = getRegisterForWrite(code, destVar);
                destReg.lock();
                String tmpVar = resolveDesVar(needFree);
                Register tmpReg = getRegisterForWrite(code, tmpVar);
                code.addCode(emitter.NTR(operand1reg, tmpReg));
                code.addCode(emitter.NTR(operand2reg, destReg));
                code.addCode(emitter.ANR(tmpReg, destReg, destReg));
                code.addCode(emitter.NTR(destReg, destReg));
                code.setResultVar(destVar);
                destReg.unlock();
                break;
            }
            case BinaryOperator.ASSIGN: {
                if(nameManager.isTmp(operand2)){
                    registerManager.freeRegister(operand2);
                    registerManager.assignRegister(operand2reg, operand1);
                } else {
                    code.addCode(emitter.ADR(ZR, operand2reg, operand1reg));
                }
                code.addCode(ArrayStore(operand1reg, address, isArray));
                needFree.remove(operand1);
                code.setResultVar(operand1);
                break;
            }
            case BinaryOperator.ANDASSIGN:{
                code.addCode(emitter.ANR(operand1reg, operand2reg, operand1reg));
                code.addCode(ArrayStore(operand1reg, address, isArray));
                needFree.remove(operand1);
                code.setResultVar(operand1);
                break;
            }
            case BinaryOperator.DIVASSIGN: {
                code.addCode(emitter.DIV(operand1reg, operand2reg, operand1reg));
                code.addCode(ArrayStore(operand1reg, address, isArray));
                needFree.remove(operand1);
                code.setResultVar(operand1);
                break;
            }
            case BinaryOperator.LEFTSHIFTASSIGN: {
                needFree.remove(operand1);
                String tmpVar = resolveDesVar(needFree);
                Register tmpReg = getRegisterForWrite(code, tmpVar);
                tmpReg.lock();
                code.addCode(emitter.NTR2(operand2reg, tmpReg));
                code.addCode(emitter.SAR(tmpReg, operand1reg, operand1reg));
                code.addCode(ArrayStore(operand1reg, address, isArray));
                tmpReg.unlock();
                needFree.add(tmpVar);
                code.setResultVar(operand1);
                break;
            }
            case BinaryOperator.RIGHTSHIFTASSIGN: {
                code.addCode(emitter.SAR(operand2reg, operand1reg, operand1reg));
                code.addCode(ArrayStore(operand1reg, address, isArray));
                needFree.remove(operand1);
                code.setResultVar(operand1);
                break;
            }
            case BinaryOperator.MINUSASSIGN: {
                code.addCode(emitter.SUR(operand1reg, operand2reg, operand1reg));
                code.addCode(ArrayStore(operand1reg, address, isArray));
                needFree.remove(operand1);
                code.setResultVar(operand1);
                break;
            }
            case BinaryOperator.PLUSASSIGN: {
                code.addCode(emitter.ADR(operand1reg, operand2reg, operand1reg));
                code.addCode(ArrayStore(operand1reg, address, isArray));
                needFree.remove(operand1);
                code.setResultVar(operand1);
                break;
            }
            case BinaryOperator.STARASSIGN: {
                code.addCode(emitter.MUL(operand2reg, operand1reg, operand1reg));
                code.addCode(ArrayStore(operand1reg, address, isArray));
                needFree.remove(operand1);
                code.setResultVar(operand1);
                break;
            }
            case BinaryOperator.ORASSIGN: {
                needFree.remove(operand1);
                String tmpVar = resolveDesVar(needFree);
                Register tmpReg = getRegisterForWrite(code, tmpVar);
                tmpReg.lock();
                code.addCode(emitter.NTR(operand1reg, operand1reg));
                code.addCode(emitter.NTR(operand2reg, tmpReg));
                code.addCode(emitter.ANR(tmpReg, operand1reg, operand1reg));
                code.addCode(emitter.NTR(operand1reg, operand1reg));
                code.addCode(ArrayStore(operand1reg, address, isArray));
                tmpReg.unlock();
                code.setResultVar(operand1);
                break;
            }
            case BinaryOperator.XORASSIGN: {
                needFree.remove(operand1);
                String tmpVar = nameManager.newTmpVarName();
                Register tmpReg = getRegisterForWrite(code, tmpVar);
                tmpReg.lock();
                String tmp2Var = resolveDesVar(needFree);
                Register tmp2Reg = getRegisterForWrite(code, tmp2Var);
                tmp2Reg.lock();
                code.addCode(emitter.ANR(operand1reg, operand2reg, tmpReg));
                code.addCode(emitter.NTR(tmpReg, tmpReg));
                code.addCode(emitter.NTR(operand1reg, operand1reg));
                code.addCode(emitter.NTR(operand2reg, tmp2Reg));
                code.addCode(emitter.ANR(tmp2Reg, operand1reg, operand1reg));
                code.addCode(emitter.NTR(operand1reg, operand1reg));
                code.addCode(emitter.ANR(operand1reg, tmpReg, operand1reg));
                code.addCode(ArrayStore(operand1reg, address, isArray));
                tmpReg.unlock();
                tmp2Reg.unlock();
                code.setResultVar(operand1);
                needFree.add(tmpVar);
                needFree.add(tmp2Var);
                break;
            }
            case BinaryOperator.MODASSIGN: {
                code.addCode(emitter.DIV(operand1reg, operand2reg, helperReg));
                code.addCode(ArrayStore(operand1reg, address, isArray));
                needFree.remove(operand1);
                code.setResultVar(operand1);
                break;
            }
        }

        operand1reg.unlock();
        operand2reg.unlock();
        if(helperReg != null)
            helperReg.unlock();

        for(String tmpVar: needFree){
            registerManager.freeRegister(tmpVar);
        }

        return code;
    }

    public CodeObject visit(Identifier identifier) {
        CodeObject code = new CodeObject();
        code.setResultVar(identifier.getSpecialName());
        return code;
    }

    public CodeObject visit(IntVal intVal) {
        CodeObject code = new CodeObject();
        String destRegVar = nameManager.newTmpVarName();
        Register destReg = this.getRegisterForWrite(code, destRegVar);
        int val = intVal.getInt();
        code.addCode(emitter.MSI(val, destReg));
        code.setResultVar(destRegVar);

        return code;
    }

}

