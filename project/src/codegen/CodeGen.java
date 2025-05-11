package codegen;

import java.util.*;

import org.antlr.v4.runtime.tree.ParseTreeProperty;

import Tuga.*;
import types.symbols.*;
import io.BytecodeEncoder;
import types.*;
import vm.*;

public class CodeGen extends TugaBaseVisitor<Void>
{
	private ArrayList<Instruction> code;
	private ArrayList<Value> constantPool;
	private HashMap<Value, Integer> constantPoolHash;
	private ParseTreeProperty<Type> types;
	private HashMap<String, Type> globalVarTypes;
	private HashMap<String, Integer> globalVariableMapping;
	private HashMap<String, Integer> functionCodeIndex;
	private ArrayList<String> functionsArr;
	private HashMap<String, Integer> functionsArrIndexMapping;
	private HashMap<String, FunctionSymbol> functions;
	private int globalVariableChainCounter;
	private int localVariableChainCounter;
	private int localVariableFrameCounter;
	private int currArgCounter;
	private FunctionSymbol currFunction;
	private HashMap<String, Integer> currLocalVarFrameIndex;
	private HashMap<String, Type> currLocalVarTypes;
	private Type currLocalVarType;
	private Stack<FunctionSymbol> currFunctionCalls;
	private Stack<Integer> currFunctionCallIndex;
	private boolean isFirstFunctionDeclaration;

