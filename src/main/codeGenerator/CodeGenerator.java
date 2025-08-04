package main.codeGenerator;

import main.ast.nodes.Statement.IterationStatement.ForStatement;
import main.ast.nodes.Statement.IterationStatement.WhileStatement;
import main.ast.nodes.Statement.JumpStatement.BreakStatement;
import main.ast.nodes.Statement.JumpStatement.JumpStatement;
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
    private final Stack<String> loopEndLabels = new Stack<>();

    public CodeGenerator() {
        memoryManager = new MemoryManager();
        registerManager = new RegisterManager(memoryManager);
        emitter = new InstructionEmitter();
        labelManager = new LabelManager();
    }


    /** Register commands:*/
    private String getRegisterForRead(String varName){
        List<RegisterAction> actions = new ArrayList<>();
        String reg = registerManager.allocateForRead(varName, actions);

        for (RegisterAction action : actions) {
            switch (action.type) {
                case SPILL -> emitter.SW(action.register,"FP",action.offset);
                case LOAD  -> emitter.LW(action.register,"FP",action.offset);
            }
        }
        return reg;
    }

    private String getRegisterForWrite(String varName){
        List<RegisterAction> actions = new ArrayList<>();
        String reg = registerManager.allocateForWrite(varName, actions);

        for (RegisterAction action : actions) {
            switch (action.type) {
                case SPILL -> emitter.SW(action.register,"FP",action.offset);
                case LOAD  -> emitter.LW(action.register,"FP",action.offset);
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
    ///     |  reg 11(ra)  |
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
    public CodeObject visit(FunctionDefinition functionDefinition) {
        CodeObject code = new CodeObject();
        code.addCode(emitter.emitLabel(labelManager.generateFunctionLabel(functionDefinition.getName())));
        code.addCode(emitter.STR("fp", "sp"));
        code.addCode(emitter.ADR("r0", "sp", "fp"));
        code.addCode(emitter.ADI(-2, "sp"));
        //Todo (optional): use liveness  analyze to allocate space for locals instead of allocating all:
        code.addCode(emitter.ADI(functionDefinition.getNumLocals() * -2, "sp"));

        List<String> usableRegisters = registerManager.getAllRegisters();    //Todo:[option 1(naive approach)] get all the
                                                                             // registers except the ones in use like
                                                                             // fp, sp, r0
                                                                             // [option 2] get the code generated for this part
                                                                             // and save only the registers used in this func
                                                                             //

        //Todo: set function arguments with corresponding offset in memory manager
        for (String reg : usableRegisters) {
            code.addCode(emitter.STR( reg, "sp"));
            code.addCode(emitter.ADI( -2, "sp"));
        }

        memoryManager.beginFunction();

        //----------------------------------------------
        if (functionDefinition.getDeclarator() != null){
            functionDefinition.getDeclarator().accept(this);
        }
        if (functionDefinition.getDeclarations() != null){
            for (Declaration ds: functionDefinition.getDeclarations()){
                ds.accept(this);
            }
        }
        if (functionDefinition.getBody() != null){
            functionDefinition.getBody().accept(this);
        }
        //--------------------------------------------------

        code.addCode(emitter.emitLabel(labelManager.generateFunctionReturnLabel(functionDefinition.getName())));

        for (int i = usableRegisters.size() - 1; i >= 0; i--) {
            String reg = usableRegisters.get(i);
            code.addCode(emitter.ADI( 2, "sp"));
            code.addCode(emitter.LDR("sp", reg));
        }

        code.addCode(emitter.ADR("r0","fp", "sp"));
        code.addCode(emitter.LDR("fp", "fp"));
        code.addCode(emitter.JMR("ra"));


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
            String tmpReg = getRegisterForWrite(tmpName);
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
        if (whileStatement.getCondition() != null) {
            whileStatement.getCondition().accept(this);
        }
        if (whileStatement.getBody() != null) {
            whileStatement.getBody().accept(this);
        }

        String condLabel = labelManager.generateWhileConditionLabel();
        String bodyLabel = labelManager.generateWhileBodyLabel();
        String endLabel = labelManager.generateWhileEndLabel();

        loopEndLabels.push(endLabel);

        code.addCode(emitter.emitLabel(condLabel));
        if (check_cond_While(whileStatement.getCondition())) {
            code.addCode(emitter.JMP(bodyLabel));
        }
        else {
            code.addCode(emitter.JMP(endLabel));
        }

        code.addCode(emitter.emitLabel(bodyLabel));
        if (whileStatement.getBody() != null) {
            whileStatement.getBody().accept(this);
        }
        code.addCode(emitter.JMP(condLabel));

        code.addCode(emitter.emitLabel(endLabel));
        loopEndLabels.pop();

        return code;
    }


    @Override
    public CodeObject visit(ForStatement forStatement) {
        CodeObject code = new CodeObject();
        String condLabel = labelManager.generateForConditionLabel();
        String bodyLabel = labelManager.generateForBodyLabel();
        String endLabel = labelManager.generateForEndLabel();

        loopEndLabels.push(endLabel);

        if (forStatement.getForCondition().getDeclaration() != null) {
            forStatement.getForCondition().getDeclaration().accept(this);
        }

        code.addCode(emitter.emitLabel(condLabel));
        if(check_cond_For(forStatement.getForCondition().getConditions())) {
            code.addCode(emitter.JMP(bodyLabel));
        }
        else {
            code.addCode(emitter.JMP(endLabel));
        }


        code.addCode(emitter.emitLabel(bodyLabel));
        if (forStatement.getBody() != null) {
            forStatement.getBody().accept(this);
        }

        if (forStatement.getForCondition().getSteps() != null) {
            for (Expr step : forStatement.getForCondition().getSteps()) {
                step.accept(this);
            }
        }

        code.addCode(emitter.JMP(condLabel));

        code.addCode(emitter.emitLabel(endLabel));
        loopEndLabels.pop();

        return code;
    }

    @Override
    public CodeObject visit(BreakStatement breakStatement) {
        CodeObject code = new CodeObject();

        if (loopEndLabels.isEmpty()) {
            throw new RuntimeException("Break statement not inside a loop"); // won't happen ! compile error
        }
        String targetLabel = loopEndLabels.peek();
        code.addCode(emitter.JMP(targetLabel));
        return code;
    }


    private Boolean check_cond_For(List<Expr> conditions) {
        return Boolean.TRUE; // list of expr
    }

    private Boolean check_cond_While(Expr condition) {
        return Boolean.TRUE; // expr
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
                    String rightReg = getRegisterForRead(right.getResultVar());
                    code.addCode(emitter.CMI(intVal.getInt(), rightReg));
                    code.addCode(emitter.BRR(binaryExpr.getOperator().getSymbol(), trueLabel));
                }
                else if(binaryExpr.getSecondOperand() instanceof IntVal intVal){
                    CodeObject left = binaryExpr.getFirstOperand().accept(this);
                    String leftReg = getRegisterForRead(left.getResultVar());
                    code.addCode(emitter.CMI(intVal.getInt(), leftReg));
                    code.addCode(emitter.BRR(binaryExpr.getOperator().flip().getSymbol(), trueLabel));
                }
                else{
                    CodeObject left = binaryExpr.getFirstOperand().accept(this);
                    CodeObject right = binaryExpr.getSecondOperand().accept(this);
                    String leftReg = getRegisterForRead(left.getResultVar());
                    String rightReg = getRegisterForRead(right.getResultVar());
                    code.addCode(emitter.CMR(leftReg, rightReg));
                    code.addCode(emitter.BRR(binaryExpr.getOperator().getSymbol(), trueLabel));
                }
                
                code.addCode(emitter.JMP(falseLabel));
                
            }
        }
        return code;
    }

}



