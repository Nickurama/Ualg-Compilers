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

	public int getInt()
	{
		if (this.type != Type.INT)
			throw new IllegalStateException("Cannot get the INT value from a " + this.type + ".");
		return (Integer) value;
	}

	public double getDouble()
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

	public boolean getBool()
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

	@Override
	public String toString()
	{
		String result;
		switch (this.type)
		{
			case Type.INT:
				result = String.valueOf(getInt());
				break;
			case Type.DOUBLE:
				result = String.valueOf(getDouble());
				break;
			case Type.STRING:
				result = "\"" + getString() + "\"";
				break;
			case Type.BOOL:
				result = String.valueOf(getBool());
				break;
			case Type.NULL:
				result = "NULL";
				break;
			case Type.ERROR:
				result = "ERROR";
				break;
			default:
				result = "UNKNOWN";
				break;
		}
		return result;
	}

	@Override
	public int hashCode()
	{
		// should not store error type!
		int hash = 0;
		if (this.type == Type.INT)
			hash = 137 * Integer.hashCode(this.getInt());
		else if (this.type == Type.DOUBLE)
			hash = 241 * Double.hashCode(this.getDouble());
		else if (this.type == Type.STRING)
			hash = 487 * this.getString().hashCode();
		else if (this.type == Type.BOOL)
			hash = 1031 * Boolean.hashCode(this.getBool());
		return hash;
	}

	@Override
	public boolean equals(Object other)
	{
		if (this == other) return true;
		if (other == null) return false;
		if (this.getClass() != other.getClass()) return false;
		Value that = (Value) other;
		if (this.type != that.type)
			return false;
		else if (this.type == Type.INT && this.getInt() != that.getInt())
			return false;
		else if (this.type == Type.DOUBLE && this.getDouble() != that.getDouble())
			return false;
		else if (this.type == Type.STRING && !this.getString().equals(that.getString()))
			return false;
		else if (this.type == Type.BOOL && this.getBool() != that.getBool())
			return false;
		return true;
	}
}
