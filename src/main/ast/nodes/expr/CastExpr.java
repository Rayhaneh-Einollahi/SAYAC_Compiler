package main.ast.nodes.expr;

import main.ast.nodes.declaration.Typename;
import main.visitor.IVisitor;

public class CastExpr extends Expr{

    private Typename typename;
    private Expr castExpr;
    public CastExpr(Typename typename, Expr castExpr){
        this.castExpr = castExpr;
        this.typename = typename;
    }

    public Typename getTypename() {
        return typename;
    }

    public Expr getCastExpr() {
        return castExpr;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
    public boolean isDead(){
        return castExpr == null || castExpr.isDead();
    }
}
