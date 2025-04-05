// Generated from LExpr.g4 by ANTLR 4.13.2
package LExpr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class LExprParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		POW=1, MLT=2, DIV=3, ADD=4, SUB=5, LPAREN=6, RPAREN=7, NUM=8, WS=9;
	public static final int
		RULE_s = 0, RULE_e = 1;
	private static String[] makeRuleNames() {
		return new String[] {
			"s", "e"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'^'", "'*'", "'/'", "'+'", "'-'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "POW", "MLT", "DIV", "ADD", "SUB", "LPAREN", "RPAREN", "NUM", "WS"
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
	public String getGrammarFileName() { return "LExpr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LExprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SContext extends ParserRuleContext {
		public EContext e() {
			return getRuleContext(EContext.class,0);
		}
		public SContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_s; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LExprListener ) ((LExprListener)listener).enterS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LExprListener ) ((LExprListener)listener).exitS(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LExprVisitor ) return ((LExprVisitor<? extends T>)visitor).visitS(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SContext s() throws RecognitionException {
		SContext _localctx = new SContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_s);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4);
			e(0);
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
	public static class EContext extends ParserRuleContext {
		public EContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_e; }
	 
		public EContext() { }
		public void copyFrom(EContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryOpContext extends EContext {
		public Token op;
		public List<EContext> e() {
			return getRuleContexts(EContext.class);
		}
		public EContext e(int i) {
			return getRuleContext(EContext.class,i);
		}
		public TerminalNode MLT() { return getToken(LExprParser.MLT, 0); }
		public TerminalNode DIV() { return getToken(LExprParser.DIV, 0); }
		public PrimaryOpContext(EContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LExprListener ) ((LExprListener)listener).enterPrimaryOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LExprListener ) ((LExprListener)listener).exitPrimaryOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LExprVisitor ) return ((LExprVisitor<? extends T>)visitor).visitPrimaryOp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegateOpContext extends EContext {
		public TerminalNode SUB() { return getToken(LExprParser.SUB, 0); }
		public EContext e() {
			return getRuleContext(EContext.class,0);
		}
		public NegateOpContext(EContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LExprListener ) ((LExprListener)listener).enterNegateOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LExprListener ) ((LExprListener)listener).exitNegateOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LExprVisitor ) return ((LExprVisitor<? extends T>)visitor).visitNegateOp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SecondaryOpContext extends EContext {
		public Token op;
		public List<EContext> e() {
			return getRuleContexts(EContext.class);
		}
		public EContext e(int i) {
			return getRuleContext(EContext.class,i);
		}
		public TerminalNode ADD() { return getToken(LExprParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(LExprParser.SUB, 0); }
		public SecondaryOpContext(EContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LExprListener ) ((LExprListener)listener).enterSecondaryOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LExprListener ) ((LExprListener)listener).exitSecondaryOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LExprVisitor ) return ((LExprVisitor<? extends T>)visitor).visitSecondaryOp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumContext extends EContext {
		public TerminalNode NUM() { return getToken(LExprParser.NUM, 0); }
		public NumContext(EContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LExprListener ) ((LExprListener)listener).enterNum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LExprListener ) ((LExprListener)listener).exitNum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LExprVisitor ) return ((LExprVisitor<? extends T>)visitor).visitNum(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenExprContext extends EContext {
		public TerminalNode LPAREN() { return getToken(LExprParser.LPAREN, 0); }
		public EContext e() {
			return getRuleContext(EContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LExprParser.RPAREN, 0); }
		public ParenExprContext(EContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LExprListener ) ((LExprListener)listener).enterParenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LExprListener ) ((LExprListener)listener).exitParenExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LExprVisitor ) return ((LExprVisitor<? extends T>)visitor).visitParenExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PowerOpContext extends EContext {
		public List<EContext> e() {
			return getRuleContexts(EContext.class);
		}
		public EContext e(int i) {
			return getRuleContext(EContext.class,i);
		}
		public TerminalNode POW() { return getToken(LExprParser.POW, 0); }
		public PowerOpContext(EContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LExprListener ) ((LExprListener)listener).enterPowerOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LExprListener ) ((LExprListener)listener).exitPowerOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LExprVisitor ) return ((LExprVisitor<? extends T>)visitor).visitPowerOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EContext e() throws RecognitionException {
		return e(0);
	}

	private EContext e(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EContext _localctx = new EContext(_ctx, _parentState);
		EContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_e, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SUB:
				{
				_localctx = new NegateOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(7);
				match(SUB);
				setState(8);
				e(6);
				}
				break;
			case LPAREN:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(9);
				match(LPAREN);
				setState(10);
				e(0);
				setState(11);
				match(RPAREN);
				}
				break;
			case NUM:
				{
				_localctx = new NumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(13);
				match(NUM);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(27);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(25);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new PowerOpContext(new EContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_e);
						setState(16);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(17);
						match(POW);
						setState(18);
						e(4);
						}
						break;
					case 2:
						{
						_localctx = new PrimaryOpContext(new EContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_e);
						setState(19);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(20);
						((PrimaryOpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MLT || _la==DIV) ) {
							((PrimaryOpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(21);
						e(4);
						}
						break;
					case 3:
						{
						_localctx = new SecondaryOpContext(new EContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_e);
						setState(22);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(23);
						((SecondaryOpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((SecondaryOpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(24);
						e(3);
						}
						break;
					}
					} 
				}
				setState(29);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return e_sempred((EContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean e_sempred(EContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\t\u001f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u000f\b\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0005\u0001\u001a\b\u0001\n\u0001\f\u0001"+
		"\u001d\t\u0001\u0001\u0001\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0002"+
		"\u0001\u0000\u0002\u0003\u0001\u0000\u0004\u0005!\u0000\u0004\u0001\u0000"+
		"\u0000\u0000\u0002\u000e\u0001\u0000\u0000\u0000\u0004\u0005\u0003\u0002"+
		"\u0001\u0000\u0005\u0001\u0001\u0000\u0000\u0000\u0006\u0007\u0006\u0001"+
		"\uffff\uffff\u0000\u0007\b\u0005\u0005\u0000\u0000\b\u000f\u0003\u0002"+
		"\u0001\u0006\t\n\u0005\u0006\u0000\u0000\n\u000b\u0003\u0002\u0001\u0000"+
		"\u000b\f\u0005\u0007\u0000\u0000\f\u000f\u0001\u0000\u0000\u0000\r\u000f"+
		"\u0005\b\u0000\u0000\u000e\u0006\u0001\u0000\u0000\u0000\u000e\t\u0001"+
		"\u0000\u0000\u0000\u000e\r\u0001\u0000\u0000\u0000\u000f\u001b\u0001\u0000"+
		"\u0000\u0000\u0010\u0011\n\u0004\u0000\u0000\u0011\u0012\u0005\u0001\u0000"+
		"\u0000\u0012\u001a\u0003\u0002\u0001\u0004\u0013\u0014\n\u0003\u0000\u0000"+
		"\u0014\u0015\u0007\u0000\u0000\u0000\u0015\u001a\u0003\u0002\u0001\u0004"+
		"\u0016\u0017\n\u0002\u0000\u0000\u0017\u0018\u0007\u0001\u0000\u0000\u0018"+
		"\u001a\u0003\u0002\u0001\u0003\u0019\u0010\u0001\u0000\u0000\u0000\u0019"+
		"\u0013\u0001\u0000\u0000\u0000\u0019\u0016\u0001\u0000\u0000\u0000\u001a"+
		"\u001d\u0001\u0000\u0000\u0000\u001b\u0019\u0001\u0000\u0000\u0000\u001b"+
		"\u001c\u0001\u0000\u0000\u0000\u001c\u0003\u0001\u0000\u0000\u0000\u001d"+
		"\u001b\u0001\u0000\u0000\u0000\u0003\u000e\u0019\u001b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}