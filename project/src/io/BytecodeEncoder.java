package io;

import java.io.*;

import types.ConstType;
import types.Type;
import types.Value;
import vm.Instruction;

public class BytecodeEncoder
{
	private Value[] constantPool;
	private Instruction[] instructions;

	public BytecodeEncoder(byte[] bytecodes)
	{
		decode(bytecodes);
	}

	public BytecodeEncoder(Value[] constantPool, Instruction[] instructions)
	{
		this.constantPool = constantPool;
		this.instructions = instructions;
	}

	private void decode(byte[] bytecodes)
	{
		try(DataInputStream in = new DataInputStream(new ByteArrayInputStream(bytecodes)))
		{
			decodeConstantPool(in);
			decodeInstructions(in);
			in.close();
		}
		catch (IOException e)
		{
			System.out.println("IO error on decoding bytecodes:\n" + e.getMessage());
		}
	}

	private void decodeConstantPool(DataInputStream in) throws IOException
	{
		int numConstants = in.readInt();
		this.constantPool = new Value[numConstants];

		for (int i = 0; i < numConstants; i++)
		{
			Value value;

			ConstType constType = ConstType.values()[in.readByte()];
			if (constType == ConstType.DOUBLE)
			{
				double d = in.readDouble();
				value = new Value(Type.DOUBLE, d);
			}
			else if (constType == ConstType.STRING)
			{
				int strLen = in.readInt();
				StringBuilder builder = new StringBuilder();
				for (int j = 0; j < strLen; j++)
					builder.append(in.readChar());
				String str = builder.toString();
				value = new Value(Type.STRING, str);
			}
			else
				throw new IllegalStateException("Unknown constant type.");

			this.constantPool[i] = value;
		}
	}

	public void encodeConstantPool(DataOutputStream out) throws IOException
	{
		out.writeInt(constantPool.length);
		for (int i = 0; i < constantPool.length; i++)
		{
			if (constantPool[i].type() == Type.DOUBLE)
			{
				out.writeByte(ConstType.DOUBLE.ordinal());
				out.writeDouble(constantPool[i].getDouble());
			}
			else if (constantPool[i].type() == Type.STRING)
			{
				out.writeByte(ConstType.STRING.ordinal());
				String str = constantPool[i].getString();
				out.writeInt(str.length());
				for (int j = 0; j < str.length(); j++)
					out.writeChar(str.charAt(j));
			}
			else
				throw new IllegalStateException("Cannot assign this type to a constant.");
		}
	}

	private void decodeInstructions(DataInputStream in) throws IOException
	{
		int numInstructions = in.readInt();
		this.instructions = new Instruction[numInstructions];
		for (int i = 0; i < numInstructions; i++)
			this.instructions[i] = Instruction.readFrom(in);
	}

	public void encodeInstructions(DataOutputStream out) throws IOException
	{
		out.writeInt(this.instructions.length);
		for (Instruction inst : instructions)
			inst.writeTo(out);
	}

	public byte[] encode()
	{
		byte[] bytes = null;
		try(ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
			DataOutputStream out = new DataOutputStream(byteOut))
		{
			encodeConstantPool(out);
			encodeInstructions(out);
			bytes = byteOut.toByteArray();
			out.close();
		}
		catch (IOException e)
		{
			System.out.println("IO error on decoding bytecodes:\n" + e.getMessage());
		}
		return bytes;
	}

	public Value[] getConstantPool()
	{
		return this.constantPool;
	}

	public Instruction[] getInstructions()
	{
		return this.instructions;
	}
}
