package VirtualMachine;

import java.util.*;

public class VirtualMachine
{
	private boolean showTrace;
	private final byte[] bytecodes;
	private int ip;
	private final Stack<Integer> runtimeStack;

	public VirtualMachine(byte[] bytecodes, boolean showTrace)
	{
		this.showTrace = showTrace;
		this.bytecodes = bytecodes;
		this.ip = 0;
		this.runtimeStack = new Stack<Integer>();
	}
}
