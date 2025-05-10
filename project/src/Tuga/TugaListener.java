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
	 * Enter a parse tree produced by the {@code VarDecl}
	 * labeled alternative in {@link TugaParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(TugaParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarDecl}
	 * labeled alternative in {@link TugaParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(TugaParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FuncDecl}
	 * labeled alternative in {@link TugaParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFuncDecl(TugaParser.FuncDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FuncDecl}
	 * labeled alternative in {@link TugaParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFuncDecl(TugaParser.FuncDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArgSingle}
	 * labeled alternative in {@link TugaParser#arg_list}.
	 * @param ctx the parse tree
	 */
	void enterArgSingle(TugaParser.ArgSingleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArgSingle}
	 * labeled alternative in {@link TugaParser#arg_list}.
	 * @param ctx the parse tree
	 */
	void exitArgSingle(TugaParser.ArgSingleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArgMultiple}
	 * labeled alternative in {@link TugaParser#arg_list}.
	 * @param ctx the parse tree
	 */
	void enterArgMultiple(TugaParser.ArgMultipleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArgMultiple}
	 * labeled alternative in {@link TugaParser#arg_list}.
	 * @param ctx the parse tree
	 */
	void exitArgMultiple(TugaParser.ArgMultipleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprSingle}
	 * labeled alternative in {@link TugaParser#expr_list}.
	 * @param ctx the parse tree
	 */
	void enterExprSingle(TugaParser.ExprSingleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprSingle}
	 * labeled alternative in {@link TugaParser#expr_list}.
	 * @param ctx the parse tree
	 */
	void exitExprSingle(TugaParser.ExprSingleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprMultiple}
	 * labeled alternative in {@link TugaParser#expr_list}.
	 * @param ctx the parse tree
	 */
	void enterExprMultiple(TugaParser.ExprMultipleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprMultiple}
	 * labeled alternative in {@link TugaParser#expr_list}.
	 * @param ctx the parse tree
	 */
	void exitExprMultiple(TugaParser.ExprMultipleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Argument}
	 * labeled alternative in {@link TugaParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArgument(TugaParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Argument}
	 * labeled alternative in {@link TugaParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArgument(TugaParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FuncCall}
	 * labeled alternative in {@link TugaParser#func_call}.
	 * @param ctx the parse tree
	 */
	void enterFuncCall(TugaParser.FuncCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FuncCall}
	 * labeled alternative in {@link TugaParser#func_call}.
	 * @param ctx the parse tree
	 */
	void exitFuncCall(TugaParser.FuncCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link TugaParser#inst}.
	 * @param ctx the parse tree
	 */
	void enterInst(TugaParser.InstContext ctx);
	/**
	 * Exit a parse tree produced by {@link TugaParser#inst}.
	 * @param ctx the parse tree
	 */
	void exitInst(TugaParser.InstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrintInst}
	 * labeled alternative in {@link TugaParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrintInst(TugaParser.PrintInstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrintInst}
	 * labeled alternative in {@link TugaParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrintInst(TugaParser.PrintInstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignInst}
	 * labeled alternative in {@link TugaParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssignInst(TugaParser.AssignInstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignInst}
	 * labeled alternative in {@link TugaParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssignInst(TugaParser.AssignInstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ScopeInst}
	 * labeled alternative in {@link TugaParser#scope}.
	 * @param ctx the parse tree
	 */
	void enterScopeInst(TugaParser.ScopeInstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ScopeInst}
	 * labeled alternative in {@link TugaParser#scope}.
	 * @param ctx the parse tree
	 */
	void exitScopeInst(TugaParser.ScopeInstContext ctx);
	/**
	 * Enter a parse tree produced by {@link TugaParser#scope_or_inline}.
	 * @param ctx the parse tree
	 */
	void enterScope_or_inline(TugaParser.Scope_or_inlineContext ctx);
	/**
	 * Exit a parse tree produced by {@link TugaParser#scope_or_inline}.
	 * @param ctx the parse tree
	 */
	void exitScope_or_inline(TugaParser.Scope_or_inlineContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfElseInst}
	 * labeled alternative in {@link TugaParser#ifelse}.
	 * @param ctx the parse tree
	 */
	void enterIfElseInst(TugaParser.IfElseInstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfElseInst}
	 * labeled alternative in {@link TugaParser#ifelse}.
	 * @param ctx the parse tree
	 */
	void exitIfElseInst(TugaParser.IfElseInstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfInst}
	 * labeled alternative in {@link TugaParser#if}.
	 * @param ctx the parse tree
	 */
	void enterIfInst(TugaParser.IfInstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfInst}
	 * labeled alternative in {@link TugaParser#if}.
	 * @param ctx the parse tree
	 */
	void exitIfInst(TugaParser.IfInstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileInst}
	 * labeled alternative in {@link TugaParser#while}.
	 * @param ctx the parse tree
	 */
	void enterWhileInst(TugaParser.WhileInstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileInst}
	 * labeled alternative in {@link TugaParser#while}.
	 * @param ctx the parse tree
	 */
	void exitWhileInst(TugaParser.WhileInstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FuncCallInst}
	 * labeled alternative in {@link TugaParser#func_call_inst}.
	 * @param ctx the parse tree
	 */
	void enterFuncCallInst(TugaParser.FuncCallInstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FuncCallInst}
	 * labeled alternative in {@link TugaParser#func_call_inst}.
	 * @param ctx the parse tree
	 */
	void exitFuncCallInst(TugaParser.FuncCallInstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnInst}
	 * labeled alternative in {@link TugaParser#return}.
	 * @param ctx the parse tree
	 */
	void enterReturnInst(TugaParser.ReturnInstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnInst}
	 * labeled alternative in {@link TugaParser#return}.
	 * @param ctx the parse tree
	 */
	void exitReturnInst(TugaParser.ReturnInstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyInst}
	 * labeled alternative in {@link TugaParser#empty}.
	 * @param ctx the parse tree
	 */
	void enterEmptyInst(TugaParser.EmptyInstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyInst}
	 * labeled alternative in {@link TugaParser#empty}.
	 * @param ctx the parse tree
	 */
	void exitEmptyInst(TugaParser.EmptyInstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarSingle}
	 * labeled alternative in {@link TugaParser#vars}.
	 * @param ctx the parse tree
	 */
	void enterVarSingle(TugaParser.VarSingleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarSingle}
	 * labeled alternative in {@link TugaParser#vars}.
	 * @param ctx the parse tree
	 */
	void exitVarSingle(TugaParser.VarSingleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarMultiple}
	 * labeled alternative in {@link TugaParser#vars}.
	 * @param ctx the parse tree
	 */
	void enterVarMultiple(TugaParser.VarMultipleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarMultiple}
	 * labeled alternative in {@link TugaParser#vars}.
	 * @param ctx the parse tree
	 */
	void exitVarMultiple(TugaParser.VarMultipleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IDExpr}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIDExpr(TugaParser.IDExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IDExpr}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIDExpr(TugaParser.IDExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqualsOp}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEqualsOp(TugaParser.EqualsOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqualsOp}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEqualsOp(TugaParser.EqualsOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OrOp}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOrOp(TugaParser.OrOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OrOp}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOrOp(TugaParser.OrOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultDivOp}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultDivOp(TugaParser.MultDivOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultDivOp}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultDivOp(TugaParser.MultDivOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SumSubOp}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSumSubOp(TugaParser.SumSubOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SumSubOp}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSumSubOp(TugaParser.SumSubOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicNegateOp}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicNegateOp(TugaParser.LogicNegateOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicNegateOp}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicNegateOp(TugaParser.LogicNegateOpContext ctx);
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
	 * Enter a parse tree produced by the {@code RelOp}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterRelOp(TugaParser.RelOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RelOp}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitRelOp(TugaParser.RelOpContext ctx);
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
	 * Enter a parse tree produced by the {@code FuncExpr}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFuncExpr(TugaParser.FuncExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FuncExpr}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFuncExpr(TugaParser.FuncExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticNegateOp}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticNegateOp(TugaParser.ArithmeticNegateOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticNegateOp}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticNegateOp(TugaParser.ArithmeticNegateOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AndOp}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAndOp(TugaParser.AndOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AndOp}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAndOp(TugaParser.AndOpContext ctx);
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