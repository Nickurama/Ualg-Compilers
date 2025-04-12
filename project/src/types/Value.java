package types;

public class Value
{
	private final Type type;
	private final Object value;

	public Value(Type type, Object value)
	{
		this.type = type;
		this.value = value;
	}

	public Type type()
	{
		return this.type;
	}

	public Integer getInt()
	{
		if (this.type != Type.INT)
			throw new IllegalStateException("Cannot get the INT value from a " + this.type + ".");
		return (Integer) value;
	}

	public Double getDouble()
	{
		if (this.type != Type.DOUBLE)
			throw new IllegalStateException("Cannot get the DOUBLE value from a " + this.type + ".");
		return (Double) value;
	}

	public String getString()
	{
		if (this.type != Type.STRING)
			throw new IllegalStateException("Cannot get the STRING value from a " + this.type + ".");
		return (String) value;
	}

	public Boolean getBool()
	{
		if (this.type != Type.BOOL)
			throw new IllegalStateException("Cannot get the BOOL value from a " + this.type + ".");
		return (Boolean) value;
	}

	public String getErrorValue()
	{
		if (this.type != Type.ERROR)
			throw new IllegalStateException("Cannot get the ERROR value from a " + this.type + ".");
		return (String) value;
	}
}
