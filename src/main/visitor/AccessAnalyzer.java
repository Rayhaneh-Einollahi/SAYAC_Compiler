package main.visitor;

import main.ast.nodes.Program;
import main.ast.nodes.declaration.Declaration;
import main.ast.nodes.declaration.ExternalDeclaration;
import main.ast.nodes.declaration.FunctionDefinition;
import main.ast.nodes.expr.Expr;
import main.ast.nodes.expr.FunctionExpr;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemAlreadyExistsException;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.item.DecSymbolTableItem;
import main.symbolTable.item.FuncDecSymbolTableItem;
import main.symbolTable.item.SymbolTableItem;
import main.symbolTable.utils.Key;

import java.util.*;

public class AccessAnalyzer extends Visitor<Void>{
    public boolean ok = true;
    private static Set<Key> accessedFunctions  = new HashSet<>();
    private static Map<Key, FunctionDefinition> allFunctions  = new HashMap<>();

    private Stack<Key> stack = new Stack<>();

    public static void addAccessedFunction(FunctionDefinition functionDefinition){

    }

    public Void visit(Program program) {

        for (ExternalDeclaration ed : program.getExternalDeclarations()){
            if(!(ed instanceof FunctionDefinition functionDefinition)){
                continue;
            }

            Key key = new Key(FuncDecSymbolTableItem.START_KEY, functionDefinition.getName(), functionDefinition.getArgDeclarations().size());


            if (functionDefinition.getName().equals("main")){
                stack.add(key);
                accessedFunctions.add(key);
            }
            allFunctions.put(key, functionDefinition);
        }

        allFunctions.get(stack.peek()).accept(this);

        for (ExternalDeclaration ed : program.getExternalDeclarations()){
            if(!(ed instanceof FunctionDefinition functionDefinition)){
                continue;
            }

            Key key = new Key(FuncDecSymbolTableItem.START_KEY, functionDefinition.getName(), functionDefinition.getArgDeclarations().size());


            if (!accessedFunctions.contains(key)){
                program.getExternalDeclarations().remove(functionDefinition);
            }
            allFunctions.put(key, functionDefinition);
        }

        return null;
    }
    public Void visit(FunctionExpr functionExpr) {
        Key key = new Key(FuncDecSymbolTableItem.START_KEY, functionExpr.getName(), functionExpr.getArgumentCount());
        if (!accessedFunctions.contains(key)){
            stack.add(key);
            accessedFunctions.add(key);
            allFunctions.get(key).accept(this);
        }


        if (functionExpr.getArguments() != null) {
            for (Expr arg : functionExpr.getArguments()) {
                arg.accept(this);
            }
        }
        return null;
    }
}
