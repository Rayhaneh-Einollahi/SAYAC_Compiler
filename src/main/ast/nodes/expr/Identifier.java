package main.ast.nodes.expr;

import main.visitor.IVisitor;

public class Identifier extends Expr{
    private String name;

    public Identifier(String _name) {name = _name;}
    public void setName(String name) {this.name = name;}
    public String getName(){return this.name;}
    @Override
    public <T> T accept(IVisitor<T> visitor) {return visitor.visit(this);}


}
