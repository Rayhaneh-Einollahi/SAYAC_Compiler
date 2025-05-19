package main.ast.nodes.declaration;

import main.ast.nodes.Node;
import main.ast.nodes.expr.Expr;
import main.ast.nodes.expr.primitives.StringVal;
import main.visitor.IVisitor;

import java.util.List;

public class Typename extends Node {
    private List<Expr> specifierQualifiers;
    private Declarator declarator;

    public void setDeclarator(Declarator declarator) {
        this.declarator = declarator;
    }

    public void setSpecifierQualifiers(List<Expr> specifierQualifiers) {
        this.specifierQualifiers = specifierQualifiers;
    }

    public Declarator getDeclarator() {
        return declarator;
    }

    public List<Expr> getSpecifierQualifiers() {
        return specifierQualifiers;
    }

    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Typename other = (Typename) obj;
        return this.specifierQualifiers.equals(other.specifierQualifiers)
                && this.declarator.equals(other.declarator);
    }
}
