package main.ast.nodes.declaration;

import main.ast.nodes.Node;
import main.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class InitializerList extends Node {
    public final class Pair {
        private final Designation designation;
        private final Initializer initializer;

        public Pair(Designation designation, Initializer initializer) {
            this.designation = designation;
            this.initializer = initializer;
        }

        public Designation designation() { return designation; }
        public Initializer initializer() { return initializer; }

        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair other = (Pair) obj;
            return this.designation.equals(other.designation);
        }
    }
    private final List<Pair> list = new ArrayList<>();
    public void add(Designation designation, Initializer initializer){
        this.list.add(new Pair(designation, initializer));
    }

    public List<Pair> getList() {
        return list;
    }

    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        InitializerList other = (InitializerList) obj;
        return this.list.equals(other.list);
    }

}
