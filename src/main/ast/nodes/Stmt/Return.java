package main.ast.nodes.Stmt;

import main.ast.nodes.expr.Expr;
import main.visitor.IVisitor;

public class Return extends Stmt {

    private Expr return_value;

    public Return( Expr expr) {
        this.return_value = expr;
    }

    public Expr getReturn_value() {
        return return_value;
    }
    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
