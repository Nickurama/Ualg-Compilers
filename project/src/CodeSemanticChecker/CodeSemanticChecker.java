package CodeSemanticChecker;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

import Tuga.*;
import Types.*;

public class CodeSemanticChecker extends TugaBaseVisitor<TugaType>
{
	private ParseTreeProperty<TugaType> types;

	public CodeSemanticChecker(ParseTreeProperty<TugaType> types)
	{
		this.types = types;
	}

	@Override
	public TugaType visitMultDivOp(TugaParser.MultDivOpContext ctx)
	{
		TugaParser.BinaryOpContext parentContext = (TugaParser.BinaryOpContext)ctx.getParent();
		TugaType leftType = visit(parentContext.expr(0));
		TugaType rightType = visit(parentContext.expr(1));

		if (leftType.isNumerical() && rightType.isNumerical())
		{
			if (leftType == TugaType.DOUBLE || rightType == TugaType.DOUBLE)
			{
				if (ctx.op.getType() == TugaParser.MOD)
					return TugaType.ERROR;
				return TugaType.DOUBLE;
			}
			return TugaType.INT;
		}

		return TugaType.ERROR;
	}

	@Override
	public TugaType visitInt(TugaParser.IntContext ctx)
	{
		// Integer.valueOf(ctx.INT().getText());
		return TugaType.INT;
	}
}
