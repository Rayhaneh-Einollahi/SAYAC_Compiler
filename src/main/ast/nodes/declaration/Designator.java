package main.ast.nodes.declaration;

import main.ast.nodes.Node;
import main.ast.nodes.expr.Expr;
import main.ast.nodes.expr.Identifier;
import main.visitor.IVisitor;

public class Designator extends Node {
    private Expr expr;
    private Identifier identifier;

    public void setExpr(Expr expr) {
        this.expr = expr;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public Expr getExpr() {
        return expr;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Designator other = (Designator) obj;
        return this.expr.equals(other.expr)
                && this.identifier.equals(other.identifier);
    }
}
