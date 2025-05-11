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
import types.symbols.*;
import vm.*;

public class TugaCompileAndRun
{
	public static final String BYTECODES_FILE = "bytecodes.bc";
	public static final String FLAG_TRACE = "-trace";
	public static final String FLAG_ASM = "-asm";
	public static final String FLAG_DIRECT = "-direct";
	public static final String FLAG_PARSE_ONLY = "-parse";
	public static final String FLAG_COMPILE_ONLY = "-compile";
	public static final String FLAG_RUN_ONLY = "-run";

	private static boolean showLexerErrors;
	private static boolean showParserErrors;
	private static boolean showTypeCheckingErrors;
	private static boolean showTrace;
	private static boolean showAsm;
	private static boolean isDirect;
	private static boolean dumps;
	private static boolean parseOnly;
	private static boolean compileOnly;
	private static boolean runOnly;

	public static void main(String[] args) throws Exception
	{
		showLexerErrors = false;
		showParserErrors = false;
		showTypeCheckingErrors = true;
		showTrace = false;
		showAsm = false;
		isDirect = false;
		dumps = true; // mooshak
		parseOnly = false;
		compileOnly = false;
		runOnly = false;

		String inputFile = null;
		if (args.length > 0)
		{
			inputFile = args[0];
			for (int i = 1; i < args.length; i++)
			{
				if (args[i].equals(FLAG_TRACE))
					showTrace = true;
				else if (args[i].equals(FLAG_ASM))
					showAsm = true;
				else if (args[i].equals(FLAG_ASM))
					isDirect = true;
				else if (args[i].equals(FLAG_PARSE_ONLY))
					parseOnly = true;
				else if (args[i].equals(FLAG_COMPILE_ONLY))
					compileOnly = true;
				else if (args[i].equals(FLAG_RUN_ONLY))
					runOnly = true;
			}
		}
		InputStream is = System.in;

		if ((parseOnly && (compileOnly || runOnly))
			|| (compileOnly && (parseOnly || runOnly))
			|| (runOnly && (parseOnly || compileOnly)))
			throw new IllegalStateException("The following are mutually exclusive: -compile -run -parse");

		try
		{
			byte[] bytecodes = null;
			if (!runOnly)
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
				HashMap<String, FunctionSymbol> functions = new HashMap<String, FunctionSymbol>();
				new FunctionCollector(functions).visit(tree);
				ParseTreeProperty<Type> types = new ParseTreeProperty<Type>();
				HashMap<String, Type> varTypes = new HashMap<String, Type>();
				SemanticAnalyser semanticAnalyser = new SemanticAnalyser(types, varTypes, functions);
				semanticAnalyser.removeErrorListeners();
				semanticAnalyser.addErrorListener(errorListener);
				semanticAnalyser.visit(tree);

				// Error handling
				errorListener.print();
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
				// if (errorListener.getNumSemanticErrors() > 0 && !showTypeCheckingErrors)
				if (errorListener.getNumSemanticErrors() > 0)
				{
					// System.out.println("Input has type checking errors");
					return;
				}

				if (parseOnly)
					return;

				// Code Generation
				CodeGen codeGen = new CodeGen(types, varTypes, functions);
				codeGen.visit(tree);
				if (showAsm)
					codeGen.dumpCode();
				bytecodes = codeGen.getBytecode();
				if (!isDirect)
					BytesIO.write(bytecodes, BYTECODES_FILE);
			}
			if (compileOnly)
				return;

			// Code Running (vm)
			if (!isDirect)
				bytecodes = BytesIO.read(BYTECODES_FILE);
			if (bytecodes == null)
				throw new IllegalStateException("Could not get bytecodes");
			VirtualMachine vm = new VirtualMachine(bytecodes, showTrace);
			if (dumps)
				runDumps(vm);
			vm.run();
		}
		catch (java.io.IOException e)
		{
			System.out.println(e);
		}
	}

	public static void runDumps(VirtualMachine vm)
	{
		System.out.println("*** Constant pool ***");
		vm.dumpConstantPool();
		System.out.println("*** Instructions ***");
		vm.dumpInstructions();
		System.out.println("*** VM output ***");
	}
}
