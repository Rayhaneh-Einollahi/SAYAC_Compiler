package main.ast.nodes.Statement.IterationStatement;

import main.ast.nodes.Statement.Statement;
import main.ast.nodes.expr.Expr;
import main.symbolTable.SymbolTable;
import main.visitor.IVisitor;

public class WhileStatement extends IterationStatement{
    private Expr condition;
    public WhileStatement(Expr condition, Statement body) {
        this.condition = condition;
        this.body = body;
    }
    private SymbolTable symbol_table;

    public void set_symbol_table(SymbolTable symbol_table) {this.symbol_table = symbol_table;}
    public SymbolTable get_symbol_table() {return symbol_table;}

    public Expr getCondition() {
        return condition;
    }
    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
