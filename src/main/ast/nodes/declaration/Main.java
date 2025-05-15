package main.ast.nodes.declaration;

import main.ast.nodes.Node;
import main.ast.nodes.Stmt.Stmt;
import main.symbolTable.SymbolTable;
import main.visitor.IVisitor;

import java.util.ArrayList;

public class Main extends Node {
    private ArrayList<Stmt> stmts = new ArrayList<Stmt>();
    private SymbolTable symbol_table;


    public SymbolTable get_symbol_table() {return symbol_table;}

    public void set_symbol_table(SymbolTable symbol_table) {this.symbol_table = symbol_table;}
    public Main() {}
    public void addStmt(Stmt stmt) {
        this.stmts.add(stmt);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public ArrayList<Stmt> getStmts() {
        return stmts;
    }

    public void setStmts(ArrayList<Stmt> stmts) {
        this.stmts = stmts;
    }

}
