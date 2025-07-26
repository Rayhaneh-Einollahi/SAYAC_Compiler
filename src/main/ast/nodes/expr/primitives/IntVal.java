package main.ast.nodes.expr.primitives;

import main.ast.nodes.expr.Expr;
import main.visitor.IVisitor;

public class IntVal extends ConstantExpr {
    public IntVal(String intVal){
        this.str = intVal;
    }

    @Override
    public String toString(){
        return "IntValue:" + this.str;}
    @Override
    public <T> T accept(IVisitor<T> visitor){return visitor.visit(this);}
}