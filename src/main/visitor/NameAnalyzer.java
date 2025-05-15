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
            System.out.println("Redefinition of function \"" + functionDefinition.getName() +"\" in line " + functionDefinition.getLine());
        }


        SymbolTable func_dec_symbol_table = new SymbolTable(SymbolTable.top);
        functionDefinition.set_symbol_table(func_dec_symbol_table);
        SymbolTable.push(func_dec_symbol_table);

//        if (functionDefinition.getDeclarator() != null){
//            functionDefinition.getDeclarator().accept(this);
//        }
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
            SymbolTable.top.getItem(FuncDecSymbolTableItem.START_KEY + functionExpr.getName());
        } catch (ItemNotFoundException e) {
            System.out.println("Function \"" +functionExpr.getName() + "\" not declared in line : " + functionExpr.getLine());
        }

//        if (functionExpr.getOutside() != null) {
//            functionExpr.getOutside().accept(this);
//        }
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
            System.out.println("Redeclaration of variable \"" + declaration.getName() +"\" in line " + declaration.getLine());
        }
        if (declaration.getDeclarationSpecifiers() != null){
            for (StringVal ds: declaration.getDeclarationSpecifiers()){
                ds.accept(this);
            }
        }
        if (declaration.getInitDeclarators() != null){
            for (InitDeclarator id: declaration.getInitDeclarators()){
                id.accept(this);
            }
        }

        return null;
    }

    @Override
    public Void visit(BinaryExpr binaryExpr) {

        if (binaryExpr.getOperator() == BinaryOperator.ASSIGN){
            try {
                SymbolTable.top.getItem(DecSymbolTableItem.START_KEY + binaryExpr.getFirstOperand().getName());
            } catch (ItemNotFoundException e) {
                System.out.println("Variable \"" + binaryExpr.getFirstOperand().getName() + "\" not declared in line : " + binaryExpr.getLine());
            }
        }


        if (binaryExpr.getFirstOperand() != null) {
            binaryExpr.getFirstOperand().accept(this);
        }
        if (binaryExpr.getSecondOperand() != null) {
            binaryExpr.getSecondOperand().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(Identifier identifier) {
        try {
            SymbolTable.top.getItem(DecSymbolTableItem.START_KEY + identifier.getName());
        } catch (ItemNotFoundException e) {
            System.out.println("Variable \"" + identifier.getName() + "\" not declared in line : " + identifier.getLine());
        }
        return null;
    }



    public Void visit(BlockItem blockItem) {
        if (blockItem.getStatement() != null) {
            blockItem.getStatement().accept(this);
        }
        if (blockItem.getDeclaration() != null) {
            blockItem.getDeclaration().accept(this);
        }
        return null;
    }

    public Void visit(CompoundStatement compoundStatement) {
        if (compoundStatement.getBlockItems() != null) {
            for (BlockItem bi : compoundStatement.getBlockItems()) {
                bi.accept(this);
            }
        }
//        System.out.println(compoundStatement.getBlockItems().size());
        return null;
    }

    public Void visit(ExpressionStatement expressionStatement) {
        if (expressionStatement.getExpr() != null) {
            expressionStatement.getExpr().accept(this);
        }
        return null;
    }

    public Void visit(ForCondition forCondition) {
        if (forCondition.getForDeclaration() != null) {
            forCondition.getForDeclaration().accept(this);
        }
        if (forCondition.getExpr() != null) {
            forCondition.getExpr().accept(this);
        }
        if (forCondition.getConditions() != null) {
            for (Expr condition : forCondition.getConditions()) {
                condition.accept(this);
            }
        }
        if (forCondition.getSteps() != null) {
            for (Expr step : forCondition.getSteps()) {
                step.accept(this);
            }
        }
        return null;
    }

    public Void visit(ForDeclaration forDeclaration) {
        if (forDeclaration.getDeclarationSpecifiers() != null) {
            for (StringVal ds : forDeclaration.getDeclarationSpecifiers()) {
                ds.accept(this);
            }
        }
        if (forDeclaration.getInitDeclarators() != null) {
            for (InitDeclarator id : forDeclaration.getInitDeclarators()) {
                id.accept(this);
            }
        }
        return null;
    }


    public Void visit(IterationStatement iterationStatement) {
//        System.out.print("Line ");
//        System.out.print(iterationStatement.getLine());
//        String kind;
//        if(iterationStatement.getKind() == IterationStatement.Kind.FOR)
//            kind = "for";
//        else if(iterationStatement.getKind() == IterationStatement.Kind.WHILE)
//            kind = "while";
//        else
//            kind = "do-while";
//
//        System.out.print(": Stmt " + kind + " = ");
//        System.out.println(iterationStatement.getBody().getStatementCount());

        if (iterationStatement.getCondition() != null) {
            iterationStatement.getCondition().accept(this);
        }
        if (iterationStatement.getBody() != null) {
            iterationStatement.getBody().accept(this);
        }
        if (iterationStatement.getForCondition() != null) {
            iterationStatement.getForCondition().accept(this);
        }
        return null;
    }

    public Void visit(JumpStatement jumpStatement) {
        if (jumpStatement.getExpr() != null) {
            jumpStatement.getExpr().accept(this);
        }
        if (jumpStatement.getCommand() != null) {
            jumpStatement.getCommand().accept(this);
        }
        return null;
    }

    public Void visit(SelectionStatement selectionStatement) {
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

        if (selectionStatement.getCondition() != null) {
            selectionStatement.getCondition().accept(this);
        }
        if (selectionStatement.getIfStatement() != null) {
            selectionStatement.getIfStatement().accept(this);
        }
        if (selectionStatement.getElseStatement() != null) {
            selectionStatement.getElseStatement().accept(this);
        }
        return null;
    }



    public Void visit(ArrayExpr arrayExpr) {
        if (arrayExpr.getOutside() != null) {
            arrayExpr.getOutside().accept(this);
        }
        if (arrayExpr.getInside() != null) {
            arrayExpr.getInside().accept(this);
        }
        return null;
    }


    public Void visit(CastExpr castExpr) {
        if (castExpr.getTypename() != null) {
            castExpr.getTypename().accept(this);
        }
        if (castExpr.getCastExpr() != null) {
            castExpr.getCastExpr().accept(this);
        }
        return null;
    }

    public Void visit(CommaExpr commaExpr) {
//        if (commaExpr.getExpressions() != null) {
//            for (Expr expr : commaExpr.getExpressions()) {
//                expr.accept(this);
//            }
//        }
        return null;
    }

    public Void visit(ConstantExpr constantExpr) {
//        if (constantExpr.getStr() != null) {
//            constantExpr.getStr().accept(this);
//        }
        return null;
    }




    public Void visit(IniListExpr iniListExpr) {
//        if (iniListExpr.getTypename() != null) {
//            iniListExpr.getTypename().accept(this);
//        }
//        if (iniListExpr.getInitializerList() != null) {
//            iniListExpr.getInitializerList().accept(this);
//        }
        return null;
    }

    public Void visit(SizeofTypeExpr sizeofTypeExpr) {

//        if (sizeofTypeExpr.getTypename() != null) {
//            sizeofTypeExpr.getTypename().accept(this);
//        }
        return null;
    }

    public Void visit(StringExpr stringExpr) {
//        System.out.print("Line ");
//        System.out.print(stringExpr.getLine());
//        System.out.println(": Expr string" );
//        if (stringExpr.getStrings() != null) {
//            for (StringVal str : stringExpr.getStrings()) {
//                if (str != null) {
//                    str.accept(this);
//                }
//            }
//        }
        return null;
    }

    public Void visit(TernaryExpr ternaryExpr) {

//        if (ternaryExpr.getFirstOperand() != null) {
//            ternaryExpr.getFirstOperand().accept(this);
//        }
//        if (ternaryExpr.getSecondOperand() != null) {
//            ternaryExpr.getSecondOperand().accept(this);
//        }
//        if (ternaryExpr.getThirdOperand() != null) {
//            ternaryExpr.getThirdOperand().accept(this);
//        }
        return null;
    }

    public Void visit(UnaryExpr unaryExpr) {

//        unaryExpr.getOperand().accept(this);
        return null;
    }




    public Void visit(Declarator declarator) {
        if (declarator.getPointer() != null) {
            declarator.getPointer().accept(this);
        }
        if (declarator.getDirectDeclarator() != null) {
            declarator.getDirectDeclarator().accept(this);
        }
        return null;
    }

    public Void visit(Designation designation) {
        if (designation.getDesignators() != null) {
            for (Designator designator : designation.getDesignators()) {
                if (designator != null) {
                    designator.accept(this);
                }
            }
        }
        return null;
    }

    public Void visit(Designator designator) {
        if (designator.getExpr() != null) {
            designator.getExpr().accept(this);
        }
        if (designator.getIdentifier() != null) {
            designator.getIdentifier().accept(this);
        }
        return null;
    }

    public Void visit(DirectDeclarator directDeclarator) {
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

    public Void visit(InitDeclarator initDeclarator) {
        if (initDeclarator.getDeclarator() != null) {
            initDeclarator.getDeclarator().accept(this);
        }
        if (initDeclarator.getInitializer() != null) {
            initDeclarator.getInitializer().accept(this);
        }
        return null;
    }

    public Void visit(Initializer initializer) {
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

    public Void visit(InitializerList initializerList) {
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

    public Void visit(Parameter parameter) {
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

    public Void visit(Typename typename) {
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
