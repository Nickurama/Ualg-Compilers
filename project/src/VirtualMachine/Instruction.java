package VirtualMachine;

import java.io.*;
import java.util.ArrayList;

public class Instruction
{
	private OpCode opCode;
	private int[] args;

	public Instruction(OpCode opCode, int ...args)
	{
		if (this.opCode.nArgs() != args.length)
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

	public static Instruction[] decode(byte[] bytecodes)
	{
		ArrayList<Instruction> instructions = new ArrayList<Instruction>();
		DataInputStream in = new DataInputStream(new ByteArrayInputStream(bytecodes));
		try
		{
			while (in.available() > 0)
			{
				System.out.println("available: " + in.available());
				instructions.add(readFrom(in));
			}

			in.close();
		}
		catch (IOException e)
		{
			System.err.println("IO error on decoding bytecodes:\n" + e.getMessage());
		}

		Instruction[] result = new Instruction[instructions.size()];
		return instructions.toArray(result);
	}

	public static byte[] encode(Instruction[] instructions)
	{
		byte[] result = null;
		try
		{
			ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
			DataOutputStream out = new DataOutputStream(byteOut);

			for (Instruction inst : instructions)
				inst.writeTo(out);

			result = byteOut.toByteArray();
		}
		catch (IOException e)
		{
			System.err.println("IO error on enconding instructions:\n" + e.getMessage());
		}

		return result;
	}
}
