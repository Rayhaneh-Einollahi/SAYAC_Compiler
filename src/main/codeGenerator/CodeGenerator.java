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
    private final CodeGenContext context;
    private boolean insideFunction = false;

    public CodeGenerator(CodeGenContext context) {
        this.context = context;
    }

    public String visit(Declaration declaration) {


            for (InitDeclarator initDeclarator : declaration.getInitDeclarators()) {
                String varName = initDeclarator.getDeclarator().getName();
                String initValue = "0";
                System.out.println(varName);
                if (initDeclarator.getInitializer() != null && initDeclarator.getInitializer().getExpr() != null) {
                    Expr expr = initDeclarator.getInitializer().getExpr();
                    if (expr instanceof ConstantExpr constantExpr) {
                        initValue = constantExpr.getStr();
                    }
                }

                if (!insideFunction) {
                    this.context.emitter.emitRaw(".data");
                    this.context.emitter.emitRaw(varName + ": .word " + initValue);
                    this.context.emitter.emitRaw(".text");
                } else {
//                    this.context.memoryManager.beginFrame(); entering main function
                    if (initValue != null) {
                        int offset = this.context.memoryManager.allocateLocal(varName, 4);
                        int reg = this.context.registerManager.allocate();
                        int reg2 = this.context.registerManager.allocate();
                        this.context.emitter.emit("MSI", this.context.registerManager.regName(reg), initValue);
                        this.context.emitter.emit("MSI", this.context.registerManager.regName(reg2), "1000");

                        this.context.emitter.emit("ADI", this.context.registerManager.regName(reg2), this.context.memoryManager.stackAccess(-4));

                        this.context.emitter.emit("STR", this.context.registerManager.regName(reg2), this.context.registerManager.regName(reg));
                        this.context.registerManager.free(reg);
                        this.context.registerManager.free(reg2);
                    }
                }
            }

            this.context.emitter.printCode();

            return null;


    }


    public String visit(FunctionDefinition functionDefinition) {
        this.insideFunction = true;
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
        return null;
    }

    public String visit(Identifier identifier) {
        System.out.println("identifier");
        return null;
    }
    public String visit(ConstantExpr constantExpr) {
        System.out.println("constantExpr");
        return null;
    }

    public String visit(UnaryExpr unaryExpr) {
        System.out.println("unaryExpr");
        return null;
    }
    public String visit(BinaryExpr binaryExpr) {
        System.out.println("binaryExpr");
        return null;
    }

    public String visit(SelectionStatement selectionStatement) {
        System.out.println("selectionStatement");
        return null;
    }
    public String visit(WhileStatement whileStmt) {  return null; }
    public String visit(ForStatement forStmt) {  return null; }
}
