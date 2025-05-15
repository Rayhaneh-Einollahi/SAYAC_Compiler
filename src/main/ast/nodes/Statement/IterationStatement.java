package main.ast.nodes.Statement;

import main.ast.nodes.expr.Expr;
import main.visitor.IVisitor;

public class IterationStatement extends Statement{
    public enum Kind { WHILE, DO_WHILE, FOR }

    private Kind kind;
    private Expr condition;
    private Statement body;

    private ForCondition forCondition;



    public void setWhileLoop(Expr condition, Statement body) {
        this.condition = condition;
        this.body = body;
        this.kind = Kind.WHILE;
    }

    public void setDoWhileLoop(Statement body, Expr condition) {
        this.condition = condition;
        this.body = body;
        this.kind = Kind.DO_WHILE;
    }

    public void setForLoop(ForCondition fc, Statement body) {
        this.forCondition = fc;
        this.body = body;
        this.kind = Kind.FOR;
    }

    public Kind getKind() {
        return kind;
    }

    public Expr getCondition() {
        return condition;
    }

    public Statement getBody() {
        return body;
    }

    public ForCondition getForCondition() {
        return forCondition;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
