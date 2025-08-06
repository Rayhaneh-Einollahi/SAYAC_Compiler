package main.codeGenerator;

import main.ast.nodes.Statement.IterationStatement.ForStatement;
import main.ast.nodes.Statement.IterationStatement.WhileStatement;
import main.ast.nodes.Statement.JumpStatement.BreakStatement;
import main.ast.nodes.Statement.JumpStatement.ContinueStatement;
import main.ast.nodes.Statement.JumpStatement.JumpStatement;
import main.ast.nodes.Statement.JumpStatement.ReturnStatement;
import main.ast.nodes.Statement.SelectionStatement;
import main.ast.nodes.declaration.Declaration;
import main.ast.nodes.declaration.Declarator;
import main.ast.nodes.declaration.FunctionDefinition;
import main.ast.nodes.declaration.InitDeclarator;
import main.ast.nodes.expr.*;
import main.ast.nodes.expr.operator.BinaryOperator;
import main.ast.nodes.expr.operator.UnaryOperator;
import main.ast.nodes.expr.primitives.ConstantExpr;
import main.ast.nodes.expr.primitives.IntVal;
import main.visitor.IVisitor;
import main.visitor.Visitor;

import java.util.*;

public class CodeGenerator extends Visitor<CodeObject> {
    private boolean insideFunction = false;
    public final RegisterManager registerManager;
    public final MemoryManager memoryManager;
    public final InstructionEmitter emitter;
    public final LabelManager labelManager;
    private final Deque<String> loopEndLabels = new ArrayDeque<>();
    private final Deque<String> loopContinueLabels = new ArrayDeque<>();
    private String currentFunctionEndLabel;

