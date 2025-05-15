package main.ast.nodes.expr;

import main.ast.nodes.Node;
import main.ast.nodes.expr.primitives.StringVal;
import main.visitor.IVisitor;

import java.util.List;

public class StringExpr extends Expr {
    private List<StringVal> strings;
    public StringExpr(List<StringVal> strings) { this.strings = strings; }

    public List<StringVal> getStrings() {
        return strings;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
