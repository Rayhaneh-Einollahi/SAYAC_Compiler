package main.ast.nodes.Statement;

import main.ast.nodes.expr.Expr;
import main.visitor.IVisitor;

public class ForStatement extends IterationStatement{
    private ForCondition forCondition;
    public ForStatement(ForCondition fc, Statement body) {
        this.forCondition = fc;
        this.body = body;
    }

    public ForCondition getForCondition() {
        return forCondition;
    }
    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
