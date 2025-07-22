package main.ast.nodes.expr.primitives;

import main.visitor.IVisitor;

public class CharVal extends ConstantExpr {
    public CharVal(String str){
        this.str = str;
    }
    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
