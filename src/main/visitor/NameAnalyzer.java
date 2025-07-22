package main.visitor;

import main.ast.nodes.Program;
import main.ast.nodes.Statement.*;
import main.ast.nodes.declaration.*;
import main.ast.nodes.expr.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemAlreadyExistsException;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.item.FuncDecSymbolTableItem;
import main.symbolTable.item.DecSymbolTableItem;
import main.symbolTable.item.SymbolTableItem;
import main.symbolTable.utils.Key;

/*
 *   Main Changes:
 *       1.create a SymbolTable class to act as our symbol table
 *       2.create some symbolTableItems as the different nodes which are going to be stored in the SymbolTable
 *       3.create a new visitor as our NameAnalyzer
 *       4.add a symbolTable field in program, main, and func_dec AST nodes to store the corresponding symbol table
 * */



public class NameAnalyzer extends Visitor<Void>{
    public boolean ok = true;

    @Override
    public Void visit(Program program) {
        SymbolTable.top = new SymbolTable();
        SymbolTable.root = SymbolTable.top;

        program.set_symbol_table(SymbolTable.top);
        
        for (ExternalDeclaration ed : program.getExternalDeclarations()){
            ed.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(FunctionDefinition functionDefinition) {
        
        FuncDecSymbolTableItem func_dec_item = new FuncDecSymbolTableItem(functionDefinition);
        try {
            SymbolTable.top.put(func_dec_item);
        } catch (ItemAlreadyExistsException e) {
            ok = false;
            System.out.println("Redefinition of function \"" + functionDefinition.getName() +"\" in line " + functionDefinition.getLine());
        }

        SymbolTable new_symbol_table = new SymbolTable(SymbolTable.top);
        functionDefinition.set_symbol_table(new_symbol_table);
        SymbolTable.push(new_symbol_table);
        if (functionDefinition.getDeclarations() != null) {
            for (Declaration declaration : functionDefinition.getArgDeclarations()) {
                DecSymbolTableItem var_dec_item = new DecSymbolTableItem(declaration);
                try {
                    SymbolTable.top.put(var_dec_item);
                } catch (ItemAlreadyExistsException e) {
                    ok = false;
                    System.out.println("Redeclaration of variable \"" + declaration.getName() + "\" in line " + declaration.getLine());
                }
            }
        }



        if (functionDefinition.getDeclarator() != null){
            functionDefinition.getDeclarator().accept(this);
        }

        if (functionDefinition.getDeclarations() != null){
            for (Declaration ds: functionDefinition.getDeclarations()){
                ds.accept(this);
            }
        }
        if (functionDefinition.getBody() != null){
            functionDefinition.getBody().accept(this);
        }
        SymbolTable.pop();
        return null;
    }


    @Override
    public Void visit(FunctionExpr functionExpr) {
        
        try {
            if (!SymbolTable.isBuiltIn(functionExpr.getName())) {
                SymbolTable.top.getItem(new Key(FuncDecSymbolTableItem.START_KEY, functionExpr.getName(), functionExpr.getArgumentCount()));
            }
        } catch (ItemNotFoundException e) {
            ok = false;
            System.out.printf("Line:%d-> %s not declared\n", functionExpr.getLine(), functionExpr.getName());
        }

        if (functionExpr.getArguments() != null) {
            for (Expr arg : functionExpr.getArguments()) {
                arg.accept(this);
            }
        }
        return null;
    }

    @Override
    public Void visit(Declaration declaration) {
        
        DecSymbolTableItem var_dec_item = new DecSymbolTableItem(declaration);
        try {
            SymbolTable.top.put(var_dec_item);
        } catch (ItemAlreadyExistsException e) {
            ok = false;
            System.out.println("Redeclaration of variable \"" + declaration.getName() + "\" in line " + declaration.getLine());
        }
        if (declaration.getInitDeclarators() != null) {
            for (InitDeclarator id : declaration.getInitDeclarators()) {
                id.accept(this);
            }
        }
        return null;
    }

    @Override
    public Void visit(Identifier identifier) {
        
        try {
            SymbolTableItem symbolTableItem = SymbolTable.top.getItem(new Key(DecSymbolTableItem.START_KEY, identifier.getName()), true);
            symbolTableItem.incUsed();
        } catch (ItemNotFoundException e) {
            ok = false;
            System.out.printf("Line:%d-> %s not declared\n", identifier.getLine(), identifier.getName() );
        }
        return null;
    }

    public Void visit(CompoundStatement compoundStatement) {

        SymbolTable new_symbol_table = new SymbolTable(SymbolTable.top);
        compoundStatement.set_symbol_table(new_symbol_table);
        SymbolTable.push(new_symbol_table);

        if (compoundStatement.getBlockItems() != null) {
            for (BlockItem bi : compoundStatement.getBlockItems()) {
                bi.accept(this);
            }
        }
        SymbolTable.pop();
        return null;
    }
}
