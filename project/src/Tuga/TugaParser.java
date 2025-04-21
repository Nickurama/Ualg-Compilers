// Generated from Tuga.g4 by ANTLR 4.13.2
package Tuga;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class TugaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		END_INST=10, LPAREN=11, RPAREN=12, SUM=13, SUB=14, MLT=15, DIV=16, MOD=17, 
		LESS=18, GREATER=19, LESS_EQ=20, GREATER_EQ=21, EQUALS=22, N_EQUALS=23, 
		AND=24, OR=25, NOT=26, INT=27, DOUBLE=28, STRING=29, TRUE=30, FALSE=31, 
		TYPE=32, ID=33, WS=34, SL_COMMENT=35, ML_COMMENT=36;
	public static final int
		RULE_tuga = 0, RULE_var_decl = 1, RULE_inst = 2, RULE_print = 3, RULE_assign = 4, 
		RULE_scope = 5, RULE_if = 6, RULE_else = 7, RULE_while = 8, RULE_empty = 9, 
		RULE_vars = 10, RULE_expr = 11, RULE_literal = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"tuga", "var_decl", "inst", "print", "assign", "scope", "if", "else", 
			"while", "empty", "vars", "expr", "literal"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "'escreve'", "'<-'", "'inicio'", "'fim'", "'se'", "'senao'", 
			"'enquanto'", "','", "';'", "'('", "')'", "'+'", "'-'", "'*'", "'/'", 
			"'%'", "'<'", "'>'", "'<='", "'>='", "'igual'", "'diferente'", "'e'", 
			"'ou'", "'nao'", null, null, null, "'verdadeiro'", "'falso'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "END_INST", 
			"LPAREN", "RPAREN", "SUM", "SUB", "MLT", "DIV", "MOD", "LESS", "GREATER", 
			"LESS_EQ", "GREATER_EQ", "EQUALS", "N_EQUALS", "AND", "OR", "NOT", "INT", 
			"DOUBLE", "STRING", "TRUE", "FALSE", "TYPE", "ID", "WS", "SL_COMMENT", 
			"ML_COMMENT"
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
	public String getGrammarFileName() { return "Tuga.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TugaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TugaContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(TugaParser.EOF, 0); }
		public List<Var_declContext> var_decl() {
			return getRuleContexts(Var_declContext.class);
		}
		public Var_declContext var_decl(int i) {
			return getRuleContext(Var_declContext.class,i);
		}
		public List<InstContext> inst() {
			return getRuleContexts(InstContext.class);
		}
		public InstContext inst(int i) {
			return getRuleContext(InstContext.class,i);
		}
		public TugaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tuga; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterTuga(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitTuga(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitTuga(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TugaContext tuga() throws RecognitionException {
		TugaContext _localctx = new TugaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_tuga);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(26);
					var_decl();
					}
					} 
				}
				setState(31);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(33); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(32);
				inst();
				}
				}
				setState(35); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 8589935956L) != 0) );
			setState(37);
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
	public static class Var_declContext extends ParserRuleContext {
		public Var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl; }
	 
		public Var_declContext() { }
		public void copyFrom(Var_declContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarDeclContext extends Var_declContext {
		public VarsContext vars() {
			return getRuleContext(VarsContext.class,0);
		}
		public TerminalNode TYPE() { return getToken(TugaParser.TYPE, 0); }
		public TerminalNode END_INST() { return getToken(TugaParser.END_INST, 0); }
		public VarDeclContext(Var_declContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_var_decl);
		try {
			_localctx = new VarDeclContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			vars();
			setState(40);
			match(T__0);
			setState(41);
			match(TYPE);
			setState(42);
			match(END_INST);
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
	public static class InstContext extends ParserRuleContext {
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
		}
		public IfContext if_() {
			return getRuleContext(IfContext.class,0);
		}
		public ElseContext else_() {
			return getRuleContext(ElseContext.class,0);
		}
		public WhileContext while_() {
			return getRuleContext(WhileContext.class,0);
		}
		public EmptyContext empty() {
			return getRuleContext(EmptyContext.class,0);
		}
		public InstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inst; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterInst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitInst(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitInst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstContext inst() throws RecognitionException {
		InstContext _localctx = new InstContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_inst);
		try {
			setState(53);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				print();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				assign();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(46);
				scope();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(47);
				if_();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(48);
				if_();
				setState(49);
				else_();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(51);
				while_();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(52);
				empty();
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
	public static class PrintContext extends ParserRuleContext {
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
	 
		public PrintContext() { }
		public void copyFrom(PrintContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintInstContext extends PrintContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode END_INST() { return getToken(TugaParser.END_INST, 0); }
		public PrintInstContext(PrintContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterPrintInst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitPrintInst(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitPrintInst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_print);
		try {
			_localctx = new PrintInstContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(T__1);
			setState(56);
			expr(0);
			setState(57);
			match(END_INST);
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
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
	 
		public AssignContext() { }
		public void copyFrom(AssignContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignInstContext extends AssignContext {
		public TerminalNode ID() { return getToken(TugaParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode END_INST() { return getToken(TugaParser.END_INST, 0); }
		public AssignInstContext(AssignContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterAssignInst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitAssignInst(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitAssignInst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_assign);
		try {
			_localctx = new AssignInstContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(ID);
			setState(60);
			match(T__2);
			setState(61);
			expr(0);
			setState(62);
			match(END_INST);
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
	public static class ScopeContext extends ParserRuleContext {
		public ScopeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scope; }
	 
		public ScopeContext() { }
		public void copyFrom(ScopeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ScopeInstContext extends ScopeContext {
		public List<InstContext> inst() {
			return getRuleContexts(InstContext.class);
		}
		public InstContext inst(int i) {
			return getRuleContext(InstContext.class,i);
		}
		public ScopeInstContext(ScopeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterScopeInst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitScopeInst(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitScopeInst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScopeContext scope() throws RecognitionException {
		ScopeContext _localctx = new ScopeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_scope);
		int _la;
		try {
			_localctx = new ScopeInstContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(T__3);
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8589935956L) != 0)) {
				{
				{
				setState(65);
				inst();
				}
				}
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(71);
			match(T__4);
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
	public static class IfContext extends ParserRuleContext {
		public IfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if; }
	 
		public IfContext() { }
		public void copyFrom(IfContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfInstContext extends IfContext {
		public TerminalNode LPAREN() { return getToken(TugaParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(TugaParser.RPAREN, 0); }
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
		}
		public IfInstContext(IfContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterIfInst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitIfInst(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitIfInst(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InlineIfInstContext extends IfContext {
		public TerminalNode LPAREN() { return getToken(TugaParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(TugaParser.RPAREN, 0); }
		public InstContext inst() {
			return getRuleContext(InstContext.class,0);
		}
		public InlineIfInstContext(IfContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterInlineIfInst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitInlineIfInst(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitInlineIfInst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfContext if_() throws RecognitionException {
		IfContext _localctx = new IfContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_if);
		try {
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new IfInstContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				match(T__5);
				setState(74);
				match(LPAREN);
				setState(75);
				expr(0);
				setState(76);
				match(RPAREN);
				setState(77);
				scope();
				}
				break;
			case 2:
				_localctx = new InlineIfInstContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				match(T__5);
				setState(80);
				match(LPAREN);
				setState(81);
				expr(0);
				setState(82);
				match(RPAREN);
				setState(83);
				inst();
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
	public static class ElseContext extends ParserRuleContext {
		public ElseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else; }
	 
		public ElseContext() { }
		public void copyFrom(ElseContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InlineElseInstContext extends ElseContext {
		public InstContext inst() {
			return getRuleContext(InstContext.class,0);
		}
		public InlineElseInstContext(ElseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterInlineElseInst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitInlineElseInst(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitInlineElseInst(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ElseInstContext extends ElseContext {
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
		}
		public ElseInstContext(ElseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterElseInst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitElseInst(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitElseInst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseContext else_() throws RecognitionException {
		ElseContext _localctx = new ElseContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_else);
		try {
			setState(91);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new ElseInstContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(87);
				match(T__6);
				setState(88);
				scope();
				}
				break;
			case 2:
				_localctx = new InlineElseInstContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
				match(T__6);
				setState(90);
				inst();
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
	public static class WhileContext extends ParserRuleContext {
		public WhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while; }
	 
		public WhileContext() { }
		public void copyFrom(WhileContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileInstContext extends WhileContext {
		public TerminalNode LPAREN() { return getToken(TugaParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(TugaParser.RPAREN, 0); }
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
		}
		public WhileInstContext(WhileContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterWhileInst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitWhileInst(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitWhileInst(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InlineWhileInstContext extends WhileContext {
		public TerminalNode LPAREN() { return getToken(TugaParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(TugaParser.RPAREN, 0); }
		public InstContext inst() {
			return getRuleContext(InstContext.class,0);
		}
		public InlineWhileInstContext(WhileContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterInlineWhileInst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitInlineWhileInst(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitInlineWhileInst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileContext while_() throws RecognitionException {
		WhileContext _localctx = new WhileContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_while);
		try {
			setState(105);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new WhileInstContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				match(T__7);
				setState(94);
				match(LPAREN);
				setState(95);
				expr(0);
				setState(96);
				match(RPAREN);
				setState(97);
				scope();
				}
				break;
			case 2:
				_localctx = new InlineWhileInstContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(99);
				match(T__7);
				setState(100);
				match(LPAREN);
				setState(101);
				expr(0);
				setState(102);
				match(RPAREN);
				setState(103);
				inst();
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
	public static class EmptyContext extends ParserRuleContext {
		public EmptyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_empty; }
	 
		public EmptyContext() { }
		public void copyFrom(EmptyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EmptyInstContext extends EmptyContext {
		public TerminalNode END_INST() { return getToken(TugaParser.END_INST, 0); }
		public EmptyInstContext(EmptyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterEmptyInst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitEmptyInst(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitEmptyInst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmptyContext empty() throws RecognitionException {
		EmptyContext _localctx = new EmptyContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_empty);
		try {
			_localctx = new EmptyInstContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(END_INST);
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
	public static class VarsContext extends ParserRuleContext {
		public VarsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vars; }
	 
		public VarsContext() { }
		public void copyFrom(VarsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarMultipleContext extends VarsContext {
		public TerminalNode ID() { return getToken(TugaParser.ID, 0); }
		public VarsContext vars() {
			return getRuleContext(VarsContext.class,0);
		}
		public VarMultipleContext(VarsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterVarMultiple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitVarMultiple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitVarMultiple(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarSingleContext extends VarsContext {
		public TerminalNode ID() { return getToken(TugaParser.ID, 0); }
		public VarSingleContext(VarsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterVarSingle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitVarSingle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitVarSingle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarsContext vars() throws RecognitionException {
		VarsContext _localctx = new VarsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_vars);
		try {
			setState(113);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new VarSingleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(109);
				match(ID);
				}
				break;
			case 2:
				_localctx = new VarMultipleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				match(ID);
				setState(111);
				match(T__8);
				setState(112);
				vars();
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
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IDExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(TugaParser.ID, 0); }
		public IDExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterIDExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitIDExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitIDExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqualsOpContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EQUALS() { return getToken(TugaParser.EQUALS, 0); }
		public TerminalNode N_EQUALS() { return getToken(TugaParser.N_EQUALS, 0); }
		public EqualsOpContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterEqualsOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitEqualsOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitEqualsOp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrOpContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OR() { return getToken(TugaParser.OR, 0); }
		public OrOpContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterOrOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitOrOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitOrOp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultDivOpContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MLT() { return getToken(TugaParser.MLT, 0); }
		public TerminalNode DIV() { return getToken(TugaParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(TugaParser.MOD, 0); }
		public MultDivOpContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterMultDivOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitMultDivOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitMultDivOp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SumSubOpContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode SUM() { return getToken(TugaParser.SUM, 0); }
		public TerminalNode SUB() { return getToken(TugaParser.SUB, 0); }
		public SumSubOpContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterSumSubOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitSumSubOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitSumSubOp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicNegateOpContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NOT() { return getToken(TugaParser.NOT, 0); }
		public LogicNegateOpContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterLogicNegateOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitLogicNegateOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitLogicNegateOp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LiteralExprContext extends ExprContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterLiteralExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitLiteralExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitLiteralExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RelOpContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LESS() { return getToken(TugaParser.LESS, 0); }
		public TerminalNode GREATER() { return getToken(TugaParser.GREATER, 0); }
		public TerminalNode LESS_EQ() { return getToken(TugaParser.LESS_EQ, 0); }
		public TerminalNode GREATER_EQ() { return getToken(TugaParser.GREATER_EQ, 0); }
		public RelOpContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterRelOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitRelOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitRelOp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenExprContext extends ExprContext {
		public TerminalNode LPAREN() { return getToken(TugaParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(TugaParser.RPAREN, 0); }
		public ParenExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterParenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitParenExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitParenExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArithmeticNegateOpContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SUB() { return getToken(TugaParser.SUB, 0); }
		public ArithmeticNegateOpContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterArithmeticNegateOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitArithmeticNegateOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitArithmeticNegateOp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndOpContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(TugaParser.AND, 0); }
		public AndOpContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterAndOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitAndOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitAndOp(this);
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
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(116);
				match(LPAREN);
				setState(117);
				expr(0);
				setState(118);
				match(RPAREN);
				}
				break;
			case SUB:
				{
				_localctx = new ArithmeticNegateOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(120);
				((ArithmeticNegateOpContext)_localctx).op = match(SUB);
				setState(121);
				expr(10);
				}
				break;
			case NOT:
				{
				_localctx = new LogicNegateOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(122);
				((LogicNegateOpContext)_localctx).op = match(NOT);
				setState(123);
				expr(9);
				}
				break;
			case INT:
			case DOUBLE:
			case STRING:
			case TRUE:
			case FALSE:
				{
				_localctx = new LiteralExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(124);
				literal();
				}
				break;
			case ID:
				{
				_localctx = new IDExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(125);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(148);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(146);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new MultDivOpContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(128);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(129);
						((MultDivOpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 229376L) != 0)) ) {
							((MultDivOpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(130);
						expr(9);
						}
						break;
					case 2:
						{
						_localctx = new SumSubOpContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(131);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(132);
						((SumSubOpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==SUM || _la==SUB) ) {
							((SumSubOpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(133);
						expr(8);
						}
						break;
					case 3:
						{
						_localctx = new RelOpContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(134);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(135);
						((RelOpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3932160L) != 0)) ) {
							((RelOpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(136);
						expr(7);
						}
						break;
					case 4:
						{
						_localctx = new EqualsOpContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(137);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(138);
						((EqualsOpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQUALS || _la==N_EQUALS) ) {
							((EqualsOpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(139);
						expr(6);
						}
						break;
					case 5:
						{
						_localctx = new AndOpContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(140);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(141);
						((AndOpContext)_localctx).op = match(AND);
						setState(142);
						expr(5);
						}
						break;
					case 6:
						{
						_localctx = new OrOpContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(143);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(144);
						((OrOpContext)_localctx).op = match(OR);
						setState(145);
						expr(4);
						}
						break;
					}
					} 
				}
				setState(150);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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
	public static class LiteralContext extends ParserRuleContext {
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	 
		public LiteralContext() { }
		public void copyFrom(LiteralContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TrueContext extends LiteralContext {
		public TerminalNode TRUE() { return getToken(TugaParser.TRUE, 0); }
		public TrueContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterTrue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitTrue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitTrue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringContext extends LiteralContext {
		public TerminalNode STRING() { return getToken(TugaParser.STRING, 0); }
		public StringContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FalseContext extends LiteralContext {
		public TerminalNode FALSE() { return getToken(TugaParser.FALSE, 0); }
		public FalseContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterFalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitFalse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitFalse(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DoubleContext extends LiteralContext {
		public TerminalNode DOUBLE() { return getToken(TugaParser.DOUBLE, 0); }
		public DoubleContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterDouble(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitDouble(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitDouble(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntContext extends LiteralContext {
		public TerminalNode INT() { return getToken(TugaParser.INT, 0); }
		public IntContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).enterInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TugaListener ) ((TugaListener)listener).exitInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TugaVisitor ) return ((TugaVisitor<? extends T>)visitor).visitInt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_literal);
		try {
			setState(156);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new IntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(151);
				match(INT);
				}
				break;
			case DOUBLE:
				_localctx = new DoubleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(152);
				match(DOUBLE);
				}
				break;
			case STRING:
				_localctx = new StringContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(153);
				match(STRING);
				}
				break;
			case TRUE:
				_localctx = new TrueContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(154);
				match(TRUE);
				}
				break;
			case FALSE:
				_localctx = new FalseContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(155);
				match(FALSE);
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
		case 11:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 4);
		case 5:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001$\u009f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0001\u0000\u0005\u0000\u001c\b\u0000\n\u0000\f\u0000\u001f"+
		"\t\u0000\u0001\u0000\u0004\u0000\"\b\u0000\u000b\u0000\f\u0000#\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u00026\b\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0005\u0005C\b"+
		"\u0005\n\u0005\f\u0005F\t\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006V\b"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\\\b"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0003\bj\b\b\u0001\t\u0001\t\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0003\nr\b\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0003\u000b\u007f\b\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u0093\b\u000b"+
		"\n\u000b\f\u000b\u0096\t\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0003\f\u009d\b\f\u0001\f\u0000\u0001\u0016\r\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u0000\u0004\u0001\u0000\u000f"+
		"\u0011\u0001\u0000\r\u000e\u0001\u0000\u0012\u0015\u0001\u0000\u0016\u0017"+
		"\u00ac\u0000\u001d\u0001\u0000\u0000\u0000\u0002\'\u0001\u0000\u0000\u0000"+
		"\u00045\u0001\u0000\u0000\u0000\u00067\u0001\u0000\u0000\u0000\b;\u0001"+
		"\u0000\u0000\u0000\n@\u0001\u0000\u0000\u0000\fU\u0001\u0000\u0000\u0000"+
		"\u000e[\u0001\u0000\u0000\u0000\u0010i\u0001\u0000\u0000\u0000\u0012k"+
		"\u0001\u0000\u0000\u0000\u0014q\u0001\u0000\u0000\u0000\u0016~\u0001\u0000"+
		"\u0000\u0000\u0018\u009c\u0001\u0000\u0000\u0000\u001a\u001c\u0003\u0002"+
		"\u0001\u0000\u001b\u001a\u0001\u0000\u0000\u0000\u001c\u001f\u0001\u0000"+
		"\u0000\u0000\u001d\u001b\u0001\u0000\u0000\u0000\u001d\u001e\u0001\u0000"+
		"\u0000\u0000\u001e!\u0001\u0000\u0000\u0000\u001f\u001d\u0001\u0000\u0000"+
		"\u0000 \"\u0003\u0004\u0002\u0000! \u0001\u0000\u0000\u0000\"#\u0001\u0000"+
		"\u0000\u0000#!\u0001\u0000\u0000\u0000#$\u0001\u0000\u0000\u0000$%\u0001"+
		"\u0000\u0000\u0000%&\u0005\u0000\u0000\u0001&\u0001\u0001\u0000\u0000"+
		"\u0000\'(\u0003\u0014\n\u0000()\u0005\u0001\u0000\u0000)*\u0005 \u0000"+
		"\u0000*+\u0005\n\u0000\u0000+\u0003\u0001\u0000\u0000\u0000,6\u0003\u0006"+
		"\u0003\u0000-6\u0003\b\u0004\u0000.6\u0003\n\u0005\u0000/6\u0003\f\u0006"+
		"\u000001\u0003\f\u0006\u000012\u0003\u000e\u0007\u000026\u0001\u0000\u0000"+
		"\u000036\u0003\u0010\b\u000046\u0003\u0012\t\u00005,\u0001\u0000\u0000"+
		"\u00005-\u0001\u0000\u0000\u00005.\u0001\u0000\u0000\u00005/\u0001\u0000"+
		"\u0000\u000050\u0001\u0000\u0000\u000053\u0001\u0000\u0000\u000054\u0001"+
		"\u0000\u0000\u00006\u0005\u0001\u0000\u0000\u000078\u0005\u0002\u0000"+
		"\u000089\u0003\u0016\u000b\u00009:\u0005\n\u0000\u0000:\u0007\u0001\u0000"+
		"\u0000\u0000;<\u0005!\u0000\u0000<=\u0005\u0003\u0000\u0000=>\u0003\u0016"+
		"\u000b\u0000>?\u0005\n\u0000\u0000?\t\u0001\u0000\u0000\u0000@D\u0005"+
		"\u0004\u0000\u0000AC\u0003\u0004\u0002\u0000BA\u0001\u0000\u0000\u0000"+
		"CF\u0001\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000"+
		"\u0000EG\u0001\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000GH\u0005\u0005"+
		"\u0000\u0000H\u000b\u0001\u0000\u0000\u0000IJ\u0005\u0006\u0000\u0000"+
		"JK\u0005\u000b\u0000\u0000KL\u0003\u0016\u000b\u0000LM\u0005\f\u0000\u0000"+
		"MN\u0003\n\u0005\u0000NV\u0001\u0000\u0000\u0000OP\u0005\u0006\u0000\u0000"+
		"PQ\u0005\u000b\u0000\u0000QR\u0003\u0016\u000b\u0000RS\u0005\f\u0000\u0000"+
		"ST\u0003\u0004\u0002\u0000TV\u0001\u0000\u0000\u0000UI\u0001\u0000\u0000"+
		"\u0000UO\u0001\u0000\u0000\u0000V\r\u0001\u0000\u0000\u0000WX\u0005\u0007"+
		"\u0000\u0000X\\\u0003\n\u0005\u0000YZ\u0005\u0007\u0000\u0000Z\\\u0003"+
		"\u0004\u0002\u0000[W\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000"+
		"\\\u000f\u0001\u0000\u0000\u0000]^\u0005\b\u0000\u0000^_\u0005\u000b\u0000"+
		"\u0000_`\u0003\u0016\u000b\u0000`a\u0005\f\u0000\u0000ab\u0003\n\u0005"+
		"\u0000bj\u0001\u0000\u0000\u0000cd\u0005\b\u0000\u0000de\u0005\u000b\u0000"+
		"\u0000ef\u0003\u0016\u000b\u0000fg\u0005\f\u0000\u0000gh\u0003\u0004\u0002"+
		"\u0000hj\u0001\u0000\u0000\u0000i]\u0001\u0000\u0000\u0000ic\u0001\u0000"+
		"\u0000\u0000j\u0011\u0001\u0000\u0000\u0000kl\u0005\n\u0000\u0000l\u0013"+
		"\u0001\u0000\u0000\u0000mr\u0005!\u0000\u0000no\u0005!\u0000\u0000op\u0005"+
		"\t\u0000\u0000pr\u0003\u0014\n\u0000qm\u0001\u0000\u0000\u0000qn\u0001"+
		"\u0000\u0000\u0000r\u0015\u0001\u0000\u0000\u0000st\u0006\u000b\uffff"+
		"\uffff\u0000tu\u0005\u000b\u0000\u0000uv\u0003\u0016\u000b\u0000vw\u0005"+
		"\f\u0000\u0000w\u007f\u0001\u0000\u0000\u0000xy\u0005\u000e\u0000\u0000"+
		"y\u007f\u0003\u0016\u000b\nz{\u0005\u001a\u0000\u0000{\u007f\u0003\u0016"+
		"\u000b\t|\u007f\u0003\u0018\f\u0000}\u007f\u0005!\u0000\u0000~s\u0001"+
		"\u0000\u0000\u0000~x\u0001\u0000\u0000\u0000~z\u0001\u0000\u0000\u0000"+
		"~|\u0001\u0000\u0000\u0000~}\u0001\u0000\u0000\u0000\u007f\u0094\u0001"+
		"\u0000\u0000\u0000\u0080\u0081\n\b\u0000\u0000\u0081\u0082\u0007\u0000"+
		"\u0000\u0000\u0082\u0093\u0003\u0016\u000b\t\u0083\u0084\n\u0007\u0000"+
		"\u0000\u0084\u0085\u0007\u0001\u0000\u0000\u0085\u0093\u0003\u0016\u000b"+
		"\b\u0086\u0087\n\u0006\u0000\u0000\u0087\u0088\u0007\u0002\u0000\u0000"+
		"\u0088\u0093\u0003\u0016\u000b\u0007\u0089\u008a\n\u0005\u0000\u0000\u008a"+
		"\u008b\u0007\u0003\u0000\u0000\u008b\u0093\u0003\u0016\u000b\u0006\u008c"+
		"\u008d\n\u0004\u0000\u0000\u008d\u008e\u0005\u0018\u0000\u0000\u008e\u0093"+
		"\u0003\u0016\u000b\u0005\u008f\u0090\n\u0003\u0000\u0000\u0090\u0091\u0005"+
		"\u0019\u0000\u0000\u0091\u0093\u0003\u0016\u000b\u0004\u0092\u0080\u0001"+
		"\u0000\u0000\u0000\u0092\u0083\u0001\u0000\u0000\u0000\u0092\u0086\u0001"+
		"\u0000\u0000\u0000\u0092\u0089\u0001\u0000\u0000\u0000\u0092\u008c\u0001"+
		"\u0000\u0000\u0000\u0092\u008f\u0001\u0000\u0000\u0000\u0093\u0096\u0001"+
		"\u0000\u0000\u0000\u0094\u0092\u0001\u0000\u0000\u0000\u0094\u0095\u0001"+
		"\u0000\u0000\u0000\u0095\u0017\u0001\u0000\u0000\u0000\u0096\u0094\u0001"+
		"\u0000\u0000\u0000\u0097\u009d\u0005\u001b\u0000\u0000\u0098\u009d\u0005"+
		"\u001c\u0000\u0000\u0099\u009d\u0005\u001d\u0000\u0000\u009a\u009d\u0005"+
		"\u001e\u0000\u0000\u009b\u009d\u0005\u001f\u0000\u0000\u009c\u0097\u0001"+
		"\u0000\u0000\u0000\u009c\u0098\u0001\u0000\u0000\u0000\u009c\u0099\u0001"+
		"\u0000\u0000\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009c\u009b\u0001"+
		"\u0000\u0000\u0000\u009d\u0019\u0001\u0000\u0000\u0000\f\u001d#5DU[iq"+
		"~\u0092\u0094\u009c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}