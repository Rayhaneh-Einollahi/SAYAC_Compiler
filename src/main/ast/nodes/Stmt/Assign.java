package main.ast.nodes.Stmt;

import main.ast.nodes.expr.Expr;
import main.visitor.IVisitor;

public class Assign extends Stmt {
    private String leftHand;
    private Expr rightHand;

    public Assign(String leftHand, Expr expr) {
        this.leftHand = leftHand;
        this.rightHand = expr;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public String getLeftHand() {
        return leftHand;
    }

    public void setLeftHand(String leftHand) {
        this.leftHand = leftHand;
    }

    public Expr getRightHand() {
        return rightHand;
    }

    public void setRightHand(Expr rightHand) {
        this.rightHand = rightHand;
    }
}
