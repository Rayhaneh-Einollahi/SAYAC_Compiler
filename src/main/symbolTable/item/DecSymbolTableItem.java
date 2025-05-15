package main.symbolTable.item;

import main.ast.nodes.declaration.*;

public class DecSymbolTableItem extends SymbolTableItem{
    public static final String START_KEY = "VarDec_";
    private Declaration declaration;

    public Declaration getDeclaration() {
        return declaration;
    }

    public void setDeclaration(Declaration declaration) {
        this.declaration = declaration;
    }


    public DecSymbolTableItem(Declaration varDec) {
        this.declaration = varDec;
    }

    @Override
    public String getKey() {
        return START_KEY + this.declaration.getName();
    }

}
