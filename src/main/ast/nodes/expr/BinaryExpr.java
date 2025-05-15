package main.ast.nodes.expr;

import main.visitor.IVisitor;
import main.ast.nodes.expr.operator.*;

public class BinaryExpr extends Expr {
    private Expr firstOperand;
    private Expr secondOperand;
    private BinaryOperator binaryOperator;

    public BinaryExpr(Expr firstOperand, BinaryOperator operator, Expr secondOperand) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.binaryOperator = operator;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
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

    public BinaryOperator getOperator() {
        return binaryOperator;
    }

    public void setOperator(BinaryOperator operator) {
        this.binaryOperator = operator;
    }
}
