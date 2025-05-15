package main.ast.nodes.expr;

import main.ast.nodes.declaration.Typename;
import main.visitor.IVisitor;

public class SizeofTypeExpr extends Expr{
    private Typename typename;
    public SizeofTypeExpr(Typename typename){
        this.typename = typename;
    }

    public Typename getTypename() {
        return typename;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
