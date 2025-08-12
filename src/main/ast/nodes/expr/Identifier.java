package main.ast.nodes.expr;

import main.visitor.IVisitor;

public class Identifier extends Expr{
    private String name;
    private String specialName;
    private boolean status;
    public void setSpecialName(String specialName) {
        this.specialName = specialName;
    }

    public String getSpecialName() {
        return specialName;
    }

    public boolean isGlobal() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }


    public Identifier(String _name, Integer line) {name = _name; this.setLine(line); this.status = false;}
    public void setName(String name) {this.name = name;}
    public String getName(){return this.name;}
    @Override
    public <T> T accept(IVisitor<T> visitor) {return visitor.visit(this);}


}
