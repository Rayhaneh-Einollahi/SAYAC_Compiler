package main.ast.nodes.expr.primitives;

import main.ast.nodes.expr.Expr;
import main.visitor.IVisitor;

public class BoolVal extends Expr {
    private boolean bool_val;
    public BoolVal(String bool_val){
        this.bool_val = bool_val.equals("true");
    }

    public boolean get_bool_val() {
        return this.bool_val;
    }

    public void set_bool_val(boolean bool_val) {
        this.bool_val = bool_val;
    }
    @Override
    public String toString(){return "BoolValue:" + String.valueOf(this.bool_val);}
    @Override
    public <T> T accept(IVisitor<T> visitor){return visitor.visit(this);}
}
