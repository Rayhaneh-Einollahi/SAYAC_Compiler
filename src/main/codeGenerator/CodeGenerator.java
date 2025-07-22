package main.codeGenerator;

import main.ast.nodes.Statement.SelectionStatement;
import main.ast.nodes.declaration.Declaration;
import main.ast.nodes.declaration.InitDeclarator;
import main.ast.nodes.expr.*;
import main.ast.nodes.expr.operator.BinaryOperator;
import main.ast.nodes.expr.operator.UnaryOperator;
import main.ast.nodes.expr.primitives.ConstantExpr;
import main.visitor.Visitor;

import java.util.*;

public class CodeGenerator extends Visitor<String> {

    private final List<String> assembly = new ArrayList<>();
    private final Map<String, String> registers = new HashMap<>();
    private final List<String> Labels = new ArrayList<>();
    private int flag;
    private int registerCounter = 1;

    //labels:
    LabelGenerator loopLabelGen = new LabelGenerator("Loop");
    LabelGenerator elseLabelGen = new LabelGenerator("Else");
    LabelGenerator thenLabelGen = new LabelGenerator("Then");
    LabelGenerator endIfLabelGen = new LabelGenerator("EndIf");


    
    private int reverseFlag(int flag){
        return switch (flag) {
            case 0 -> 5;
            case 1 -> 3;
            case 2 -> 4;
            case 3 -> 1;
            case 4 -> 2;
            case 5 -> 0;
            default -> 0;
        };
    }
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
    public String visit(ConstantExpr constantExpr) {
        String reg = getTmpRegister();
        assembly.add("MSI " + constantExpr.getStr() + " " + reg);
        return reg;
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
        String tmpReg = null;
        switch (op){
            case BinaryOperator.PLUS:
                tmpReg = getTmpRegister();
                assembly.add("ADR " + reg1 + " " + reg2 + " " + tmpReg);
                break;
            case BinaryOperator.MINUS:
                tmpReg = getTmpRegister();
                assembly.add("SUR " + reg1 + " " + reg2 + " " + tmpReg);
                break;
            case BinaryOperator.MULT:
                tmpReg = getTmpRegister();
                assembly.add("MUL " + reg1 + " " + reg2 + " " + tmpReg);
                break;
            case BinaryOperator.DIVIDE:
                tmpReg = getTmpRegister();
                assembly.add("DIV " + reg1 + " " + reg2 + " " + tmpReg);
                break;
            case BinaryOperator.EQUAL:
                assembly.add("CMR " + reg1 + " " + reg2);
                tmpReg = "FLAG_SET";
                flag = 0;
                break;
            case BinaryOperator.GREATER:
                assembly.add("CMR " + reg1 + " " + reg2);
                tmpReg = "FLAG_SET";
                flag = 2;
                break;
            case BinaryOperator.GREATEREQUAL:
                assembly.add("CMR " + reg1 + " " + reg2);
                tmpReg = "FLAG_SET";
                flag = 3;
                break;
            case BinaryOperator.LESS:
                assembly.add("CMR " + reg1 + " " + reg2);
                tmpReg = "FLAG_SET";
                flag = 1;
                break;
            case BinaryOperator.LESSEQUAL:
                assembly.add("CMR " + reg1 + " " + reg2);
                tmpReg = "FLAG_SET";
                flag = 4;
                break;
            case BinaryOperator.NOTEQUAL:
                assembly.add("CMR " + reg1 + " " + reg2);
                tmpReg = "FLAG_SET"; // Todo: doesn't handle : a==b && c==d
                flag = 5;
                break;

        }
        return tmpReg;
    }

    public String visit(SelectionStatement selectionStatement) {


        String condReg = selectionStatement.getCondition().accept(this);
        String elseLabel = elseLabelGen.generateLabel();
        
        if (condReg.equals("FLAG_SET")){
            assembly.add("BRC " + reverseFlag(flag) + " " + elseLabel);
        }
        selectionStatement.getIfStatement().accept(this);
        String endIfLabel = endIfLabelGen.generateLabel();
        assembly.add("JMR " + endIfLabel + " " + "0"); // s = 0

        assembly.add(elseLabel + ":");
        if (selectionStatement.getElseStatement() != null) {
            selectionStatement.getElseStatement().accept(this);
        }
        assembly.add(endIfLabel + ":");

        return null;
    }
}
