package main.ast.nodes.declaration;
import main.ast.nodes.Node;
import main.visitor.IVisitor;

public class InitDeclarator extends Node {
    private final Declarator declarator;
    private Initializer initializer;

    public InitDeclarator(Declarator declarator) {
        this.declarator = declarator;
    }
    public void addInitializer(Initializer initializer){this.initializer = initializer;}
    public Declarator getDeclarator() { return declarator; }
    public Initializer getInitializer() { return initializer; }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
