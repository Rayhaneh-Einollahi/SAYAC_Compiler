package main.visitor;

import main.ast.nodes.declaration.Declaration;
import main.ast.nodes.declaration.InitDeclarator;
import main.ast.nodes.expr.*;
import main.ast.nodes.expr.operator.BinaryOperator;
import main.ast.nodes.expr.operator.UnaryOperator;

import java.util.*;

public class CodeGenerator extends Visitor<String>{

    private final List<String> assembly = new ArrayList<>();
    private final Map<String, String> registers = new HashMap<>();
    private int registerCounter = 1;



    private String getRegister(String var) {
        return registers.computeIfAbsent(var, v -> "R" + (registerCounter++));
    }

    private String getTmpRegister(){
        return "R" + (registerCounter++);
    }
    private String allocRegister(String var) {
        String reg = "R" + (registerCounter++);
        registers.put(var, reg);
        return reg;
    }

    public void printAssembly() {
        for (String line : assembly) {
            System.out.println(line);
        }
    }

    public String visit(Declaration declaration) {
//        if (declaration.getDeclarationSpecifiers() != null){
//            for (Expr expr : declaration.getDeclarationSpecifiers()) {
//                expr.accept(this);
//            }
//        }
        if (declaration.getInitDeclarators() != null) {
            for (InitDeclarator id : declaration.getInitDeclarators()) {
                String var = id.getDeclarator().getName();
                String reg = allocRegister(var);
                String imm = "0";
                if (id.getInitializer().getExpr() != null) {
                    Expr expr = id.getInitializer().getExpr();
                    if(expr instanceof ConstantExpr constantExpr){
                        imm = constantExpr.getStr();
                    }
                }
                assembly.add("MSI " + imm + " " + reg);
//                id.accept(this);
            }
        }
        return null;
    }
    public String visit(Identifier identifier) {
        return getRegister(identifier.getName());
    }

    public String visit(UnaryExpr unaryExpr) {
        UnaryOperator op = unaryExpr.getOperator();
        String reg = unaryExpr.getOperand().accept(this);
        String tmpReg;
        switch (op) {
            case UnaryOperator.PRE_INC:
                assembly.add("ADI " + "1 " + reg);
                return reg;
            case UnaryOperator.PRE_DEC:     /// (a++) + b
                assembly.add("SUI " + "1 " + reg);
                return reg;
            case UnaryOperator.POST_INC:
                tmpReg = getTmpRegister();
                assembly.add("ADR " + "R0 " + reg + " " + tmpReg);
                assembly.add("ADI " + "1 " + reg);
                return tmpReg;
            case UnaryOperator.POST_DEC:
                tmpReg = getTmpRegister();
                assembly.add("ADR " + "R0 " + reg + " " + tmpReg);
                assembly.add("SUI " + "1 " + reg);
                return tmpReg;
            default:
                return null;
        }
    }
    public String visit(BinaryExpr binaryExpr) {
        String reg1, reg2;
        reg1 = binaryExpr.getFirstOperand().accept(this);
        reg2 = binaryExpr.getSecondOperand().accept(this);


        BinaryOperator op = binaryExpr.getOperator();
        String tmpReg = getTmpRegister();
        switch (op){
            case BinaryOperator.PLUS:
                assembly.add("ADR " + reg1 + " " + reg2 + " " + tmpReg);
                break;
            case BinaryOperator.MINUS:
                assembly.add("SUR " + reg1 + " " + reg2 + " " + tmpReg);
                break;
            case BinaryOperator.MULT:
                assembly.add("MUL " + reg1 + " " + reg2 + " " + tmpReg);
                break;
            case BinaryOperator.DIVIDE:
                assembly.add("DIV " + reg1 + " " + reg2 + " " + tmpReg);
                break;
        }
        return tmpReg;
    }
}
