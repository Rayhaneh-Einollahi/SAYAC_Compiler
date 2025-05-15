// Generated from F:/university/TA/plc/S04/3_name_analyzier/miniProject-NameAnalyzer/src/main/grammar/SimpleLang.g4 by ANTLR 4.13.2
package main.grammar;

    import main.ast.nodes.*;
    import main.ast.nodes.declaration.*;
    import main.ast.nodes.Stmt.*;
    import main.ast.nodes.expr.*;
    import main.ast.nodes.expr.primitives.*;
    import main.ast.nodes.expr.operator.*;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SimpleLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SimpleLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(SimpleLangParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#func_dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_dec(SimpleLangParser.Func_decContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(SimpleLangParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(SimpleLangParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#return_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_stmt(SimpleLangParser.Return_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#var_dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_dec(SimpleLangParser.Var_decContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(SimpleLangParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#if_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_stmt(SimpleLangParser.If_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(SimpleLangParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#func_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_call(SimpleLangParser.Func_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#primary_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary_expr(SimpleLangParser.Primary_exprContext ctx);
}