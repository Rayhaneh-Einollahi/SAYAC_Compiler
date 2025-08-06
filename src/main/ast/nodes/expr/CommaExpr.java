package main.ast.nodes.expr;

import main.visitor.IVisitor;

import java.util.List;

public class    CommaExpr extends Expr {
    private List<Expr> expressions;

    public CommaExpr(List<Expr> expressions) {
        this.expressions = expressions;
    }

    public List<Expr> getExpressions() {
        return expressions;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
    public boolean isDead(){
        for(Expr expr: expressions){
            if(expr != null && !expr.isDead()){
                return false;
            }
        }
        return true;
    }
}
