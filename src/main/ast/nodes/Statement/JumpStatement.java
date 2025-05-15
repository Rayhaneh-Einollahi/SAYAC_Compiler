package main.ast.nodes.Statement;

import main.ast.nodes.expr.Expr;
import main.ast.nodes.expr.primitives.StringVal;
import main.visitor.IVisitor;

public class JumpStatement extends Statement{
    private Expr expr;
    private StringVal command;

    public void setExpr(Expr expr) {
        this.expr = expr;
    }

    public void setCommand(StringVal command) {
        this.command = command;
    }

    public Expr getExpr() {
        return expr;
    }

    public StringVal getCommand() {
        return command;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this);}
}
