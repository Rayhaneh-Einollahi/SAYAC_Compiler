package main.ast.nodes.Statement.JumpStatement;

import main.ast.nodes.expr.Expr;
import main.visitor.IVisitor;

public class ReturnStatement extends JumpStatement{
    private Expr expr;

    public void setExpr(Expr expr) {
        this.expr = expr;
    }

    public Expr getExpr() {
        return expr;
    }
    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this);}
}
