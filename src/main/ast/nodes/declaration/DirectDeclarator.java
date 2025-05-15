package main.ast.nodes.declaration;


import main.ast.nodes.Node;
import main.ast.nodes.expr.Expr;
import main.ast.nodes.expr.Identifier;
import main.ast.nodes.expr.primitives.StringVal;
import main.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class DirectDeclarator extends Node {
    private Identifier identifier;
    private Declarator innerDeclarator;
    private final List<DDStep> steps = new ArrayList<>();

    public static class DDStep {
        public enum Kind { ARRAY, FUNCTION_P, FUNCTION_I}
        public Kind kind;
        public Expr arrayExpr;
        public List<Parameter> params;
        public List<Identifier> identifiers;

        public DDStep(){}
    }
    public DirectDeclarator() {}

    public void setIdentifier(Identifier identifier){
        this.identifier = identifier;
    }
    public void setInnerDeclarator(Declarator innerDeclarator) {
        this.innerDeclarator = innerDeclarator;
    }
    public void addArrExpr(Expr expr) {
        DDStep ddStep = new DDStep();
        ddStep.kind = DDStep.Kind.ARRAY;
        ddStep.arrayExpr = expr;
        this.steps.add(ddStep);
    }
    public void addFuncParams(List<Parameter> params) {
        DDStep ddStep = new DDStep();
        ddStep.kind = DDStep.Kind.FUNCTION_P;
        ddStep.params = params;
        this.steps.add(ddStep);
    }
    public void addFuncIdentifiers(List<Identifier> identifiers) {
        DDStep ddStep = new DDStep();
        ddStep.kind = DDStep.Kind.FUNCTION_I;
        ddStep.identifiers = identifiers;
        this.steps.add(ddStep);
    }



    public List<DDStep> getSteps() {
        return steps;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public Declarator getInnerDeclarator() {
        return innerDeclarator;
    }

    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
