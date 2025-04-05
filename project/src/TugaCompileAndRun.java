/***
 * Excerpted from "The Definitive ANTLR 4 Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.
***/
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

import Tuga.*;

public class TugaCompileAndRun
{
    public static class EvalVisitor extends TugaBaseVisitor<Integer>
	{
  //       public Integer visitMult(TugaParser.MultContext ctx)
		// {
  //           return visit(ctx.expr(0)) * visit(ctx.expr(1));
  //       }
		//
  //       public Integer visitAdd(TugaParser.AddContext ctx)
		// {
  //           return visit(ctx.expr(0)) + visit(ctx.expr(1));
  //       }
		//
  //       public Integer visitInt(TugaParser.IntContext ctx)
		// {
  //           return Integer.valueOf(ctx.INT().getText());
  //       }
    }

    public static void main(String[] args) throws Exception
	{
        boolean showLexerErrors = true;
        boolean showParserErrors = true;

        String inputFile = null;
        if ( args.length>0 ) inputFile = args[0];
        InputStream is = System.in;
        try
		{
            if (inputFile != null) is = new FileInputStream(inputFile);
            CharStream input = CharStreams.fromStream(is);
            /*
            TugaLexer lexer = new TugaLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            TugaParser parser = new TugaParser(tokens);
            ParseTree tree = parser.s();
             */

            //
            // add my own error listener
            //
            MyErrorListener errorListener = new MyErrorListener(showLexerErrors, showParserErrors);
            TugaLexer lexer = new TugaLexer(input);
            lexer.removeErrorListeners();
            lexer.addErrorListener( errorListener );
            CommonTokenStream tokens = new CommonTokenStream( lexer );
            TugaParser parser = new TugaParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener( errorListener );
            ParseTree tree = parser.tuga();
            if( errorListener.getNumLexerErrors() > 0 )
			{
                System.out.println("Input has lexical errors");
                return;
            }
            if( errorListener.getNumParsingErrors() > 0 )
			{
                System.out.println("Input has parsing errors");
                return;
            }

            EvalVisitor evalVisitor = new EvalVisitor();
            int result = evalVisitor.visit(tree);
            System.out.println("visitor result = " + result);
        }
        catch (java.io.IOException e)
		{
            System.out.println(e);
        }
    }
}
