package main.ast.nodes.Statement.IterationStatement;

import main.ast.nodes.Node;
import main.ast.nodes.declaration.Declaration;
import main.ast.nodes.expr.Expr;
import main.visitor.IVisitor;

import java.util.List;

public class ForCondition extends Node {

    private Declaration forDeclaration;
    private Expr expr;
    private List<Expr> conditions;
    private List<Expr> steps;

    public void setDeclaration(Declaration forDeclaration) {
        this.forDeclaration = forDeclaration;
    }

    public void setExpr(Expr expr) {
        this.expr = expr;
    }

    public void setConditions(List<Expr> conditions) {
        this.conditions = conditions;
    }

    public void setSteps(List<Expr> steps) {
        this.steps = steps;
    }


    public Declaration getDeclaration() {
        return forDeclaration;
    }

    public Expr getExpr() {
        return expr;
    }

    public List<Expr> getConditions() {
        return conditions;
    }

    public List<Expr> getSteps() {
        return steps;
    }
    @Override
    public <T> T accept(IVisitor<T> visitor) { return visitor.visit(this);}
}
