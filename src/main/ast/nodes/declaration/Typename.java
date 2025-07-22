package main.ast.nodes.declaration;

import main.ast.nodes.Node;
import main.ast.nodes.expr.Expr;
import main.visitor.IVisitor;

import java.util.List;

public class Typename extends Node {
    private List<Type> types;
    private Declarator declarator;

    public void setDeclarator(Declarator declarator) {
        this.declarator = declarator;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public Declarator getDeclarator() {
        return declarator;
    }

    public List<Type> getTypes() {
        return types;
    }

    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Typename other = (Typename) obj;
        return this.types.equals(other.types)
                && this.declarator.equals(other.declarator);
    }
}
