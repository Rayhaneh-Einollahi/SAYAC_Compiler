package main.ast.nodes.Statement;

import main.ast.nodes.Node;
import main.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class CompoundStatement extends Statement {
    private List<BlockItem> blockItems= new ArrayList<>();

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
