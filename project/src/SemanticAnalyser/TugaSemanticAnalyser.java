package SemanticAnalyser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

import Tuga.*;
import Types.*;
import ErrorListeners.*;

public class TugaSemanticAnalyser extends TugaBaseVisitor<TugaType>
{
	private ParseTreeProperty<TugaType> types;
	private ArrayList<TugaErrorListener> listeners;
	private ParseTree tree;

	public TugaSemanticAnalyser(ParseTreeProperty<TugaType> types)
	{
		this.types = types;
		this.listeners = new ArrayList<TugaErrorListener>();
	}

	// @Override
	// public TugaType visit(ParseTree tree)
	// {
	// 	this.tree = tree;
	// 	return super.visit(this.tree);
	// }

	// @Override
	// public TugaType visitPrintInst(TugaParser.PrintInstContext ctx)
	// {
	// 	// TugaType type = visit(ctx.expr());
	// 	// if (type == TugaType.ERROR)
	// 	// 	throw new IllegalStateException("Top level expression evaluated to type ERROR");
	// 	return null;
	// }

	@Override
	public TugaType visitBinaryOp(TugaParser.BinaryOpContext ctx)
	{
		TugaType result = visit(ctx.binary_op());
		types.put(ctx, result);
		return result;
	}

	@Override
	public TugaType visitUnaryOp(TugaParser.UnaryOpContext ctx)
	{
		TugaType result = visit(ctx.unary_op());
		types.put(ctx, result);
		return result;
	}

	@Override
	public TugaType visitParenExpr(TugaParser.ParenExprContext ctx)
	{
		TugaType result = visit(ctx.expr());
		types.put(ctx, result);
		return result;
	}

	@Override
	public TugaType visitLiteralExpr(TugaParser.LiteralExprContext ctx)
	{
		TugaType result = visit(ctx.literal());
		types.put(ctx, result);
		return result;
	}

	@Override
	public TugaType visitMultDivOp(TugaParser.MultDivOpContext ctx)
	{
		TugaParser.BinaryOpContext parentContext = (TugaParser.BinaryOpContext)ctx.getParent();
		TugaType leftType = visit(parentContext.expr(0));
		TugaType rightType = visit(parentContext.expr(1));

		if (leftType.isNumerical() && rightType.isNumerical())
		{
			if (leftType == TugaType.DOUBLE || rightType == TugaType.DOUBLE)
			{
				if (ctx.op.getType() == TugaParser.MOD)
				{
					types.put(ctx, TugaType.ERROR);
					return TugaType.ERROR;
				}

				types.put(ctx, TugaType.DOUBLE);
				return TugaType.DOUBLE;
			}

			types.put(ctx, TugaType.INT);
			return TugaType.INT;
		}

		types.put(ctx, TugaType.ERROR);
		return TugaType.ERROR;
	}

	@Override
	public TugaType visitInt(TugaParser.IntContext ctx)
	{
		return TugaType.INT;
	}

	@Override
	public TugaType visitString(TugaParser.StringContext ctx)
	{
		return TugaType.STRING;
	}

	@Override
	public TugaType visitDouble(TugaParser.DoubleContext ctx)
	{
		return TugaType.DOUBLE;
	}

	@Override
	public TugaType visitTrue(TugaParser.TrueContext ctx)
	{
		return TugaType.BOOL;
	}

	@Override
	public TugaType visitFalse(TugaParser.FalseContext ctx)
	{
		return TugaType.BOOL;
	}

	public void findErrors(ParseTree node)
	{
		if (this.types.get(node) == TugaType.ERROR && node instanceof TugaParser.ExprContext && !doChildrenHaveErrors(node))
			raiseError((TugaParser.ExprContext)node);

		for (int i = 0; i < node.getChildCount(); i++) // dfs
			findErrors(node.getChild(i));
	}

	public boolean doChildrenHaveErrors(ParseTree node)
	{
		for (int i = 0; i < node.getChildCount(); i++)
		{
			ParseTree child = node.getChild(i);
			if (this.types.get(child) == TugaType.ERROR && child instanceof TugaParser.ExprContext)
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
		String words = "";

		if (node instanceof TugaParser.UnaryOpContext)
		{
			TugaParser.UnaryOpContext ctx = (TugaParser.UnaryOpContext)node;
			line = ctx.getStart().getLine();
			charPositionInLine = ctx.getStart().getCharPositionInLine();
			words = ctx.getText();
		}
		else if (node instanceof TugaParser.BinaryOpContext)
		{
			TugaParser.BinaryOpContext ctx = (TugaParser.BinaryOpContext)node;
			line = ctx.getStart().getLine();
			charPositionInLine = ctx.getStart().getCharPositionInLine();
			words = ctx.getText();
		}
		else
		{
			throw new IllegalStateException("Should not get an error of anything that isn't a binary or unary operator.");
		}
		
		msg += "\n>     " + words + "     <\n";
		msg += "      ";
		for (int i = 0; i < words.length(); i++)
			msg += "^";

		raiseError(line, charPositionInLine, msg);
	}

	private void raiseError(int line, int charPositionInLine, String msg)
	{
		for (TugaErrorListener listener : this.listeners)
			listener.syntaxError(TugaErrorListener.ErrorType.SEMANTIC, line, charPositionInLine, msg);
	}
}
