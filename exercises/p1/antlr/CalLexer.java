// Generated from Cal.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class CalLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ASSIGN=1, PLUS=2, MINUS=3, TIMES=4, DIV=5, LPAREN=6, RPAREN=7, READ=8, 
		WRITE=9, ID=10, NUMBER=11, WS=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"ASSIGN", "PLUS", "MINUS", "TIMES", "DIV", "LPAREN", "RPAREN", "READ", 
			"WRITE", "ID", "NUMBER", "WS", "DIGIT", "LETTER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'+'", "'-'", "'*'", "'/'", "'('", "')'", "'read'", "'write'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ASSIGN", "PLUS", "MINUS", "TIMES", "DIV", "LPAREN", "RPAREN", 
			"READ", "WRITE", "ID", "NUMBER", "WS"
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


	public CalLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Cal.g4"; }

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
		"\u0004\u0000\fc\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0005\t:\b\t"+
		"\n\t\f\t=\t\t\u0001\n\u0004\n@\b\n\u000b\n\f\nA\u0001\n\u0005\nE\b\n\n"+
		"\n\f\nH\t\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\nO\b\n\u0001"+
		"\n\u0005\nR\b\n\n\n\f\nU\t\n\u0003\nW\b\n\u0001\u000b\u0004\u000bZ\b\u000b"+
		"\u000b\u000b\f\u000b[\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r"+
		"\u0001\r\u0000\u0000\u000e\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004"+
		"\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017"+
		"\f\u0019\u0000\u001b\u0000\u0001\u0000\u0003\u0003\u0000\t\n\r\r  \u0001"+
		"\u000009\u0002\u0000AZazh\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003"+
		"\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007"+
		"\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001"+
		"\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000"+
		"\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000"+
		"\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000"+
		"\u0000\u0000\u0001\u001d\u0001\u0000\u0000\u0000\u0003\u001f\u0001\u0000"+
		"\u0000\u0000\u0005!\u0001\u0000\u0000\u0000\u0007#\u0001\u0000\u0000\u0000"+
		"\t%\u0001\u0000\u0000\u0000\u000b\'\u0001\u0000\u0000\u0000\r)\u0001\u0000"+
		"\u0000\u0000\u000f+\u0001\u0000\u0000\u0000\u00110\u0001\u0000\u0000\u0000"+
		"\u00136\u0001\u0000\u0000\u0000\u0015V\u0001\u0000\u0000\u0000\u0017Y"+
		"\u0001\u0000\u0000\u0000\u0019_\u0001\u0000\u0000\u0000\u001ba\u0001\u0000"+
		"\u0000\u0000\u001d\u001e\u0005=\u0000\u0000\u001e\u0002\u0001\u0000\u0000"+
		"\u0000\u001f \u0005+\u0000\u0000 \u0004\u0001\u0000\u0000\u0000!\"\u0005"+
		"-\u0000\u0000\"\u0006\u0001\u0000\u0000\u0000#$\u0005*\u0000\u0000$\b"+
		"\u0001\u0000\u0000\u0000%&\u0005/\u0000\u0000&\n\u0001\u0000\u0000\u0000"+
		"\'(\u0005(\u0000\u0000(\f\u0001\u0000\u0000\u0000)*\u0005)\u0000\u0000"+
		"*\u000e\u0001\u0000\u0000\u0000+,\u0005r\u0000\u0000,-\u0005e\u0000\u0000"+
		"-.\u0005a\u0000\u0000./\u0005d\u0000\u0000/\u0010\u0001\u0000\u0000\u0000"+
		"01\u0005w\u0000\u000012\u0005r\u0000\u000023\u0005i\u0000\u000034\u0005"+
		"t\u0000\u000045\u0005e\u0000\u00005\u0012\u0001\u0000\u0000\u00006;\u0003"+
		"\u001b\r\u00007:\u0003\u001b\r\u00008:\u0003\u0019\f\u000097\u0001\u0000"+
		"\u0000\u000098\u0001\u0000\u0000\u0000:=\u0001\u0000\u0000\u0000;9\u0001"+
		"\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<\u0014\u0001\u0000\u0000"+
		"\u0000=;\u0001\u0000\u0000\u0000>@\u0003\u0019\f\u0000?>\u0001\u0000\u0000"+
		"\u0000@A\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000AB\u0001\u0000"+
		"\u0000\u0000BW\u0001\u0000\u0000\u0000CE\u0003\u0019\f\u0000DC\u0001\u0000"+
		"\u0000\u0000EH\u0001\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000FG\u0001"+
		"\u0000\u0000\u0000GN\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000"+
		"IJ\u0005.\u0000\u0000JO\u0003\u0019\f\u0000KL\u0003\u0019\f\u0000LM\u0005"+
		".\u0000\u0000MO\u0001\u0000\u0000\u0000NI\u0001\u0000\u0000\u0000NK\u0001"+
		"\u0000\u0000\u0000OS\u0001\u0000\u0000\u0000PR\u0003\u0019\f\u0000QP\u0001"+
		"\u0000\u0000\u0000RU\u0001\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000"+
		"ST\u0001\u0000\u0000\u0000TW\u0001\u0000\u0000\u0000US\u0001\u0000\u0000"+
		"\u0000V?\u0001\u0000\u0000\u0000VF\u0001\u0000\u0000\u0000W\u0016\u0001"+
		"\u0000\u0000\u0000XZ\u0007\u0000\u0000\u0000YX\u0001\u0000\u0000\u0000"+
		"Z[\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000"+
		"\u0000\\]\u0001\u0000\u0000\u0000]^\u0006\u000b\u0000\u0000^\u0018\u0001"+
		"\u0000\u0000\u0000_`\u0007\u0001\u0000\u0000`\u001a\u0001\u0000\u0000"+
		"\u0000ab\u0007\u0002\u0000\u0000b\u001c\u0001\u0000\u0000\u0000\t\u0000"+
		"9;AFNSV[\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}