package vm;

import java.io.*;
import java.util.*;

import io.BytecodeEncoder;
import types.*;

public class VirtualMachine
{
	private boolean showTrace;
	private boolean halt;
	private final Stack<Value> stack;
	// private Value[] heap;
	private final ArrayList<Value> heap;
	private final byte[] bytecodes;
	private final Value[] constantPool;
	private final Instruction[] code;
	private int ip;

	public VirtualMachine(byte[] bytecodes, boolean showTrace)
	{
		this.showTrace = showTrace;
		this.halt = false;
		this.stack = new Stack<Value>();
		this.heap = new ArrayList<Value>();
		// this.heap = new Value[0];
		this.bytecodes = bytecodes;
		BytecodeEncoder encoder = new BytecodeEncoder(bytecodes);
		this.constantPool = encoder.getConstantPool();
		this.code = encoder.getInstructions();
		if (showTrace)
		{
			//dumpInstructions();
			// dumpInstructionsAndBytecodes();
		}
		this.ip = 0;
	}

	public void run()
	{
		if (showTrace)
		{
            System.out.println("Trace while running the code");
            System.out.println("Execution starts at instrution " + ip);
		}

		halt = false;
		while (ip < code.length && !halt)
			exec(code[ip++]);

		if (showTrace)
		{
            System.out.println(String.format("%22s Stack: %s", "", stack));
		}
	}

	private void runtimeError(String msg)
	{
		// System.err.println("runtime error: " + msg);
		System.err.println("erro de runtime: " + msg);
		if (showTrace)
			System.err.println(String.format("%22s Stack: %s", "", stack));
		System.exit(1);
	}

	public void dumpConstantPool()
	{
		for (int i = 0; i < constantPool.length; i++)
			System.out.println(i + ": " + constantPool[i]);
	}

	// public void dumpInstructionsAndBytecodes()
	// {
	// 	System.out.println("Disassembled instructions");
	// 	int byte_i = 0;
	// 	int code_i = 0;
	// 	while (code_i < code.length)
	// 	{
	// 		StringBuilder builder = new StringBuilder();
	// 		builder.append(String.format("%02X ", bytecodes[byte_i++]));
	// 		for (int i = 0; i < code[code_i].nArgs(); i++)
	// 			for (int k = 0; k < 4; k++) // 4 bytes for each integer argument
	// 				builder.append(String.format("%02X ", bytecodes[byte_i++]));
	// 		String result = String.format("%5s: %-15s // %s", code_i, code[code_i], builder.toString());
	// 		System.out.println(result);
	// 	}
	// }

	public void dumpInstructions()
	{
		for (int i = 0; i < code.length; i++)
			System.out.println(i + ": " + code[i]);
	}

	private void checkType(Value value, Type expectedType)
	{
		if (value.type() != expectedType)
		{
			runtimeError("Instruction type " + value.type().name() +
						" mismatches type " + expectedType.name());
		}
	}

	private void exec_iconst(int arg)
	{
		Value value = new Value(Type.INT, arg);
		stack.push(value);
	}

	private void exec_dconst(int arg)
	{
		Value value = constantPool[arg];
		checkType(value, Type.DOUBLE);
		stack.push(value);
	}

	private void exec_sconst(int arg)
	{
		Value value = constantPool[arg];
		checkType(value, Type.STRING);
		stack.push(value);
	}

	private void exec_iprint()
	{
		Value value = stack.pop();
		checkType(value, Type.INT);
		System.out.println(value.getInt());
	}

	private void exec_iuminus()
	{
		Value value = stack.pop();
		checkType(value, Type.INT);
		Value newValue = new Value(Type.INT, -value.getInt());
		stack.push(newValue);
	}

	private void exec_iadd()
	{
		Value rightValue = stack.pop();
		Value leftValue = stack.pop();
		checkType(rightValue, Type.INT);
		checkType(leftValue, Type.INT);
		Value result = new Value(Type.INT, leftValue.getInt() + rightValue.getInt());
		stack.push(result);
	}

	private void exec_isub()
	{
		Value rightValue = stack.pop();
		Value leftValue = stack.pop();
		checkType(rightValue, Type.INT);
		checkType(leftValue, Type.INT);
		Value result = new Value(Type.INT, leftValue.getInt() - rightValue.getInt());
		stack.push(result);
	}

