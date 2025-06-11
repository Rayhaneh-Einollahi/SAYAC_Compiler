package main.visitor;

import main.ast.nodes.declaration.Declaration;
import main.ast.nodes.declaration.InitDeclarator;
import main.ast.nodes.expr.ConstantExpr;
import main.ast.nodes.expr.Expr;
import main.ast.nodes.expr.Identifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodeGenerator extends Visitor<Void>{

    private final List<String> assembly = new ArrayList<>();
    private final Map<String, String> registers = new HashMap<>();
    private int registerCounter = 1;



    public List<String> generateAssembly(String instr) {

        if (instr.endsWith(":")) {
            assembly.add(instr);
            return;
        }

        // Handle conditional and unconditional jumps
        if (instr.startsWith("if")) {
            // if t1 goto L1
            String[] parts = instr.split(" ");
            String cond = parts[1];
            String label = parts[3];
            String reg = getRegister(cond);
            assembly.add("CMP " + reg + ", 0");
            assembly.add("JNE " + label);
            continue;
        } else if (instr.startsWith("goto")) {
            String label = instr.split(" ")[1];
            assembly.add("JMP " + label);
            continue;
        }

        // Handle binary operations and assignments
        String[] parts = instr.split(" ");
        if (parts.length == 5 && parts[1].equals("=")) {
            // Format: t1 = t2 + t3
            String dest = parts[0];
            String left = parts[2];
            String op = parts[3];
            String right = parts[4];

            String regLeft = getRegister(left);
            String regRight = getRegister(right);
            String regDest = allocRegister(dest);

            switch (op) {
                case "+" -> assembly.add("ADD " + regDest + ", " + regLeft + ", " + regRight);
                case "-" -> assembly.add("SUB " + regDest + ", " + regLeft + ", " + regRight);
                case "*" -> assembly.add("MUL " + regDest + ", " + regLeft + ", " + regRight);
                case "/" -> assembly.add("DIV " + regDest + ", " + regLeft + ", " + regRight);
                default -> throw new RuntimeException("Unsupported operator: " + op);
            }

        } else if (parts.length == 3 && parts[1].equals("=")) {
            // Format: x = y
            String dest = parts[0];
            String src = parts[2];
            String regSrc = getRegister(src);
            String regDest = allocRegister(dest);
            assembly.add("MOV " + regDest + ", " + regSrc);
        } else {
            throw new RuntimeException("Unrecognized TAC format: " + instr);
        }

        return assembly;
    }

    private String getRegister(String var) {
        return registers.computeIfAbsent(var, v -> "R" + (registerCounter++));
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

    public Void visit(Declaration declaration) {
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
}
