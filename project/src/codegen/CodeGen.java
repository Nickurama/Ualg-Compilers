package codegen;

import java.util.ArrayList;
import java.util.HashMap;

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
	private HashMap<Value, Integer> constantPoolHash;
	private ParseTreeProperty<Type> types;
	private HashMap<String, Type> varTypes;
	private HashMap<String, Integer> globalVariableMapping;
	private int globalVariableChainCounter;

	public CodeGen(ParseTreeProperty<Type> types, HashMap<String, Type> varTypes)
	{
		super();
		this.code = new ArrayList<Instruction>();
		this.constantPool = new ArrayList<Value>();
		this.constantPoolHash = new HashMap<Value, Integer>();
		this.types = types;
		this.varTypes = varTypes;
		this.globalVariableMapping = new HashMap<String, Integer>();
		this.globalVariableChainCounter = 0;
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
		Value key = new Value(type, value);
		int index;
		if (constantPoolHash.containsKey(key))
		{
			index = constantPoolHash.get(key);
		}
		else
		{
			constantPool.add(key);
			index = constantPool.size() - 1;
			constantPoolHash.put(key, index);
		}
		return index;
	}

	@Override
	public Void visitAssignInst(TugaParser.AssignInstContext ctx)
	{
		visit(ctx.expr());
		Type varType = varTypes.get(ctx.ID().getText());
		Type exprType = types.get(ctx.expr());
		if (varType == Type.DOUBLE && exprType == Type.INT)
			emit(OpCode.itod);
		emit(OpCode.gstore, globalVariableMapping.get(ctx.ID().getText()));

		return null;
	}

	@Override
	public Void visitVarDecl(TugaParser.VarDeclContext ctx)
	{
		visit(ctx.vars());

		emit(OpCode.galloc, globalVariableChainCounter);
		globalVariableChainCounter = 0;

		return null;
	}

	@Override
	public Void visitVarSingle(TugaParser.VarSingleContext ctx)
	{
		globalVariableMapping.put(ctx.ID().getText(), globalVariableMapping.size());
		globalVariableChainCounter++;
		return null;
	}

	@Override
	public Void visitVarMultiple(TugaParser.VarMultipleContext ctx)
	{
		globalVariableMapping.put(ctx.ID().getText(), globalVariableMapping.size());
		globalVariableChainCounter++;
		visit(ctx.vars());

		return null;
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
		else if (types.get(ctx.expr()) == Type.ERROR)
			throw new IllegalStateException("Invalid print type: ERROR");
		else if (types.get(ctx.expr()) == Type.NULL)
			throw new IllegalStateException("Invalid print type: NULL");
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
		if ((leftType == Type.STRING || rightType == Type.STRING) &&
				ctx.op.getType() == TugaParser.SUM) // concat
		{
			op = OpCode.sconcat;
			visit(ctx.expr(0));
			parseString(leftType);
			visit(ctx.expr(1));
			parseString(rightType);
		}
		else if (leftType == Type.DOUBLE || rightType == Type.DOUBLE)
		{
			if (op == OpCode.iadd)
				op = OpCode.dadd;
			else if (op == OpCode.isub)
				op = OpCode.dsub;
		}

		if (op != OpCode.sconcat)
			convertToDoubleIfNeeded(ctx.expr(0), ctx.expr(1));
		emit(op);

		return null;
	}

	private void parseString(Type type)
	{
		switch (type)
		{
			case Type.INT:
				emit(OpCode.itos);
				break;
			case Type.DOUBLE:
				emit(OpCode.dtos);
				break;
			case Type.BOOL:
				emit(OpCode.btos);
				break;
			default:
				break;
		}
	}

	@Override
	public Void visitRelOp(TugaParser.RelOpContext ctx)
	{
		Type leftType = types.get(ctx.expr(0));
		Type rightType = types.get(ctx.expr(1));

		// get operator
		boolean swap = false;
		OpCode op = OpCode.ileq;
		if (ctx.op.getType() == TugaParser.LESS)
		{
			swap = false;
			op = OpCode.ilt;
		}
		else if (ctx.op.getType() == TugaParser.LESS_EQ)
		{
			swap = false;
			op = OpCode.ileq;
		}
		else if (ctx.op.getType() == TugaParser.GREATER)
		{
			swap = true;
			op = OpCode.ilt;
		}
		else if (ctx.op.getType() == TugaParser.GREATER_EQ)
		{
			swap = true;
			op = OpCode.ileq;
		}
		else
			throw new IllegalStateException("Unknown operator.");

		// get operator type
		if (leftType == Type.DOUBLE || rightType == Type.DOUBLE)
		{
			if (op == OpCode.ilt)
				op = OpCode.dlt;
			else if (op == OpCode.ileq)
				op = OpCode.dleq;
		}

		if (!swap)
			convertToDoubleIfNeeded(ctx.expr(0), ctx.expr(1));
		else
			convertToDoubleIfNeeded(ctx.expr(1), ctx.expr(0));
		emit(op);

		return null;
	}

	@Override
	public Void visitEqualsOp(TugaParser.EqualsOpContext ctx)
	{
		Type leftType = types.get(ctx.expr(0));
		Type rightType = types.get(ctx.expr(1));

		// get operator
		OpCode op = OpCode.ieq;
		if (ctx.op.getType() == TugaParser.EQUALS)
			op = OpCode.ieq;
		else if (ctx.op.getType() == TugaParser.N_EQUALS)
			op = OpCode.ineq;
		else
			throw new IllegalStateException("Unknown operator.");

		// get operator type
		if (leftType == Type.DOUBLE || rightType == Type.DOUBLE)
		{
			if (op == OpCode.ieq)
				op = OpCode.deq;
			else if (op == OpCode.ineq)
				op = OpCode.dneq;
		}
		else if (leftType == Type.STRING && rightType == Type.STRING)
		{
			if (op == OpCode.ieq)
				op = OpCode.seq;
			else if (op == OpCode.ineq)
				op = OpCode.sneq;
		}
		else if (leftType == Type.BOOL && rightType == Type.BOOL)
		{
			if (op == OpCode.ieq)
				op = OpCode.beq;
			else if (op == OpCode.ineq)
				op = OpCode.bneq;
		}

		convertToDoubleIfNeeded(ctx.expr(0), ctx.expr(1));
		emit(op);

		return null;
	}

	@Override
	public Void visitAndOp(TugaParser.AndOpContext ctx)
	{
		visit(ctx.expr(0));
		visit(ctx.expr(1));
		emit(OpCode.and);
		return null;
	}

	@Override
	public Void visitOrOp(TugaParser.OrOpContext ctx)
	{
		visit(ctx.expr(0));
		visit(ctx.expr(1));
		emit(OpCode.or);
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
	public Void visitIDExpr(TugaParser.IDExprContext ctx)
	{
		emit(OpCode.gload, globalVariableMapping.get(ctx.ID().getText()));
		return null;
	}

	@Override
	public Void visitTuga(TugaParser.TugaContext ctx)
	{
		super.visitTuga(ctx);
		emit(OpCode.halt);
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
