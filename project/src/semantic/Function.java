package semantic;

import types.*;

public class Function
{
	private String name;
	private Type retType;
	private Argument[] args;

	public Function(String name, Type retType, Argument[] args)
	{
		this.name = name;
		this.retType = retType;
		this.args = args;
	}

	public String name() { return this.name; }
	public Type returnType() { return this.retType; }
	public int argNum() { return args.length; }
	public Argument getArg(int i) { return this.args[i]; }

	@Override
	public boolean equals(Object other)
	{
		if (this == other) return true;
		if (other == null) return false;
		if (this.getClass() != other.getClass()) return false;
		Function that = (Function) other;

		// just takes into account the function's name
		if (!this.name.equals(that.name))
			return false;
		return true;
	}

	@Override
	public int hashCode()
	{
		// just takes into account the function's name
		return this.name.hashCode();
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();

		builder.append(name);
		builder.append(" (");
		builder.append(retType);
		builder.append(")");

		for (Argument arg : args)
		{
			builder.append("\n\t- ");
			builder.append(arg.name());
			builder.append(" (");
			builder.append(arg.type());
			builder.append(")");
		}

		return builder.toString();
	}
}
