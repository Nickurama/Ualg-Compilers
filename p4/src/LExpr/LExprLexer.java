// Generated from LExpr.g4 by ANTLR 4.13.2
package LExpr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class LExprLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		POW=1, MLT=2, DIV=3, ADD=4, SUB=5, LPAREN=6, RPAREN=7, NUM=8, WS=9;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"POW", "MLT", "DIV", "ADD", "SUB", "LPAREN", "RPAREN", "NUM", "WS", "DIGIT"
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


	public LExprLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LExpr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\t>\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0004\u0007%\b\u0007\u000b\u0007\f\u0007&\u0001\u0007\u0004\u0007"+
		"*\b\u0007\u000b\u0007\f\u0007+\u0001\u0007\u0001\u0007\u0004\u00070\b"+
		"\u0007\u000b\u0007\f\u00071\u0003\u00074\b\u0007\u0001\b\u0004\b7\b\b"+
		"\u000b\b\f\b8\u0001\b\u0001\b\u0001\t\u0001\t\u0000\u0000\n\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\u0000\u0001\u0000\u0002\u0002\u0000\t\n  \u0001\u0000"+
		"09A\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000"+
		"\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000"+
		"\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000"+
		"\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000"+
		"\u0011\u0001\u0000\u0000\u0000\u0001\u0015\u0001\u0000\u0000\u0000\u0003"+
		"\u0017\u0001\u0000\u0000\u0000\u0005\u0019\u0001\u0000\u0000\u0000\u0007"+
		"\u001b\u0001\u0000\u0000\u0000\t\u001d\u0001\u0000\u0000\u0000\u000b\u001f"+
		"\u0001\u0000\u0000\u0000\r!\u0001\u0000\u0000\u0000\u000f3\u0001\u0000"+
		"\u0000\u0000\u00116\u0001\u0000\u0000\u0000\u0013<\u0001\u0000\u0000\u0000"+
		"\u0015\u0016\u0005^\u0000\u0000\u0016\u0002\u0001\u0000\u0000\u0000\u0017"+
		"\u0018\u0005*\u0000\u0000\u0018\u0004\u0001\u0000\u0000\u0000\u0019\u001a"+
		"\u0005/\u0000\u0000\u001a\u0006\u0001\u0000\u0000\u0000\u001b\u001c\u0005"+
		"+\u0000\u0000\u001c\b\u0001\u0000\u0000\u0000\u001d\u001e\u0005-\u0000"+
		"\u0000\u001e\n\u0001\u0000\u0000\u0000\u001f \u0005(\u0000\u0000 \f\u0001"+
		"\u0000\u0000\u0000!\"\u0005)\u0000\u0000\"\u000e\u0001\u0000\u0000\u0000"+
		"#%\u0003\u0013\t\u0000$#\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000\u0000"+
		"&$\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000\'4\u0001\u0000\u0000"+
		"\u0000(*\u0003\u0013\t\u0000)(\u0001\u0000\u0000\u0000*+\u0001\u0000\u0000"+
		"\u0000+)\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,-\u0001\u0000"+
		"\u0000\u0000-/\u0005.\u0000\u0000.0\u0003\u0013\t\u0000/.\u0001\u0000"+
		"\u0000\u000001\u0001\u0000\u0000\u00001/\u0001\u0000\u0000\u000012\u0001"+
		"\u0000\u0000\u000024\u0001\u0000\u0000\u00003$\u0001\u0000\u0000\u0000"+
		"3)\u0001\u0000\u0000\u00004\u0010\u0001\u0000\u0000\u000057\u0007\u0000"+
		"\u0000\u000065\u0001\u0000\u0000\u000078\u0001\u0000\u0000\u000086\u0001"+
		"\u0000\u0000\u000089\u0001\u0000\u0000\u00009:\u0001\u0000\u0000\u0000"+
		":;\u0006\b\u0000\u0000;\u0012\u0001\u0000\u0000\u0000<=\u0007\u0001\u0000"+
		"\u0000=\u0014\u0001\u0000\u0000\u0000\u0006\u0000&+138\u0001\u0006\u0000"+
		"\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}