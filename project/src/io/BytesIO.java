package io;

import java.io.*;

public class BytesIO
{
	public static byte[] read(String filename) throws IOException
	{
		byte[] bytes;
		File file = new File(filename);
		bytes = new byte[(int)file.length()];
		try (FileInputStream in = new FileInputStream(file))
		{
			in.read(bytes);
		}
		return bytes;
	}

	public static void write(byte[] bytes, String filename) throws IOException
	{
		File file = new File(filename);
		try (FileOutputStream out = new FileOutputStream(file))
		{
			out.write(bytes);
		}
	}
}
