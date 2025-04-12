package codegen;

import java.util.ArrayList;

import org.antlr.v4.runtime.tree.ParseTreeProperty;

import Tuga.*;
import io.BytecodeEncoder;
import types.Type;
import types.Value;
import vm.Instruction;
import vm.OpCode;

public class CodeGen extends TugaBaseVisitor<Void>
{
	private ArrayList<Instruction> code;
	private ArrayList<Value> constantPool;
	private ParseTreeProperty<Type> types;

	public CodeGen(ParseTreeProperty<Type> types)
	{
		super();
		code = new ArrayList<Instruction>();
		constantPool = new ArrayList<Value>();
		this.types = types;
	}

	public byte[] getBytecode()
	{
		Value[] constArr = new Value[constantPool.size()];
		constantPool.toArray(constArr);
		Instruction[] instArr = new Instruction[code.size()];
		code.toArray(instArr);
		BytecodeEncoder encoder = new BytecodeEncoder(constArr, instArr);
		return encoder.encode();
	}

	public void dumpCode()
	{
		System.out.println("Generated code in assembly format");
		for (int i = 0; i < code.size(); i++)
			System.out.println(i + ": " + code.get(i));
	}

	public void emit(OpCode op, int ...args)
	{
		code.add(new Instruction(op, args));
	}

	public int emitConst(Type type, Object value)
	{
		constantPool.add(new Value(type, value));
		return constantPool.size() - 1;
	}

	@Override
	public Void visitPrintInst(TugaParser.PrintInstContext ctx)
	{
		visit(ctx.expr());
		if (types.get(ctx.expr()) == Type.INT)
			emit(OpCode.iprint);
		else if (types.get(ctx.expr()) == Type.DOUBLE)
			emit(OpCode.dprint);
		else if (types.get(ctx.expr()) == Type.BOOL)
			emit(OpCode.bprint);
		else if (types.get(ctx.expr()) == Type.STRING)
			emit(OpCode.sprint);
		else
			throw new IllegalStateException("Unknown print type");

		return null;
	}

	@Override
	public Void visitMultDivOp(TugaParser.MultDivOpContext ctx)
	{
		Type leftType = types.get(ctx.expr(0));
		Type rightType = types.get(ctx.expr(1));

		// get operator
		OpCode op = OpCode.imult;
		if (ctx.op.getType() == TugaParser.MLT)
			op = OpCode.imult;
		else if (ctx.op.getType() == TugaParser.DIV)
			op = OpCode.idiv;
		else if (ctx.op.getType() == TugaParser.MOD)
			op = OpCode.imod;
		else
			throw new IllegalStateException("Unknown operator.");

		// get operator type
		if (leftType == Type.DOUBLE || rightType == Type.DOUBLE)
		{
			if (op == OpCode.imult)
				op = OpCode.dmult;
			else if (op == OpCode.idiv)
				op = OpCode.ddiv;
		}

		convertToDoubleIfNeeded(ctx.expr(0), ctx.expr(1));
		emit(op);

		return null;
	}

	private void convertToDoubleIfNeeded(TugaParser.ExprContext ctx0, TugaParser.ExprContext ctx1)
	{
		Type leftType = types.get(ctx0);
		Type rightType = types.get(ctx1);

		visit(ctx0);
		if (leftType == Type.INT && rightType == Type.DOUBLE)
		{
			emit(OpCode.itod);
			visit(ctx1);
		}
		else if (leftType == Type.DOUBLE && rightType == Type.INT)
		{
			visit(ctx1);
			emit(OpCode.itod);
		}
		else
			visit(ctx1);
	}

	@Override
	public Void visitSumSubOp(TugaParser.SumSubOpContext ctx)
	{
		Type leftType = types.get(ctx.expr(0));
		Type rightType = types.get(ctx.expr(1));

		// get operator
		OpCode op = OpCode.iadd;
		if (ctx.op.getType() == TugaParser.SUM)
			op = OpCode.iadd;
		else if (ctx.op.getType() == TugaParser.SUB)
			op = OpCode.isub;
		else
			throw new IllegalStateException("Unknown operator.");

		// get operator type
		if (leftType == Type.DOUBLE || rightType == Type.DOUBLE)
		{
			if (op == OpCode.iadd)
				op = OpCode.dadd;
			else if (op == OpCode.isub)
				op = OpCode.dsub;
		}

		convertToDoubleIfNeeded(ctx.expr(0), ctx.expr(1));
		emit(op);

		return null;
	}

	@Override
	public Void visitArithmeticNegateOp(TugaParser.ArithmeticNegateOpContext ctx)
	{
		visit(ctx.expr());
		if (types.get(ctx.expr()) == Type.INT)
			emit(OpCode.iuminus);
		else if (types.get(ctx.expr()) == Type.DOUBLE)
			emit(OpCode.duminus);
		else
			throw new IllegalStateException("Cannot negate the current type");
		return null;
	}

	@Override
	public Void visitLogicNegateOp(TugaParser.LogicNegateOpContext ctx)
	{
		visit(ctx.expr());
		emit(OpCode.not);
		return null;
	}

	@Override
	public Void visitParenExpr(TugaParser.ParenExprContext ctx)
	{
		visit(ctx.expr());
		return null;
	}

	@Override
	public Void visitInt(TugaParser.IntContext ctx)
	{
		int value = Integer.valueOf(ctx.INT().getText());
		emit(OpCode.iconst, value);
		return null;
	}

	@Override
	public Void visitDouble(TugaParser.DoubleContext ctx)
	{
		double value = Double.valueOf(ctx.DOUBLE().getText());
		int index = emitConst(Type.DOUBLE, value);
		emit(OpCode.dconst, index);
		return null;
	}

	@Override
	public Void visitString(TugaParser.StringContext ctx)
	{
		String text = ctx.STRING().getText();
		String value = text.substring(1, text.length() - 1);
		int index = emitConst(Type.STRING, value);
		emit(OpCode.sconst, index);
		return null;
	}

	@Override
	public Void visitTrue(TugaParser.TrueContext ctx)
	{
		emit(OpCode.tconst);
		return null;
	}

	@Override
	public Void visitFalse(TugaParser.FalseContext ctx)
	{
		emit(OpCode.fconst);
		return null;
	}
}
