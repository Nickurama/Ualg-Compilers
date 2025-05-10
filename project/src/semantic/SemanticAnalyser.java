package semantic;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.*;
import java.util.*;

import Tuga.*;
import errorlisteners.*;
import types.*;

public class SemanticAnalyser extends TugaBaseVisitor<Type>
{
	private static final String MAIN_FUNC = "principal";

	private ParseTreeProperty<Type> types;
	private ArrayList<TugaErrorListener> listeners;
	private Type currentVisitingVarType;
	private HashMap<String, Type> varTypes;
	private HashMap<String, Function> functions;

	private boolean foundMain;
	private Function currFunction;
	private boolean foundReturn;
	private Stack<Integer> currArgNum;
	private Stack<Function> currFunctionCall;
	private HashSet<String> foundFunctions;
	private HashMap<String, Type> localVarTypes;
	private Stack<ArrayList<String>> currLocalVars;

	public SemanticAnalyser(ParseTreeProperty<Type> types, HashMap<String, Type> varTypes, HashMap<String, Function> functions)
	{
		this.types = types;
		this.listeners = new ArrayList<TugaErrorListener>();
		this.currentVisitingVarType = null;
		this.varTypes = varTypes;
		this.functions = functions;

		this.foundMain = false;
		this.currArgNum = new Stack<Integer>();
		this.currFunctionCall = new Stack<Function>();
		this.foundFunctions = new HashSet<String>();
		this.currLocalVars = new Stack<ArrayList<String>>();
	}

	@Override
	public Type visit(ParseTree tree)
	{
		Type result = super.visit(tree);
		if (!(tree instanceof TugaParser.TugaContext))
			return result;
		TugaParser.TugaContext ctx = (TugaParser.TugaContext) tree;

		if (!foundMain)
			raiseError(ctx.stop.getLine(), 0, "falta funcao principal()");

		return result;
	}

	@Override
	public Type visitFuncDecl(TugaParser.FuncDeclContext ctx)
	{
		currFunction = functions.get(ctx.ID().getText());

		if (foundFunctions.contains(currFunction.name()) || varTypes.containsKey(currFunction.name()))
		{
			String msg = "'" + currFunction.name() + "' ja foi declarado";
			raiseError(ctx.start.getLine(), ctx.start.getCharPositionInLine(), msg);
		}
		else
		{
			foundFunctions.add(currFunction.name());
		}

		localVarTypes = new HashMap<String, Type>();
		currLocalVars.add(new ArrayList<String>());

		foundReturn = false;
		if (ctx.arg_list() != null)
			visit(ctx.arg_list());
		visit(ctx.scope());
		if (ctx.ID().getText().equals(MAIN_FUNC))
			this.foundMain = true;
		if (!foundReturn && currFunction.returnType() != Type.VOID)
		{
			String msg = "funcao sem retorno";
			raiseError(ctx.start.getLine(), ctx.start.getCharPositionInLine(), msg);
		}

		for (String var : currLocalVars.peek())
			localVarTypes.remove(var);
		currLocalVars.pop();
		currFunction = null;
		return null;
	}

	@Override
	public Type visitArgument(TugaParser.ArgumentContext ctx)
	{
		String name = ctx.ID().getText();
		Type type = antlrTypeConvert(ctx.type.getType());

		if (localVarTypes.containsKey(name) || varTypes.containsKey(name) || functions.containsKey(name))
		{
			String msg = "'" + ctx.ID().getText() + "' ja foi declarado";
			raiseError(ctx.start.getLine(), ctx.start.getCharPositionInLine(), msg);
			return type;
		}
		currLocalVars.peek().add(name);
		localVarTypes.put(name, type);

		return type;
	}

