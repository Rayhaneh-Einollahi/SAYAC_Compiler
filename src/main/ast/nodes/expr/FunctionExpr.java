package main.ast.nodes.expr;

import main.visitor.IVisitor;

import java.util.List;

public class FunctionExpr extends Expr{
    private Expr outside;
    private List<Expr> arguments;

    public FunctionExpr(Expr outside, List<Expr> arguments){
        this.outside = outside;
        this.arguments = arguments;
    }

    public String getName(){
        return this.outside.getName();
    }
    public Expr getOutside() {
        return outside;
    }

    public List<Expr> getArguments() {
        return arguments;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
