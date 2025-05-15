package main.symbolTable.item;

import main.ast.nodes.declaration.FunctionDefinition;

public class FuncDecSymbolTableItem extends SymbolTableItem {
    public static final String START_KEY = "FuncDef_";
    private FunctionDefinition functionDefinition;

    public FunctionDefinition getFuncDec() {
        return functionDefinition;
    }

    public void setFuncDec(FunctionDefinition functionDefinition) {
        this.functionDefinition = functionDefinition;
    }


    public FuncDecSymbolTableItem(FunctionDefinition functionDefinition) {
        this.functionDefinition = functionDefinition;
    }

    @Override
    public String getKey() {
        return START_KEY + this.functionDefinition.getName();
    }
}
