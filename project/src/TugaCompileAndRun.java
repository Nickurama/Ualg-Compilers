import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

import Tuga.*;
import errorlisteners.*;
import semantic.*;
import types.*;

public class TugaCompileAndRun
{
	public static final String FLAG_TRACE = "-trace";

	private static boolean showLexerErrors;
	private static boolean showParserErrors;
	private static boolean showTypeCheckingErrors;
	private static boolean showTrace;

	public static void main(String[] args) throws Exception
	{
		showLexerErrors = true;
		showParserErrors = true;
		showTypeCheckingErrors = true;
		showTrace = false;

		String inputFile = null;
		if (args.length > 0)
		{
			inputFile = args[0];
			for (int i = 1; i < args.length; i++)
			{
				if (args[i].equals(FLAG_TRACE))
					showTrace = true;
			}
		}
		InputStream is = System.in;

		try
		{
			if (inputFile != null)
				is = new FileInputStream(inputFile);
			CharStream input = CharStreams.fromStream(is);
			TugaErrorListener errorListener = new TugaErrorListener(showLexerErrors, showParserErrors, showTypeCheckingErrors);

			TugaLexer lexer = new TugaLexer(input);
			lexer.removeErrorListeners();
			lexer.addErrorListener(errorListener);
			CommonTokenStream tokens = new CommonTokenStream(lexer);

			TugaParser parser = new TugaParser(tokens);
			parser.removeErrorListeners();
			parser.addErrorListener(errorListener);
			ParseTree tree = parser.tuga();

			ParseTreeProperty<Type> types = new ParseTreeProperty<Type>();
			SemanticAnalyser semanticAnalyser = new SemanticAnalyser(types);
			semanticAnalyser.removeErrorListeners();
			semanticAnalyser.addErrorListener(errorListener);
			semanticAnalyser.visit(tree);
			semanticAnalyser.findErrors(tree);

			if (errorListener.getNumLexerErrors() > 0)
			{
				System.out.println("Input has lexical errors");
				return;
			}
			if (errorListener.getNumParsingErrors() > 0)
			{
				System.out.println("Input has parsing errors");
				return;
			}
			if (errorListener.getNumSemanticErrors() > 0)
			{
				System.out.println("Input has type checking errors");
				return;
			}
		}
		catch (java.io.IOException e)
		{
			System.out.println(e);
		}
	}
}
