package main.visitor;

import main.ast.nodes.Program;
import main.ast.nodes.Statement.*;
import main.ast.nodes.declaration.*;
import main.ast.nodes.expr.*;

import java.util.ArrayList;
import java.util.List;

/*
 *   Main Changes:
 *       1.create a SymbolTable class to act as our symbol table
 *       2.create some symbolTableItems as the different nodes which are going to be stored in the SymbolTable
 *       3.create a new visitor as our NameAnalyzer
 *       4.add a symbolTable field in program, main, and func_dec AST nodes to store the corresponding symbol table
 * */


public class DeadStmtRemover extends Visitor<Void>{
    public boolean ok = true;

    public Void visit(CompoundStatement compoundStatement) {
        if (compoundStatement.getBlockItems() != null) {
            List<BlockItem> original = compoundStatement.getBlockItems();
            List<BlockItem> filtered = new ArrayList<>();

            for (BlockItem bi : original) {
                if (bi.getStatement() instanceof ExpressionStatement es) {
                    if (es.getExpr().isDead()) {
                        continue;
                    }
                }

                bi.accept(this);
                filtered.add(bi);

                if (bi.getStatement() instanceof JumpStatement) {
                    break;
                }
            }

            original.clear();
            original.addAll(filtered);
        }
        return null;
    }
}
