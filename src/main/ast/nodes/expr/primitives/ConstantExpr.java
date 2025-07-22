package main.ast.nodes.expr.primitives;

import main.ast.nodes.expr.Expr;
import main.visitor.IVisitor;

public abstract class ConstantExpr extends Expr {
    protected String str;

    public String getStr() {
        return str;
    }

}
