package main.ast.nodes.declaration;

import main.ast.nodes.Node;
import main.visitor.IVisitor;

import java.util.List;

public class Pointer extends Node {
    private int starCount;
    private List<Integer> constCounts;

    public void setStarCount(int starCount) {
        this.starCount = starCount;
    }

    public void setConstCounts(List<Integer> constCounts) {
        this.constCounts = constCounts;
    }

    public int getStarCount() {
        return starCount;
    }

    public List<Integer> getConstCounts() {
        return constCounts;
    }

    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
