// Generated from LExpr.g4 by ANTLR 4.13.2
package LExpr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LExprParser}.
 */
public interface LExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LExprParser#s}.
	 * @param ctx the parse tree
	 */
	void enterS(LExprParser.SContext ctx);
	/**
	 * Exit a parse tree produced by {@link LExprParser#s}.
	 * @param ctx the parse tree
	 */
	void exitS(LExprParser.SContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrimaryOp}
	 * labeled alternative in {@link LExprParser#e}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryOp(LExprParser.PrimaryOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrimaryOp}
	 * labeled alternative in {@link LExprParser#e}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryOp(LExprParser.PrimaryOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NegateOp}
	 * labeled alternative in {@link LExprParser#e}.
	 * @param ctx the parse tree
	 */
	void enterNegateOp(LExprParser.NegateOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NegateOp}
	 * labeled alternative in {@link LExprParser#e}.
	 * @param ctx the parse tree
	 */
	void exitNegateOp(LExprParser.NegateOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SecondaryOp}
	 * labeled alternative in {@link LExprParser#e}.
	 * @param ctx the parse tree
	 */
	void enterSecondaryOp(LExprParser.SecondaryOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SecondaryOp}
	 * labeled alternative in {@link LExprParser#e}.
	 * @param ctx the parse tree
	 */
	void exitSecondaryOp(LExprParser.SecondaryOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Num}
	 * labeled alternative in {@link LExprParser#e}.
	 * @param ctx the parse tree
	 */
	void enterNum(LExprParser.NumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Num}
	 * labeled alternative in {@link LExprParser#e}.
	 * @param ctx the parse tree
	 */
	void exitNum(LExprParser.NumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link LExprParser#e}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(LExprParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link LExprParser#e}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(LExprParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PowerOp}
	 * labeled alternative in {@link LExprParser#e}.
	 * @param ctx the parse tree
	 */
	void enterPowerOp(LExprParser.PowerOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PowerOp}
	 * labeled alternative in {@link LExprParser#e}.
	 * @param ctx the parse tree
	 */
	void exitPowerOp(LExprParser.PowerOpContext ctx);
}