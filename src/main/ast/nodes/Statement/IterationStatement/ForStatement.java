package main.ast.nodes.Statement.IterationStatement;

import main.ast.nodes.Statement.Statement;
import main.symbolTable.SymbolTable;
import main.visitor.IVisitor;

public class ForStatement extends IterationStatement{
    private ForCondition forCondition;
    private SymbolTable symbol_table;

    public void set_symbol_table(SymbolTable symbol_table) {this.symbol_table = symbol_table;}
    public SymbolTable get_symbol_table() {return symbol_table;}
    public ForStatement(ForCondition fc, Statement body) {
        this.forCondition = fc;
        this.body = body;
    }

    public ForCondition getForCondition() {
        return forCondition;
    }
    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
