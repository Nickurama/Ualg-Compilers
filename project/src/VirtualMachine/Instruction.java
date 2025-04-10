package VirtualMachine;

import java.io.DataOutputStream;
import java.io.IOException;

import VirtualMachine.OpCode;

public class Instruction
{
	OpCode opCode;
	int[] args;

	public Instruction(OpCode opCode, int ...args)
	{
		if (this.opCode.nArgs() != args.length)
			throw new IllegalArgumentException("opCode requires exactly " + opCode.nArgs() + " arguments.");
		this.opCode = opCode;
		this.args = args;
	}

	public OpCode getOpCode() { return opCode; }

	public int nArgs() { return opCode.nArgs(); }

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
}
