package main.visitor;

import main.ast.nodes.Program;
import main.ast.nodes.Statement.*;
import main.ast.nodes.declaration.*;
import main.ast.nodes.expr.*;
import main.ast.nodes.expr.operator.BinaryOperator;
import main.ast.nodes.expr.primitives.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemAlreadyExistsException;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.item.FuncDecSymbolTableItem;
import main.symbolTable.item.DecSymbolTableItem;
import main.symbolTable.utils.Key;

/*
 *   Main Changes:
 *       1.create a SymbolTable class to act as our symbol table
 *       2.create some symbolTableItems as the different nodes which are going to be stored in the SymbolTable
 *       3.create a new visitor as our NameAnalyzer
 *       4.add a symbolTable field in program, main, and func_dec AST nodes to store the corresponding symbol table
 * */



public class NameAnalyzer extends Visitor<Boolean>{

    @Override
    public Boolean visit(Program program) {
        SymbolTable.top = new SymbolTable();
        SymbolTable.root = SymbolTable.top;

        program.set_symbol_table(SymbolTable.top);
        Boolean ans = true;
        for (ExternalDeclaration ed : program.getExternalDeclarations()){
            ans &= ed.accept(this);
        }
        return ans;
    }

    @Override
    public Boolean visit(FunctionDefinition functionDefinition) {
        Boolean ans = true;
        FuncDecSymbolTableItem func_dec_item = new FuncDecSymbolTableItem(functionDefinition);
        try {
            SymbolTable.top.put(func_dec_item);
        } catch (ItemAlreadyExistsException e) {
            ans = false;
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
                    ans = false;
                    System.out.println("Redeclaration of variable \"" + declaration.getName() + "\" in line " + declaration.getLine());
                }
            }
        }


