package main.visitor;

import main.ast.nodes.Program;
import main.ast.nodes.Statement.*;
import main.ast.nodes.Statement.IterationStatement.*;
import main.ast.nodes.Statement.JumpStatement.BreakStatement;
import main.ast.nodes.Statement.JumpStatement.ContinueStatement;
import main.ast.nodes.Statement.JumpStatement.ReturnStatement;
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

public abstract class Visitor<T> implements IVisitor<T> {
    protected void merge(T into, T from) {

    }

    protected T defaultResult() {
        return null;
    }


    @Override
    public T visit(Program program) {
        T result = defaultResult();
        for (ExternalDeclaration ed : program.getExternalDeclarations()){
            merge(result,ed.accept(this));
        }
        return result;
    }

    public T visit(FunctionDefinition functionDefinition) {
        T result = defaultResult();
        if (functionDefinition.getDeclarator() != null){
            merge(result, functionDefinition.getDeclarator().accept(this));
        }

        if (functionDefinition.getDeclarations() != null){
            for (Declaration ds: functionDefinition.getDeclarations()){
                merge(result, ds.accept(this));
            }
        }
        if (functionDefinition.getBody() != null){
            merge(result, functionDefinition.getBody().accept(this));
        }
        return result;
    }
    public T visit(ExternalDeclaration externalDeclaration){
        return defaultResult();
    }
    public T visit(Declaration declaration) {
        T result = defaultResult();
        if (declaration.getInitDeclarators() != null) {
            for (InitDeclarator id : declaration.getInitDeclarators()) {
                merge(result, id.accept(this));
            }
        }
        return result;
    }
    public T visit(InitDeclarator initDeclarator) {
        T result = defaultResult();
        if (initDeclarator.getDeclarator() != null) {
            merge(result, initDeclarator.getDeclarator().accept(this));
        }
        if (initDeclarator.getInitializer() != null) {
            merge(result, initDeclarator.getInitializer().accept(this));
        }
        return result;
    }
    public T visit(Declarator declarator) {
        T result = defaultResult();
        if (declarator.getPointer() != null) {
            merge(result, declarator.getPointer().accept(this));
        }
        if (declarator.getDirectDeclarator() != null) {
            merge(result, declarator.getDirectDeclarator().accept(this));
        }
        return result;
    }
    public T visit(DirectDeclarator directDeclarator) {
        T result = defaultResult();
        if (directDeclarator.getIdentifier() != null) {
            merge(result, directDeclarator.getIdentifier().accept(this));
        }
        if (directDeclarator.getInnerDeclarator() != null) {
            merge(result, directDeclarator.getInnerDeclarator().accept(this));
        }
        if (directDeclarator.getSteps() != null) {
            for (DirectDeclarator.DDStep step : directDeclarator.getSteps()) {
                if (step != null) {
                    switch (step.kind) {
                        case ARRAY:
                            if (step.arrayExpr != null) {
                                merge(result, step.arrayExpr.accept(this));
                            }
                            break;
                        case FUNCTION_P:
                            if (step.params != null) {
                                for (Parameter param : step.params) {
                                    if (param != null) {
                                        merge(result, param.accept(this));
                                    }
                                }
                            }
                            break;
                        case FUNCTION_I:
                            if (step.identifiers != null) {
                                for (Identifier id : step.identifiers) {
                                    if (id != null) {
                                        merge(result, id.accept(this));
                                    }
                                }
                            }
                            break;
                    }
                }
            }
        }
        return result;
    }
    public T visit(Designator designator) {
        T result = defaultResult();
        if (designator.getExpr() != null) {
            merge(result,designator.getExpr().accept(this));
        }
        if (designator.getIdentifier() != null) {
            merge(result, designator.getIdentifier().accept(this));
        }
        return result;
    }
    public T visit(Parameter parameter) {
        T result = defaultResult();
        if (parameter.getDeclarator() != null) {
            merge(result, parameter.getDeclarator().accept(this));
        }
        return result;
    }
    public T visit(Typename typename) {
        T result = defaultResult();
        if (typename.getDeclarator() != null) {
            merge(result, typename.getDeclarator().accept(this));
        }
        return result;
    }
    public T visit(Initializer initializer) {
        T result = defaultResult();
        if (initializer.getExpr() != null) {
            merge(result, initializer.getExpr().accept(this));
        }
        if (initializer.getInitializerlist() != null) {
            merge(result, initializer.getInitializerlist().accept(this));
        }
        if (initializer.getDesignation() != null) {
            merge(result, initializer.getDesignation().accept(this));
        }
        return result;
    }
    public T visit(InitializerList initializerList) {
        T result = defaultResult();
        if (initializerList.getList() != null) {
            for (InitializerList.Pair p : initializerList.getList()) {
                if (p != null) {
                    if (p.designation() != null) {
                        merge(result, p.designation().accept(this));
                    }
                    if (p.initializer() != null) {
                        merge(result, p.initializer().accept(this));
                    }
                }
            }
        }
        return result;
    }
    public T visit(Designation designation) {
        T result = defaultResult();
        if (designation.getDesignators() != null) {
            for (Designator designator : designation.getDesignators()) {
                if (designator != null) {
                    merge(result, designator.accept(this));
                }
            }
        }
        return result;
    }

