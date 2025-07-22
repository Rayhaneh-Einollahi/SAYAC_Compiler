package main.visitor;

import main.ast.nodes.Program;
import main.ast.nodes.Statement.*;
import main.ast.nodes.Statement.IterationStatement.*;
import main.ast.nodes.Statement.JumpStatement.BreakStatement;
import main.ast.nodes.Statement.JumpStatement.ContinueStatement;
import main.ast.nodes.Statement.JumpStatement.JumpStatement;
import main.ast.nodes.Statement.JumpStatement.ReturnStatement;
import main.ast.nodes.declaration.*;
import main.ast.nodes.expr.*;
import main.ast.nodes.expr.primitives.BoolVal;
import main.ast.nodes.expr.primitives.DoubleVal;
import main.ast.nodes.expr.primitives.IntVal;
import main.ast.nodes.expr.primitives.StringVal;

/*GOALs:
*   1. print out scope changes each time a new scope starts
*   2. print the identifier if it is initialized
*   3. print the identifier if it is used
*   4. print out the name of the function when it is defined
*   5. print out the name of the function when it is used
*
* */

public abstract class Visitor<T> implements IVisitor<T> {
    @Override

    public T visit(Program program) {
        for (ExternalDeclaration ed : program.getExternalDeclarations()){
            ed.accept(this);
        }
        return null;
    }

