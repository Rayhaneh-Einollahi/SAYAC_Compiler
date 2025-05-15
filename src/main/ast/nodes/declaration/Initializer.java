package main.ast.nodes.declaration;

import main.ast.nodes.Node;
import main.ast.nodes.expr.Expr;
import main.visitor.IVisitor;

public class Initializer extends Node {
    private Expr expr;
    private InitializerList initializerList;
    private Designation designation;

    public void setInitializerlist(InitializerList initializerslist) {
        this.initializerList = initializerslist;
    }

    public void setExpr(Expr expr) {
        this.expr = expr;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    public InitializerList getInitializerlist() {
        return initializerList;
    }

    public Expr getExpr() {
        return expr;
    }

    public Designation getDesignation() {
        return designation;
    }

    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
