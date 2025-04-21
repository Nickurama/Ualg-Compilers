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
import LExpr.*;

public class TestLEvaluator {
    /** Sample "calculator" */
    public static class Evaluator extends LExprBaseListener {
        Stack<Double> stack = new Stack<Double>();

		@Override
        public void exitPrimaryOp(LExprParser.PrimaryOpContext ctx) {
            double right = stack.pop();
            double left = stack.pop();
			if (ctx.op.getType() == LExprParser.MLT)
				stack.push(left * right);
			else if (ctx.op.getType() == LExprParser.DIV)
				stack.push(left / right);
			else
				System.out.println("Unknown operator");
        }

		@Override
        public void exitSecondaryOp(LExprParser.SecondaryOpContext ctx) {
            double right = stack.pop();
            double left = stack.pop();
			if (ctx.op.getType() == LExprParser.ADD)
				stack.push(left + right);
			else if (ctx.op.getType() == LExprParser.SUB)
				stack.push(left - right);
			else
				System.out.println("Unknown operator");
        }

		@Override
        public void exitPowerOp(LExprParser.PowerOpContext ctx) {
            double right = stack.pop();
            double left = stack.pop();
			stack.push(Math.pow(left, right));
        }

		@Override
        public void exitNegateOp(LExprParser.NegateOpContext ctx) {
            double num = stack.pop();
			stack.push(-num);
        }

		@Override
        public void exitNum(LExprParser.NumContext ctx) {
            stack.push(Double.valueOf(ctx.NUM().getText()));
        }
    }

    public static void main(String[] args) throws Exception {
        String inputFile = null;
        if ( args.length>0 ) inputFile = args[0];
        InputStream is = System.in;
        try {
            if (inputFile != null) is = new FileInputStream(inputFile);
            CharStream input = CharStreams.fromStream(is);
            LExprLexer lexer = new LExprLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            LExprParser parser = new LExprParser(tokens);
            ParseTree tree = parser.s();
            ParseTreeWalker walker = new ParseTreeWalker();
            Evaluator eval = new Evaluator();
            walker.walk(eval, tree);
            System.out.println("stack result = " + eval.stack.pop());
        }
        catch (java.io.IOException e) {
            System.out.println(e);
        }
    }
}
