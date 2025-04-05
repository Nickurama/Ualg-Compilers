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
	 * Visit a parse tree produced by {@link TugaParser#inst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInst(TugaParser.InstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryOp}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOp(TugaParser.UnaryOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralExpr}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralExpr(TugaParser.LiteralExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(TugaParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinaryOp}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOp(TugaParser.BinaryOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArithmeticNegateOp}
	 * labeled alternative in {@link TugaParser#unary_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticNegateOp(TugaParser.ArithmeticNegateOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicNegateOp}
	 * labeled alternative in {@link TugaParser#unary_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicNegateOp(TugaParser.LogicNegateOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArithmeticMultDivOp}
	 * labeled alternative in {@link TugaParser#binary_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticMultDivOp(TugaParser.ArithmeticMultDivOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArithmeticSumSubOp}
	 * labeled alternative in {@link TugaParser#binary_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticSumSubOp(TugaParser.ArithmeticSumSubOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicRelOp}
	 * labeled alternative in {@link TugaParser#binary_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicRelOp(TugaParser.LogicRelOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicEqualsOp}
	 * labeled alternative in {@link TugaParser#binary_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicEqualsOp(TugaParser.LogicEqualsOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicAndOp}
	 * labeled alternative in {@link TugaParser#binary_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicAndOp(TugaParser.LogicAndOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicOrOp}
	 * labeled alternative in {@link TugaParser#binary_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicOrOp(TugaParser.LogicOrOpContext ctx);
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