	public CodeGen(ParseTreeProperty<Type> types, HashMap<String, Type> varTypes, HashMap<String, FunctionSymbol> functions)
	{
		super();
		this.code = new ArrayList<Instruction>();
		this.constantPool = new ArrayList<Value>();
		this.constantPoolHash = new HashMap<Value, Integer>();
		this.functionCodeIndex = new HashMap<String, Integer>();
		this.functionsArr = new ArrayList<String>();
		this.functionsArrIndexMapping = new HashMap<String, Integer>();
		for (FunctionSymbol fn : functions.values())
		{
			functionsArr.add(fn.name());
			functionsArrIndexMapping.put(fn.name(), functionsArr.size() - 1);
		}
		this.types = types;
		this.globalVarTypes = varTypes;
		this.functions = functions;
		this.globalVariableMapping = new HashMap<String, Integer>();
		this.globalVariableChainCounter = 0;
		this.localVariableChainCounter = 0;
		this.localVariableFrameCounter = 0;
		this.currFunctionCalls = new Stack<FunctionSymbol>();
		this.currFunctionCallIndex = new Stack<Integer>();
		this.isFirstFunctionDeclaration = true;
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

	public void patch(int index, OpCode op, int ...args)
	{
		code.set(index, new Instruction(op, args));
	}

	public int emit(OpCode op, int ...args)
	{
		code.add(new Instruction(op, args));
		return code.size() - 1;
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
	public Void visitFuncDecl(TugaParser.FuncDeclContext ctx)
	{
		if (isFirstFunctionDeclaration)
		{
			insertSkipToMain();
			isFirstFunctionDeclaration = false;
		}

		String name = ctx.ID().getText();
		FunctionSymbol fn = functions.get(name);
		int start = code.size();
		functionCodeIndex.put(name, start);

		localVariableFrameCounter = 0;
		currLocalVarFrameIndex = new HashMap<String, Integer>();
		currLocalVarTypes = new HashMap<String, Type>();
		currFunction = fn;
		currArgCounter = 0;
		visit(ctx.ID());
		if (ctx.arg_list() != null) 
			visit(ctx.arg_list());
		visit(ctx.scope());
		currFunction = null;

		if (fn.type() == Type.VOID)
			emit(OpCode.ret, fn.argNum());

		return null;
	}

	private void insertSkipToMain()
	{
		int mainId = functionsArrIndexMapping.get("principal");
		emit(OpCode.call, mainId);
		emit(OpCode.halt);
	}

	@Override
	public Void visitFuncCall(TugaParser.FuncCallContext ctx)
	{
		String name = ctx.ID().getText();
		int id = functionsArrIndexMapping.get(name);

		visit(ctx.ID());
		currFunctionCallIndex.push(0);
		currFunctionCalls.push(functions.get(name));
		if (ctx.expr_list() != null)
			visit(ctx.expr_list());
		currFunctionCalls.pop();
		currFunctionCallIndex.pop();

		emit(OpCode.call, id);

		return null;
	}

	@Override
	public Void visitReturnInst(TugaParser.ReturnInstContext ctx)
	{
		if (ctx.expr() == null)
		{
			emit(OpCode.ret, currFunction.argNum());
		}
		else
		{
			visit(ctx.expr());
			if (currFunction.type() == Type.DOUBLE && types.get(ctx.expr()) == Type.INT)
				emit(OpCode.itod);
			emit(OpCode.retval, currFunction.argNum());
		}

		return null;
	}

	@Override
	public Void visitArgument(TugaParser.ArgumentContext ctx)
	{
		currLocalVarFrameIndex.put(ctx.ID().getText(), -currFunction.argNum() + currArgCounter);
		currLocalVarTypes.put(ctx.ID().getText(), antlrTypeConvert(ctx.type.getType()));
		currArgCounter++;

		return null;
	}

	public Type antlrTypeConvert(int type)
	{
		Type result = null;
		switch (type) {
			case TugaParser.T_INT:
				result = Type.INT;
				break;
			case TugaParser.T_DOUBLE:
				result = Type.DOUBLE;
				break;
			case TugaParser.T_STRING:
				result = Type.STRING;
				break;
			case TugaParser.T_BOOL:
				result = Type.BOOL;
				break;
			default:
				throw new IllegalStateException("Invalid variable type.");
		}
		return result;
	}

	@Override
	public Void visitExprSingle(TugaParser.ExprSingleContext ctx)
	{
		FunctionSymbol fn = currFunctionCalls.peek();
		int index = currFunctionCallIndex.pop();

		visit(ctx.expr());

		Type exprType = types.get(ctx.expr());
		Type argType = fn.getArg(index).type();
		if (exprType == Type.INT && argType == Type.DOUBLE)
			emit(OpCode.itod);

		currFunctionCallIndex.push(index + 1);
		return null;
	}

	@Override
	public Void visitExprMultiple(TugaParser.ExprMultipleContext ctx)
	{
		FunctionSymbol fn = currFunctionCalls.peek();
		int index = currFunctionCallIndex.pop();

		visit(ctx.expr());
		Type exprType = types.get(ctx.expr());
		Type argType = fn.getArg(index).type();
		if (exprType == Type.INT && argType == Type.DOUBLE)
			emit(OpCode.itod);

		currFunctionCallIndex.push(index + 1);
		visit(ctx.expr_list());

		return null;
	}

	@Override
	public Void visitScopeInst(TugaParser.ScopeInstContext ctx)
	{
		int startLocalVarFrame = localVariableFrameCounter;
		for (int i = 0; i < ctx.var_decl().size(); i++)
			visit(ctx.var_decl(i));
		int endLocalVarFrame = localVariableFrameCounter;

		for (int i = 0; i < ctx.inst().size(); i++)
			visit(ctx.inst(i));

		int frameDiff = endLocalVarFrame - startLocalVarFrame;
		if (frameDiff > 0 && currFunction.type() == Type.VOID)
			emit(OpCode.pop, frameDiff);
		localVariableFrameCounter = startLocalVarFrame;

		return null;
	}

	// @Override
	// public Void visitArgSingle(TugaParser.ArgSingleContext ctx)
	// {
	// 	visit(ctx.arg());
	// 	return null;
	// }
	//
	// @Override
	// public Void visitArgMultiple(TugaParser.ArgMultipleContext ctx)
	// {
	// 	visit(ctx.arg());
	// 	visit(ctx.arg_list());
	// 	return null;
	// }

	@Override
	public Void visitWhileInst(TugaParser.WhileInstContext ctx)
	{
		int start = code.size();
		visit(ctx.expr());
		int condJumpIndex = emit(OpCode.jumpf, -1);
		visit(ctx.scope_or_inline());
		emit(OpCode.jump, start);
		int end = code.size();

		patch(condJumpIndex, OpCode.jumpf, end);
		return null;
	}

	@Override
	public Void visitIfInst(TugaParser.IfInstContext ctx)
	{
		visit(ctx.expr());
		int condJumpIndex = emit(OpCode.jumpf, -1);
		visit(ctx.scope_or_inline());
		int end = code.size();

		patch(condJumpIndex, OpCode.jumpf, end);
		return null;
	}

	@Override
	public Void visitIfElseInst(TugaParser.IfElseInstContext ctx)
	{
		visit(ctx.expr());
		int condJumpIndex = emit(OpCode.jumpf, -1);
		visit(ctx.scope_or_inline(0));
		int elseSkipIndex = emit(OpCode.jump, -1);
		int middle = code.size();
		visit(ctx.scope_or_inline(1));
		int end = code.size();

		patch(condJumpIndex, OpCode.jumpf, middle);
		patch(elseSkipIndex, OpCode.jump, end);
		return null;
	}

	@Override
	public Void visitAssignInst(TugaParser.AssignInstContext ctx)
	{
		visit(ctx.expr());
		String name = ctx.ID().getText();
		boolean isLocalVar = false;
		Type varType = null;

		if (globalVariableMapping.containsKey(name))
			isLocalVar = false;
		else if (currLocalVarTypes.containsKey(name))
			isLocalVar = true;
		else
			throw new IllegalStateException("Variable should either be in global or local mapping.");

		if (isLocalVar)
			varType = currLocalVarTypes.get(name);
		else
			varType = globalVarTypes.get(name);

		Type exprType = types.get(ctx.expr());
		if (varType == Type.DOUBLE && exprType == Type.INT)
			emit(OpCode.itod);

		if (isLocalVar)
			emit(OpCode.lstore, currLocalVarFrameIndex.get(name));
		else
			emit(OpCode.gstore, globalVariableMapping.get(name));

		return null;
	}

	@Override
	public Void visitVarDecl(TugaParser.VarDeclContext ctx)
	{
		currLocalVarType = antlrTypeConvert(ctx.type.getType());
		visit(ctx.vars());

		if (currFunction == null)
		{
			// global
			emit(OpCode.galloc, globalVariableChainCounter);
			globalVariableChainCounter = 0;
		}
		else
		{
			// local
			emit(OpCode.lalloc, localVariableChainCounter);
			localVariableChainCounter = 0;
		}

		return null;
	}

	@Override
	public Void visitVarSingle(TugaParser.VarSingleContext ctx)
	{
		if (currFunction == null)
		{
			// global
			globalVariableMapping.put(ctx.ID().getText(), globalVariableMapping.size());
			globalVariableChainCounter++;
		}
		else
		{
			// local
			currLocalVarFrameIndex.put(ctx.ID().getText(), 2 + localVariableFrameCounter);
			currLocalVarTypes.put(ctx.ID().getText(), currLocalVarType);
			localVariableFrameCounter++;
			localVariableChainCounter++;
		}
		return null;
	}

	@Override
	public Void visitVarMultiple(TugaParser.VarMultipleContext ctx)
	{
		if (currFunction == null)
		{
			// global
			globalVariableMapping.put(ctx.ID().getText(), globalVariableMapping.size());
			globalVariableChainCounter++;
		}
		else
		{
			// local
			currLocalVarFrameIndex.put(ctx.ID().getText(), 2 + localVariableFrameCounter);
			currLocalVarTypes.put(ctx.ID().getText(), currLocalVarType);
			localVariableFrameCounter++;
			localVariableChainCounter++;
		}
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
		String name = ctx.ID().getText();
		if (globalVariableMapping.containsKey(name))
			emit(OpCode.gload, globalVariableMapping.get(name));
		else if (currLocalVarTypes.containsKey(name))
			emit(OpCode.lload, currLocalVarFrameIndex.get(name));
		else
			throw new IllegalStateException("Variable should either be in global or local mapping.");
		return null;
	}

	@Override
	public Void visitTuga(TugaParser.TugaContext ctx)
	{
		super.visitTuga(ctx);

		patchAllCalls();

		return null;
	}

	private void patchAllCalls()
	{
		for (int i = 0; i < code.size(); i++)
		{
			Instruction inst = code.get(i);
			if (inst.opCode() == OpCode.call)
			{
				int arg = inst.args()[0];
				String name = functionsArr.get(arg);
				int codeIndex = functionCodeIndex.get(name);
				patch(i, OpCode.call, codeIndex);
			}
		}
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
