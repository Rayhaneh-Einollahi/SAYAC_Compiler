package main.ast.nodes.expr.primitives;

import main.visitor.IVisitor;

public class FloatVal extends ConstantExpr{
    public FloatVal(String str){
        this.str = str;
    }
    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
