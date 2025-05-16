package main.symbolTable.item;

import main.ast.nodes.declaration.FunctionDefinition;
import main.symbolTable.utils.Key;

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
    public Key getKey() {
        return new Key(START_KEY, functionDefinition.getName(), functionDefinition.getArgDeclarations().size());
    }
}
