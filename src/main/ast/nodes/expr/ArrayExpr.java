package main.ast.nodes.expr;

import main.visitor.IVisitor;

public class ArrayExpr extends Expr{
    private Expr outside;
    private Expr inside;

    public ArrayExpr(Expr outside, Expr inside){
        this.inside = inside;
        this.outside = outside;
    }
    public boolean isDead(){
        if(outside != null && !outside.isDead()){
            return false;
        }
        return inside == null || inside.isDead();
    }

    public Expr getOutside() {
        return outside;
    }

    public Expr getInside() {
        return inside;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
