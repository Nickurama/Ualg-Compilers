package semantic;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.*;
import java.util.*;

import Tuga.*;
import errorlisteners.*;
import types.*;

public class FunctionCollector extends TugaBaseVisitor<Void>
{
	private HashMap<String, Function> functions;
	private ArrayList<Argument> currArgs;

	public FunctionCollector(HashMap<String, Function> functions)
	{
		this.functions = functions;
	}

	@Override
	public Void visitFuncDecl(TugaParser.FuncDeclContext ctx)
	{
		// visit(ctx.scope());

		String name = ctx.ID().getText();
		Type retType = null;
		if (ctx.type != null)
			retType = antlrTypeConvert(ctx.type.getType());
		else
			retType = Type.NULL;


		currArgs = new ArrayList<Argument>();
		if (ctx.arg_list() != null)
			visit(ctx.arg_list());
		Argument[] args = new Argument[currArgs.size()];
		args = currArgs.toArray(args);

		Function fn = new Function(name, retType, args);
		functions.put(name, fn);

		return null;
	}

	@Override
	public Void visitArgument(TugaParser.ArgumentContext ctx)
	{
		String name = ctx.ID().getText();
		Type type = antlrTypeConvert(ctx.type.getType());

		Argument arg = new Argument(name, type);
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
