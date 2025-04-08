package Types;

public class TugaValue
{
	private final TugaType type;
	private final Object value;

	public TugaValue(TugaType type, Object value)
	{
		this.type = type;
		this.value = value;
	}

	public TugaType type()
	{
		return this.type;
	}

	public Integer getInt()
	{
		if (this.type != TugaType.INT)
			throw new IllegalStateException("Cannot get the INT value from a " + this.type + ".");
		return (Integer) value;
	}

	public Double getDouble()
	{
		if (this.type != TugaType.DOUBLE)
			throw new IllegalStateException("Cannot get the DOUBLE value from a " + this.type + ".");
		return (Double) value;
	}

	public String getString()
	{
		if (this.type != TugaType.STRING)
			throw new IllegalStateException("Cannot get the STRING value from a " + this.type + ".");
		return (String) value;
	}

	public Boolean getBool()
	{
		if (this.type != TugaType.BOOL)
			throw new IllegalStateException("Cannot get the BOOL value from a " + this.type + ".");
		return (Boolean) value;
	}

	public String getErrorValue()
	{
		if (this.type != TugaType.ERROR)
			throw new IllegalStateException("Cannot get the ERROR value from a " + this.type + ".");
		return (String) value;
	}
}
