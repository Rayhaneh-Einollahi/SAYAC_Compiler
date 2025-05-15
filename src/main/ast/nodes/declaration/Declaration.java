package main.ast.nodes.declaration;

import main.ast.nodes.Node;
import main.ast.nodes.expr.primitives.StringVal;
import main.visitor.IVisitor;

import java.util.List;

public class Declaration extends ExternalDeclaration {
    private final List<StringVal> declarationSpecifiers;
    private final List<InitDeclarator> initDeclarators;
    public Declaration(
            List<StringVal> declarationSpecifiers,
            List<InitDeclarator> initDeclarators){
        this.declarationSpecifiers = declarationSpecifiers;
        this.initDeclarators = initDeclarators;
    }

    public String getName(){
        if (initDeclarators==null){
            return this.declarationSpecifiers.getLast().getName();
        }
        return initDeclarators.getLast().getDeclarator().getName();
    }
    public List<StringVal> getDeclarationSpecifiers() {
        return declarationSpecifiers;
    }

    public List<InitDeclarator> getInitDeclarators() {
        return initDeclarators;
    }

    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
