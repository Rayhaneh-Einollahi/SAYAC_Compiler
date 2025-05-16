package main.ast.nodes.declaration;

import main.ast.nodes.Node;
import main.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class Declarator extends Node {

    private Pointer pointer;
    private DirectDeclarator directDeclarator;

    public String getName(){
        DirectDeclarator dd = this.getDirectDeclarator();
        while (dd != null) {
            if (dd.getIdentifier() != null) {
                return dd.getIdentifier().getName();
            }
            Declarator inner = dd.getInnerDeclarator();
            if (inner != null) {
                dd = inner.getDirectDeclarator();
            }
        }
        return null;
    }
    public List<Declaration> getParamsDeclarations() {
        if (directDeclarator == null)
            return new ArrayList<>();
        return directDeclarator.getParamsDeclarations();

    }



    public void setPointer(Pointer pointer) {
        this.pointer = pointer;
    }

    public void setDirectDeclarator(DirectDeclarator directDeclarator) {
        this.directDeclarator = directDeclarator;
    }

    public Pointer getPointer() {
        return pointer;
    }

    public DirectDeclarator getDirectDeclarator() {
        return directDeclarator;
    }

    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
