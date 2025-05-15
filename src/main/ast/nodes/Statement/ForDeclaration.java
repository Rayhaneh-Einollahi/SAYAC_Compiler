package main.ast.nodes.Statement;

import main.ast.nodes.Node;
import main.ast.nodes.declaration.InitDeclarator;
import main.ast.nodes.expr.primitives.StringVal;
import main.visitor.IVisitor;

import java.util.List;

public class ForDeclaration extends Node {


    private List<StringVal> declarationSpecifiers;
    private List<InitDeclarator> InitDeclarators;

    public ForDeclaration(List<StringVal> declarationSpecifiers){
        this.declarationSpecifiers = declarationSpecifiers;
    }

    public void addInitDeclarators(List<InitDeclarator> initDeclarators){
        this.InitDeclarators = initDeclarators;

    }

    public List<StringVal> getDeclarationSpecifiers() {
        return declarationSpecifiers;
    }

    public void setDeclarationSpecifiers(List<StringVal> declarationSpecifiers) {
        this.declarationSpecifiers = declarationSpecifiers;
    }

    public List<InitDeclarator> getInitDeclarators() {
        return InitDeclarators;
    }

    public void setInitDeclarators(List<InitDeclarator> initDeclarators) {
        InitDeclarators = initDeclarators;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
