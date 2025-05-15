package main.ast.nodes.Statement;

import main.ast.nodes.Node;
import main.ast.nodes.declaration.Declaration;
import main.visitor.IVisitor;

public class BlockItem extends Node {

    private final Statement statement;
    private final Declaration declaration;

    public BlockItem(Statement Statement) {
        this.statement = Statement;
        this.declaration = null;
    }

    public BlockItem(Declaration declaration) {
        this.statement = null;
        this.declaration = declaration;
    }

    public Statement getStatement() {
        return statement;
    }

    public Declaration getDeclaration() {
        return declaration;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
