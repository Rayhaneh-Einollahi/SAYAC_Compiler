package main.ast.nodes.Statement;

import main.ast.nodes.expr.Expr;
import main.visitor.IVisitor;

public class SelectionStatement extends Statement{
    private Expr condition;
    private Statement ifStatement;
    private Statement elseStatement;


    public SelectionStatement(Expr condition, Statement ifStatement){
        this.condition = condition;
        this.ifStatement = ifStatement;
    }
    public void addElse(Statement elseStatement){
        this.elseStatement = elseStatement;
    }
    public Expr getCondition() {
        return condition;
    }

    public Statement getIfStatement() {
        return ifStatement;
    }

    public Statement getElseStatement() {
        return elseStatement;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
