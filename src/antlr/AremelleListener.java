package antlr;

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
	 * Enter a parse tree produced by {@link AremelleParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(AremelleParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link AremelleParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(AremelleParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link AremelleParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(AremelleParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AremelleParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(AremelleParser.StatementContext ctx);
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
	 * Enter a parse tree produced by {@link AremelleParser#parametersList}.
	 * @param ctx the parse tree
	 */
	void enterParametersList(AremelleParser.ParametersListContext ctx);
	/**
	 * Exit a parse tree produced by {@link AremelleParser#parametersList}.
	 * @param ctx the parse tree
	 */
	void exitParametersList(AremelleParser.ParametersListContext ctx);
	/**
	 * Enter a parse tree produced by {@link AremelleParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(AremelleParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link AremelleParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(AremelleParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link AremelleParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(AremelleParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link AremelleParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(AremelleParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link AremelleParser#atomicParameter}.
	 * @param ctx the parse tree
	 */
	void enterAtomicParameter(AremelleParser.AtomicParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link AremelleParser#atomicParameter}.
	 * @param ctx the parse tree
	 */
	void exitAtomicParameter(AremelleParser.AtomicParameterContext ctx);
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