// Generated from G:/stuff/Paper/SAYAC/SAYAC_Compiler/src/main/grammar/SimpleLang.g4 by ANTLR 4.13.2
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
		RULE_functionDefinition = 3, RULE_declarationList = 4, RULE_expression = 5, 
		RULE_argumentExpressionList = 6, RULE_unaryOperator = 7, RULE_castExpression = 8, 
		RULE_assignmentOperator = 9, RULE_declaration = 10, RULE_declarationSpecifiers = 11, 
		RULE_declarationSpecifier = 12, RULE_initDeclaratorList = 13, RULE_initDeclarator = 14, 
		RULE_typeSpecifier = 15, RULE_specifierQualifierList = 16, RULE_declarator = 17, 
		RULE_directDeclarator = 18, RULE_pointer = 19, RULE_parameterList = 20, 
		RULE_parameterDeclaration = 21, RULE_identifierList = 22, RULE_typeName = 23, 
		RULE_abstractDeclarator = 24, RULE_directAbstractDeclarator = 25, RULE_initializer = 26, 
		RULE_initializerList = 27, RULE_designation = 28, RULE_designator = 29, 
		RULE_statement = 30, RULE_compoundStatement = 31, RULE_blockItem = 32, 
		RULE_expressionStatement = 33, RULE_selectionStatement = 34, RULE_iterationStatement = 35, 
		RULE_forCondition = 36, RULE_forDeclaration = 37, RULE_forExpression = 38, 
		RULE_jumpStatement = 39, RULE_constant = 40;
	private static String[] makeRuleNames() {
		return new String[] {
			"compilationUnit", "translationUnit", "externalDeclaration", "functionDefinition", 
			"declarationList", "expression", "argumentExpressionList", "unaryOperator", 
			"castExpression", "assignmentOperator", "declaration", "declarationSpecifiers", 
			"declarationSpecifier", "initDeclaratorList", "initDeclarator", "typeSpecifier", 
			"specifierQualifierList", "declarator", "directDeclarator", "pointer", 
			"parameterList", "parameterDeclaration", "identifierList", "typeName", 
			"abstractDeclarator", "directAbstractDeclarator", "initializer", "initializerList", 
			"designation", "designator", "statement", "compoundStatement", "blockItem", 
			"expressionStatement", "selectionStatement", "iterationStatement", "forCondition", 
			"forDeclaration", "forExpression", "jumpStatement", "constant"
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
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2252349583972684L) != 0) || _la==Identifier) {
				{
				setState(84);
				((CompilationUnitContext)_localctx).tu = translationUnit();
				_localctx.programRet.addExternalDeclarations(((CompilationUnitContext)_localctx).tu.list);
				}
			}

			setState(89);
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
			setState(95); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(92);
				((TranslationUnitContext)_localctx).ed = externalDeclaration();
				if (((TranslationUnitContext)_localctx).ed.externalDecRet != null) _localctx.list.add(((TranslationUnitContext)_localctx).ed.externalDecRet);
				}
				}
				setState(97); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2252349583972684L) != 0) || _la==Identifier );
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
			setState(107);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				((ExternalDeclarationContext)_localctx).fd = functionDefinition();
				((ExternalDeclarationContext)_localctx).externalDecRet =  ((ExternalDeclarationContext)_localctx).fd.funcDefRet;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				((ExternalDeclarationContext)_localctx).dec = declaration();
				((ExternalDeclarationContext)_localctx).externalDecRet =  ((ExternalDeclarationContext)_localctx).dec.decRet;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(105);
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
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
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
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(109);
				((FunctionDefinitionContext)_localctx).specs = declarationSpecifiers();
				}
				break;
			}
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

			        ((FunctionDefinitionContext)_localctx).funcDefRet =  new FunctionDefinition(((FunctionDefinitionContext)_localctx).specs != null ? ((FunctionDefinitionContext)_localctx).specs.list: null, ((FunctionDefinitionContext)_localctx).dec.declaratorRet, ((FunctionDefinitionContext)_localctx).declist != null? ((FunctionDefinitionContext)_localctx).declist.list: null, ((FunctionDefinitionContext)_localctx).cstmt.cstmtRet);
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
		public ExpressionContext expression;
		public List<ExpressionContext> es = new ArrayList<ExpressionContext>();
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
		public List<TerminalNode> Comma() { return getTokens(SimpleLangParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SimpleLangParser.Comma, i);
		}
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
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(128);
				((ExpressionContext)_localctx).id = match(Identifier);
				((ExpressionContext)_localctx).expRet =  new Identifier((((ExpressionContext)_localctx).id!=null?((ExpressionContext)_localctx).id.getText():null), ((ExpressionContext)_localctx).id.getLine());
				}
				break;
			case 2:
				{
				setState(130);
				((ExpressionContext)_localctx).c = constant();
				((ExpressionContext)_localctx).expRet =  ((ExpressionContext)_localctx).c.cret;  _localctx.expRet.setLine((((ExpressionContext)_localctx).c!=null?(((ExpressionContext)_localctx).c.start):null).getLine());
				}
				break;
			case 3:
				{
				List<String> list = new ArrayList<>();
				setState(136); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(134);
						((ExpressionContext)_localctx).str = match(StringLiteral);
						list.add((((ExpressionContext)_localctx).str!=null?((ExpressionContext)_localctx).str.getText():null));
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(138); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				((ExpressionContext)_localctx).expRet =  new StringExpr(list); _localctx.expRet.setLine(_localctx.start.getLine());
				}
				break;
			case 4:
				{
				setState(141);
				match(LeftParen);
				setState(142);
				((ExpressionContext)_localctx).e = expression(0);
				setState(143);
				match(RightParen);
				((ExpressionContext)_localctx).expRet =  ((ExpressionContext)_localctx).e.expRet; _localctx.expRet.setLine(_localctx.start.getLine());
				}
				break;
			case 5:
				{
				setState(146);
				match(LeftParen);
				setState(147);
				((ExpressionContext)_localctx).t = typeName();
				setState(148);
				match(RightParen);
				setState(149);
				match(LeftBrace);
				setState(150);
				((ExpressionContext)_localctx).i = initializerList();
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(151);
					match(Comma);
					}
				}

				setState(154);
				match(RightBrace);
				((ExpressionContext)_localctx).expRet =  new IniListExpr(((ExpressionContext)_localctx).t.typeRet, ((ExpressionContext)_localctx).i.list); _localctx.expRet.setLine(_localctx.start.getLine());
				}
				break;
			case 6:
				{
				 List<Token> ops = new ArrayList<>(); 
				setState(162);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(158);
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
					setState(164);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				}
				setState(204);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(165);
					((ExpressionContext)_localctx).id = match(Identifier);
					((ExpressionContext)_localctx).expRet =  new Identifier((((ExpressionContext)_localctx).id!=null?((ExpressionContext)_localctx).id.getText():null), ((ExpressionContext)_localctx).id.getLine()); 
					}
					break;
				case 2:
					{
					setState(167);
					((ExpressionContext)_localctx).c = constant();
					((ExpressionContext)_localctx).expRet =  ((ExpressionContext)_localctx).c.cret;
					}
					break;
				case 3:
					{
					List<String> list = new ArrayList<>();
					setState(173); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(171);
							((ExpressionContext)_localctx).str = match(StringLiteral);
							list.add((((ExpressionContext)_localctx).str!=null?((ExpressionContext)_localctx).str.getText():null));
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(175); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					((ExpressionContext)_localctx).expRet =  new StringExpr(list);
					}
					break;
				case 4:
					{
					setState(178);
					match(LeftParen);
					setState(179);
					((ExpressionContext)_localctx).e = expression(0);
					setState(180);
					match(RightParen);
					((ExpressionContext)_localctx).expRet =  ((ExpressionContext)_localctx).e.expRet;
					}
					break;
				case 5:
					{
					setState(183);
					match(LeftParen);
					setState(184);
					((ExpressionContext)_localctx).t = typeName();
					setState(185);
					match(RightParen);
					setState(186);
					match(LeftBrace);
					setState(187);
					((ExpressionContext)_localctx).i = initializerList();
					setState(189);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Comma) {
						{
						setState(188);
						match(Comma);
						}
					}

					setState(191);
					match(RightBrace);
					((ExpressionContext)_localctx).expRet =  new IniListExpr(((ExpressionContext)_localctx).t.typeRet, ((ExpressionContext)_localctx).i.list);
					}
					break;
				case 6:
					{
					setState(194);
					((ExpressionContext)_localctx).u = unaryOperator();
					setState(195);
					((ExpressionContext)_localctx).ce = castExpression();
					 ((ExpressionContext)_localctx).expRet =  new UnaryExpr(((ExpressionContext)_localctx).ce.expRet, ((ExpressionContext)_localctx).u.op); 
					}
					break;
				case 7:
					{
					setState(198);
					match(Sizeof);
					setState(199);
					match(LeftParen);
					setState(200);
					((ExpressionContext)_localctx).t = typeName();
					setState(201);
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
				setState(207);
				match(LeftParen);
				setState(208);
				((ExpressionContext)_localctx).tn = typeName();
				setState(209);
				match(RightParen);
				setState(210);
				((ExpressionContext)_localctx).ce = castExpression();
				 ((ExpressionContext)_localctx).expRet =  new CastExpr(((ExpressionContext)_localctx).tn.typeRet, ((ExpressionContext)_localctx).ce.expRet); _localctx.expRet.setLine(_localctx.start.getLine());
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(307);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(305);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(215);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(216);
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
						setState(217);
						((ExpressionContext)_localctx).e2 = expression(14);
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
						setState(220);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(221);
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
						setState(222);
						((ExpressionContext)_localctx).e2 = expression(13);
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
						setState(225);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(226);
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
						setState(227);
						((ExpressionContext)_localctx).e2 = expression(12);
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
						setState(230);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(231);
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
						setState(232);
						((ExpressionContext)_localctx).e2 = expression(11);
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
						setState(235);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(236);
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
						setState(237);
						((ExpressionContext)_localctx).e2 = expression(10);
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
						setState(240);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(241);
						((ExpressionContext)_localctx).op = match(And);
						setState(242);
						((ExpressionContext)_localctx).e2 = expression(9);
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
						setState(245);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(246);
						((ExpressionContext)_localctx).op = match(Xor);
						setState(247);
						((ExpressionContext)_localctx).e2 = expression(8);
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
						setState(250);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(251);
						((ExpressionContext)_localctx).op = match(Or);
						setState(252);
						((ExpressionContext)_localctx).e2 = expression(7);
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
						setState(255);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(256);
						((ExpressionContext)_localctx).op = match(AndAnd);
						setState(257);
						((ExpressionContext)_localctx).e2 = expression(6);
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
						setState(260);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(261);
						((ExpressionContext)_localctx).op = match(OrOr);
						setState(262);
						((ExpressionContext)_localctx).e2 = expression(5);
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
						setState(265);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(266);
						match(Question);
						setState(267);
						((ExpressionContext)_localctx).e2 = expression(0);
						setState(268);
						match(Colon);
						setState(269);
						((ExpressionContext)_localctx).e3 = expression(4);
						 ((ExpressionContext)_localctx).expRet =  new TernaryExpr(((ExpressionContext)_localctx).e1.expRet, ((ExpressionContext)_localctx).e2.expRet, ((ExpressionContext)_localctx).e3.expRet);
						                    _localctx.expRet.setLine(_localctx.start.getLine());
						                  
						}
						break;
					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(272);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(273);
						((ExpressionContext)_localctx).op2 = assignmentOperator();
						setState(274);
						((ExpressionContext)_localctx).e2 = expression(3);
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
						setState(277);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(278);
						match(LeftBracket);
						setState(279);
						((ExpressionContext)_localctx).e2 = expression(0);
						setState(280);
						match(RightBracket);
						 ((ExpressionContext)_localctx).expRet =  new ArrayExpr(((ExpressionContext)_localctx).e1.expRet, ((ExpressionContext)_localctx).e2.expRet); _localctx.expRet.setLine(_localctx.start.getLine());
						}
						break;
					case 14:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(283);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(284);
						match(LeftParen);
						setState(286);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 247697986031190145L) != 0)) {
							{
							setState(285);
							((ExpressionContext)_localctx).l = argumentExpressionList();
							}
						}

						setState(288);
						match(RightParen);
						((ExpressionContext)_localctx).expRet =  new FunctionExpr(((ExpressionContext)_localctx).e.expRet, ((ExpressionContext)_localctx).l!=null? ((ExpressionContext)_localctx).l.list: null); _localctx.expRet.setLine(_localctx.start.getLine());
						}
						break;
					case 15:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(290);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(291);
						match(PlusPlus);
						((ExpressionContext)_localctx).expRet =  new UnaryExpr(((ExpressionContext)_localctx).e.expRet, UnaryOperator.POST_INC); _localctx.expRet.setLine(_localctx.start.getLine());
						}
						break;
					case 16:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(293);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(294);
						match(MinusMinus);
						((ExpressionContext)_localctx).expRet =  new UnaryExpr(((ExpressionContext)_localctx).e.expRet, UnaryOperator.POST_DEC); _localctx.expRet.setLine(_localctx.start.getLine());
						}
						break;
					case 17:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(296);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(299); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(297);
								match(Comma);
								setState(298);
								((ExpressionContext)_localctx).expression = expression(0);
								((ExpressionContext)_localctx).es.add(((ExpressionContext)_localctx).expression);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(301); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );

						                      List<Expr> result = new ArrayList<>();
						                          result.add(((ExpressionContext)_localctx).e1.expRet);
						                          for (ExpressionContext ctx : ((ExpressionContext)_localctx).es) {
						                              result.add(ctx.expRet);
						                          }
						                      ((ExpressionContext)_localctx).expRet =  new CommaExpr(result);
						                      _localctx.expRet.setLine(_localctx.start.getLine());
						                  
						}
						break;
					}
					} 
				}
				setState(309);
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
		enterRule(_localctx, 12, RULE_argumentExpressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((ArgumentExpressionListContext)_localctx).list =  new ArrayList<>();
			setState(311);
			((ArgumentExpressionListContext)_localctx).e = expression(0);
			_localctx.list.add(((ArgumentExpressionListContext)_localctx).e.expRet);
			setState(319);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(313);
				match(Comma);
				setState(314);
				((ArgumentExpressionListContext)_localctx).e2 = expression(0);
				_localctx.list.add(((ArgumentExpressionListContext)_localctx).e2.expRet);
				}
				}
				setState(321);
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
		enterRule(_localctx, 14, RULE_unaryOperator);
		try {
			setState(334);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case And:
				enterOuterAlt(_localctx, 1);
				{
				setState(322);
				match(And);
				((UnaryOperatorContext)_localctx).op =  UnaryOperator.AND;
				}
				break;
			case Star:
				enterOuterAlt(_localctx, 2);
				{
				setState(324);
				match(Star);
				((UnaryOperatorContext)_localctx).op =  UnaryOperator.STAR;
				}
				break;
			case Plus:
				enterOuterAlt(_localctx, 3);
				{
				setState(326);
				match(Plus);
				((UnaryOperatorContext)_localctx).op =  UnaryOperator.PLUS;
				}
				break;
			case Minus:
				enterOuterAlt(_localctx, 4);
				{
				setState(328);
				match(Minus);
				((UnaryOperatorContext)_localctx).op =  UnaryOperator.MINUS;
				}
				break;
			case Tilde:
				enterOuterAlt(_localctx, 5);
				{
				setState(330);
				match(Tilde);
				((UnaryOperatorContext)_localctx).op =  UnaryOperator.TILDE;
				}
				break;
			case Not:
				enterOuterAlt(_localctx, 6);
				{
				setState(332);
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
		enterRule(_localctx, 16, RULE_castExpression);
		try {
			setState(347);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(336);
				match(LeftParen);
				setState(337);
				((CastExpressionContext)_localctx).tn = typeName();
				setState(338);
				match(RightParen);
				setState(339);
				((CastExpressionContext)_localctx).ce = castExpression();
				 ((CastExpressionContext)_localctx).expRet =  new CastExpr(((CastExpressionContext)_localctx).tn.typeRet, ((CastExpressionContext)_localctx).ce.expRet); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(342);
				((CastExpressionContext)_localctx).e = expression(0);
				 ((CastExpressionContext)_localctx).expRet =  ((CastExpressionContext)_localctx).e.expRet; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(345);
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
		enterRule(_localctx, 18, RULE_assignmentOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
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
		enterRule(_localctx, 20, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			((DeclarationContext)_localctx).specs = declarationSpecifiers();
			setState(354);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & 35184372154369L) != 0)) {
				{
				setState(353);
				((DeclarationContext)_localctx).decl = initDeclaratorList();
				}
			}

			setState(356);
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
		enterRule(_localctx, 22, RULE_declarationSpecifiers);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			((DeclarationSpecifiersContext)_localctx).list =  new ArrayList<>();
			setState(363); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(360);
					((DeclarationSpecifiersContext)_localctx).spec = declarationSpecifier();
					_localctx.list.add(((DeclarationSpecifiersContext)_localctx).spec.typeRet);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(365); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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
		enterRule(_localctx, 24, RULE_declarationSpecifier);
		try {
			setState(374);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Typedef:
				enterOuterAlt(_localctx, 1);
				{
				setState(367);
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
				setState(369);
				((DeclarationSpecifierContext)_localctx).ts = typeSpecifier();
				((DeclarationSpecifierContext)_localctx).typeRet =  ((DeclarationSpecifierContext)_localctx).ts.typeRet;
				}
				break;
			case Const:
				enterOuterAlt(_localctx, 3);
				{
				setState(372);
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
		enterRule(_localctx, 26, RULE_initDeclaratorList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((InitDeclaratorListContext)_localctx).list =  new ArrayList<>();
			setState(377);
			((InitDeclaratorListContext)_localctx).i0 = initDeclarator();
			_localctx.list.add(((InitDeclaratorListContext)_localctx).i0.initDecRet);
			setState(385);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(379);
				match(Comma);
				setState(380);
				((InitDeclaratorListContext)_localctx).ii = initDeclarator();
				_localctx.list.add(((InitDeclaratorListContext)_localctx).ii.initDecRet);
				}
				}
				setState(387);
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
		enterRule(_localctx, 28, RULE_initDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(388);
			((InitDeclaratorContext)_localctx).dec = declarator();
			((InitDeclaratorContext)_localctx).initDecRet =  new InitDeclarator(((InitDeclaratorContext)_localctx).dec.declaratorRet);
			setState(394);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(390);
				match(Assign);
				setState(391);
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
		enterRule(_localctx, 30, RULE_typeSpecifier);
		try {
			setState(418);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Void:
				enterOuterAlt(_localctx, 1);
				{
				setState(396);
				match(Void);
				 ((TypeSpecifierContext)_localctx).typeRet =  Type.VOID; 
				}
				break;
			case Char:
				enterOuterAlt(_localctx, 2);
				{
				setState(398);
				match(Char);
				 ((TypeSpecifierContext)_localctx).typeRet =  Type.CHAR; 
				}
				break;
			case Short:
				enterOuterAlt(_localctx, 3);
				{
				setState(400);
				match(Short);
				 ((TypeSpecifierContext)_localctx).typeRet =  Type.SHORT; 
				}
				break;
			case Int:
				enterOuterAlt(_localctx, 4);
				{
				setState(402);
				match(Int);
				 ((TypeSpecifierContext)_localctx).typeRet =  Type.INT; 
				}
				break;
			case Long:
				enterOuterAlt(_localctx, 5);
				{
				setState(404);
				match(Long);
				 ((TypeSpecifierContext)_localctx).typeRet =  Type.LONG; 
				}
				break;
			case Float:
				enterOuterAlt(_localctx, 6);
				{
				setState(406);
				match(Float);
				 ((TypeSpecifierContext)_localctx).typeRet =  Type.FLOAT; 
				}
				break;
			case Double:
				enterOuterAlt(_localctx, 7);
				{
				setState(408);
				match(Double);
				 ((TypeSpecifierContext)_localctx).typeRet =  Type.DOUBLE; 
				}
				break;
			case Signed:
				enterOuterAlt(_localctx, 8);
				{
				setState(410);
				match(Signed);
				 ((TypeSpecifierContext)_localctx).typeRet =  Type.SIGNED; 
				}
				break;
			case Unsigned:
				enterOuterAlt(_localctx, 9);
				{
				setState(412);
				match(Unsigned);
				 ((TypeSpecifierContext)_localctx).typeRet =  Type.UNSIGNED; 
				}
				break;
			case Bool:
				enterOuterAlt(_localctx, 10);
				{
				setState(414);
				match(Bool);
				 ((TypeSpecifierContext)_localctx).typeRet =  Type.BOOL; 
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 11);
				{
				setState(416);
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
		enterRule(_localctx, 32, RULE_specifierQualifierList);
		((SpecifierQualifierListContext)_localctx).list =  new ArrayList<>();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(425);
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
				setState(420);
				((SpecifierQualifierListContext)_localctx).ts = typeSpecifier();
				_localctx.list.add(((SpecifierQualifierListContext)_localctx).ts.typeRet);
				}
				break;
			case Const:
				{
				setState(423);
				match(Const);
				_localctx.list.add(Type.CONST);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(430);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5822796L) != 0) || _la==Identifier) {
				{
				setState(427);
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
		enterRule(_localctx, 34, RULE_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((DeclaratorContext)_localctx).declaratorRet =  new Declarator(); _localctx.declaratorRet.setLine(_localctx.start.getLine());
			setState(436);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Star) {
				{
				setState(433);
				((DeclaratorContext)_localctx).p = pointer();
				_localctx.declaratorRet.setPointer(((DeclaratorContext)_localctx).p.ptrRet);
				}
			}

			setState(438);
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
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_directDeclarator, _p);
		((DirectDeclaratorContext)_localctx).ddRet =  new DirectDeclarator();
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(449);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				{
				setState(442);
				((DirectDeclaratorContext)_localctx).id = match(Identifier);
				_localctx.ddRet.setIdentifier(new Identifier((((DirectDeclaratorContext)_localctx).id!=null?((DirectDeclaratorContext)_localctx).id.getText():null), ((DirectDeclaratorContext)_localctx).id.getLine()));
				}
				break;
			case LeftParen:
				{
				setState(444);
				match(LeftParen);
				setState(445);
				((DirectDeclaratorContext)_localctx).d = declarator();
				setState(446);
				match(RightParen);
				_localctx.ddRet.setInnerDeclarator(((DirectDeclaratorContext)_localctx).d.declaratorRet);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(475);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(473);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
					case 1:
						{
						_localctx = new DirectDeclaratorContext(_parentctx, _parentState);
						_localctx.dd = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_directDeclarator);
						setState(451);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						((DirectDeclaratorContext)_localctx).ddRet =  ((DirectDeclaratorContext)_localctx).dd.ddRet;
						setState(453);
						match(LeftBracket);
						setState(455);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 247697986031190145L) != 0)) {
							{
							setState(454);
							((DirectDeclaratorContext)_localctx).exp = expression(0);
							}
						}

						setState(457);
						match(RightBracket);
						_localctx.ddRet.addArrExpr(((DirectDeclaratorContext)_localctx).exp.expRet);
						}
						break;
					case 2:
						{
						_localctx = new DirectDeclaratorContext(_parentctx, _parentState);
						_localctx.dd = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_directDeclarator);
						setState(459);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						((DirectDeclaratorContext)_localctx).ddRet =  ((DirectDeclaratorContext)_localctx).dd.ddRet;
						setState(461);
						match(LeftParen);
						setState(470);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
						case 1:
							{
							setState(462);
							((DirectDeclaratorContext)_localctx).pl = parameterList();
							_localctx.ddRet.addFuncParams(((DirectDeclaratorContext)_localctx).pl.list);
							}
							break;
						case 2:
							{
							setState(468);
							_errHandler.sync(this);
							_la = _input.LA(1);
							if (_la==Identifier) {
								{
								setState(465);
								((DirectDeclaratorContext)_localctx).idl = identifierList();
								_localctx.ddRet.addFuncIdentifiers(((DirectDeclaratorContext)_localctx).idl.list);
								}
							}

							}
							break;
						}
						setState(472);
						match(RightParen);
						}
						break;
					}
					} 
				}
				setState(477);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
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
		enterRule(_localctx, 38, RULE_pointer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

			        ((PointerContext)_localctx).ptrRet =  new Pointer();
			        int stars = 0;
			        List<Integer> constCounts = new ArrayList<>();
			    
			setState(487); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				{
				setState(479);
				match(Star);
				setState(483);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Const) {
					{
					{
					setState(480);
					((PointerContext)_localctx).Const = match(Const);
					((PointerContext)_localctx).c.add(((PointerContext)_localctx).Const);
					}
					}
					setState(485);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				stars++; constCounts.add(((PointerContext)_localctx).c.size());
				}
				}
				}
				setState(489); 
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
		enterRule(_localctx, 40, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((ParameterListContext)_localctx).list =  new ArrayList<>();
			setState(494);
			((ParameterListContext)_localctx).p = parameterDeclaration();
			_localctx.list.add(((ParameterListContext)_localctx).p.paramRet);
			setState(502);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(496);
				match(Comma);
				setState(497);
				((ParameterListContext)_localctx).p2 = parameterDeclaration();
				_localctx.list.add(((ParameterListContext)_localctx).p2.paramRet);
				}
				}
				setState(504);
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
		enterRule(_localctx, 42, RULE_parameterDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(505);
			((ParameterDeclarationContext)_localctx).ds = declarationSpecifiers();
			((ParameterDeclarationContext)_localctx).paramRet =  new Parameter(((ParameterDeclarationContext)_localctx).ds.list);
			setState(515);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				setState(507);
				((ParameterDeclarationContext)_localctx).d = declarator();
				_localctx.paramRet.setDeclarator(((ParameterDeclarationContext)_localctx).d.declaratorRet);
				}
				break;
			case 2:
				{
				setState(513);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 549797756928L) != 0)) {
					{
					setState(510);
					((ParameterDeclarationContext)_localctx).d2 = abstractDeclarator();
					_localctx.paramRet.setDeclarator(((ParameterDeclarationContext)_localctx).d2.declaratorRet);
					}
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
		enterRule(_localctx, 44, RULE_identifierList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((IdentifierListContext)_localctx).list =  new ArrayList<>();
			setState(518);
			((IdentifierListContext)_localctx).id = match(Identifier);
			_localctx.list.add(new Identifier((((IdentifierListContext)_localctx).id!=null?((IdentifierListContext)_localctx).id.getText():null), ((IdentifierListContext)_localctx).id.getLine()));
			setState(525);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(520);
				match(Comma);
				setState(521);
				((IdentifierListContext)_localctx).id2 = match(Identifier);
				_localctx.list.add(new Identifier((((IdentifierListContext)_localctx).id!=null?((IdentifierListContext)_localctx).id.getText():null), ((IdentifierListContext)_localctx).id.getLine()));
				}
				}
				setState(527);
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
		enterRule(_localctx, 46, RULE_typeName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((TypeNameContext)_localctx).typeRet =  new Typename();
			setState(529);
			((TypeNameContext)_localctx).spl = specifierQualifierList();
			_localctx.typeRet.setTypes(((TypeNameContext)_localctx).spl.list);
			setState(534);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 549797756928L) != 0)) {
				{
				setState(531);
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
		enterRule(_localctx, 48, RULE_abstractDeclarator);
		((AbstractDeclaratorContext)_localctx).declaratorRet =  new Declarator();
		int _la;
		try {
			setState(547);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(536);
				((AbstractDeclaratorContext)_localctx).p = pointer();
				_localctx.declaratorRet.setPointer(((AbstractDeclaratorContext)_localctx).p.ptrRet);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(542);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Star) {
					{
					setState(539);
					((AbstractDeclaratorContext)_localctx).p = pointer();
					_localctx.declaratorRet.setPointer(((AbstractDeclaratorContext)_localctx).p.ptrRet);
					}
				}

				setState(544);
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
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_directAbstractDeclarator, _p);
		((DirectAbstractDeclaratorContext)_localctx).ddRet =  new DirectDeclarator();
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(567);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftBracket:
				{
				setState(550);
				match(LeftBracket);
				setState(552);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 247697986031190145L) != 0)) {
					{
					setState(551);
					expression(0);
					}
				}

				setState(554);
				match(RightBracket);
				_localctx.ddRet.addArrExpr(((DirectAbstractDeclaratorContext)_localctx).exp.expRet);
				}
				break;
			case LeftParen:
				{
				setState(556);
				match(LeftParen);
				setState(564);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LeftParen:
				case LeftBracket:
				case Star:
					{
					setState(557);
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
					setState(561);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6084940L) != 0) || _la==Identifier) {
						{
						setState(560);
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
				setState(566);
				match(RightParen);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(587);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(585);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
					case 1:
						{
						_localctx = new DirectAbstractDeclaratorContext(_parentctx, _parentState);
						_localctx.dd = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_directAbstractDeclarator);
						setState(569);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						((DirectAbstractDeclaratorContext)_localctx).ddRet =  ((DirectAbstractDeclaratorContext)_localctx).dd.ddRet;
						setState(571);
						match(LeftBracket);
						setState(573);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 247697986031190145L) != 0)) {
							{
							setState(572);
							((DirectAbstractDeclaratorContext)_localctx).exp = expression(0);
							}
						}

						setState(575);
						match(RightBracket);
						_localctx.ddRet.addArrExpr(((DirectAbstractDeclaratorContext)_localctx).exp.expRet);
						}
						break;
					case 2:
						{
						_localctx = new DirectAbstractDeclaratorContext(_parentctx, _parentState);
						_localctx.dd = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_directAbstractDeclarator);
						setState(577);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						((DirectAbstractDeclaratorContext)_localctx).ddRet =  ((DirectAbstractDeclaratorContext)_localctx).dd.ddRet;
						setState(579);
						match(LeftParen);
						setState(581);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6084940L) != 0) || _la==Identifier) {
							{
							setState(580);
							((DirectAbstractDeclaratorContext)_localctx).pl = parameterList();
							}
						}

						setState(583);
						match(RightParen);
						_localctx.ddRet.addFuncParams(((DirectAbstractDeclaratorContext)_localctx).pl.list);
						}
						break;
					}
					} 
				}
				setState(589);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
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
		enterRule(_localctx, 52, RULE_initializer);
		((InitializerContext)_localctx).iniRet =  new Initializer();
		int _la;
		try {
			setState(601);
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
				setState(590);
				((InitializerContext)_localctx).exp = expression(0);
				_localctx.iniRet.setExpr(((InitializerContext)_localctx).exp.expRet);
				}
				break;
			case LeftBrace:
				enterOuterAlt(_localctx, 2);
				{
				setState(593);
				match(LeftBrace);
				setState(594);
				((InitializerContext)_localctx).i = initializerList();
				_localctx.iniRet.setInitializerlist(((InitializerContext)_localctx).i.list);
				setState(597);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(596);
					match(Comma);
					}
				}

				setState(599);
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
		enterRule(_localctx, 54, RULE_initializerList);
		((InitializerListContext)_localctx).list =  new InitializerList();
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(604);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LeftBracket || _la==Dot) {
				{
				setState(603);
				((InitializerListContext)_localctx).d = designation();
				}
			}

			setState(606);
			((InitializerListContext)_localctx).i = initializer();
			_localctx.list.add(((InitializerListContext)_localctx).d!=null? ((InitializerListContext)_localctx).d.dRet : null, ((InitializerListContext)_localctx).i.iniRet);
			setState(617);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(608);
					match(Comma);
					setState(610);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==LeftBracket || _la==Dot) {
						{
						setState(609);
						((InitializerListContext)_localctx).d2 = designation();
						}
					}

					setState(612);
					((InitializerListContext)_localctx).i2 = initializer();
					_localctx.list.add(((InitializerListContext)_localctx).d2!=null? ((InitializerListContext)_localctx).d2.dRet : null, ((InitializerListContext)_localctx).i2.iniRet);
					}
					} 
				}
				setState(619);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
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
		enterRule(_localctx, 56, RULE_designation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((DesignationContext)_localctx).dRet =  new Designation();
			setState(624); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(621);
				((DesignationContext)_localctx).d = designator();
				_localctx.dRet.addDesignator(((DesignationContext)_localctx).d.dRet);
				}
				}
				setState(626); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==LeftBracket || _la==Dot );
			setState(628);
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
		enterRule(_localctx, 58, RULE_designator);
		((DesignatorContext)_localctx).dRet =  new Designator(); 
		try {
			setState(638);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftBracket:
				enterOuterAlt(_localctx, 1);
				{
				setState(630);
				match(LeftBracket);
				setState(631);
				((DesignatorContext)_localctx).exp = expression(0);
				_localctx.dRet.setExpr(((DesignatorContext)_localctx).exp.expRet);
				setState(633);
				match(RightBracket);
				}
				break;
			case Dot:
				enterOuterAlt(_localctx, 2);
				{
				setState(635);
				match(Dot);
				setState(636);
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
		enterRule(_localctx, 60, RULE_statement);
		try {
			setState(655);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftBrace:
				enterOuterAlt(_localctx, 1);
				{
				setState(640);
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
				setState(643);
				((StatementContext)_localctx).e = expressionStatement();
				((StatementContext)_localctx).stRet =  ((StatementContext)_localctx).e.stRet;_localctx.stRet.setLine(_localctx.start.getLine());
				}
				break;
			case If:
				enterOuterAlt(_localctx, 3);
				{
				setState(646);
				((StatementContext)_localctx).s = selectionStatement();
				((StatementContext)_localctx).stRet =  ((StatementContext)_localctx).s.stRet; _localctx.stRet.setLine(_localctx.start.getLine());
				}
				break;
			case Do:
			case For:
			case While:
				enterOuterAlt(_localctx, 4);
				{
				setState(649);
				((StatementContext)_localctx).i = iterationStatement();
				((StatementContext)_localctx).stRet =  ((StatementContext)_localctx).i.stRet; _localctx.stRet.setLine(_localctx.start.getLine());
				}
				break;
			case Break:
			case Continue:
			case Return:
				enterOuterAlt(_localctx, 5);
				{
				setState(652);
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
		enterRule(_localctx, 62, RULE_compoundStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((CompoundStatementContext)_localctx).cstmtRet =  new CompoundStatement(); _localctx.cstmtRet.setLine(_localctx.start.getLine());
			setState(658);
			match(LeftBrace);
			setState(664);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2679475628015486L) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & 55L) != 0)) {
				{
				{
				setState(659);
				((CompoundStatementContext)_localctx).b = blockItem();
				_localctx.cstmtRet.addBlockItem(((CompoundStatementContext)_localctx).b.blockRet);
				}
				}
				setState(666);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(667);
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
		enterRule(_localctx, 64, RULE_blockItem);
		try {
			setState(675);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(669);
				((BlockItemContext)_localctx).st = statement();
				((BlockItemContext)_localctx).blockRet =  new BlockItem(((BlockItemContext)_localctx).st.stRet);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(672);
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
		public ExpressionContext exp;
		public TerminalNode Semi() { return getToken(SimpleLangParser.Semi, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
		enterRule(_localctx, 66, RULE_expressionStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(680);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 247697986031190145L) != 0)) {
				{
				setState(677);
				((ExpressionStatementContext)_localctx).exp = expression(0);
				((ExpressionStatementContext)_localctx).stRet =  new ExpressionStatement(((ExpressionStatementContext)_localctx).exp.expRet);
				}
			}

			setState(682);
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
		public ExpressionContext exp;
		public StatementContext ifst;
		public StatementContext elsest;
		public TerminalNode If() { return getToken(SimpleLangParser.If, 0); }
		public TerminalNode LeftParen() { return getToken(SimpleLangParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(SimpleLangParser.RightParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
		enterRule(_localctx, 68, RULE_selectionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(684);
			match(If);
			setState(685);
			match(LeftParen);
			setState(686);
			((SelectionStatementContext)_localctx).exp = expression(0);
			setState(687);
			match(RightParen);
			setState(688);
			((SelectionStatementContext)_localctx).ifst = statement();
			((SelectionStatementContext)_localctx).stRet =  new SelectionStatement(((SelectionStatementContext)_localctx).exp.expRet, ((SelectionStatementContext)_localctx).ifst.stRet);
			setState(694);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				{
				setState(690);
				match(Else);
				setState(691);
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
		public ExpressionContext e;
		public StatementContext s;
		public ForConditionContext f;
		public TerminalNode While() { return getToken(SimpleLangParser.While, 0); }
		public TerminalNode LeftParen() { return getToken(SimpleLangParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(SimpleLangParser.RightParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
		enterRule(_localctx, 70, RULE_iterationStatement);
		try {
			setState(719);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case While:
				enterOuterAlt(_localctx, 1);
				{
				setState(696);
				match(While);
				setState(697);
				match(LeftParen);
				setState(698);
				((IterationStatementContext)_localctx).e = expression(0);
				setState(699);
				match(RightParen);
				setState(700);
				((IterationStatementContext)_localctx).s = statement();
				((IterationStatementContext)_localctx).stRet =  new WhileStatement(((IterationStatementContext)_localctx).e.expRet, ((IterationStatementContext)_localctx).s.stRet);
				}
				break;
			case Do:
				enterOuterAlt(_localctx, 2);
				{
				setState(703);
				match(Do);
				setState(704);
				((IterationStatementContext)_localctx).s = statement();
				setState(705);
				match(While);
				setState(706);
				match(LeftParen);
				setState(707);
				((IterationStatementContext)_localctx).e = expression(0);
				setState(708);
				match(RightParen);
				setState(709);
				match(Semi);
				((IterationStatementContext)_localctx).stRet =  new DoWhileStatement(((IterationStatementContext)_localctx).s.stRet, ((IterationStatementContext)_localctx).e.expRet);
				}
				break;
			case For:
				enterOuterAlt(_localctx, 3);
				{
				setState(712);
				match(For);
				setState(713);
				match(LeftParen);
				setState(714);
				((IterationStatementContext)_localctx).f = forCondition();
				setState(715);
				match(RightParen);
				setState(716);
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
		public ExpressionContext e;
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
		enterRule(_localctx, 72, RULE_forCondition);
		((ForConditionContext)_localctx).forconRet =  new ForCondition();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(729);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
			case 1:
				{
				setState(721);
				((ForConditionContext)_localctx).fd = forDeclaration();
				_localctx.forconRet.setDeclaration(((ForConditionContext)_localctx).fd.forRet);
				}
				break;
			case 2:
				{
				setState(727);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 247697986031190145L) != 0)) {
					{
					setState(724);
					((ForConditionContext)_localctx).e = expression(0);
					_localctx.forconRet.setExpr(((ForConditionContext)_localctx).e.expRet);
					}
				}

				}
				break;
			}
			setState(731);
			match(Semi);
			setState(735);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 247697986031190145L) != 0)) {
				{
				setState(732);
				((ForConditionContext)_localctx).f1 = forExpression();
				_localctx.forconRet.setConditions(((ForConditionContext)_localctx).f1.list);
				}
			}

			setState(737);
			match(Semi);
			setState(741);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 247697986031190145L) != 0)) {
				{
				setState(738);
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
		enterRule(_localctx, 74, RULE_forDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(743);
			((ForDeclarationContext)_localctx).d = declarationSpecifiers();
			((ForDeclarationContext)_localctx).forRet =  new Declaration(((ForDeclarationContext)_localctx).d.list);
			setState(748);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & 35184372154369L) != 0)) {
				{
				setState(745);
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
		enterRule(_localctx, 76, RULE_forExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((ForExpressionContext)_localctx).list =  new ArrayList<>();
			setState(751);
			((ForExpressionContext)_localctx).e = expression(0);
			_localctx.list.add(((ForExpressionContext)_localctx).e.expRet);
			setState(759);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(753);
				match(Comma);
				setState(754);
				((ForExpressionContext)_localctx).e2 = expression(0);
				_localctx.list.add(((ForExpressionContext)_localctx).e2.expRet);
				}
				}
				setState(761);
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
		enterRule(_localctx, 78, RULE_jumpStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(773);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Continue:
				{
				setState(762);
				match(Continue);
				((JumpStatementContext)_localctx).stRet =  new ContinueStatement();
				}
				break;
			case Break:
				{
				setState(764);
				match(Break);
				((JumpStatementContext)_localctx).stRet =  new BreakStatement();
				}
				break;
			case Return:
				{
				setState(766);
				match(Return);
				((JumpStatementContext)_localctx).stRet =  new ReturnStatement();
				setState(771);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 247697986031190145L) != 0)) {
					{
					setState(768);
					((JumpStatementContext)_localctx).e = expression(0);
					((ReturnStatement)_localctx.stRet).setExpr(((JumpStatementContext)_localctx).e.expRet);
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(775);
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
		enterRule(_localctx, 80, RULE_constant);
		try {
			setState(783);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IntegerConstant:
				enterOuterAlt(_localctx, 1);
				{
				setState(777);
				((ConstantContext)_localctx).i = match(IntegerConstant);
				 ((ConstantContext)_localctx).cret =  new IntVal((((ConstantContext)_localctx).i!=null?((ConstantContext)_localctx).i.getText():null)); 
				}
				break;
			case FloatingConstant:
				enterOuterAlt(_localctx, 2);
				{
				setState(779);
				((ConstantContext)_localctx).f = match(FloatingConstant);
				 ((ConstantContext)_localctx).cret =  new FloatVal((((ConstantContext)_localctx).f!=null?((ConstantContext)_localctx).f.getText():null)); 
				}
				break;
			case CharacterConstant:
				enterOuterAlt(_localctx, 3);
				{
				setState(781);
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
		case 5:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 18:
			return directDeclarator_sempred((DirectDeclaratorContext)_localctx, predIndex);
		case 25:
			return directAbstractDeclarator_sempred((DirectAbstractDeclaratorContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 13);
		case 1:
			return precpred(_ctx, 12);
		case 2:
			return precpred(_ctx, 11);
		case 3:
			return precpred(_ctx, 10);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 8);
		case 6:
			return precpred(_ctx, 7);
		case 7:
			return precpred(_ctx, 6);
		case 8:
			return precpred(_ctx, 5);
		case 9:
			return precpred(_ctx, 4);
		case 10:
			return precpred(_ctx, 3);
		case 11:
			return precpred(_ctx, 2);
		case 12:
			return precpred(_ctx, 19);
		case 13:
			return precpred(_ctx, 18);
		case 14:
			return precpred(_ctx, 17);
		case 15:
			return precpred(_ctx, 16);
		case 16:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean directDeclarator_sempred(DirectDeclaratorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 17:
			return precpred(_ctx, 2);
		case 18:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean directAbstractDeclarator_sempred(DirectAbstractDeclaratorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 19:
			return precpred(_ctx, 2);
		case 20:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001O\u0312\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"(\u0007(\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0003"+
		"\u0000X\b\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0004\u0001`\b\u0001\u000b\u0001\f\u0001a\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002l\b\u0002\u0001\u0003\u0003\u0003o\b\u0003\u0001"+
		"\u0003\u0001\u0003\u0003\u0003s\b\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0004\u0004|\b"+
		"\u0004\u000b\u0004\f\u0004}\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0004"+
		"\u0005\u0089\b\u0005\u000b\u0005\f\u0005\u008a\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u0099\b\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0005\u0005\u00a1\b\u0005\n\u0005\f\u0005\u00a4\t\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0004\u0005\u00ae\b\u0005\u000b\u0005\f\u0005\u00af\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"\u00be\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u0005\u00cd\b\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"\u00d6\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0003\u0005\u011f\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0004\u0005\u012c\b\u0005\u000b\u0005\f\u0005\u012d\u0001"+
		"\u0005\u0001\u0005\u0005\u0005\u0132\b\u0005\n\u0005\f\u0005\u0135\t\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0005\u0006\u013e\b\u0006\n\u0006\f\u0006\u0141\t\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007\u014f\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u015c\b\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0003\n\u0163\b\n\u0001\n\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0004\u000b\u016c\b\u000b\u000b\u000b"+
		"\f\u000b\u016d\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0003\f\u0177\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0005\r\u0180\b\r\n\r\f\r\u0183\t\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u018b\b\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u01a3\b\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u01aa\b\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u01af\b\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u01b5\b\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u01c2\b\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u01c8\b\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012"+
		"\u01d5\b\u0012\u0003\u0012\u01d7\b\u0012\u0001\u0012\u0005\u0012\u01da"+
		"\b\u0012\n\u0012\f\u0012\u01dd\t\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0005\u0013\u01e2\b\u0013\n\u0013\f\u0013\u01e5\t\u0013\u0001\u0013\u0004"+
		"\u0013\u01e8\b\u0013\u000b\u0013\f\u0013\u01e9\u0001\u0013\u0001\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0005\u0014\u01f5\b\u0014\n\u0014\f\u0014\u01f8\t\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0003\u0015\u0202\b\u0015\u0003\u0015\u0204\b\u0015"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0005\u0016\u020c\b\u0016\n\u0016\f\u0016\u020f\t\u0016\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u0217"+
		"\b\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0003\u0018\u021f\b\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0003"+
		"\u0018\u0224\b\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u0229"+
		"\b\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0003\u0019\u0232\b\u0019\u0001\u0019\u0003\u0019\u0235"+
		"\b\u0019\u0001\u0019\u0003\u0019\u0238\b\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0003\u0019\u023e\b\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u0246\b\u0019"+
		"\u0001\u0019\u0001\u0019\u0005\u0019\u024a\b\u0019\n\u0019\f\u0019\u024d"+
		"\t\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0003\u001a\u0256\b\u001a\u0001\u001a\u0001\u001a\u0003"+
		"\u001a\u025a\b\u001a\u0001\u001b\u0003\u001b\u025d\b\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u0263\b\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0005\u001b\u0268\b\u001b\n\u001b\f\u001b\u026b"+
		"\t\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0004\u001c\u0271"+
		"\b\u001c\u000b\u001c\f\u001c\u0272\u0001\u001c\u0001\u001c\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0003\u001d\u027f\b\u001d\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0003\u001e\u0290\b\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0005\u001f\u0297\b\u001f\n\u001f\f\u001f\u029a\t\u001f\u0001"+
		"\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0003 \u02a4"+
		"\b \u0001!\u0001!\u0001!\u0003!\u02a9\b!\u0001!\u0001!\u0001\"\u0001\""+
		"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0003"+
		"\"\u02b7\b\"\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001"+
		"#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001"+
		"#\u0001#\u0001#\u0001#\u0001#\u0003#\u02d0\b#\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0003$\u02d8\b$\u0003$\u02da\b$\u0001$\u0001$\u0001$\u0001"+
		"$\u0003$\u02e0\b$\u0001$\u0001$\u0001$\u0001$\u0003$\u02e6\b$\u0001%\u0001"+
		"%\u0001%\u0001%\u0001%\u0003%\u02ed\b%\u0001&\u0001&\u0001&\u0001&\u0001"+
		"&\u0001&\u0001&\u0005&\u02f6\b&\n&\f&\u02f9\t&\u0001\'\u0001\'\u0001\'"+
		"\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0003\'\u0304\b\'\u0003"+
		"\'\u0306\b\'\u0001\'\u0001\'\u0001(\u0001(\u0001(\u0001(\u0001(\u0001"+
		"(\u0003(\u0310\b(\u0001(\u0000\u0003\n$2)\u0000\u0002\u0004\u0006\b\n"+
		"\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.0246"+
		"8:<>@BDFHJLNP\u0000\u0007\u0003\u0000\u0010\u0010$$&&\u0001\u0000\')\u0002"+
		"\u0000##%%\u0001\u0000!\"\u0001\u0000\u001d \u0001\u0000@A\u0001\u0000"+
		"5?\u0361\u0000R\u0001\u0000\u0000\u0000\u0002[\u0001\u0000\u0000\u0000"+
		"\u0004k\u0001\u0000\u0000\u0000\u0006n\u0001\u0000\u0000\u0000\bw\u0001"+
		"\u0000\u0000\u0000\n\u00d5\u0001\u0000\u0000\u0000\f\u0136\u0001\u0000"+
		"\u0000\u0000\u000e\u014e\u0001\u0000\u0000\u0000\u0010\u015b\u0001\u0000"+
		"\u0000\u0000\u0012\u015d\u0001\u0000\u0000\u0000\u0014\u0160\u0001\u0000"+
		"\u0000\u0000\u0016\u0167\u0001\u0000\u0000\u0000\u0018\u0176\u0001\u0000"+
		"\u0000\u0000\u001a\u0178\u0001\u0000\u0000\u0000\u001c\u0184\u0001\u0000"+
		"\u0000\u0000\u001e\u01a2\u0001\u0000\u0000\u0000 \u01a9\u0001\u0000\u0000"+
		"\u0000\"\u01b0\u0001\u0000\u0000\u0000$\u01c1\u0001\u0000\u0000\u0000"+
		"&\u01de\u0001\u0000\u0000\u0000(\u01ed\u0001\u0000\u0000\u0000*\u01f9"+
		"\u0001\u0000\u0000\u0000,\u0205\u0001\u0000\u0000\u0000.\u0210\u0001\u0000"+
		"\u0000\u00000\u0223\u0001\u0000\u0000\u00002\u0237\u0001\u0000\u0000\u0000"+
		"4\u0259\u0001\u0000\u0000\u00006\u025c\u0001\u0000\u0000\u00008\u026c"+
		"\u0001\u0000\u0000\u0000:\u027e\u0001\u0000\u0000\u0000<\u028f\u0001\u0000"+
		"\u0000\u0000>\u0291\u0001\u0000\u0000\u0000@\u02a3\u0001\u0000\u0000\u0000"+
		"B\u02a8\u0001\u0000\u0000\u0000D\u02ac\u0001\u0000\u0000\u0000F\u02cf"+
		"\u0001\u0000\u0000\u0000H\u02d9\u0001\u0000\u0000\u0000J\u02e7\u0001\u0000"+
		"\u0000\u0000L\u02ee\u0001\u0000\u0000\u0000N\u0305\u0001\u0000\u0000\u0000"+
		"P\u030f\u0001\u0000\u0000\u0000RS\u0006\u0000\uffff\uffff\u0000SW\u0006"+
		"\u0000\uffff\uffff\u0000TU\u0003\u0002\u0001\u0000UV\u0006\u0000\uffff"+
		"\uffff\u0000VX\u0001\u0000\u0000\u0000WT\u0001\u0000\u0000\u0000WX\u0001"+
		"\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000YZ\u0005\u0000\u0000\u0001"+
		"Z\u0001\u0001\u0000\u0000\u0000[_\u0006\u0001\uffff\uffff\u0000\\]\u0003"+
		"\u0004\u0002\u0000]^\u0006\u0001\uffff\uffff\u0000^`\u0001\u0000\u0000"+
		"\u0000_\\\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000a_\u0001\u0000"+
		"\u0000\u0000ab\u0001\u0000\u0000\u0000b\u0003\u0001\u0000\u0000\u0000"+
		"cd\u0003\u0006\u0003\u0000de\u0006\u0002\uffff\uffff\u0000el\u0001\u0000"+
		"\u0000\u0000fg\u0003\u0014\n\u0000gh\u0006\u0002\uffff\uffff\u0000hl\u0001"+
		"\u0000\u0000\u0000ij\u00053\u0000\u0000jl\u0006\u0002\uffff\uffff\u0000"+
		"kc\u0001\u0000\u0000\u0000kf\u0001\u0000\u0000\u0000ki\u0001\u0000\u0000"+
		"\u0000l\u0005\u0001\u0000\u0000\u0000mo\u0003\u0016\u000b\u0000nm\u0001"+
		"\u0000\u0000\u0000no\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000"+
		"pr\u0003\"\u0011\u0000qs\u0003\b\u0004\u0000rq\u0001\u0000\u0000\u0000"+
		"rs\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000tu\u0003>\u001f\u0000"+
		"uv\u0006\u0003\uffff\uffff\u0000v\u0007\u0001\u0000\u0000\u0000w{\u0006"+
		"\u0004\uffff\uffff\u0000xy\u0003\u0014\n\u0000yz\u0006\u0004\uffff\uffff"+
		"\u0000z|\u0001\u0000\u0000\u0000{x\u0001\u0000\u0000\u0000|}\u0001\u0000"+
		"\u0000\u0000}{\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~\t\u0001"+
		"\u0000\u0000\u0000\u007f\u0080\u0006\u0005\uffff\uffff\u0000\u0080\u0081"+
		"\u0005D\u0000\u0000\u0081\u00d6\u0006\u0005\uffff\uffff\u0000\u0082\u0083"+
		"\u0003P(\u0000\u0083\u0084\u0006\u0005\uffff\uffff\u0000\u0084\u00d6\u0001"+
		"\u0000\u0000\u0000\u0085\u0088\u0006\u0005\uffff\uffff\u0000\u0086\u0087"+
		"\u0005I\u0000\u0000\u0087\u0089\u0006\u0005\uffff\uffff\u0000\u0088\u0086"+
		"\u0001\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u0088"+
		"\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u008c"+
		"\u0001\u0000\u0000\u0000\u008c\u00d6\u0006\u0005\uffff\uffff\u0000\u008d"+
		"\u008e\u0005\u0017\u0000\u0000\u008e\u008f\u0003\n\u0005\u0000\u008f\u0090"+
		"\u0005\u0018\u0000\u0000\u0090\u0091\u0006\u0005\uffff\uffff\u0000\u0091"+
		"\u00d6\u0001\u0000\u0000\u0000\u0092\u0093\u0005\u0017\u0000\u0000\u0093"+
		"\u0094\u0003.\u0017\u0000\u0094\u0095\u0005\u0018\u0000\u0000\u0095\u0096"+
		"\u0005\u001b\u0000\u0000\u0096\u0098\u00036\u001b\u0000\u0097\u0099\u0005"+
		"4\u0000\u0000\u0098\u0097\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000"+
		"\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a\u009b\u0005\u001c"+
		"\u0000\u0000\u009b\u009c\u0006\u0005\uffff\uffff\u0000\u009c\u00d6\u0001"+
		"\u0000\u0000\u0000\u009d\u00a2\u0006\u0005\uffff\uffff\u0000\u009e\u009f"+
		"\u0007\u0000\u0000\u0000\u009f\u00a1\u0006\u0005\uffff\uffff\u0000\u00a0"+
		"\u009e\u0001\u0000\u0000\u0000\u00a1\u00a4\u0001\u0000\u0000\u0000\u00a2"+
		"\u00a0\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3"+
		"\u00cc\u0001\u0000\u0000\u0000\u00a4\u00a2\u0001\u0000\u0000\u0000\u00a5"+
		"\u00a6\u0005D\u0000\u0000\u00a6\u00cd\u0006\u0005\uffff\uffff\u0000\u00a7"+
		"\u00a8\u0003P(\u0000\u00a8\u00a9\u0006\u0005\uffff\uffff\u0000\u00a9\u00cd"+
		"\u0001\u0000\u0000\u0000\u00aa\u00ad\u0006\u0005\uffff\uffff\u0000\u00ab"+
		"\u00ac\u0005I\u0000\u0000\u00ac\u00ae\u0006\u0005\uffff\uffff\u0000\u00ad"+
		"\u00ab\u0001\u0000\u0000\u0000\u00ae\u00af\u0001\u0000\u0000\u0000\u00af"+
		"\u00ad\u0001\u0000\u0000\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0"+
		"\u00b1\u0001\u0000\u0000\u0000\u00b1\u00cd\u0006\u0005\uffff\uffff\u0000"+
		"\u00b2\u00b3\u0005\u0017\u0000\u0000\u00b3\u00b4\u0003\n\u0005\u0000\u00b4"+
		"\u00b5\u0005\u0018\u0000\u0000\u00b5\u00b6\u0006\u0005\uffff\uffff\u0000"+
		"\u00b6\u00cd\u0001\u0000\u0000\u0000\u00b7\u00b8\u0005\u0017\u0000\u0000"+
		"\u00b8\u00b9\u0003.\u0017\u0000\u00b9\u00ba\u0005\u0018\u0000\u0000\u00ba"+
		"\u00bb\u0005\u001b\u0000\u0000\u00bb\u00bd\u00036\u001b\u0000\u00bc\u00be"+
		"\u00054\u0000\u0000\u00bd\u00bc\u0001\u0000\u0000\u0000\u00bd\u00be\u0001"+
		"\u0000\u0000\u0000\u00be\u00bf\u0001\u0000\u0000\u0000\u00bf\u00c0\u0005"+
		"\u001c\u0000\u0000\u00c0\u00c1\u0006\u0005\uffff\uffff\u0000\u00c1\u00cd"+
		"\u0001\u0000\u0000\u0000\u00c2\u00c3\u0003\u000e\u0007\u0000\u00c3\u00c4"+
		"\u0003\u0010\b\u0000\u00c4\u00c5\u0006\u0005\uffff\uffff\u0000\u00c5\u00cd"+
		"\u0001\u0000\u0000\u0000\u00c6\u00c7\u0005\u0010\u0000\u0000\u00c7\u00c8"+
		"\u0005\u0017\u0000\u0000\u00c8\u00c9\u0003.\u0017\u0000\u00c9\u00ca\u0005"+
		"\u0018\u0000\u0000\u00ca\u00cb\u0006\u0005\uffff\uffff\u0000\u00cb\u00cd"+
		"\u0001\u0000\u0000\u0000\u00cc\u00a5\u0001\u0000\u0000\u0000\u00cc\u00a7"+
		"\u0001\u0000\u0000\u0000\u00cc\u00aa\u0001\u0000\u0000\u0000\u00cc\u00b2"+
		"\u0001\u0000\u0000\u0000\u00cc\u00b7\u0001\u0000\u0000\u0000\u00cc\u00c2"+
		"\u0001\u0000\u0000\u0000\u00cc\u00c6\u0001\u0000\u0000\u0000\u00cd\u00ce"+
		"\u0001\u0000\u0000\u0000\u00ce\u00d6\u0006\u0005\uffff\uffff\u0000\u00cf"+
		"\u00d0\u0005\u0017\u0000\u0000\u00d0\u00d1\u0003.\u0017\u0000\u00d1\u00d2"+
		"\u0005\u0018\u0000\u0000\u00d2\u00d3\u0003\u0010\b\u0000\u00d3\u00d4\u0006"+
		"\u0005\uffff\uffff\u0000\u00d4\u00d6\u0001\u0000\u0000\u0000\u00d5\u007f"+
		"\u0001\u0000\u0000\u0000\u00d5\u0082\u0001\u0000\u0000\u0000\u00d5\u0085"+
		"\u0001\u0000\u0000\u0000\u00d5\u008d\u0001\u0000\u0000\u0000\u00d5\u0092"+
		"\u0001\u0000\u0000\u0000\u00d5\u009d\u0001\u0000\u0000\u0000\u00d5\u00cf"+
		"\u0001\u0000\u0000\u0000\u00d6\u0133\u0001\u0000\u0000\u0000\u00d7\u00d8"+
		"\n\r\u0000\u0000\u00d8\u00d9\u0007\u0001\u0000\u0000\u00d9\u00da\u0003"+
		"\n\u0005\u000e\u00da\u00db\u0006\u0005\uffff\uffff\u0000\u00db\u0132\u0001"+
		"\u0000\u0000\u0000\u00dc\u00dd\n\f\u0000\u0000\u00dd\u00de\u0007\u0002"+
		"\u0000\u0000\u00de\u00df\u0003\n\u0005\r\u00df\u00e0\u0006\u0005\uffff"+
		"\uffff\u0000\u00e0\u0132\u0001\u0000\u0000\u0000\u00e1\u00e2\n\u000b\u0000"+
		"\u0000\u00e2\u00e3\u0007\u0003\u0000\u0000\u00e3\u00e4\u0003\n\u0005\f"+
		"\u00e4\u00e5\u0006\u0005\uffff\uffff\u0000\u00e5\u0132\u0001\u0000\u0000"+
		"\u0000\u00e6\u00e7\n\n\u0000\u0000\u00e7\u00e8\u0007\u0004\u0000\u0000"+
		"\u00e8\u00e9\u0003\n\u0005\u000b\u00e9\u00ea\u0006\u0005\uffff\uffff\u0000"+
		"\u00ea\u0132\u0001\u0000\u0000\u0000\u00eb\u00ec\n\t\u0000\u0000\u00ec"+
		"\u00ed\u0007\u0005\u0000\u0000\u00ed\u00ee\u0003\n\u0005\n\u00ee\u00ef"+
		"\u0006\u0005\uffff\uffff\u0000\u00ef\u0132\u0001\u0000\u0000\u0000\u00f0"+
		"\u00f1\n\b\u0000\u0000\u00f1\u00f2\u0005*\u0000\u0000\u00f2\u00f3\u0003"+
		"\n\u0005\t\u00f3\u00f4\u0006\u0005\uffff\uffff\u0000\u00f4\u0132\u0001"+
		"\u0000\u0000\u0000\u00f5\u00f6\n\u0007\u0000\u0000\u00f6\u00f7\u0005."+
		"\u0000\u0000\u00f7\u00f8\u0003\n\u0005\b\u00f8\u00f9\u0006\u0005\uffff"+
		"\uffff\u0000\u00f9\u0132\u0001\u0000\u0000\u0000\u00fa\u00fb\n\u0006\u0000"+
		"\u0000\u00fb\u00fc\u0005+\u0000\u0000\u00fc\u00fd\u0003\n\u0005\u0007"+
		"\u00fd\u00fe\u0006\u0005\uffff\uffff\u0000\u00fe\u0132\u0001\u0000\u0000"+
		"\u0000\u00ff\u0100\n\u0005\u0000\u0000\u0100\u0101\u0005,\u0000\u0000"+
		"\u0101\u0102\u0003\n\u0005\u0006\u0102\u0103\u0006\u0005\uffff\uffff\u0000"+
		"\u0103\u0132\u0001\u0000\u0000\u0000\u0104\u0105\n\u0004\u0000\u0000\u0105"+
		"\u0106\u0005-\u0000\u0000\u0106\u0107\u0003\n\u0005\u0005\u0107\u0108"+
		"\u0006\u0005\uffff\uffff\u0000\u0108\u0132\u0001\u0000\u0000\u0000\u0109"+
		"\u010a\n\u0003\u0000\u0000\u010a\u010b\u00051\u0000\u0000\u010b\u010c"+
		"\u0003\n\u0005\u0000\u010c\u010d\u00052\u0000\u0000\u010d\u010e\u0003"+
		"\n\u0005\u0004\u010e\u010f\u0006\u0005\uffff\uffff\u0000\u010f\u0132\u0001"+
		"\u0000\u0000\u0000\u0110\u0111\n\u0002\u0000\u0000\u0111\u0112\u0003\u0012"+
		"\t\u0000\u0112\u0113\u0003\n\u0005\u0003\u0113\u0114\u0006\u0005\uffff"+
		"\uffff\u0000\u0114\u0132\u0001\u0000\u0000\u0000\u0115\u0116\n\u0013\u0000"+
		"\u0000\u0116\u0117\u0005\u0019\u0000\u0000\u0117\u0118\u0003\n\u0005\u0000"+
		"\u0118\u0119\u0005\u001a\u0000\u0000\u0119\u011a\u0006\u0005\uffff\uffff"+
		"\u0000\u011a\u0132\u0001\u0000\u0000\u0000\u011b\u011c\n\u0012\u0000\u0000"+
		"\u011c\u011e\u0005\u0017\u0000\u0000\u011d\u011f\u0003\f\u0006\u0000\u011e"+
		"\u011d\u0001\u0000\u0000\u0000\u011e\u011f\u0001\u0000\u0000\u0000\u011f"+
		"\u0120\u0001\u0000\u0000\u0000\u0120\u0121\u0005\u0018\u0000\u0000\u0121"+
		"\u0132\u0006\u0005\uffff\uffff\u0000\u0122\u0123\n\u0011\u0000\u0000\u0123"+
		"\u0124\u0005$\u0000\u0000\u0124\u0132\u0006\u0005\uffff\uffff\u0000\u0125"+
		"\u0126\n\u0010\u0000\u0000\u0126\u0127\u0005&\u0000\u0000\u0127\u0132"+
		"\u0006\u0005\uffff\uffff\u0000\u0128\u012b\n\u0001\u0000\u0000\u0129\u012a"+
		"\u00054\u0000\u0000\u012a\u012c\u0003\n\u0005\u0000\u012b\u0129\u0001"+
		"\u0000\u0000\u0000\u012c\u012d\u0001\u0000\u0000\u0000\u012d\u012b\u0001"+
		"\u0000\u0000\u0000\u012d\u012e\u0001\u0000\u0000\u0000\u012e\u012f\u0001"+
		"\u0000\u0000\u0000\u012f\u0130\u0006\u0005\uffff\uffff\u0000\u0130\u0132"+
		"\u0001\u0000\u0000\u0000\u0131\u00d7\u0001\u0000\u0000\u0000\u0131\u00dc"+
		"\u0001\u0000\u0000\u0000\u0131\u00e1\u0001\u0000\u0000\u0000\u0131\u00e6"+
		"\u0001\u0000\u0000\u0000\u0131\u00eb\u0001\u0000\u0000\u0000\u0131\u00f0"+
		"\u0001\u0000\u0000\u0000\u0131\u00f5\u0001\u0000\u0000\u0000\u0131\u00fa"+
		"\u0001\u0000\u0000\u0000\u0131\u00ff\u0001\u0000\u0000\u0000\u0131\u0104"+
		"\u0001\u0000\u0000\u0000\u0131\u0109\u0001\u0000\u0000\u0000\u0131\u0110"+
		"\u0001\u0000\u0000\u0000\u0131\u0115\u0001\u0000\u0000\u0000\u0131\u011b"+
		"\u0001\u0000\u0000\u0000\u0131\u0122\u0001\u0000\u0000\u0000\u0131\u0125"+
		"\u0001\u0000\u0000\u0000\u0131\u0128\u0001\u0000\u0000\u0000\u0132\u0135"+
		"\u0001\u0000\u0000\u0000\u0133\u0131\u0001\u0000\u0000\u0000\u0133\u0134"+
		"\u0001\u0000\u0000\u0000\u0134\u000b\u0001\u0000\u0000\u0000\u0135\u0133"+
		"\u0001\u0000\u0000\u0000\u0136\u0137\u0006\u0006\uffff\uffff\u0000\u0137"+
		"\u0138\u0003\n\u0005\u0000\u0138\u013f\u0006\u0006\uffff\uffff\u0000\u0139"+
		"\u013a\u00054\u0000\u0000\u013a\u013b\u0003\n\u0005\u0000\u013b\u013c"+
		"\u0006\u0006\uffff\uffff\u0000\u013c\u013e\u0001\u0000\u0000\u0000\u013d"+
		"\u0139\u0001\u0000\u0000\u0000\u013e\u0141\u0001\u0000\u0000\u0000\u013f"+
		"\u013d\u0001\u0000\u0000\u0000\u013f\u0140\u0001\u0000\u0000\u0000\u0140"+
		"\r\u0001\u0000\u0000\u0000\u0141\u013f\u0001\u0000\u0000\u0000\u0142\u0143"+
		"\u0005*\u0000\u0000\u0143\u014f\u0006\u0007\uffff\uffff\u0000\u0144\u0145"+
		"\u0005\'\u0000\u0000\u0145\u014f\u0006\u0007\uffff\uffff\u0000\u0146\u0147"+
		"\u0005#\u0000\u0000\u0147\u014f\u0006\u0007\uffff\uffff\u0000\u0148\u0149"+
		"\u0005%\u0000\u0000\u0149\u014f\u0006\u0007\uffff\uffff\u0000\u014a\u014b"+
		"\u00050\u0000\u0000\u014b\u014f\u0006\u0007\uffff\uffff\u0000\u014c\u014d"+
		"\u0005/\u0000\u0000\u014d\u014f\u0006\u0007\uffff\uffff\u0000\u014e\u0142"+
		"\u0001\u0000\u0000\u0000\u014e\u0144\u0001\u0000\u0000\u0000\u014e\u0146"+
		"\u0001\u0000\u0000\u0000\u014e\u0148\u0001\u0000\u0000\u0000\u014e\u014a"+
		"\u0001\u0000\u0000\u0000\u014e\u014c\u0001\u0000\u0000\u0000\u014f\u000f"+
		"\u0001\u0000\u0000\u0000\u0150\u0151\u0005\u0017\u0000\u0000\u0151\u0152"+
		"\u0003.\u0017\u0000\u0152\u0153\u0005\u0018\u0000\u0000\u0153\u0154\u0003"+
		"\u0010\b\u0000\u0154\u0155\u0006\b\uffff\uffff\u0000\u0155\u015c\u0001"+
		"\u0000\u0000\u0000\u0156\u0157\u0003\n\u0005\u0000\u0157\u0158\u0006\b"+
		"\uffff\uffff\u0000\u0158\u015c\u0001\u0000\u0000\u0000\u0159\u015a\u0005"+
		"G\u0000\u0000\u015a\u015c\u0006\b\uffff\uffff\u0000\u015b\u0150\u0001"+
		"\u0000\u0000\u0000\u015b\u0156\u0001\u0000\u0000\u0000\u015b\u0159\u0001"+
		"\u0000\u0000\u0000\u015c\u0011\u0001\u0000\u0000\u0000\u015d\u015e\u0007"+
		"\u0006\u0000\u0000\u015e\u015f\u0006\t\uffff\uffff\u0000\u015f\u0013\u0001"+
		"\u0000\u0000\u0000\u0160\u0162\u0003\u0016\u000b\u0000\u0161\u0163\u0003"+
		"\u001a\r\u0000\u0162\u0161\u0001\u0000\u0000\u0000\u0162\u0163\u0001\u0000"+
		"\u0000\u0000\u0163\u0164\u0001\u0000\u0000\u0000\u0164\u0165\u00053\u0000"+
		"\u0000\u0165\u0166\u0006\n\uffff\uffff\u0000\u0166\u0015\u0001\u0000\u0000"+
		"\u0000\u0167\u016b\u0006\u000b\uffff\uffff\u0000\u0168\u0169\u0003\u0018"+
		"\f\u0000\u0169\u016a\u0006\u000b\uffff\uffff\u0000\u016a\u016c\u0001\u0000"+
		"\u0000\u0000\u016b\u0168\u0001\u0000\u0000\u0000\u016c\u016d\u0001\u0000"+
		"\u0000\u0000\u016d\u016b\u0001\u0000\u0000\u0000\u016d\u016e\u0001\u0000"+
		"\u0000\u0000\u016e\u0017\u0001\u0000\u0000\u0000\u016f\u0170\u0005\u0012"+
		"\u0000\u0000\u0170\u0177\u0006\f\uffff\uffff\u0000\u0171\u0172\u0003\u001e"+
		"\u000f\u0000\u0172\u0173\u0006\f\uffff\uffff\u0000\u0173\u0177\u0001\u0000"+
		"\u0000\u0000\u0174\u0175\u0005\u0003\u0000\u0000\u0175\u0177\u0006\f\uffff"+
		"\uffff\u0000\u0176\u016f\u0001\u0000\u0000\u0000\u0176\u0171\u0001\u0000"+
		"\u0000\u0000\u0176\u0174\u0001\u0000\u0000\u0000\u0177\u0019\u0001\u0000"+
		"\u0000\u0000\u0178\u0179\u0006\r\uffff\uffff\u0000\u0179\u017a\u0003\u001c"+
		"\u000e\u0000\u017a\u0181\u0006\r\uffff\uffff\u0000\u017b\u017c\u00054"+
		"\u0000\u0000\u017c\u017d\u0003\u001c\u000e\u0000\u017d\u017e\u0006\r\uffff"+
		"\uffff\u0000\u017e\u0180\u0001\u0000\u0000\u0000\u017f\u017b\u0001\u0000"+
		"\u0000\u0000\u0180\u0183\u0001\u0000\u0000\u0000\u0181\u017f\u0001\u0000"+
		"\u0000\u0000\u0181\u0182\u0001\u0000\u0000\u0000\u0182\u001b\u0001\u0000"+
		"\u0000\u0000\u0183\u0181\u0001\u0000\u0000\u0000\u0184\u0185\u0003\"\u0011"+
		"\u0000\u0185\u018a\u0006\u000e\uffff\uffff\u0000\u0186\u0187\u00055\u0000"+
		"\u0000\u0187\u0188\u00034\u001a\u0000\u0188\u0189\u0006\u000e\uffff\uffff"+
		"\u0000\u0189\u018b\u0001\u0000\u0000\u0000\u018a\u0186\u0001\u0000\u0000"+
		"\u0000\u018a\u018b\u0001\u0000\u0000\u0000\u018b\u001d\u0001\u0000\u0000"+
		"\u0000\u018c\u018d\u0005\u0014\u0000\u0000\u018d\u01a3\u0006\u000f\uffff"+
		"\uffff\u0000\u018e\u018f\u0005\u0002\u0000\u0000\u018f\u01a3\u0006\u000f"+
		"\uffff\uffff\u0000\u0190\u0191\u0005\u000e\u0000\u0000\u0191\u01a3\u0006"+
		"\u000f\uffff\uffff\u0000\u0192\u0193\u0005\u000b\u0000\u0000\u0193\u01a3"+
		"\u0006\u000f\uffff\uffff\u0000\u0194\u0195\u0005\f\u0000\u0000\u0195\u01a3"+
		"\u0006\u000f\uffff\uffff\u0000\u0196\u0197\u0005\b\u0000\u0000\u0197\u01a3"+
		"\u0006\u000f\uffff\uffff\u0000\u0198\u0199\u0005\u0006\u0000\u0000\u0199"+
		"\u01a3\u0006\u000f\uffff\uffff\u0000\u019a\u019b\u0005\u000f\u0000\u0000"+
		"\u019b\u01a3\u0006\u000f\uffff\uffff\u0000\u019c\u019d\u0005\u0013\u0000"+
		"\u0000\u019d\u01a3\u0006\u000f\uffff\uffff\u0000\u019e\u019f\u0005\u0016"+
		"\u0000\u0000\u019f\u01a3\u0006\u000f\uffff\uffff\u0000\u01a0\u01a1\u0005"+
		"D\u0000\u0000\u01a1\u01a3\u0006\u000f\uffff\uffff\u0000\u01a2\u018c\u0001"+
		"\u0000\u0000\u0000\u01a2\u018e\u0001\u0000\u0000\u0000\u01a2\u0190\u0001"+
		"\u0000\u0000\u0000\u01a2\u0192\u0001\u0000\u0000\u0000\u01a2\u0194\u0001"+
		"\u0000\u0000\u0000\u01a2\u0196\u0001\u0000\u0000\u0000\u01a2\u0198\u0001"+
		"\u0000\u0000\u0000\u01a2\u019a\u0001\u0000\u0000\u0000\u01a2\u019c\u0001"+
		"\u0000\u0000\u0000\u01a2\u019e\u0001\u0000\u0000\u0000\u01a2\u01a0\u0001"+
		"\u0000\u0000\u0000\u01a3\u001f\u0001\u0000\u0000\u0000\u01a4\u01a5\u0003"+
		"\u001e\u000f\u0000\u01a5\u01a6\u0006\u0010\uffff\uffff\u0000\u01a6\u01aa"+
		"\u0001\u0000\u0000\u0000\u01a7\u01a8\u0005\u0003\u0000\u0000\u01a8\u01aa"+
		"\u0006\u0010\uffff\uffff\u0000\u01a9\u01a4\u0001\u0000\u0000\u0000\u01a9"+
		"\u01a7\u0001\u0000\u0000\u0000\u01aa\u01ae\u0001\u0000\u0000\u0000\u01ab"+
		"\u01ac\u0003 \u0010\u0000\u01ac\u01ad\u0006\u0010\uffff\uffff\u0000\u01ad"+
		"\u01af\u0001\u0000\u0000\u0000\u01ae\u01ab\u0001\u0000\u0000\u0000\u01ae"+
		"\u01af\u0001\u0000\u0000\u0000\u01af!\u0001\u0000\u0000\u0000\u01b0\u01b4"+
		"\u0006\u0011\uffff\uffff\u0000\u01b1\u01b2\u0003&\u0013\u0000\u01b2\u01b3"+
		"\u0006\u0011\uffff\uffff\u0000\u01b3\u01b5\u0001\u0000\u0000\u0000\u01b4"+
		"\u01b1\u0001\u0000\u0000\u0000\u01b4\u01b5\u0001\u0000\u0000\u0000\u01b5"+
		"\u01b6\u0001\u0000\u0000\u0000\u01b6\u01b7\u0003$\u0012\u0000\u01b7\u01b8"+
		"\u0006\u0011\uffff\uffff\u0000\u01b8#\u0001\u0000\u0000\u0000\u01b9\u01ba"+
		"\u0006\u0012\uffff\uffff\u0000\u01ba\u01bb\u0005D\u0000\u0000\u01bb\u01c2"+
		"\u0006\u0012\uffff\uffff\u0000\u01bc\u01bd\u0005\u0017\u0000\u0000\u01bd"+
		"\u01be\u0003\"\u0011\u0000\u01be\u01bf\u0005\u0018\u0000\u0000\u01bf\u01c0"+
		"\u0006\u0012\uffff\uffff\u0000\u01c0\u01c2\u0001\u0000\u0000\u0000\u01c1"+
		"\u01b9\u0001\u0000\u0000\u0000\u01c1\u01bc\u0001\u0000\u0000\u0000\u01c2"+
		"\u01db\u0001\u0000\u0000\u0000\u01c3\u01c4\n\u0002\u0000\u0000\u01c4\u01c5"+
		"\u0006\u0012\uffff\uffff\u0000\u01c5\u01c7\u0005\u0019\u0000\u0000\u01c6"+
		"\u01c8\u0003\n\u0005\u0000\u01c7\u01c6\u0001\u0000\u0000\u0000\u01c7\u01c8"+
		"\u0001\u0000\u0000\u0000\u01c8\u01c9\u0001\u0000\u0000\u0000\u01c9\u01ca"+
		"\u0005\u001a\u0000\u0000\u01ca\u01da\u0006\u0012\uffff\uffff\u0000\u01cb"+
		"\u01cc\n\u0001\u0000\u0000\u01cc\u01cd\u0006\u0012\uffff\uffff\u0000\u01cd"+
		"\u01d6\u0005\u0017\u0000\u0000\u01ce\u01cf\u0003(\u0014\u0000\u01cf\u01d0"+
		"\u0006\u0012\uffff\uffff\u0000\u01d0\u01d7\u0001\u0000\u0000\u0000\u01d1"+
		"\u01d2\u0003,\u0016\u0000\u01d2\u01d3\u0006\u0012\uffff\uffff\u0000\u01d3"+
		"\u01d5\u0001\u0000\u0000\u0000\u01d4\u01d1\u0001\u0000\u0000\u0000\u01d4"+
		"\u01d5\u0001\u0000\u0000\u0000\u01d5\u01d7\u0001\u0000\u0000\u0000\u01d6"+
		"\u01ce\u0001\u0000\u0000\u0000\u01d6\u01d4\u0001\u0000\u0000\u0000\u01d7"+
		"\u01d8\u0001\u0000\u0000\u0000\u01d8\u01da\u0005\u0018\u0000\u0000\u01d9"+
		"\u01c3\u0001\u0000\u0000\u0000\u01d9\u01cb\u0001\u0000\u0000\u0000\u01da"+
		"\u01dd\u0001\u0000\u0000\u0000\u01db\u01d9\u0001\u0000\u0000\u0000\u01db"+
		"\u01dc\u0001\u0000\u0000\u0000\u01dc%\u0001\u0000\u0000\u0000\u01dd\u01db"+
		"\u0001\u0000\u0000\u0000\u01de\u01e7\u0006\u0013\uffff\uffff\u0000\u01df"+
		"\u01e3\u0005\'\u0000\u0000\u01e0\u01e2\u0005\u0003\u0000\u0000\u01e1\u01e0"+
		"\u0001\u0000\u0000\u0000\u01e2\u01e5\u0001\u0000\u0000\u0000\u01e3\u01e1"+
		"\u0001\u0000\u0000\u0000\u01e3\u01e4\u0001\u0000\u0000\u0000\u01e4\u01e6"+
		"\u0001\u0000\u0000\u0000\u01e5\u01e3\u0001\u0000\u0000\u0000\u01e6\u01e8"+
		"\u0006\u0013\uffff\uffff\u0000\u01e7\u01df\u0001\u0000\u0000\u0000\u01e8"+
		"\u01e9\u0001\u0000\u0000\u0000\u01e9\u01e7\u0001\u0000\u0000\u0000\u01e9"+
		"\u01ea\u0001\u0000\u0000\u0000\u01ea\u01eb\u0001\u0000\u0000\u0000\u01eb"+
		"\u01ec\u0006\u0013\uffff\uffff\u0000\u01ec\'\u0001\u0000\u0000\u0000\u01ed"+
		"\u01ee\u0006\u0014\uffff\uffff\u0000\u01ee\u01ef\u0003*\u0015\u0000\u01ef"+
		"\u01f6\u0006\u0014\uffff\uffff\u0000\u01f0\u01f1\u00054\u0000\u0000\u01f1"+
		"\u01f2\u0003*\u0015\u0000\u01f2\u01f3\u0006\u0014\uffff\uffff\u0000\u01f3"+
		"\u01f5\u0001\u0000\u0000\u0000\u01f4\u01f0\u0001\u0000\u0000\u0000\u01f5"+
		"\u01f8\u0001\u0000\u0000\u0000\u01f6\u01f4\u0001\u0000\u0000\u0000\u01f6"+
		"\u01f7\u0001\u0000\u0000\u0000\u01f7)\u0001\u0000\u0000\u0000\u01f8\u01f6"+
		"\u0001\u0000\u0000\u0000\u01f9\u01fa\u0003\u0016\u000b\u0000\u01fa\u0203"+
		"\u0006\u0015\uffff\uffff\u0000\u01fb\u01fc\u0003\"\u0011\u0000\u01fc\u01fd"+
		"\u0006\u0015\uffff\uffff\u0000\u01fd\u0204\u0001\u0000\u0000\u0000\u01fe"+
		"\u01ff\u00030\u0018\u0000\u01ff\u0200\u0006\u0015\uffff\uffff\u0000\u0200"+
		"\u0202\u0001\u0000\u0000\u0000\u0201\u01fe\u0001\u0000\u0000\u0000\u0201"+
		"\u0202\u0001\u0000\u0000\u0000\u0202\u0204\u0001\u0000\u0000\u0000\u0203"+
		"\u01fb\u0001\u0000\u0000\u0000\u0203\u0201\u0001\u0000\u0000\u0000\u0204"+
		"+\u0001\u0000\u0000\u0000\u0205\u0206\u0006\u0016\uffff\uffff\u0000\u0206"+
		"\u0207\u0005D\u0000\u0000\u0207\u020d\u0006\u0016\uffff\uffff\u0000\u0208"+
		"\u0209\u00054\u0000\u0000\u0209\u020a\u0005D\u0000\u0000\u020a\u020c\u0006"+
		"\u0016\uffff\uffff\u0000\u020b\u0208\u0001\u0000\u0000\u0000\u020c\u020f"+
		"\u0001\u0000\u0000\u0000\u020d\u020b\u0001\u0000\u0000\u0000\u020d\u020e"+
		"\u0001\u0000\u0000\u0000\u020e-\u0001\u0000\u0000\u0000\u020f\u020d\u0001"+
		"\u0000\u0000\u0000\u0210\u0211\u0006\u0017\uffff\uffff\u0000\u0211\u0212"+
		"\u0003 \u0010\u0000\u0212\u0216\u0006\u0017\uffff\uffff\u0000\u0213\u0214"+
		"\u00030\u0018\u0000\u0214\u0215\u0006\u0017\uffff\uffff\u0000\u0215\u0217"+
		"\u0001\u0000\u0000\u0000\u0216\u0213\u0001\u0000\u0000\u0000\u0216\u0217"+
		"\u0001\u0000\u0000\u0000\u0217/\u0001\u0000\u0000\u0000\u0218\u0219\u0003"+
		"&\u0013\u0000\u0219\u021a\u0006\u0018\uffff\uffff\u0000\u021a\u0224\u0001"+
		"\u0000\u0000\u0000\u021b\u021c\u0003&\u0013\u0000\u021c\u021d\u0006\u0018"+
		"\uffff\uffff\u0000\u021d\u021f\u0001\u0000\u0000\u0000\u021e\u021b\u0001"+
		"\u0000\u0000\u0000\u021e\u021f\u0001\u0000\u0000\u0000\u021f\u0220\u0001"+
		"\u0000\u0000\u0000\u0220\u0221\u00032\u0019\u0000\u0221\u0222\u0006\u0018"+
		"\uffff\uffff\u0000\u0222\u0224\u0001\u0000\u0000\u0000\u0223\u0218\u0001"+
		"\u0000\u0000\u0000\u0223\u021e\u0001\u0000\u0000\u0000\u02241\u0001\u0000"+
		"\u0000\u0000\u0225\u0226\u0006\u0019\uffff\uffff\u0000\u0226\u0228\u0005"+
		"\u0019\u0000\u0000\u0227\u0229\u0003\n\u0005\u0000\u0228\u0227\u0001\u0000"+
		"\u0000\u0000\u0228\u0229\u0001\u0000\u0000\u0000\u0229\u022a\u0001\u0000"+
		"\u0000\u0000\u022a\u022b\u0005\u001a\u0000\u0000\u022b\u0238\u0006\u0019"+
		"\uffff\uffff\u0000\u022c\u0234\u0005\u0017\u0000\u0000\u022d\u022e\u0003"+
		"0\u0018\u0000\u022e\u022f\u0006\u0019\uffff\uffff\u0000\u022f\u0235\u0001"+
		"\u0000\u0000\u0000\u0230\u0232\u0003(\u0014\u0000\u0231\u0230\u0001\u0000"+
		"\u0000\u0000\u0231\u0232\u0001\u0000\u0000\u0000\u0232\u0233\u0001\u0000"+
		"\u0000\u0000\u0233\u0235\u0006\u0019\uffff\uffff\u0000\u0234\u022d\u0001"+
		"\u0000\u0000\u0000\u0234\u0231\u0001\u0000\u0000\u0000\u0235\u0236\u0001"+
		"\u0000\u0000\u0000\u0236\u0238\u0005\u0018\u0000\u0000\u0237\u0225\u0001"+
		"\u0000\u0000\u0000\u0237\u022c\u0001\u0000\u0000\u0000\u0238\u024b\u0001"+
		"\u0000\u0000\u0000\u0239\u023a\n\u0002\u0000\u0000\u023a\u023b\u0006\u0019"+
		"\uffff\uffff\u0000\u023b\u023d\u0005\u0019\u0000\u0000\u023c\u023e\u0003"+
		"\n\u0005\u0000\u023d\u023c\u0001\u0000\u0000\u0000\u023d\u023e\u0001\u0000"+
		"\u0000\u0000\u023e\u023f\u0001\u0000\u0000\u0000\u023f\u0240\u0005\u001a"+
		"\u0000\u0000\u0240\u024a\u0006\u0019\uffff\uffff\u0000\u0241\u0242\n\u0001"+
		"\u0000\u0000\u0242\u0243\u0006\u0019\uffff\uffff\u0000\u0243\u0245\u0005"+
		"\u0017\u0000\u0000\u0244\u0246\u0003(\u0014\u0000\u0245\u0244\u0001\u0000"+
		"\u0000\u0000\u0245\u0246\u0001\u0000\u0000\u0000\u0246\u0247\u0001\u0000"+
		"\u0000\u0000\u0247\u0248\u0005\u0018\u0000\u0000\u0248\u024a\u0006\u0019"+
		"\uffff\uffff\u0000\u0249\u0239\u0001\u0000\u0000\u0000\u0249\u0241\u0001"+
		"\u0000\u0000\u0000\u024a\u024d\u0001\u0000\u0000\u0000\u024b\u0249\u0001"+
		"\u0000\u0000\u0000\u024b\u024c\u0001\u0000\u0000\u0000\u024c3\u0001\u0000"+
		"\u0000\u0000\u024d\u024b\u0001\u0000\u0000\u0000\u024e\u024f\u0003\n\u0005"+
		"\u0000\u024f\u0250\u0006\u001a\uffff\uffff\u0000\u0250\u025a\u0001\u0000"+
		"\u0000\u0000\u0251\u0252\u0005\u001b\u0000\u0000\u0252\u0253\u00036\u001b"+
		"\u0000\u0253\u0255\u0006\u001a\uffff\uffff\u0000\u0254\u0256\u00054\u0000"+
		"\u0000\u0255\u0254\u0001\u0000\u0000\u0000\u0255\u0256\u0001\u0000\u0000"+
		"\u0000\u0256\u0257\u0001\u0000\u0000\u0000\u0257\u0258\u0005\u001c\u0000"+
		"\u0000\u0258\u025a\u0001\u0000\u0000\u0000\u0259\u024e\u0001\u0000\u0000"+
		"\u0000\u0259\u0251\u0001\u0000\u0000\u0000\u025a5\u0001\u0000\u0000\u0000"+
		"\u025b\u025d\u00038\u001c\u0000\u025c\u025b\u0001\u0000\u0000\u0000\u025c"+
		"\u025d\u0001\u0000\u0000\u0000\u025d\u025e\u0001\u0000\u0000\u0000\u025e"+
		"\u025f\u00034\u001a\u0000\u025f\u0269\u0006\u001b\uffff\uffff\u0000\u0260"+
		"\u0262\u00054\u0000\u0000\u0261\u0263\u00038\u001c\u0000\u0262\u0261\u0001"+
		"\u0000\u0000\u0000\u0262\u0263\u0001\u0000\u0000\u0000\u0263\u0264\u0001"+
		"\u0000\u0000\u0000\u0264\u0265\u00034\u001a\u0000\u0265\u0266\u0006\u001b"+
		"\uffff\uffff\u0000\u0266\u0268\u0001\u0000\u0000\u0000\u0267\u0260\u0001"+
		"\u0000\u0000\u0000\u0268\u026b\u0001\u0000\u0000\u0000\u0269\u0267\u0001"+
		"\u0000\u0000\u0000\u0269\u026a\u0001\u0000\u0000\u0000\u026a7\u0001\u0000"+
		"\u0000\u0000\u026b\u0269\u0001\u0000\u0000\u0000\u026c\u0270\u0006\u001c"+
		"\uffff\uffff\u0000\u026d\u026e\u0003:\u001d\u0000\u026e\u026f\u0006\u001c"+
		"\uffff\uffff\u0000\u026f\u0271\u0001\u0000\u0000\u0000\u0270\u026d\u0001"+
		"\u0000\u0000\u0000\u0271\u0272\u0001\u0000\u0000\u0000\u0272\u0270\u0001"+
		"\u0000\u0000\u0000\u0272\u0273\u0001\u0000\u0000\u0000\u0273\u0274\u0001"+
		"\u0000\u0000\u0000\u0274\u0275\u00055\u0000\u0000\u02759\u0001\u0000\u0000"+
		"\u0000\u0276\u0277\u0005\u0019\u0000\u0000\u0277\u0278\u0003\n\u0005\u0000"+
		"\u0278\u0279\u0006\u001d\uffff\uffff\u0000\u0279\u027a\u0005\u001a\u0000"+
		"\u0000\u027a\u027f\u0001\u0000\u0000\u0000\u027b\u027c\u0005C\u0000\u0000"+
		"\u027c\u027d\u0005D\u0000\u0000\u027d\u027f\u0006\u001d\uffff\uffff\u0000"+
		"\u027e\u0276\u0001\u0000\u0000\u0000\u027e\u027b\u0001\u0000\u0000\u0000"+
		"\u027f;\u0001\u0000\u0000\u0000\u0280\u0281\u0003>\u001f\u0000\u0281\u0282"+
		"\u0006\u001e\uffff\uffff\u0000\u0282\u0290\u0001\u0000\u0000\u0000\u0283"+
		"\u0284\u0003B!\u0000\u0284\u0285\u0006\u001e\uffff\uffff\u0000\u0285\u0290"+
		"\u0001\u0000\u0000\u0000\u0286\u0287\u0003D\"\u0000\u0287\u0288\u0006"+
		"\u001e\uffff\uffff\u0000\u0288\u0290\u0001\u0000\u0000\u0000\u0289\u028a"+
		"\u0003F#\u0000\u028a\u028b\u0006\u001e\uffff\uffff\u0000\u028b\u0290\u0001"+
		"\u0000\u0000\u0000\u028c\u028d\u0003N\'\u0000\u028d\u028e\u0006\u001e"+
		"\uffff\uffff\u0000\u028e\u0290\u0001\u0000\u0000\u0000\u028f\u0280\u0001"+
		"\u0000\u0000\u0000\u028f\u0283\u0001\u0000\u0000\u0000\u028f\u0286\u0001"+
		"\u0000\u0000\u0000\u028f\u0289\u0001\u0000\u0000\u0000\u028f\u028c\u0001"+
		"\u0000\u0000\u0000\u0290=\u0001\u0000\u0000\u0000\u0291\u0292\u0006\u001f"+
		"\uffff\uffff\u0000\u0292\u0298\u0005\u001b\u0000\u0000\u0293\u0294\u0003"+
		"@ \u0000\u0294\u0295\u0006\u001f\uffff\uffff\u0000\u0295\u0297\u0001\u0000"+
		"\u0000\u0000\u0296\u0293\u0001\u0000\u0000\u0000\u0297\u029a\u0001\u0000"+
		"\u0000\u0000\u0298\u0296\u0001\u0000\u0000\u0000\u0298\u0299\u0001\u0000"+
		"\u0000\u0000\u0299\u029b\u0001\u0000\u0000\u0000\u029a\u0298\u0001\u0000"+
		"\u0000\u0000\u029b\u029c\u0005\u001c\u0000\u0000\u029c?\u0001\u0000\u0000"+
		"\u0000\u029d\u029e\u0003<\u001e\u0000\u029e\u029f\u0006 \uffff\uffff\u0000"+
		"\u029f\u02a4\u0001\u0000\u0000\u0000\u02a0\u02a1\u0003\u0014\n\u0000\u02a1"+
		"\u02a2\u0006 \uffff\uffff\u0000\u02a2\u02a4\u0001\u0000\u0000\u0000\u02a3"+
		"\u029d\u0001\u0000\u0000\u0000\u02a3\u02a0\u0001\u0000\u0000\u0000\u02a4"+
		"A\u0001\u0000\u0000\u0000\u02a5\u02a6\u0003\n\u0005\u0000\u02a6\u02a7"+
		"\u0006!\uffff\uffff\u0000\u02a7\u02a9\u0001\u0000\u0000\u0000\u02a8\u02a5"+
		"\u0001\u0000\u0000\u0000\u02a8\u02a9\u0001\u0000\u0000\u0000\u02a9\u02aa"+
		"\u0001\u0000\u0000\u0000\u02aa\u02ab\u00053\u0000\u0000\u02abC\u0001\u0000"+
		"\u0000\u0000\u02ac\u02ad\u0005\n\u0000\u0000\u02ad\u02ae\u0005\u0017\u0000"+
		"\u0000\u02ae\u02af\u0003\n\u0005\u0000\u02af\u02b0\u0005\u0018\u0000\u0000"+
		"\u02b0\u02b1\u0003<\u001e\u0000\u02b1\u02b6\u0006\"\uffff\uffff\u0000"+
		"\u02b2\u02b3\u0005\u0007\u0000\u0000\u02b3\u02b4\u0003<\u001e\u0000\u02b4"+
		"\u02b5\u0006\"\uffff\uffff\u0000\u02b5\u02b7\u0001\u0000\u0000\u0000\u02b6"+
		"\u02b2\u0001\u0000\u0000\u0000\u02b6\u02b7\u0001\u0000\u0000\u0000\u02b7"+
		"E\u0001\u0000\u0000\u0000\u02b8\u02b9\u0005\u0015\u0000\u0000\u02b9\u02ba"+
		"\u0005\u0017\u0000\u0000\u02ba\u02bb\u0003\n\u0005\u0000\u02bb\u02bc\u0005"+
		"\u0018\u0000\u0000\u02bc\u02bd\u0003<\u001e\u0000\u02bd\u02be\u0006#\uffff"+
		"\uffff\u0000\u02be\u02d0\u0001\u0000\u0000\u0000\u02bf\u02c0\u0005\u0005"+
		"\u0000\u0000\u02c0\u02c1\u0003<\u001e\u0000\u02c1\u02c2\u0005\u0015\u0000"+
		"\u0000\u02c2\u02c3\u0005\u0017\u0000\u0000\u02c3\u02c4\u0003\n\u0005\u0000"+
		"\u02c4\u02c5\u0005\u0018\u0000\u0000\u02c5\u02c6\u00053\u0000\u0000\u02c6"+
		"\u02c7\u0006#\uffff\uffff\u0000\u02c7\u02d0\u0001\u0000\u0000\u0000\u02c8"+
		"\u02c9\u0005\t\u0000\u0000\u02c9\u02ca\u0005\u0017\u0000\u0000\u02ca\u02cb"+
		"\u0003H$\u0000\u02cb\u02cc\u0005\u0018\u0000\u0000\u02cc\u02cd\u0003<"+
		"\u001e\u0000\u02cd\u02ce\u0006#\uffff\uffff\u0000\u02ce\u02d0\u0001\u0000"+
		"\u0000\u0000\u02cf\u02b8\u0001\u0000\u0000\u0000\u02cf\u02bf\u0001\u0000"+
		"\u0000\u0000\u02cf\u02c8\u0001\u0000\u0000\u0000\u02d0G\u0001\u0000\u0000"+
		"\u0000\u02d1\u02d2\u0003J%\u0000\u02d2\u02d3\u0006$\uffff\uffff\u0000"+
		"\u02d3\u02da\u0001\u0000\u0000\u0000\u02d4\u02d5\u0003\n\u0005\u0000\u02d5"+
		"\u02d6\u0006$\uffff\uffff\u0000\u02d6\u02d8\u0001\u0000\u0000\u0000\u02d7"+
		"\u02d4\u0001\u0000\u0000\u0000\u02d7\u02d8\u0001\u0000\u0000\u0000\u02d8"+
		"\u02da\u0001\u0000\u0000\u0000\u02d9\u02d1\u0001\u0000\u0000\u0000\u02d9"+
		"\u02d7\u0001\u0000\u0000\u0000\u02da\u02db\u0001\u0000\u0000\u0000\u02db"+
		"\u02df\u00053\u0000\u0000\u02dc\u02dd\u0003L&\u0000\u02dd\u02de\u0006"+
		"$\uffff\uffff\u0000\u02de\u02e0\u0001\u0000\u0000\u0000\u02df\u02dc\u0001"+
		"\u0000\u0000\u0000\u02df\u02e0\u0001\u0000\u0000\u0000\u02e0\u02e1\u0001"+
		"\u0000\u0000\u0000\u02e1\u02e5\u00053\u0000\u0000\u02e2\u02e3\u0003L&"+
		"\u0000\u02e3\u02e4\u0006$\uffff\uffff\u0000\u02e4\u02e6\u0001\u0000\u0000"+
		"\u0000\u02e5\u02e2\u0001\u0000\u0000\u0000\u02e5\u02e6\u0001\u0000\u0000"+
		"\u0000\u02e6I\u0001\u0000\u0000\u0000\u02e7\u02e8\u0003\u0016\u000b\u0000"+
		"\u02e8\u02ec\u0006%\uffff\uffff\u0000\u02e9\u02ea\u0003\u001a\r\u0000"+
		"\u02ea\u02eb\u0006%\uffff\uffff\u0000\u02eb\u02ed\u0001\u0000\u0000\u0000"+
		"\u02ec\u02e9\u0001\u0000\u0000\u0000\u02ec\u02ed\u0001\u0000\u0000\u0000"+
		"\u02edK\u0001\u0000\u0000\u0000\u02ee\u02ef\u0006&\uffff\uffff\u0000\u02ef"+
		"\u02f0\u0003\n\u0005\u0000\u02f0\u02f7\u0006&\uffff\uffff\u0000\u02f1"+
		"\u02f2\u00054\u0000\u0000\u02f2\u02f3\u0003\n\u0005\u0000\u02f3\u02f4"+
		"\u0006&\uffff\uffff\u0000\u02f4\u02f6\u0001\u0000\u0000\u0000\u02f5\u02f1"+
		"\u0001\u0000\u0000\u0000\u02f6\u02f9\u0001\u0000\u0000\u0000\u02f7\u02f5"+
		"\u0001\u0000\u0000\u0000\u02f7\u02f8\u0001\u0000\u0000\u0000\u02f8M\u0001"+
		"\u0000\u0000\u0000\u02f9\u02f7\u0001\u0000\u0000\u0000\u02fa\u02fb\u0005"+
		"\u0004\u0000\u0000\u02fb\u0306\u0006\'\uffff\uffff\u0000\u02fc\u02fd\u0005"+
		"\u0001\u0000\u0000\u02fd\u0306\u0006\'\uffff\uffff\u0000\u02fe\u02ff\u0005"+
		"\r\u0000\u0000\u02ff\u0303\u0006\'\uffff\uffff\u0000\u0300\u0301\u0003"+
		"\n\u0005\u0000\u0301\u0302\u0006\'\uffff\uffff\u0000\u0302\u0304\u0001"+
		"\u0000\u0000\u0000\u0303\u0300\u0001\u0000\u0000\u0000\u0303\u0304\u0001"+
		"\u0000\u0000\u0000\u0304\u0306\u0001\u0000\u0000\u0000\u0305\u02fa\u0001"+
		"\u0000\u0000\u0000\u0305\u02fc\u0001\u0000\u0000\u0000\u0305\u02fe\u0001"+
		"\u0000\u0000\u0000\u0306\u0307\u0001\u0000\u0000\u0000\u0307\u0308\u0005"+
		"3\u0000\u0000\u0308O\u0001\u0000\u0000\u0000\u0309\u030a\u0005E\u0000"+
		"\u0000\u030a\u0310\u0006(\uffff\uffff\u0000\u030b\u030c\u0005F\u0000\u0000"+
		"\u030c\u0310\u0006(\uffff\uffff\u0000\u030d\u030e\u0005H\u0000\u0000\u030e"+
		"\u0310\u0006(\uffff\uffff\u0000\u030f\u0309\u0001\u0000\u0000\u0000\u030f"+
		"\u030b\u0001\u0000\u0000\u0000\u030f\u030d\u0001\u0000\u0000\u0000\u0310"+
		"Q\u0001\u0000\u0000\u0000JWaknr}\u008a\u0098\u00a2\u00af\u00bd\u00cc\u00d5"+
		"\u011e\u012d\u0131\u0133\u013f\u014e\u015b\u0162\u016d\u0176\u0181\u018a"+
		"\u01a2\u01a9\u01ae\u01b4\u01c1\u01c7\u01d4\u01d6\u01d9\u01db\u01e3\u01e9"+
		"\u01f6\u0201\u0203\u020d\u0216\u021e\u0223\u0228\u0231\u0234\u0237\u023d"+
		"\u0245\u0249\u024b\u0255\u0259\u025c\u0262\u0269\u0272\u027e\u028f\u0298"+
		"\u02a3\u02a8\u02b6\u02cf\u02d7\u02d9\u02df\u02e5\u02ec\u02f7\u0303\u0305"+
		"\u030f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}