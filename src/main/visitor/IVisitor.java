package main.visitor;

import main.ast.nodes.Program;
import main.ast.nodes.Statement.*;
import main.ast.nodes.declaration.*;
import main.ast.nodes.expr.*;
import main.ast.nodes.expr.primitives.*;

public interface IVisitor<T> {
    T visit(Program program);
    T visit(ExternalDeclaration externalDeclaration);
    T visit(InitDeclarator initDeclarator);
    T visit(Declaration declaration);
    T visit(Declarator declarator);
    T visit(DirectDeclarator directDeclarator);
    T visit(Designator designator);
    T visit(Parameter parameter);
    T visit(Typename typename);
    T visit(Initializer initializer);
    T visit(InitializerList initializerList);
    T visit(Designation designation);
    T visit(BlockItem blockItem);
    T visit(CompoundStatement compoundStatement);
    T visit(IterationStatement iterationStatement);
    T visit(JumpStatement jumpStatement);
    T visit(ForDeclaration forDeclaration);
    T visit(ForCondition forCondition);
    T visit(ExpressionStatement expressionStatement);
    T visit(SelectionStatement selectionStatement);
    T visit(Pointer pointer);
    T visit(FunctionDefinition functionDefinition);
    T visit(UnaryExpr unaryExpr);
    T visit(BinaryExpr binaryExpr);
    T visit(Identifier identifier);
    T visit(ConstantExpr constantExpr);
    T visit(StringExpr stringExpr);
    T visit(IniListExpr iniListExpr);
    T visit(ArrayExpr arrayExpr);
    T visit(CastExpr castExpr);
    T visit(FunctionExpr functionExpr);
    T visit(SizeofTypeExpr sizeofTypeExpr);
    T visit(TernaryExpr ternaryExpr);
    T visit(CommaExpr commaExpr);
    T visit(IntVal intVal);
    T visit(StringVal string_val);
    T visit(BoolVal int_Val);
    T visit(DoubleVal double_val);
}
