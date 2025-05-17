package main.symbolTable;


import main.ast.nodes.declaration.Declaration;
import main.ast.nodes.declaration.ExternalDeclaration;
import main.symbolTable.exceptions.ItemAlreadyExistsException;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.item.DecSymbolTableItem;
import main.symbolTable.item.FuncDecSymbolTableItem;
import main.symbolTable.item.SymbolTableItem;
import main.symbolTable.utils.Key;

import java.util.*;


public class SymbolTable {

    //Start of static members

    public static SymbolTable top;
    public static SymbolTable root;
    private static Stack<SymbolTable> stack = new Stack<>();
    private static Set<String> built_in_funcs  = new HashSet<>(Arrays.asList("printf", "scanf"));

    public static Boolean isBuiltIn(String name){
        return built_in_funcs.contains(name);
    }
    public static void push(SymbolTable symbolTable) {
        if (top != null)
            stack.push(top);
        top = symbolTable;
    }

    public static void pop() {
        top = stack.pop();
    }

    public SymbolTable pre;
    public Map<Key, SymbolTableItem> items;

    public SymbolTable() {
        this(null);
    }

    public SymbolTable(SymbolTable pre) {
        this.pre = pre;
        this.items = new HashMap<>();
    }

    public static Stack<SymbolTable> getStack() {
        return stack;
    }

    public void put(SymbolTableItem item) throws ItemAlreadyExistsException {
        if (items.containsKey(item.getKey()))
            throw new ItemAlreadyExistsException();
        items.put(item.getKey(), item);
    }

    public List<Declaration> getUnused(){
        List<Declaration> declarations = new ArrayList<>();
        for (Map.Entry<Key, SymbolTableItem> entry : items.entrySet()) {
            if (! (entry.getValue() instanceof DecSymbolTableItem item))
                continue;
            declarations.add(item.getDeclaration());
        }
        return declarations;
    }
    public SymbolTableItem getItem(Key key) throws ItemNotFoundException {
        SymbolTable currentSymbolTable = this;

        while(currentSymbolTable != null) {
            SymbolTableItem symbolTableItem = currentSymbolTable.items.get(key);
            if( symbolTableItem != null ) {
                symbolTableItem.incUsed();
                return symbolTableItem;
            }
            currentSymbolTable = currentSymbolTable.pre;
        }
        throw new ItemNotFoundException();
    }

    public int getItemsSize() {
        return this.items.size();
    }
}
