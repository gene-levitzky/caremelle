package antlr2;
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
		BAR=1, CARET=2, COMMA=3, COLON=4, DEFINE=5, DOLLAR=6, DOT=7, EQUAL=8, 
		IMPORT=9, LEFT_BRACE=10, LEFT_PAREN=11, PAREN=12, RIGHT_BRACE=13, RIGHT_PAREN=14, 
		SEMICOLON=15, SLASH=16, SPACE=17, Comment=18, Identifier=19, IdentifierEmpty=20, 
		Number=21, RegexpOperatorBinary=22, RegexpOperatorExponent=23, RegexpOperatorUnary=24, 
		String=25;
	public static final int
		RULE_program = 0, RULE_importStatement = 1, RULE_function = 2, RULE_functionBody = 3, 
		RULE_rewriteRules = 4, RULE_rewriteRule = 5, RULE_expression = 6, RULE_atomicExpression = 7, 
		RULE_functionCall = 8, RULE_arguments = 9, RULE_argument = 10, RULE_signatures = 11, 
		RULE_signature = 12, RULE_pattern = 13, RULE_atomicPattern = 14, RULE_regexp = 15, 
		RULE_atomicRegexp = 16;
	public static final String[] ruleNames = {
		"program", "importStatement", "function", "functionBody", "rewriteRules", 
		"rewriteRule", "expression", "atomicExpression", "functionCall", "arguments", 
		"argument", "signatures", "signature", "pattern", "atomicPattern", "regexp", 
		"atomicRegexp"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'|'", "'^'", "','", "':'", "'define'", "'$'", "'.'", "'='", "'import'", 
		"'{'", "'('", "'\"'", "'}'", "')'", "';'", "'/'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "BAR", "CARET", "COMMA", "COLON", "DEFINE", "DOLLAR", "DOT", "EQUAL", 
		"IMPORT", "LEFT_BRACE", "LEFT_PAREN", "PAREN", "RIGHT_BRACE", "RIGHT_PAREN", 
		"SEMICOLON", "SLASH", "SPACE", "Comment", "Identifier", "IdentifierEmpty", 
		"Number", "RegexpOperatorBinary", "RegexpOperatorExponent", "RegexpOperatorUnary", 
		"String"
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
		public List<ImportStatementContext> importStatement() {
			return getRuleContexts(ImportStatementContext.class);
		}
		public ImportStatementContext importStatement(int i) {
			return getRuleContext(ImportStatementContext.class,i);
		}
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
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(34);
				importStatement();
				}
				}
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(41);
			_la = _input.LA(1);
			if (_la==DEFINE) {
				{
				setState(40);
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

	public static class ImportStatementContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(AremelleParser.IMPORT, 0); }
		public TerminalNode String() { return getToken(AremelleParser.String, 0); }
		public TerminalNode DOT() { return getToken(AremelleParser.DOT, 0); }
		public ImportStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).enterImportStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).exitImportStatement(this);
		}
	}

	public final ImportStatementContext importStatement() throws RecognitionException {
		ImportStatementContext _localctx = new ImportStatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_importStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			match(IMPORT);
			setState(44);
			match(String);
			setState(45);
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
		enterRule(_localctx, 4, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			match(DEFINE);
			setState(48);
			match(Identifier);
			setState(49);
			match(COLON);
			setState(50);
			functionBody();
			setState(51);
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
		public RewriteRulesContext rewriteRules() {
			return getRuleContext(RewriteRulesContext.class,0);
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
		enterRule(_localctx, 6, RULE_functionBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DEFINE) {
				{
				{
				setState(53);
				function();
				}
				}
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(61);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(59);
				expression();
				}
				break;
			case 2:
				{
				setState(60);
				rewriteRules();
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

	public static class RewriteRulesContext extends ParserRuleContext {
		public List<RewriteRuleContext> rewriteRule() {
			return getRuleContexts(RewriteRuleContext.class);
		}
		public RewriteRuleContext rewriteRule(int i) {
			return getRuleContext(RewriteRuleContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(AremelleParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(AremelleParser.SEMICOLON, i);
		}
		public RewriteRulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rewriteRules; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).enterRewriteRules(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).exitRewriteRules(this);
		}
	}

	public final RewriteRulesContext rewriteRules() throws RecognitionException {
		RewriteRulesContext _localctx = new RewriteRulesContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_rewriteRules);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			rewriteRule();
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMICOLON) {
				{
				{
				setState(64);
				match(SEMICOLON);
				setState(65);
				rewriteRule();
				}
				}
				setState(70);
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

	public static class RewriteRuleContext extends ParserRuleContext {
		public SignaturesContext signatures() {
			return getRuleContext(SignaturesContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(AremelleParser.EQUAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RewriteRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rewriteRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).enterRewriteRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).exitRewriteRule(this);
		}
	}

	public final RewriteRuleContext rewriteRule() throws RecognitionException {
		RewriteRuleContext _localctx = new RewriteRuleContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_rewriteRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			signatures();
			setState(72);
			match(EQUAL);
			setState(73);
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
		enterRule(_localctx, 12, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(75);
				atomicExpression();
				}
				}
				setState(78); 
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
		enterRule(_localctx, 14, RULE_atomicExpression);
		try {
			setState(84);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				functionCall();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				match(String);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(82);
				match(Number);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(83);
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
		enterRule(_localctx, 16, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(Identifier);
			setState(87);
			match(LEFT_PAREN);
			setState(89);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Identifier) | (1L << Number) | (1L << String))) != 0)) {
				{
				setState(88);
				arguments();
				}
			}

			setState(91);
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
		enterRule(_localctx, 18, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			argument();
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(94);
				match(COMMA);
				setState(95);
				argument();
				}
				}
				setState(100);
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
		enterRule(_localctx, 20, RULE_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
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

	public static class SignaturesContext extends ParserRuleContext {
		public List<SignatureContext> signature() {
			return getRuleContexts(SignatureContext.class);
		}
		public SignatureContext signature(int i) {
			return getRuleContext(SignatureContext.class,i);
		}
		public List<TerminalNode> BAR() { return getTokens(AremelleParser.BAR); }
		public TerminalNode BAR(int i) {
			return getToken(AremelleParser.BAR, i);
		}
		public SignaturesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signatures; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).enterSignatures(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).exitSignatures(this);
		}
	}

	public final SignaturesContext signatures() throws RecognitionException {
		SignaturesContext _localctx = new SignaturesContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_signatures);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			signature();
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BAR) {
				{
				{
				setState(104);
				match(BAR);
				setState(105);
				signature();
				}
				}
				setState(110);
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

	public static class SignatureContext extends ParserRuleContext {
		public List<PatternContext> pattern() {
			return getRuleContexts(PatternContext.class);
		}
		public PatternContext pattern(int i) {
			return getRuleContext(PatternContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AremelleParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AremelleParser.COMMA, i);
		}
		public SignatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signature; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).enterSignature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).exitSignature(this);
		}
	}

	public final SignatureContext signature() throws RecognitionException {
		SignatureContext _localctx = new SignatureContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_signature);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			pattern();
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(112);
				match(COMMA);
				setState(113);
				pattern();
				}
				}
				setState(118);
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

	public static class PatternContext extends ParserRuleContext {
		public List<AtomicPatternContext> atomicPattern() {
			return getRuleContexts(AtomicPatternContext.class);
		}
		public AtomicPatternContext atomicPattern(int i) {
			return getRuleContext(AtomicPatternContext.class,i);
		}
		public PatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).enterPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).exitPattern(this);
		}
	}

	public final PatternContext pattern() throws RecognitionException {
		PatternContext _localctx = new PatternContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_pattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(119);
				atomicPattern();
				}
				}
				setState(122); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT_BRACE) | (1L << Identifier) | (1L << IdentifierEmpty) | (1L << Number) | (1L << String))) != 0) );
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

	public static class AtomicPatternContext extends ParserRuleContext {
		public TerminalNode IdentifierEmpty() { return getToken(AremelleParser.IdentifierEmpty, 0); }
		public TerminalNode Identifier() { return getToken(AremelleParser.Identifier, 0); }
		public RegexpContext regexp() {
			return getRuleContext(RegexpContext.class,0);
		}
		public AtomicPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomicPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).enterAtomicPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AremelleListener ) ((AremelleListener)listener).exitAtomicPattern(this);
		}
	}

	public final AtomicPatternContext atomicPattern() throws RecognitionException {
		AtomicPatternContext _localctx = new AtomicPatternContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_atomicPattern);
		try {
			setState(127);
			switch (_input.LA(1)) {
			case IdentifierEmpty:
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				match(IdentifierEmpty);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(125);
				match(Identifier);
				}
				break;
			case LEFT_BRACE:
			case Number:
			case String:
				enterOuterAlt(_localctx, 3);
				{
				setState(126);
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
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
		enterRule(_localctx, 30, RULE_regexp);
		int _la;
		try {
			setState(137);
			switch (_input.LA(1)) {
			case Number:
			case String:
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				atomicRegexp();
				}
				break;
			case LEFT_BRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
				match(LEFT_BRACE);
				setState(131);
				expression();
				setState(132);
				match(RIGHT_BRACE);
				setState(135);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(133);
					match(COLON);
					setState(134);
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
		enterRule(_localctx, 32, RULE_atomicRegexp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\33\u0090\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\7\2&\n\2\f\2\16\2)\13\2\3\2\5\2,\n\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\5\7\59\n\5\f\5\16\5<\13\5\3\5\3\5\5\5@\n\5\3\6\3\6\3\6"+
		"\7\6E\n\6\f\6\16\6H\13\6\3\7\3\7\3\7\3\7\3\b\6\bO\n\b\r\b\16\bP\3\t\3"+
		"\t\3\t\3\t\5\tW\n\t\3\n\3\n\3\n\5\n\\\n\n\3\n\3\n\3\13\3\13\3\13\7\13"+
		"c\n\13\f\13\16\13f\13\13\3\f\3\f\3\r\3\r\3\r\7\rm\n\r\f\r\16\rp\13\r\3"+
		"\16\3\16\3\16\7\16u\n\16\f\16\16\16x\13\16\3\17\6\17{\n\17\r\17\16\17"+
		"|\3\20\3\20\3\20\5\20\u0082\n\20\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u008a"+
		"\n\21\5\21\u008c\n\21\3\22\3\22\3\22\2\2\23\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"\2\3\4\2\27\27\33\33\u0090\2\'\3\2\2\2\4-\3\2\2\2\6\61"+
		"\3\2\2\2\b:\3\2\2\2\nA\3\2\2\2\fI\3\2\2\2\16N\3\2\2\2\20V\3\2\2\2\22X"+
		"\3\2\2\2\24_\3\2\2\2\26g\3\2\2\2\30i\3\2\2\2\32q\3\2\2\2\34z\3\2\2\2\36"+
		"\u0081\3\2\2\2 \u008b\3\2\2\2\"\u008d\3\2\2\2$&\5\4\3\2%$\3\2\2\2&)\3"+
		"\2\2\2\'%\3\2\2\2\'(\3\2\2\2(+\3\2\2\2)\'\3\2\2\2*,\5\6\4\2+*\3\2\2\2"+
		"+,\3\2\2\2,\3\3\2\2\2-.\7\13\2\2./\7\33\2\2/\60\7\t\2\2\60\5\3\2\2\2\61"+
		"\62\7\7\2\2\62\63\7\25\2\2\63\64\7\6\2\2\64\65\5\b\5\2\65\66\7\t\2\2\66"+
		"\7\3\2\2\2\679\5\6\4\28\67\3\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;?\3\2"+
		"\2\2<:\3\2\2\2=@\5\16\b\2>@\5\n\6\2?=\3\2\2\2?>\3\2\2\2@\t\3\2\2\2AF\5"+
		"\f\7\2BC\7\21\2\2CE\5\f\7\2DB\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2G\13"+
		"\3\2\2\2HF\3\2\2\2IJ\5\30\r\2JK\7\n\2\2KL\5\16\b\2L\r\3\2\2\2MO\5\20\t"+
		"\2NM\3\2\2\2OP\3\2\2\2PN\3\2\2\2PQ\3\2\2\2Q\17\3\2\2\2RW\5\22\n\2SW\7"+
		"\33\2\2TW\7\27\2\2UW\7\25\2\2VR\3\2\2\2VS\3\2\2\2VT\3\2\2\2VU\3\2\2\2"+
		"W\21\3\2\2\2XY\7\25\2\2Y[\7\r\2\2Z\\\5\24\13\2[Z\3\2\2\2[\\\3\2\2\2\\"+
		"]\3\2\2\2]^\7\20\2\2^\23\3\2\2\2_d\5\26\f\2`a\7\5\2\2ac\5\26\f\2b`\3\2"+
		"\2\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2e\25\3\2\2\2fd\3\2\2\2gh\5\16\b\2h\27"+
		"\3\2\2\2in\5\32\16\2jk\7\3\2\2km\5\32\16\2lj\3\2\2\2mp\3\2\2\2nl\3\2\2"+
		"\2no\3\2\2\2o\31\3\2\2\2pn\3\2\2\2qv\5\34\17\2rs\7\5\2\2su\5\34\17\2t"+
		"r\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2w\33\3\2\2\2xv\3\2\2\2y{\5\36\20"+
		"\2zy\3\2\2\2{|\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\35\3\2\2\2~\u0082\7\26\2\2"+
		"\177\u0082\7\25\2\2\u0080\u0082\5 \21\2\u0081~\3\2\2\2\u0081\177\3\2\2"+
		"\2\u0081\u0080\3\2\2\2\u0082\37\3\2\2\2\u0083\u008c\5\"\22\2\u0084\u0085"+
		"\7\f\2\2\u0085\u0086\5\16\b\2\u0086\u0089\7\17\2\2\u0087\u0088\7\6\2\2"+
		"\u0088\u008a\7\25\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008c"+
		"\3\2\2\2\u008b\u0083\3\2\2\2\u008b\u0084\3\2\2\2\u008c!\3\2\2\2\u008d"+
		"\u008e\t\2\2\2\u008e#\3\2\2\2\21\'+:?FPV[dnv|\u0081\u0089\u008b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}