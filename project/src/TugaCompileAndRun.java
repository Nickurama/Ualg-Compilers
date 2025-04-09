import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

import Tuga.*;
import Types.*;
import SemanticAnalyser.*;
import ErrorListeners.*;

public class TugaCompileAndRun
{
	public static void main(String[] args) throws Exception
	{
		boolean showLexerErrors = true;
		boolean showParserErrors = true;
		boolean showSemanticErrors = true;

		String inputFile = null;
		if (args.length > 0)
			inputFile = args[0];
		InputStream is = System.in;

		try
		{
			if (inputFile != null)
				is = new FileInputStream(inputFile);
			CharStream input = CharStreams.fromStream(is);
			TugaErrorListener errorListener = new TugaErrorListener(showLexerErrors, showParserErrors, showSemanticErrors);

			TugaLexer lexer = new TugaLexer(input);
			lexer.removeErrorListeners();
			lexer.addErrorListener(errorListener);
			CommonTokenStream tokens = new CommonTokenStream(lexer);

			TugaParser parser = new TugaParser(tokens);
			parser.removeErrorListeners();
			parser.addErrorListener(errorListener);
			ParseTree tree = parser.tuga();

			ParseTreeProperty<TugaType> types = new ParseTreeProperty<TugaType>();
			TugaSemanticAnalyser semanticAnalyser = new TugaSemanticAnalyser(types);
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