	@Override
	public Type visitReturnInst(TugaParser.ReturnInstContext ctx)
	{
		foundReturn = true;
		Type exprType = Type.VOID;
		if (ctx.expr() != null)
			exprType = visit(ctx.expr());

		if (currFunction.returnType() != exprType &&
			!(currFunction.returnType() == Type.DOUBLE && exprType == Type.INT))
		{
			String msg = "funcao de tipo " + currFunction.returnType() + " nao pode retornar uma expressao do tipo " + exprType;
			raiseError(ctx.start.getLine(), ctx.start.getCharPositionInLine(), msg);
		}

		return exprType;
	}

	@Override
	public Type visitFuncCallInst(TugaParser.FuncCallInstContext ctx)
	{
		Type result = visit(ctx.func_call());

		TugaParser.FuncCallContext fnCtx = (TugaParser.FuncCallContext)ctx.func_call();
		String fnName = fnCtx.ID().getText();
		if (functions.containsKey(fnName) && !(functions.get(fnName).returnType() == Type.VOID))
		{
			String msg = "valor de '" + fnName + "' tem de ser atribuido a uma variavel";
			raiseError(ctx.start.getLine(), ctx.start.getCharPositionInLine(), msg);
		}

		return result;
	}

	@Override
	public Type visitFuncCall(TugaParser.FuncCallContext ctx)
	{
		if (!functions.containsKey(ctx.ID().getText()))
		{
			String msg = "'" + ctx.ID().getText() + "' nao foi declarado";
			raiseError(ctx.start.getLine(), ctx.start.getCharPositionInLine(), msg);
			return null;
		}

		currArgNum.push(0);
		Function fn = functions.get(ctx.ID().getText());
		currFunctionCall.push(fn);
		if (ctx.expr_list() != null)
			visit(ctx.expr_list());
		currFunctionCall.pop();

		if (currArgNum.peek() != fn.argNum())
		{
			String msg = "'" + fn.name() + "' requer " + fn.argNum() + " argumentos";
			raiseError(ctx.start.getLine(), ctx.start.getCharPositionInLine(), msg);
		}
		currArgNum.pop();

		return null;
	}

	@Override
	public Type visitExprSingle(TugaParser.ExprSingleContext ctx)
	{
		argLogic(ctx.expr());
		return null;
	}

	@Override
	public Type visitExprMultiple(TugaParser.ExprMultipleContext ctx)
	{
		argLogic(ctx.expr());
		visit(ctx.expr_list());
		return null;
	}

	private void argLogic(TugaParser.ExprContext ctx)
	{
		int id = currArgNum.pop();
		Function currFn = currFunctionCall.peek();
		currArgNum.push(id + 1);
		if (id >= currFn.argNum())
			return;

		Type expectedType = currFn.getArg(id).type();
		Type type = visit(ctx);

		if (!expectedType.equals(type) && !(expectedType == Type.DOUBLE && type == Type.INT))
		{
			String msg = "'" + getOriginalText(ctx) + "' devia ser do tipo " + expectedType;
			raiseError(ctx.start.getLine(), ctx.start.getCharPositionInLine(), msg);
		}
	}

	@Override
	public Type visitFuncExpr(TugaParser.FuncExprContext ctx)
	{
		visit(ctx.func_call());

		TugaParser.FuncCallContext fnCtx = (TugaParser.FuncCallContext)ctx.func_call();
		String fnName = fnCtx.ID().getText();

		Function fn = functions.get(fnName);
		if (fn == null)
			return Type.ERROR;
		Type result = functions.get(fnName).returnType();

		types.put(ctx, result);
		return result;
	}

	@Override
	public Type visitWhileInst(TugaParser.WhileInstContext ctx)
	{
		final String operator = "enquanto";
		Type condType = visit(ctx.expr());

		if (condType == Type.ERROR)
		{
			types.put(ctx, Type.ERROR);
			condType = Type.ERROR;
		}
		else if (condType != Type.BOOL)
		{
			raiseExpressionTypeError(ctx, operator, Type.BOOL);
			types.put(ctx, Type.ERROR);
			condType = Type.ERROR;
		}

		visit(ctx.scope_or_inline());
		return condType;
	}

