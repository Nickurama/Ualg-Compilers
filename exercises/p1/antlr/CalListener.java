// Generated from Cal.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalParser}.
 */
public interface CalListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(CalParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(CalParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(CalParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(CalParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(CalParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(CalParser.ExprContext ctx);
}