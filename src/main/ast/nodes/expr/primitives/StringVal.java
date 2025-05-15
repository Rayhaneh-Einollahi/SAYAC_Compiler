package main.ast.nodes.expr.primitives;

import main.ast.nodes.expr.Expr;
import main.visitor.IVisitor;

public class StringVal extends Expr {
    private String string_val;
    public StringVal(String string_val){this.string_val =  string_val.substring(1, string_val.length() - 1);;}

    public String get_string_val() {
        return string_val;
    }

    public void set_string_val(String string_val) {
        this.string_val = string_val;
    }
    @Override
    public String toString(){return "StringValue:" +this.string_val;}
    @Override
    public <T> T accept(IVisitor<T> visitor){return visitor.visit(this);}
}
