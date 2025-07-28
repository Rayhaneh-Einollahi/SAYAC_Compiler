package main.codeGenerator;

import main.ast.nodes.Statement.IterationStatement.ForStatement;
import main.ast.nodes.Statement.IterationStatement.WhileStatement;
import main.ast.nodes.Statement.SelectionStatement;
import main.ast.nodes.declaration.Declaration;
import main.ast.nodes.declaration.Declarator;
import main.ast.nodes.declaration.FunctionDefinition;
import main.ast.nodes.declaration.InitDeclarator;
import main.ast.nodes.expr.*;
import main.ast.nodes.expr.operator.BinaryOperator;
import main.ast.nodes.expr.operator.UnaryOperator;
import main.ast.nodes.expr.primitives.ConstantExpr;
import main.visitor.Visitor;

import java.util.*;



public class CodeGenerator extends Visitor<String> {
    private boolean insideFunction = false;
    public final RegisterManager registerManager;
    public final MemoryManager memoryManager;
    public final InstructionEmitter emitter;
    public final LabelManager labelManager;

    public CodeGenerator() {
        registerManager = new RegisterManager();
        memoryManager = new MemoryManager();
        emitter = new InstructionEmitter();
        labelManager = new LabelManager();
    }

    public String visit(Declaration declaration) {


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

    /**
     * generate code for Function: <p>
     * 1 - generate a label for the beginning of function definition <p>
     * 2 - store the current frame-pointer to the stack <p>
     * 3 - as new function is called another frame should be initialized so the fp is updated to current stack-pointer <p>
     * 4 - move the sp to point to the clear cell of memory <p>
     * 5 - store the used registers
     * @param functionDefinition : function definition node
     */

    public String visit(FunctionDefinition functionDefinition) {
        this.emitter.emitRaw(labelManager.generateFunctionLabel(functionDefinition.getName()));
        this.emitter.STR("fp", "sp");
        this.emitter.ADR("r0", "sp", "fp");
        this.emitter.ADI("-2", "sp");
        //Todo (optional): use liveness  analyze to allocate space for locals instead of allocating all:
        this.emitter.ADI(String.valueOf(functionDefinition.getNumLocals() * -2), "sp");

        List<String> usableRegisters = registerManager.getUsableRegisters(); //Todo:[option 1(naive approach)] get all the
                                                                             // registers except the ones in use like
                                                                             // fp, sp, r0
                                                                             // [option 2] get the code generated for this part
                                                                             // and save only the registers used in this func
                                                                             //

        for (String reg : usableRegisters) {
            this.emitter.STR( reg, "sp");
            this.emitter.ADI( "-4", "sp");
        }

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

        this.emitter.emitRaw(labelManager.generateFunctionReturnLabel(functionDefinition.getName()));

        for (int i = usableRegisters.size() - 1; i >= 0; i--) {
            String reg = usableRegisters.get(i);
            this.emitter.ADI( "4", "sp");
            this.emitter.LDR("sp", reg);
        }

        this.emitter.ADR("r0","fp", "sp");
        this.emitter.LDR("fp", "fp");
        this.emitter.Ret();


        return null;
    }

}



