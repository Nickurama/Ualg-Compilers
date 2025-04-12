package semantic;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

import Tuga.*;
import errorlisteners.*;
import types.*;

public class SemanticAnalyser extends TugaBaseVisitor<Type>
{
	private ParseTreeProperty<Type> types;
	private ArrayList<TugaErrorListener> listeners;
	private ParseTree tree;

	public SemanticAnalyser(ParseTreeProperty<Type> types)
	{
		this.types = types;
		this.listeners = new ArrayList<TugaErrorListener>();
	}

	@Override
	public Type visitBinaryOp(TugaParser.BinaryOpContext ctx)
	{
		Type result = visit(ctx.binary_op());
		types.put(ctx, result);
		return result;
	}

	@Override
	public Type visitUnaryOp(TugaParser.UnaryOpContext ctx)
	{
		Type result = visit(ctx.unary_op());
		types.put(ctx, result);
		return result;
	}

	@Override
	public Type visitParenExpr(TugaParser.ParenExprContext ctx)
	{
		Type result = visit(ctx.expr());
		types.put(ctx, result);
		return result;
	}

	@Override
	public Type visitLiteralExpr(TugaParser.LiteralExprContext ctx)
	{
		Type result = visit(ctx.literal());
		types.put(ctx, result);
		return result;
	}

	@Override
	public Type visitMultDivOp(TugaParser.MultDivOpContext ctx)
	{
		TugaParser.BinaryOpContext parentContext = (TugaParser.BinaryOpContext)ctx.getParent();
		Type leftType = visit(parentContext.expr(0));
		Type rightType = visit(parentContext.expr(1));

		if (!leftType.isNumerical() || !rightType.isNumerical())
		{
			types.put(ctx, Type.ERROR);
			return Type.ERROR;
		}

		if (leftType == Type.INT && rightType == Type.INT)
		{
			types.put(ctx, Type.INT);
			return Type.INT;
		}

		if (ctx.op.getType() == TugaParser.MOD)
		{
			types.put(ctx, Type.ERROR);
			return Type.ERROR;
		}

		types.put(ctx, Type.DOUBLE);
		return Type.DOUBLE;
	}

	@Override
	public Type visitSumSubOp(TugaParser.SumSubOpContext ctx)
	{
		TugaParser.BinaryOpContext parentContext = (TugaParser.BinaryOpContext)ctx.getParent();
		Type leftType = visit(parentContext.expr(0));
		Type rightType = visit(parentContext.expr(1));

		if (ctx.op.getType() == TugaParser.SUM && (leftType == Type.STRING || rightType == Type.STRING))
		{
			types.put(ctx, Type.STRING);
			return Type.STRING;
		}

		if (!leftType.isNumerical() || !rightType.isNumerical())
		{
			types.put(ctx, Type.ERROR);
			return Type.ERROR;
		}

		if (leftType == Type.DOUBLE || rightType == Type.DOUBLE)
		{
			types.put(ctx, Type.DOUBLE);
			return Type.DOUBLE;
		}

		types.put(ctx, Type.INT);
		return Type.INT;
	}

	@Override
	public Type visitAndOp(TugaParser.AndOpContext ctx)
	{
		TugaParser.BinaryOpContext parentContext = (TugaParser.BinaryOpContext)ctx.getParent();
		Type leftType = visit(parentContext.expr(0));
		Type rightType = visit(parentContext.expr(1));

		if (leftType != Type.BOOL || rightType != Type.BOOL)
		{
			types.put(ctx, Type.ERROR);
			return Type.ERROR;
		}

		types.put(ctx, Type.BOOL);
		return Type.BOOL;
	}

	@Override
	public Type visitOrOp(TugaParser.OrOpContext ctx)
	{
		TugaParser.BinaryOpContext parentContext = (TugaParser.BinaryOpContext)ctx.getParent();
		Type leftType = visit(parentContext.expr(0));
		Type rightType = visit(parentContext.expr(1));

		if (leftType != Type.BOOL || rightType != Type.BOOL)
		{
			types.put(ctx, Type.ERROR);
			return Type.ERROR;
		}

		types.put(ctx, Type.BOOL);
		return Type.BOOL;
	}

	@Override
	public Type visitRelOp(TugaParser.RelOpContext ctx)
	{
		TugaParser.BinaryOpContext parentContext = (TugaParser.BinaryOpContext)ctx.getParent();
		Type leftType = visit(parentContext.expr(0));
		Type rightType = visit(parentContext.expr(1));

		if (!leftType.isNumerical() || !rightType.isNumerical())
		{
			types.put(ctx, Type.ERROR);
			return Type.ERROR;
		}

		types.put(ctx, Type.BOOL);
		return Type.BOOL;
	}