//        if (functionDefinition.getDeclarator() != null){
//            functionDefinition.getDeclarator().accept(this);
//        }

        if (functionDefinition.getDeclarations() != null){
            for (Declaration ds: functionDefinition.getDeclarations()){
                ans &= ds.accept(this);
            }
        }
        if (functionDefinition.getBody() != null){
            ans &= functionDefinition.getBody().accept(this);
        }
        SymbolTable.pop();
        return ans;
    }


    @Override
    public Boolean visit(FunctionExpr functionExpr) {
        Boolean ans = true;
        try {
            if (!SymbolTable.isBuiltIn(functionExpr.getName())) {
                SymbolTable.top.getItem(new Key(FuncDecSymbolTableItem.START_KEY, functionExpr.getName(), functionExpr.getArgumentCount()));
            }
        } catch (ItemNotFoundException e) {
            ans = false;
            System.out.printf("Line:%d-> %s not declared\n", functionExpr.getLine(), functionExpr.getName());
        }

        if (functionExpr.getArguments() != null) {
            for (Expr arg : functionExpr.getArguments()) {
                ans &= arg.accept(this);
            }
        }
        return ans;
    }

    @Override
    public Boolean visit(Declaration declaration) {
        Boolean ans = true;
        DecSymbolTableItem var_dec_item = new DecSymbolTableItem(declaration);
        try {
            SymbolTable.top.put(var_dec_item);
        } catch (ItemAlreadyExistsException e) {
            ans = false;
            System.out.println("Redeclaration of variable \"" + declaration.getName() + "\" in line " + declaration.getLine());
        }
        if (declaration.getDeclarationSpecifiers() != null) {
            for (StringVal ds : declaration.getDeclarationSpecifiers()) {
                ans &= ds.accept(this);
            }
        }
        if (declaration.getInitDeclarators() != null) {
            for (InitDeclarator id : declaration.getInitDeclarators()) {
                ans &= id.accept(this);
            }
        }
        return ans;
    }

    @Override
    public Boolean visit(BinaryExpr binaryExpr) {
        Boolean ans = true;
        if (binaryExpr.getFirstOperand() != null) {
            ans &= binaryExpr.getFirstOperand().accept(this);
        }
        if (binaryExpr.getSecondOperand() != null) {
            ans &= binaryExpr.getSecondOperand().accept(this);
        }
        return ans;
    }

    @Override
    public Boolean visit(Identifier identifier) {
        Boolean ans = true;
        try {
            SymbolTable.top.getItem(new Key(DecSymbolTableItem.START_KEY, identifier.getName()));
        } catch (ItemNotFoundException e) {
            ans = false;
            System.out.printf("Line:%d-> %s not declared\n", identifier.getLine(), identifier.getName() );
        }
        return ans;
    }

    public Boolean visit(BlockItem blockItem) {
        Boolean ans = true;
        if (blockItem.getStatement() != null) {
            ans &= blockItem.getStatement().accept(this);
        }
        if (blockItem.getDeclaration() != null) {
            ans &= blockItem.getDeclaration().accept(this);
        }
        return ans;
    }

    public Boolean visit(CompoundStatement compoundStatement) {
        Boolean ans = true;
        SymbolTable new_symbol_table = new SymbolTable(SymbolTable.top);
        compoundStatement.set_symbol_table(new_symbol_table);
        SymbolTable.push(new_symbol_table);

        if (compoundStatement.getBlockItems() != null) {
            for (BlockItem bi : compoundStatement.getBlockItems()) {
                ans &= bi.accept(this);
            }
        }
        SymbolTable.pop();
        return ans;
    }

    public Boolean visit(ExpressionStatement expressionStatement) {
        Boolean ans = true;
        if (expressionStatement.getExpr() != null) {
            ans &= expressionStatement.getExpr().accept(this);
        }
        return ans;
    }

    public Boolean visit(ForCondition forCondition) {
        Boolean ans = true;
        if (forCondition.getForDeclaration() != null) {
            ans &= forCondition.getForDeclaration().accept(this);
        }
        if (forCondition.getExpr() != null) {
            ans &= forCondition.getExpr().accept(this);
        }
        if (forCondition.getConditions() != null) {
            for (Expr condition : forCondition.getConditions()) {
                ans &= condition.accept(this);
            }
        }
        if (forCondition.getSteps() != null) {
            for (Expr step : forCondition.getSteps()) {
                ans &= step.accept(this);
            }
        }
        return ans;
    }

    public Boolean visit(ForDeclaration forDeclaration) {
        Boolean ans = true;
        if (forDeclaration.getDeclarationSpecifiers() != null) {
            for (StringVal ds : forDeclaration.getDeclarationSpecifiers()) {
                ans &= ds.accept(this);
            }
        }
        if (forDeclaration.getInitDeclarators() != null) {
            for (InitDeclarator id : forDeclaration.getInitDeclarators()) {
                ans &= id.accept(this);
            }
        }
        return ans;
    }

    public Boolean visit(IterationStatement iterationStatement) {
        Boolean ans = true;
        if (iterationStatement.getCondition() != null) {
            ans &= iterationStatement.getCondition().accept(this);
        }
        if (iterationStatement.getBody() != null) {
            ans &= iterationStatement.getBody().accept(this);
        }
        if (iterationStatement.getForCondition() != null) {
            ans &= iterationStatement.getForCondition().accept(this);
        }
        return ans;
    }


    public Boolean visit(JumpStatement jumpStatement) {
        Boolean ans = true;
        if (jumpStatement.getExpr() != null) {
            ans &= jumpStatement.getExpr().accept(this);
        }
        if (jumpStatement.getCommand() != null) {
            ans &= jumpStatement.getCommand().accept(this);
        }
        return ans;
    }

    public Boolean visit(SelectionStatement selectionStatement) {
//        System.out.print("Line ");
//        System.out.print(selectionStatement.getLine());
//        System.out.print(": Stmt selection = ");
//        System.out.println(selectionStatement.getIfStatement().getStatementCount());
//
//        if (selectionStatement.getElseStatement()!=null && !(selectionStatement.getElseStatement() instanceof SelectionStatement)) {
//            System.out.print("Line ");
//            System.out.print(selectionStatement.getElseStatement().getLine());
//            System.out.print(": Stmt selection = ");
//            System.out.println(selectionStatement.getElseStatement().getStatementCount());
//        }
        Boolean ans = true;
        if (selectionStatement.getCondition() != null) {
            ans &= selectionStatement.getCondition().accept(this);
        }
        if (selectionStatement.getIfStatement() != null) {
            ans &= selectionStatement.getIfStatement().accept(this);
        }
        if (selectionStatement.getElseStatement() != null) {
            ans &= selectionStatement.getElseStatement().accept(this);
        }
        return ans;
    }



    public Boolean visit(ArrayExpr arrayExpr) {
        Boolean ans = true;
        if (arrayExpr.getOutside() != null) {
            ans &= arrayExpr.getOutside().accept(this);
        }
        if (arrayExpr.getInside() != null) {
            ans &= arrayExpr.getInside().accept(this);
        }
        return ans;
    }


    public Boolean visit(CastExpr castExpr) {
        Boolean ans = true;
        if (castExpr.getTypename() != null) {
            ans &= castExpr.getTypename().accept(this);
        }
        if (castExpr.getCastExpr() != null) {
            ans &= castExpr.getCastExpr().accept(this);
        }
        return ans;
    }

    public Boolean visit(CommaExpr commaExpr) {
        Boolean ans = true;
        if (commaExpr.getExpressions() != null) {
            for (Expr expr : commaExpr.getExpressions()) {
                ans &= expr.accept(this);
            }
        }
        return ans;
    }

    public Boolean visit(ConstantExpr constantExpr) {
        Boolean ans = true;
        if (constantExpr.getStr() != null) {
            ans &= constantExpr.getStr().accept(this);
        }
        return ans;
    }




    public Boolean visit(IniListExpr iniListExpr) {
        Boolean ans = true;
        if (iniListExpr.getTypename() != null) {
            ans &= iniListExpr.getTypename().accept(this);
        }
        if (iniListExpr.getInitializerList() != null) {
            ans &= iniListExpr.getInitializerList().accept(this);
        }
        return ans;
    }

    public Boolean visit(SizeofTypeExpr sizeofTypeExpr) {
        Boolean ans = true;
        if (sizeofTypeExpr.getTypename() != null) {
            ans &= sizeofTypeExpr.getTypename().accept(this);
        }
        return ans;
    }

    public Boolean visit(StringExpr stringExpr) {
//        System.out.print("Line ");
//        System.out.print(stringExpr.getLine());
//        System.out.println(": Expr string" );
        if (stringExpr.getStrings() != null) {
            for (StringVal str : stringExpr.getStrings()) {
                if (str != null) {
                    str.accept(this);
                }
            }
        }
        return null;
    }

    public Boolean visit(TernaryExpr ternaryExpr) {

        if (ternaryExpr.getFirstOperand() != null) {
            ternaryExpr.getFirstOperand().accept(this);
        }
        if (ternaryExpr.getSecondOperand() != null) {
            ternaryExpr.getSecondOperand().accept(this);
        }
        if (ternaryExpr.getThirdOperand() != null) {
            ternaryExpr.getThirdOperand().accept(this);
        }
        return null;
    }

    public Boolean visit(UnaryExpr unaryExpr) {

        unaryExpr.getOperand().accept(this);
        return null;
    }




    public Boolean visit(Declarator declarator) {
        if (declarator.getPointer() != null) {
            declarator.getPointer().accept(this);
        }
        if (declarator.getDirectDeclarator() != null) {
            declarator.getDirectDeclarator().accept(this);
        }
        return null;
    }

    public Boolean visit(Designation designation) {
        if (designation.getDesignators() != null) {
            for (Designator designator : designation.getDesignators()) {
                if (designator != null) {
                    designator.accept(this);
                }
            }
        }
        return null;
    }

    public Boolean visit(Designator designator) {
        if (designator.getExpr() != null) {
            designator.getExpr().accept(this);
        }
        if (designator.getIdentifier() != null) {
            designator.getIdentifier().accept(this);
        }
        return null;
    }

    public Boolean visit(DirectDeclarator directDeclarator) {
        if (directDeclarator.getIdentifier() != null) {
            directDeclarator.getIdentifier().accept(this);
        }
        if (directDeclarator.getInnerDeclarator() != null) {
            directDeclarator.getInnerDeclarator().accept(this);
        }
        if (directDeclarator.getSteps() != null) {
            for (DirectDeclarator.DDStep step : directDeclarator.getSteps()) {
                if (step != null) {
                    switch (step.kind) {
                        case ARRAY:
                            if (step.arrayExpr != null) {
                                step.arrayExpr.accept(this);
                            }
                            break;
                        case FUNCTION_P:
                            if (step.params != null) {
                                for (Parameter param : step.params) {
                                    if (param != null) {
                                        param.accept(this);
                                    }
                                }
                            }
                            break;
                        case FUNCTION_I:
                            if (step.identifiers != null) {
                                for (Identifier id : step.identifiers) {
                                    if (id != null) {
                                        id.accept(this);
                                    }
                                }
                            }
                            break;
                    }
                }
            }
        }
        return null;
    }

    public Boolean visit(InitDeclarator initDeclarator) {
        if (initDeclarator.getDeclarator() != null) {
            initDeclarator.getDeclarator().accept(this);
        }
        if (initDeclarator.getInitializer() != null) {
            initDeclarator.getInitializer().accept(this);
        }
        return null;
    }

    public Boolean visit(Initializer initializer) {
        if (initializer.getExpr() != null) {
            initializer.getExpr().accept(this);
        }
        if (initializer.getInitializerlist() != null) {
            initializer.getInitializerlist().accept(this);
        }
        if (initializer.getDesignation() != null) {
            initializer.getDesignation().accept(this);
        }
        return null;
    }

    public Boolean visit(InitializerList initializerList) {
        if (initializerList.getList() != null) {
            for (InitializerList.Pair p : initializerList.getList()) {
                if (p != null) {
                    if (p.designation() != null) {
                        p.designation().accept(this);
                    }
                    if (p.initializer() != null) {
                        p.initializer().accept(this);
                    }
                }
            }
        }
        return null;
    }

    public Boolean visit(Parameter parameter) {
        if (parameter.getDeclarationSpecifiers() != null) {
            for (StringVal specifier : parameter.getDeclarationSpecifiers()) {
                if (specifier != null) {
                    specifier.accept(this);
                }
            }
        }
        if (parameter.getDeclarator() != null) {
            parameter.getDeclarator().accept(this);
        }
        return null;
    }

    public Boolean visit(Typename typename) {
        if (typename.getSpecifierQualifiers() != null) {
            for (StringVal specQual : typename.getSpecifierQualifiers()) {
                if (specQual != null) {
                    specQual.accept(this);
                }
            }
        }
        if (typename.getDeclarator() != null) {
            typename.getDeclarator().accept(this);
        }
        return null;
    }
}
