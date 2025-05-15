package main.ast.nodes;

import main.symbolTable.SymbolTable;
import main.visitor.IVisitor;
import main.ast.nodes.declaration.ExternalDeclaration;

import java.util.ArrayList;
import java.util.List;

public class Program extends Node{
    private List<ExternalDeclaration> externalDeclarations = new ArrayList<>();;
    private SymbolTable symbol_table;

    public Program() {

    }
    public void addExternalDeclarations(List<ExternalDeclaration> declarations){
        this.externalDeclarations = declarations;

    }
    public List<ExternalDeclaration> getExternalDeclarations() {
        return externalDeclarations;
    }
    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public SymbolTable get_symbol_table() {return symbol_table;}
    public void set_symbol_table(SymbolTable symbol_table) {this.symbol_table = symbol_table;}
}