	@Override
	public Type visitEqualsOp(TugaParser.EqualsOpContext ctx)
	{
		TugaParser.BinaryOpContext parentContext = (TugaParser.BinaryOpContext)ctx.getParent();
		Type leftType = visit(parentContext.expr(0));
		Type rightType = visit(parentContext.expr(1));

		if (leftType.isNumerical() && rightType.isNumerical())
		{
			types.put(ctx, Type.BOOL);
			return Type.BOOL;
		}

		if (leftType == Type.STRING && rightType == Type.STRING)
		{
			types.put(ctx, Type.BOOL);
			return Type.BOOL;
		}

		if (leftType == Type.BOOL && rightType == Type.BOOL)
		{
			types.put(ctx, Type.BOOL);
			return Type.BOOL;
		}

		types.put(ctx, Type.ERROR);
		return Type.ERROR;
	}

	@Override
	public Type visitArithmeticNegateOp(TugaParser.ArithmeticNegateOpContext ctx)
	{
		TugaParser.UnaryOpContext parentContext = (TugaParser.UnaryOpContext)ctx.getParent();
		Type type = visit(parentContext.expr());

		if (type == Type.INT || type == Type.DOUBLE)
		{
			types.put(ctx, type);
			return type;
		}

		types.put(ctx, Type.ERROR);
		return Type.ERROR;
	}

	@Override
	public Type visitLogicNegateOp(TugaParser.LogicNegateOpContext ctx)
	{
		TugaParser.UnaryOpContext parentContext = (TugaParser.UnaryOpContext)ctx.getParent();
		Type type = visit(parentContext.expr());

		if (type == Type.BOOL)
		{
			types.put(ctx, type);
			return type;
		}

		types.put(ctx, Type.ERROR);
		return Type.ERROR;
	}

	@Override
	public Type visitInt(TugaParser.IntContext ctx)
	{
		return Type.INT;
	}

	@Override
	public Type visitString(TugaParser.StringContext ctx)
	{
		return Type.STRING;
	}

	@Override
	public Type visitDouble(TugaParser.DoubleContext ctx)
	{
		return Type.DOUBLE;
	}

	@Override
	public Type visitTrue(TugaParser.TrueContext ctx)
	{
		return Type.BOOL;
	}

	@Override
	public Type visitFalse(TugaParser.FalseContext ctx)
	{
		return Type.BOOL;
	}

	public void findErrors(ParseTree node)
	{
		if (this.types.get(node) == Type.ERROR && node instanceof TugaParser.ExprContext && !doChildrenHaveErrors(node))
			raiseError((TugaParser.ExprContext)node);

		for (int i = 0; i < node.getChildCount(); i++) // dfs
			findErrors(node.getChild(i));
	}

	public boolean doChildrenHaveErrors(ParseTree node)
	{
		for (int i = 0; i < node.getChildCount(); i++)
		{
			ParseTree child = node.getChild(i);
			if (this.types.get(child) == Type.ERROR && child instanceof TugaParser.ExprContext)
				return true;
		}
		return false;
	}

	public void addErrorListener(TugaErrorListener listener)
	{
		if (listener == null)
		{
			throw new NullPointerException("listener cannot be null.");
		}
		else
		{
			this.listeners.add(listener);
		}
	}
	
	public void removeErrorListeners()
	{
		if (!this.listeners.isEmpty())
			this.listeners = new ArrayList<TugaErrorListener>();
	}

	private void raiseError(TugaParser.ExprContext node)
	{
		int line = 0;
		int charPositionInLine = 0;
		String msg = "";
		String text = "";

		if (node instanceof TugaParser.UnaryOpContext)
		{
			TugaParser.UnaryOpContext ctx = (TugaParser.UnaryOpContext)node;
			line = ctx.getStart().getLine();
			charPositionInLine = ctx.getStart().getCharPositionInLine();
			text = getOriginalText(ctx);
		}
		else if (node instanceof TugaParser.BinaryOpContext)
		{
			TugaParser.BinaryOpContext ctx = (TugaParser.BinaryOpContext)node;
			line = ctx.getStart().getLine();
			charPositionInLine = ctx.getStart().getCharPositionInLine();
			text = getOriginalText(ctx);
		}
		else
		{
			throw new IllegalStateException("Should not get an error of anything that isn't a binary or unary operator.");
		}
		
		msg += "\n>     " + text + "     <\n";
		msg += "      ";
		for (int i = 0; i < text.length(); i++)
			msg += "^";

		raiseError(line, charPositionInLine, msg);
	}

	private void raiseError(int line, int charPositionInLine, String msg)
	{
		for (TugaErrorListener listener : this.listeners)
			listener.syntaxError(TugaErrorListener.ErrorType.SEMANTIC, line, charPositionInLine, msg);
	}

	private static String getOriginalText(ParserRuleContext ctx)
	{
		if (ctx.start == null || ctx.stop == null)
			return ctx.getText();

		CharStream charStream = ctx.start.getInputStream();

		int startIndex = ctx.start.getStartIndex();
		int stopIndex = ctx.stop.getStopIndex();

		return charStream.getText(Interval.of(startIndex, stopIndex));
	}
}
