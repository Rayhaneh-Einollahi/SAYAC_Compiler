package main.symbolTable.item;

import main.ast.nodes.declaration.FuncDec;

public class FuncDecSymbolTableItem extends SymbolTableItem {
    public static final String START_KEY = "FuncDec_";

    public FuncDec getFuncDec() {
        return funcDec;
    }

    public void setFuncDec(FuncDec funcDec) {
        this.funcDec = funcDec;
    }

    private FuncDec funcDec;

    public FuncDecSymbolTableItem(FuncDec funcDec) {
        this.funcDec = funcDec;
    }

    @Override
    public String getKey() {
        return START_KEY + this.funcDec.getFuncName();
    }
}