	@Override
	public Type visitIfInst(TugaParser.IfInstContext ctx)
	{
		final String operator = "se";
		Type condType = visit(ctx.expr());

		if (condType == Type.ERROR)
		{
			types.put(ctx, Type.ERROR);
			condType = Type.ERROR;
		}
		else if (condType != Type.BOOL)
		{
			raiseExpressionTypeError(ctx, operator, Type.BOOL);
			types.put(ctx, Type.ERROR);
			condType = Type.ERROR;
		}

		visit(ctx.scope_or_inline());
		return condType;
	}

	@Override
	public Type visitIfElseInst(TugaParser.IfElseInstContext ctx)
	{
		final String operator = "se";
		Type condType = visit(ctx.expr());

		if (condType == Type.ERROR)
		{
			types.put(ctx, Type.ERROR);
			condType = Type.ERROR;
		}
		else if (condType != Type.BOOL)
		{
			raiseExpressionTypeError(ctx, operator, Type.BOOL);
			types.put(ctx, Type.ERROR);
			condType = Type.ERROR;
		}

		visit(ctx.scope_or_inline(0));
		visit(ctx.scope_or_inline(1));
		return condType;
	}

	@Override
	public Type visitAssignInst(TugaParser.AssignInstContext ctx)
	{
		String var = ctx.ID().getText();
		if (!this.varTypes.containsKey(var) && !this.localVarTypes.containsKey(var))
		{
			raiseUndeclaredVarError(ctx, var);
			types.put(ctx, Type.ERROR);
			return Type.ERROR;
		}

		final String operator = "<-";
		Type varType = this.varTypes.get(var);
		Type exprType = visit(ctx.expr());

		Type result = Type.ERROR;

		if (varType == Type.INT && exprType == Type.INT)
			result = Type.INT;
		else if (varType == Type.DOUBLE && (exprType == Type.INT || exprType == Type.DOUBLE))
			result = Type.DOUBLE;
		else if (varType == Type.BOOL && exprType == Type.BOOL)
			result = Type.BOOL;
		else if (varType == Type.STRING && exprType == Type.STRING)
			result = Type.STRING;
		else if (exprType == Type.ERROR)
		{
			types.put(ctx, Type.ERROR);
			return Type.ERROR;
		}

		if (result == Type.ERROR)
		{
			types.put(ctx, Type.ERROR);
			raiseTypeError(ctx, operator, varType, exprType);
		}

		return result;
	}

	public int getLine(ParserRuleContext ctx)
	{
		return ctx.getStart().getLine();
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
		String operator = ctx.op.getText();
		Type leftType = visit(ctx.expr(0));
		Type rightType = visit(ctx.expr(1));

		if (!leftType.isNumerical() || !rightType.isNumerical())
		{
			setError(ctx, operator, leftType, rightType);
			return Type.ERROR;
		}

		if (leftType == Type.INT && rightType == Type.INT)
		{
			types.put(ctx, Type.INT);
			return Type.INT;
		}

		if (ctx.op.getType() == TugaParser.MOD)
		{
			setError(ctx, operator, leftType, rightType);
			return Type.ERROR;
		}

		types.put(ctx, Type.DOUBLE);
		return Type.DOUBLE;
	}

