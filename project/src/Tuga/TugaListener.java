// Generated from Tuga.g4 by ANTLR 4.13.2
package Tuga;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TugaParser}.
 */
public interface TugaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TugaParser#tuga}.
	 * @param ctx the parse tree
	 */
	void enterTuga(TugaParser.TugaContext ctx);
	/**
	 * Exit a parse tree produced by {@link TugaParser#tuga}.
	 * @param ctx the parse tree
	 */
	void exitTuga(TugaParser.TugaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrintInst}
	 * labeled alternative in {@link TugaParser#inst}.
	 * @param ctx the parse tree
	 */
	void enterPrintInst(TugaParser.PrintInstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrintInst}
	 * labeled alternative in {@link TugaParser#inst}.
	 * @param ctx the parse tree
	 */
	void exitPrintInst(TugaParser.PrintInstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryOp}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOp(TugaParser.UnaryOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryOp}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOp(TugaParser.UnaryOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralExpr}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLiteralExpr(TugaParser.LiteralExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralExpr}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLiteralExpr(TugaParser.LiteralExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(TugaParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(TugaParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinaryOp}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOp(TugaParser.BinaryOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinaryOp}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOp(TugaParser.BinaryOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticNegateOp}
	 * labeled alternative in {@link TugaParser#unary_op}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticNegateOp(TugaParser.ArithmeticNegateOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticNegateOp}
	 * labeled alternative in {@link TugaParser#unary_op}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticNegateOp(TugaParser.ArithmeticNegateOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicNegateOp}
	 * labeled alternative in {@link TugaParser#unary_op}.
	 * @param ctx the parse tree
	 */
	void enterLogicNegateOp(TugaParser.LogicNegateOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicNegateOp}
	 * labeled alternative in {@link TugaParser#unary_op}.
	 * @param ctx the parse tree
	 */
	void exitLogicNegateOp(TugaParser.LogicNegateOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultDivOp}
	 * labeled alternative in {@link TugaParser#binary_op}.
	 * @param ctx the parse tree
	 */
	void enterMultDivOp(TugaParser.MultDivOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultDivOp}
	 * labeled alternative in {@link TugaParser#binary_op}.
	 * @param ctx the parse tree
	 */
	void exitMultDivOp(TugaParser.MultDivOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SumSubOp}
	 * labeled alternative in {@link TugaParser#binary_op}.
	 * @param ctx the parse tree
	 */
	void enterSumSubOp(TugaParser.SumSubOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SumSubOp}
	 * labeled alternative in {@link TugaParser#binary_op}.
	 * @param ctx the parse tree
	 */
	void exitSumSubOp(TugaParser.SumSubOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RelOp}
	 * labeled alternative in {@link TugaParser#binary_op}.
	 * @param ctx the parse tree
	 */
	void enterRelOp(TugaParser.RelOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RelOp}
	 * labeled alternative in {@link TugaParser#binary_op}.
	 * @param ctx the parse tree
	 */
	void exitRelOp(TugaParser.RelOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqualsOp}
	 * labeled alternative in {@link TugaParser#binary_op}.
	 * @param ctx the parse tree
	 */
	void enterEqualsOp(TugaParser.EqualsOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqualsOp}
	 * labeled alternative in {@link TugaParser#binary_op}.
	 * @param ctx the parse tree
	 */
	void exitEqualsOp(TugaParser.EqualsOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AndOp}
	 * labeled alternative in {@link TugaParser#binary_op}.
	 * @param ctx the parse tree
	 */
	void enterAndOp(TugaParser.AndOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AndOp}
	 * labeled alternative in {@link TugaParser#binary_op}.
	 * @param ctx the parse tree
	 */
	void exitAndOp(TugaParser.AndOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OrOp}
	 * labeled alternative in {@link TugaParser#binary_op}.
	 * @param ctx the parse tree
	 */
	void enterOrOp(TugaParser.OrOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OrOp}
	 * labeled alternative in {@link TugaParser#binary_op}.
	 * @param ctx the parse tree
	 */
	void exitOrOp(TugaParser.OrOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Int}
	 * labeled alternative in {@link TugaParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterInt(TugaParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link TugaParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitInt(TugaParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Double}
	 * labeled alternative in {@link TugaParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterDouble(TugaParser.DoubleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Double}
	 * labeled alternative in {@link TugaParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitDouble(TugaParser.DoubleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code String}
	 * labeled alternative in {@link TugaParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterString(TugaParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code String}
	 * labeled alternative in {@link TugaParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitString(TugaParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code True}
	 * labeled alternative in {@link TugaParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterTrue(TugaParser.TrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code True}
	 * labeled alternative in {@link TugaParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitTrue(TugaParser.TrueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code False}
	 * labeled alternative in {@link TugaParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterFalse(TugaParser.FalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code False}
	 * labeled alternative in {@link TugaParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitFalse(TugaParser.FalseContext ctx);
}