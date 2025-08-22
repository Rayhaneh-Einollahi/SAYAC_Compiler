// Generated from /Users/mahdis/Me/university/Research/SAYAC_Compiler/src/main/grammar/SimpleLang.g4 by ANTLR 4.13.2
package main.grammar;

    import java.util.List;
     import java.util.ArrayList;
    import main.ast.nodes.*;
    import main.ast.nodes.declaration.*;
    import main.ast.nodes.Statement.*;
    import main.ast.nodes.Statement.IterationStatement.*;
    import main.ast.nodes.Statement.JumpStatement.*;
    import main.ast.nodes.expr.*;
    import main.ast.nodes.expr.primitives.*;
    import main.ast.nodes.expr.operator.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class SimpleLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Break=1, Char=2, Const=3, Continue=4, Do=5, Double=6, Else=7, Float=8, 
		For=9, If=10, Int=11, Long=12, Return=13, Short=14, Signed=15, Sizeof=16, 
		Switch=17, Typedef=18, Unsigned=19, Void=20, While=21, Bool=22, LeftParen=23, 
		RightParen=24, LeftBracket=25, RightBracket=26, LeftBrace=27, RightBrace=28, 
		Less=29, LessEqual=30, Greater=31, GreaterEqual=32, LeftShift=33, RightShift=34, 
		Plus=35, PlusPlus=36, Minus=37, MinusMinus=38, Star=39, Div=40, Mod=41, 
		And=42, Or=43, AndAnd=44, OrOr=45, Xor=46, Not=47, Tilde=48, Question=49, 
		Colon=50, Semi=51, Comma=52, Assign=53, StarAssign=54, DivAssign=55, ModAssign=56, 
		PlusAssign=57, MinusAssign=58, LeftShiftAssign=59, RightShiftAssign=60, 
		AndAssign=61, XorAssign=62, OrAssign=63, Equal=64, NotEqual=65, Arrow=66, 
		Dot=67, Identifier=68, IntegerConstant=69, FloatingConstant=70, DigitSequence=71, 
		CharacterConstant=72, StringLiteral=73, MultiLineMacro=74, Directive=75, 
		Whitespace=76, Newline=77, BlockComment=78, LineComment=79;
	public static final int
		RULE_compilationUnit = 0, RULE_translationUnit = 1, RULE_externalDeclaration = 2, 
		RULE_functionDefinition = 3, RULE_declarationList = 4, RULE_allExpression = 5, 
		RULE_expression = 6, RULE_argumentExpressionList = 7, RULE_unaryOperator = 8, 
		RULE_castExpression = 9, RULE_assignmentOperator = 10, RULE_declaration = 11, 
		RULE_declarationSpecifiers = 12, RULE_declarationSpecifier = 13, RULE_initDeclaratorList = 14, 
		RULE_initDeclarator = 15, RULE_typeSpecifier = 16, RULE_specifierQualifierList = 17, 
		RULE_declarator = 18, RULE_directDeclarator = 19, RULE_pointer = 20, RULE_parameterList = 21, 
		RULE_parameterDeclaration = 22, RULE_identifierList = 23, RULE_typeName = 24, 
		RULE_abstractDeclarator = 25, RULE_directAbstractDeclarator = 26, RULE_initializer = 27, 
		RULE_initializerList = 28, RULE_designation = 29, RULE_designator = 30, 
		RULE_statement = 31, RULE_compoundStatement = 32, RULE_blockItem = 33, 
		RULE_expressionStatement = 34, RULE_selectionStatement = 35, RULE_iterationStatement = 36, 
		RULE_forCondition = 37, RULE_forDeclaration = 38, RULE_forExpression = 39, 
		RULE_jumpStatement = 40, RULE_constant = 41;
	private static String[] makeRuleNames() {
		return new String[] {
			"compilationUnit", "translationUnit", "externalDeclaration", "functionDefinition", 
			"declarationList", "allExpression", "expression", "argumentExpressionList", 
			"unaryOperator", "castExpression", "assignmentOperator", "declaration", 
			"declarationSpecifiers", "declarationSpecifier", "initDeclaratorList", 
			"initDeclarator", "typeSpecifier", "specifierQualifierList", "declarator", 
			"directDeclarator", "pointer", "parameterList", "parameterDeclaration", 
			"identifierList", "typeName", "abstractDeclarator", "directAbstractDeclarator", 
			"initializer", "initializerList", "designation", "designator", "statement", 
			"compoundStatement", "blockItem", "expressionStatement", "selectionStatement", 
			"iterationStatement", "forCondition", "forDeclaration", "forExpression", 
			"jumpStatement", "constant"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'break'", "'char'", "'const'", "'continue'", "'do'", "'double'", 
			"'else'", "'float'", "'for'", "'if'", "'int'", "'long'", "'return'", 
			"'short'", "'signed'", "'sizeof'", "'switch'", "'typedef'", "'unsigned'", 
			"'void'", "'while'", "'bool'", "'('", "')'", "'['", "']'", "'{'", "'}'", 
			"'<'", "'<='", "'>'", "'>='", "'<<'", "'>>'", "'+'", "'++'", "'-'", "'--'", 
			"'*'", "'/'", "'%'", "'&'", "'|'", "'&&'", "'||'", "'^'", "'!'", "'~'", 
			"'?'", "':'", "';'", "','", "'='", "'*='", "'/='", "'%='", "'+='", "'-='", 
			"'<<='", "'>>='", "'&='", "'^='", "'|='", "'=='", "'!='", "'->'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Break", "Char", "Const", "Continue", "Do", "Double", "Else", "Float", 
			"For", "If", "Int", "Long", "Return", "Short", "Signed", "Sizeof", "Switch", 
			"Typedef", "Unsigned", "Void", "While", "Bool", "LeftParen", "RightParen", 
			"LeftBracket", "RightBracket", "LeftBrace", "RightBrace", "Less", "LessEqual", 
			"Greater", "GreaterEqual", "LeftShift", "RightShift", "Plus", "PlusPlus", 
			"Minus", "MinusMinus", "Star", "Div", "Mod", "And", "Or", "AndAnd", "OrOr", 
			"Xor", "Not", "Tilde", "Question", "Colon", "Semi", "Comma", "Assign", 
			"StarAssign", "DivAssign", "ModAssign", "PlusAssign", "MinusAssign", 
			"LeftShiftAssign", "RightShiftAssign", "AndAssign", "XorAssign", "OrAssign", 
			"Equal", "NotEqual", "Arrow", "Dot", "Identifier", "IntegerConstant", 
			"FloatingConstant", "DigitSequence", "CharacterConstant", "StringLiteral", 
			"MultiLineMacro", "Directive", "Whitespace", "Newline", "BlockComment", 
			"LineComment"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SimpleLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SimpleLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CompilationUnitContext extends ParserRuleContext {
		public Program programRet;
		public TranslationUnitContext tu;
		public TerminalNode EOF() { return getToken(SimpleLangParser.EOF, 0); }
		public TranslationUnitContext translationUnit() {
			return getRuleContext(TranslationUnitContext.class,0);
		}
		public CompilationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compilationUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterCompilationUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitCompilationUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitCompilationUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompilationUnitContext compilationUnit() throws RecognitionException {
		CompilationUnitContext _localctx = new CompilationUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compilationUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((CompilationUnitContext)_localctx).programRet =  new Program();
			_localctx.programRet.setLine(_localctx.start.getLine());
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2251799819770188L) != 0) || _la==Identifier) {
				{
				setState(86);
				((CompilationUnitContext)_localctx).tu = translationUnit();
				_localctx.programRet.addExternalDeclarations(((CompilationUnitContext)_localctx).tu.list);
				}
			}

			setState(91);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TranslationUnitContext extends ParserRuleContext {
		public List<ExternalDeclaration> list;
		public ExternalDeclarationContext ed;
		public List<ExternalDeclarationContext> externalDeclaration() {
			return getRuleContexts(ExternalDeclarationContext.class);
		}
		public ExternalDeclarationContext externalDeclaration(int i) {
			return getRuleContext(ExternalDeclarationContext.class,i);
		}
		public TranslationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_translationUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterTranslationUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitTranslationUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitTranslationUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TranslationUnitContext translationUnit() throws RecognitionException {
		TranslationUnitContext _localctx = new TranslationUnitContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_translationUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((TranslationUnitContext)_localctx).list =  new ArrayList<>();
			setState(97); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(94);
				((TranslationUnitContext)_localctx).ed = externalDeclaration();
				if (((TranslationUnitContext)_localctx).ed.externalDecRet != null) _localctx.list.add(((TranslationUnitContext)_localctx).ed.externalDecRet);
				}
				}
				setState(99); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2251799819770188L) != 0) || _la==Identifier );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExternalDeclarationContext extends ParserRuleContext {
		public ExternalDeclaration externalDecRet;
		public FunctionDefinitionContext fd;
		public DeclarationContext dec;
		public FunctionDefinitionContext functionDefinition() {
			return getRuleContext(FunctionDefinitionContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public TerminalNode Semi() { return getToken(SimpleLangParser.Semi, 0); }
		public ExternalDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_externalDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterExternalDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitExternalDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitExternalDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExternalDeclarationContext externalDeclaration() throws RecognitionException {
		ExternalDeclarationContext _localctx = new ExternalDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_externalDeclaration);
		try {
			setState(109);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(101);
				((ExternalDeclarationContext)_localctx).fd = functionDefinition();
				((ExternalDeclarationContext)_localctx).externalDecRet =  ((ExternalDeclarationContext)_localctx).fd.funcDefRet;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
				((ExternalDeclarationContext)_localctx).dec = declaration();
				((ExternalDeclarationContext)_localctx).externalDecRet =  ((ExternalDeclarationContext)_localctx).dec.decRet;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(107);
				match(Semi);
				 ((ExternalDeclarationContext)_localctx).externalDecRet =  null;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDefinitionContext extends ParserRuleContext {
		public FunctionDefinition funcDefRet;
		public DeclarationSpecifiersContext specs;
		public DeclaratorContext dec;
		public DeclarationListContext declist;
		public CompoundStatementContext cstmt;
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
		}
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public DeclarationListContext declarationList() {
			return getRuleContext(DeclarationListContext.class,0);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterFunctionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitFunctionDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitFunctionDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			((FunctionDefinitionContext)_localctx).specs = declarationSpecifiers();
			setState(112);
			((FunctionDefinitionContext)_localctx).dec = declarator();
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6084940L) != 0) || _la==Identifier) {
				{
				setState(113);
				((FunctionDefinitionContext)_localctx).declist = declarationList();
				}
			}

			setState(116);
			((FunctionDefinitionContext)_localctx).cstmt = compoundStatement();

			        ((FunctionDefinitionContext)_localctx).funcDefRet =  new FunctionDefinition(((FunctionDefinitionContext)_localctx).specs.list, ((FunctionDefinitionContext)_localctx).dec.declaratorRet, ((FunctionDefinitionContext)_localctx).declist != null? ((FunctionDefinitionContext)_localctx).declist.list: null, ((FunctionDefinitionContext)_localctx).cstmt.cstmtRet);
			        _localctx.funcDefRet.setLine(_localctx.start.getLine());
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationListContext extends ParserRuleContext {
		public List<Declaration> list;
		public DeclarationContext dec;
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public DeclarationListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterDeclarationList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitDeclarationList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitDeclarationList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationListContext declarationList() throws RecognitionException {
		DeclarationListContext _localctx = new DeclarationListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_declarationList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((DeclarationListContext)_localctx).list =  new ArrayList<>();
			setState(123); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(120);
				((DeclarationListContext)_localctx).dec = declaration();
				_localctx.list.add(((DeclarationListContext)_localctx).dec.decRet);
				}
				}
				setState(125); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 6084940L) != 0) || _la==Identifier );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AllExpressionContext extends ParserRuleContext {
		public Expr expRet;
		public ExpressionContext e;
		public ExpressionContext e1;
		public ExpressionContext expression;
		public List<ExpressionContext> es = new ArrayList<ExpressionContext>();
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SimpleLangParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SimpleLangParser.Comma, i);
		}
		public AllExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_allExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterAllExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitAllExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitAllExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AllExpressionContext allExpression() throws RecognitionException {
		AllExpressionContext _localctx = new AllExpressionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_allExpression);
		int _la;
		try {
			setState(139);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(127);
				((AllExpressionContext)_localctx).e = expression(0);
				((AllExpressionContext)_localctx).expRet =  ((AllExpressionContext)_localctx).e.expRet; _localctx.expRet.setLine(_localctx.start.getLine());
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
				((AllExpressionContext)_localctx).e1 = expression(0);
				setState(133); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(131);
					match(Comma);
					setState(132);
					((AllExpressionContext)_localctx).expression = expression(0);
					((AllExpressionContext)_localctx).es.add(((AllExpressionContext)_localctx).expression);
					}
					}
					setState(135); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==Comma );

				            List<Expr> result = new ArrayList<>();
				                result.add(((AllExpressionContext)_localctx).e1.expRet);
				                for (ExpressionContext ctx : ((AllExpressionContext)_localctx).es) {
				                    result.add(ctx.expRet);
				                }
				            ((AllExpressionContext)_localctx).expRet =  new CommaExpr(result);
				            _localctx.expRet.setLine(_localctx.start.getLine());
				        
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public Expr expRet;
		public ExpressionContext e1;
		public ExpressionContext e;
		public Token id;
		public ConstantContext c;
		public Token str;
		public TypeNameContext t;
		public InitializerListContext i;
		public Token op;
		public UnaryOperatorContext u;
		public CastExpressionContext ce;
		public TypeNameContext tn;
		public ExpressionContext e2;
		public ExpressionContext e3;
		public AssignmentOperatorContext op2;
		public ArgumentExpressionListContext l;
		public TerminalNode Identifier() { return getToken(SimpleLangParser.Identifier, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public List<TerminalNode> StringLiteral() { return getTokens(SimpleLangParser.StringLiteral); }
		public TerminalNode StringLiteral(int i) {
			return getToken(SimpleLangParser.StringLiteral, i);
		}
		public TerminalNode LeftParen() { return getToken(SimpleLangParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(SimpleLangParser.RightParen, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LeftBrace() { return getToken(SimpleLangParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(SimpleLangParser.RightBrace, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public InitializerListContext initializerList() {
			return getRuleContext(InitializerListContext.class,0);
		}
		public TerminalNode Comma() { return getToken(SimpleLangParser.Comma, 0); }
		public List<TerminalNode> Sizeof() { return getTokens(SimpleLangParser.Sizeof); }
		public TerminalNode Sizeof(int i) {
			return getToken(SimpleLangParser.Sizeof, i);
		}
		public UnaryOperatorContext unaryOperator() {
			return getRuleContext(UnaryOperatorContext.class,0);
		}
		public CastExpressionContext castExpression() {
			return getRuleContext(CastExpressionContext.class,0);
		}
		public List<TerminalNode> PlusPlus() { return getTokens(SimpleLangParser.PlusPlus); }
		public TerminalNode PlusPlus(int i) {
			return getToken(SimpleLangParser.PlusPlus, i);
		}
		public List<TerminalNode> MinusMinus() { return getTokens(SimpleLangParser.MinusMinus); }
		public TerminalNode MinusMinus(int i) {
			return getToken(SimpleLangParser.MinusMinus, i);
		}
		public TerminalNode Star() { return getToken(SimpleLangParser.Star, 0); }
		public TerminalNode Div() { return getToken(SimpleLangParser.Div, 0); }
		public TerminalNode Mod() { return getToken(SimpleLangParser.Mod, 0); }
		public TerminalNode Plus() { return getToken(SimpleLangParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(SimpleLangParser.Minus, 0); }
		public TerminalNode LeftShift() { return getToken(SimpleLangParser.LeftShift, 0); }
		public TerminalNode RightShift() { return getToken(SimpleLangParser.RightShift, 0); }
		public TerminalNode Less() { return getToken(SimpleLangParser.Less, 0); }
		public TerminalNode Greater() { return getToken(SimpleLangParser.Greater, 0); }
		public TerminalNode LessEqual() { return getToken(SimpleLangParser.LessEqual, 0); }
		public TerminalNode GreaterEqual() { return getToken(SimpleLangParser.GreaterEqual, 0); }
		public TerminalNode Equal() { return getToken(SimpleLangParser.Equal, 0); }
		public TerminalNode NotEqual() { return getToken(SimpleLangParser.NotEqual, 0); }
		public TerminalNode And() { return getToken(SimpleLangParser.And, 0); }
		public TerminalNode Xor() { return getToken(SimpleLangParser.Xor, 0); }
		public TerminalNode Or() { return getToken(SimpleLangParser.Or, 0); }
		public TerminalNode AndAnd() { return getToken(SimpleLangParser.AndAnd, 0); }
		public TerminalNode OrOr() { return getToken(SimpleLangParser.OrOr, 0); }
		public TerminalNode Question() { return getToken(SimpleLangParser.Question, 0); }
		public TerminalNode Colon() { return getToken(SimpleLangParser.Colon, 0); }
		public AssignmentOperatorContext assignmentOperator() {
			return getRuleContext(AssignmentOperatorContext.class,0);
		}
		public TerminalNode LeftBracket() { return getToken(SimpleLangParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(SimpleLangParser.RightBracket, 0); }
		public ArgumentExpressionListContext argumentExpressionList() {
			return getRuleContext(ArgumentExpressionListContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(142);
				((ExpressionContext)_localctx).id = match(Identifier);
				((ExpressionContext)_localctx).expRet =  new Identifier((((ExpressionContext)_localctx).id!=null?((ExpressionContext)_localctx).id.getText():null), ((ExpressionContext)_localctx).id.getLine());
				}
				break;
			case 2:
				{
				setState(144);
				((ExpressionContext)_localctx).c = constant();
				((ExpressionContext)_localctx).expRet =  ((ExpressionContext)_localctx).c.cret;  _localctx.expRet.setLine((((ExpressionContext)_localctx).c!=null?(((ExpressionContext)_localctx).c.start):null).getLine());
				}
				break;
			case 3:
				{
				List<String> list = new ArrayList<>();
				setState(150); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(148);
						((ExpressionContext)_localctx).str = match(StringLiteral);
						list.add((((ExpressionContext)_localctx).str!=null?((ExpressionContext)_localctx).str.getText():null));
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(152); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				((ExpressionContext)_localctx).expRet =  new StringExpr(list); _localctx.expRet.setLine(_localctx.start.getLine());
				}
				break;
			case 4:
				{
				setState(155);
				match(LeftParen);
				setState(156);
				((ExpressionContext)_localctx).e = expression(0);
				setState(157);
				match(RightParen);
				((ExpressionContext)_localctx).expRet =  ((ExpressionContext)_localctx).e.expRet; _localctx.expRet.setLine(_localctx.start.getLine());
				}
				break;
			case 5:
				{
				setState(160);
				match(LeftParen);
				setState(161);
				((ExpressionContext)_localctx).t = typeName();
				setState(162);
				match(RightParen);
				setState(163);
				match(LeftBrace);
				setState(164);
				((ExpressionContext)_localctx).i = initializerList();
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(165);
					match(Comma);
					}
				}

				setState(168);
				match(RightBrace);
				((ExpressionContext)_localctx).expRet =  new IniListExpr(((ExpressionContext)_localctx).t.typeRet, ((ExpressionContext)_localctx).i.list); _localctx.expRet.setLine(_localctx.start.getLine());
				}
				break;
			case 6:
				{
				 List<Token> ops = new ArrayList<>(); 
				setState(176);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(172);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 343597449216L) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						ops.add(((ExpressionContext)_localctx).op);
						}
						} 
					}
					setState(178);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				}
				setState(218);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(179);
					((ExpressionContext)_localctx).id = match(Identifier);
					((ExpressionContext)_localctx).expRet =  new Identifier((((ExpressionContext)_localctx).id!=null?((ExpressionContext)_localctx).id.getText():null), ((ExpressionContext)_localctx).id.getLine()); 
					}
					break;
				case 2:
					{
					setState(181);
					((ExpressionContext)_localctx).c = constant();
					((ExpressionContext)_localctx).expRet =  ((ExpressionContext)_localctx).c.cret;
					}
					break;
				case 3:
					{
					List<String> list = new ArrayList<>();
					setState(187); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(185);
							((ExpressionContext)_localctx).str = match(StringLiteral);
							list.add((((ExpressionContext)_localctx).str!=null?((ExpressionContext)_localctx).str.getText():null));
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(189); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					((ExpressionContext)_localctx).expRet =  new StringExpr(list);
					}
					break;
				case 4:
					{
					setState(192);
					match(LeftParen);
					setState(193);
					((ExpressionContext)_localctx).e = expression(0);
					setState(194);
					match(RightParen);
					((ExpressionContext)_localctx).expRet =  ((ExpressionContext)_localctx).e.expRet;
					}
					break;
				case 5:
					{
					setState(197);
					match(LeftParen);
					setState(198);
					((ExpressionContext)_localctx).t = typeName();
					setState(199);
					match(RightParen);
					setState(200);
					match(LeftBrace);
					setState(201);
					((ExpressionContext)_localctx).i = initializerList();
					setState(203);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Comma) {
						{
						setState(202);
						match(Comma);
						}
					}

					setState(205);
					match(RightBrace);
					((ExpressionContext)_localctx).expRet =  new IniListExpr(((ExpressionContext)_localctx).t.typeRet, ((ExpressionContext)_localctx).i.list);
					}
					break;
				case 6:
					{
					setState(208);
					((ExpressionContext)_localctx).u = unaryOperator();
					setState(209);
					((ExpressionContext)_localctx).ce = castExpression();
					 ((ExpressionContext)_localctx).expRet =  new UnaryExpr(((ExpressionContext)_localctx).ce.expRet, ((ExpressionContext)_localctx).u.op); 
					}
					break;
				case 7:
					{
					setState(212);
					match(Sizeof);
					setState(213);
					match(LeftParen);
					setState(214);
					((ExpressionContext)_localctx).t = typeName();
					setState(215);
					match(RightParen);
					 ((ExpressionContext)_localctx).expRet =  new SizeofTypeExpr(((ExpressionContext)_localctx).t.typeRet);
					}
					break;
				}

				      for (int i = ops.size() - 1; i >= 0; i--) {
				        Token op = ops.get(i);
				        switch (op.getType()) {
				          case PlusPlus:
				            ((ExpressionContext)_localctx).expRet =  new UnaryExpr(_localctx.expRet, UnaryOperator.PRE_INC);
				            break;
				          case MinusMinus:
				            ((ExpressionContext)_localctx).expRet =  new UnaryExpr(_localctx.expRet, UnaryOperator.PRE_DEC);
				            break;
				          case Sizeof:
				            ((ExpressionContext)_localctx).expRet =  new UnaryExpr(_localctx.expRet, UnaryOperator.SIZEOF);
				            break;
				        }
				      }
				      _localctx.expRet.setLine(_localctx.start.getLine());
				    
				}
				break;
			case 7:
				{
				setState(221);
				match(LeftParen);
				setState(222);
				((ExpressionContext)_localctx).tn = typeName();
				setState(223);
				match(RightParen);
				setState(224);
				((ExpressionContext)_localctx).ce = castExpression();
				 ((ExpressionContext)_localctx).expRet =  new CastExpr(((ExpressionContext)_localctx).tn.typeRet, ((ExpressionContext)_localctx).ce.expRet); _localctx.expRet.setLine(_localctx.start.getLine());
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(312);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(310);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(229);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(230);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3848290697216L) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(231);
						((ExpressionContext)_localctx).e2 = expression(13);
						BinaryOperator op = BinaryOperator.fromString((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null));
						                   ((ExpressionContext)_localctx).expRet =  new BinaryExpr(((ExpressionContext)_localctx).e1.expRet, op, ((ExpressionContext)_localctx).e2.expRet);
						                   _localctx.expRet.setLine(_localctx.start.getLine());
						                  
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(234);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(235);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Plus || _la==Minus) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(236);
						((ExpressionContext)_localctx).e2 = expression(12);
						BinaryOperator op = BinaryOperator.fromString((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null));
						                   ((ExpressionContext)_localctx).expRet =  new BinaryExpr(((ExpressionContext)_localctx).e1.expRet, op, ((ExpressionContext)_localctx).e2.expRet);
						                   _localctx.expRet.setLine(_localctx.start.getLine());
						                  
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(239);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(240);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==LeftShift || _la==RightShift) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(241);
						((ExpressionContext)_localctx).e2 = expression(11);
						BinaryOperator op = BinaryOperator.fromString((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null));
						                  ((ExpressionContext)_localctx).expRet =  new BinaryExpr(((ExpressionContext)_localctx).e1.expRet, op, ((ExpressionContext)_localctx).e2.expRet);
						                  _localctx.expRet.setLine(_localctx.start.getLine());
						                  
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(244);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(245);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8053063680L) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(246);
						((ExpressionContext)_localctx).e2 = expression(10);
						BinaryOperator op = BinaryOperator.fromString((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null));
						                  ((ExpressionContext)_localctx).expRet =  new BinaryExpr(((ExpressionContext)_localctx).e1.expRet, op, ((ExpressionContext)_localctx).e2.expRet);
						                  _localctx.expRet.setLine(_localctx.start.getLine());
						                  
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(249);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(250);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Equal || _la==NotEqual) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(251);
						((ExpressionContext)_localctx).e2 = expression(9);
						BinaryOperator op = BinaryOperator.fromString((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null));
						                   ((ExpressionContext)_localctx).expRet =  new BinaryExpr(((ExpressionContext)_localctx).e1.expRet, op, ((ExpressionContext)_localctx).e2.expRet);
						                   _localctx.expRet.setLine(_localctx.start.getLine());
						                  
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(254);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(255);
						((ExpressionContext)_localctx).op = match(And);
						setState(256);
						((ExpressionContext)_localctx).e2 = expression(8);
						BinaryOperator op = BinaryOperator.fromString((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null));
						                   ((ExpressionContext)_localctx).expRet =  new BinaryExpr(((ExpressionContext)_localctx).e1.expRet, op, ((ExpressionContext)_localctx).e2.expRet);
						                   _localctx.expRet.setLine(_localctx.start.getLine());
						                  
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(259);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(260);
						((ExpressionContext)_localctx).op = match(Xor);
						setState(261);
						((ExpressionContext)_localctx).e2 = expression(7);
						BinaryOperator op = BinaryOperator.fromString((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null));
						                   ((ExpressionContext)_localctx).expRet =  new BinaryExpr(((ExpressionContext)_localctx).e1.expRet, op, ((ExpressionContext)_localctx).e2.expRet);
						                   _localctx.expRet.setLine(_localctx.start.getLine());
						                  
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(264);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(265);
						((ExpressionContext)_localctx).op = match(Or);
						setState(266);
						((ExpressionContext)_localctx).e2 = expression(6);
						BinaryOperator op = BinaryOperator.fromString((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null));
						                   ((ExpressionContext)_localctx).expRet =  new BinaryExpr(((ExpressionContext)_localctx).e1.expRet, op, ((ExpressionContext)_localctx).e2.expRet);
						                   _localctx.expRet.setLine(_localctx.start.getLine());
						                  
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(269);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(270);
						((ExpressionContext)_localctx).op = match(AndAnd);
						setState(271);
						((ExpressionContext)_localctx).e2 = expression(5);
						BinaryOperator op = BinaryOperator.fromString((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null));
						                   ((ExpressionContext)_localctx).expRet =  new BinaryExpr(((ExpressionContext)_localctx).e1.expRet, op, ((ExpressionContext)_localctx).e2.expRet);
						                   _localctx.expRet.setLine(_localctx.start.getLine());
						                  
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(274);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(275);
						((ExpressionContext)_localctx).op = match(OrOr);
						setState(276);
						((ExpressionContext)_localctx).e2 = expression(4);
						BinaryOperator op = BinaryOperator.fromString((((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null));
						                   ((ExpressionContext)_localctx).expRet =  new BinaryExpr(((ExpressionContext)_localctx).e1.expRet, op, ((ExpressionContext)_localctx).e2.expRet);
						                   _localctx.expRet.setLine(_localctx.start.getLine());
						                  
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(279);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(280);
						match(Question);
						setState(281);
						((ExpressionContext)_localctx).e2 = expression(0);
						setState(282);
						match(Colon);
						setState(283);
						((ExpressionContext)_localctx).e3 = expression(3);
						 ((ExpressionContext)_localctx).expRet =  new TernaryExpr(((ExpressionContext)_localctx).e1.expRet, ((ExpressionContext)_localctx).e2.expRet, ((ExpressionContext)_localctx).e3.expRet);
						                    _localctx.expRet.setLine(_localctx.start.getLine());
						                  
						}
						break;
					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(286);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(287);
						((ExpressionContext)_localctx).op2 = assignmentOperator();
						setState(288);
						((ExpressionContext)_localctx).e2 = expression(2);
						BinaryOperator op = BinaryOperator.fromString(((ExpressionContext)_localctx).op2.text);
						                   ((ExpressionContext)_localctx).expRet =  new BinaryExpr(((ExpressionContext)_localctx).e1.expRet, op, ((ExpressionContext)_localctx).e2.expRet);
						                   _localctx.expRet.setLine(_localctx.start.getLine());
						                  
						}
						break;
					case 13:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(291);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(292);
						match(LeftBracket);
						setState(293);
						((ExpressionContext)_localctx).e2 = expression(0);
						setState(294);
						match(RightBracket);
						 ((ExpressionContext)_localctx).expRet =  new ArrayExpr(((ExpressionContext)_localctx).e1.expRet, ((ExpressionContext)_localctx).e2.expRet); _localctx.expRet.setLine(_localctx.start.getLine());
						}
						break;
					case 14:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(297);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(298);
						match(LeftParen);
						setState(300);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 247697986031190145L) != 0)) {
							{
							setState(299);
							((ExpressionContext)_localctx).l = argumentExpressionList();
							}
						}

						setState(302);
						match(RightParen);
						((ExpressionContext)_localctx).expRet =  new FunctionExpr(((ExpressionContext)_localctx).e.expRet, ((ExpressionContext)_localctx).l!=null? ((ExpressionContext)_localctx).l.list: new ArrayList<>()); _localctx.expRet.setLine(_localctx.start.getLine());
						}
						break;
					case 15:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(304);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(305);
						match(PlusPlus);
						((ExpressionContext)_localctx).expRet =  new UnaryExpr(((ExpressionContext)_localctx).e.expRet, UnaryOperator.POST_INC); _localctx.expRet.setLine(_localctx.start.getLine());
						}
						break;
					case 16:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(307);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(308);
						match(MinusMinus);
						((ExpressionContext)_localctx).expRet =  new UnaryExpr(((ExpressionContext)_localctx).e.expRet, UnaryOperator.POST_DEC); _localctx.expRet.setLine(_localctx.start.getLine());
						}
						break;
					}
					} 
				}
				setState(314);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentExpressionListContext extends ParserRuleContext {
		public List<Expr> list;
		public ExpressionContext e;
		public ExpressionContext e2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SimpleLangParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SimpleLangParser.Comma, i);
		}
		public ArgumentExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentExpressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterArgumentExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitArgumentExpressionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitArgumentExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentExpressionListContext argumentExpressionList() throws RecognitionException {
		ArgumentExpressionListContext _localctx = new ArgumentExpressionListContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_argumentExpressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((ArgumentExpressionListContext)_localctx).list =  new ArrayList<>();
			setState(316);
			((ArgumentExpressionListContext)_localctx).e = expression(0);
			_localctx.list.add(((ArgumentExpressionListContext)_localctx).e.expRet);
			setState(324);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(318);
				match(Comma);
				setState(319);
				((ArgumentExpressionListContext)_localctx).e2 = expression(0);
				_localctx.list.add(((ArgumentExpressionListContext)_localctx).e2.expRet);
				}
				}
				setState(326);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryOperatorContext extends ParserRuleContext {
		public UnaryOperator op;
		public TerminalNode And() { return getToken(SimpleLangParser.And, 0); }
		public TerminalNode Star() { return getToken(SimpleLangParser.Star, 0); }
		public TerminalNode Plus() { return getToken(SimpleLangParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(SimpleLangParser.Minus, 0); }
		public TerminalNode Tilde() { return getToken(SimpleLangParser.Tilde, 0); }
		public TerminalNode Not() { return getToken(SimpleLangParser.Not, 0); }
		public UnaryOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterUnaryOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitUnaryOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitUnaryOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryOperatorContext unaryOperator() throws RecognitionException {
		UnaryOperatorContext _localctx = new UnaryOperatorContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_unaryOperator);
		try {
			setState(339);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case And:
				enterOuterAlt(_localctx, 1);
				{
				setState(327);
				match(And);
				((UnaryOperatorContext)_localctx).op =  UnaryOperator.AND;
				}
				break;
			case Star:
				enterOuterAlt(_localctx, 2);
				{
				setState(329);
				match(Star);
				((UnaryOperatorContext)_localctx).op =  UnaryOperator.STAR;
				}
				break;
			case Plus:
				enterOuterAlt(_localctx, 3);
				{
				setState(331);
				match(Plus);
				((UnaryOperatorContext)_localctx).op =  UnaryOperator.PLUS;
				}
				break;
			case Minus:
				enterOuterAlt(_localctx, 4);
				{
				setState(333);
				match(Minus);
				((UnaryOperatorContext)_localctx).op =  UnaryOperator.MINUS;
				}
				break;
			case Tilde:
				enterOuterAlt(_localctx, 5);
				{
				setState(335);
				match(Tilde);
				((UnaryOperatorContext)_localctx).op =  UnaryOperator.TILDE;
				}
				break;
			case Not:
				enterOuterAlt(_localctx, 6);
				{
				setState(337);
				match(Not);
				((UnaryOperatorContext)_localctx).op =  UnaryOperator.NOT;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CastExpressionContext extends ParserRuleContext {
		public Expr expRet;
		public TypeNameContext tn;
		public CastExpressionContext ce;
		public ExpressionContext e;
		public Token d;
		public TerminalNode LeftParen() { return getToken(SimpleLangParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(SimpleLangParser.RightParen, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public CastExpressionContext castExpression() {
			return getRuleContext(CastExpressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DigitSequence() { return getToken(SimpleLangParser.DigitSequence, 0); }
		public CastExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterCastExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitCastExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitCastExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CastExpressionContext castExpression() throws RecognitionException {
		CastExpressionContext _localctx = new CastExpressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_castExpression);
		try {
			setState(352);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(341);
				match(LeftParen);
				setState(342);
				((CastExpressionContext)_localctx).tn = typeName();
				setState(343);
				match(RightParen);
				setState(344);
				((CastExpressionContext)_localctx).ce = castExpression();
				 ((CastExpressionContext)_localctx).expRet =  new CastExpr(((CastExpressionContext)_localctx).tn.typeRet, ((CastExpressionContext)_localctx).ce.expRet); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(347);
				((CastExpressionContext)_localctx).e = expression(0);
				 ((CastExpressionContext)_localctx).expRet =  ((CastExpressionContext)_localctx).e.expRet; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(350);
				((CastExpressionContext)_localctx).d = match(DigitSequence);
				((CastExpressionContext)_localctx).expRet =  new IntVal((((CastExpressionContext)_localctx).d!=null?((CastExpressionContext)_localctx).d.getText():null));
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentOperatorContext extends ParserRuleContext {
		public String text;
		public Token cm;
		public TerminalNode Assign() { return getToken(SimpleLangParser.Assign, 0); }
		public TerminalNode StarAssign() { return getToken(SimpleLangParser.StarAssign, 0); }
		public TerminalNode DivAssign() { return getToken(SimpleLangParser.DivAssign, 0); }
		public TerminalNode ModAssign() { return getToken(SimpleLangParser.ModAssign, 0); }
		public TerminalNode PlusAssign() { return getToken(SimpleLangParser.PlusAssign, 0); }
		public TerminalNode MinusAssign() { return getToken(SimpleLangParser.MinusAssign, 0); }
		public TerminalNode LeftShiftAssign() { return getToken(SimpleLangParser.LeftShiftAssign, 0); }
		public TerminalNode RightShiftAssign() { return getToken(SimpleLangParser.RightShiftAssign, 0); }
		public TerminalNode AndAssign() { return getToken(SimpleLangParser.AndAssign, 0); }
		public TerminalNode XorAssign() { return getToken(SimpleLangParser.XorAssign, 0); }
		public TerminalNode OrAssign() { return getToken(SimpleLangParser.OrAssign, 0); }
		public AssignmentOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterAssignmentOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitAssignmentOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitAssignmentOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentOperatorContext assignmentOperator() throws RecognitionException {
		AssignmentOperatorContext _localctx = new AssignmentOperatorContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_assignmentOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			((AssignmentOperatorContext)_localctx).cm = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & -9007199254740992L) != 0)) ) {
				((AssignmentOperatorContext)_localctx).cm = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			((AssignmentOperatorContext)_localctx).text =  ((AssignmentOperatorContext)_localctx).cm.getText();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public Declaration decRet;
		public DeclarationSpecifiersContext specs;
		public InitDeclaratorListContext decl;
		public TerminalNode Semi() { return getToken(SimpleLangParser.Semi, 0); }
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
		}
		public InitDeclaratorListContext initDeclaratorList() {
			return getRuleContext(InitDeclaratorListContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(357);
			((DeclarationContext)_localctx).specs = declarationSpecifiers();
			setState(358);
			((DeclarationContext)_localctx).decl = initDeclaratorList();
			setState(359);
			match(Semi);

			        ((DeclarationContext)_localctx).decRet =  new Declaration(((DeclarationContext)_localctx).specs.list, ((DeclarationContext)_localctx).decl != null ? ((DeclarationContext)_localctx).decl.list : null);
			        _localctx.decRet.setLine(_localctx.start.getLine());
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationSpecifiersContext extends ParserRuleContext {
		public List<Type> list;
		public DeclarationSpecifierContext spec;
		public List<DeclarationSpecifierContext> declarationSpecifier() {
			return getRuleContexts(DeclarationSpecifierContext.class);
		}
		public DeclarationSpecifierContext declarationSpecifier(int i) {
			return getRuleContext(DeclarationSpecifierContext.class,i);
		}
		public DeclarationSpecifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationSpecifiers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterDeclarationSpecifiers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitDeclarationSpecifiers(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitDeclarationSpecifiers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationSpecifiersContext declarationSpecifiers() throws RecognitionException {
		DeclarationSpecifiersContext _localctx = new DeclarationSpecifiersContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_declarationSpecifiers);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			((DeclarationSpecifiersContext)_localctx).list =  new ArrayList<>();
			setState(366); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(363);
					((DeclarationSpecifiersContext)_localctx).spec = declarationSpecifier();
					_localctx.list.add(((DeclarationSpecifiersContext)_localctx).spec.typeRet);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(368); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationSpecifierContext extends ParserRuleContext {
		public Type typeRet;
		public Token td;
		public TypeSpecifierContext ts;
		public Token c;
		public TerminalNode Typedef() { return getToken(SimpleLangParser.Typedef, 0); }
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public TerminalNode Const() { return getToken(SimpleLangParser.Const, 0); }
		public DeclarationSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterDeclarationSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitDeclarationSpecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitDeclarationSpecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationSpecifierContext declarationSpecifier() throws RecognitionException {
		DeclarationSpecifierContext _localctx = new DeclarationSpecifierContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_declarationSpecifier);
		try {
			setState(377);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Typedef:
				enterOuterAlt(_localctx, 1);
				{
				setState(370);
				((DeclarationSpecifierContext)_localctx).td = match(Typedef);
				((DeclarationSpecifierContext)_localctx).typeRet =  Type.TYPEDEF;
				}
				break;
			case Char:
			case Double:
			case Float:
			case Int:
			case Long:
			case Short:
			case Signed:
			case Unsigned:
			case Void:
			case Bool:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(372);
				((DeclarationSpecifierContext)_localctx).ts = typeSpecifier();
				((DeclarationSpecifierContext)_localctx).typeRet =  ((DeclarationSpecifierContext)_localctx).ts.typeRet;
				}
				break;
			case Const:
				enterOuterAlt(_localctx, 3);
				{
				setState(375);
				((DeclarationSpecifierContext)_localctx).c = match(Const);
				((DeclarationSpecifierContext)_localctx).typeRet =  Type.CONST;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InitDeclaratorListContext extends ParserRuleContext {
		public List<InitDeclarator> list;
		public InitDeclaratorContext i0;
		public InitDeclaratorContext ii;
		public List<InitDeclaratorContext> initDeclarator() {
			return getRuleContexts(InitDeclaratorContext.class);
		}
		public InitDeclaratorContext initDeclarator(int i) {
			return getRuleContext(InitDeclaratorContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SimpleLangParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SimpleLangParser.Comma, i);
		}
		public InitDeclaratorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initDeclaratorList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterInitDeclaratorList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitInitDeclaratorList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitInitDeclaratorList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitDeclaratorListContext initDeclaratorList() throws RecognitionException {
		InitDeclaratorListContext _localctx = new InitDeclaratorListContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_initDeclaratorList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((InitDeclaratorListContext)_localctx).list =  new ArrayList<>();
			setState(380);
			((InitDeclaratorListContext)_localctx).i0 = initDeclarator();
			_localctx.list.add(((InitDeclaratorListContext)_localctx).i0.initDecRet);
			setState(388);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(382);
				match(Comma);
				setState(383);
				((InitDeclaratorListContext)_localctx).ii = initDeclarator();
				_localctx.list.add(((InitDeclaratorListContext)_localctx).ii.initDecRet);
				}
				}
				setState(390);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InitDeclaratorContext extends ParserRuleContext {
		public InitDeclarator initDecRet;
		public DeclaratorContext dec;
		public InitializerContext ini;
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public TerminalNode Assign() { return getToken(SimpleLangParser.Assign, 0); }
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
		}
		public InitDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterInitDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitInitDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitInitDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitDeclaratorContext initDeclarator() throws RecognitionException {
		InitDeclaratorContext _localctx = new InitDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_initDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(391);
			((InitDeclaratorContext)_localctx).dec = declarator();
			((InitDeclaratorContext)_localctx).initDecRet =  new InitDeclarator(((InitDeclaratorContext)_localctx).dec.declaratorRet);
			setState(397);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(393);
				match(Assign);
				setState(394);
				((InitDeclaratorContext)_localctx).ini = initializer();
				_localctx.initDecRet.addInitializer(((InitDeclaratorContext)_localctx).ini.iniRet);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeSpecifierContext extends ParserRuleContext {
		public Type typeRet;
		public Token id;
		public TerminalNode Void() { return getToken(SimpleLangParser.Void, 0); }
		public TerminalNode Char() { return getToken(SimpleLangParser.Char, 0); }
		public TerminalNode Short() { return getToken(SimpleLangParser.Short, 0); }
		public TerminalNode Int() { return getToken(SimpleLangParser.Int, 0); }
		public TerminalNode Long() { return getToken(SimpleLangParser.Long, 0); }
		public TerminalNode Float() { return getToken(SimpleLangParser.Float, 0); }
		public TerminalNode Double() { return getToken(SimpleLangParser.Double, 0); }
		public TerminalNode Signed() { return getToken(SimpleLangParser.Signed, 0); }
		public TerminalNode Unsigned() { return getToken(SimpleLangParser.Unsigned, 0); }
		public TerminalNode Bool() { return getToken(SimpleLangParser.Bool, 0); }
		public TerminalNode Identifier() { return getToken(SimpleLangParser.Identifier, 0); }
		public TypeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterTypeSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitTypeSpecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitTypeSpecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeSpecifierContext typeSpecifier() throws RecognitionException {
		TypeSpecifierContext _localctx = new TypeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_typeSpecifier);
		try {
			setState(421);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Void:
				enterOuterAlt(_localctx, 1);
				{
				setState(399);
				match(Void);
				 ((TypeSpecifierContext)_localctx).typeRet =  Type.VOID; 
				}
				break;
			case Char:
				enterOuterAlt(_localctx, 2);
				{
				setState(401);
				match(Char);
				 ((TypeSpecifierContext)_localctx).typeRet =  Type.CHAR; 
				}
				break;
			case Short:
				enterOuterAlt(_localctx, 3);
				{
				setState(403);
				match(Short);
				 ((TypeSpecifierContext)_localctx).typeRet =  Type.SHORT; 
				}
				break;
			case Int:
				enterOuterAlt(_localctx, 4);
				{
				setState(405);
				match(Int);
				 ((TypeSpecifierContext)_localctx).typeRet =  Type.INT; 
				}
				break;
			case Long:
				enterOuterAlt(_localctx, 5);
				{
				setState(407);
				match(Long);
				 ((TypeSpecifierContext)_localctx).typeRet =  Type.LONG; 
				}
				break;
			case Float:
				enterOuterAlt(_localctx, 6);
				{
				setState(409);
				match(Float);
				 ((TypeSpecifierContext)_localctx).typeRet =  Type.FLOAT; 
				}
				break;
			case Double:
				enterOuterAlt(_localctx, 7);
				{
				setState(411);
				match(Double);
				 ((TypeSpecifierContext)_localctx).typeRet =  Type.DOUBLE; 
				}
				break;
			case Signed:
				enterOuterAlt(_localctx, 8);
				{
				setState(413);
				match(Signed);
				 ((TypeSpecifierContext)_localctx).typeRet =  Type.SIGNED; 
				}
				break;
			case Unsigned:
				enterOuterAlt(_localctx, 9);
				{
				setState(415);
				match(Unsigned);
				 ((TypeSpecifierContext)_localctx).typeRet =  Type.UNSIGNED; 
				}
				break;
			case Bool:
				enterOuterAlt(_localctx, 10);
				{
				setState(417);
				match(Bool);
				 ((TypeSpecifierContext)_localctx).typeRet =  Type.BOOL; 
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 11);
				{
				setState(419);
				((TypeSpecifierContext)_localctx).id = match(Identifier);

				        ((TypeSpecifierContext)_localctx).typeRet =  Type.IDENTIFIER;
				        _localctx.typeRet.setIdentifierName(((TypeSpecifierContext)_localctx).id.getText());
				      
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SpecifierQualifierListContext extends ParserRuleContext {
		public List<Type> list;
		public TypeSpecifierContext ts;
		public SpecifierQualifierListContext sq;
		public TerminalNode Const() { return getToken(SimpleLangParser.Const, 0); }
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public SpecifierQualifierListContext specifierQualifierList() {
			return getRuleContext(SpecifierQualifierListContext.class,0);
		}
		public SpecifierQualifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specifierQualifierList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterSpecifierQualifierList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitSpecifierQualifierList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitSpecifierQualifierList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecifierQualifierListContext specifierQualifierList() throws RecognitionException {
		SpecifierQualifierListContext _localctx = new SpecifierQualifierListContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_specifierQualifierList);
		((SpecifierQualifierListContext)_localctx).list =  new ArrayList<>();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(428);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Char:
			case Double:
			case Float:
			case Int:
			case Long:
			case Short:
			case Signed:
			case Unsigned:
			case Void:
			case Bool:
			case Identifier:
				{
				setState(423);
				((SpecifierQualifierListContext)_localctx).ts = typeSpecifier();
				_localctx.list.add(((SpecifierQualifierListContext)_localctx).ts.typeRet);
				}
				break;
			case Const:
				{
				setState(426);
				match(Const);
				_localctx.list.add(Type.CONST);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(433);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5822796L) != 0) || _la==Identifier) {
				{
				setState(430);
				((SpecifierQualifierListContext)_localctx).sq = specifierQualifierList();
				_localctx.list.addAll(((SpecifierQualifierListContext)_localctx).sq.list);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaratorContext extends ParserRuleContext {
		public Declarator declaratorRet;
		public PointerContext p;
		public DirectDeclaratorContext d;
		public DirectDeclaratorContext directDeclarator() {
			return getRuleContext(DirectDeclaratorContext.class,0);
		}
		public PointerContext pointer() {
			return getRuleContext(PointerContext.class,0);
		}
		public DeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaratorContext declarator() throws RecognitionException {
		DeclaratorContext _localctx = new DeclaratorContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((DeclaratorContext)_localctx).declaratorRet =  new Declarator(); _localctx.declaratorRet.setLine(_localctx.start.getLine());
			setState(439);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Star) {
				{
				setState(436);
				((DeclaratorContext)_localctx).p = pointer();
				_localctx.declaratorRet.setPointer(((DeclaratorContext)_localctx).p.ptrRet);
				}
			}

			setState(441);
			((DeclaratorContext)_localctx).d = directDeclarator(0);
			_localctx.declaratorRet.setDirectDeclarator(((DeclaratorContext)_localctx).d.ddRet);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DirectDeclaratorContext extends ParserRuleContext {
		public DirectDeclarator ddRet;
		public DirectDeclaratorContext dd;
		public Token id;
		public DeclaratorContext d;
		public ExpressionContext exp;
		public ParameterListContext pl;
		public IdentifierListContext idl;
		public TerminalNode Identifier() { return getToken(SimpleLangParser.Identifier, 0); }
		public TerminalNode LeftParen() { return getToken(SimpleLangParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(SimpleLangParser.RightParen, 0); }
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public TerminalNode LeftBracket() { return getToken(SimpleLangParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(SimpleLangParser.RightBracket, 0); }
		public DirectDeclaratorContext directDeclarator() {
			return getRuleContext(DirectDeclaratorContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public DirectDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterDirectDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitDirectDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitDirectDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DirectDeclaratorContext directDeclarator() throws RecognitionException {
		return directDeclarator(0);
	}

	private DirectDeclaratorContext directDeclarator(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		DirectDeclaratorContext _localctx = new DirectDeclaratorContext(_ctx, _parentState);
		DirectDeclaratorContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_directDeclarator, _p);
		((DirectDeclaratorContext)_localctx).ddRet =  new DirectDeclarator();
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(452);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				{
				setState(445);
				((DirectDeclaratorContext)_localctx).id = match(Identifier);
				_localctx.ddRet.setIdentifier(new Identifier((((DirectDeclaratorContext)_localctx).id!=null?((DirectDeclaratorContext)_localctx).id.getText():null), ((DirectDeclaratorContext)_localctx).id.getLine()));
				}
				break;
			case LeftParen:
				{
				setState(447);
				match(LeftParen);
				setState(448);
				((DirectDeclaratorContext)_localctx).d = declarator();
				setState(449);
				match(RightParen);
				_localctx.ddRet.setInnerDeclarator(((DirectDeclaratorContext)_localctx).d.declaratorRet);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(478);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(476);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
					case 1:
						{
						_localctx = new DirectDeclaratorContext(_parentctx, _parentState);
						_localctx.dd = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_directDeclarator);
						setState(454);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						((DirectDeclaratorContext)_localctx).ddRet =  ((DirectDeclaratorContext)_localctx).dd.ddRet;
						setState(456);
						match(LeftBracket);
						setState(458);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 247697986031190145L) != 0)) {
							{
							setState(457);
							((DirectDeclaratorContext)_localctx).exp = expression(0);
							}
						}

						setState(460);
						match(RightBracket);
						_localctx.ddRet.addArrExpr(((DirectDeclaratorContext)_localctx).exp.expRet);
						}
						break;
					case 2:
						{
						_localctx = new DirectDeclaratorContext(_parentctx, _parentState);
						_localctx.dd = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_directDeclarator);
						setState(462);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						((DirectDeclaratorContext)_localctx).ddRet =  ((DirectDeclaratorContext)_localctx).dd.ddRet;
						setState(464);
						match(LeftParen);
						setState(473);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
						case 1:
							{
							setState(465);
							((DirectDeclaratorContext)_localctx).pl = parameterList();
							_localctx.ddRet.addFuncParams(((DirectDeclaratorContext)_localctx).pl.list);
							}
							break;
						case 2:
							{
							setState(471);
							_errHandler.sync(this);
							_la = _input.LA(1);
							if (_la==Identifier) {
								{
								setState(468);
								((DirectDeclaratorContext)_localctx).idl = identifierList();
								_localctx.ddRet.addFuncIdentifiers(((DirectDeclaratorContext)_localctx).idl.list);
								}
							}

							}
							break;
						}
						setState(475);
						match(RightParen);
						}
						break;
					}
					} 
				}
				setState(480);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PointerContext extends ParserRuleContext {
		public Pointer ptrRet;
		public Token Const;
		public List<Token> c = new ArrayList<Token>();
		public List<TerminalNode> Star() { return getTokens(SimpleLangParser.Star); }
		public TerminalNode Star(int i) {
			return getToken(SimpleLangParser.Star, i);
		}
		public List<TerminalNode> Const() { return getTokens(SimpleLangParser.Const); }
		public TerminalNode Const(int i) {
			return getToken(SimpleLangParser.Const, i);
		}
		public PointerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterPointer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitPointer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitPointer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PointerContext pointer() throws RecognitionException {
		PointerContext _localctx = new PointerContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_pointer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

			        ((PointerContext)_localctx).ptrRet =  new Pointer();
			        int stars = 0;
			        List<Integer> constCounts = new ArrayList<>();
			    
			setState(490); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				{
				setState(482);
				match(Star);
				setState(486);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Const) {
					{
					{
					setState(483);
					((PointerContext)_localctx).Const = match(Const);
					((PointerContext)_localctx).c.add(((PointerContext)_localctx).Const);
					}
					}
					setState(488);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				stars++; constCounts.add(((PointerContext)_localctx).c.size());
				}
				}
				}
				setState(492); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Star );

			        _localctx.ptrRet.setStarCount(stars);
			        _localctx.ptrRet.setConstCounts(constCounts);
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterListContext extends ParserRuleContext {
		public List<Parameter> list;
		public ParameterDeclarationContext p;
		public ParameterDeclarationContext p2;
		public List<ParameterDeclarationContext> parameterDeclaration() {
			return getRuleContexts(ParameterDeclarationContext.class);
		}
		public ParameterDeclarationContext parameterDeclaration(int i) {
			return getRuleContext(ParameterDeclarationContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SimpleLangParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SimpleLangParser.Comma, i);
		}
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((ParameterListContext)_localctx).list =  new ArrayList<>();
			setState(497);
			((ParameterListContext)_localctx).p = parameterDeclaration();
			_localctx.list.add(((ParameterListContext)_localctx).p.paramRet);
			setState(505);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(499);
				match(Comma);
				setState(500);
				((ParameterListContext)_localctx).p2 = parameterDeclaration();
				_localctx.list.add(((ParameterListContext)_localctx).p2.paramRet);
				}
				}
				setState(507);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterDeclarationContext extends ParserRuleContext {
		public Parameter paramRet;
		public DeclarationSpecifiersContext ds;
		public DeclaratorContext d;
		public AbstractDeclaratorContext d2;
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
		}
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public AbstractDeclaratorContext abstractDeclarator() {
			return getRuleContext(AbstractDeclaratorContext.class,0);
		}
		public ParameterDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterParameterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitParameterDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitParameterDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterDeclarationContext parameterDeclaration() throws RecognitionException {
		ParameterDeclarationContext _localctx = new ParameterDeclarationContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_parameterDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(508);
			((ParameterDeclarationContext)_localctx).ds = declarationSpecifiers();
			((ParameterDeclarationContext)_localctx).paramRet =  new Parameter(((ParameterDeclarationContext)_localctx).ds.list);
			setState(516);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(510);
				((ParameterDeclarationContext)_localctx).d = declarator();
				_localctx.paramRet.setDeclarator(((ParameterDeclarationContext)_localctx).d.declaratorRet);
				}
				break;
			case 2:
				{
				{
				setState(513);
				((ParameterDeclarationContext)_localctx).d2 = abstractDeclarator();
				_localctx.paramRet.setDeclarator(((ParameterDeclarationContext)_localctx).d2.declaratorRet);
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierListContext extends ParserRuleContext {
		public List<Identifier> list;
		public Token id;
		public Token id2;
		public List<TerminalNode> Identifier() { return getTokens(SimpleLangParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(SimpleLangParser.Identifier, i);
		}
		public List<TerminalNode> Comma() { return getTokens(SimpleLangParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SimpleLangParser.Comma, i);
		}
		public IdentifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterIdentifierList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitIdentifierList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitIdentifierList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierListContext identifierList() throws RecognitionException {
		IdentifierListContext _localctx = new IdentifierListContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_identifierList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((IdentifierListContext)_localctx).list =  new ArrayList<>();
			setState(519);
			((IdentifierListContext)_localctx).id = match(Identifier);
			_localctx.list.add(new Identifier((((IdentifierListContext)_localctx).id!=null?((IdentifierListContext)_localctx).id.getText():null), ((IdentifierListContext)_localctx).id.getLine()));
			setState(526);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(521);
				match(Comma);
				setState(522);
				((IdentifierListContext)_localctx).id2 = match(Identifier);
				_localctx.list.add(new Identifier((((IdentifierListContext)_localctx).id!=null?((IdentifierListContext)_localctx).id.getText():null), ((IdentifierListContext)_localctx).id.getLine()));
				}
				}
				setState(528);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeNameContext extends ParserRuleContext {
		public Typename typeRet;
		public SpecifierQualifierListContext spl;
		public AbstractDeclaratorContext d;
		public SpecifierQualifierListContext specifierQualifierList() {
			return getRuleContext(SpecifierQualifierListContext.class,0);
		}
		public AbstractDeclaratorContext abstractDeclarator() {
			return getRuleContext(AbstractDeclaratorContext.class,0);
		}
		public TypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitTypeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitTypeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeNameContext typeName() throws RecognitionException {
		TypeNameContext _localctx = new TypeNameContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_typeName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((TypeNameContext)_localctx).typeRet =  new Typename();
			setState(530);
			((TypeNameContext)_localctx).spl = specifierQualifierList();
			_localctx.typeRet.setTypes(((TypeNameContext)_localctx).spl.list);
			setState(535);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 549797756928L) != 0)) {
				{
				setState(532);
				((TypeNameContext)_localctx).d = abstractDeclarator();
				_localctx.typeRet.setDeclarator(((TypeNameContext)_localctx).d.declaratorRet);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AbstractDeclaratorContext extends ParserRuleContext {
		public Declarator declaratorRet;
		public PointerContext p;
		public DirectAbstractDeclaratorContext dd;
		public PointerContext pointer() {
			return getRuleContext(PointerContext.class,0);
		}
		public DirectAbstractDeclaratorContext directAbstractDeclarator() {
			return getRuleContext(DirectAbstractDeclaratorContext.class,0);
		}
		public AbstractDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abstractDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterAbstractDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitAbstractDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitAbstractDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AbstractDeclaratorContext abstractDeclarator() throws RecognitionException {
		AbstractDeclaratorContext _localctx = new AbstractDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_abstractDeclarator);
		((AbstractDeclaratorContext)_localctx).declaratorRet =  new Declarator();
		int _la;
		try {
			setState(548);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(537);
				((AbstractDeclaratorContext)_localctx).p = pointer();
				_localctx.declaratorRet.setPointer(((AbstractDeclaratorContext)_localctx).p.ptrRet);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(543);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Star) {
					{
					setState(540);
					((AbstractDeclaratorContext)_localctx).p = pointer();
					_localctx.declaratorRet.setPointer(((AbstractDeclaratorContext)_localctx).p.ptrRet);
					}
				}

				setState(545);
				((AbstractDeclaratorContext)_localctx).dd = directAbstractDeclarator(0);
				_localctx.declaratorRet.setDirectDeclarator(((AbstractDeclaratorContext)_localctx).dd.ddRet);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DirectAbstractDeclaratorContext extends ParserRuleContext {
		public DirectDeclarator ddRet;
		public DirectAbstractDeclaratorContext dd;
		public AbstractDeclaratorContext d;
		public ParameterListContext pl;
		public ExpressionContext exp;
		public TerminalNode LeftBracket() { return getToken(SimpleLangParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(SimpleLangParser.RightBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(SimpleLangParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(SimpleLangParser.RightParen, 0); }
		public AbstractDeclaratorContext abstractDeclarator() {
			return getRuleContext(AbstractDeclaratorContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public DirectAbstractDeclaratorContext directAbstractDeclarator() {
			return getRuleContext(DirectAbstractDeclaratorContext.class,0);
		}
		public DirectAbstractDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directAbstractDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterDirectAbstractDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitDirectAbstractDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitDirectAbstractDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DirectAbstractDeclaratorContext directAbstractDeclarator() throws RecognitionException {
		return directAbstractDeclarator(0);
	}

	private DirectAbstractDeclaratorContext directAbstractDeclarator(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		DirectAbstractDeclaratorContext _localctx = new DirectAbstractDeclaratorContext(_ctx, _parentState);
		DirectAbstractDeclaratorContext _prevctx = _localctx;
		int _startState = 52;
		enterRecursionRule(_localctx, 52, RULE_directAbstractDeclarator, _p);
		((DirectAbstractDeclaratorContext)_localctx).ddRet =  new DirectDeclarator();
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(568);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftBracket:
				{
				setState(551);
				match(LeftBracket);
				setState(553);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 247697986031190145L) != 0)) {
					{
					setState(552);
					expression(0);
					}
				}

				setState(555);
				match(RightBracket);
				_localctx.ddRet.addArrExpr(((DirectAbstractDeclaratorContext)_localctx).exp.expRet);
				}
				break;
			case LeftParen:
				{
				setState(557);
				match(LeftParen);
				setState(565);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LeftParen:
				case LeftBracket:
				case Star:
					{
					setState(558);
					((DirectAbstractDeclaratorContext)_localctx).d = abstractDeclarator();
					_localctx.ddRet.setInnerDeclarator(((DirectAbstractDeclaratorContext)_localctx).d.declaratorRet);
					}
					break;
				case Char:
				case Const:
				case Double:
				case Float:
				case Int:
				case Long:
				case Short:
				case Signed:
				case Typedef:
				case Unsigned:
				case Void:
				case Bool:
				case RightParen:
				case Identifier:
					{
					{
					setState(562);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6084940L) != 0) || _la==Identifier) {
						{
						setState(561);
						((DirectAbstractDeclaratorContext)_localctx).pl = parameterList();
						}
					}

					_localctx.ddRet.addFuncParams(((DirectAbstractDeclaratorContext)_localctx).pl.list);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(567);
				match(RightParen);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(588);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(586);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
					case 1:
						{
						_localctx = new DirectAbstractDeclaratorContext(_parentctx, _parentState);
						_localctx.dd = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_directAbstractDeclarator);
						setState(570);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						((DirectAbstractDeclaratorContext)_localctx).ddRet =  ((DirectAbstractDeclaratorContext)_localctx).dd.ddRet;
						setState(572);
						match(LeftBracket);
						setState(574);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 247697986031190145L) != 0)) {
							{
							setState(573);
							((DirectAbstractDeclaratorContext)_localctx).exp = expression(0);
							}
						}

						setState(576);
						match(RightBracket);
						_localctx.ddRet.addArrExpr(((DirectAbstractDeclaratorContext)_localctx).exp.expRet);
						}
						break;
					case 2:
						{
						_localctx = new DirectAbstractDeclaratorContext(_parentctx, _parentState);
						_localctx.dd = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_directAbstractDeclarator);
						setState(578);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						((DirectAbstractDeclaratorContext)_localctx).ddRet =  ((DirectAbstractDeclaratorContext)_localctx).dd.ddRet;
						setState(580);
						match(LeftParen);
						setState(582);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6084940L) != 0) || _la==Identifier) {
							{
							setState(581);
							((DirectAbstractDeclaratorContext)_localctx).pl = parameterList();
							}
						}

						setState(584);
						match(RightParen);
						_localctx.ddRet.addFuncParams(((DirectAbstractDeclaratorContext)_localctx).pl.list);
						}
						break;
					}
					} 
				}
				setState(590);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InitializerContext extends ParserRuleContext {
		public Initializer iniRet;
		public ExpressionContext exp;
		public InitializerListContext i;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LeftBrace() { return getToken(SimpleLangParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(SimpleLangParser.RightBrace, 0); }
		public InitializerListContext initializerList() {
			return getRuleContext(InitializerListContext.class,0);
		}
		public TerminalNode Comma() { return getToken(SimpleLangParser.Comma, 0); }
		public InitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitializerContext initializer() throws RecognitionException {
		InitializerContext _localctx = new InitializerContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_initializer);
		((InitializerContext)_localctx).iniRet =  new Initializer();
		int _la;
		try {
			setState(602);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Sizeof:
			case LeftParen:
			case Plus:
			case PlusPlus:
			case Minus:
			case MinusMinus:
			case Star:
			case And:
			case Not:
			case Tilde:
			case Identifier:
			case IntegerConstant:
			case FloatingConstant:
			case CharacterConstant:
			case StringLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(591);
				((InitializerContext)_localctx).exp = expression(0);
				_localctx.iniRet.setExpr(((InitializerContext)_localctx).exp.expRet);
				}
				break;
			case LeftBrace:
				enterOuterAlt(_localctx, 2);
				{
				setState(594);
				match(LeftBrace);
				setState(595);
				((InitializerContext)_localctx).i = initializerList();
				_localctx.iniRet.setInitializerlist(((InitializerContext)_localctx).i.list);
				setState(598);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(597);
					match(Comma);
					}
				}

				setState(600);
				match(RightBrace);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InitializerListContext extends ParserRuleContext {
		public InitializerList list;
		public DesignationContext d;
		public InitializerContext i;
		public DesignationContext d2;
		public InitializerContext i2;
		public List<InitializerContext> initializer() {
			return getRuleContexts(InitializerContext.class);
		}
		public InitializerContext initializer(int i) {
			return getRuleContext(InitializerContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SimpleLangParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SimpleLangParser.Comma, i);
		}
		public List<DesignationContext> designation() {
			return getRuleContexts(DesignationContext.class);
		}
		public DesignationContext designation(int i) {
			return getRuleContext(DesignationContext.class,i);
		}
		public InitializerListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializerList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterInitializerList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitInitializerList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitInitializerList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitializerListContext initializerList() throws RecognitionException {
		InitializerListContext _localctx = new InitializerListContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_initializerList);
		((InitializerListContext)_localctx).list =  new InitializerList();
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(605);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LeftBracket || _la==Dot) {
				{
				setState(604);
				((InitializerListContext)_localctx).d = designation();
				}
			}

			setState(607);
			((InitializerListContext)_localctx).i = initializer();
			_localctx.list.add(((InitializerListContext)_localctx).d!=null? ((InitializerListContext)_localctx).d.dRet : null, ((InitializerListContext)_localctx).i.iniRet);
			setState(618);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(609);
					match(Comma);
					setState(611);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==LeftBracket || _la==Dot) {
						{
						setState(610);
						((InitializerListContext)_localctx).d2 = designation();
						}
					}

					setState(613);
					((InitializerListContext)_localctx).i2 = initializer();
					_localctx.list.add(((InitializerListContext)_localctx).d2!=null? ((InitializerListContext)_localctx).d2.dRet : null, ((InitializerListContext)_localctx).i2.iniRet);
					}
					} 
				}
				setState(620);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DesignationContext extends ParserRuleContext {
		public Designation dRet;
		public DesignatorContext d;
		public TerminalNode Assign() { return getToken(SimpleLangParser.Assign, 0); }
		public List<DesignatorContext> designator() {
			return getRuleContexts(DesignatorContext.class);
		}
		public DesignatorContext designator(int i) {
			return getRuleContext(DesignatorContext.class,i);
		}
		public DesignationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_designation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterDesignation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitDesignation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitDesignation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DesignationContext designation() throws RecognitionException {
		DesignationContext _localctx = new DesignationContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_designation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((DesignationContext)_localctx).dRet =  new Designation();
			setState(625); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(622);
				((DesignationContext)_localctx).d = designator();
				_localctx.dRet.addDesignator(((DesignationContext)_localctx).d.dRet);
				}
				}
				setState(627); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==LeftBracket || _la==Dot );
			setState(629);
			match(Assign);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DesignatorContext extends ParserRuleContext {
		public Designator dRet;
		public ExpressionContext exp;
		public Token id;
		public TerminalNode LeftBracket() { return getToken(SimpleLangParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(SimpleLangParser.RightBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Dot() { return getToken(SimpleLangParser.Dot, 0); }
		public TerminalNode Identifier() { return getToken(SimpleLangParser.Identifier, 0); }
		public DesignatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_designator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterDesignator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitDesignator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitDesignator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DesignatorContext designator() throws RecognitionException {
		DesignatorContext _localctx = new DesignatorContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_designator);
		((DesignatorContext)_localctx).dRet =  new Designator(); 
		try {
			setState(639);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftBracket:
				enterOuterAlt(_localctx, 1);
				{
				setState(631);
				match(LeftBracket);
				setState(632);
				((DesignatorContext)_localctx).exp = expression(0);
				_localctx.dRet.setExpr(((DesignatorContext)_localctx).exp.expRet);
				setState(634);
				match(RightBracket);
				}
				break;
			case Dot:
				enterOuterAlt(_localctx, 2);
				{
				setState(636);
				match(Dot);
				setState(637);
				((DesignatorContext)_localctx).id = match(Identifier);
				 _localctx.dRet.setIdentifier(new Identifier((((DesignatorContext)_localctx).id!=null?((DesignatorContext)_localctx).id.getText():null), ((DesignatorContext)_localctx).id.getLine()));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public Statement stRet;
		public CompoundStatementContext c;
		public ExpressionStatementContext e;
		public SelectionStatementContext s;
		public IterationStatementContext i;
		public JumpStatementContext j;
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public SelectionStatementContext selectionStatement() {
			return getRuleContext(SelectionStatementContext.class,0);
		}
		public IterationStatementContext iterationStatement() {
			return getRuleContext(IterationStatementContext.class,0);
		}
		public JumpStatementContext jumpStatement() {
			return getRuleContext(JumpStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_statement);
		try {
			setState(656);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftBrace:
				enterOuterAlt(_localctx, 1);
				{
				setState(641);
				((StatementContext)_localctx).c = compoundStatement();
				((StatementContext)_localctx).stRet =  ((StatementContext)_localctx).c.cstmtRet; _localctx.stRet.setLine(_localctx.start.getLine());
				}
				break;
			case Sizeof:
			case LeftParen:
			case Plus:
			case PlusPlus:
			case Minus:
			case MinusMinus:
			case Star:
			case And:
			case Not:
			case Tilde:
			case Semi:
			case Identifier:
			case IntegerConstant:
			case FloatingConstant:
			case CharacterConstant:
			case StringLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(644);
				((StatementContext)_localctx).e = expressionStatement();
				((StatementContext)_localctx).stRet =  ((StatementContext)_localctx).e.stRet;_localctx.stRet.setLine(_localctx.start.getLine());
				}
				break;
			case If:
				enterOuterAlt(_localctx, 3);
				{
				setState(647);
				((StatementContext)_localctx).s = selectionStatement();
				((StatementContext)_localctx).stRet =  ((StatementContext)_localctx).s.stRet; _localctx.stRet.setLine(_localctx.start.getLine());
				}
				break;
			case Do:
			case For:
			case While:
				enterOuterAlt(_localctx, 4);
				{
				setState(650);
				((StatementContext)_localctx).i = iterationStatement();
				((StatementContext)_localctx).stRet =  ((StatementContext)_localctx).i.stRet; _localctx.stRet.setLine(_localctx.start.getLine());
				}
				break;
			case Break:
			case Continue:
			case Return:
				enterOuterAlt(_localctx, 5);
				{
				setState(653);
				((StatementContext)_localctx).j = jumpStatement();
				((StatementContext)_localctx).stRet =  ((StatementContext)_localctx).j.stRet;      _localctx.stRet.setLine(_localctx.start.getLine());
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CompoundStatementContext extends ParserRuleContext {
		public CompoundStatement cstmtRet;
		public BlockItemContext b;
		public TerminalNode LeftBrace() { return getToken(SimpleLangParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(SimpleLangParser.RightBrace, 0); }
		public List<BlockItemContext> blockItem() {
			return getRuleContexts(BlockItemContext.class);
		}
		public BlockItemContext blockItem(int i) {
			return getRuleContext(BlockItemContext.class,i);
		}
		public CompoundStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterCompoundStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitCompoundStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitCompoundStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompoundStatementContext compoundStatement() throws RecognitionException {
		CompoundStatementContext _localctx = new CompoundStatementContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_compoundStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((CompoundStatementContext)_localctx).cstmtRet =  new CompoundStatement(); _localctx.cstmtRet.setLine(_localctx.start.getLine());
			setState(659);
			match(LeftBrace);
			setState(665);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2679475628015486L) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & 55L) != 0)) {
				{
				{
				setState(660);
				((CompoundStatementContext)_localctx).b = blockItem();
				_localctx.cstmtRet.addBlockItem(((CompoundStatementContext)_localctx).b.blockRet);
				}
				}
				setState(667);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(668);
			match(RightBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockItemContext extends ParserRuleContext {
		public BlockItem blockRet;
		public StatementContext st;
		public DeclarationContext dec;
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public BlockItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterBlockItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitBlockItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitBlockItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockItemContext blockItem() throws RecognitionException {
		BlockItemContext _localctx = new BlockItemContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_blockItem);
		try {
			setState(676);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(670);
				((BlockItemContext)_localctx).st = statement();
				((BlockItemContext)_localctx).blockRet =  new BlockItem(((BlockItemContext)_localctx).st.stRet);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(673);
				((BlockItemContext)_localctx).dec = declaration();
				((BlockItemContext)_localctx).blockRet =  new BlockItem(((BlockItemContext)_localctx).dec.decRet);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionStatementContext extends ParserRuleContext {
		public ExpressionStatement stRet;
		public AllExpressionContext exp;
		public TerminalNode Semi() { return getToken(SimpleLangParser.Semi, 0); }
		public AllExpressionContext allExpression() {
			return getRuleContext(AllExpressionContext.class,0);
		}
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterExpressionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitExpressionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitExpressionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_expressionStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(681);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 247697986031190145L) != 0)) {
				{
				setState(678);
				((ExpressionStatementContext)_localctx).exp = allExpression();
				((ExpressionStatementContext)_localctx).stRet =  new ExpressionStatement(((ExpressionStatementContext)_localctx).exp.expRet);
				}
			}

			setState(683);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SelectionStatementContext extends ParserRuleContext {
		public SelectionStatement stRet;
		public AllExpressionContext exp;
		public StatementContext ifst;
		public StatementContext elsest;
		public TerminalNode If() { return getToken(SimpleLangParser.If, 0); }
		public TerminalNode LeftParen() { return getToken(SimpleLangParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(SimpleLangParser.RightParen, 0); }
		public AllExpressionContext allExpression() {
			return getRuleContext(AllExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode Else() { return getToken(SimpleLangParser.Else, 0); }
		public SelectionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterSelectionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitSelectionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitSelectionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectionStatementContext selectionStatement() throws RecognitionException {
		SelectionStatementContext _localctx = new SelectionStatementContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_selectionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(685);
			match(If);
			setState(686);
			match(LeftParen);
			setState(687);
			((SelectionStatementContext)_localctx).exp = allExpression();
			setState(688);
			match(RightParen);
			setState(689);
			((SelectionStatementContext)_localctx).ifst = statement();
			((SelectionStatementContext)_localctx).stRet =  new SelectionStatement(((SelectionStatementContext)_localctx).exp.expRet, ((SelectionStatementContext)_localctx).ifst.stRet);
			setState(695);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
			case 1:
				{
				setState(691);
				match(Else);
				setState(692);
				((SelectionStatementContext)_localctx).elsest = statement();
				_localctx.stRet.addElse(((SelectionStatementContext)_localctx).elsest.stRet);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IterationStatementContext extends ParserRuleContext {
		public IterationStatement stRet;
		public AllExpressionContext e;
		public StatementContext s;
		public ForConditionContext f;
		public TerminalNode While() { return getToken(SimpleLangParser.While, 0); }
		public TerminalNode LeftParen() { return getToken(SimpleLangParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(SimpleLangParser.RightParen, 0); }
		public AllExpressionContext allExpression() {
			return getRuleContext(AllExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode Do() { return getToken(SimpleLangParser.Do, 0); }
		public TerminalNode Semi() { return getToken(SimpleLangParser.Semi, 0); }
		public TerminalNode For() { return getToken(SimpleLangParser.For, 0); }
		public ForConditionContext forCondition() {
			return getRuleContext(ForConditionContext.class,0);
		}
		public IterationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterationStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterIterationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitIterationStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitIterationStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IterationStatementContext iterationStatement() throws RecognitionException {
		IterationStatementContext _localctx = new IterationStatementContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_iterationStatement);
		try {
			setState(720);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case While:
				enterOuterAlt(_localctx, 1);
				{
				setState(697);
				match(While);
				setState(698);
				match(LeftParen);
				setState(699);
				((IterationStatementContext)_localctx).e = allExpression();
				setState(700);
				match(RightParen);
				setState(701);
				((IterationStatementContext)_localctx).s = statement();
				((IterationStatementContext)_localctx).stRet =  new WhileStatement(((IterationStatementContext)_localctx).e.expRet, ((IterationStatementContext)_localctx).s.stRet);
				}
				break;
			case Do:
				enterOuterAlt(_localctx, 2);
				{
				setState(704);
				match(Do);
				setState(705);
				((IterationStatementContext)_localctx).s = statement();
				setState(706);
				match(While);
				setState(707);
				match(LeftParen);
				setState(708);
				((IterationStatementContext)_localctx).e = allExpression();
				setState(709);
				match(RightParen);
				setState(710);
				match(Semi);
				((IterationStatementContext)_localctx).stRet =  new DoWhileStatement(((IterationStatementContext)_localctx).s.stRet, ((IterationStatementContext)_localctx).e.expRet);
				}
				break;
			case For:
				enterOuterAlt(_localctx, 3);
				{
				setState(713);
				match(For);
				setState(714);
				match(LeftParen);
				setState(715);
				((IterationStatementContext)_localctx).f = forCondition();
				setState(716);
				match(RightParen);
				setState(717);
				((IterationStatementContext)_localctx).s = statement();
				((IterationStatementContext)_localctx).stRet =  new ForStatement(((IterationStatementContext)_localctx).f.forconRet, ((IterationStatementContext)_localctx).s.stRet);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForConditionContext extends ParserRuleContext {
		public ForCondition forconRet;
		public ForDeclarationContext fd;
		public AllExpressionContext e;
		public ForExpressionContext f1;
		public ForExpressionContext f2;
		public List<TerminalNode> Semi() { return getTokens(SimpleLangParser.Semi); }
		public TerminalNode Semi(int i) {
			return getToken(SimpleLangParser.Semi, i);
		}
		public ForDeclarationContext forDeclaration() {
			return getRuleContext(ForDeclarationContext.class,0);
		}
		public List<ForExpressionContext> forExpression() {
			return getRuleContexts(ForExpressionContext.class);
		}
		public ForExpressionContext forExpression(int i) {
			return getRuleContext(ForExpressionContext.class,i);
		}
		public AllExpressionContext allExpression() {
			return getRuleContext(AllExpressionContext.class,0);
		}
		public ForConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterForCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitForCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitForCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForConditionContext forCondition() throws RecognitionException {
		ForConditionContext _localctx = new ForConditionContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_forCondition);
		((ForConditionContext)_localctx).forconRet =  new ForCondition();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(730);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				{
				setState(722);
				((ForConditionContext)_localctx).fd = forDeclaration();
				_localctx.forconRet.setDeclaration(((ForConditionContext)_localctx).fd.forRet);
				}
				break;
			case 2:
				{
				setState(728);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 247697986031190145L) != 0)) {
					{
					setState(725);
					((ForConditionContext)_localctx).e = allExpression();
					_localctx.forconRet.setExpr(((ForConditionContext)_localctx).e.expRet);
					}
				}

				}
				break;
			}
			setState(732);
			match(Semi);
			setState(736);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 247697986031190145L) != 0)) {
				{
				setState(733);
				((ForConditionContext)_localctx).f1 = forExpression();
				_localctx.forconRet.setConditions(((ForConditionContext)_localctx).f1.list);
				}
			}

			setState(738);
			match(Semi);
			setState(742);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 247697986031190145L) != 0)) {
				{
				setState(739);
				((ForConditionContext)_localctx).f2 = forExpression();
				_localctx.forconRet.setSteps(((ForConditionContext)_localctx).f2.list);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForDeclarationContext extends ParserRuleContext {
		public Declaration forRet;
		public DeclarationSpecifiersContext d;
		public InitDeclaratorListContext i;
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
		}
		public InitDeclaratorListContext initDeclaratorList() {
			return getRuleContext(InitDeclaratorListContext.class,0);
		}
		public ForDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterForDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitForDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitForDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForDeclarationContext forDeclaration() throws RecognitionException {
		ForDeclarationContext _localctx = new ForDeclarationContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_forDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(744);
			((ForDeclarationContext)_localctx).d = declarationSpecifiers();
			((ForDeclarationContext)_localctx).forRet =  new Declaration(((ForDeclarationContext)_localctx).d.list);
			setState(749);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & 35184372154369L) != 0)) {
				{
				setState(746);
				((ForDeclarationContext)_localctx).i = initDeclaratorList();
				_localctx.forRet.addInitDeclarators(((ForDeclarationContext)_localctx).i.list);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForExpressionContext extends ParserRuleContext {
		public List<Expr> list;
		public ExpressionContext e;
		public ExpressionContext e2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SimpleLangParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SimpleLangParser.Comma, i);
		}
		public ForExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterForExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitForExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitForExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForExpressionContext forExpression() throws RecognitionException {
		ForExpressionContext _localctx = new ForExpressionContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_forExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((ForExpressionContext)_localctx).list =  new ArrayList<>();
			setState(752);
			((ForExpressionContext)_localctx).e = expression(0);
			_localctx.list.add(((ForExpressionContext)_localctx).e.expRet);
			setState(760);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(754);
				match(Comma);
				setState(755);
				((ForExpressionContext)_localctx).e2 = expression(0);
				_localctx.list.add(((ForExpressionContext)_localctx).e2.expRet);
				}
				}
				setState(762);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JumpStatementContext extends ParserRuleContext {
		public JumpStatement stRet;
		public ExpressionContext e;
		public TerminalNode Semi() { return getToken(SimpleLangParser.Semi, 0); }
		public TerminalNode Continue() { return getToken(SimpleLangParser.Continue, 0); }
		public TerminalNode Break() { return getToken(SimpleLangParser.Break, 0); }
		public TerminalNode Return() { return getToken(SimpleLangParser.Return, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public JumpStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jumpStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterJumpStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitJumpStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitJumpStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JumpStatementContext jumpStatement() throws RecognitionException {
		JumpStatementContext _localctx = new JumpStatementContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_jumpStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(774);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Continue:
				{
				setState(763);
				match(Continue);
				((JumpStatementContext)_localctx).stRet =  new ContinueStatement();
				}
				break;
			case Break:
				{
				setState(765);
				match(Break);
				((JumpStatementContext)_localctx).stRet =  new BreakStatement();
				}
				break;
			case Return:
				{
				setState(767);
				match(Return);
				((JumpStatementContext)_localctx).stRet =  new ReturnStatement();
				setState(772);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 247697986031190145L) != 0)) {
					{
					setState(769);
					((JumpStatementContext)_localctx).e = expression(0);
					((ReturnStatement)_localctx.stRet).setExpr(((JumpStatementContext)_localctx).e.expRet);
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(776);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstantContext extends ParserRuleContext {
		public ConstantExpr cret;
		public Token i;
		public Token f;
		public Token c;
		public TerminalNode IntegerConstant() { return getToken(SimpleLangParser.IntegerConstant, 0); }
		public TerminalNode FloatingConstant() { return getToken(SimpleLangParser.FloatingConstant, 0); }
		public TerminalNode CharacterConstant() { return getToken(SimpleLangParser.CharacterConstant, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_constant);
		try {
			setState(784);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IntegerConstant:
				enterOuterAlt(_localctx, 1);
				{
				setState(778);
				((ConstantContext)_localctx).i = match(IntegerConstant);
				 ((ConstantContext)_localctx).cret =  new IntVal((((ConstantContext)_localctx).i!=null?((ConstantContext)_localctx).i.getText():null)); 
				}
				break;
			case FloatingConstant:
				enterOuterAlt(_localctx, 2);
				{
				setState(780);
				((ConstantContext)_localctx).f = match(FloatingConstant);
				 ((ConstantContext)_localctx).cret =  new FloatVal((((ConstantContext)_localctx).f!=null?((ConstantContext)_localctx).f.getText():null)); 
				}
				break;
			case CharacterConstant:
				enterOuterAlt(_localctx, 3);
				{
				setState(782);
				((ConstantContext)_localctx).c = match(CharacterConstant);
				 ((ConstantContext)_localctx).cret =  new CharVal((((ConstantContext)_localctx).c!=null?((ConstantContext)_localctx).c.getText():null)); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 19:
			return directDeclarator_sempred((DirectDeclaratorContext)_localctx, predIndex);
		case 26:
			return directAbstractDeclarator_sempred((DirectAbstractDeclaratorContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 12);
		case 1:
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 10);
		case 3:
			return precpred(_ctx, 9);
		case 4:
			return precpred(_ctx, 8);
		case 5:
			return precpred(_ctx, 7);
		case 6:
			return precpred(_ctx, 6);
		case 7:
			return precpred(_ctx, 5);
		case 8:
			return precpred(_ctx, 4);
		case 9:
			return precpred(_ctx, 3);
		case 10:
			return precpred(_ctx, 2);
		case 11:
			return precpred(_ctx, 1);
		case 12:
			return precpred(_ctx, 18);
		case 13:
			return precpred(_ctx, 17);
		case 14:
			return precpred(_ctx, 16);
		case 15:
			return precpred(_ctx, 15);
		}
		return true;
	}
	private boolean directDeclarator_sempred(DirectDeclaratorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 16:
			return precpred(_ctx, 2);
		case 17:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean directAbstractDeclarator_sempred(DirectAbstractDeclaratorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 18:
			return precpred(_ctx, 2);
		case 19:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001O\u0313\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0003\u0000Z\b\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0004\u0001b\b\u0001\u000b\u0001"+
		"\f\u0001c\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002n\b\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003s\b\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0004\u0004"+
		"|\b\u0004\u000b\u0004\f\u0004}\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0004\u0005\u0086\b\u0005\u000b\u0005\f"+
		"\u0005\u0087\u0001\u0005\u0001\u0005\u0003\u0005\u008c\b\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0004\u0006\u0097\b\u0006\u000b\u0006\f\u0006"+
		"\u0098\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0003\u0006\u00a7\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u00af\b\u0006\n\u0006\f\u0006"+
		"\u00b2\t\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0004\u0006\u00bc\b\u0006\u000b\u0006"+
		"\f\u0006\u00bd\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0003\u0006\u00cc\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u00db\b\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0003\u0006\u00e4\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006\u012d\b\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0005\u0006\u0137\b\u0006\n\u0006\f\u0006\u013a\t\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005"+
		"\u0007\u0143\b\u0007\n\u0007\f\u0007\u0146\t\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0003\b\u0154\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u0161\b\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0004\f\u016f\b\f\u000b\f\f\f\u0170\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u017a\b\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0005\u000e\u0183\b\u000e\n\u000e\f\u000e\u0186\t\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u018e"+
		"\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u01a6"+
		"\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003"+
		"\u0011\u01ad\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u01b2"+
		"\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u01b8"+
		"\b\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003"+
		"\u0013\u01c5\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003"+
		"\u0013\u01cb\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0003\u0013\u01d8\b\u0013\u0003\u0013\u01da\b\u0013\u0001\u0013"+
		"\u0005\u0013\u01dd\b\u0013\n\u0013\f\u0013\u01e0\t\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0005\u0014\u01e5\b\u0014\n\u0014\f\u0014\u01e8\t\u0014"+
		"\u0001\u0014\u0004\u0014\u01eb\b\u0014\u000b\u0014\f\u0014\u01ec\u0001"+
		"\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u01f8\b\u0015\n\u0015\f\u0015"+
		"\u01fb\t\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u0205\b\u0016\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0005\u0017"+
		"\u020d\b\u0017\n\u0017\f\u0017\u0210\t\u0017\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u0218\b\u0018\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0003"+
		"\u0019\u0220\b\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u0225"+
		"\b\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u022a\b\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0003\u001a\u0233\b\u001a\u0001\u001a\u0003\u001a\u0236\b"+
		"\u001a\u0001\u001a\u0003\u001a\u0239\b\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0003\u001a\u023f\b\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u0247\b\u001a\u0001"+
		"\u001a\u0001\u001a\u0005\u001a\u024b\b\u001a\n\u001a\f\u001a\u024e\t\u001a"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0003\u001b\u0257\b\u001b\u0001\u001b\u0001\u001b\u0003\u001b"+
		"\u025b\b\u001b\u0001\u001c\u0003\u001c\u025e\b\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u0264\b\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0005\u001c\u0269\b\u001c\n\u001c\f\u001c\u026c\t\u001c"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0004\u001d\u0272\b\u001d"+
		"\u000b\u001d\f\u001d\u0273\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0003\u001e\u0280\b\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0003\u001f"+
		"\u0291\b\u001f\u0001 \u0001 \u0001 \u0001 \u0001 \u0005 \u0298\b \n \f"+
		" \u029b\t \u0001 \u0001 \u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0003"+
		"!\u02a5\b!\u0001\"\u0001\"\u0001\"\u0003\"\u02aa\b\"\u0001\"\u0001\"\u0001"+
		"#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0003"+
		"#\u02b8\b#\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0003$\u02d1\b$\u0001%\u0001%\u0001%\u0001"+
		"%\u0001%\u0001%\u0003%\u02d9\b%\u0003%\u02db\b%\u0001%\u0001%\u0001%\u0001"+
		"%\u0003%\u02e1\b%\u0001%\u0001%\u0001%\u0001%\u0003%\u02e7\b%\u0001&\u0001"+
		"&\u0001&\u0001&\u0001&\u0003&\u02ee\b&\u0001\'\u0001\'\u0001\'\u0001\'"+
		"\u0001\'\u0001\'\u0001\'\u0005\'\u02f7\b\'\n\'\f\'\u02fa\t\'\u0001(\u0001"+
		"(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0003(\u0305\b(\u0003"+
		"(\u0307\b(\u0001(\u0001(\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0003"+
		")\u0311\b)\u0001)\u0000\u0003\f&4*\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDF"+
		"HJLNPR\u0000\u0007\u0003\u0000\u0010\u0010$$&&\u0001\u0000\')\u0002\u0000"+
		"##%%\u0001\u0000!\"\u0001\u0000\u001d \u0001\u0000@A\u0001\u00005?\u035e"+
		"\u0000T\u0001\u0000\u0000\u0000\u0002]\u0001\u0000\u0000\u0000\u0004m"+
		"\u0001\u0000\u0000\u0000\u0006o\u0001\u0000\u0000\u0000\bw\u0001\u0000"+
		"\u0000\u0000\n\u008b\u0001\u0000\u0000\u0000\f\u00e3\u0001\u0000\u0000"+
		"\u0000\u000e\u013b\u0001\u0000\u0000\u0000\u0010\u0153\u0001\u0000\u0000"+
		"\u0000\u0012\u0160\u0001\u0000\u0000\u0000\u0014\u0162\u0001\u0000\u0000"+
		"\u0000\u0016\u0165\u0001\u0000\u0000\u0000\u0018\u016a\u0001\u0000\u0000"+
		"\u0000\u001a\u0179\u0001\u0000\u0000\u0000\u001c\u017b\u0001\u0000\u0000"+
		"\u0000\u001e\u0187\u0001\u0000\u0000\u0000 \u01a5\u0001\u0000\u0000\u0000"+
		"\"\u01ac\u0001\u0000\u0000\u0000$\u01b3\u0001\u0000\u0000\u0000&\u01c4"+
		"\u0001\u0000\u0000\u0000(\u01e1\u0001\u0000\u0000\u0000*\u01f0\u0001\u0000"+
		"\u0000\u0000,\u01fc\u0001\u0000\u0000\u0000.\u0206\u0001\u0000\u0000\u0000"+
		"0\u0211\u0001\u0000\u0000\u00002\u0224\u0001\u0000\u0000\u00004\u0238"+
		"\u0001\u0000\u0000\u00006\u025a\u0001\u0000\u0000\u00008\u025d\u0001\u0000"+
		"\u0000\u0000:\u026d\u0001\u0000\u0000\u0000<\u027f\u0001\u0000\u0000\u0000"+
		">\u0290\u0001\u0000\u0000\u0000@\u0292\u0001\u0000\u0000\u0000B\u02a4"+
		"\u0001\u0000\u0000\u0000D\u02a9\u0001\u0000\u0000\u0000F\u02ad\u0001\u0000"+
		"\u0000\u0000H\u02d0\u0001\u0000\u0000\u0000J\u02da\u0001\u0000\u0000\u0000"+
		"L\u02e8\u0001\u0000\u0000\u0000N\u02ef\u0001\u0000\u0000\u0000P\u0306"+
		"\u0001\u0000\u0000\u0000R\u0310\u0001\u0000\u0000\u0000TU\u0006\u0000"+
		"\uffff\uffff\u0000UY\u0006\u0000\uffff\uffff\u0000VW\u0003\u0002\u0001"+
		"\u0000WX\u0006\u0000\uffff\uffff\u0000XZ\u0001\u0000\u0000\u0000YV\u0001"+
		"\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000"+
		"[\\\u0005\u0000\u0000\u0001\\\u0001\u0001\u0000\u0000\u0000]a\u0006\u0001"+
		"\uffff\uffff\u0000^_\u0003\u0004\u0002\u0000_`\u0006\u0001\uffff\uffff"+
		"\u0000`b\u0001\u0000\u0000\u0000a^\u0001\u0000\u0000\u0000bc\u0001\u0000"+
		"\u0000\u0000ca\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000d\u0003"+
		"\u0001\u0000\u0000\u0000ef\u0003\u0006\u0003\u0000fg\u0006\u0002\uffff"+
		"\uffff\u0000gn\u0001\u0000\u0000\u0000hi\u0003\u0016\u000b\u0000ij\u0006"+
		"\u0002\uffff\uffff\u0000jn\u0001\u0000\u0000\u0000kl\u00053\u0000\u0000"+
		"ln\u0006\u0002\uffff\uffff\u0000me\u0001\u0000\u0000\u0000mh\u0001\u0000"+
		"\u0000\u0000mk\u0001\u0000\u0000\u0000n\u0005\u0001\u0000\u0000\u0000"+
		"op\u0003\u0018\f\u0000pr\u0003$\u0012\u0000qs\u0003\b\u0004\u0000rq\u0001"+
		"\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000"+
		"tu\u0003@ \u0000uv\u0006\u0003\uffff\uffff\u0000v\u0007\u0001\u0000\u0000"+
		"\u0000w{\u0006\u0004\uffff\uffff\u0000xy\u0003\u0016\u000b\u0000yz\u0006"+
		"\u0004\uffff\uffff\u0000z|\u0001\u0000\u0000\u0000{x\u0001\u0000\u0000"+
		"\u0000|}\u0001\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000}~\u0001\u0000"+
		"\u0000\u0000~\t\u0001\u0000\u0000\u0000\u007f\u0080\u0003\f\u0006\u0000"+
		"\u0080\u0081\u0006\u0005\uffff\uffff\u0000\u0081\u008c\u0001\u0000\u0000"+
		"\u0000\u0082\u0085\u0003\f\u0006\u0000\u0083\u0084\u00054\u0000\u0000"+
		"\u0084\u0086\u0003\f\u0006\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0086"+
		"\u0087\u0001\u0000\u0000\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0087"+
		"\u0088\u0001\u0000\u0000\u0000\u0088\u0089\u0001\u0000\u0000\u0000\u0089"+
		"\u008a\u0006\u0005\uffff\uffff\u0000\u008a\u008c\u0001\u0000\u0000\u0000"+
		"\u008b\u007f\u0001\u0000\u0000\u0000\u008b\u0082\u0001\u0000\u0000\u0000"+
		"\u008c\u000b\u0001\u0000\u0000\u0000\u008d\u008e\u0006\u0006\uffff\uffff"+
		"\u0000\u008e\u008f\u0005D\u0000\u0000\u008f\u00e4\u0006\u0006\uffff\uffff"+
		"\u0000\u0090\u0091\u0003R)\u0000\u0091\u0092\u0006\u0006\uffff\uffff\u0000"+
		"\u0092\u00e4\u0001\u0000\u0000\u0000\u0093\u0096\u0006\u0006\uffff\uffff"+
		"\u0000\u0094\u0095\u0005I\u0000\u0000\u0095\u0097\u0006\u0006\uffff\uffff"+
		"\u0000\u0096\u0094\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000"+
		"\u0000\u0098\u0096\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000"+
		"\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a\u00e4\u0006\u0006\uffff"+
		"\uffff\u0000\u009b\u009c\u0005\u0017\u0000\u0000\u009c\u009d\u0003\f\u0006"+
		"\u0000\u009d\u009e\u0005\u0018\u0000\u0000\u009e\u009f\u0006\u0006\uffff"+
		"\uffff\u0000\u009f\u00e4\u0001\u0000\u0000\u0000\u00a0\u00a1\u0005\u0017"+
		"\u0000\u0000\u00a1\u00a2\u00030\u0018\u0000\u00a2\u00a3\u0005\u0018\u0000"+
		"\u0000\u00a3\u00a4\u0005\u001b\u0000\u0000\u00a4\u00a6\u00038\u001c\u0000"+
		"\u00a5\u00a7\u00054\u0000\u0000\u00a6\u00a5\u0001\u0000\u0000\u0000\u00a6"+
		"\u00a7\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8"+
		"\u00a9\u0005\u001c\u0000\u0000\u00a9\u00aa\u0006\u0006\uffff\uffff\u0000"+
		"\u00aa\u00e4\u0001\u0000\u0000\u0000\u00ab\u00b0\u0006\u0006\uffff\uffff"+
		"\u0000\u00ac\u00ad\u0007\u0000\u0000\u0000\u00ad\u00af\u0006\u0006\uffff"+
		"\uffff\u0000\u00ae\u00ac\u0001\u0000\u0000\u0000\u00af\u00b2\u0001\u0000"+
		"\u0000\u0000\u00b0\u00ae\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000"+
		"\u0000\u0000\u00b1\u00da\u0001\u0000\u0000\u0000\u00b2\u00b0\u0001\u0000"+
		"\u0000\u0000\u00b3\u00b4\u0005D\u0000\u0000\u00b4\u00db\u0006\u0006\uffff"+
		"\uffff\u0000\u00b5\u00b6\u0003R)\u0000\u00b6\u00b7\u0006\u0006\uffff\uffff"+
		"\u0000\u00b7\u00db\u0001\u0000\u0000\u0000\u00b8\u00bb\u0006\u0006\uffff"+
		"\uffff\u0000\u00b9\u00ba\u0005I\u0000\u0000\u00ba\u00bc\u0006\u0006\uffff"+
		"\uffff\u0000\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bc\u00bd\u0001\u0000"+
		"\u0000\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000\u00bd\u00be\u0001\u0000"+
		"\u0000\u0000\u00be\u00bf\u0001\u0000\u0000\u0000\u00bf\u00db\u0006\u0006"+
		"\uffff\uffff\u0000\u00c0\u00c1\u0005\u0017\u0000\u0000\u00c1\u00c2\u0003"+
		"\f\u0006\u0000\u00c2\u00c3\u0005\u0018\u0000\u0000\u00c3\u00c4\u0006\u0006"+
		"\uffff\uffff\u0000\u00c4\u00db\u0001\u0000\u0000\u0000\u00c5\u00c6\u0005"+
		"\u0017\u0000\u0000\u00c6\u00c7\u00030\u0018\u0000\u00c7\u00c8\u0005\u0018"+
		"\u0000\u0000\u00c8\u00c9\u0005\u001b\u0000\u0000\u00c9\u00cb\u00038\u001c"+
		"\u0000\u00ca\u00cc\u00054\u0000\u0000\u00cb\u00ca\u0001\u0000\u0000\u0000"+
		"\u00cb\u00cc\u0001\u0000\u0000\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000"+
		"\u00cd\u00ce\u0005\u001c\u0000\u0000\u00ce\u00cf\u0006\u0006\uffff\uffff"+
		"\u0000\u00cf\u00db\u0001\u0000\u0000\u0000\u00d0\u00d1\u0003\u0010\b\u0000"+
		"\u00d1\u00d2\u0003\u0012\t\u0000\u00d2\u00d3\u0006\u0006\uffff\uffff\u0000"+
		"\u00d3\u00db\u0001\u0000\u0000\u0000\u00d4\u00d5\u0005\u0010\u0000\u0000"+
		"\u00d5\u00d6\u0005\u0017\u0000\u0000\u00d6\u00d7\u00030\u0018\u0000\u00d7"+
		"\u00d8\u0005\u0018\u0000\u0000\u00d8\u00d9\u0006\u0006\uffff\uffff\u0000"+
		"\u00d9\u00db\u0001\u0000\u0000\u0000\u00da\u00b3\u0001\u0000\u0000\u0000"+
		"\u00da\u00b5\u0001\u0000\u0000\u0000\u00da\u00b8\u0001\u0000\u0000\u0000"+
		"\u00da\u00c0\u0001\u0000\u0000\u0000\u00da\u00c5\u0001\u0000\u0000\u0000"+
		"\u00da\u00d0\u0001\u0000\u0000\u0000\u00da\u00d4\u0001\u0000\u0000\u0000"+
		"\u00db\u00dc\u0001\u0000\u0000\u0000\u00dc\u00e4\u0006\u0006\uffff\uffff"+
		"\u0000\u00dd\u00de\u0005\u0017\u0000\u0000\u00de\u00df\u00030\u0018\u0000"+
		"\u00df\u00e0\u0005\u0018\u0000\u0000\u00e0\u00e1\u0003\u0012\t\u0000\u00e1"+
		"\u00e2\u0006\u0006\uffff\uffff\u0000\u00e2\u00e4\u0001\u0000\u0000\u0000"+
		"\u00e3\u008d\u0001\u0000\u0000\u0000\u00e3\u0090\u0001\u0000\u0000\u0000"+
		"\u00e3\u0093\u0001\u0000\u0000\u0000\u00e3\u009b\u0001\u0000\u0000\u0000"+
		"\u00e3\u00a0\u0001\u0000\u0000\u0000\u00e3\u00ab\u0001\u0000\u0000\u0000"+
		"\u00e3\u00dd\u0001\u0000\u0000\u0000\u00e4\u0138\u0001\u0000\u0000\u0000"+
		"\u00e5\u00e6\n\f\u0000\u0000\u00e6\u00e7\u0007\u0001\u0000\u0000\u00e7"+
		"\u00e8\u0003\f\u0006\r\u00e8\u00e9\u0006\u0006\uffff\uffff\u0000\u00e9"+
		"\u0137\u0001\u0000\u0000\u0000\u00ea\u00eb\n\u000b\u0000\u0000\u00eb\u00ec"+
		"\u0007\u0002\u0000\u0000\u00ec\u00ed\u0003\f\u0006\f\u00ed\u00ee\u0006"+
		"\u0006\uffff\uffff\u0000\u00ee\u0137\u0001\u0000\u0000\u0000\u00ef\u00f0"+
		"\n\n\u0000\u0000\u00f0\u00f1\u0007\u0003\u0000\u0000\u00f1\u00f2\u0003"+
		"\f\u0006\u000b\u00f2\u00f3\u0006\u0006\uffff\uffff\u0000\u00f3\u0137\u0001"+
		"\u0000\u0000\u0000\u00f4\u00f5\n\t\u0000\u0000\u00f5\u00f6\u0007\u0004"+
		"\u0000\u0000\u00f6\u00f7\u0003\f\u0006\n\u00f7\u00f8\u0006\u0006\uffff"+
		"\uffff\u0000\u00f8\u0137\u0001\u0000\u0000\u0000\u00f9\u00fa\n\b\u0000"+
		"\u0000\u00fa\u00fb\u0007\u0005\u0000\u0000\u00fb\u00fc\u0003\f\u0006\t"+
		"\u00fc\u00fd\u0006\u0006\uffff\uffff\u0000\u00fd\u0137\u0001\u0000\u0000"+
		"\u0000\u00fe\u00ff\n\u0007\u0000\u0000\u00ff\u0100\u0005*\u0000\u0000"+
		"\u0100\u0101\u0003\f\u0006\b\u0101\u0102\u0006\u0006\uffff\uffff\u0000"+
		"\u0102\u0137\u0001\u0000\u0000\u0000\u0103\u0104\n\u0006\u0000\u0000\u0104"+
		"\u0105\u0005.\u0000\u0000\u0105\u0106\u0003\f\u0006\u0007\u0106\u0107"+
		"\u0006\u0006\uffff\uffff\u0000\u0107\u0137\u0001\u0000\u0000\u0000\u0108"+
		"\u0109\n\u0005\u0000\u0000\u0109\u010a\u0005+\u0000\u0000\u010a\u010b"+
		"\u0003\f\u0006\u0006\u010b\u010c\u0006\u0006\uffff\uffff\u0000\u010c\u0137"+
		"\u0001\u0000\u0000\u0000\u010d\u010e\n\u0004\u0000\u0000\u010e\u010f\u0005"+
		",\u0000\u0000\u010f\u0110\u0003\f\u0006\u0005\u0110\u0111\u0006\u0006"+
		"\uffff\uffff\u0000\u0111\u0137\u0001\u0000\u0000\u0000\u0112\u0113\n\u0003"+
		"\u0000\u0000\u0113\u0114\u0005-\u0000\u0000\u0114\u0115\u0003\f\u0006"+
		"\u0004\u0115\u0116\u0006\u0006\uffff\uffff\u0000\u0116\u0137\u0001\u0000"+
		"\u0000\u0000\u0117\u0118\n\u0002\u0000\u0000\u0118\u0119\u00051\u0000"+
		"\u0000\u0119\u011a\u0003\f\u0006\u0000\u011a\u011b\u00052\u0000\u0000"+
		"\u011b\u011c\u0003\f\u0006\u0003\u011c\u011d\u0006\u0006\uffff\uffff\u0000"+
		"\u011d\u0137\u0001\u0000\u0000\u0000\u011e\u011f\n\u0001\u0000\u0000\u011f"+
		"\u0120\u0003\u0014\n\u0000\u0120\u0121\u0003\f\u0006\u0002\u0121\u0122"+
		"\u0006\u0006\uffff\uffff\u0000\u0122\u0137\u0001\u0000\u0000\u0000\u0123"+
		"\u0124\n\u0012\u0000\u0000\u0124\u0125\u0005\u0019\u0000\u0000\u0125\u0126"+
		"\u0003\f\u0006\u0000\u0126\u0127\u0005\u001a\u0000\u0000\u0127\u0128\u0006"+
		"\u0006\uffff\uffff\u0000\u0128\u0137\u0001\u0000\u0000\u0000\u0129\u012a"+
		"\n\u0011\u0000\u0000\u012a\u012c\u0005\u0017\u0000\u0000\u012b\u012d\u0003"+
		"\u000e\u0007\u0000\u012c\u012b\u0001\u0000\u0000\u0000\u012c\u012d\u0001"+
		"\u0000\u0000\u0000\u012d\u012e\u0001\u0000\u0000\u0000\u012e\u012f\u0005"+
		"\u0018\u0000\u0000\u012f\u0137\u0006\u0006\uffff\uffff\u0000\u0130\u0131"+
		"\n\u0010\u0000\u0000\u0131\u0132\u0005$\u0000\u0000\u0132\u0137\u0006"+
		"\u0006\uffff\uffff\u0000\u0133\u0134\n\u000f\u0000\u0000\u0134\u0135\u0005"+
		"&\u0000\u0000\u0135\u0137\u0006\u0006\uffff\uffff\u0000\u0136\u00e5\u0001"+
		"\u0000\u0000\u0000\u0136\u00ea\u0001\u0000\u0000\u0000\u0136\u00ef\u0001"+
		"\u0000\u0000\u0000\u0136\u00f4\u0001\u0000\u0000\u0000\u0136\u00f9\u0001"+
		"\u0000\u0000\u0000\u0136\u00fe\u0001\u0000\u0000\u0000\u0136\u0103\u0001"+
		"\u0000\u0000\u0000\u0136\u0108\u0001\u0000\u0000\u0000\u0136\u010d\u0001"+
		"\u0000\u0000\u0000\u0136\u0112\u0001\u0000\u0000\u0000\u0136\u0117\u0001"+
		"\u0000\u0000\u0000\u0136\u011e\u0001\u0000\u0000\u0000\u0136\u0123\u0001"+
		"\u0000\u0000\u0000\u0136\u0129\u0001\u0000\u0000\u0000\u0136\u0130\u0001"+
		"\u0000\u0000\u0000\u0136\u0133\u0001\u0000\u0000\u0000\u0137\u013a\u0001"+
		"\u0000\u0000\u0000\u0138\u0136\u0001\u0000\u0000\u0000\u0138\u0139\u0001"+
		"\u0000\u0000\u0000\u0139\r\u0001\u0000\u0000\u0000\u013a\u0138\u0001\u0000"+
		"\u0000\u0000\u013b\u013c\u0006\u0007\uffff\uffff\u0000\u013c\u013d\u0003"+
		"\f\u0006\u0000\u013d\u0144\u0006\u0007\uffff\uffff\u0000\u013e\u013f\u0005"+
		"4\u0000\u0000\u013f\u0140\u0003\f\u0006\u0000\u0140\u0141\u0006\u0007"+
		"\uffff\uffff\u0000\u0141\u0143\u0001\u0000\u0000\u0000\u0142\u013e\u0001"+
		"\u0000\u0000\u0000\u0143\u0146\u0001\u0000\u0000\u0000\u0144\u0142\u0001"+
		"\u0000\u0000\u0000\u0144\u0145\u0001\u0000\u0000\u0000\u0145\u000f\u0001"+
		"\u0000\u0000\u0000\u0146\u0144\u0001\u0000\u0000\u0000\u0147\u0148\u0005"+
		"*\u0000\u0000\u0148\u0154\u0006\b\uffff\uffff\u0000\u0149\u014a\u0005"+
		"\'\u0000\u0000\u014a\u0154\u0006\b\uffff\uffff\u0000\u014b\u014c\u0005"+
		"#\u0000\u0000\u014c\u0154\u0006\b\uffff\uffff\u0000\u014d\u014e\u0005"+
		"%\u0000\u0000\u014e\u0154\u0006\b\uffff\uffff\u0000\u014f\u0150\u0005"+
		"0\u0000\u0000\u0150\u0154\u0006\b\uffff\uffff\u0000\u0151\u0152\u0005"+
		"/\u0000\u0000\u0152\u0154\u0006\b\uffff\uffff\u0000\u0153\u0147\u0001"+
		"\u0000\u0000\u0000\u0153\u0149\u0001\u0000\u0000\u0000\u0153\u014b\u0001"+
		"\u0000\u0000\u0000\u0153\u014d\u0001\u0000\u0000\u0000\u0153\u014f\u0001"+
		"\u0000\u0000\u0000\u0153\u0151\u0001\u0000\u0000\u0000\u0154\u0011\u0001"+
		"\u0000\u0000\u0000\u0155\u0156\u0005\u0017\u0000\u0000\u0156\u0157\u0003"+
		"0\u0018\u0000\u0157\u0158\u0005\u0018\u0000\u0000\u0158\u0159\u0003\u0012"+
		"\t\u0000\u0159\u015a\u0006\t\uffff\uffff\u0000\u015a\u0161\u0001\u0000"+
		"\u0000\u0000\u015b\u015c\u0003\f\u0006\u0000\u015c\u015d\u0006\t\uffff"+
		"\uffff\u0000\u015d\u0161\u0001\u0000\u0000\u0000\u015e\u015f\u0005G\u0000"+
		"\u0000\u015f\u0161\u0006\t\uffff\uffff\u0000\u0160\u0155\u0001\u0000\u0000"+
		"\u0000\u0160\u015b\u0001\u0000\u0000\u0000\u0160\u015e\u0001\u0000\u0000"+
		"\u0000\u0161\u0013\u0001\u0000\u0000\u0000\u0162\u0163\u0007\u0006\u0000"+
		"\u0000\u0163\u0164\u0006\n\uffff\uffff\u0000\u0164\u0015\u0001\u0000\u0000"+
		"\u0000\u0165\u0166\u0003\u0018\f\u0000\u0166\u0167\u0003\u001c\u000e\u0000"+
		"\u0167\u0168\u00053\u0000\u0000\u0168\u0169\u0006\u000b\uffff\uffff\u0000"+
		"\u0169\u0017\u0001\u0000\u0000\u0000\u016a\u016e\u0006\f\uffff\uffff\u0000"+
		"\u016b\u016c\u0003\u001a\r\u0000\u016c\u016d\u0006\f\uffff\uffff\u0000"+
		"\u016d\u016f\u0001\u0000\u0000\u0000\u016e\u016b\u0001\u0000\u0000\u0000"+
		"\u016f\u0170\u0001\u0000\u0000\u0000\u0170\u016e\u0001\u0000\u0000\u0000"+
		"\u0170\u0171\u0001\u0000\u0000\u0000\u0171\u0019\u0001\u0000\u0000\u0000"+
		"\u0172\u0173\u0005\u0012\u0000\u0000\u0173\u017a\u0006\r\uffff\uffff\u0000"+
		"\u0174\u0175\u0003 \u0010\u0000\u0175\u0176\u0006\r\uffff\uffff\u0000"+
		"\u0176\u017a\u0001\u0000\u0000\u0000\u0177\u0178\u0005\u0003\u0000\u0000"+
		"\u0178\u017a\u0006\r\uffff\uffff\u0000\u0179\u0172\u0001\u0000\u0000\u0000"+
		"\u0179\u0174\u0001\u0000\u0000\u0000\u0179\u0177\u0001\u0000\u0000\u0000"+
		"\u017a\u001b\u0001\u0000\u0000\u0000\u017b\u017c\u0006\u000e\uffff\uffff"+
		"\u0000\u017c\u017d\u0003\u001e\u000f\u0000\u017d\u0184\u0006\u000e\uffff"+
		"\uffff\u0000\u017e\u017f\u00054\u0000\u0000\u017f\u0180\u0003\u001e\u000f"+
		"\u0000\u0180\u0181\u0006\u000e\uffff\uffff\u0000\u0181\u0183\u0001\u0000"+
		"\u0000\u0000\u0182\u017e\u0001\u0000\u0000\u0000\u0183\u0186\u0001\u0000"+
		"\u0000\u0000\u0184\u0182\u0001\u0000\u0000\u0000\u0184\u0185\u0001\u0000"+
		"\u0000\u0000\u0185\u001d\u0001\u0000\u0000\u0000\u0186\u0184\u0001\u0000"+
		"\u0000\u0000\u0187\u0188\u0003$\u0012\u0000\u0188\u018d\u0006\u000f\uffff"+
		"\uffff\u0000\u0189\u018a\u00055\u0000\u0000\u018a\u018b\u00036\u001b\u0000"+
		"\u018b\u018c\u0006\u000f\uffff\uffff\u0000\u018c\u018e\u0001\u0000\u0000"+
		"\u0000\u018d\u0189\u0001\u0000\u0000\u0000\u018d\u018e\u0001\u0000\u0000"+
		"\u0000\u018e\u001f\u0001\u0000\u0000\u0000\u018f\u0190\u0005\u0014\u0000"+
		"\u0000\u0190\u01a6\u0006\u0010\uffff\uffff\u0000\u0191\u0192\u0005\u0002"+
		"\u0000\u0000\u0192\u01a6\u0006\u0010\uffff\uffff\u0000\u0193\u0194\u0005"+
		"\u000e\u0000\u0000\u0194\u01a6\u0006\u0010\uffff\uffff\u0000\u0195\u0196"+
		"\u0005\u000b\u0000\u0000\u0196\u01a6\u0006\u0010\uffff\uffff\u0000\u0197"+
		"\u0198\u0005\f\u0000\u0000\u0198\u01a6\u0006\u0010\uffff\uffff\u0000\u0199"+
		"\u019a\u0005\b\u0000\u0000\u019a\u01a6\u0006\u0010\uffff\uffff\u0000\u019b"+
		"\u019c\u0005\u0006\u0000\u0000\u019c\u01a6\u0006\u0010\uffff\uffff\u0000"+
		"\u019d\u019e\u0005\u000f\u0000\u0000\u019e\u01a6\u0006\u0010\uffff\uffff"+
		"\u0000\u019f\u01a0\u0005\u0013\u0000\u0000\u01a0\u01a6\u0006\u0010\uffff"+
		"\uffff\u0000\u01a1\u01a2\u0005\u0016\u0000\u0000\u01a2\u01a6\u0006\u0010"+
		"\uffff\uffff\u0000\u01a3\u01a4\u0005D\u0000\u0000\u01a4\u01a6\u0006\u0010"+
		"\uffff\uffff\u0000\u01a5\u018f\u0001\u0000\u0000\u0000\u01a5\u0191\u0001"+
		"\u0000\u0000\u0000\u01a5\u0193\u0001\u0000\u0000\u0000\u01a5\u0195\u0001"+
		"\u0000\u0000\u0000\u01a5\u0197\u0001\u0000\u0000\u0000\u01a5\u0199\u0001"+
		"\u0000\u0000\u0000\u01a5\u019b\u0001\u0000\u0000\u0000\u01a5\u019d\u0001"+
		"\u0000\u0000\u0000\u01a5\u019f\u0001\u0000\u0000\u0000\u01a5\u01a1\u0001"+
		"\u0000\u0000\u0000\u01a5\u01a3\u0001\u0000\u0000\u0000\u01a6!\u0001\u0000"+
		"\u0000\u0000\u01a7\u01a8\u0003 \u0010\u0000\u01a8\u01a9\u0006\u0011\uffff"+
		"\uffff\u0000\u01a9\u01ad\u0001\u0000\u0000\u0000\u01aa\u01ab\u0005\u0003"+
		"\u0000\u0000\u01ab\u01ad\u0006\u0011\uffff\uffff\u0000\u01ac\u01a7\u0001"+
		"\u0000\u0000\u0000\u01ac\u01aa\u0001\u0000\u0000\u0000\u01ad\u01b1\u0001"+
		"\u0000\u0000\u0000\u01ae\u01af\u0003\"\u0011\u0000\u01af\u01b0\u0006\u0011"+
		"\uffff\uffff\u0000\u01b0\u01b2\u0001\u0000\u0000\u0000\u01b1\u01ae\u0001"+
		"\u0000\u0000\u0000\u01b1\u01b2\u0001\u0000\u0000\u0000\u01b2#\u0001\u0000"+
		"\u0000\u0000\u01b3\u01b7\u0006\u0012\uffff\uffff\u0000\u01b4\u01b5\u0003"+
		"(\u0014\u0000\u01b5\u01b6\u0006\u0012\uffff\uffff\u0000\u01b6\u01b8\u0001"+
		"\u0000\u0000\u0000\u01b7\u01b4\u0001\u0000\u0000\u0000\u01b7\u01b8\u0001"+
		"\u0000\u0000\u0000\u01b8\u01b9\u0001\u0000\u0000\u0000\u01b9\u01ba\u0003"+
		"&\u0013\u0000\u01ba\u01bb\u0006\u0012\uffff\uffff\u0000\u01bb%\u0001\u0000"+
		"\u0000\u0000\u01bc\u01bd\u0006\u0013\uffff\uffff\u0000\u01bd\u01be\u0005"+
		"D\u0000\u0000\u01be\u01c5\u0006\u0013\uffff\uffff\u0000\u01bf\u01c0\u0005"+
		"\u0017\u0000\u0000\u01c0\u01c1\u0003$\u0012\u0000\u01c1\u01c2\u0005\u0018"+
		"\u0000\u0000\u01c2\u01c3\u0006\u0013\uffff\uffff\u0000\u01c3\u01c5\u0001"+
		"\u0000\u0000\u0000\u01c4\u01bc\u0001\u0000\u0000\u0000\u01c4\u01bf\u0001"+
		"\u0000\u0000\u0000\u01c5\u01de\u0001\u0000\u0000\u0000\u01c6\u01c7\n\u0002"+
		"\u0000\u0000\u01c7\u01c8\u0006\u0013\uffff\uffff\u0000\u01c8\u01ca\u0005"+
		"\u0019\u0000\u0000\u01c9\u01cb\u0003\f\u0006\u0000\u01ca\u01c9\u0001\u0000"+
		"\u0000\u0000\u01ca\u01cb\u0001\u0000\u0000\u0000\u01cb\u01cc\u0001\u0000"+
		"\u0000\u0000\u01cc\u01cd\u0005\u001a\u0000\u0000\u01cd\u01dd\u0006\u0013"+
		"\uffff\uffff\u0000\u01ce\u01cf\n\u0001\u0000\u0000\u01cf\u01d0\u0006\u0013"+
		"\uffff\uffff\u0000\u01d0\u01d9\u0005\u0017\u0000\u0000\u01d1\u01d2\u0003"+
		"*\u0015\u0000\u01d2\u01d3\u0006\u0013\uffff\uffff\u0000\u01d3\u01da\u0001"+
		"\u0000\u0000\u0000\u01d4\u01d5\u0003.\u0017\u0000\u01d5\u01d6\u0006\u0013"+
		"\uffff\uffff\u0000\u01d6\u01d8\u0001\u0000\u0000\u0000\u01d7\u01d4\u0001"+
		"\u0000\u0000\u0000\u01d7\u01d8\u0001\u0000\u0000\u0000\u01d8\u01da\u0001"+
		"\u0000\u0000\u0000\u01d9\u01d1\u0001\u0000\u0000\u0000\u01d9\u01d7\u0001"+
		"\u0000\u0000\u0000\u01da\u01db\u0001\u0000\u0000\u0000\u01db\u01dd\u0005"+
		"\u0018\u0000\u0000\u01dc\u01c6\u0001\u0000\u0000\u0000\u01dc\u01ce\u0001"+
		"\u0000\u0000\u0000\u01dd\u01e0\u0001\u0000\u0000\u0000\u01de\u01dc\u0001"+
		"\u0000\u0000\u0000\u01de\u01df\u0001\u0000\u0000\u0000\u01df\'\u0001\u0000"+
		"\u0000\u0000\u01e0\u01de\u0001\u0000\u0000\u0000\u01e1\u01ea\u0006\u0014"+
		"\uffff\uffff\u0000\u01e2\u01e6\u0005\'\u0000\u0000\u01e3\u01e5\u0005\u0003"+
		"\u0000\u0000\u01e4\u01e3\u0001\u0000\u0000\u0000\u01e5\u01e8\u0001\u0000"+
		"\u0000\u0000\u01e6\u01e4\u0001\u0000\u0000\u0000\u01e6\u01e7\u0001\u0000"+
		"\u0000\u0000\u01e7\u01e9\u0001\u0000\u0000\u0000\u01e8\u01e6\u0001\u0000"+
		"\u0000\u0000\u01e9\u01eb\u0006\u0014\uffff\uffff\u0000\u01ea\u01e2\u0001"+
		"\u0000\u0000\u0000\u01eb\u01ec\u0001\u0000\u0000\u0000\u01ec\u01ea\u0001"+
		"\u0000\u0000\u0000\u01ec\u01ed\u0001\u0000\u0000\u0000\u01ed\u01ee\u0001"+
		"\u0000\u0000\u0000\u01ee\u01ef\u0006\u0014\uffff\uffff\u0000\u01ef)\u0001"+
		"\u0000\u0000\u0000\u01f0\u01f1\u0006\u0015\uffff\uffff\u0000\u01f1\u01f2"+
		"\u0003,\u0016\u0000\u01f2\u01f9\u0006\u0015\uffff\uffff\u0000\u01f3\u01f4"+
		"\u00054\u0000\u0000\u01f4\u01f5\u0003,\u0016\u0000\u01f5\u01f6\u0006\u0015"+
		"\uffff\uffff\u0000\u01f6\u01f8\u0001\u0000\u0000\u0000\u01f7\u01f3\u0001"+
		"\u0000\u0000\u0000\u01f8\u01fb\u0001\u0000\u0000\u0000\u01f9\u01f7\u0001"+
		"\u0000\u0000\u0000\u01f9\u01fa\u0001\u0000\u0000\u0000\u01fa+\u0001\u0000"+
		"\u0000\u0000\u01fb\u01f9\u0001\u0000\u0000\u0000\u01fc\u01fd\u0003\u0018"+
		"\f\u0000\u01fd\u0204\u0006\u0016\uffff\uffff\u0000\u01fe\u01ff\u0003$"+
		"\u0012\u0000\u01ff\u0200\u0006\u0016\uffff\uffff\u0000\u0200\u0205\u0001"+
		"\u0000\u0000\u0000\u0201\u0202\u00032\u0019\u0000\u0202\u0203\u0006\u0016"+
		"\uffff\uffff\u0000\u0203\u0205\u0001\u0000\u0000\u0000\u0204\u01fe\u0001"+
		"\u0000\u0000\u0000\u0204\u0201\u0001\u0000\u0000\u0000\u0205-\u0001\u0000"+
		"\u0000\u0000\u0206\u0207\u0006\u0017\uffff\uffff\u0000\u0207\u0208\u0005"+
		"D\u0000\u0000\u0208\u020e\u0006\u0017\uffff\uffff\u0000\u0209\u020a\u0005"+
		"4\u0000\u0000\u020a\u020b\u0005D\u0000\u0000\u020b\u020d\u0006\u0017\uffff"+
		"\uffff\u0000\u020c\u0209\u0001\u0000\u0000\u0000\u020d\u0210\u0001\u0000"+
		"\u0000\u0000\u020e\u020c\u0001\u0000\u0000\u0000\u020e\u020f\u0001\u0000"+
		"\u0000\u0000\u020f/\u0001\u0000\u0000\u0000\u0210\u020e\u0001\u0000\u0000"+
		"\u0000\u0211\u0212\u0006\u0018\uffff\uffff\u0000\u0212\u0213\u0003\"\u0011"+
		"\u0000\u0213\u0217\u0006\u0018\uffff\uffff\u0000\u0214\u0215\u00032\u0019"+
		"\u0000\u0215\u0216\u0006\u0018\uffff\uffff\u0000\u0216\u0218\u0001\u0000"+
		"\u0000\u0000\u0217\u0214\u0001\u0000\u0000\u0000\u0217\u0218\u0001\u0000"+
		"\u0000\u0000\u02181\u0001\u0000\u0000\u0000\u0219\u021a\u0003(\u0014\u0000"+
		"\u021a\u021b\u0006\u0019\uffff\uffff\u0000\u021b\u0225\u0001\u0000\u0000"+
		"\u0000\u021c\u021d\u0003(\u0014\u0000\u021d\u021e\u0006\u0019\uffff\uffff"+
		"\u0000\u021e\u0220\u0001\u0000\u0000\u0000\u021f\u021c\u0001\u0000\u0000"+
		"\u0000\u021f\u0220\u0001\u0000\u0000\u0000\u0220\u0221\u0001\u0000\u0000"+
		"\u0000\u0221\u0222\u00034\u001a\u0000\u0222\u0223\u0006\u0019\uffff\uffff"+
		"\u0000\u0223\u0225\u0001\u0000\u0000\u0000\u0224\u0219\u0001\u0000\u0000"+
		"\u0000\u0224\u021f\u0001\u0000\u0000\u0000\u02253\u0001\u0000\u0000\u0000"+
		"\u0226\u0227\u0006\u001a\uffff\uffff\u0000\u0227\u0229\u0005\u0019\u0000"+
		"\u0000\u0228\u022a\u0003\f\u0006\u0000\u0229\u0228\u0001\u0000\u0000\u0000"+
		"\u0229\u022a\u0001\u0000\u0000\u0000\u022a\u022b\u0001\u0000\u0000\u0000"+
		"\u022b\u022c\u0005\u001a\u0000\u0000\u022c\u0239\u0006\u001a\uffff\uffff"+
		"\u0000\u022d\u0235\u0005\u0017\u0000\u0000\u022e\u022f\u00032\u0019\u0000"+
		"\u022f\u0230\u0006\u001a\uffff\uffff\u0000\u0230\u0236\u0001\u0000\u0000"+
		"\u0000\u0231\u0233\u0003*\u0015\u0000\u0232\u0231\u0001\u0000\u0000\u0000"+
		"\u0232\u0233\u0001\u0000\u0000\u0000\u0233\u0234\u0001\u0000\u0000\u0000"+
		"\u0234\u0236\u0006\u001a\uffff\uffff\u0000\u0235\u022e\u0001\u0000\u0000"+
		"\u0000\u0235\u0232\u0001\u0000\u0000\u0000\u0236\u0237\u0001\u0000\u0000"+
		"\u0000\u0237\u0239\u0005\u0018\u0000\u0000\u0238\u0226\u0001\u0000\u0000"+
		"\u0000\u0238\u022d\u0001\u0000\u0000\u0000\u0239\u024c\u0001\u0000\u0000"+
		"\u0000\u023a\u023b\n\u0002\u0000\u0000\u023b\u023c\u0006\u001a\uffff\uffff"+
		"\u0000\u023c\u023e\u0005\u0019\u0000\u0000\u023d\u023f\u0003\f\u0006\u0000"+
		"\u023e\u023d\u0001\u0000\u0000\u0000\u023e\u023f\u0001\u0000\u0000\u0000"+
		"\u023f\u0240\u0001\u0000\u0000\u0000\u0240\u0241\u0005\u001a\u0000\u0000"+
		"\u0241\u024b\u0006\u001a\uffff\uffff\u0000\u0242\u0243\n\u0001\u0000\u0000"+
		"\u0243\u0244\u0006\u001a\uffff\uffff\u0000\u0244\u0246\u0005\u0017\u0000"+
		"\u0000\u0245\u0247\u0003*\u0015\u0000\u0246\u0245\u0001\u0000\u0000\u0000"+
		"\u0246\u0247\u0001\u0000\u0000\u0000\u0247\u0248\u0001\u0000\u0000\u0000"+
		"\u0248\u0249\u0005\u0018\u0000\u0000\u0249\u024b\u0006\u001a\uffff\uffff"+
		"\u0000\u024a\u023a\u0001\u0000\u0000\u0000\u024a\u0242\u0001\u0000\u0000"+
		"\u0000\u024b\u024e\u0001\u0000\u0000\u0000\u024c\u024a\u0001\u0000\u0000"+
		"\u0000\u024c\u024d\u0001\u0000\u0000\u0000\u024d5\u0001\u0000\u0000\u0000"+
		"\u024e\u024c\u0001\u0000\u0000\u0000\u024f\u0250\u0003\f\u0006\u0000\u0250"+
		"\u0251\u0006\u001b\uffff\uffff\u0000\u0251\u025b\u0001\u0000\u0000\u0000"+
		"\u0252\u0253\u0005\u001b\u0000\u0000\u0253\u0254\u00038\u001c\u0000\u0254"+
		"\u0256\u0006\u001b\uffff\uffff\u0000\u0255\u0257\u00054\u0000\u0000\u0256"+
		"\u0255\u0001\u0000\u0000\u0000\u0256\u0257\u0001\u0000\u0000\u0000\u0257"+
		"\u0258\u0001\u0000\u0000\u0000\u0258\u0259\u0005\u001c\u0000\u0000\u0259"+
		"\u025b\u0001\u0000\u0000\u0000\u025a\u024f\u0001\u0000\u0000\u0000\u025a"+
		"\u0252\u0001\u0000\u0000\u0000\u025b7\u0001\u0000\u0000\u0000\u025c\u025e"+
		"\u0003:\u001d\u0000\u025d\u025c\u0001\u0000\u0000\u0000\u025d\u025e\u0001"+
		"\u0000\u0000\u0000\u025e\u025f\u0001\u0000\u0000\u0000\u025f\u0260\u0003"+
		"6\u001b\u0000\u0260\u026a\u0006\u001c\uffff\uffff\u0000\u0261\u0263\u0005"+
		"4\u0000\u0000\u0262\u0264\u0003:\u001d\u0000\u0263\u0262\u0001\u0000\u0000"+
		"\u0000\u0263\u0264\u0001\u0000\u0000\u0000\u0264\u0265\u0001\u0000\u0000"+
		"\u0000\u0265\u0266\u00036\u001b\u0000\u0266\u0267\u0006\u001c\uffff\uffff"+
		"\u0000\u0267\u0269\u0001\u0000\u0000\u0000\u0268\u0261\u0001\u0000\u0000"+
		"\u0000\u0269\u026c\u0001\u0000\u0000\u0000\u026a\u0268\u0001\u0000\u0000"+
		"\u0000\u026a\u026b\u0001\u0000\u0000\u0000\u026b9\u0001\u0000\u0000\u0000"+
		"\u026c\u026a\u0001\u0000\u0000\u0000\u026d\u0271\u0006\u001d\uffff\uffff"+
		"\u0000\u026e\u026f\u0003<\u001e\u0000\u026f\u0270\u0006\u001d\uffff\uffff"+
		"\u0000\u0270\u0272\u0001\u0000\u0000\u0000\u0271\u026e\u0001\u0000\u0000"+
		"\u0000\u0272\u0273\u0001\u0000\u0000\u0000\u0273\u0271\u0001\u0000\u0000"+
		"\u0000\u0273\u0274\u0001\u0000\u0000\u0000\u0274\u0275\u0001\u0000\u0000"+
		"\u0000\u0275\u0276\u00055\u0000\u0000\u0276;\u0001\u0000\u0000\u0000\u0277"+
		"\u0278\u0005\u0019\u0000\u0000\u0278\u0279\u0003\f\u0006\u0000\u0279\u027a"+
		"\u0006\u001e\uffff\uffff\u0000\u027a\u027b\u0005\u001a\u0000\u0000\u027b"+
		"\u0280\u0001\u0000\u0000\u0000\u027c\u027d\u0005C\u0000\u0000\u027d\u027e"+
		"\u0005D\u0000\u0000\u027e\u0280\u0006\u001e\uffff\uffff\u0000\u027f\u0277"+
		"\u0001\u0000\u0000\u0000\u027f\u027c\u0001\u0000\u0000\u0000\u0280=\u0001"+
		"\u0000\u0000\u0000\u0281\u0282\u0003@ \u0000\u0282\u0283\u0006\u001f\uffff"+
		"\uffff\u0000\u0283\u0291\u0001\u0000\u0000\u0000\u0284\u0285\u0003D\""+
		"\u0000\u0285\u0286\u0006\u001f\uffff\uffff\u0000\u0286\u0291\u0001\u0000"+
		"\u0000\u0000\u0287\u0288\u0003F#\u0000\u0288\u0289\u0006\u001f\uffff\uffff"+
		"\u0000\u0289\u0291\u0001\u0000\u0000\u0000\u028a\u028b\u0003H$\u0000\u028b"+
		"\u028c\u0006\u001f\uffff\uffff\u0000\u028c\u0291\u0001\u0000\u0000\u0000"+
		"\u028d\u028e\u0003P(\u0000\u028e\u028f\u0006\u001f\uffff\uffff\u0000\u028f"+
		"\u0291\u0001\u0000\u0000\u0000\u0290\u0281\u0001\u0000\u0000\u0000\u0290"+
		"\u0284\u0001\u0000\u0000\u0000\u0290\u0287\u0001\u0000\u0000\u0000\u0290"+
		"\u028a\u0001\u0000\u0000\u0000\u0290\u028d\u0001\u0000\u0000\u0000\u0291"+
		"?\u0001\u0000\u0000\u0000\u0292\u0293\u0006 \uffff\uffff\u0000\u0293\u0299"+
		"\u0005\u001b\u0000\u0000\u0294\u0295\u0003B!\u0000\u0295\u0296\u0006 "+
		"\uffff\uffff\u0000\u0296\u0298\u0001\u0000\u0000\u0000\u0297\u0294\u0001"+
		"\u0000\u0000\u0000\u0298\u029b\u0001\u0000\u0000\u0000\u0299\u0297\u0001"+
		"\u0000\u0000\u0000\u0299\u029a\u0001\u0000\u0000\u0000\u029a\u029c\u0001"+
		"\u0000\u0000\u0000\u029b\u0299\u0001\u0000\u0000\u0000\u029c\u029d\u0005"+
		"\u001c\u0000\u0000\u029dA\u0001\u0000\u0000\u0000\u029e\u029f\u0003>\u001f"+
		"\u0000\u029f\u02a0\u0006!\uffff\uffff\u0000\u02a0\u02a5\u0001\u0000\u0000"+
		"\u0000\u02a1\u02a2\u0003\u0016\u000b\u0000\u02a2\u02a3\u0006!\uffff\uffff"+
		"\u0000\u02a3\u02a5\u0001\u0000\u0000\u0000\u02a4\u029e\u0001\u0000\u0000"+
		"\u0000\u02a4\u02a1\u0001\u0000\u0000\u0000\u02a5C\u0001\u0000\u0000\u0000"+
		"\u02a6\u02a7\u0003\n\u0005\u0000\u02a7\u02a8\u0006\"\uffff\uffff\u0000"+
		"\u02a8\u02aa\u0001\u0000\u0000\u0000\u02a9\u02a6\u0001\u0000\u0000\u0000"+
		"\u02a9\u02aa\u0001\u0000\u0000\u0000\u02aa\u02ab\u0001\u0000\u0000\u0000"+
		"\u02ab\u02ac\u00053\u0000\u0000\u02acE\u0001\u0000\u0000\u0000\u02ad\u02ae"+
		"\u0005\n\u0000\u0000\u02ae\u02af\u0005\u0017\u0000\u0000\u02af\u02b0\u0003"+
		"\n\u0005\u0000\u02b0\u02b1\u0005\u0018\u0000\u0000\u02b1\u02b2\u0003>"+
		"\u001f\u0000\u02b2\u02b7\u0006#\uffff\uffff\u0000\u02b3\u02b4\u0005\u0007"+
		"\u0000\u0000\u02b4\u02b5\u0003>\u001f\u0000\u02b5\u02b6\u0006#\uffff\uffff"+
		"\u0000\u02b6\u02b8\u0001\u0000\u0000\u0000\u02b7\u02b3\u0001\u0000\u0000"+
		"\u0000\u02b7\u02b8\u0001\u0000\u0000\u0000\u02b8G\u0001\u0000\u0000\u0000"+
		"\u02b9\u02ba\u0005\u0015\u0000\u0000\u02ba\u02bb\u0005\u0017\u0000\u0000"+
		"\u02bb\u02bc\u0003\n\u0005\u0000\u02bc\u02bd\u0005\u0018\u0000\u0000\u02bd"+
		"\u02be\u0003>\u001f\u0000\u02be\u02bf\u0006$\uffff\uffff\u0000\u02bf\u02d1"+
		"\u0001\u0000\u0000\u0000\u02c0\u02c1\u0005\u0005\u0000\u0000\u02c1\u02c2"+
		"\u0003>\u001f\u0000\u02c2\u02c3\u0005\u0015\u0000\u0000\u02c3\u02c4\u0005"+
		"\u0017\u0000\u0000\u02c4\u02c5\u0003\n\u0005\u0000\u02c5\u02c6\u0005\u0018"+
		"\u0000\u0000\u02c6\u02c7\u00053\u0000\u0000\u02c7\u02c8\u0006$\uffff\uffff"+
		"\u0000\u02c8\u02d1\u0001\u0000\u0000\u0000\u02c9\u02ca\u0005\t\u0000\u0000"+
		"\u02ca\u02cb\u0005\u0017\u0000\u0000\u02cb\u02cc\u0003J%\u0000\u02cc\u02cd"+
		"\u0005\u0018\u0000\u0000\u02cd\u02ce\u0003>\u001f\u0000\u02ce\u02cf\u0006"+
		"$\uffff\uffff\u0000\u02cf\u02d1\u0001\u0000\u0000\u0000\u02d0\u02b9\u0001"+
		"\u0000\u0000\u0000\u02d0\u02c0\u0001\u0000\u0000\u0000\u02d0\u02c9\u0001"+
		"\u0000\u0000\u0000\u02d1I\u0001\u0000\u0000\u0000\u02d2\u02d3\u0003L&"+
		"\u0000\u02d3\u02d4\u0006%\uffff\uffff\u0000\u02d4\u02db\u0001\u0000\u0000"+
		"\u0000\u02d5\u02d6\u0003\n\u0005\u0000\u02d6\u02d7\u0006%\uffff\uffff"+
		"\u0000\u02d7\u02d9\u0001\u0000\u0000\u0000\u02d8\u02d5\u0001\u0000\u0000"+
		"\u0000\u02d8\u02d9\u0001\u0000\u0000\u0000\u02d9\u02db\u0001\u0000\u0000"+
		"\u0000\u02da\u02d2\u0001\u0000\u0000\u0000\u02da\u02d8\u0001\u0000\u0000"+
		"\u0000\u02db\u02dc\u0001\u0000\u0000\u0000\u02dc\u02e0\u00053\u0000\u0000"+
		"\u02dd\u02de\u0003N\'\u0000\u02de\u02df\u0006%\uffff\uffff\u0000\u02df"+
		"\u02e1\u0001\u0000\u0000\u0000\u02e0\u02dd\u0001\u0000\u0000\u0000\u02e0"+
		"\u02e1\u0001\u0000\u0000\u0000\u02e1\u02e2\u0001\u0000\u0000\u0000\u02e2"+
		"\u02e6\u00053\u0000\u0000\u02e3\u02e4\u0003N\'\u0000\u02e4\u02e5\u0006"+
		"%\uffff\uffff\u0000\u02e5\u02e7\u0001\u0000\u0000\u0000\u02e6\u02e3\u0001"+
		"\u0000\u0000\u0000\u02e6\u02e7\u0001\u0000\u0000\u0000\u02e7K\u0001\u0000"+
		"\u0000\u0000\u02e8\u02e9\u0003\u0018\f\u0000\u02e9\u02ed\u0006&\uffff"+
		"\uffff\u0000\u02ea\u02eb\u0003\u001c\u000e\u0000\u02eb\u02ec\u0006&\uffff"+
		"\uffff\u0000\u02ec\u02ee\u0001\u0000\u0000\u0000\u02ed\u02ea\u0001\u0000"+
		"\u0000\u0000\u02ed\u02ee\u0001\u0000\u0000\u0000\u02eeM\u0001\u0000\u0000"+
		"\u0000\u02ef\u02f0\u0006\'\uffff\uffff\u0000\u02f0\u02f1\u0003\f\u0006"+
		"\u0000\u02f1\u02f8\u0006\'\uffff\uffff\u0000\u02f2\u02f3\u00054\u0000"+
		"\u0000\u02f3\u02f4\u0003\f\u0006\u0000\u02f4\u02f5\u0006\'\uffff\uffff"+
		"\u0000\u02f5\u02f7\u0001\u0000\u0000\u0000\u02f6\u02f2\u0001\u0000\u0000"+
		"\u0000\u02f7\u02fa\u0001\u0000\u0000\u0000\u02f8\u02f6\u0001\u0000\u0000"+
		"\u0000\u02f8\u02f9\u0001\u0000\u0000\u0000\u02f9O\u0001\u0000\u0000\u0000"+
		"\u02fa\u02f8\u0001\u0000\u0000\u0000\u02fb\u02fc\u0005\u0004\u0000\u0000"+
		"\u02fc\u0307\u0006(\uffff\uffff\u0000\u02fd\u02fe\u0005\u0001\u0000\u0000"+
		"\u02fe\u0307\u0006(\uffff\uffff\u0000\u02ff\u0300\u0005\r\u0000\u0000"+
		"\u0300\u0304\u0006(\uffff\uffff\u0000\u0301\u0302\u0003\f\u0006\u0000"+
		"\u0302\u0303\u0006(\uffff\uffff\u0000\u0303\u0305\u0001\u0000\u0000\u0000"+
		"\u0304\u0301\u0001\u0000\u0000\u0000\u0304\u0305\u0001\u0000\u0000\u0000"+
		"\u0305\u0307\u0001\u0000\u0000\u0000\u0306\u02fb\u0001\u0000\u0000\u0000"+
		"\u0306\u02fd\u0001\u0000\u0000\u0000\u0306\u02ff\u0001\u0000\u0000\u0000"+
		"\u0307\u0308\u0001\u0000\u0000\u0000\u0308\u0309\u00053\u0000\u0000\u0309"+
		"Q\u0001\u0000\u0000\u0000\u030a\u030b\u0005E\u0000\u0000\u030b\u0311\u0006"+
		")\uffff\uffff\u0000\u030c\u030d\u0005F\u0000\u0000\u030d\u0311\u0006)"+
		"\uffff\uffff\u0000\u030e\u030f\u0005H\u0000\u0000\u030f\u0311\u0006)\uffff"+
		"\uffff\u0000\u0310\u030a\u0001\u0000\u0000\u0000\u0310\u030c\u0001\u0000"+
		"\u0000\u0000\u0310\u030e\u0001\u0000\u0000\u0000\u0311S\u0001\u0000\u0000"+
		"\u0000HYcmr}\u0087\u008b\u0098\u00a6\u00b0\u00bd\u00cb\u00da\u00e3\u012c"+
		"\u0136\u0138\u0144\u0153\u0160\u0170\u0179\u0184\u018d\u01a5\u01ac\u01b1"+
		"\u01b7\u01c4\u01ca\u01d7\u01d9\u01dc\u01de\u01e6\u01ec\u01f9\u0204\u020e"+
		"\u0217\u021f\u0224\u0229\u0232\u0235\u0238\u023e\u0246\u024a\u024c\u0256"+
		"\u025a\u025d\u0263\u026a\u0273\u027f\u0290\u0299\u02a4\u02a9\u02b7\u02d0"+
		"\u02d8\u02da\u02e0\u02e6\u02ed\u02f8\u0304\u0306\u0310";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}