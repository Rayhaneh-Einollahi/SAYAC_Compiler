package main.ast.nodes.expr.primitives;

import main.ast.nodes.expr.Expr;
import main.visitor.IVisitor;

import java.util.List;

public class StringExpr extends ConstantExpr{
    private List<String> strings;
    public StringExpr(List<String> strings) { this.strings = strings;
        this.str = String.join("", strings);
    }

    public List<String> getStrings() {
        return strings;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
