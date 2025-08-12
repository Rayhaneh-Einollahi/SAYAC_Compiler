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

    public static SymbolTable top;
    public static SymbolTable root;
    private static final Stack<SymbolTable> stack = new Stack<>();
    private static final Set<String> built_in_funcs  = new HashSet<>(Arrays.asList("printf", "scanf"));

    private static int NEXT_ID = 0;
    public SymbolTable pre;
    public Map<Key, SymbolTableItem> items;

    public final int scope_id;

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

    public SymbolTable() {
        this(null);
    }

    public SymbolTable(SymbolTable pre) {
        this.pre = pre;
        this.items = new HashMap<>();
        this.scope_id = NEXT_ID++;
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
            if (!(entry.getValue() instanceof DecSymbolTableItem item))
                continue;
            if (!entry.getValue().isUsed()){
                declarations.add(item.getDeclaration());
            }
        }
        return declarations;
    }

    public SymbolTableItem getItem(Key key) throws ItemNotFoundException {
        SymbolTable currentSymbolTable = this;
        while(currentSymbolTable != null) {
            SymbolTableItem symbolTableItem = currentSymbolTable.items.get(key);
            if (symbolTableItem != null)
                return symbolTableItem;
            currentSymbolTable = currentSymbolTable.pre;
        }
        throw new ItemNotFoundException();
    }

    public SymbolTableItem getItem(Key key, boolean justName) throws ItemNotFoundException {
        if (!justName)
            return getItem(key);

        SymbolTable currentSymbolTable = this;
        while(currentSymbolTable != null) {
            for (Map.Entry<Key, SymbolTableItem> entry : currentSymbolTable.items.entrySet()) {
                if (key.getName().equals(entry.getValue().getKey().getName()))
                    return entry.getValue();
            }
            currentSymbolTable = currentSymbolTable.pre;
        }
        throw new ItemNotFoundException();
    }

    public int getNearestDeclScopeIdByName(String name) throws ItemNotFoundException {
        SymbolTable cur = this;
        while (cur != null) {
            for (SymbolTableItem it : cur.items.values()) {
                if (it.getKey().getName().equals(name)) {
                    return cur.scope_id;
                }
            }
            cur = cur.pre;
        }
        throw new ItemNotFoundException();
    }

    public int getScopeId() {
        return this.scope_id;
    }


    public int getItemsSize() {
        return this.items.size();
    }
}
