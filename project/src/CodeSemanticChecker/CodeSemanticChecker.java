package CodeSemanticChecker;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;
import Tuga.*;

public class CodeSemanticChecker extends TugaBaseVisitor<Void>
{
	// @Override
	// public Void visitBinaryOp(TugaParser.BinaryOpContext ctx)
	// {
	// 	if (ctx.children)
	// 	visit(ctx.expr(0));
	// 	return null;
	// }

	@Override
	public Void visitMultDivOp(TugaParser.MultDivOpContext ctx)
	{
		System.out.println("Multiplication detected");
		TugaParser.BinaryOpContext parentContext = (TugaParser.BinaryOpContext)ctx.getParent();
		double leftValue = visit(parentContext.expr(0));
		System.out.println(visit(parentContext.expr(0)));
		// double x = visit(ctx.expr(0)) * visit(ctx.expr(1));
		return null;
	}

	// @Override
	// public Void visitSumSubOp(TugaParser.SumSubOpContext ctx)
	// {
	// 	double x = visit(ctx.expr(0)) + visit(ctx.expr(1));
	// 	return null;
	// }

	@Override
	public Void visitInt(TugaParser.IntContext ctx)
	{
		Integer.valueOf(ctx.INT().getText());
		return null;
	}
}
