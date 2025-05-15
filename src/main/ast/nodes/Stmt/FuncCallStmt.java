package main.ast.nodes.Stmt;

import main.visitor.IVisitor;
import main.ast.nodes.expr.FuncCallExpr;
public class FuncCallStmt extends Stmt{
    private FuncCallExpr function;

    public FuncCallStmt(FuncCallExpr function) {
        this.function = function;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public FuncCallExpr getFunction() {
        return function;
    }

    public void setFunction(FuncCallExpr function) {
        this.function = function;
    }
}
