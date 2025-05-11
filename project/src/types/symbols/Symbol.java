package types.symbols;

import types.*;

public class Symbol
{
	private String name;
	private Type type;

	public Symbol(String name, Type type)
	{
		this.name = name;
		this.type = type;
	}

	public Type type() { return this.type; }
	public String name() { return this.name; }
}
