package main.ast.nodes.Statement.JumpStatement;

import main.ast.nodes.expr.Expr;
import main.visitor.IVisitor;

public class BreakStatement extends JumpStatement{
    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this);}

}