	@Override
	public Type visitSumSubOp(TugaParser.SumSubOpContext ctx)
	{
		String operator = ctx.op.getText();
		Type leftType = visit(ctx.expr(0));
		Type rightType = visit(ctx.expr(1));

		if (ctx.op.getType() == TugaParser.SUM && (leftType == Type.STRING || rightType == Type.STRING))
		{
			types.put(ctx, Type.STRING);
			return Type.STRING;
		}

		if (!leftType.isNumerical() || !rightType.isNumerical())
		{
			setError(ctx, operator, leftType, rightType);
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
		String operator = ctx.op.getText();
		Type leftType = visit(ctx.expr(0));
		Type rightType = visit(ctx.expr(1));

		if (leftType != Type.BOOL || rightType != Type.BOOL)
		{
			setError(ctx, operator, leftType, rightType);
			return Type.ERROR;
		}

		types.put(ctx, Type.BOOL);
		return Type.BOOL;
	}

	@Override
	public Type visitOrOp(TugaParser.OrOpContext ctx)
	{
		String operator = ctx.op.getText();
		Type leftType = visit(ctx.expr(0));
		Type rightType = visit(ctx.expr(1));

		if (leftType != Type.BOOL || rightType != Type.BOOL)
		{
			setError(ctx, operator, leftType, rightType);
			return Type.ERROR;
		}

		types.put(ctx, Type.BOOL);
		return Type.BOOL;
	}

	@Override
	public Type visitRelOp(TugaParser.RelOpContext ctx)
	{
		String operator = ctx.op.getText();
		Type leftType = visit(ctx.expr(0));
		Type rightType = visit(ctx.expr(1));

		if (!leftType.isNumerical() || !rightType.isNumerical())
		{
			setError(ctx, operator, leftType, rightType);
			return Type.ERROR;
		}

		types.put(ctx, Type.BOOL);
		return Type.BOOL;
	}

	@Override
	public Type visitEqualsOp(TugaParser.EqualsOpContext ctx)
	{
		String operator = ctx.op.getText();
		Type leftType = visit(ctx.expr(0));
		Type rightType = visit(ctx.expr(1));

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

		setError(ctx, operator, leftType, rightType);
		return Type.ERROR;
	}

	@Override
	public Type visitArithmeticNegateOp(TugaParser.ArithmeticNegateOpContext ctx)
	{
		String operator = ctx.op.getText();
		Type type = visit(ctx.expr());

		if (type == Type.INT || type == Type.DOUBLE)
		{
			types.put(ctx, type);
			return type;
		}

		setError(ctx, operator, type);
		return Type.ERROR;
	}

	@Override
	public Type visitLogicNegateOp(TugaParser.LogicNegateOpContext ctx)
	{
		String operator = ctx.op.getText();
		Type type = visit(ctx.expr());

		if (type == Type.BOOL)
		{
			types.put(ctx, type);
			return type;
		}

		setError(ctx, operator, type);
		return Type.ERROR;
	}

	@Override
	public Type visitVarDecl(TugaParser.VarDeclContext ctx)
	{
		switch (ctx.type.getType()) {
			case TugaParser.T_INT:
				this.currentVisitingVarType = Type.INT;
				break;
			case TugaParser.T_DOUBLE:
				this.currentVisitingVarType = Type.DOUBLE;
				break;
			case TugaParser.T_STRING:
				this.currentVisitingVarType = Type.STRING;
				break;
			case TugaParser.T_BOOL:
				this.currentVisitingVarType = Type.BOOL;
				break;
			default:
				throw new IllegalStateException("Invalid variable type.");
		}

		visit(ctx.vars());

		return this.currentVisitingVarType;
	}

	@Override
	public Type visitVarSingle(TugaParser.VarSingleContext ctx)
	{
		if (this.varTypes.containsKey(ctx.ID().getText()))
			raiseAlreadyDeclaredVarError(ctx, ctx.ID().getText());
		else if (this.foundFunctions.contains(ctx.ID().getText()))
		{
			String msg = "'" + ctx.ID().getText() + "' ja foi declarado";
			raiseError(ctx.start.getLine(), ctx.start.getCharPositionInLine(), msg);
		}
		else
			this.varTypes.put(ctx.ID().getText(), this.currentVisitingVarType);

		return this.currentVisitingVarType;
	}

	@Override
	public Type visitVarMultiple(TugaParser.VarMultipleContext ctx)
	{
		if (this.varTypes.containsKey(ctx.ID().getText()))
			raiseAlreadyDeclaredVarError(ctx, ctx.ID().getText());
		else if (this.foundFunctions.contains(ctx.ID().getText()))
		{
			String msg = "'" + ctx.ID().getText() + "' ja foi declarado";
			raiseError(ctx.start.getLine(), ctx.start.getCharPositionInLine(), msg);
		}
		else
			this.varTypes.put(ctx.ID().getText(), this.currentVisitingVarType);

		visit(ctx.vars());
		return this.currentVisitingVarType;
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

	@Override
	public Type visitIDExpr(TugaParser.IDExprContext ctx)
	{
		Type result = this.varTypes.get(ctx.ID().getText());
		if (result == null && this.localVarTypes != null)
			result = this.localVarTypes.get(ctx.ID().getText());
		if (result == null)
		{
			raiseUndeclaredVarError(ctx, ctx.ID().getText());
			result = Type.ERROR;
		}

		types.put(ctx, result);
		return result;
	}

	private void raiseUndeclaredVarError(ParserRuleContext ctx, String variable)
	{
		int line = ctx.getStart().getLine();
		int charPositionInLine = ctx.getStart().getCharPositionInLine();
		// String text = "Variable \'" + ctx.ID().getText() + "\' hasn't been declared.";
		String text = "variavel \'" + variable + "\' nao foi declarada";
		raiseError(line, charPositionInLine, text);
	}

	private void raiseAlreadyDeclaredVarError(ParserRuleContext ctx, String variable)
	{
		int line = ctx.getStart().getLine();
		int charPositionInLine = ctx.getStart().getCharPositionInLine();
		// String text = "Variable \'" + ctx.ID().getText() + "\' already declared.";
		String text = "variavel \'" + variable + "\' ja foi declarada";
		raiseError(line, charPositionInLine, text);
	}

	private void setError(ParserRuleContext node, String operator, Type type)
	{
		types.put(node, Type.ERROR);
		if (isLeafError(node))
			raiseTypeError(node, operator, type);
	}

	private void setError(ParserRuleContext node, String operator, Type type1, Type type2)
	{
		types.put(node, Type.ERROR);
		if (isLeafError(node))
			raiseTypeError(node, operator, type1, type2);
	}

	private boolean isLeafError(ParseTree node)
	{
		return this.types.get(node) == Type.ERROR && node instanceof TugaParser.ExprContext && !doChildrenHaveErrors(node);
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
			throw new NullPointerException("listener cannot be null.");
		else
			this.listeners.add(listener);
	}
	
	public void removeErrorListeners()
	{
		if (!this.listeners.isEmpty())
			this.listeners = new ArrayList<TugaErrorListener>();
	}

	private void raiseExpressionTypeError(ParserRuleContext node, String operator, Type type)
	{
		int line = node.getStart().getLine();
		int charPositionInLine = node.getStart().getCharPositionInLine();
		String msg = "expressao de \'" + operator + "\' nao eh do tipo " + type.toString();
		raiseError(line, charPositionInLine, msg);
	}

	private void raiseTypeError(ParserRuleContext node, String operator, Type type)
	{
		int line = node.getStart().getLine();
		int charPositionInLine = node.getStart().getCharPositionInLine();
		raiseTypeError(line, charPositionInLine, operator, type);
	}

	private void raiseTypeError(ParserRuleContext node, String operator, Type type1, Type type2)
	{
		int line = node.getStart().getLine();
		int charPositionInLine = node.getStart().getCharPositionInLine();
		raiseTypeError(line, charPositionInLine, operator, type1, type2);
	}

	private void raiseTypeError(int line, int charPositionInLine, String operator, Type type)
	{
		String msg = "operador \'" + operator + "\' eh invalido para o tipo " + type.toString();
		raiseError(line, charPositionInLine, msg);
	}

	private void raiseTypeError(int line, int charPositionInLine, String operator, Type type1, Type type2)
	{
		String msg = "operador \'" + operator + "\' eh invalido entre " + type1.toString() + " e " + type2.toString();
		raiseError(line, charPositionInLine, msg);
	}

	private void raiseError(TugaParser.ExprContext node)
	{
		int line = 0;
		int charPositionInLine = 0;
		String msg = "";
		String text = "";

		if (node instanceof TugaParser.ExprContext)
		{
			TugaParser.ExprContext ctx = (TugaParser.ExprContext)node;
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
}