	private void exec_imult()
	{
		Value rightValue = stack.pop();
		Value leftValue = stack.pop();
		checkType(rightValue, Type.INT);
		checkType(leftValue, Type.INT);
		Value result = new Value(Type.INT, leftValue.getInt() * rightValue.getInt());
		stack.push(result);
	}

	private void exec_idiv()
	{
		Value rightValue = stack.pop();
		Value leftValue = stack.pop();
		checkType(rightValue, Type.INT);
		checkType(leftValue, Type.INT);
		if (rightValue.getInt() == 0)
			runtimeError("division by 0");
		Value result = new Value(Type.INT, leftValue.getInt() / rightValue.getInt());
		stack.push(result);
	}

	private void exec_imod()
	{
		Value rightValue = stack.pop();
		Value leftValue = stack.pop();
		checkType(rightValue, Type.INT);
		checkType(leftValue, Type.INT);
		if (rightValue.getInt() == 0)
			runtimeError("division by 0");
		Value result = new Value(Type.INT, leftValue.getInt() % rightValue.getInt());
		stack.push(result);
	}

	private void exec_ieq()
	{
		Value rightValue = stack.pop();
		Value leftValue = stack.pop();
		checkType(rightValue, Type.INT);
		checkType(leftValue, Type.INT);
		Value result = new Value(Type.BOOL, leftValue.getInt() == rightValue.getInt());
		stack.push(result);
	}

	private void exec_ineq()
	{
		Value rightValue = stack.pop();
		Value leftValue = stack.pop();
		checkType(rightValue, Type.INT);
		checkType(leftValue, Type.INT);
		Value result = new Value(Type.BOOL, leftValue.getInt() != rightValue.getInt());
		stack.push(result);
	}

	private void exec_ilt()
	{
		Value rightValue = stack.pop();
		Value leftValue = stack.pop();
		checkType(rightValue, Type.INT);
		checkType(leftValue, Type.INT);
		Value result = new Value(Type.BOOL, leftValue.getInt() < rightValue.getInt());
		stack.push(result);
	}

	private void exec_ileq()
	{
		Value rightValue = stack.pop();
		Value leftValue = stack.pop();
		checkType(rightValue, Type.INT);
		checkType(leftValue, Type.INT);
		Value result = new Value(Type.BOOL, leftValue.getInt() <= rightValue.getInt());
		stack.push(result);
	}

	private void exec_itod()
	{
		Value value = stack.pop();
		checkType(value, Type.INT);
		Value newValue = new Value(Type.DOUBLE, (double)value.getInt());
		stack.push(newValue);
	}

	private void exec_itos()
	{
		Value value = stack.pop();
		checkType(value, Type.INT);
		Value newValue = new Value(Type.STRING, String.valueOf(value.getInt()));
		stack.push(newValue);
	}

	private void exec_dprint()
	{
		Value value = stack.pop();
		checkType(value, Type.DOUBLE);
		System.out.println(value.getDouble());
	}

	private void exec_duminus()
	{
		Value value = stack.pop();
		checkType(value, Type.DOUBLE);
		Value newValue = new Value(Type.DOUBLE, -value.getDouble());
		stack.push(newValue);
	}

	private void exec_dadd()
	{
		Value rightValue = stack.pop();
		Value leftValue = stack.pop();
		checkType(rightValue, Type.DOUBLE);
		checkType(leftValue, Type.DOUBLE);
		Value result = new Value(Type.DOUBLE, leftValue.getDouble() + rightValue.getDouble());
		stack.push(result);
	}

	private void exec_dsub()
	{
		Value rightValue = stack.pop();
		Value leftValue = stack.pop();
		checkType(rightValue, Type.DOUBLE);
		checkType(leftValue, Type.DOUBLE);
		Value result = new Value(Type.DOUBLE, leftValue.getDouble() - rightValue.getDouble());
		stack.push(result);
	}

	private void exec_dmult()
	{
		Value rightValue = stack.pop();
		Value leftValue = stack.pop();
		checkType(rightValue, Type.DOUBLE);
		checkType(leftValue, Type.DOUBLE);
		Value result = new Value(Type.DOUBLE, leftValue.getDouble() * rightValue.getDouble());
		stack.push(result);
	}

	private void exec_ddiv()
	{
		Value rightValue = stack.pop();
		Value leftValue = stack.pop();
		checkType(rightValue, Type.DOUBLE);
		checkType(leftValue, Type.DOUBLE);
		if (rightValue.getDouble() == 0)
			runtimeError("division by 0");
		Value result = new Value(Type.DOUBLE, leftValue.getDouble() / rightValue.getDouble());
		stack.push(result);
	}

