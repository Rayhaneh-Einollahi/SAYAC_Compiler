package main.visitor;

import main.ast.nodes.*;
import main.ast.nodes.Statement.*;
import main.ast.nodes.Statement.IterationStatement.*;
import main.ast.nodes.declaration.*;
import main.ast.nodes.expr.*;
import main.ast.nodes.expr.primitives.*;


/*GOALs:
 *   1. print out scope changes each time a new scope starts
 *   2. print the identifier if it is initialized
 *   3. print the identifier if it is used
 *   4. print out the name of the function when it is defined
 *   5. print out the name of the function when it is used
 *
 * */


public class TestVisitor extends Visitor<Void>{
    @Override
    public Void visit(Program program) {
        for (ExternalDeclaration ed : program.getExternalDeclarations()){
            ed.accept(this);
        }
        return null;
    }

    public Void visit(FunctionDefinition functionDefinition) {
        System.out.print("Line ");
        System.out.print(functionDefinition.getLine());
        System.out.print(": Stmt function "+functionDefinition.getName() + " = ");
        System.out.println(functionDefinition.getBody().getStatementCount() + " " + functionDefinition.getArgDeclarations().size());

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
        if (forCondition.getDeclaration() != null) {
            forCondition.getDeclaration().accept(this);
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

    public Void visit(ForStatement forStatement){
        System.out.print("Line ");
        System.out.print(forStatement.getLine());
        System.out.print(": Stmt for = ");
        System.out.println(forStatement.getBody().getStatementCount());
        if (forStatement.getForCondition() != null) {
            forStatement.getForCondition().accept(this);
        }
        if (forStatement.getBody() != null) {
            forStatement.getBody().accept(this);
        }
        return null;
    }

    public Void visit(WhileStatement whileStatement){
        System.out.print("Line ");
        System.out.print(whileStatement.getLine());
        System.out.print(": Stmt while = ");
        System.out.println(whileStatement.getBody().getStatementCount());
        if (whileStatement.getCondition() != null) {
            whileStatement.getCondition().accept(this);
        }
        if (whileStatement.getBody() != null) {
            whileStatement.getBody().accept(this);
        }
        return null;
    }

    public Void visit(DoWhileStatement doWhileStatement){
        System.out.print("Line ");
        System.out.print(doWhileStatement.getLine());
        System.out.print(": Stmt do-while = ");
        System.out.println(doWhileStatement.getBody().getStatementCount());
        if (doWhileStatement.getCondition() != null) {
            doWhileStatement.getCondition().accept(this);
        }
        if (doWhileStatement.getBody() != null) {
            doWhileStatement.getBody().accept(this);
        }

        return null;
    }


    public Void visit(SelectionStatement selectionStatement) {
        System.out.print("Line ");
        System.out.print(selectionStatement.getLine());
        System.out.print(": Stmt selection = ");
        System.out.println(selectionStatement.getIfStatement().getStatementCount());

        if (selectionStatement.getElseStatement()!=null && !(selectionStatement.getElseStatement() instanceof SelectionStatement)) {
            System.out.print("Line ");
            System.out.print(selectionStatement.getElseStatement().getLine());
            System.out.print(": Stmt selection = ");
            System.out.println(selectionStatement.getElseStatement().getStatementCount());
        }

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
        System.out.print("Line ");
        System.out.print(arrayExpr.getLine());
        System.out.println(": Expr Array");
        if (arrayExpr.getOutside() != null) {
            arrayExpr.getOutside().accept(this);
        }
        if (arrayExpr.getInside() != null) {
            arrayExpr.getInside().accept(this);
        }
        return null;
    }

    public Void visit(BinaryExpr binaryExpr) {
        System.out.print("Line ");
        System.out.print(binaryExpr.getLine());
        System.out.println(": Expr "+binaryExpr.getOperator().getSymbol() );
        if (binaryExpr.getFirstOperand() != null) {
            binaryExpr.getFirstOperand().accept(this);
        }
        if (binaryExpr.getSecondOperand() != null) {
            binaryExpr.getSecondOperand().accept(this);
        }
        return null;
    }

    public Void visit(CastExpr castExpr) {
        System.out.print("Line ");
        System.out.print(castExpr.getLine());
        System.out.println(": Expr castExpr");
        if (castExpr.getTypename() != null) {
            castExpr.getTypename().accept(this);
        }
        if (castExpr.getCastExpr() != null) {
            castExpr.getCastExpr().accept(this);
        }
        return null;
    }

    public Void visit(CommaExpr commaExpr) {
//        System.out.print("Line ");
//        System.out.print(commaExpr.getLine());
//        System.out.println(": Expr ,");
        if (commaExpr.getExpressions() != null) {
            for (Expr expr : commaExpr.getExpressions()) {
                expr.accept(this);
            }
        }
        return null;
    }

    public Void visit(ConstantExpr constantExpr) {
        System.out.print("Line ");
        System.out.print(constantExpr.getLine());
        System.out.println(": Expr constantExpr"+constantExpr.getStr() );

        return null;
    }

    public Void visit(FunctionExpr functionExpr) {
        System.out.print("Line ");
        System.out.print(functionExpr.getLine());
        String x = functionExpr.getName();
        System.out.println(": Expr FunctionExpr name: " + x);
        if (functionExpr.getOutside() != null) {
            functionExpr.getOutside().accept(this);
        }
        if (functionExpr.getArguments() != null) {
            for (Expr arg : functionExpr.getArguments()) {
                arg.accept(this);
            }
        }
        return null;
    }

    public Void visit(Identifier identifier) {

//        System.out.print(identifier.getName());

        return null;
    }

    public Void visit(IniListExpr iniListExpr) {
        System.out.print("Line ");
        System.out.print(iniListExpr.getLine());
        System.out.println(": Expr initializerList" );
        if (iniListExpr.getTypename() != null) {
            iniListExpr.getTypename().accept(this);
        }
        if (iniListExpr.getInitializerList() != null) {
            iniListExpr.getInitializerList().accept(this);
        }
        return null;
    }

    public Void visit(SizeofTypeExpr sizeofTypeExpr) {
        System.out.print("Line ");
        System.out.print(sizeofTypeExpr.getLine());
        System.out.println(": Expr sizeOf");

        if (sizeofTypeExpr.getTypename() != null) {
            sizeofTypeExpr.getTypename().accept(this);
        }
        return null;
    }

    public Void visit(TernaryExpr ternaryExpr) {
        System.out.print("Line ");
        System.out.print(ternaryExpr.getLine());
        System.out.println(": Expr ternary");
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

    public Void visit(UnaryExpr unaryExpr) {
        System.out.print("Line ");
        System.out.print(unaryExpr.getLine());
        System.out.println(": Expr unary "+unaryExpr.getOperator().getSymbol() );
        unaryExpr.getOperand().accept(this);
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
        System.out.print("Line ");
        System.out.print(initDeclarator.getLine());
        System.out.print(": declaration ");
        if (initDeclarator.getDeclarator() != null) {
            initDeclarator.getDeclarator().accept(this);
        }
        System.out.print(" = ");
        if (initDeclarator.getInitializer() != null) {
            initDeclarator.getInitializer().accept(this);
        }
        System.out.println(" ");
        return null;
    }

    public Void visit(Initializer initializer) {
        if (initializer.getExpr() != null) {
            initializer.getExpr().accept(this);
        }
        if (initializer.getInitializerlist() != null) {
            initializer.getInitializerlist().accept(this);
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

    public Void visit(IntVal intVal) {
        System.out.print(intVal.getStr());
        return null;
    }
    public Void visit(CharVal charVal){
        System.out.print(charVal.getStr());
        return null;
    }
    public Void visit(FloatVal floatVal){
        System.out.print(floatVal.getStr());
        return null;
    }
    public Void visit(StringExpr stringExpr){
        System.out.print(stringExpr.getStr());
        return null;
    }
}


