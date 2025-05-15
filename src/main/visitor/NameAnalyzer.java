package main.visitor;

import main.ast.nodes.Program;
import main.ast.nodes.Stmt.*;
import main.ast.nodes.declaration.FuncDec;
import main.ast.nodes.declaration.Main;
import main.ast.nodes.expr.*;
import main.ast.nodes.expr.primitives.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemAlreadyExistsException;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.item.FuncDecSymbolTableItem;
import main.symbolTable.item.VarDecSymbolTableItem;

/*
*   Main Changes:
*       1.create a SymbolTable class to act as our symbol table
*       2.create some symbolTableItems as the different nodes which are going to be stored in the SymbolTable
*       3.create a new visitor as our NameAnalyzer
*       4.add a symbolTable field in program, main, and func_dec AST nodes to store the corresponding symbol table
* */



public class NameAnalyzer extends Visitor<Void>{

    @Override
    public Void visit(Program program) {
        SymbolTable.top = new SymbolTable();
        SymbolTable.root = SymbolTable.top;

        program.set_symbol_table(SymbolTable.top);

        for (FuncDec funcDec : program.getFuncDecs()) {
            if (funcDec != null) {
                funcDec.accept(this);
            }
        }

        if (program.getMain() != null) {
            program.getMain().accept(this);
        }

        return null;
    }

    @Override
    public Void visit(FuncDec func_dec) {
        FuncDecSymbolTableItem func_dec_item = new FuncDecSymbolTableItem(func_dec);
        try {
            SymbolTable.top.put(func_dec_item);
        } catch (ItemAlreadyExistsException e) {
            System.out.println("Redefinition of function \"" + func_dec.getFuncName() +"\" in line " + func_dec.getLine());
        }


        SymbolTable func_dec_symbol_table = new SymbolTable(SymbolTable.top);
        func_dec.set_symbol_table(func_dec_symbol_table);
        SymbolTable.push(func_dec_symbol_table);

        for (Stmt stmt : func_dec.getStmts()) {
            if (stmt != null) {
                stmt.accept(this);
            }
        }

        SymbolTable.pop();

        return null;
    }

    @Override
    public Void visit(Main main) {
        SymbolTable main_symbol_table = new SymbolTable(SymbolTable.top);
        main.set_symbol_table(main_symbol_table);
        SymbolTable.push(main_symbol_table);

        for (Stmt stmt : main.getStmts()) {
            if (stmt != null) {
                stmt.accept(this);
            }
        }

        SymbolTable.pop();

        return null;
    }

    @Override
    public Void visit(FuncCallStmt func_call_stmt) {
        try {
            SymbolTable.top.getItem(FuncDecSymbolTableItem.START_KEY + func_call_stmt.getFunction().getName());
        } catch (ItemNotFoundException e) {
            System.out.println("Function \"" +func_call_stmt.getFunction().getName() + "\" not declared in line : " + func_call_stmt.getLine());
        }

        return null;
    }

    @Override
    public Void visit(FuncCallExpr func_call_expr) {
        try {
            SymbolTable.top.getItem(FuncDecSymbolTableItem.START_KEY + func_call_expr.getName());
        } catch (ItemNotFoundException e) {
            System.out.println("Function \"" +func_call_expr.getName() + "\" not declared in line : " + func_call_expr.getLine());
        }

        return null;
    }

    @Override
    public Void visit(VarDec var_dec) {


        VarDecSymbolTableItem var_dec_item = new VarDecSymbolTableItem(var_dec);
        try {
            SymbolTable.top.put(var_dec_item);
        } catch (ItemAlreadyExistsException e) {
            System.out.println("Redeclaration of variable \"" + var_dec.getVarName() +"\" in line " + var_dec.getLine());
        }

        return null;
    }

    @Override
    public Void visit(Assign assign) {
        try {
            SymbolTable.top.getItem(VarDecSymbolTableItem.START_KEY + assign.getLeftHand());
        } catch (ItemNotFoundException e) {
            System.out.println("Variable \"" + assign.getLeftHand() + "\" not declared in line : " + assign.getLine());
        }

        if ( assign.getRightHand() != null ) {
            assign.getRightHand().accept(this);
        }

        return null;
    }

    @Override
    public Void visit(IfStmt if_stmt) {
        SymbolTable symbolTable = new SymbolTable(SymbolTable.top);
        if_stmt.setSymbol_table(symbolTable);
        SymbolTable.push(symbolTable);

        if_stmt.getCondition().accept(this);
        if_stmt.getIfBody().accept(this);
        if(if_stmt.getElseBody()!= null){
            if_stmt.getElseBody().accept(this);
        }

        SymbolTable.pop();
        return null;
    }

    @Override
    public Void visit(Return return_stmt) {
        return_stmt.getReturn_value().accept(this);
        return null;
    }

    @Override
    public Void visit(UnaryExpr unary_expr) {
        unary_expr.getOperand().accept(this);
        return null;
    }

    @Override
    public Void visit(BinaryExpr binary_expr) {
        binary_expr.getFirstOperand().accept(this);
        binary_expr.getSecondOperand().accept(this);
        return null;
    }

    @Override
    public Void visit(IntVal int_val) {
        return null;
    }

    @Override
    public Void visit(Identifier the_id) {
        try {
            SymbolTable.top.getItem(VarDecSymbolTableItem.START_KEY + the_id.getName());
        } catch (ItemNotFoundException e) {
            System.out.println("Variable \"" + the_id.getName() + "\" not declared in line : " + the_id.getLine());
        }
        return null;
    }
}
