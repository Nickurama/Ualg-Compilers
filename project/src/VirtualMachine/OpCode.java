package VirtualMachine;

import java.io.DataOutputStream;
import java.io.IOException;

public enum OpCode
{
	iconst(1),
	dconst(1),
	sconst(1),
	iprint(0),
	iuminus(0),
	iadd(0),
	isub(0),
	imult(0),
	idiv(0),
	imod(0),
	ieq(0),
	ineq(0),
	ilt(0),
	ileq(0),
	itod(0),
	itos(0),
	dprint(0),
	duminus(0),
	dadd(0),
	dsub(0),
	dmult(0),
	ddiv(0),
	deq(0),
	dneq(0),
	dlt(0),
	dleq(0),
	dtos(0),
	sprint(0),
	sconcat(0),
	seq(0),
	sneq(0),
	tconst(0),
	fconst(0),
	bprint(0),
	beq(0),
	bneq(0),
	and(0),
	or(0),
	not(0),
	btos(0),
	halt(0)
	;

	private final int nArgs;

	OpCode(int nArgs) { this.nArgs = nArgs; }

	public int nArgs() { return nArgs; }

	public static OpCode convert(byte value)
	{
		return OpCode.values()[value];
	}
}
