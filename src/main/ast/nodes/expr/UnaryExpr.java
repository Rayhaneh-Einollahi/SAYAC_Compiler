package main.ast.nodes.expr;

import main.ast.nodes.expr.operator.BinaryOperator;
import main.ast.nodes.expr.operator.UnaryOperator;
import main.visitor.IVisitor;

import java.util.List;

import static main.ast.nodes.expr.operator.BinaryOperator.*;
import static main.ast.nodes.expr.operator.UnaryOperator.*;

public class UnaryExpr extends Expr{
    private Expr operand;
    private UnaryOperator operator;


    public UnaryExpr(Expr operand, UnaryOperator operator)
    {
        this.operator = operator;
        this.operand = operand;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Expr getOperand() {
        return operand;
    }

    public void setOperand(Expr operand) {
        this.operand = operand;
    }

    public UnaryOperator getOperator() {return operator;}

    public void setOperator(UnaryOperator operator) {
        this.operator = operator;
    }
    public boolean isDead(){
        if (operand != null || !operand.isDead())
            return false;
        List<UnaryOperator> assignOps = List.of(POST_INC, POST_DEC, PRE_INC, PRE_DEC);
        return !assignOps.contains( operator);
    }
}
