package main.ast.nodes.declaration;


import main.ast.nodes.Node;
import main.ast.nodes.expr.Expr;
import main.ast.nodes.expr.Identifier;
import main.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class DirectDeclarator extends Node {
    private Identifier identifier;
    private Declarator innerDeclarator;
    private final List<DDStep> steps = new ArrayList<>();

    public boolean isGlobal() {
        return this.identifier.isGlobal();
    }

    public Boolean isVar() {
        return this.identifier.isVar();
    }

    public static class DDStep {
        public enum Kind { ARRAY, FUNCTION_P, FUNCTION_I}
        public Kind kind;
        public Expr arrayExpr;
        public List<Parameter> params;
        public List<Identifier> identifiers;

        public DDStep(){}
        public List<Declaration> getParamsDeclarations(){
            List<Declaration> paramsTypes = new ArrayList<>();
            for (Parameter parameter: params){
                paramsTypes.add(parameter.extractDeclaration());
            }
            return paramsTypes;
        }
        public void remove(Declaration declaration){
            params.removeIf(parameter -> declaration.equals(parameter.extractDeclaration()));
        }

        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            DDStep other = (DDStep) obj;
            return this.kind.equals(other.kind)
                    && this.arrayExpr.equals(other.arrayExpr)
                    && this.params.equals(other.params)
                    && this.identifiers.equals(other.identifiers);
        }
    }
    public DirectDeclarator() {}

    public List<Declaration> getParamsDeclarations(){
        if (steps.isEmpty())
            return new ArrayList<>();
        return steps.getFirst().getParamsDeclarations();

    }
    public void remove(Declaration declaration){
        steps.getFirst().remove(declaration);
    }
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

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        DirectDeclarator other = (DirectDeclarator) obj;
        return this.identifier.equals(other.identifier)
                && this.innerDeclarator.equals(other.innerDeclarator)
                && this.steps.equals(other.steps);
    }
}
