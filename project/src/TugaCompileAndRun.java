import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

import Tuga.*;
import codegen.CodeGen;
import errorlisteners.*;
import io.BytesIO;
import semantic.*;
import types.*;
import vm.Instruction;
import vm.VirtualMachine;

public class TugaCompileAndRun
{
	public static final String BYTECODES_FILE = "bytecodes.bc";
	public static final String FLAG_TRACE = "-trace";
	public static final String FLAG_ASM = "-asm";
	public static final String FLAG_DIRECT = "-direct";

	private static boolean showLexerErrors;
	private static boolean showParserErrors;
	private static boolean showTypeCheckingErrors;
	private static boolean showTrace;
	private static boolean showAsm;
	private static boolean isDirect;

	public static void main(String[] args) throws Exception
	{
		showLexerErrors = true;
		showParserErrors = true;
		showTypeCheckingErrors = true;
		showTrace = false;
		showAsm = false;
		isDirect = false;

		String inputFile = null;
		if (args.length > 0)
		{
			inputFile = args[0];
			for (int i = 1; i < args.length; i++)
			{
				if (args[i].equals(FLAG_TRACE))
					showTrace = true;
				if (args[i].equals(FLAG_ASM))
					showAsm = true;
				if (args[i].equals(FLAG_ASM))
					isDirect = true;
			}
		}
		InputStream is = System.in;

		try
		{
			if (inputFile != null)
				is = new FileInputStream(inputFile);
			CharStream input = CharStreams.fromStream(is);
			TugaErrorListener errorListener = new TugaErrorListener(showLexerErrors, showParserErrors, showTypeCheckingErrors);

			// Lexer
			TugaLexer lexer = new TugaLexer(input);
			lexer.removeErrorListeners();
			lexer.addErrorListener(errorListener);
			CommonTokenStream tokens = new CommonTokenStream(lexer);

			// Parser
			TugaParser parser = new TugaParser(tokens);
			parser.removeErrorListeners();
			parser.addErrorListener(errorListener);
			ParseTree tree = parser.tuga();

			// Semantic Analyser
			ParseTreeProperty<Type> types = new ParseTreeProperty<Type>();
			SemanticAnalyser semanticAnalyser = new SemanticAnalyser(types);
			semanticAnalyser.removeErrorListeners();
			semanticAnalyser.addErrorListener(errorListener);
			semanticAnalyser.visit(tree);
			semanticAnalyser.findErrors(tree);

			// Error handling
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

			// Code Generation
			CodeGen codeGen = new CodeGen(types);
			codeGen.visit(tree);
			if (showAsm)
				codeGen.dumpCode();
			byte[] bytecodes = codeGen.getBytecode();
			if (!isDirect)
				BytesIO.write(bytecodes, BYTECODES_FILE);

			// Code Running (vm)
			if (!isDirect)
				bytecodes = BytesIO.read(BYTECODES_FILE);
			VirtualMachine vm = new VirtualMachine(bytecodes, showTrace);
			vm.run();
		}
		catch (java.io.IOException e)
		{
			System.out.println(e);
		}
	}
}
