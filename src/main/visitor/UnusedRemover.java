package main.visitor;

import main.ast.nodes.Program;
import main.ast.nodes.Statement.*;
import main.ast.nodes.declaration.*;
import main.ast.nodes.expr.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.item.FuncDecSymbolTableItem;
import main.symbolTable.utils.Key;

import java.util.ArrayList;
import java.util.List;

/*
 *   Main Changes:
 *       1.create a SymbolTable class to act as our symbol table
 *       2.create some symbolTableItems as the different nodes which are going to be stored in the SymbolTable
 *       3.create a new visitor as our NameAnalyzer
 *       4.add a symbolTable field in program, main, and func_dec AST nodes to store the corresponding symbol table
 * */


public class UnusedRemover extends Visitor<Void>{
    public boolean ok = true;
    @Override
    public Void visit(Program program) {
        List<Declaration> unused = program.get_symbol_table().getUnused();


        List<ExternalDeclaration> decls = new ArrayList<>(program.getExternalDeclarations());
        program.getExternalDeclarations().clear();
        for (ExternalDeclaration ed : decls) {
            if (ed instanceof Declaration && unused.contains(ed)) {
                ok = false;
                continue;
            }
            ed.accept(this);
            program.getExternalDeclarations().add(ed);
        }
        return null;
    }

    @Override
    public Void visit(FunctionDefinition functionDefinition) {


        List<Declaration> unused = functionDefinition.get_symbol_table().getUnused();
        FuncDecSymbolTableItem func_item = null;
        try {
            Key key = new Key(FuncDecSymbolTableItem.START_KEY, functionDefinition.getName(), functionDefinition.getArgDeclarations().size());
            func_item = (FuncDecSymbolTableItem) functionDefinition.get_symbol_table().getItem(key);
        }
        catch(ItemNotFoundException e){
            System.out.println("function not found in the symbol table");
        }
        if (functionDefinition.getDeclarations() != null) {
            int ind = 0;
            for (Declaration declaration : functionDefinition.getArgDeclarations()) {
                if ( unused.contains(declaration)){
                    ok = false;
                    //delete the node:
                    functionDefinition.remove(declaration);
                    //delete from symbol table item:
                    func_item.addRemoved(ind);

                }
                ind++;
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
        return null;
    }


    @Override
    public Void visit(FunctionExpr functionExpr) {

        try {
            if (!SymbolTable.isBuiltIn(functionExpr.getName())) {
                Key key = new Key(FuncDecSymbolTableItem.START_KEY, functionExpr.getName(), functionExpr.getArgumentCount());
                FuncDecSymbolTableItem symbolTableItem = (FuncDecSymbolTableItem)SymbolTable.top.getItem(key);
                List<Integer> removedInds = symbolTableItem.getRemovedArgs();
                functionExpr.removeArgs(removedInds);
            }
        } catch (ItemNotFoundException e) {

            System.out.printf("Line:%d-> %s not declared\n", functionExpr.getLine(), functionExpr.getName());
        }
        if (functionExpr.getArguments() != null) {
            for (Expr arg : functionExpr.getArguments()) {
                arg.accept(this);
            }
        }
        return null;
    }

    public Void visit(CompoundStatement compoundStatement) {

        List<Declaration> unused = compoundStatement.get_symbol_table().getUnused();
        for(Declaration unusedDec :unused){
            ok = false;
            compoundStatement.remove(unusedDec);
        }
        if (compoundStatement.getBlockItems() != null) {
            for (BlockItem bi : compoundStatement.getBlockItems()) {
                bi.accept(this);
            }
        }
        return null;
    }
}
