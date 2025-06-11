package main.ast.nodes.expr;

import main.ast.nodes.expr.primitives.StringVal;
import main.visitor.IVisitor;

public class ConstantExpr extends Expr {
    private StringVal str;
    public ConstantExpr(StringVal str) {
        this.str = str;
    }

    public String getStr() {
        return str.getName();
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