	private void exec_deq()
	{
		Value rightValue = stack.pop();
		Value leftValue = stack.pop();
		checkType(rightValue, Type.DOUBLE);
		checkType(leftValue, Type.DOUBLE);
		Value result = new Value(Type.BOOL, leftValue.getDouble() == rightValue.getDouble());
		stack.push(result);
	}

	private void exec_dneq()
	{
		Value rightValue = stack.pop();
		Value leftValue = stack.pop();
		checkType(rightValue, Type.DOUBLE);
		checkType(leftValue, Type.DOUBLE);
		Value result = new Value(Type.BOOL, leftValue.getDouble() != rightValue.getDouble());
		stack.push(result);
	}

	private void exec_dlt()
	{
		Value rightValue = stack.pop();
		Value leftValue = stack.pop();
		checkType(rightValue, Type.DOUBLE);
		checkType(leftValue, Type.DOUBLE);
		Value result = new Value(Type.BOOL, leftValue.getDouble() < rightValue.getDouble());
		stack.push(result);
	}

	private void exec_dleq()
	{
		Value rightValue = stack.pop();
		Value leftValue = stack.pop();
		checkType(rightValue, Type.DOUBLE);
		checkType(leftValue, Type.DOUBLE);
		Value result = new Value(Type.BOOL, leftValue.getDouble() <= rightValue.getDouble());
		stack.push(result);
	}

	private void exec_dtos()
	{
		Value value = stack.pop();
		checkType(value, Type.DOUBLE);
		Value newValue = new Value(Type.STRING, String.valueOf(value.getDouble()));
		stack.push(newValue);
	}

	private void exec_sprint()
	{
		Value value = stack.pop();
		checkType(value, Type.STRING);
		System.out.println(value.getString());
	}

	private void exec_sconcat()
	{
		Value rightValue = stack.pop();
		Value leftValue = stack.pop();
		checkType(rightValue, Type.STRING);
		checkType(leftValue, Type.STRING);
		Value result = new Value(Type.STRING, leftValue.getString().concat(rightValue.getString()));
		stack.push(result);
	}

	private void exec_seq()
	{
		Value rightValue = stack.pop();
		Value leftValue = stack.pop();
		checkType(rightValue, Type.STRING);
		checkType(leftValue, Type.STRING);
		Value result = new Value(Type.BOOL, leftValue.getString().equals(rightValue.getString()));
		stack.push(result);
	}

	private void exec_sneq()
	{
		Value rightValue = stack.pop();
		Value leftValue = stack.pop();
		checkType(rightValue, Type.STRING);
		checkType(leftValue, Type.STRING);
		Value result = new Value(Type.BOOL, !leftValue.getString().equals(rightValue.getString()));
		stack.push(result);
	}

	private void exec_tconst()
	{
		stack.push(new Value(Type.BOOL, true));
	}

	private void exec_fconst()
	{
		stack.push(new Value(Type.BOOL, false));
	}

	private void exec_bprint()
	{
		Value value = stack.pop();
		checkType(value, Type.BOOL);
		if (value.getBool())
			System.out.println("verdadeiro");
		else
			System.out.println("falso");
	}

	private void exec_beq()
	{
		Value rightValue = stack.pop();
		Value leftValue = stack.pop();
		checkType(rightValue, Type.BOOL);
		checkType(leftValue, Type.BOOL);
		Value result = new Value(Type.BOOL, leftValue.getBool() == rightValue.getBool());
		stack.push(result);
	}

	private void exec_bneq()
	{
		Value rightValue = stack.pop();
		Value leftValue = stack.pop();
		checkType(rightValue, Type.BOOL);
		checkType(leftValue, Type.BOOL);
		Value result = new Value(Type.BOOL, leftValue.getBool() != rightValue.getBool());
		stack.push(result);
	}

	private void exec_and()
	{
		Value rightValue = stack.pop();
		Value leftValue = stack.pop();
		checkType(rightValue, Type.BOOL);
		checkType(leftValue, Type.BOOL);
		Value result = new Value(Type.BOOL, leftValue.getBool() && rightValue.getBool());
		stack.push(result);
	}

	private void exec_or()
	{
		Value rightValue = stack.pop();
		Value leftValue = stack.pop();
		checkType(rightValue, Type.BOOL);
		checkType(leftValue, Type.BOOL);
		Value result = new Value(Type.BOOL, leftValue.getBool() || rightValue.getBool());
		stack.push(result);
	}

