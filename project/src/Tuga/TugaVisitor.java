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
	 * Visit a parse tree produced by the {@code VarDecl}
	 * labeled alternative in {@link TugaParser#var_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(TugaParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link TugaParser#inst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInst(TugaParser.InstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrintInst}
	 * labeled alternative in {@link TugaParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintInst(TugaParser.PrintInstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignInst}
	 * labeled alternative in {@link TugaParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignInst(TugaParser.AssignInstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ScopeInst}
	 * labeled alternative in {@link TugaParser#scope}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScopeInst(TugaParser.ScopeInstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfInst}
	 * labeled alternative in {@link TugaParser#if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfInst(TugaParser.IfInstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InlineIfInst}
	 * labeled alternative in {@link TugaParser#if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInlineIfInst(TugaParser.InlineIfInstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ElseInst}
	 * labeled alternative in {@link TugaParser#else}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseInst(TugaParser.ElseInstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InlineElseInst}
	 * labeled alternative in {@link TugaParser#else}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInlineElseInst(TugaParser.InlineElseInstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileInst}
	 * labeled alternative in {@link TugaParser#while}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileInst(TugaParser.WhileInstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InlineWhileInst}
	 * labeled alternative in {@link TugaParser#while}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInlineWhileInst(TugaParser.InlineWhileInstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyInst}
	 * labeled alternative in {@link TugaParser#empty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyInst(TugaParser.EmptyInstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarSingle}
	 * labeled alternative in {@link TugaParser#vars}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarSingle(TugaParser.VarSingleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarMultiple}
	 * labeled alternative in {@link TugaParser#vars}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarMultiple(TugaParser.VarMultipleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IDExpr}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIDExpr(TugaParser.IDExprContext ctx);
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