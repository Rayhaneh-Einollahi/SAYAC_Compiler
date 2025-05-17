package main.ast.nodes.expr.primitives;

import main.ast.nodes.expr.Expr;
import main.visitor.IVisitor;

public class StringVal extends Expr {
    private String string_val;
    public StringVal(String string_val){this.string_val =  string_val;}

    public String getName() {
        return string_val;
    }

    public void set_string_val(String string_val) {
        this.string_val = string_val;
    }
    @Override
    public String toString(){return this.string_val;}
    @Override
    public <T> T accept(IVisitor<T> visitor){return visitor.visit(this);}
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        StringVal other = (StringVal) obj;
        return this.string_val.equals(other.string_val);
    }
}
