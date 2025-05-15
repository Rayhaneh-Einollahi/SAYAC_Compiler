// Generated from F:/university/TA/plc/S04/3_name_analyzier/miniProject-NameAnalyzer/src/main/grammar/SimpleLang.g4 by ANTLR 4.13.2
package main.grammar;

    import main.ast.nodes.*;
    import main.ast.nodes.declaration.*;
    import main.ast.nodes.Stmt.*;
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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, MAIN=7, TYPE=8, IF=9, 
		ELSE=10, RETURN=11, INT_VAL=12, STR_VAL=13, BOOL_VAL=14, DOUBLE_VAL=15, 
		LBRACE=16, RBRACE=17, SEMI=18, ASSIGN=19, PLUS=20, LPAR=21, RPAR=22, ID=23, 
		WHITE_SPACE=24, LINE_COMMENT=25, BLOCK_COMMENT=26;
	public static final int
		RULE_program = 0, RULE_func_dec = 1, RULE_main = 2, RULE_stmt = 3, RULE_return_stmt = 4, 
		RULE_var_dec = 5, RULE_assign = 6, RULE_if_stmt = 7, RULE_expr = 8, RULE_func_call = 9, 
		RULE_primary_expr = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "func_dec", "main", "stmt", "return_stmt", "var_dec", "assign", 
			"if_stmt", "expr", "func_call", "primary_expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'FuncDec'", "'++'", "'--'", "'*'", "'/'", "'-'", "'main'", null, 
			"'if'", "'else'", "'return'", null, null, null, null, "'{'", "'}'", "';'", 
			"'='", "'+'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "MAIN", "TYPE", "IF", "ELSE", 
			"RETURN", "INT_VAL", "STR_VAL", "BOOL_VAL", "DOUBLE_VAL", "LBRACE", "RBRACE", 
			"SEMI", "ASSIGN", "PLUS", "LPAR", "RPAR", "ID", "WHITE_SPACE", "LINE_COMMENT", 
			"BLOCK_COMMENT"
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
	public static class ProgramContext extends ParserRuleContext {
		public Program programRet;
		public Func_decContext f;
		public MainContext m;
		public MainContext main() {
			return getRuleContext(MainContext.class,0);
		}
		public List<Func_decContext> func_dec() {
			return getRuleContexts(Func_decContext.class);
		}
		public Func_decContext func_dec(int i) {
			return getRuleContext(Func_decContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((ProgramContext)_localctx).programRet =  new Program();
			setState(28);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(23);
				((ProgramContext)_localctx).f = func_dec();
				 _localctx.programRet.addFuncDec(((ProgramContext)_localctx).f.funcDecRet); 
				}
				}
				setState(30);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(31);
			((ProgramContext)_localctx).m = main();
			 _localctx.programRet.setMain(((ProgramContext)_localctx).m.mainRet); 
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
	public static class Func_decContext extends ParserRuleContext {
		public FuncDec funcDecRet;
		public Token i;
		public StmtContext s;
		public TerminalNode LPAR() { return getToken(SimpleLangParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(SimpleLangParser.RPAR, 0); }
		public TerminalNode LBRACE() { return getToken(SimpleLangParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(SimpleLangParser.RBRACE, 0); }
		public TerminalNode ID() { return getToken(SimpleLangParser.ID, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public Func_decContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_dec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterFunc_dec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitFunc_dec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitFunc_dec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Func_decContext func_dec() throws RecognitionException {
		Func_decContext _localctx = new Func_decContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_func_dec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			match(T__0);
			setState(35);
			((Func_decContext)_localctx).i = match(ID);
			 ((Func_decContext)_localctx).funcDecRet =  new FuncDec((((Func_decContext)_localctx).i!=null?((Func_decContext)_localctx).i.getText():null)); 
			setState(37);
			match(LPAR);
			setState(38);
			match(RPAR);
			setState(39);
			match(LBRACE);
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8391424L) != 0)) {
				{
				{
				setState(40);
				((Func_decContext)_localctx).s = stmt();
				 _localctx.funcDecRet.addStmt(((Func_decContext)_localctx).s.stmtRet); 
				}
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(48);
			match(RBRACE);
			 _localctx.funcDecRet.setLine((((Func_decContext)_localctx).i!=null?((Func_decContext)_localctx).i.getLine():0)); 
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
	public static class MainContext extends ParserRuleContext {
		public Main mainRet;
		public Token m;
		public StmtContext s;
		public TerminalNode LPAR() { return getToken(SimpleLangParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(SimpleLangParser.RPAR, 0); }
		public TerminalNode LBRACE() { return getToken(SimpleLangParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(SimpleLangParser.RBRACE, 0); }
		public TerminalNode MAIN() { return getToken(SimpleLangParser.MAIN, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterMain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitMain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_main);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((MainContext)_localctx).mainRet =  new Main();
			setState(52);
			((MainContext)_localctx).m = match(MAIN);
			setState(53);
			match(LPAR);
			setState(54);
			match(RPAR);
			setState(55);
			match(LBRACE);
			 _localctx.mainRet.setLine((((MainContext)_localctx).m!=null?((MainContext)_localctx).m.getLine():0)); 
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8391424L) != 0)) {
				{
				{
				setState(57);
				((MainContext)_localctx).s = stmt();
				 _localctx.mainRet.addStmt(((MainContext)_localctx).s.stmtRet); 
				}
				}
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(65);
			match(RBRACE);
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
	public static class StmtContext extends ParserRuleContext {
		public Stmt stmtRet;
		public AssignContext a;
		public If_stmtContext i;
		public Var_decContext v;
		public Func_callContext f;
		public Return_stmtContext r;
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
		}
		public Var_decContext var_dec() {
			return getRuleContext(Var_decContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(SimpleLangParser.SEMI, 0); }
		public Func_callContext func_call() {
			return getRuleContext(Func_callContext.class,0);
		}
		public Return_stmtContext return_stmt() {
			return getRuleContext(Return_stmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_stmt);
		try {
			setState(83);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				((StmtContext)_localctx).a = assign();
				 ((StmtContext)_localctx).stmtRet =  ((StmtContext)_localctx).a.assignRet; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				((StmtContext)_localctx).i = if_stmt();
				 ((StmtContext)_localctx).stmtRet =  ((StmtContext)_localctx).i.ifStmtRet; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(73);
				((StmtContext)_localctx).v = var_dec();
				 ((StmtContext)_localctx).stmtRet =  ((StmtContext)_localctx).v.varDecRet; 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(76);
				((StmtContext)_localctx).f = func_call();
				 ((StmtContext)_localctx).stmtRet =  new FuncCallStmt(((StmtContext)_localctx).f.func_call_ret); _localctx.stmtRet.setLine(((StmtContext)_localctx).f.func_call_ret.getLine());
				setState(78);
				match(SEMI);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(80);
				((StmtContext)_localctx).r = return_stmt();
				 ((StmtContext)_localctx).stmtRet =  ((StmtContext)_localctx).r.returnRet; 
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
	public static class Return_stmtContext extends ParserRuleContext {
		public Return returnRet;
		public Token r;
		public ExprContext e;
		public TerminalNode SEMI() { return getToken(SimpleLangParser.SEMI, 0); }
		public TerminalNode RETURN() { return getToken(SimpleLangParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Return_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterReturn_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitReturn_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitReturn_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_stmtContext return_stmt() throws RecognitionException {
		Return_stmtContext _localctx = new Return_stmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_return_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			((Return_stmtContext)_localctx).r = match(RETURN);
			setState(86);
			((Return_stmtContext)_localctx).e = expr(0);
			setState(87);
			match(SEMI);

			        ((Return_stmtContext)_localctx).returnRet =  new Return(((Return_stmtContext)_localctx).e.exprRet);
			        _localctx.returnRet.setLine((((Return_stmtContext)_localctx).r!=null?((Return_stmtContext)_localctx).r.getLine():0));
			    
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
	public static class Var_decContext extends ParserRuleContext {
		public VarDec varDecRet;
		public Token t;
		public Token id;
		public TerminalNode SEMI() { return getToken(SimpleLangParser.SEMI, 0); }
		public TerminalNode TYPE() { return getToken(SimpleLangParser.TYPE, 0); }
		public TerminalNode ID() { return getToken(SimpleLangParser.ID, 0); }
		public Var_decContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_dec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterVar_dec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitVar_dec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitVar_dec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_decContext var_dec() throws RecognitionException {
		Var_decContext _localctx = new Var_decContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_var_dec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			((Var_decContext)_localctx).t = match(TYPE);
			setState(91);
			((Var_decContext)_localctx).id = match(ID);
			setState(92);
			match(SEMI);

			        ((Var_decContext)_localctx).varDecRet =  new VarDec((((Var_decContext)_localctx).id!=null?((Var_decContext)_localctx).id.getText():null));
			        _localctx.varDecRet.setLine((((Var_decContext)_localctx).id!=null?((Var_decContext)_localctx).id.getLine():0));
			        _localctx.varDecRet.setTypeName((((Var_decContext)_localctx).t!=null?((Var_decContext)_localctx).t.getText():null));
			     
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
	public static class AssignContext extends ParserRuleContext {
		public Assign assignRet;
		public Token id;
		public ExprContext e;
		public TerminalNode ASSIGN() { return getToken(SimpleLangParser.ASSIGN, 0); }
		public TerminalNode SEMI() { return getToken(SimpleLangParser.SEMI, 0); }
		public TerminalNode ID() { return getToken(SimpleLangParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			((AssignContext)_localctx).id = match(ID);
			setState(96);
			match(ASSIGN);
			setState(97);
			((AssignContext)_localctx).e = expr(0);
			setState(98);
			match(SEMI);

			        ((AssignContext)_localctx).assignRet =  new Assign((((AssignContext)_localctx).id!=null?((AssignContext)_localctx).id.getText():null), ((AssignContext)_localctx).e.exprRet);
			        _localctx.assignRet.setLine((((AssignContext)_localctx).id!=null?((AssignContext)_localctx).id.getLine():0));
			    
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
	public static class If_stmtContext extends ParserRuleContext {
		public IfStmt ifStmtRet;
		public Token i;
		public ExprContext e;
		public StmtContext s1;
		public StmtContext s2;
		public TerminalNode LPAR() { return getToken(SimpleLangParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(SimpleLangParser.RPAR, 0); }
		public TerminalNode IF() { return getToken(SimpleLangParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(SimpleLangParser.ELSE, 0); }
		public If_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterIf_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitIf_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitIf_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_if_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			((If_stmtContext)_localctx).i = match(IF);
			setState(102);
			match(LPAR);
			setState(103);
			((If_stmtContext)_localctx).e = expr(0);
			 ((If_stmtContext)_localctx).ifStmtRet =  new IfStmt(((If_stmtContext)_localctx).e.exprRet); 
			setState(105);
			match(RPAR);
			setState(106);
			((If_stmtContext)_localctx).s1 = stmt();
			 _localctx.ifStmtRet.setIfBody(((If_stmtContext)_localctx).s1.stmtRet); 
			setState(112);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(108);
				match(ELSE);
				setState(109);
				((If_stmtContext)_localctx).s2 = stmt();
				 _localctx.ifStmtRet.setElseBody(((If_stmtContext)_localctx).s2.stmtRet); 
				}
				break;
			}
			 _localctx.ifStmtRet.setLine((((If_stmtContext)_localctx).i!=null?((If_stmtContext)_localctx).i.getLine():0)); 
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
	public static class ExprContext extends ParserRuleContext {
		public Expr exprRet;
		public ExprContext e1;
		public ExprContext e2;
		public ExprContext e4;
		public Func_callContext f;
		public Primary_exprContext p;
		public Token op2;
		public ExprContext e3;
		public Token op3;
		public ExprContext e5;
		public Token op1;
		public Func_callContext func_call() {
			return getRuleContext(Func_callContext.class,0);
		}
		public Primary_exprContext primary_expr() {
			return getRuleContext(Primary_exprContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(SimpleLangParser.PLUS, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(117);
				((ExprContext)_localctx).f = func_call();
				((ExprContext)_localctx).exprRet =  ((ExprContext)_localctx).f.func_call_ret;
				}
				break;
			case 2:
				{
				setState(120);
				((ExprContext)_localctx).p = primary_expr();
				((ExprContext)_localctx).exprRet =  ((ExprContext)_localctx).p.primary_expr_ret;
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(140);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(138);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e2 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(125);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(126);
						((ExprContext)_localctx).op2 = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__3 || _la==T__4) ) {
							((ExprContext)_localctx).op2 = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(127);
						((ExprContext)_localctx).e3 = expr(5);

						                      BinaryOperator op = ((((ExprContext)_localctx).op2!=null?((ExprContext)_localctx).op2.getText():null).equals("*")) ? BinaryOperator.MULT :  BinaryOperator.DIVIDE;
						                      ((ExprContext)_localctx).exprRet =  new BinaryExpr(((ExprContext)_localctx).e2.exprRet, op, ((ExprContext)_localctx).e3.exprRet);
						                      _localctx.exprRet.setLine((((ExprContext)_localctx).op1!=null?((ExprContext)_localctx).op1.getLine():0));
						                  
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e4 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(130);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(131);
						((ExprContext)_localctx).op3 = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__5 || _la==PLUS) ) {
							((ExprContext)_localctx).op3 = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(132);
						((ExprContext)_localctx).e5 = expr(4);

						                      BinaryOperator op = ((((ExprContext)_localctx).op3!=null?((ExprContext)_localctx).op3.getText():null).equals("+")) ? BinaryOperator.PLUS :  BinaryOperator.MINUS;
						                      ((ExprContext)_localctx).exprRet =  new BinaryExpr(((ExprContext)_localctx).e4.exprRet, op, ((ExprContext)_localctx).e5.exprRet);
						                      _localctx.exprRet.setLine((((ExprContext)_localctx).op1!=null?((ExprContext)_localctx).op1.getLine():0));
						                  
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(135);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(136);
						((ExprContext)_localctx).op1 = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__1 || _la==T__2) ) {
							((ExprContext)_localctx).op1 = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}

						                      UnaryOperator  op = ((((ExprContext)_localctx).op1!=null?((ExprContext)_localctx).op1.getText():null).equals("--")) ? UnaryOperator.POST_DEC :  UnaryOperator.POST_INC;
						                      ((ExprContext)_localctx).exprRet =  new UnaryExpr(((ExprContext)_localctx).e1.exprRet, op);
						                      _localctx.exprRet.setLine((((ExprContext)_localctx).op1!=null?((ExprContext)_localctx).op1.getLine():0));
						                  
						}
						break;
					}
					} 
				}
				setState(142);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
	public static class Func_callContext extends ParserRuleContext {
		public FuncCallExpr func_call_ret;
		public Token id;
		public TerminalNode LPAR() { return getToken(SimpleLangParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(SimpleLangParser.RPAR, 0); }
		public TerminalNode ID() { return getToken(SimpleLangParser.ID, 0); }
		public Func_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterFunc_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitFunc_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitFunc_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Func_callContext func_call() throws RecognitionException {
		Func_callContext _localctx = new Func_callContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_func_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			((Func_callContext)_localctx).id = match(ID);
			setState(144);
			match(LPAR);
			setState(145);
			match(RPAR);

			        ((Func_callContext)_localctx).func_call_ret =  new FuncCallExpr((((Func_callContext)_localctx).id!=null?((Func_callContext)_localctx).id.getText():null));
			        _localctx.func_call_ret.setLine((((Func_callContext)_localctx).id!=null?((Func_callContext)_localctx).id.getLine():0));
			    
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
	public static class Primary_exprContext extends ParserRuleContext {
		public Expr primary_expr_ret;
		public Token id;
		public Token i;
		public Token b;
		public Token s;
		public Token d;
		public TerminalNode ID() { return getToken(SimpleLangParser.ID, 0); }
		public TerminalNode INT_VAL() { return getToken(SimpleLangParser.INT_VAL, 0); }
		public TerminalNode BOOL_VAL() { return getToken(SimpleLangParser.BOOL_VAL, 0); }
		public TerminalNode STR_VAL() { return getToken(SimpleLangParser.STR_VAL, 0); }
		public TerminalNode DOUBLE_VAL() { return getToken(SimpleLangParser.DOUBLE_VAL, 0); }
		public Primary_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterPrimary_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitPrimary_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitPrimary_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Primary_exprContext primary_expr() throws RecognitionException {
		Primary_exprContext _localctx = new Primary_exprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_primary_expr);
		try {
			setState(158);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(148);
				((Primary_exprContext)_localctx).id = match(ID);
				((Primary_exprContext)_localctx).primary_expr_ret =  new Identifier((((Primary_exprContext)_localctx).id!=null?((Primary_exprContext)_localctx).id.getText():null)); _localctx.primary_expr_ret.setLine((((Primary_exprContext)_localctx).id!=null?((Primary_exprContext)_localctx).id.getLine():0));
				}
				break;
			case INT_VAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(150);
				((Primary_exprContext)_localctx).i = match(INT_VAL);
				 ((Primary_exprContext)_localctx).primary_expr_ret =  new IntVal((((Primary_exprContext)_localctx).i!=null?Integer.valueOf(((Primary_exprContext)_localctx).i.getText()):0)); _localctx.primary_expr_ret.setLine((((Primary_exprContext)_localctx).i!=null?((Primary_exprContext)_localctx).i.getLine():0));
				}
				break;
			case BOOL_VAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(152);
				((Primary_exprContext)_localctx).b = match(BOOL_VAL);
				 ((Primary_exprContext)_localctx).primary_expr_ret =  new BoolVal((((Primary_exprContext)_localctx).b!=null?((Primary_exprContext)_localctx).b.getText():null)); _localctx.primary_expr_ret.setLine((((Primary_exprContext)_localctx).b!=null?((Primary_exprContext)_localctx).b.getLine():0));
				}
				break;
			case STR_VAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(154);
				((Primary_exprContext)_localctx).s = match(STR_VAL);
				 ((Primary_exprContext)_localctx).primary_expr_ret =  new StringVal((((Primary_exprContext)_localctx).s!=null?((Primary_exprContext)_localctx).s.getText():null)); _localctx.primary_expr_ret.setLine((((Primary_exprContext)_localctx).s!=null?((Primary_exprContext)_localctx).s.getLine():0));
				}
				break;
			case DOUBLE_VAL:
				enterOuterAlt(_localctx, 5);
				{
				setState(156);
				((Primary_exprContext)_localctx).d = match(DOUBLE_VAL);
				 ((Primary_exprContext)_localctx).primary_expr_ret =  new DoubleVal((((Primary_exprContext)_localctx).d!=null?((Primary_exprContext)_localctx).d.getText():null)); _localctx.primary_expr_ret.setLine((((Primary_exprContext)_localctx).d!=null?((Primary_exprContext)_localctx).d.getLine():0));
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
		case 8:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001a\u00a1\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0005\u0000\u001b\b\u0000\n\u0000\f\u0000\u001e"+
		"\t\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0005\u0001,\b\u0001\n\u0001\f\u0001/\t\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002=\b"+
		"\u0002\n\u0002\f\u0002@\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003T\b\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0003\u0007q\b\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b|\b\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0005\b\u008b\b\b\n\b\f\b\u008e\t\b\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u009f\b\n\u0001\n\u0000"+
		"\u0001\u0010\u000b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0000\u0003\u0001\u0000\u0004\u0005\u0002\u0000\u0006\u0006\u0014\u0014"+
		"\u0001\u0000\u0002\u0003\u00a5\u0000\u0016\u0001\u0000\u0000\u0000\u0002"+
		"\"\u0001\u0000\u0000\u0000\u00043\u0001\u0000\u0000\u0000\u0006S\u0001"+
		"\u0000\u0000\u0000\bU\u0001\u0000\u0000\u0000\nZ\u0001\u0000\u0000\u0000"+
		"\f_\u0001\u0000\u0000\u0000\u000ee\u0001\u0000\u0000\u0000\u0010{\u0001"+
		"\u0000\u0000\u0000\u0012\u008f\u0001\u0000\u0000\u0000\u0014\u009e\u0001"+
		"\u0000\u0000\u0000\u0016\u001c\u0006\u0000\uffff\uffff\u0000\u0017\u0018"+
		"\u0003\u0002\u0001\u0000\u0018\u0019\u0006\u0000\uffff\uffff\u0000\u0019"+
		"\u001b\u0001\u0000\u0000\u0000\u001a\u0017\u0001\u0000\u0000\u0000\u001b"+
		"\u001e\u0001\u0000\u0000\u0000\u001c\u001a\u0001\u0000\u0000\u0000\u001c"+
		"\u001d\u0001\u0000\u0000\u0000\u001d\u001f\u0001\u0000\u0000\u0000\u001e"+
		"\u001c\u0001\u0000\u0000\u0000\u001f \u0003\u0004\u0002\u0000 !\u0006"+
		"\u0000\uffff\uffff\u0000!\u0001\u0001\u0000\u0000\u0000\"#\u0005\u0001"+
		"\u0000\u0000#$\u0005\u0017\u0000\u0000$%\u0006\u0001\uffff\uffff\u0000"+
		"%&\u0005\u0015\u0000\u0000&\'\u0005\u0016\u0000\u0000\'-\u0005\u0010\u0000"+
		"\u0000()\u0003\u0006\u0003\u0000)*\u0006\u0001\uffff\uffff\u0000*,\u0001"+
		"\u0000\u0000\u0000+(\u0001\u0000\u0000\u0000,/\u0001\u0000\u0000\u0000"+
		"-+\u0001\u0000\u0000\u0000-.\u0001\u0000\u0000\u0000.0\u0001\u0000\u0000"+
		"\u0000/-\u0001\u0000\u0000\u000001\u0005\u0011\u0000\u000012\u0006\u0001"+
		"\uffff\uffff\u00002\u0003\u0001\u0000\u0000\u000034\u0006\u0002\uffff"+
		"\uffff\u000045\u0005\u0007\u0000\u000056\u0005\u0015\u0000\u000067\u0005"+
		"\u0016\u0000\u000078\u0005\u0010\u0000\u00008>\u0006\u0002\uffff\uffff"+
		"\u00009:\u0003\u0006\u0003\u0000:;\u0006\u0002\uffff\uffff\u0000;=\u0001"+
		"\u0000\u0000\u0000<9\u0001\u0000\u0000\u0000=@\u0001\u0000\u0000\u0000"+
		"><\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000?A\u0001\u0000\u0000"+
		"\u0000@>\u0001\u0000\u0000\u0000AB\u0005\u0011\u0000\u0000B\u0005\u0001"+
		"\u0000\u0000\u0000CD\u0003\f\u0006\u0000DE\u0006\u0003\uffff\uffff\u0000"+
		"ET\u0001\u0000\u0000\u0000FG\u0003\u000e\u0007\u0000GH\u0006\u0003\uffff"+
		"\uffff\u0000HT\u0001\u0000\u0000\u0000IJ\u0003\n\u0005\u0000JK\u0006\u0003"+
		"\uffff\uffff\u0000KT\u0001\u0000\u0000\u0000LM\u0003\u0012\t\u0000MN\u0006"+
		"\u0003\uffff\uffff\u0000NO\u0005\u0012\u0000\u0000OT\u0001\u0000\u0000"+
		"\u0000PQ\u0003\b\u0004\u0000QR\u0006\u0003\uffff\uffff\u0000RT\u0001\u0000"+
		"\u0000\u0000SC\u0001\u0000\u0000\u0000SF\u0001\u0000\u0000\u0000SI\u0001"+
		"\u0000\u0000\u0000SL\u0001\u0000\u0000\u0000SP\u0001\u0000\u0000\u0000"+
		"T\u0007\u0001\u0000\u0000\u0000UV\u0005\u000b\u0000\u0000VW\u0003\u0010"+
		"\b\u0000WX\u0005\u0012\u0000\u0000XY\u0006\u0004\uffff\uffff\u0000Y\t"+
		"\u0001\u0000\u0000\u0000Z[\u0005\b\u0000\u0000[\\\u0005\u0017\u0000\u0000"+
		"\\]\u0005\u0012\u0000\u0000]^\u0006\u0005\uffff\uffff\u0000^\u000b\u0001"+
		"\u0000\u0000\u0000_`\u0005\u0017\u0000\u0000`a\u0005\u0013\u0000\u0000"+
		"ab\u0003\u0010\b\u0000bc\u0005\u0012\u0000\u0000cd\u0006\u0006\uffff\uffff"+
		"\u0000d\r\u0001\u0000\u0000\u0000ef\u0005\t\u0000\u0000fg\u0005\u0015"+
		"\u0000\u0000gh\u0003\u0010\b\u0000hi\u0006\u0007\uffff\uffff\u0000ij\u0005"+
		"\u0016\u0000\u0000jk\u0003\u0006\u0003\u0000kp\u0006\u0007\uffff\uffff"+
		"\u0000lm\u0005\n\u0000\u0000mn\u0003\u0006\u0003\u0000no\u0006\u0007\uffff"+
		"\uffff\u0000oq\u0001\u0000\u0000\u0000pl\u0001\u0000\u0000\u0000pq\u0001"+
		"\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000rs\u0006\u0007\uffff\uffff"+
		"\u0000s\u000f\u0001\u0000\u0000\u0000tu\u0006\b\uffff\uffff\u0000uv\u0003"+
		"\u0012\t\u0000vw\u0006\b\uffff\uffff\u0000w|\u0001\u0000\u0000\u0000x"+
		"y\u0003\u0014\n\u0000yz\u0006\b\uffff\uffff\u0000z|\u0001\u0000\u0000"+
		"\u0000{t\u0001\u0000\u0000\u0000{x\u0001\u0000\u0000\u0000|\u008c\u0001"+
		"\u0000\u0000\u0000}~\n\u0004\u0000\u0000~\u007f\u0007\u0000\u0000\u0000"+
		"\u007f\u0080\u0003\u0010\b\u0005\u0080\u0081\u0006\b\uffff\uffff\u0000"+
		"\u0081\u008b\u0001\u0000\u0000\u0000\u0082\u0083\n\u0003\u0000\u0000\u0083"+
		"\u0084\u0007\u0001\u0000\u0000\u0084\u0085\u0003\u0010\b\u0004\u0085\u0086"+
		"\u0006\b\uffff\uffff\u0000\u0086\u008b\u0001\u0000\u0000\u0000\u0087\u0088"+
		"\n\u0005\u0000\u0000\u0088\u0089\u0007\u0002\u0000\u0000\u0089\u008b\u0006"+
		"\b\uffff\uffff\u0000\u008a}\u0001\u0000\u0000\u0000\u008a\u0082\u0001"+
		"\u0000\u0000\u0000\u008a\u0087\u0001\u0000\u0000\u0000\u008b\u008e\u0001"+
		"\u0000\u0000\u0000\u008c\u008a\u0001\u0000\u0000\u0000\u008c\u008d\u0001"+
		"\u0000\u0000\u0000\u008d\u0011\u0001\u0000\u0000\u0000\u008e\u008c\u0001"+
		"\u0000\u0000\u0000\u008f\u0090\u0005\u0017\u0000\u0000\u0090\u0091\u0005"+
		"\u0015\u0000\u0000\u0091\u0092\u0005\u0016\u0000\u0000\u0092\u0093\u0006"+
		"\t\uffff\uffff\u0000\u0093\u0013\u0001\u0000\u0000\u0000\u0094\u0095\u0005"+
		"\u0017\u0000\u0000\u0095\u009f\u0006\n\uffff\uffff\u0000\u0096\u0097\u0005"+
		"\f\u0000\u0000\u0097\u009f\u0006\n\uffff\uffff\u0000\u0098\u0099\u0005"+
		"\u000e\u0000\u0000\u0099\u009f\u0006\n\uffff\uffff\u0000\u009a\u009b\u0005"+
		"\r\u0000\u0000\u009b\u009f\u0006\n\uffff\uffff\u0000\u009c\u009d\u0005"+
		"\u000f\u0000\u0000\u009d\u009f\u0006\n\uffff\uffff\u0000\u009e\u0094\u0001"+
		"\u0000\u0000\u0000\u009e\u0096\u0001\u0000\u0000\u0000\u009e\u0098\u0001"+
		"\u0000\u0000\u0000\u009e\u009a\u0001\u0000\u0000\u0000\u009e\u009c\u0001"+
		"\u0000\u0000\u0000\u009f\u0015\u0001\u0000\u0000\u0000\t\u001c->Sp{\u008a"+
		"\u008c\u009e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}