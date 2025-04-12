package errorlisteners;

import org.antlr.v4.runtime.*;

public class TugaErrorListener extends BaseErrorListener
{
    private boolean showLexerErrors;
    private boolean showParserErrors;
    private boolean showSemanticErrors;
    private int numLexerErrors;
    private int numParsingErrors;
    private int numSemanticErrors;

	public enum ErrorType
	{
		UNKNOWN,
		LEXER,
		PARSER,
		SEMANTIC,
	}

    public TugaErrorListener(boolean showLexerErrors, boolean showParserErrors, boolean showSemanticErrors)
	{
        super();

		this.numLexerErrors = 0;
		this.numParsingErrors = 0;
		this.numSemanticErrors = 0;

        this.showLexerErrors = showLexerErrors;
        this.showParserErrors = showParserErrors;
        this.showSemanticErrors = showSemanticErrors;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line,
							int charPositionInLine,
                            String msg,
                            RecognitionException e)
    {
		ErrorType eType = ErrorType.UNKNOWN;
        if (recognizer instanceof Lexer)
			eType = ErrorType.LEXER;
		else if (recognizer instanceof Parser)
			eType = ErrorType.PARSER;
		syntaxError(eType, line, charPositionInLine, msg);
    }

	public void syntaxError(ErrorType eType, int line, int charPositionInLine, String msg)
	{
		switch (eType)
		{
			case ErrorType.LEXER:
				this.numLexerErrors++;
				if (this.showLexerErrors)
					System.err.printf("line %d:%d error: %s\n", line, charPositionInLine, msg);
				break;
			case ErrorType.PARSER:
				this.numParsingErrors++;
				if (this.showParserErrors)
					System.err.printf("line %d:%d error: %s\n", line, charPositionInLine, msg);
				break;
			case ErrorType.SEMANTIC:
				this.numSemanticErrors++;
				if (this.showSemanticErrors)
					System.err.printf("line %d:%d error: %s\n", line, charPositionInLine, msg);
				break;
			default:
				throw new IllegalStateException("Cannot have a syntax error of unknown type");
		}
	}

    public int getNumLexerErrors()
	{
        return this.numLexerErrors;
    }

    public int getNumParsingErrors()
	{
        return this.numParsingErrors;
    }

    public int getNumSemanticErrors()
	{
        return this.numSemanticErrors;
    }
}

