package main.symbolTable.item;

import main.ast.nodes.declaration.Declaration;
import main.ast.nodes.declaration.FunctionDefinition;
import main.symbolTable.utils.Key;

import java.util.ArrayList;
import java.util.List;

public class FuncDecSymbolTableItem extends SymbolTableItem {
    public static final String START_KEY = "FuncDef_";
    private final List<Integer> removedArgs = new ArrayList<>();
    private FunctionDefinition functionDefinition;

    public FunctionDefinition getFuncDec() {
        return functionDefinition;
    }

    public void setFuncDec(FunctionDefinition functionDefinition) {
        this.functionDefinition = functionDefinition;
    }
    public void addRemoved(int index){
        removedArgs.add(index);
    }

    public List<Integer> getRemovedArgs() {
        return removedArgs;
    }

    public FuncDecSymbolTableItem(FunctionDefinition functionDefinition) {
        this.functionDefinition = functionDefinition;
    }

    @Override
    public Key getKey() {
        return new Key(START_KEY, functionDefinition.getName(), functionDefinition.getArgDeclarations().size());
    }
}