    public T visit(Pointer pointer){
        return defaultResult();
    }
    public T visit(BlockItem blockItem) {
        T result = defaultResult();
        if (blockItem.getStatement() != null) {
            merge(result, blockItem.getStatement().accept(this));
        }
        if (blockItem.getDeclaration() != null) {
            merge(result, blockItem.getDeclaration().accept(this));
        }
        return result;
    }
    public T visit(CompoundStatement compoundStatement) {
        T result = defaultResult();
        if (compoundStatement.getBlockItems() != null) {
            for (BlockItem bi : compoundStatement.getBlockItems()) {
                merge(result, bi.accept(this));
            }
        }
        return result;
    }
    public T visit(ExpressionStatement expressionStatement) {
        T result = defaultResult();
        if (expressionStatement.getExpr() != null) {
            merge(result, expressionStatement.getExpr().accept(this));
        }
        return result;
    }
    public T visit(SelectionStatement selectionStatement) {
        T result = defaultResult();
        if (selectionStatement.getCondition() != null) {
            merge(result, selectionStatement.getCondition().accept(this));
        }
        if (selectionStatement.getIfStatement() != null) {
            merge(result, selectionStatement.getIfStatement().accept(this));
        }
        if (selectionStatement.getElseStatement() != null) {
            merge(result, selectionStatement.getElseStatement().accept(this));
        }
        return result;
    }
    public T visit(ForStatement forStatement){
        T result = defaultResult();
        if (forStatement.getForCondition() != null) {
            merge(result, forStatement.getForCondition().accept(this));
        }
        if (forStatement.getBody() != null) {
            merge(result, forStatement.getBody().accept(this));
        }
        return result;
    }

    public T visit(WhileStatement whileStatement){
        T result = defaultResult();
        if (whileStatement.getCondition() != null) {
            merge(result, whileStatement.getCondition().accept(this));
        }
        if (whileStatement.getBody() != null) {
            merge(result, whileStatement.getBody().accept(this));
        }
        return result;
    }

    public T visit(DoWhileStatement doWhileStatement){
        T result = defaultResult();
        if (doWhileStatement.getCondition() != null) {
            merge(result, doWhileStatement.getCondition().accept(this));
        }
        if (doWhileStatement.getBody() != null) {
            merge(result, doWhileStatement.getBody().accept(this));
        }
        return result;
    }
    public T visit(ContinueStatement continueStatement){
        return defaultResult();
    }

    public T visit(BreakStatement breakStatement){
        return defaultResult();
    }

