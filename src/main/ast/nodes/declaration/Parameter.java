package main.ast.nodes.declaration;

import main.ast.nodes.Node;
import main.ast.nodes.expr.primitives.StringVal;
import main.visitor.IVisitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Parameter extends Node {
    private final List<StringVal> declarationSpecifiers;
    private Declarator declarator;
    public Parameter(List<StringVal> declarationSpecifiers){
        this.declarationSpecifiers = declarationSpecifiers;
    }

    public void setDeclarator(Declarator declarator){
        this.declarator = declarator;
    }
    public Declarator getDeclarator() {
        return declarator;
    }

    public Declaration extractDeclaration(){
        ArrayList<InitDeclarator> initDeclarators = new ArrayList<>();
        if (declarator != null){
            initDeclarators.add(new InitDeclarator(declarator));
        }
        return new Declaration(declarationSpecifiers, initDeclarators);
    }
    public List<StringVal> getDeclarationSpecifiers() {
        return declarationSpecifiers;
    }

    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Parameter other = (Parameter) obj;
        return this.declarationSpecifiers.equals(other.declarationSpecifiers)
                && this.declarator.equals(other.declarator);
    }
}
