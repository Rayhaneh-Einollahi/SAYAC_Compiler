package main.visitor;

import main.ast.nodes.Program;
import main.ast.nodes.Stmt.Assign;
import main.ast.nodes.Stmt.FuncCallStmt;
import main.ast.nodes.Stmt.IfStmt;
import main.ast.nodes.Stmt.VarDec;
import main.ast.nodes.Stmt.Return;
import main.ast.nodes.declaration.FuncDec;
import main.ast.nodes.declaration.Main;
import main.ast.nodes.expr.BinaryExpr;
import main.ast.nodes.expr.Identifier;
import main.ast.nodes.expr.primitives.*;
import main.ast.nodes.expr.UnaryExpr;
import main.ast.nodes.expr.FuncCallExpr;


public interface IVisitor<T> {

    T visit(Program program);
    T visit(Main main);
    T visit(VarDec varDec);
    T visit(IfStmt ifStmt);
    T visit(FuncCallStmt funcCall);
    T visit(Assign assign);
    T visit(FuncDec funcDec);
    T visit(UnaryExpr unaryExpr);
    T visit(BinaryExpr binaryExpr);
    T visit(Identifier identifier);
    T visit(IntVal int_Val);
    T visit(StringVal string_val);
    T visit(BoolVal int_Val);
    T visit(DoubleVal double_val);
    T visit(FuncCallExpr func_call_expr);
    T visit(Return returnStmt);
}