    public T visit(ReturnStatement returnStatement){
        T result = defaultResult();
        if(returnStatement.getExpr() != null){
            merge(result, returnStatement.getExpr().accept(this));
        }
        return result;
    }

    public T visit(ForCondition forCondition) {
        T result = defaultResult();
        if (forCondition.getDeclaration() != null) {
            merge(result, forCondition.getDeclaration().accept(this));
        }
        if (forCondition.getExpr() != null) {
            merge(result, forCondition.getExpr().accept(this));
        }
        if (forCondition.getConditions() != null) {
            for (Expr condition : forCondition.getConditions()) {
                merge(result, condition.accept(this));
            }
        }
        if (forCondition.getSteps() != null) {
            for (Expr step : forCondition.getSteps()) {
                merge(result, step.accept(this));
            }
        }
        return result;
    }

    public T visit(UnaryExpr unaryExpr) {
        T result = defaultResult();
        merge(result, unaryExpr.getOperand().accept(this));
        return result;
    }

    public T visit(BinaryExpr binaryExpr) {
        T result = defaultResult();
        if (binaryExpr.getFirstOperand() != null) {
            merge(result, binaryExpr.getFirstOperand().accept(this));
        }
        if (binaryExpr.getSecondOperand() != null) {
            merge(result, binaryExpr.getSecondOperand().accept(this));
        }
        return result;
    }
    public T visit(Identifier identifier) {
        return defaultResult();
    }

    public T visit(IniListExpr iniListExpr) {
        T result = defaultResult();
        if (iniListExpr.getTypename() != null) {
            merge(result, iniListExpr.getTypename().accept(this));
        }
        if (iniListExpr.getInitializerList() != null) {
            merge(result, iniListExpr.getInitializerList().accept(this));
        }
        return result;
    }
    public T visit(ArrayExpr arrayExpr) {
        T result = defaultResult();
        if (arrayExpr.getOutside() != null) {
            merge(result, arrayExpr.getOutside().accept(this));
        }
        if (arrayExpr.getInside() != null) {
            merge(result, arrayExpr.getInside().accept(this));
        }
        return result;
    }
    public T visit(CastExpr castExpr) {
        T result = defaultResult();
        if (castExpr.getTypename() != null) {
            merge(result, castExpr.getTypename().accept(this));
        }
        if (castExpr.getCastExpr() != null) {
            merge(result, castExpr.getCastExpr().accept(this));
        }
        return result;
    }
    public T visit(FunctionExpr functionExpr) {
        T result = defaultResult();
        if (functionExpr.getArguments() != null) {
            for (Expr arg : functionExpr.getArguments()) {
                merge(result, arg.accept(this));
            }
        }
        return result;
    }
    public T visit(SizeofTypeExpr sizeofTypeExpr) {
        T result = defaultResult();
        if (sizeofTypeExpr.getTypename() != null) {
            merge(result, sizeofTypeExpr.getTypename().accept(this));
        }
        return result;
    }
    public T visit(TernaryExpr ternaryExpr) {
        T result = defaultResult();
        if (ternaryExpr.getFirstOperand() != null) {
            merge(result, ternaryExpr.getFirstOperand().accept(this));
        }
        if (ternaryExpr.getSecondOperand() != null) {
            merge(result, ternaryExpr.getSecondOperand().accept(this));
        }
        if (ternaryExpr.getThirdOperand() != null) {
            merge(result, ternaryExpr.getThirdOperand().accept(this));
        }
        return result;
    }
    public T visit(CommaExpr commaExpr) {
        T result = defaultResult();
        if (commaExpr.getExpressions() != null) {
            for (Expr expr : commaExpr.getExpressions()) {
                merge(result, expr.accept(this));
            }
        }
        return result;
    }

    public T visit(IntVal intVal) {
        return defaultResult();
    }

    public T visit(CharVal charVal){
        return defaultResult();
    }

    public T visit(FloatVal floatVal){
        return defaultResult();
    }
    public T visit(StringExpr stringExpr){
        return defaultResult();
    }

}
