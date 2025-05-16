package main.ast.nodes.declaration;

import main.ast.nodes.Node;
import main.ast.nodes.expr.primitives.StringVal;
import main.visitor.IVisitor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Parameter extends Node {
    private final List<StringVal> declarationSpecifiers;
    private Declarator declarator;
    public Parameter(List<StringVal> declarationSpecifiers){
        this.declarationSpecifiers = declarationSpecifiers;
    }

    public void setDeclarator(Declarator declarator){
        this.declarator = declarator;
    }
    public Declarator getDeclarator() {
        return declarator;
    }

    public List<String> getTypeName(){
        List<String> TypeNames = new LinkedList<>();
        for (StringVal ds:declarationSpecifiers){
            TypeNames.add(ds.getName());
        }
        if (declarator == null){
            TypeNames.removeLast();
        }
        return TypeNames;
    }
    public List<StringVal> getDeclarationSpecifiers() {
        return declarationSpecifiers;
    }

    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
