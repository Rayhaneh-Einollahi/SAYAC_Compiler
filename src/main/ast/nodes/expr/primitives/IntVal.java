package main.ast.nodes.expr.primitives;

import main.ast.nodes.expr.Expr;
import main.visitor.IVisitor;

public class IntVal extends ConstantExpr {
    private String intVal;
    public IntVal(String intVal){this.intVal = intVal;
        this.str = intVal;
    }

    @Override
    public String toString(){
        return "IntValue:" + String.valueOf(this.intVal);}
    @Override
    public <T> T accept(IVisitor<T> visitor){return visitor.visit(this);}
}