	private void exec_not()
	{
		Value value = stack.pop();
		checkType(value, Type.BOOL);
		Value newValue = new Value(Type.BOOL, !value.getBool());
		stack.push(newValue);
	}

	private void exec_btos()
	{
		Value value = stack.pop();
		checkType(value, Type.BOOL);
		Value newValue;
		if (value.getBool())
			newValue = new Value(Type.STRING, "verdadeiro");
		else
			newValue = new Value(Type.STRING, "falso");
		// Value newValue = new Value(Type.STRING, String.valueOf(value.getBool()));
		stack.push(newValue);
	}

	private void exec_halt()
	{
		halt = true;
	}

	private void exec_jump(int arg)
	{
		ip = arg;
	}

	private void exec_jumpf(int arg)
	{
		Value value = stack.pop();
		checkType(value, Type.BOOL);
		if (!value.getBool())
			ip = arg;
	}

	private void exec_galloc(int arg)
	{
		// Value[] tmp = new Value[heap.length + arg];
		// System.arraycopy(heap, 0, tmp, 0, heap.length);
		// heap = tmp;
		for (int i = 0; i < arg; i++)
			heap.add(new Value(Type.NULL, null));
	}

	private void exec_gload(int arg)
	{
		if (arg > heap.size() - 1 || arg < 0)
			runtimeError("Invalid address.");
		Value value = heap.get(arg);
		if (value.type() == Type.NULL)
			runtimeError("tentativa de acesso a valor NULO");
		stack.push(value);
	}

	private void exec_gstore(int arg)
	{
		if (arg > heap.size() - 1 || arg < 0)
			runtimeError("Invalid address.");
		Value value = stack.pop();
		heap.set(arg, value);
	}

	public void exec(Instruction inst)
	{
		if (showTrace)
            System.out.println(String.format("%5s: %-15s Stack: %s", ip, inst, stack));

		switch(inst.opCode())
		{
			case iconst:
				exec_iconst(inst.args()[0]);
				break;
			case dconst:
				exec_dconst(inst.args()[0]);
				break;
			case sconst:
				exec_sconst(inst.args()[0]);
				break;
			case iprint:
				exec_iprint();
				break;
			case iuminus:
				exec_iuminus();
				break;
			case iadd:
				exec_iadd();
				break;
			case isub:
				exec_isub();
				break;
			case imult:
				exec_imult();
				break;
			case idiv:
				exec_idiv();
				break;
			case imod:
				exec_imod();
				break;
			case ieq:
				exec_ieq();
				break;
			case ineq:
				exec_ineq();
				break;
			case ilt:
				exec_ilt();
				break;
			case ileq:
				exec_ileq();
				break;
			case itod:
				exec_itod();
				break;
			case itos:
				exec_itos();
				break;
			case dprint:
				exec_dprint();
				break;
			case duminus:
				exec_duminus();
				break;
			case dadd:
				exec_dadd();
				break;
			case dsub:
				exec_dsub();
				break;
			case dmult:
				exec_dmult();
				break;
			case ddiv:
				exec_ddiv();
				break;
			case deq:
				exec_deq();
				break;
			case dneq:
				exec_dneq();
				break;
			case dlt:
				exec_dlt();
				break;
			case dleq:
				exec_dleq();
				break;
			case dtos:
				exec_dtos();
				break;
			case sprint:
				exec_sprint();
				break;
			case sconcat:
				exec_sconcat();
				break;
			case seq:
				exec_seq();
				break;
			case sneq:
				exec_sneq();
				break;
			case tconst:
				exec_tconst();
				break;
			case fconst:
				exec_fconst();
				break;
			case bprint:
				exec_bprint();
				break;
			case beq:
				exec_beq();
				break;
			case bneq:
				exec_bneq();
				break;
			case and:
				exec_and();
				break;
			case or:
				exec_or();
				break;
			case not:
				exec_not();
				break;
			case btos:
				exec_btos();
				break;
			case halt:
				exec_halt();
				break;
			case jump:
				exec_jump(inst.args()[0]);
				break;
			case jumpf:
				exec_jumpf(inst.args()[0]);
				break;
			case galloc:
				exec_galloc(inst.args()[0]);
				break;
			case gload:
				exec_gload(inst.args()[0]);
				break;
			case gstore:
				exec_gstore(inst.args()[0]);
				break;
		}
	}
}
