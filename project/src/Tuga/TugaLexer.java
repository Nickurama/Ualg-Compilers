// Generated from Tuga.g4 by ANTLR 4.13.2
package Tuga;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class TugaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, END_INST=2, LPAREN=3, RPAREN=4, SUM=5, SUB=6, MLT=7, DIV=8, MOD=9, 
		LESS=10, GREATER=11, LESS_EQ=12, GREATER_EQ=13, EQUALS=14, N_EQUALS=15, 
		AND=16, OR=17, NOT=18, INT=19, DOUBLE=20, STRING=21, TRUE=22, FALSE=23, 
		WS=24, SL_COMMENT=25, ML_COMMENT=26;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "END_INST", "LPAREN", "RPAREN", "SUM", "SUB", "MLT", "DIV", "MOD", 
			"LESS", "GREATER", "LESS_EQ", "GREATER_EQ", "EQUALS", "N_EQUALS", "AND", 
			"OR", "NOT", "INT", "DOUBLE", "STRING", "TRUE", "FALSE", "WS", "SL_COMMENT", 
			"ML_COMMENT", "ALL_CHARS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'escreve'", "';'", "'('", "')'", "'+'", "'-'", "'*'", "'/'", "'%'", 
			"'<'", "'>'", "'<='", "'>='", "'igual'", "'diferente'", "'e'", "'ou'", 
			"'nao'", null, null, null, "'verdadeiro'", "'falso'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "END_INST", "LPAREN", "RPAREN", "SUM", "SUB", "MLT", "DIV", 
			"MOD", "LESS", "GREATER", "LESS_EQ", "GREATER_EQ", "EQUALS", "N_EQUALS", 
			"AND", "OR", "NOT", "INT", "DOUBLE", "STRING", "TRUE", "FALSE", "WS", 
			"SL_COMMENT", "ML_COMMENT"
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


	public TugaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Tuga.g4"; }

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
		"\u0004\u0000\u001a\u00c0\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f"+
		"\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0012\u0004\u0012t\b\u0012\u000b\u0012\f\u0012u\u0001\u0013"+
		"\u0004\u0013y\b\u0013\u000b\u0013\f\u0013z\u0001\u0013\u0001\u0013\u0004"+
		"\u0013\u007f\b\u0013\u000b\u0013\f\u0013\u0080\u0001\u0014\u0001\u0014"+
		"\u0004\u0014\u0085\b\u0014\u000b\u0014\f\u0014\u0086\u0001\u0014\u0001"+
		"\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0017\u0004\u0017\u009d\b\u0017\u000b\u0017\f\u0017\u009e\u0001\u0017"+
		"\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0005\u0018"+
		"\u00a7\b\u0018\n\u0018\f\u0018\u00aa\t\u0018\u0001\u0018\u0003\u0018\u00ad"+
		"\b\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0005\u0019\u00b5\b\u0019\n\u0019\f\u0019\u00b8\t\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a"+
		"\u0002\u00a8\u00b6\u0000\u001b\u0001\u0001\u0003\u0002\u0005\u0003\u0007"+
		"\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b"+
		"\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013"+
		"\'\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a5\u0000\u0001\u0000"+
		"\u0004\u0001\u000009\u0003\u0000\t\n\r\r  \u0001\u0001\n\n\u0004\u0000"+
		"  ==AZaz\u00c5\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000"+
		"\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000"+
		"\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%"+
		"\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001"+
		"\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000"+
		"\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u0000"+
		"3\u0001\u0000\u0000\u0000\u00017\u0001\u0000\u0000\u0000\u0003?\u0001"+
		"\u0000\u0000\u0000\u0005A\u0001\u0000\u0000\u0000\u0007C\u0001\u0000\u0000"+
		"\u0000\tE\u0001\u0000\u0000\u0000\u000bG\u0001\u0000\u0000\u0000\rI\u0001"+
		"\u0000\u0000\u0000\u000fK\u0001\u0000\u0000\u0000\u0011M\u0001\u0000\u0000"+
		"\u0000\u0013O\u0001\u0000\u0000\u0000\u0015Q\u0001\u0000\u0000\u0000\u0017"+
		"S\u0001\u0000\u0000\u0000\u0019V\u0001\u0000\u0000\u0000\u001bY\u0001"+
		"\u0000\u0000\u0000\u001d_\u0001\u0000\u0000\u0000\u001fi\u0001\u0000\u0000"+
		"\u0000!k\u0001\u0000\u0000\u0000#n\u0001\u0000\u0000\u0000%s\u0001\u0000"+
		"\u0000\u0000\'x\u0001\u0000\u0000\u0000)\u0082\u0001\u0000\u0000\u0000"+
		"+\u008a\u0001\u0000\u0000\u0000-\u0095\u0001\u0000\u0000\u0000/\u009c"+
		"\u0001\u0000\u0000\u00001\u00a2\u0001\u0000\u0000\u00003\u00b0\u0001\u0000"+
		"\u0000\u00005\u00be\u0001\u0000\u0000\u000078\u0005e\u0000\u000089\u0005"+
		"s\u0000\u00009:\u0005c\u0000\u0000:;\u0005r\u0000\u0000;<\u0005e\u0000"+
		"\u0000<=\u0005v\u0000\u0000=>\u0005e\u0000\u0000>\u0002\u0001\u0000\u0000"+
		"\u0000?@\u0005;\u0000\u0000@\u0004\u0001\u0000\u0000\u0000AB\u0005(\u0000"+
		"\u0000B\u0006\u0001\u0000\u0000\u0000CD\u0005)\u0000\u0000D\b\u0001\u0000"+
		"\u0000\u0000EF\u0005+\u0000\u0000F\n\u0001\u0000\u0000\u0000GH\u0005-"+
		"\u0000\u0000H\f\u0001\u0000\u0000\u0000IJ\u0005*\u0000\u0000J\u000e\u0001"+
		"\u0000\u0000\u0000KL\u0005/\u0000\u0000L\u0010\u0001\u0000\u0000\u0000"+
		"MN\u0005%\u0000\u0000N\u0012\u0001\u0000\u0000\u0000OP\u0005<\u0000\u0000"+
		"P\u0014\u0001\u0000\u0000\u0000QR\u0005>\u0000\u0000R\u0016\u0001\u0000"+
		"\u0000\u0000ST\u0005<\u0000\u0000TU\u0005=\u0000\u0000U\u0018\u0001\u0000"+
		"\u0000\u0000VW\u0005>\u0000\u0000WX\u0005=\u0000\u0000X\u001a\u0001\u0000"+
		"\u0000\u0000YZ\u0005i\u0000\u0000Z[\u0005g\u0000\u0000[\\\u0005u\u0000"+
		"\u0000\\]\u0005a\u0000\u0000]^\u0005l\u0000\u0000^\u001c\u0001\u0000\u0000"+
		"\u0000_`\u0005d\u0000\u0000`a\u0005i\u0000\u0000ab\u0005f\u0000\u0000"+
		"bc\u0005e\u0000\u0000cd\u0005r\u0000\u0000de\u0005e\u0000\u0000ef\u0005"+
		"n\u0000\u0000fg\u0005t\u0000\u0000gh\u0005e\u0000\u0000h\u001e\u0001\u0000"+
		"\u0000\u0000ij\u0005e\u0000\u0000j \u0001\u0000\u0000\u0000kl\u0005o\u0000"+
		"\u0000lm\u0005u\u0000\u0000m\"\u0001\u0000\u0000\u0000no\u0005n\u0000"+
		"\u0000op\u0005a\u0000\u0000pq\u0005o\u0000\u0000q$\u0001\u0000\u0000\u0000"+
		"rt\u0007\u0000\u0000\u0000sr\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000"+
		"\u0000us\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000v&\u0001\u0000"+
		"\u0000\u0000wy\u0007\u0000\u0000\u0000xw\u0001\u0000\u0000\u0000yz\u0001"+
		"\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000"+
		"{|\u0001\u0000\u0000\u0000|~\u0005.\u0000\u0000}\u007f\u0007\u0000\u0000"+
		"\u0000~}\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080"+
		"~\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081(\u0001"+
		"\u0000\u0000\u0000\u0082\u0084\u0005\"\u0000\u0000\u0083\u0085\u00035"+
		"\u001a\u0000\u0084\u0083\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000"+
		"\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000"+
		"\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088\u0089\u0005\"\u0000"+
		"\u0000\u0089*\u0001\u0000\u0000\u0000\u008a\u008b\u0005v\u0000\u0000\u008b"+
		"\u008c\u0005e\u0000\u0000\u008c\u008d\u0005r\u0000\u0000\u008d\u008e\u0005"+
		"d\u0000\u0000\u008e\u008f\u0005a\u0000\u0000\u008f\u0090\u0005d\u0000"+
		"\u0000\u0090\u0091\u0005e\u0000\u0000\u0091\u0092\u0005i\u0000\u0000\u0092"+
		"\u0093\u0005r\u0000\u0000\u0093\u0094\u0005o\u0000\u0000\u0094,\u0001"+
		"\u0000\u0000\u0000\u0095\u0096\u0005f\u0000\u0000\u0096\u0097\u0005a\u0000"+
		"\u0000\u0097\u0098\u0005l\u0000\u0000\u0098\u0099\u0005s\u0000\u0000\u0099"+
		"\u009a\u0005o\u0000\u0000\u009a.\u0001\u0000\u0000\u0000\u009b\u009d\u0007"+
		"\u0001\u0000\u0000\u009c\u009b\u0001\u0000\u0000\u0000\u009d\u009e\u0001"+
		"\u0000\u0000\u0000\u009e\u009c\u0001\u0000\u0000\u0000\u009e\u009f\u0001"+
		"\u0000\u0000\u0000\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0\u00a1\u0006"+
		"\u0017\u0000\u0000\u00a10\u0001\u0000\u0000\u0000\u00a2\u00a3\u0005/\u0000"+
		"\u0000\u00a3\u00a4\u0005/\u0000\u0000\u00a4\u00a8\u0001\u0000\u0000\u0000"+
		"\u00a5\u00a7\t\u0000\u0000\u0000\u00a6\u00a5\u0001\u0000\u0000\u0000\u00a7"+
		"\u00aa\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000\u0000\u00a8"+
		"\u00a6\u0001\u0000\u0000\u0000\u00a9\u00ac\u0001\u0000\u0000\u0000\u00aa"+
		"\u00a8\u0001\u0000\u0000\u0000\u00ab\u00ad\u0007\u0002\u0000\u0000\u00ac"+
		"\u00ab\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000\u00ae"+
		"\u00af\u0006\u0018\u0000\u0000\u00af2\u0001\u0000\u0000\u0000\u00b0\u00b1"+
		"\u0005/\u0000\u0000\u00b1\u00b2\u0005*\u0000\u0000\u00b2\u00b6\u0001\u0000"+
		"\u0000\u0000\u00b3\u00b5\t\u0000\u0000\u0000\u00b4\u00b3\u0001\u0000\u0000"+
		"\u0000\u00b5\u00b8\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000"+
		"\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b7\u00b9\u0001\u0000\u0000"+
		"\u0000\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b9\u00ba\u0005*\u0000\u0000"+
		"\u00ba\u00bb\u0005/\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000\u0000\u00bc"+
		"\u00bd\u0006\u0019\u0000\u0000\u00bd4\u0001\u0000\u0000\u0000\u00be\u00bf"+
		"\u0007\u0003\u0000\u0000\u00bf6\u0001\u0000\u0000\u0000\t\u0000uz\u0080"+
		"\u0086\u009e\u00a8\u00ac\u00b6\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}