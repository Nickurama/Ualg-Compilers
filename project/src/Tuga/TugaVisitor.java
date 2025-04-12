// Generated from Tuga.g4 by ANTLR 4.13.2
package Tuga;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TugaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TugaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TugaParser#tuga}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTuga(TugaParser.TugaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrintInst}
	 * labeled alternative in {@link TugaParser#inst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintInst(TugaParser.PrintInstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqualsOp}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualsOp(TugaParser.EqualsOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OrOp}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrOp(TugaParser.OrOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultDivOp}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultDivOp(TugaParser.MultDivOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SumSubOp}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSumSubOp(TugaParser.SumSubOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicNegateOp}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicNegateOp(TugaParser.LogicNegateOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralExpr}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralExpr(TugaParser.LiteralExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RelOp}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelOp(TugaParser.RelOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(TugaParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArithmeticNegateOp}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticNegateOp(TugaParser.ArithmeticNegateOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AndOp}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndOp(TugaParser.AndOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link TugaParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(TugaParser.IntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Double}
	 * labeled alternative in {@link TugaParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDouble(TugaParser.DoubleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code String}
	 * labeled alternative in {@link TugaParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(TugaParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code True}
	 * labeled alternative in {@link TugaParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrue(TugaParser.TrueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code False}
	 * labeled alternative in {@link TugaParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalse(TugaParser.FalseContext ctx);
}