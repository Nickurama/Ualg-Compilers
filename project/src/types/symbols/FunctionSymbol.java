package types.symbols;

import types.*;

public class FunctionSymbol extends Symbol
{
	private VariableSymbol[] args;

	public FunctionSymbol(String name, Type returnType, VariableSymbol[] args)
	{
		super(name, returnType);
		this.args = args;
	}

	public int argNum() { return this.args.length; }
	public VariableSymbol getArg(int i) { return this.args[i]; }
}
