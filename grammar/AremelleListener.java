// Generated from Aremelle.g4 by ANTLR 4.5.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AremelleParser}.
 */
public interface AremelleListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AremelleParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(AremelleParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link AremelleParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(AremelleParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link AremelleParser#importStatement}.
	 * @param ctx the parse tree
	 */
	void enterImportStatement(AremelleParser.ImportStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AremelleParser#importStatement}.
	 * @param ctx the parse tree
	 */
	void exitImportStatement(AremelleParser.ImportStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AremelleParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(AremelleParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AremelleParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(AremelleParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AremelleParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void enterFunctionBody(AremelleParser.FunctionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link AremelleParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void exitFunctionBody(AremelleParser.FunctionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link AremelleParser#rewriteRules}.
	 * @param ctx the parse tree
	 */
	void enterRewriteRules(AremelleParser.RewriteRulesContext ctx);
	/**
	 * Exit a parse tree produced by {@link AremelleParser#rewriteRules}.
	 * @param ctx the parse tree
	 */
	void exitRewriteRules(AremelleParser.RewriteRulesContext ctx);
	/**
	 * Enter a parse tree produced by {@link AremelleParser#rewriteRule}.
	 * @param ctx the parse tree
	 */
	void enterRewriteRule(AremelleParser.RewriteRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link AremelleParser#rewriteRule}.
	 * @param ctx the parse tree
	 */
	void exitRewriteRule(AremelleParser.RewriteRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link AremelleParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(AremelleParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AremelleParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(AremelleParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AremelleParser#atomicExpression}.
	 * @param ctx the parse tree
	 */
	void enterAtomicExpression(AremelleParser.AtomicExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AremelleParser#atomicExpression}.
	 * @param ctx the parse tree
	 */
	void exitAtomicExpression(AremelleParser.AtomicExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AremelleParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(AremelleParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link AremelleParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(AremelleParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link AremelleParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(AremelleParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link AremelleParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(AremelleParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link AremelleParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(AremelleParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link AremelleParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(AremelleParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link AremelleParser#signatures}.
	 * @param ctx the parse tree
	 */
	void enterSignatures(AremelleParser.SignaturesContext ctx);
	/**
	 * Exit a parse tree produced by {@link AremelleParser#signatures}.
	 * @param ctx the parse tree
	 */
	void exitSignatures(AremelleParser.SignaturesContext ctx);
	/**
	 * Enter a parse tree produced by {@link AremelleParser#signature}.
	 * @param ctx the parse tree
	 */
	void enterSignature(AremelleParser.SignatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link AremelleParser#signature}.
	 * @param ctx the parse tree
	 */
	void exitSignature(AremelleParser.SignatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link AremelleParser#pattern}.
	 * @param ctx the parse tree
	 */
	void enterPattern(AremelleParser.PatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link AremelleParser#pattern}.
	 * @param ctx the parse tree
	 */
	void exitPattern(AremelleParser.PatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link AremelleParser#atomicPattern}.
	 * @param ctx the parse tree
	 */
	void enterAtomicPattern(AremelleParser.AtomicPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link AremelleParser#atomicPattern}.
	 * @param ctx the parse tree
	 */
	void exitAtomicPattern(AremelleParser.AtomicPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link AremelleParser#regexp}.
	 * @param ctx the parse tree
	 */
	void enterRegexp(AremelleParser.RegexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link AremelleParser#regexp}.
	 * @param ctx the parse tree
	 */
	void exitRegexp(AremelleParser.RegexpContext ctx);
	/**
	 * Enter a parse tree produced by {@link AremelleParser#atomicRegexp}.
	 * @param ctx the parse tree
	 */
	void enterAtomicRegexp(AremelleParser.AtomicRegexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link AremelleParser#atomicRegexp}.
	 * @param ctx the parse tree
	 */
	void exitAtomicRegexp(AremelleParser.AtomicRegexpContext ctx);
}