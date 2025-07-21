// Generated from G:/stuff/Paper/SAYAC/SAYAC_Compiler/src/main/grammar/SimpleLang.g4 by ANTLR 4.13.2
package main.grammar;

    import java.util.List;
     import java.util.ArrayList;
    import main.ast.nodes.*;
    import main.ast.nodes.declaration.*;
    import main.ast.nodes.Statement.*;
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
	 * Enter a parse tree produced by {@link SimpleLangParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompilationUnit(SimpleLangParser.CompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompilationUnit(SimpleLangParser.CompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#translationUnit}.
	 * @param ctx the parse tree
	 */
	void enterTranslationUnit(SimpleLangParser.TranslationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#translationUnit}.
	 * @param ctx the parse tree
	 */
	void exitTranslationUnit(SimpleLangParser.TranslationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#externalDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterExternalDeclaration(SimpleLangParser.ExternalDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#externalDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitExternalDeclaration(SimpleLangParser.ExternalDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinition(SimpleLangParser.FunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinition(SimpleLangParser.FunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#declarationList}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationList(SimpleLangParser.DeclarationListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#declarationList}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationList(SimpleLangParser.DeclarationListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(SimpleLangParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(SimpleLangParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#argumentExpressionList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentExpressionList(SimpleLangParser.ArgumentExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#argumentExpressionList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentExpressionList(SimpleLangParser.ArgumentExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOperator(SimpleLangParser.UnaryOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOperator(SimpleLangParser.UnaryOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#castExpression}.
	 * @param ctx the parse tree
	 */
	void enterCastExpression(SimpleLangParser.CastExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#castExpression}.
	 * @param ctx the parse tree
	 */
	void exitCastExpression(SimpleLangParser.CastExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentOperator(SimpleLangParser.AssignmentOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentOperator(SimpleLangParser.AssignmentOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(SimpleLangParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(SimpleLangParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#declarationSpecifiers}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationSpecifiers(SimpleLangParser.DeclarationSpecifiersContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#declarationSpecifiers}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationSpecifiers(SimpleLangParser.DeclarationSpecifiersContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#declarationSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationSpecifier(SimpleLangParser.DeclarationSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#declarationSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationSpecifier(SimpleLangParser.DeclarationSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#initDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void enterInitDeclaratorList(SimpleLangParser.InitDeclaratorListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#initDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void exitInitDeclaratorList(SimpleLangParser.InitDeclaratorListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#initDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterInitDeclarator(SimpleLangParser.InitDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#initDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitInitDeclarator(SimpleLangParser.InitDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeSpecifier(SimpleLangParser.TypeSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeSpecifier(SimpleLangParser.TypeSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#specifierQualifierList}.
	 * @param ctx the parse tree
	 */
	void enterSpecifierQualifierList(SimpleLangParser.SpecifierQualifierListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#specifierQualifierList}.
	 * @param ctx the parse tree
	 */
	void exitSpecifierQualifierList(SimpleLangParser.SpecifierQualifierListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#declarator}.
	 * @param ctx the parse tree
	 */
	void enterDeclarator(SimpleLangParser.DeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#declarator}.
	 * @param ctx the parse tree
	 */
	void exitDeclarator(SimpleLangParser.DeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#directDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterDirectDeclarator(SimpleLangParser.DirectDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#directDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitDirectDeclarator(SimpleLangParser.DirectDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#pointer}.
	 * @param ctx the parse tree
	 */
	void enterPointer(SimpleLangParser.PointerContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#pointer}.
	 * @param ctx the parse tree
	 */
	void exitPointer(SimpleLangParser.PointerContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(SimpleLangParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(SimpleLangParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterParameterDeclaration(SimpleLangParser.ParameterDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitParameterDeclaration(SimpleLangParser.ParameterDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#identifierList}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierList(SimpleLangParser.IdentifierListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#identifierList}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierList(SimpleLangParser.IdentifierListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#typeName}.
	 * @param ctx the parse tree
	 */
	void enterTypeName(SimpleLangParser.TypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#typeName}.
	 * @param ctx the parse tree
	 */
	void exitTypeName(SimpleLangParser.TypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#abstractDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterAbstractDeclarator(SimpleLangParser.AbstractDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#abstractDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitAbstractDeclarator(SimpleLangParser.AbstractDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#directAbstractDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterDirectAbstractDeclarator(SimpleLangParser.DirectAbstractDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#directAbstractDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitDirectAbstractDeclarator(SimpleLangParser.DirectAbstractDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#initializer}.
	 * @param ctx the parse tree
	 */
	void enterInitializer(SimpleLangParser.InitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#initializer}.
	 * @param ctx the parse tree
	 */
	void exitInitializer(SimpleLangParser.InitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#initializerList}.
	 * @param ctx the parse tree
	 */
	void enterInitializerList(SimpleLangParser.InitializerListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#initializerList}.
	 * @param ctx the parse tree
	 */
	void exitInitializerList(SimpleLangParser.InitializerListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#designation}.
	 * @param ctx the parse tree
	 */
	void enterDesignation(SimpleLangParser.DesignationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#designation}.
	 * @param ctx the parse tree
	 */
	void exitDesignation(SimpleLangParser.DesignationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#designator}.
	 * @param ctx the parse tree
	 */
	void enterDesignator(SimpleLangParser.DesignatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#designator}.
	 * @param ctx the parse tree
	 */
	void exitDesignator(SimpleLangParser.DesignatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(SimpleLangParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(SimpleLangParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#compoundStatement}.
	 * @param ctx the parse tree
	 */
	void enterCompoundStatement(SimpleLangParser.CompoundStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#compoundStatement}.
	 * @param ctx the parse tree
	 */
	void exitCompoundStatement(SimpleLangParser.CompoundStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#blockItem}.
	 * @param ctx the parse tree
	 */
	void enterBlockItem(SimpleLangParser.BlockItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#blockItem}.
	 * @param ctx the parse tree
	 */
	void exitBlockItem(SimpleLangParser.BlockItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(SimpleLangParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(SimpleLangParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#selectionStatement}.
	 * @param ctx the parse tree
	 */
	void enterSelectionStatement(SimpleLangParser.SelectionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#selectionStatement}.
	 * @param ctx the parse tree
	 */
	void exitSelectionStatement(SimpleLangParser.SelectionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void enterIterationStatement(SimpleLangParser.IterationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void exitIterationStatement(SimpleLangParser.IterationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#forCondition}.
	 * @param ctx the parse tree
	 */
	void enterForCondition(SimpleLangParser.ForConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#forCondition}.
	 * @param ctx the parse tree
	 */
	void exitForCondition(SimpleLangParser.ForConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#forDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterForDeclaration(SimpleLangParser.ForDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#forDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitForDeclaration(SimpleLangParser.ForDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#forExpression}.
	 * @param ctx the parse tree
	 */
	void enterForExpression(SimpleLangParser.ForExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#forExpression}.
	 * @param ctx the parse tree
	 */
	void exitForExpression(SimpleLangParser.ForExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void enterJumpStatement(SimpleLangParser.JumpStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void exitJumpStatement(SimpleLangParser.JumpStatementContext ctx);
}