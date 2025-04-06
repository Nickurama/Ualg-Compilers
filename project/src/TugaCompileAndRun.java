import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

import Tuga.*;
import CodeSemanticChecker.*;
// import CodeGenerator.*;
// import VirtualMachine.*;

public class TugaCompileAndRun
{
	public static void main(String[] args) throws Exception
	{
		boolean showLexerErrors = true;
		boolean showParserErrors = true;

		String inputFile = null;
		if ( args.length>0 ) inputFile = args[0];
		InputStream is = System.in;
		try
		{
			if (inputFile != null)
				is = new FileInputStream(inputFile);
			CharStream input = CharStreams.fromStream(is);
			MyErrorListener errorListener = new MyErrorListener(showLexerErrors, showParserErrors);

			TugaLexer lexer = new TugaLexer(input);
			lexer.removeErrorListeners();
			lexer.addErrorListener( errorListener );
			CommonTokenStream tokens = new CommonTokenStream(lexer);

			TugaParser parser = new TugaParser(tokens);
			parser.removeErrorListeners();
			parser.addErrorListener( errorListener );
			ParseTree tree = parser.tuga();

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

			CodeSemanticChecker semanticChecker = new CodeSemanticChecker();
			semanticChecker.visit(tree);
		}
		catch (java.io.IOException e)
		{
			System.out.println(e);
		}
	}
}
