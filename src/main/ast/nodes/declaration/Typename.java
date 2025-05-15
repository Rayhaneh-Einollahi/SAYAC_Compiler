package main.ast.nodes.declaration;

import main.ast.nodes.Node;
import main.ast.nodes.expr.primitives.StringVal;
import main.visitor.IVisitor;

import java.util.List;

public class Typename extends Node {
    private List<StringVal> specifierQualifiers;
    private Declarator declarator;

    public void setDeclarator(Declarator declarator) {
        this.declarator = declarator;
    }

    public void setSpecifierQualifiers(List<StringVal> specifierQualifiers) {
        this.specifierQualifiers = specifierQualifiers;
    }

    public Declarator getDeclarator() {
        return declarator;
    }

    public List<StringVal> getSpecifierQualifiers() {
        return specifierQualifiers;
    }

    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
