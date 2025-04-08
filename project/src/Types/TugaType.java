package Types;

public enum TugaType
{
	INT()
	{
		@Override
		public boolean isNumerical() { return true; }
	},
	DOUBLE()
	{
		@Override
		public boolean isNumerical() { return true; }
	},
	STRING()
	{
		@Override
		public boolean isNumerical() { return false; }
	},
	BOOL()
	{
		@Override
		public boolean isNumerical() { return false; }
	},
	ERROR()
	{
		@Override
		public boolean isNumerical() { return false; }
	};

	public abstract boolean isNumerical();
}
