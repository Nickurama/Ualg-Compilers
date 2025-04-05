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


public class TestLEvaluatorWithProps {
    /** Sample "calculator" using property of nodes */
    public static class EvaluatorWithProps extends LExprBaseListener {
        /** maps nodes to integers with Map<ParseTree,Integer> */
        ParseTreeProperty<Double> values = new ParseTreeProperty<Double>();

        /** Need to pass e's value out of rule s : e ; */
		@Override
        public void exitS(LExprParser.SContext ctx) {
            setValue(ctx, getValue(ctx.e())); // like: int s() { return e(); }
        }

		@Override
        public void exitPrimaryOp(LExprParser.PrimaryOpContext ctx) {
            double left = getValue(ctx.e(0));
            double right = getValue(ctx.e(1));
			if (ctx.op.getType() == LExprParser.MLT)
				setValue(ctx, left * right);
			else if (ctx.op.getType() == LExprParser.DIV)
				setValue(ctx, left / right);
			else
				System.out.println("Unknown Operator");
        }

		@Override
        public void exitSecondaryOp(LExprParser.SecondaryOpContext ctx) {
            double left = getValue(ctx.e(0));
            double right = getValue(ctx.e(1));
			if (ctx.op.getType() == LExprParser.ADD)
				setValue(ctx, left + right);
			else if (ctx.op.getType() == LExprParser.SUB)
				setValue(ctx, left - right);
			else
				System.out.println("Unknown Operator");
        }

		@Override
        public void exitPowerOp(LExprParser.PowerOpContext ctx) {
            double left = getValue(ctx.e(0));
            double right = getValue(ctx.e(1));
			setValue(ctx, Math.pow(left, right));
        }

		@Override
        public void exitParenExpr(LExprParser.ParenExprContext ctx) {
			setValue(ctx, getValue(ctx.e()));
        }

		@Override
        public void exitNegateOp(LExprParser.NegateOpContext ctx) {
			setValue(ctx, -getValue(ctx.e()));
        }

		@Override
        public void exitNum(LExprParser.NumContext ctx) {
            String numText = ctx.NUM().getText();
            setValue(ctx, Double.valueOf(numText));
        }


        public void setValue(ParseTree node, double value) { values.put(node, value); }
        public double getValue(ParseTree node) { return values.get(node); }
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
            EvaluatorWithProps evalProp = new EvaluatorWithProps();
            walker.walk(evalProp, tree);
            System.out.println("properties result = " + evalProp.getValue(tree));
        }
        catch (java.io.IOException e) {
                System.out.println(e);
        }
    }

}
