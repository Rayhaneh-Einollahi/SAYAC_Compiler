package main.ast.nodes.Statement;

import main.ast.nodes.Node;
import main.ast.nodes.expr.Expr;
import main.visitor.IVisitor;

public class ExpressionStatement extends Statement {
    private final Expr expr;

    public ExpressionStatement(Expr expr){
        this.expr = expr;
    }

    public Expr getExpr() {
        return expr;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
