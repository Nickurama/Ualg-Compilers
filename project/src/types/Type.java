package types;

public enum Type
{
	INT()
	{
		@Override
		public boolean isNumerical() { return true; }

		@Override
		public String toString() { return "inteiro"; }
	},
	DOUBLE()
	{
		@Override
		public boolean isNumerical() { return true; }

		@Override
		public String toString() { return "real"; }
	},
	STRING()
	{
		@Override
		public boolean isNumerical() { return false; }

		@Override
		public String toString() { return "string"; }
	},
	BOOL()
	{
		@Override
		public boolean isNumerical() { return false; }

		@Override
		public String toString() { return "booleano"; }
	},
	ERROR()
	{
		@Override
		public boolean isNumerical() { return false; }

		@Override
		public String toString() { return "erro"; }
	};

	public abstract boolean isNumerical();
}
