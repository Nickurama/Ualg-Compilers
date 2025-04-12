package io;

import java.io.*;
import java.util.ArrayList;

import vm.Instruction;

public class InstructionIO
{
	public static Instruction[] read(String filename) throws IOException
	{
		ArrayList<Instruction> instructions = new ArrayList<Instruction>();
		File file = new File(filename);
		try (DataInputStream in = new DataInputStream(new FileInputStream(file)))
		{
			while (in.available() > 0)
			{
				try
				{
					instructions.add(Instruction.readFrom(in));
				}
				catch (EOFException e)
				{
					break;
				}
			}
		}
		Instruction[] result = new Instruction[instructions.size()];
		instructions.toArray(result);
		return result;
	}

	public static void write(Instruction[] instructions, String filename) throws IOException
	{
		File file = new File(filename);
		try (DataOutputStream out = new DataOutputStream(new FileOutputStream(file)))
		{
			for (Instruction inst : instructions)
				inst.writeTo(out);
		}
	}
}
