package main.visitor;

import main.ast.nodes.Program;
import main.ast.nodes.Statement.*;
import main.ast.nodes.declaration.*;
import main.ast.nodes.expr.*;
import main.ast.nodes.expr.primitives.StringVal;

import java.util.Iterator;
import java.util.List;

/*
 *   Main Changes:
 *       1.create a SymbolTable class to act as our symbol table
 *       2.create some symbolTableItems as the different nodes which are going to be stored in the SymbolTable
 *       3.create a new visitor as our NameAnalyzer
 *       4.add a symbolTable field in program, main, and func_dec AST nodes to store the corresponding symbol table
 * */


public class DefRemover extends Visitor<Void>{
    public boolean ok = true;

    public Void visit(Program program) {
        Iterator<ExternalDeclaration> iterator = program.getExternalDeclarations().iterator();
        while (iterator.hasNext()) {
            ExternalDeclaration bi = iterator.next();
            if (!(bi instanceof Declaration declaration))
                continue;
            String name = declaration.getDeclarationSpecifiers().getFirst().getName();
            if (name.equals("typedef") || name.equals("const")) {
                iterator.remove();
                continue;
            }
            bi.accept(this);
        }
        return null;
    }
    public Void visit(CompoundStatement compoundStatement) {
        if (compoundStatement.getBlockItems() != null) {
            Iterator<BlockItem> iterator = compoundStatement.getBlockItems().iterator();
            while (iterator.hasNext()) {
                BlockItem bi = iterator.next();
                Declaration declaration = bi.getDeclaration();
                if (declaration != null) {
                    String name = declaration.getDeclarationSpecifiers().getFirst().getName();
                    if (name.equals("typedef") || name.equals("const")) {
                        iterator.remove();
                        continue;
                    }
                }
                bi.accept(this);
            }

        }
        return null;
    }
}
