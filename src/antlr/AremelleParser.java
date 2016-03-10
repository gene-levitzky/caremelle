package antlr;

// Generated from Aremelle.g4 by ANTLR 4.5.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AremelleParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BAR=1, CARET=2, COMMA=3, COLON=4, DEFINE=5, DOT=6, EQUAL=7, LEFT_BRACE=8, 
		LEFT_PAREN=9, RIGHT_BRACE=10, RIGHT_PAREN=11, SEMICOLON=12, SLASH=13, 
		SPACE=14, Identifier=15, Number=16, RegexpOperatorBinary=17, RegexpOperatorExponent=18, 
		RegexpOperatorUnary=19, String=20;
	public static final int
		RULE_program = 0, RULE_function = 1, RULE_functionBody = 2, RULE_statements = 3, 
		RULE_statement = 4, RULE_expression = 5, RULE_atomicExpression = 6, RULE_functionCall = 7, 
		RULE_arguments = 8, RULE_argument = 9, RULE_parametersList = 10, RULE_parameters = 11, 
		RULE_parameter = 12, RULE_atomicParameter = 13, RULE_regexp = 14, RULE_atomicRegexp = 15;
	public static final String[] ruleNames = {
		"program", "function", "functionBody", "statements", "statement", "expression", 
		"atomicExpression", "functionCall", "arguments", "argument", "parametersList", 
		"parameters", "parameter", "atomicParameter", "regexp", "atomicRegexp"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'|'", "'^'", "','", "':'", "'define'", "'.'", "'='", "'{'", "'('", 
		"'}'", "')'", "';'", "'/'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "BAR", "CARET", "COMMA", "COLON", "DEFINE", "DOT", "EQUAL", "LEFT_BRACE", 
		"LEFT_PAREN", "RIGHT_BRACE", "RIGHT_PAREN", "SEMICOLON", "SLASH", "SPACE", 
		"Identifier", "Number", "RegexpOperatorBinary", "RegexpOperatorExponent", 
		"RegexpOperatorUnary", "String"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Aremelle.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AremelleParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			_la = _input.LA(1);
			if (_la==DEFINE) {
				{
				setState(32);
				function();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode DEFINE() { return getToken(AremelleParser.DEFINE, 0); }
		public TerminalNode Identifier() { return getToken(AremelleParser.Identifier, 0); }
		public TerminalNode COLON() { return getToken(AremelleParser.COLON, 0); }
		public FunctionBodyContext functionBody() {
			return getRuleContext(FunctionBodyContext.class,0);
		}
		public TerminalNode DOT() { return getToken(AremelleParser.DOT, 0); }
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).exitFunction(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			match(DEFINE);
			setState(36);
			match(Identifier);
			setState(37);
			match(COLON);
			setState(38);
			functionBody();
			setState(39);
			match(DOT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionBodyContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public FunctionBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).enterFunctionBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).exitFunctionBody(this);
		}
	}

	public final FunctionBodyContext functionBody() throws RecognitionException {
		FunctionBodyContext _localctx = new FunctionBodyContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_functionBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DEFINE) {
				{
				{
				setState(41);
				function();
				}
				}
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(49);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(47);
				expression();
				}
				break;
			case 2:
				{
				setState(48);
				statements();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementsContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(AremelleParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(AremelleParser.SEMICOLON, i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).exitStatements(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			statement();
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMICOLON) {
				{
				{
				setState(52);
				match(SEMICOLON);
				setState(53);
				statement();
				}
				}
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public ParametersListContext parametersList() {
			return getRuleContext(ParametersListContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(AremelleParser.EQUAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			parametersList();
			setState(60);
			match(EQUAL);
			setState(61);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public List<AtomicExpressionContext> atomicExpression() {
			return getRuleContexts(AtomicExpressionContext.class);
		}
		public AtomicExpressionContext atomicExpression(int i) {
			return getRuleContext(AtomicExpressionContext.class,i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(63);
				atomicExpression();
				}
				}
				setState(66); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Identifier) | (1L << Number) | (1L << String))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomicExpressionContext extends ParserRuleContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public TerminalNode String() { return getToken(AremelleParser.String, 0); }
		public TerminalNode Number() { return getToken(AremelleParser.Number, 0); }
		public TerminalNode Identifier() { return getToken(AremelleParser.Identifier, 0); }
		public AtomicExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomicExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).enterAtomicExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).exitAtomicExpression(this);
		}
	}

	public final AtomicExpressionContext atomicExpression() throws RecognitionException {
		AtomicExpressionContext _localctx = new AtomicExpressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_atomicExpression);
		try {
			setState(72);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				functionCall();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				match(String);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(70);
				match(Number);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(71);
				match(Identifier);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionCallContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(AremelleParser.Identifier, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(AremelleParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(AremelleParser.RIGHT_PAREN, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).exitFunctionCall(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(Identifier);
			setState(75);
			match(LEFT_PAREN);
			setState(77);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Identifier) | (1L << Number) | (1L << String))) != 0)) {
				{
				setState(76);
				arguments();
				}
			}

			setState(79);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentsContext extends ParserRuleContext {
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AremelleParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AremelleParser.COMMA, i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).exitArguments(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			argument();
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(82);
				match(COMMA);
				setState(83);
				argument();
				}
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).enterArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).exitArgument(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametersListContext extends ParserRuleContext {
		public List<ParametersContext> parameters() {
			return getRuleContexts(ParametersContext.class);
		}
		public ParametersContext parameters(int i) {
			return getRuleContext(ParametersContext.class,i);
		}
		public List<TerminalNode> BAR() { return getTokens(AremelleParser.BAR); }
		public TerminalNode BAR(int i) {
			return getToken(AremelleParser.BAR, i);
		}
		public ParametersListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametersList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).enterParametersList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).exitParametersList(this);
		}
	}

	public final ParametersListContext parametersList() throws RecognitionException {
		ParametersListContext _localctx = new ParametersListContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_parametersList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			parameters();
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BAR) {
				{
				{
				setState(92);
				match(BAR);
				setState(93);
				parameters();
				}
				}
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametersContext extends ParserRuleContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AremelleParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AremelleParser.COMMA, i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).exitParameters(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			parameter();
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(100);
				match(COMMA);
				setState(101);
				parameter();
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterContext extends ParserRuleContext {
		public List<AtomicParameterContext> atomicParameter() {
			return getRuleContexts(AtomicParameterContext.class);
		}
		public AtomicParameterContext atomicParameter(int i) {
			return getRuleContext(AtomicParameterContext.class,i);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).exitParameter(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_parameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(107);
				atomicParameter();
				}
				}
				setState(110); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT_BRACE) | (1L << Identifier) | (1L << Number) | (1L << String))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomicParameterContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(AremelleParser.Identifier, 0); }
		public RegexpContext regexp() {
			return getRuleContext(RegexpContext.class,0);
		}
		public AtomicParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomicParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).enterAtomicParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).exitAtomicParameter(this);
		}
	}

	public final AtomicParameterContext atomicParameter() throws RecognitionException {
		AtomicParameterContext _localctx = new AtomicParameterContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_atomicParameter);
		try {
			setState(114);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				match(Identifier);
				}
				break;
			case LEFT_BRACE:
			case Number:
			case String:
				enterOuterAlt(_localctx, 2);
				{
				setState(113);
				regexp();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RegexpContext extends ParserRuleContext {
		public AtomicRegexpContext atomicRegexp() {
			return getRuleContext(AtomicRegexpContext.class,0);
		}
		public TerminalNode LEFT_BRACE() { return getToken(AremelleParser.LEFT_BRACE, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(AremelleParser.RIGHT_BRACE, 0); }
		public TerminalNode COLON() { return getToken(AremelleParser.COLON, 0); }
		public TerminalNode Identifier() { return getToken(AremelleParser.Identifier, 0); }
		public RegexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regexp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).enterRegexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).exitRegexp(this);
		}
	}

	public final RegexpContext regexp() throws RecognitionException {
		RegexpContext _localctx = new RegexpContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_regexp);
		int _la;
		try {
			setState(124);
			switch (_input.LA(1)) {
			case Number:
			case String:
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				atomicRegexp();
				}
				break;
			case LEFT_BRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(117);
				match(LEFT_BRACE);
				setState(118);
				atomicRegexp();
				setState(119);
				match(RIGHT_BRACE);
				setState(122);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(120);
					match(COLON);
					setState(121);
					match(Identifier);
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomicRegexpContext extends ParserRuleContext {
		public TerminalNode String() { return getToken(AremelleParser.String, 0); }
		public TerminalNode Number() { return getToken(AremelleParser.Number, 0); }
		public AtomicRegexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomicRegexp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).enterAtomicRegexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).exitAtomicRegexp(this);
		}
	}

	public final AtomicRegexpContext atomicRegexp() throws RecognitionException {
		AtomicRegexpContext _localctx = new AtomicRegexpContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_atomicRegexp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			_la = _input.LA(1);
			if ( !(_la==Number || _la==String) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\26\u0083\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\5\2"+
		"$\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\7\4-\n\4\f\4\16\4\60\13\4\3\4\3\4\5"+
		"\4\64\n\4\3\5\3\5\3\5\7\59\n\5\f\5\16\5<\13\5\3\6\3\6\3\6\3\6\3\7\6\7"+
		"C\n\7\r\7\16\7D\3\b\3\b\3\b\3\b\5\bK\n\b\3\t\3\t\3\t\5\tP\n\t\3\t\3\t"+
		"\3\n\3\n\3\n\7\nW\n\n\f\n\16\nZ\13\n\3\13\3\13\3\f\3\f\3\f\7\fa\n\f\f"+
		"\f\16\fd\13\f\3\r\3\r\3\r\7\ri\n\r\f\r\16\rl\13\r\3\16\6\16o\n\16\r\16"+
		"\16\16p\3\17\3\17\5\17u\n\17\3\20\3\20\3\20\3\20\3\20\3\20\5\20}\n\20"+
		"\5\20\177\n\20\3\21\3\21\3\21\2\2\22\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \2\3\4\2\22\22\26\26\u0082\2#\3\2\2\2\4%\3\2\2\2\6.\3\2\2\2\b\65"+
		"\3\2\2\2\n=\3\2\2\2\fB\3\2\2\2\16J\3\2\2\2\20L\3\2\2\2\22S\3\2\2\2\24"+
		"[\3\2\2\2\26]\3\2\2\2\30e\3\2\2\2\32n\3\2\2\2\34t\3\2\2\2\36~\3\2\2\2"+
		" \u0080\3\2\2\2\"$\5\4\3\2#\"\3\2\2\2#$\3\2\2\2$\3\3\2\2\2%&\7\7\2\2&"+
		"\'\7\21\2\2\'(\7\6\2\2()\5\6\4\2)*\7\b\2\2*\5\3\2\2\2+-\5\4\3\2,+\3\2"+
		"\2\2-\60\3\2\2\2.,\3\2\2\2./\3\2\2\2/\63\3\2\2\2\60.\3\2\2\2\61\64\5\f"+
		"\7\2\62\64\5\b\5\2\63\61\3\2\2\2\63\62\3\2\2\2\64\7\3\2\2\2\65:\5\n\6"+
		"\2\66\67\7\16\2\2\679\5\n\6\28\66\3\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2"+
		"\2;\t\3\2\2\2<:\3\2\2\2=>\5\26\f\2>?\7\t\2\2?@\5\f\7\2@\13\3\2\2\2AC\5"+
		"\16\b\2BA\3\2\2\2CD\3\2\2\2DB\3\2\2\2DE\3\2\2\2E\r\3\2\2\2FK\5\20\t\2"+
		"GK\7\26\2\2HK\7\22\2\2IK\7\21\2\2JF\3\2\2\2JG\3\2\2\2JH\3\2\2\2JI\3\2"+
		"\2\2K\17\3\2\2\2LM\7\21\2\2MO\7\13\2\2NP\5\22\n\2ON\3\2\2\2OP\3\2\2\2"+
		"PQ\3\2\2\2QR\7\r\2\2R\21\3\2\2\2SX\5\24\13\2TU\7\5\2\2UW\5\24\13\2VT\3"+
		"\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y\23\3\2\2\2ZX\3\2\2\2[\\\5\f\7\2"+
		"\\\25\3\2\2\2]b\5\30\r\2^_\7\3\2\2_a\5\30\r\2`^\3\2\2\2ad\3\2\2\2b`\3"+
		"\2\2\2bc\3\2\2\2c\27\3\2\2\2db\3\2\2\2ej\5\32\16\2fg\7\5\2\2gi\5\32\16"+
		"\2hf\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2k\31\3\2\2\2lj\3\2\2\2mo\5\34"+
		"\17\2nm\3\2\2\2op\3\2\2\2pn\3\2\2\2pq\3\2\2\2q\33\3\2\2\2ru\7\21\2\2s"+
		"u\5\36\20\2tr\3\2\2\2ts\3\2\2\2u\35\3\2\2\2v\177\5 \21\2wx\7\n\2\2xy\5"+
		" \21\2y|\7\f\2\2z{\7\6\2\2{}\7\21\2\2|z\3\2\2\2|}\3\2\2\2}\177\3\2\2\2"+
		"~v\3\2\2\2~w\3\2\2\2\177\37\3\2\2\2\u0080\u0081\t\2\2\2\u0081!\3\2\2\2"+
		"\20#.\63:DJOXbjpt|~";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}