    public CodeGenerator() {
        memoryManager = new MemoryManager();
        registerManager = new RegisterManager(memoryManager);
        emitter = new InstructionEmitter();
        labelManager = new LabelManager();
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
    private String getRegisterForRead(String varName, CodeObject code){
        List<RegisterAction> actions = new ArrayList<>();
        String reg = registerManager.allocateForRead(varName, actions);

        for (RegisterAction action : actions) {
            switch (action.type) {
                case SPILL -> code.addCode(emitter.SW(action.register,"FP",action.offset));
                case LOAD  -> code.addCode(emitter.LW(action.register,"FP",action.offset));
            }
        }
        return reg;
    }

    private String getRegisterForWrite(String varName, CodeObject code){
        List<RegisterAction> actions = new ArrayList<>();
        String reg = registerManager.allocateForWrite(varName, actions);

        for (RegisterAction action : actions) {
            switch (action.type) {
                case SPILL -> code.addCode(emitter.SW(action.register,"FP",action.offset));
                case LOAD  -> code.addCode(emitter.LW(action.register,"FP",action.offset));
            }
        }
        return reg;
    }



    public CodeObject visit(Declaration declaration) {


            for (InitDeclarator initDeclarator : declaration.getInitDeclarators()) {
                String varName = initDeclarator.getDeclarator().getName();
                String initValue = "0";
//                System.out.println(varName);
                if (initDeclarator.getInitializer() != null && initDeclarator.getInitializer().getExpr() != null) {
                    Expr expr = initDeclarator.getInitializer().getExpr();
                    if (expr instanceof ConstantExpr constantExpr) {
                        initValue = constantExpr.getStr();
                    }
                }

                if (!insideFunction) {
                    this.emitter.emitRaw(".data");
                    this.emitter.emitRaw(varName + ": .word " + initValue);
                    this.emitter.emitRaw(".text");
                } else {
//                    this.memoryManager.beginFrame(); entering main function
                    if (initValue != null) {
                        int offset = this.memoryManager.allocateLocal(varName, 4);
                        int reg = this.registerManager.allocate();
                        int reg2 = this.registerManager.allocate();
                        this.emitter.emit("MSI", this.registerManager.regName(reg), initValue);
                        this.emitter.emit("MSI", this.registerManager.regName(reg2), "1000");

                        this.emitter.emit("ADI", this.registerManager.regName(reg2), this.memoryManager.stackAccess(-4));

                        this.emitter.emit("STR", this.registerManager.regName(reg2), this.registerManager.regName(reg));
                        this.registerManager.free(reg);
                        this.registerManager.free(reg2);
                    }
                }
            }

            this.emitter.printCode();

            return null;
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
    ///     |  return val  | <- top of stack would be the return value
    ///     |  ...         |
    ///     |  locals      |
    ///     |  old fp      | <- new fp pointing here
    ///     |  reg 11(ra)  |
    ///     |  ...         |
    ///     |  reg 2       |
    ///     |  reg 1       |
    ///     |  arg n       |
    ///     |  ... .       |
    ///     |  arg2        |
    ///     |  arg1        |
    /// </pre>
    /// @param functionDefinition : function definition node
    @Override
    public CodeObject visit(FunctionDefinition functionDefinition) {
        CodeObject code = new CodeObject();
        List<String> usableRegisters = registerManager.getAllRegisters();    //Todo:[option 1(naive approach)] get all the
                                                                             // registers except the ones in use like
                                                                             // fp, sp, r0
                                                                             // [option 2] get the code generated for this part
                                                                             // and save only the registers used in this func
                                                                             //
        for (String reg : usableRegisters) {
            code.addCode(emitter.STR( reg, "sp"));
            code.addCode(emitter.ADI( -2, "sp"));
        }
        registerManager.clearRegisters();

        code.addCode(emitter.emitLabel(labelManager.generateFunctionLabel(functionDefinition.getName())));
        code.addCode(emitter.STR("fp", "sp"));
        code.addCode(emitter.ADR("r0", "sp", "fp"));
        code.addCode(emitter.ADI(-2, "sp"));

        List<Declaration> args = functionDefinition.getArgDeclarations();
        for(int i = 0; i < args.size(); i++){
            Declaration arg = args.get(i);
            memoryManager.setFunctionArgOffset(arg.getName(), usableRegisters.size() + args.size() - i);
        }
        memoryManager.beginFunction();
        currentFunctionEndLabel = labelManager.generateFunctionReturnLabel(functionDefinition.getName());

        //----------------------------------------------
        if (functionDefinition.getDeclarations() != null){
            for (Declaration ds: functionDefinition.getDeclarations()){
                ds.accept(this);
            }
        }
        if (functionDefinition.getBody() != null){
            code.addCode(functionDefinition.getBody().accept(this));
        }
        //--------------------------------------------------

        code.addCode(emitter.emitLabel(currentFunctionEndLabel));


        code.addCode(emitter.ADR("r0","fp", "sp"));
        code.addCode(emitter.LDR("fp", "fp"));
        for (int i = usableRegisters.size() - 1; i >= 0; i--) {
            String reg = usableRegisters.get(i);
            code.addCode(emitter.ADI( 2, "sp"));
            code.addCode(emitter.LDR("sp", reg));
        }

        code.addCode(emitter.ADI(args.size(), "sp"));
        code.addCode(emitter.JMR("ra"));


        return code;
    }

    @Override
    public CodeObject visit(ReturnStatement returnStatement) {
        CodeObject code = new CodeObject();
        if(returnStatement.getExpr() != null) {
            CodeObject retStCode = returnStatement.getExpr().accept(this);
            code.addCode(retStCode);
            String regResult =  getRegisterForRead(retStCode.getResultVar(), code);
            code.addCode(emitter.ADR("r0", regResult, "ret"));
        }
        code.addCode(emitter.JMP(currentFunctionEndLabel));
        return code;
    }

    @Override
    public CodeObject visit(FunctionExpr functionExpr) {
        CodeObject code = new CodeObject();

        List<Expr> arguments = functionExpr.getArguments();
        List<Integer> tempOffsets = new ArrayList<>();
        for (int i = 0; i< arguments.size(); i++) {
            Expr arg = arguments.get(i);
            CodeObject argCode = arg.accept(this);
            code.addCode(argCode);

            String resultVar = argCode.getResultVar();
            if (resultVar == null)
                throw new RuntimeException("Missing result register for argument");

            int offset = memoryManager.allocateLocal(".arg_"+ i,2);
            tempOffsets.add(offset);

            code.addCode(emitter.SW(resultVar, "fp", offset));
        }


        for (int offset : tempOffsets) {
            String tmpName = registerManager.newTmpVarName();
            String tmpReg = getRegisterForWrite(tmpName, code);
            code.addCode(emitter.LW(tmpReg, "fp", offset));

            code.addCode(emitter.STR(tmpReg, "sp"));
            code.addCode(emitter.ADI(-2, "sp"));
        }

        String funcLabel = labelManager.generateFunctionLabel(functionExpr.getName());
        code.addCode(emitter.JMPS(funcLabel, "ra"));
        code.addCode(emitter.ADI(2 * tempOffsets.size(), "sp"));
//        code.setResultReg("ra");

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
            if(unaryexpr.getOperator() == UnaryOperator.NOT)
                code.addCode(branch(unaryexpr.getOperand(), falseLabel, trueLabel));
            else
                code.addCode(expr.accept(this));
        }
        else if(expr instanceof BinaryExpr binaryExpr) {
            if(binaryExpr.getOperator() == BinaryOperator.ANDAND){
                String nextLabel = labelManager.generateNextLabel();
                code.addCode(branch(binaryExpr.getFirstOperand(), nextLabel, falseLabel));
                code.addCode(branch(binaryExpr.getSecondOperand(), trueLabel, falseLabel));
            }
            else if(binaryExpr.getOperator() == BinaryOperator.OROR) {
                String nextLabel = labelManager.generateNextLabel();
                code.addCode(branch(binaryExpr.getFirstOperand(), trueLabel, nextLabel));
                code.addCode(branch(binaryExpr.getSecondOperand(), trueLabel, falseLabel));
            }
            else if(binaryExpr.getOperator().isCompare()){
                if (binaryExpr.getFirstOperand() instanceof IntVal intVal){
                    CodeObject right = binaryExpr.getSecondOperand().accept(this);
                    String rightReg = getRegisterForRead(right.getResultVar(), code);
                    code.addCode(emitter.CMI(intVal.getInt(), rightReg));
                    code.addCode(emitter.BRR(binaryExpr.getOperator().getSymbol(), trueLabel));
                }
                else if(binaryExpr.getSecondOperand() instanceof IntVal intVal){
                    CodeObject left = binaryExpr.getFirstOperand().accept(this);
                    String leftReg = getRegisterForRead(left.getResultVar(), code);
                    code.addCode(emitter.CMI(intVal.getInt(), leftReg));
                    code.addCode(emitter.BRR(binaryExpr.getOperator().flip().getSymbol(), trueLabel));
                }
                else{
                    CodeObject left = binaryExpr.getFirstOperand().accept(this);
                    CodeObject right = binaryExpr.getSecondOperand().accept(this);
                    String leftReg = getRegisterForRead(left.getResultVar(), code);
                    String rightReg = getRegisterForRead(right.getResultVar(), code);
                    code.addCode(emitter.CMR(leftReg, rightReg));
                    code.addCode(emitter.BRR(binaryExpr.getOperator().getSymbol(), trueLabel));
                }
                
                code.addCode(emitter.JMP(falseLabel));
                
            }
        }
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
        return null;
    }
    public CodeObject visit(UnaryExpr unaryExpr) {
        CodeObject code = new CodeObject();
        UnaryOperator op = unaryExpr.getOperator();

        CodeObject operandCode = unaryExpr.getOperand().accept(this);

        if (operandCode != null){
            code.addCode(operandCode);
        }

        String operand = (unaryExpr.getOperand() != null) ? unaryExpr.getOperand().getName() : "";

        String operandReg = (operand != "") ? this.getRegisterForRead(operand) : "";

        String destRegName = registerManager.newTmpVarName();
        String destReg = this.getRegisterForWrite(destRegName);
        String label = "";
        String zeroName = registerManager.newTmpVarName();
        String zeroReg = this.getRegisterForWrite(zeroName);
        switch (op) {
            case UnaryOperator.PRE_INC:
                code.addCode(emitter.MSI("0", zeroReg));
                code.addCode(emitter.ADI(1 , operandReg));
                code.addCode(emitter.ADR(zeroReg, operandReg, destReg));
                this.registerManager.freeRegister(zeroReg);

                code.setResultVar(destRegName);
                break;
            case UnaryOperator.POST_INC:
                code.addCode(emitter.MSI("0", zeroReg));
                code.addCode(emitter.ADR(zeroReg, operandReg, destReg));
                code.addCode(emitter.ADI(1 , operandReg));
                this.registerManager.freeRegister(zeroReg);
                code.setResultVar(destRegName);
                break;
            case UnaryOperator.PRE_DEC:
                code.addCode(emitter.MSI("0", zeroReg));
                code.addCode(emitter.SUI(1 , operandReg));
                code.addCode(emitter.ADR(zeroReg, operandReg, destReg));
                this.registerManager.freeRegister(zeroReg);

                code.setResultVar(destRegName);
                break;
            case UnaryOperator.POST_DEC:
                code.addCode(emitter.MSI("0", zeroReg));
                code.addCode(emitter.ADR(zeroReg, operandReg, destReg));
                code.addCode(emitter.SUI(1 , operandReg));
                this.registerManager.freeRegister(zeroReg);
                code.setResultVar(destRegName);
                break;
            //bepors az bache ha
            case UnaryOperator.NOT:
                code.addCode(emitter.NTR(destReg, operandReg));
                code.setResultVar(destRegName);
                break;
            case UnaryOperator.MINUS:
                code.addCode(emitter.NTR(destReg, operandReg));
                code.setResultVar(destRegName);
                break;
            case UnaryOperator.TILDE:
                code.addCode(emitter.NTR(destReg, operandReg));
                code.setResultVar(destRegName);
                break;
        }
        //inja free konam??
        return null;
    }

    public CodeObject visit(BinaryExpr binaryExpr) {
        CodeObject code = new CodeObject();
        BinaryOperator op = binaryExpr.getOperator();

        CodeObject firstOperandCode = binaryExpr.getFirstOperand().accept(this);
        if (firstOperandCode != null){
            code.addCode(firstOperandCode);
        }

        CodeObject secondOperandCode = binaryExpr.getSecondOperand().accept(this);

        if (secondOperandCode != null){
            code.addCode(secondOperandCode);
        }



        String firstOperand = (binaryExpr.getFirstOperand() != null) ? binaryExpr.getFirstOperand().getName() : "";
        String secondOperand = (binaryExpr.getSecondOperand() != null) ? binaryExpr.getSecondOperand().getName() : "";

        String firstOperandReg = (firstOperand != "") ? this.getRegisterForRead(firstOperand) : "";
        String secondOperandReg = (secondOperand != "") ? this.getRegisterForRead(secondOperand) : "";
        System.out.println(secondOperand);
        System.out.println(secondOperandReg);

        String destRegName = registerManager.newTmpVarName();
        String destReg = this.getRegisterForWrite(destRegName);
        String trueLabel = "";
        String falseLabel = "";
        String endLabel = "";
        String zeroName = registerManager.newTmpVarName();
        String zeroReg = this.getRegisterForWrite(zeroName);
        switch (op) {
            case BinaryOperator.AND:
                code.addCode(emitter.ANR(firstOperandReg, secondOperandReg,destReg));
                code.setResultVar(destRegName);
                break;
            case  BinaryOperator.ANDASSIGN:
                code.addCode(emitter.ANR(firstOperandReg, secondOperandReg,firstOperandReg));
                code.setResultVar(destRegName);
                break;
            case BinaryOperator.ANDAND:
                //jump
                falseLabel = this.labelManager.generateFalseLabel();
                endLabel = this.labelManager.generateEndLabel();
                code.addCode(emitter.CMI("0",firstOperandReg));
                code.addCode(emitter.BRR("==", falseLabel));

                code.addCode(emitter.CMI("0",secondOperandReg));
                code.addCode(emitter.BRR("==", falseLabel));

                code.addCode(emitter.MSI("1", destReg));
                code.setResultVar(destRegName);

                code.addCode(emitter.JMR(endLabel));

                code.addCode(emitter.emitLabel(falseLabel));
                code.addCode(emitter.MSI("1", destReg));

                code.addCode(emitter.emitLabel(endLabel));


            case BinaryOperator.ASSIGN:
                code.addCode(emitter.MSI("0", zeroReg));
                code.addCode(emitter.ADR(zeroReg, secondOperandReg, firstOperandReg));
                code.setResultVar(destRegName);
            case BinaryOperator.DIVIDE:
                code.addCode(emitter.DIV(destReg, firstOperandReg, secondOperandReg));
                System.out.println(destReg);
            case BinaryOperator.DIVASSIGN:
                code.addCode(emitter.DIV(firstOperandReg, firstOperandReg, secondOperandReg));
                System.out.println(firstOperandReg);

            case BinaryOperator.EQUAL:
                trueLabel =  this.labelManager.generateTrueLabel();
                endLabel = this.labelManager.generateEndLabel();

                code.addCode(emitter.CMR(firstOperandReg, secondOperandReg));
                code.addCode(emitter.BRR("==", trueLabel));
                code.addCode(emitter.MSI("0", destReg));
                code.addCode(emitter.JMR(endLabel));
                code.addCode(emitter.emitLabel(trueLabel));
                code.addCode(emitter.MSI("1", destReg));
                code.addCode(emitter.emitLabel(endLabel));
                code.setResultVar(destRegName);
            case BinaryOperator.NOTEQUAL:
                trueLabel =  this.labelManager.generateTrueLabel();
                endLabel = this.labelManager.generateEndLabel();
                code.addCode(emitter.CMR(firstOperandReg, secondOperandReg));
                code.addCode(emitter.BRR("!=", trueLabel));
                code.addCode(emitter.MSI("0", destReg));
                code.addCode(emitter.JMR(endLabel));
                code.addCode(emitter.emitLabel(trueLabel));
                code.addCode(emitter.MSI("1", destReg));
                code.addCode(emitter.emitLabel(endLabel));

                code.setResultVar(destRegName);
            case BinaryOperator.GREATER:
                trueLabel =  this.labelManager.generateTrueLabel();
                endLabel = this.labelManager.generateEndLabel();
                code.addCode(emitter.CMR(secondOperandReg, firstOperandReg));
                code.addCode(emitter.BRR(">", trueLabel));
                code.addCode(emitter.MSI("0", destReg));
                code.addCode(emitter.JMR(endLabel));
                code.addCode(emitter.emitLabel(trueLabel));
                code.addCode(emitter.MSI("1", destReg));
                code.addCode(emitter.emitLabel(endLabel));

                code.setResultVar(destRegName);
            case BinaryOperator.GREATEREQUAL:
                trueLabel =  this.labelManager.generateTrueLabel();
                endLabel = this.labelManager.generateEndLabel();                code.addCode(emitter.CMR(secondOperandReg, firstOperandReg));
                code.addCode(emitter.BRR(">=", trueLabel));
                code.addCode(emitter.MSI("0", destReg));
                code.addCode(emitter.JMR(endLabel));

                code.addCode(emitter.emitLabel(trueLabel));
                code.addCode(emitter.MSI("1", destReg));
                code.addCode(emitter.emitLabel(endLabel));

                code.setResultVar(destRegName);
            case BinaryOperator.LESS:
                trueLabel =  this.labelManager.generateTrueLabel();
                endLabel = this.labelManager.generateEndLabel();
                code.addCode(emitter.CMR(secondOperandReg, firstOperandReg));
                code.addCode(emitter.BRR("<", trueLabel));
                code.addCode(emitter.MSI("0", destReg));
                code.addCode(emitter.JMR(endLabel));
                code.addCode(emitter.emitLabel(trueLabel));
                code.addCode(emitter.MSI("1", destReg));
                code.addCode(emitter.emitLabel(endLabel));

                code.setResultVar(destRegName);

            case BinaryOperator.LESSEQUAL:
                trueLabel =  this.labelManager.generateTrueLabel();
                endLabel = this.labelManager.generateEndLabel();
                code.addCode(emitter.CMR(secondOperandReg, firstOperandReg));
                code.addCode(emitter.BRR("<=", trueLabel));
                code.addCode(emitter.MSI("0", destReg));
                code.addCode(emitter.JMR(endLabel));

                code.addCode(emitter.emitLabel(trueLabel));
                code.addCode(emitter.MSI("1", destReg));
                code.addCode(emitter.emitLabel(endLabel));

                code.setResultVar(destRegName);

            case BinaryOperator.LEFTSHIFT:
                code.addCode(emitter.SAR(destReg, firstOperandReg , "-" + secondOperandReg));
                code.setResultVar(destRegName);
            case BinaryOperator.LEFTSHIFTASSIGN:
                code.addCode(emitter.SAR(firstOperandReg, firstOperandReg , "-" + secondOperandReg));
                code.setResultVar(destRegName);
            case BinaryOperator.RIGHTSHIFT:
                code.addCode(emitter.SAR(destReg, firstOperandReg , "+" + secondOperandReg));
                code.setResultVar(destRegName);
            case BinaryOperator.RIGHTSHIFTASSIGN:
                code.addCode(emitter.SAR(firstOperandReg, firstOperandReg , "+" + secondOperandReg));
                code.setResultVar(destRegName);
            case BinaryOperator.MINUS:
                code.addCode(emitter.SUR(firstOperandReg, secondOperandReg,destReg));
                code.setResultVar(destRegName);
            case BinaryOperator.MINUSASSIGN:
                code.addCode(emitter.SUR(firstOperandReg, secondOperandReg,firstOperandReg));
                code.setResultVar(destRegName);
            case BinaryOperator.PLUS:
                code.addCode(emitter.ADR(firstOperandReg, secondOperandReg,destReg));
                code.setResultVar(destRegName);
            case BinaryOperator.PLUSASSIGN:
                code.addCode(emitter.ADR(firstOperandReg, secondOperandReg,firstOperandReg));
                code.setResultVar(destRegName);
            case BinaryOperator.MULT:
                //MSB ro chikar konam
                code.addCode(emitter.MUL(destReg, secondOperandReg, firstOperandReg));
                code.setResultVar(destRegName);
            case BinaryOperator.STARASSIGN:
                code.addCode(emitter.MUL(firstOperandReg, secondOperandReg, firstOperandReg));
                code.setResultVar(destRegName);
            case BinaryOperator.OR:
                code.addCode(emitter.NTR(firstOperandReg, firstOperandReg));
                code.addCode(emitter.NTR(secondOperandReg, secondOperandReg));
                code.addCode(emitter.ANR(secondOperandReg, firstOperandReg, destReg));
                code.addCode(emitter.NTR(destReg, destReg));
                code.setResultVar(destRegName);
            case BinaryOperator.ORASSIGN:
                code.addCode(emitter.NTR(firstOperandReg, firstOperandReg));
                code.addCode(emitter.NTR(secondOperandReg, secondOperandReg));
                code.addCode(emitter.ANR(secondOperandReg, firstOperandReg, firstOperandReg));
                code.addCode(emitter.NTR(firstOperandReg, firstOperandReg));
                code.setResultVar(destRegName);
            case BinaryOperator.OROR:
                trueLabel =  this.labelManager.generateTrueLabel();

                endLabel = this.labelManager.generateEndLabel();

                code.addCode(emitter.CMI("1",firstOperandReg));
                code.addCode(emitter.BRR("==", trueLabel));

                code.addCode(emitter.CMI("1",secondOperandReg));
                code.addCode(emitter.BRR("==", trueLabel));

                code.addCode(emitter.MSI("0", destReg));

                //dorosteh?

                code.addCode(emitter.JMR(endLabel));

                code.addCode(emitter.emitLabel(trueLabel));
                code.addCode(emitter.MSI("1", destReg));

                code.addCode(emitter.emitLabel(endLabel));
                code.setResultVar(destRegName);
            case BinaryOperator.XOR:
                String notFirstName = registerManager.newTmpVarName();
                String notFirst = this.getRegisterForWrite(notFirstName);

                String notSecondName = registerManager.newTmpVarName();
                String notSecondReg = this.getRegisterForWrite(notSecondName);

                String temp1Name = registerManager.newTmpVarName();
                String temp1Reg = this.getRegisterForWrite(temp1Name);

                String temp2Name = registerManager.newTmpVarName();
                String temp2Reg = this.getRegisterForWrite(temp2Name);


                code.addCode(emitter.NTR(notFirst, firstOperandReg));
                code.addCode(emitter.NTR(notSecondReg, secondOperandReg));
                code.addCode(emitter.ANR(notFirst, secondOperandReg, temp1Reg));
                code.addCode(emitter.ANR(notSecondReg, firstOperandReg, temp2Reg));

                code.addCode(emitter.NTR(temp1Reg, temp1Reg));
                code.addCode(emitter.NTR(temp2Reg, temp2Reg));
                code.addCode(emitter.ANR(temp2Reg, temp1Reg, destReg));
                code.addCode(emitter.NTR(destReg, destReg));
                code.setResultVar(destRegName);
                this.registerManager.freeRegister(notFirst);
                this.registerManager.freeRegister(notSecondReg);
                this.registerManager.freeRegister(temp1Reg);

                this.registerManager.freeRegister(temp2Reg);



            case BinaryOperator.XORASSIGN:
                String _notFirstName = registerManager.newTmpVarName();
                String _notFirst = this.getRegisterForWrite(_notFirstName);

                String _notSecondName = registerManager.newTmpVarName();
                String _notSecondReg = this.getRegisterForWrite(_notSecondName);

                String _temp1Name = registerManager.newTmpVarName();
                String _temp1Reg = this.getRegisterForWrite(_temp1Name);

                String _temp2Name = registerManager.newTmpVarName();
                String _temp2Reg = this.getRegisterForWrite(_temp2Name);

                code.addCode(emitter.NTR(_notFirst, firstOperandReg));
                code.addCode(emitter.NTR(_notSecondReg, secondOperandReg));
                code.addCode(emitter.ANR(_notFirst, secondOperandReg, _temp1Reg));
                code.addCode(emitter.ANR(_notSecondReg, firstOperandReg, _temp1Reg));

                code.addCode(emitter.NTR(_temp1Reg, _temp1Reg));
                code.addCode(emitter.NTR(_temp2Reg, _temp2Reg));
                code.addCode(emitter.ANR(_temp2Reg, _temp1Reg, firstOperandReg));
                code.addCode(emitter.NTR(firstOperandReg, firstOperandReg));
                code.setResultVar(destRegName);

                this.registerManager.freeRegister(_notFirst);
                this.registerManager.freeRegister(_notSecondReg);
                this.registerManager.freeRegister(_temp1Reg);

                this.registerManager.freeRegister(_temp2Reg);





            case BinaryOperator.MOD:
            case BinaryOperator.MODASSIGN:
        }
        this.registerManager.freeRegister(zeroReg);

        return null;
    }

}