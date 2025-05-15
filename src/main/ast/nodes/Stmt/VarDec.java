package main.ast.nodes.Stmt;

import main.visitor.IVisitor;

public class VarDec extends Stmt{
    private String varName;
    private String typeName;



    public VarDec(String varName) {
        this.varName = varName;
    }
    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName = varName;
    }
    public String getTypeName() {return typeName;}

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
