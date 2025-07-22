package main.ast.nodes.Statement.IterationStatement;

import main.ast.nodes.Statement.Statement;
import main.ast.nodes.expr.Expr;
import main.visitor.IVisitor;

public class WhileStatement extends IterationStatement{
    private Expr condition;
    public WhileStatement(Expr condition, Statement body) {
        this.condition = condition;
        this.body = body;
    }

    public Expr getCondition() {
        return condition;
    }
    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
