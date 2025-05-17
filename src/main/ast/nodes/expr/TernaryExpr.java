package main.ast.nodes.expr;

import main.ast.nodes.expr.operator.BinaryOperator;
import main.visitor.IVisitor;

public class TernaryExpr extends Expr{
    private Expr firstOperand;
    private Expr secondOperand;
    private Expr thirdOperand;

    public TernaryExpr(Expr firstOperand, Expr secondOperand, Expr thirdOperand) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.thirdOperand = thirdOperand;

    }

    public Expr getFirstOperand() {
        return firstOperand;
    }

    public void setFirstOperand(Expr firstOperand) {
        this.firstOperand = firstOperand;
    }

    public Expr getSecondOperand() {
        return secondOperand;
    }

    public void setSecondOperand(Expr secondOperand) {
        this.secondOperand = secondOperand;
    }

    public Expr getThirdOperand() {
        return thirdOperand;
    }

    public void setThirdOperand(Expr thirdOperand) {
        this.thirdOperand = thirdOperand;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
    public boolean isDead(){
        if(firstOperand != null && !firstOperand.isDead()){
            return false;
        }
        if(secondOperand != null && !secondOperand.isDead()){
            return false;
        }
        return thirdOperand == null || thirdOperand.isDead();
    }
}
