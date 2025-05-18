// Generated from D:/Ray_Universe/compiler/phase-2-ce-Rayhaneh-Einollahi/src/main/grammar/SimpleLang.g4 by ANTLR 4.13.2
package main.grammar;

    import java.util.List;
     import java.util.ArrayList;
    import main.ast.nodes.*;
    import main.ast.nodes.declaration.*;
    import main.ast.nodes.Statement.*;
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
	 * Visit a parse tree produced by {@link SimpleLangParser#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(SimpleLangParser.CompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#translationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTranslationUnit(SimpleLangParser.TranslationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#externalDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExternalDeclaration(SimpleLangParser.ExternalDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#functionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(SimpleLangParser.FunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#declarationList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationList(SimpleLangParser.DeclarationListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(SimpleLangParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#argumentExpressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentExpressionList(SimpleLangParser.ArgumentExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#unaryOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOperator(SimpleLangParser.UnaryOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#castExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastExpression(SimpleLangParser.CastExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#assignmentOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentOperator(SimpleLangParser.AssignmentOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(SimpleLangParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#declarationSpecifiers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationSpecifiers(SimpleLangParser.DeclarationSpecifiersContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#declarationSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationSpecifier(SimpleLangParser.DeclarationSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#initDeclaratorList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitDeclaratorList(SimpleLangParser.InitDeclaratorListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#initDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitDeclarator(SimpleLangParser.InitDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#typeSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeSpecifier(SimpleLangParser.TypeSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#specifierQualifierList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecifierQualifierList(SimpleLangParser.SpecifierQualifierListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarator(SimpleLangParser.DeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#directDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirectDeclarator(SimpleLangParser.DirectDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#pointer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPointer(SimpleLangParser.PointerContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(SimpleLangParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterDeclaration(SimpleLangParser.ParameterDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#identifierList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierList(SimpleLangParser.IdentifierListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(SimpleLangParser.TypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#abstractDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbstractDeclarator(SimpleLangParser.AbstractDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#directAbstractDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirectAbstractDeclarator(SimpleLangParser.DirectAbstractDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#initializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializer(SimpleLangParser.InitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#initializerList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializerList(SimpleLangParser.InitializerListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#designation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDesignation(SimpleLangParser.DesignationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#designator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDesignator(SimpleLangParser.DesignatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(SimpleLangParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#compoundStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundStatement(SimpleLangParser.CompoundStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#blockItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockItem(SimpleLangParser.BlockItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(SimpleLangParser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#selectionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectionStatement(SimpleLangParser.SelectionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#iterationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterationStatement(SimpleLangParser.IterationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#forCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForCondition(SimpleLangParser.ForConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#forDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForDeclaration(SimpleLangParser.ForDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#forExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForExpression(SimpleLangParser.ForExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#jumpStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJumpStatement(SimpleLangParser.JumpStatementContext ctx);
}