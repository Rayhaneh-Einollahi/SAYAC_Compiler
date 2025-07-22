package main.ast.nodes.declaration;

import main.ast.nodes.Node;
import main.visitor.IVisitor;
import java.util.ArrayList;
import java.util.List;

public class Parameter extends Node {
    private final List<Type> types;
    private Declarator declarator;
    public Parameter(List<Type> types){
        this.types = types;
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
        return new Declaration(types, initDeclarators);
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
        Parameter other = (Parameter) obj;
        return this.types.equals(other.types)
                && this.declarator.equals(other.declarator);
    }
}
