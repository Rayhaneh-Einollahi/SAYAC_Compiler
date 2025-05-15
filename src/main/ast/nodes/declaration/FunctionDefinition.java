package main.ast.nodes.declaration;

import main.ast.nodes.Statement.CompoundStatement;
import main.ast.nodes.expr.primitives.StringVal;
import main.symbolTable.SymbolTable;
import main.visitor.IVisitor;

import java.util.List;

public class FunctionDefinition extends ExternalDeclaration {
    private final List<StringVal> declarationSpecifiers;
    private final Declarator declarator;
    private final List<Declaration> declarations;
    private final CompoundStatement body;
    private String functionName;
    private SymbolTable symbol_table;

    public SymbolTable get_symbol_table() {return symbol_table;}
    public void set_symbol_table(SymbolTable symbol_table) {this.symbol_table = symbol_table;}

    public FunctionDefinition(
            List<StringVal> declarationSpecifiers,
            Declarator declarator,
            List<Declaration> declarations,
            CompoundStatement body) {
        this.declarationSpecifiers = declarationSpecifiers;
        this.declarator = declarator;
        this.declarations = declarations;
        this.body = body;
    }

    public String getName(){
        if (this.functionName == null){
            this.functionName = this.declarator.getName();
        }
        return functionName;
    }


    public List<StringVal> getDeclarationSpecifiers() {
        return declarationSpecifiers;
    }
    public Declarator getDeclarator() {
        return declarator;
    }

    public CompoundStatement getBody() {
        return body;
    }

    public List<Declaration> getDeclarations() {
        return declarations;
    }


    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
