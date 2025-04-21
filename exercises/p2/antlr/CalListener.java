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
	 * Enter a parse tree produced by {@link CalParser#s}.
	 * @param ctx the parse tree
	 */
	void enterS(CalParser.SContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalParser#s}.
	 * @param ctx the parse tree
	 */
	void exitS(CalParser.SContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalParser#l}.
	 * @param ctx the parse tree
	 */
	void enterL(CalParser.LContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalParser#l}.
	 * @param ctx the parse tree
	 */
	void exitL(CalParser.LContext ctx);
}