package main.visitor;

import main.ast.nodes.Program;
import main.ast.nodes.Statement.*;
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
        return null;
    }

    public T visit(FunctionDefinition funcDef) {
        return null;
    }
    public T visit(ExternalDeclaration externalDeclaration){return null;}
    public T visit(Declaration declaration){return null;}
    public T visit(InitDeclarator initDeclarator){return null;}
    public T visit(Declarator declarator){return null;}
    public T visit(DirectDeclarator directDeclarator){return null;}
    public T visit(Designator designator){return null;}
    public T visit(Parameter parameter){return null;}
    public T visit(Typename typename){return null;}
    public T visit(Initializer initializer){return null;}
    public T visit(InitializerList initializerList){return null;}
    public T visit(Designation designation){return null;}

    public T visit(Pointer pointer){return null;}
    public T visit(BlockItem lockItem){return null;}
    public T visit(CompoundStatement compoundStatement){return null;}
    public T visit(ExpressionStatement expressionStatement){return null;}
    public T visit(SelectionStatement selectionStatement){return null;}
    public T visit(IterationStatement iterationStatement){return null;}
    public T visit(JumpStatement jumpStatement){return null;}
    public T visit(ForDeclaration forDeclaration){return null;}
    public T visit(ForCondition forCondition){return null;}
    public T visit(UnaryExpr unaryExpr) {
        return null;
    }
    public T visit(BinaryExpr binaryExpr) {
        return null;
    }
    public T visit(Identifier identifier) {
        return null;
    }
    public T visit(ConstantExpr constantExpr) {return null;}
    public T visit(StringExpr stringExpr) {return null;}
    public T visit(IniListExpr iniListExpr) {return null;}
    public T visit(ArrayExpr arrayExpr) {return null;}
    public T visit(CastExpr castExpr) {return null;}
    public T visit(FunctionExpr functionExpr) {return null;}
    public T visit(SizeofTypeExpr sizeofTypeExpr) {return null;}
    public T visit(TernaryExpr ternaryExpr) {return null;}
    public T visit(CommaExpr commaExpr) {return null;}

    public T visit(IntVal intVal) {
        return null;
    }
    public T visit(StringVal string_val){return null;}
    public T visit(BoolVal bool_val){return null;}
    public T visit(DoubleVal double_vals){return null;}

}
