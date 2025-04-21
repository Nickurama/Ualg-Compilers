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

public class TestLEvalVisitor {
    // a4 -visitor Expr.g4
    /** Visitor "calculator" */
    public static class EvalVisitor extends LExprBaseVisitor<Double> {

		@Override
        public Double visitPrimaryOp(LExprParser.PrimaryOpContext ctx) {
			if (ctx.op.getType() == LExprParser.MLT)
				return visit(ctx.e(0)) * visit(ctx.e(1));
			else if (ctx.op.getType() == LExprParser.DIV)
				return visit(ctx.e(0)) / visit(ctx.e(1));
			else
				throw new Error("Unknown operator");
        }

		@Override
        public Double visitSecondaryOp(LExprParser.SecondaryOpContext ctx) {
			if (ctx.op.getType() == LExprParser.ADD)
				return visit(ctx.e(0)) + visit(ctx.e(1));
			else if (ctx.op.getType() == LExprParser.SUB)
				return visit(ctx.e(0)) - visit(ctx.e(1));
			else
				throw new Error("Unknown operator");
        }

		@Override
        public Double visitPowerOp(LExprParser.PowerOpContext ctx) {
			return Math.pow(visit(ctx.e(0)), visit(ctx.e(1)));
        }

		@Override
        public Double visitParenExpr(LExprParser.ParenExprContext ctx) {
			return visit(ctx.e());
        }

		@Override
        public Double visitNegateOp(LExprParser.NegateOpContext ctx) {
			return - visit(ctx.e());
        }

		@Override
        public Double visitNum(LExprParser.NumContext ctx) {
			return Double.valueOf(ctx.NUM().getText());
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
            EvalVisitor evalVisitor = new EvalVisitor();
            double result = evalVisitor.visit(tree);
            System.out.println("visitor result = " + result);
        }
        catch (java.io.IOException e) {
            System.out.println(e);
        }
    }
}
