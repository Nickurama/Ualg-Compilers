// Generated from LExpr.g4 by ANTLR 4.13.2
package LExpr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LExprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LExprParser#s}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitS(LExprParser.SContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrimaryOp}
	 * labeled alternative in {@link LExprParser#e}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryOp(LExprParser.PrimaryOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NegateOp}
	 * labeled alternative in {@link LExprParser#e}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegateOp(LExprParser.NegateOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SecondaryOp}
	 * labeled alternative in {@link LExprParser#e}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSecondaryOp(LExprParser.SecondaryOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Num}
	 * labeled alternative in {@link LExprParser#e}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNum(LExprParser.NumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link LExprParser#e}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(LExprParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PowerOp}
	 * labeled alternative in {@link LExprParser#e}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowerOp(LExprParser.PowerOpContext ctx);
}