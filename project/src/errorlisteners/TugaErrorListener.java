package errorlisteners;

import org.antlr.v4.runtime.*;
import java.util.*;

public class TugaErrorListener extends BaseErrorListener
{
    private boolean showLexerErrors;
    private boolean showParserErrors;
    private boolean showSemanticErrors;
    private int numLexerErrors;
    private int numParsingErrors;
    private int numSemanticErrors;

	private PriorityQueue<Integer> lines;
	private HashMap<Integer, ArrayList<String>> errors;

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

		this.lines = new PriorityQueue<Integer>();
		this.errors = new HashMap<Integer, ArrayList<String>>();
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
					addError(line, "erro na linha " + line + ": " + msg);
					// System.out.println("erro na linha " + line + ": " + msg);
					// System.out.printf("line %d:%d error: %s\n", line, charPositionInLine, msg);
				break;
			case ErrorType.PARSER:
				this.numParsingErrors++;
				if (this.showParserErrors)
					addError(line, "erro na linha " + line + ": " + msg);
					// System.out.println("erro na linha " + line + ": " + msg);
					// System.out.printf("line %d:%d error: %s\n", line, charPositionInLine, msg);
				break;
			case ErrorType.SEMANTIC:
				this.numSemanticErrors++;
				if (this.showSemanticErrors)
					addError(line, "erro na linha " + line + ": " + msg);
					// System.out.println("erro na linha " + line + ": " + msg);
					// System.out.printf("line %d:%d error: %s\n", line, charPositionInLine, msg);
				break;
			default:
				throw new IllegalStateException("Cannot have a syntax error of unknown type");
		}
	}

	private void addError(int line, String msg)
	{
		this.lines.add(line);
		if (this.errors.get(line) == null)
			this.errors.put(line, new ArrayList<String>());

		ArrayList<String> lineErrors = this.errors.get(line);
		lineErrors.add(msg);
	}

	public void print()
	{
		while (lines.size() > 0)
		{
			int line = this.lines.remove();
			while (this.lines.peek() != null && this.lines.peek() == line)
				this.lines.remove();
			ArrayList<String> lineErrors = this.errors.get(line);
			for (String error : lineErrors)
				System.out.println(error);
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

