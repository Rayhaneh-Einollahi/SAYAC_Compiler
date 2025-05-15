package main.visitor;

import main.ast.nodes.Program;
import main.ast.nodes.Stmt.*;
import main.ast.nodes.declaration.*;
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

public abstract class Visitor<T> implements IVisitor<T> {
    @Override
    public T visit(Program program) {
        return null;
    }
    public T visit(Main main) {
        return null;
    }

    public T visit(FuncDec funcDec) {
        return null;
    }

    public T visit(Assign assign) {
        return null;
    }
    public T visit(VarDec varDec) {
        return null;
    }
    public T visit(IfStmt ifStmt) {
        return null;
    }
    public T visit(FuncCallStmt funcCall) {
        return null;
    }
    public T visit(UnaryExpr unaryExpr) {
        return null;
    }
    public T visit(BinaryExpr binaryExpr) {
        return null;
    }
    public T visit(Identifier identifier) {
        return null;
    }

    public T visit(IntVal int_Val) {
        return null;
    }
    public T visit(StringVal string_val){return null;}
    public T visit(BoolVal bool_val){return null;}
    public T visit(DoubleVal double_vals){return null;}
    public T visit(FuncCallExpr func_call_expr){
        return null;
    }
    public T visit(Return the_return){
        return null;
    }

}
