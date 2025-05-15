package main.visitor;

import main.ast.nodes.Program;
import main.ast.nodes.Stmt.*;
import main.ast.nodes.declaration.FuncDec;
import main.ast.nodes.declaration.Main;
import main.ast.nodes.expr.*;
import main.ast.nodes.expr.primitives.BoolVal;
import main.ast.nodes.expr.primitives.DoubleVal;
import main.ast.nodes.expr.primitives.IntVal;
import main.ast.nodes.expr.primitives.StringVal;


/*GOALs:
 *   1. print out scope changes each time a new scope starts
 *   2. print the identifier if it is initialized
 *   3. print the identifier if it is used
 *   4. print out the name of the function when it is defined
 *   5. print out the name of the function when it is used
 *
 * */


public class TestVisitor extends Visitor<Void>{
    @Override
    public Void visit(Program program) {
        for (FuncDec func_dec : program.getFuncDecs()){
            func_dec.accept(this);
        }
        program.getMain().accept(this);
        return null;
    }
    public Void visit(Main main) {
        System.out.println("New Scope: Main");
        for (Stmt stmt : main.getStmts()){
            stmt.accept(this);
        }
        return null;
    }

    public Void visit(FuncDec funcDec) {
        System.out.println("New Scope: " + funcDec.getFuncName());
        for (Stmt stmt : funcDec.getStmts()){
            stmt.accept(this);
        }
        return null;
    }

    public Void visit(Assign assign) {
        System.out.println("Used variable: " + assign.getLeftHand());
        assign.getRightHand().accept(this);
        return null;
    }
    public Void visit(VarDec varDec) {
        System.out.println("Declared variable: " + varDec.getVarName());
        return null;
    }
    public Void visit(IfStmt ifStmt) {
        ifStmt.getCondition().accept(this);
        ifStmt.getIfBody().accept(this);
        ifStmt.getElseBody().accept(this);
        return null;
    }
    public Void visit(FuncCallStmt funcCall) {
        System.out.println("Called function: " + funcCall.getFunction().getName());
        return null;
    }
    public Void visit(UnaryExpr unaryExpr) {
        unaryExpr.getOperand().accept(this);
        return null;
    }
    public Void visit(BinaryExpr binaryExpr) {
        binaryExpr.getFirstOperand().accept(this);
        binaryExpr.getSecondOperand().accept(this);
        return null;
    }
    public Void visit(Identifier identifier) {
        System.out.println("Used variable: " + identifier.getName());
        return null;
    }

    public Void visit(IntVal int_Val) {
        return null;
    }
    public Void visit(StringVal string_val){return null;}
    public Void visit(BoolVal bool_val){return null;}
    public Void visit(DoubleVal double_vals){return null;}

    public Void visit(FuncCallExpr func_call_expr){
        System.out.println("Called function: " + func_call_expr.getName());
        return null;
    }
    public Void visit(Return the_return){
        the_return.getReturn_value().accept(this);
        return null;
    }
}


