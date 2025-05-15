package main.ast.nodes.Stmt;

import main.ast.nodes.expr.Expr;
import main.symbolTable.SymbolTable;
import main.visitor.IVisitor;

public class IfStmt extends Stmt {
    private Stmt ifBody;
    private Stmt elseBody;
    private Expr condition;

    public SymbolTable getSymbol_table() {
        return symbol_table;
    }

    public void setSymbol_table(SymbolTable symbol_table) {
        this.symbol_table = symbol_table;
    }

    private SymbolTable symbol_table;

    public IfStmt(Expr expr) {
        this.condition = expr;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Stmt getIfBody() {
        return ifBody;
    }

    public void setIfBody(Stmt ifBody) {
        this.ifBody = ifBody;
    }

    public Stmt getElseBody() {
        return elseBody;
    }

    public void setElseBody(Stmt elseBody) {
        this.elseBody = elseBody;
    }

    public Expr getCondition() {
        return condition;
    }

    public void setCondition(Expr condition) {
        this.condition = condition;
    }
}
