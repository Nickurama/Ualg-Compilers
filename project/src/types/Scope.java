package types;

import java.util.*;
import types.symbols.*;

public class Scope
{
	Scope parent;
	HashMap<String, Symbol> vars;

	public Scope() { this(null); }
	public Scope(Scope parent)
	{
		this.parent = parent;
		this.vars = new HashMap<String, Symbol>();
	}

	public void register(Symbol symbol)
	{
		if (this.vars.containsKey(symbol.name()))
			throw new IllegalArgumentException("Scope already contains variable.");

		this.vars.put(symbol.name(), symbol);
	}

	public boolean contains(String name)
	{
		if (this.vars.containsKey(name))
			return true;
		if (this.parent == null)
			return false;
		return this.parent.contains(name);
	}

	public Symbol getSymbol(String name)
	{
		if (this.vars.containsKey(name))
			return this.vars.get(name);
		if (this.parent == null)
			return null;
		return this.parent.getSymbol(name);
	}

	public Scope parent()
	{
		return this.parent;
	}
}
