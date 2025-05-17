package main.symbolTable.item;

import main.symbolTable.utils.Key;

public abstract class SymbolTableItem {
    private int usedCount = 0;
    public void incUsed(){
        usedCount ++;
    }
    public boolean isUsed(){
        return usedCount>0;
    }
    public abstract Key getKey();
}
