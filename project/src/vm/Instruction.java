package vm;

import java.io.*;
import java.util.ArrayList;

public class Instruction
{
	private OpCode opCode;
	private int[] args;

	public Instruction(OpCode opCode, int ...args)
	{
		if (opCode.nArgs() != args.length)
			throw new IllegalArgumentException("opCode requires exactly " + opCode.nArgs() + " arguments.");
		this.opCode = opCode;
		this.args = args;
	}

	public OpCode opCode() { return opCode; }

	public int nArgs() { return opCode.nArgs(); }

	public int[] args() { return this.args; }

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append(opCode.toString());
		for (int i = 0; i < this.nArgs(); i++)
		{
			builder.append(" ");
			builder.append(args[i]);
		}
		return builder.toString();
	}

	public void writeTo(DataOutputStream out) throws IOException
	{
		out.writeByte(opCode.ordinal());
		for (int i = 0; i < this.nArgs(); i++)
			out.writeInt(args[i]);
	}

	public static Instruction readFrom(DataInputStream in) throws IOException
	{
		byte b = in.readByte();
		OpCode op = OpCode.convert(b);

		int[] args = new int[op.nArgs()];
		for (int i = 0; i < args.length; i++)
			args[i] = in.readInt();

		return new Instruction(op, args);
	}
}
