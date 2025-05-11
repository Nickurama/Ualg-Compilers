package semantic;

import java.util.*;

import Tuga.*;
import types.*;
import types.symbols.*;

public class FunctionCollector extends TugaBaseVisitor<Void>
{
	private HashMap<String, FunctionSymbol> functions;
	private ArrayList<VariableSymbol> currArgs;

	public FunctionCollector(HashMap<String, FunctionSymbol> functions)
	{
		this.functions = functions;
	}

	@Override
	public Void visitFuncDecl(TugaParser.FuncDeclContext ctx)
	{
		// visit(ctx.scope());

		String name = ctx.ID().getText();
		if (functions.containsKey(name))
			return null;
		Type retType = null;
		if (ctx.type != null)
			retType = antlrTypeConvert(ctx.type.getType());
		else
			retType = Type.VOID;


		currArgs = new ArrayList<VariableSymbol>();
		if (ctx.arg_list() != null)
			visit(ctx.arg_list());
		VariableSymbol[] args = new VariableSymbol[currArgs.size()];
		args = currArgs.toArray(args);

		FunctionSymbol fn = new FunctionSymbol(name, retType, args);
		fn.setLine(ctx.start.getLine());
		functions.put(name, fn);

		return null;
	}

	@Override
	public Void visitArgument(TugaParser.ArgumentContext ctx)
	{
		String name = ctx.ID().getText();
		Type type = antlrTypeConvert(ctx.type.getType());

		VariableSymbol arg = new VariableSymbol(name, type);
		currArgs.add(arg);

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
}
