package main.ast.nodes.declaration;

import main.ast.nodes.Node;
import main.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class Designation extends Node {
    private List<Designator> designators = new ArrayList<>();

    public void addDesignator(Designator designator){
        this.designators.add(designator);
    }

    public List<Designator> getDesignators() {
        return this.designators;
    }

    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
