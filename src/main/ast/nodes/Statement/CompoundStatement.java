package main.ast.nodes.Statement;

import main.ast.nodes.Node;
import main.ast.nodes.declaration.Declaration;
import main.symbolTable.SymbolTable;
import main.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class CompoundStatement extends Statement {
    private List<BlockItem> blockItems= new ArrayList<>();
    private SymbolTable symbol_table;

    public void remove(Declaration declaration){
        blockItems.removeIf(blockItem -> blockItem.getDeclaration() != null && blockItem.getDeclaration() == declaration);
    }
    public SymbolTable get_symbol_table() {return symbol_table;}
    public void set_symbol_table(SymbolTable symbol_table) {this.symbol_table = symbol_table;}

    public void addBlockItem(BlockItem blockItem) {
        this.blockItems.add(blockItem);
    }

    public List<BlockItem> getBlockItems() {
        return blockItems;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Integer getStatementCount(){
        if (blockItems==null)
            return 0;
        return blockItems.size();
    }

}
