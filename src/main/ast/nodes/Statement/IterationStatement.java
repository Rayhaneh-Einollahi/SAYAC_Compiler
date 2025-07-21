package main.ast.nodes.Statement;

import main.ast.nodes.expr.Expr;
import main.symbolTable.SymbolTable;
import main.visitor.IVisitor;

public abstract class IterationStatement extends Statement{
    protected Statement body;

    private SymbolTable symbol_table;
    public SymbolTable get_symbol_table() {return symbol_table;}
    public void set_symbol_table(SymbolTable symbol_table) {this.symbol_table = symbol_table;}

    public Statement getBody() {
        return body;
    }
}
