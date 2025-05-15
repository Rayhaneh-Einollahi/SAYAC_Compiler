package main.symbolTable.item;

import main.ast.nodes.Stmt.VarDec;

public class VarDecSymbolTableItem extends SymbolTableItem{
    public static final String START_KEY = "VarDec_";

    public VarDec getVarDec() {
        return varDec;
    }

    public void setVarDec(VarDec varDec) {
        this.varDec = varDec;
    }

    private VarDec varDec;

    public VarDecSymbolTableItem(VarDec varDec) {
        this.varDec = varDec;
    }

    @Override
    public String getKey() {
        return START_KEY + this.varDec.getVarName();
    }

}
