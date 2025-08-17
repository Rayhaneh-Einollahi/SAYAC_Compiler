package main.ast.nodes.declaration;

import main.ast.nodes.Node;
import main.ast.nodes.expr.Expr;
import main.visitor.IVisitor;

public class Initializer extends Node {
    private Expr expr;
    private InitializerList initializerList;

    public void setInitializerlist(InitializerList initializerslist) {
        this.initializerList = initializerslist;
    }

    public void setExpr(Expr expr) {
        this.expr = expr;
    }

    public InitializerList getInitializerlist() {
        return initializerList;
    }

    public Expr getExpr() {
        return expr;
    }


    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Initializer other = (Initializer) obj;
        return this.expr.equals(other.expr)
                && this.initializerList.equals(other.initializerList);
    }

}
