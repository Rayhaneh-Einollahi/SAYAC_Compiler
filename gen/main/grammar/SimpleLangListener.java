// Generated from F:/university/TA/plc/S04/3_name_analyzier/miniProject-NameAnalyzer/src/main/grammar/SimpleLang.g4 by ANTLR 4.13.2
package main.grammar;

    import main.ast.nodes.*;
    import main.ast.nodes.declaration.*;
    import main.ast.nodes.Stmt.*;
    import main.ast.nodes.expr.*;
    import main.ast.nodes.expr.primitives.*;
    import main.ast.nodes.expr.operator.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimpleLangParser}.
 */
public interface SimpleLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(SimpleLangParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(SimpleLangParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#func_dec}.
	 * @param ctx the parse tree
	 */
	void enterFunc_dec(SimpleLangParser.Func_decContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#func_dec}.
	 * @param ctx the parse tree
	 */
	void exitFunc_dec(SimpleLangParser.Func_decContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(SimpleLangParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(SimpleLangParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(SimpleLangParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(SimpleLangParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void enterReturn_stmt(SimpleLangParser.Return_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void exitReturn_stmt(SimpleLangParser.Return_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#var_dec}.
	 * @param ctx the parse tree
	 */
	void enterVar_dec(SimpleLangParser.Var_decContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#var_dec}.
	 * @param ctx the parse tree
	 */
	void exitVar_dec(SimpleLangParser.Var_decContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(SimpleLangParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(SimpleLangParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIf_stmt(SimpleLangParser.If_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIf_stmt(SimpleLangParser.If_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(SimpleLangParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(SimpleLangParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#func_call}.
	 * @param ctx the parse tree
	 */
	void enterFunc_call(SimpleLangParser.Func_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#func_call}.
	 * @param ctx the parse tree
	 */
	void exitFunc_call(SimpleLangParser.Func_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#primary_expr}.
	 * @param ctx the parse tree
	 */
	void enterPrimary_expr(SimpleLangParser.Primary_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#primary_expr}.
	 * @param ctx the parse tree
	 */
	void exitPrimary_expr(SimpleLangParser.Primary_exprContext ctx);
}