    public T visit(FunctionDefinition functionDefinition) {
        if (functionDefinition.getDeclarationSpecifiers() != null){
            for (Expr expr : functionDefinition.getDeclarationSpecifiers()) {
                expr.accept(this);
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
    public T visit(ExternalDeclaration externalDeclaration){return null;}
    public T visit(Declaration declaration) {
        if (declaration.getDeclarationSpecifiers() != null){
            for (Expr expr : declaration.getDeclarationSpecifiers()) {
                expr.accept(this);
            }
        }
        if (declaration.getInitDeclarators() != null) {
            for (InitDeclarator id : declaration.getInitDeclarators()) {
                id.accept(this);
            }
        }
        return null;
    }
    public T visit(InitDeclarator initDeclarator) {

        if (initDeclarator.getDeclarator() != null) {
            initDeclarator.getDeclarator().accept(this);
        }
        if (initDeclarator.getInitializer() != null) {
            initDeclarator.getInitializer().accept(this);
        }
        return null;
    }
    public T visit(Declarator declarator) {

        if (declarator.getPointer() != null) {
            declarator.getPointer().accept(this);
        }
        if (declarator.getDirectDeclarator() != null) {
            declarator.getDirectDeclarator().accept(this);
        }
        return null;
    }
    public T visit(DirectDeclarator directDeclarator) {

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
    public T visit(Designator designator) {

        if (designator.getExpr() != null) {
            designator.getExpr().accept(this);
        }
        if (designator.getIdentifier() != null) {
            designator.getIdentifier().accept(this);
        }
        return null;
    }
    public T visit(Parameter parameter) {

        if (parameter.getDeclarator() != null) {
            parameter.getDeclarator().accept(this);
        }
        if (parameter.getDeclarationSpecifiers() != null) {
            for(Expr expr: parameter.getDeclarationSpecifiers()) {
                expr.accept(this);
            }
        }
        return null;
    }
    public T visit(Typename typename) {

        if (typename.getDeclarator() != null) {
            typename.getDeclarator().accept(this);
        }
        if (typename.getSpecifierQualifiers() != null){
            for (Expr expr : typename.getSpecifierQualifiers()) {
                expr.accept(this);
            }
        }
        return null;
    }
    public T visit(Initializer initializer) {

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
    public T visit(InitializerList initializerList) {

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
    public T visit(Designation designation) {

        if (designation.getDesignators() != null) {
            for (Designator designator : designation.getDesignators()) {
                if (designator != null) {
                    designator.accept(this);
                }
            }
        }
        return null;
    }

    public T visit(Pointer pointer){return null;}
    public T visit(BlockItem blockItem) {

        if (blockItem.getStatement() != null) {
            blockItem.getStatement().accept(this);
        }
        if (blockItem.getDeclaration() != null) {
            blockItem.getDeclaration().accept(this);
        }
        return null;
    }
    public T visit(CompoundStatement compoundStatement) {
        if (compoundStatement.getBlockItems() != null) {
            for (BlockItem bi : compoundStatement.getBlockItems()) {
                bi.accept(this);
            }
        }
        return null;
    }
    public T visit(ExpressionStatement expressionStatement) {

        if (expressionStatement.getExpr() != null) {
            expressionStatement.getExpr().accept(this);
        }
        return null;
    }
    public T visit(SelectionStatement selectionStatement) {

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
    public T visit(ForStatement forStatement){
        if (forStatement.getForCondition() != null) {
            forStatement.getForCondition().accept(this);
        }
        if (forStatement.getBody() != null) {
            forStatement.getBody().accept(this);
        }
        return null;
    }

    public T visit(WhileStatement whileStatement){
        if (whileStatement.getCondition() != null) {
            whileStatement.getCondition().accept(this);
        }
        if (whileStatement.getBody() != null) {
            whileStatement.getBody().accept(this);
        }
        return null;
    }

    public T visit(DoWhileStatement doWhileStatement){
        if (doWhileStatement.getCondition() != null) {
            doWhileStatement.getCondition().accept(this);
        }
        if (doWhileStatement.getBody() != null) {
            doWhileStatement.getBody().accept(this);
        }
        return null;
    }
    public T visit(ContinueStatement continueStatement){
        return null;
    }

    public T visit(BreakStatement breakStatement){
        return null;
    }

    public T visit(ReturnStatement returnStatement){
        if(returnStatement.getExpr() != null){
            returnStatement.getExpr().accept(this);
        }
        return null;
    }

    public T visit(ForCondition forCondition) {

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
    public T visit(UnaryExpr unaryExpr) {

        unaryExpr.getOperand().accept(this);
        return null;
    }
    public T visit(BinaryExpr binaryExpr) {

        if (binaryExpr.getFirstOperand() != null) {
            binaryExpr.getFirstOperand().accept(this);
        }
        if (binaryExpr.getSecondOperand() != null) {
            binaryExpr.getSecondOperand().accept(this);
        }
        return null;
    }
    public T visit(Identifier identifier) {
        return null;
    }
    public T visit(ConstantExpr constantExpr) {return null;}
    public T visit(StringExpr stringExpr) {return null;}
    public T visit(IniListExpr iniListExpr) {

        if (iniListExpr.getTypename() != null) {
            iniListExpr.getTypename().accept(this);
        }
        if (iniListExpr.getInitializerList() != null) {
            iniListExpr.getInitializerList().accept(this);
        }
        return null;
    }
    public T visit(ArrayExpr arrayExpr) {

        if (arrayExpr.getOutside() != null) {
            arrayExpr.getOutside().accept(this);
        }
        if (arrayExpr.getInside() != null) {
            arrayExpr.getInside().accept(this);
        }
        return null;
    }
    public T visit(CastExpr castExpr) {

        if (castExpr.getTypename() != null) {
            castExpr.getTypename().accept(this);
        }
        if (castExpr.getCastExpr() != null) {
            castExpr.getCastExpr().accept(this);
        }
        return null;
    }
    public T visit(FunctionExpr functionExpr) {

        if (functionExpr.getArguments() != null) {
            for (Expr arg : functionExpr.getArguments()) {
                arg.accept(this);
            }
        }
        return null;
    }
    public T visit(SizeofTypeExpr sizeofTypeExpr) {

        if (sizeofTypeExpr.getTypename() != null) {
            sizeofTypeExpr.getTypename().accept(this);
        }
        return null;
    }
    public T visit(TernaryExpr ternaryExpr) {

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
    public T visit(CommaExpr commaExpr) {

        if (commaExpr.getExpressions() != null) {
            for (Expr expr : commaExpr.getExpressions()) {
                expr.accept(this);
            }
        }
        return null;
    }

    public T visit(IntVal intVal) {
        return null;
    }
    public T visit(StringVal string_val){return null;}
    public T visit(BoolVal bool_val){return null;}
    public T visit(DoubleVal double_vals){return null;}

}
