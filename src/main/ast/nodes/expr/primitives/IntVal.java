package main.ast.nodes.expr.primitives;

import main.ast.nodes.expr.Expr;
import main.visitor.IVisitor;

public class IntVal extends Expr {
    private int intVal;
    public IntVal(int intVal){this.intVal = intVal;}

    public int getIntVal() {
        return intVal;
    }

    public void setIntVal(int intVal) {
        this.intVal = intVal;
    }
    @Override
    public String toString(){return "IntValue:" + String.valueOf(this.intVal);}
    @Override
    public <T> T accept(IVisitor<T> visitor){return visitor.visit(this);}
}