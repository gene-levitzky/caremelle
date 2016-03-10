package antlr;

// Generated from Aremelle.g4 by ANTLR 4.5.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AremelleLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BAR=1, CARET=2, COMMA=3, COLON=4, DEFINE=5, DOT=6, EQUAL=7, LEFT_BRACE=8, 
		LEFT_PAREN=9, RIGHT_BRACE=10, RIGHT_PAREN=11, SEMICOLON=12, SLASH=13, 
		SPACE=14, Identifier=15, Number=16, RegexpOperatorBinary=17, RegexpOperatorExponent=18, 
		RegexpOperatorUnary=19, String=20;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"BAR", "CARET", "COMMA", "COLON", "DEFINE", "DIGIT", "DOT", "EQUAL", "LETTER", 
		"LEFT_BRACE", "LEFT_PAREN", "RIGHT_BRACE", "RIGHT_PAREN", "SEMICOLON", 
		"SLASH", "SPACE", "Complex", "Identifier", "Integer", "Natural", "Number", 
		"Rational", "Real", "RegexpOperatorBinary", "RegexpOperatorExponent", 
		"RegexpOperatorUnary", "String", "StringText"
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


	public AremelleLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Aremelle.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\26\u00a1\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3"+
		"\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\6\21`\n\21"+
		"\r\21\16\21a\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\7\23n\n"+
		"\23\f\23\16\23q\13\23\3\24\5\24t\n\24\3\24\3\24\3\25\6\25y\n\25\r\25\16"+
		"\25z\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u0086\n\26\3\27"+
		"\3\27\3\27\3\27\3\30\3\30\3\30\3\30\5\30\u0090\n\30\3\31\3\31\3\32\3\32"+
		"\3\33\3\33\3\34\3\34\3\34\3\34\3\35\7\35\u009d\n\35\f\35\16\35\u00a0\13"+
		"\35\3\u009e\2\36\3\3\5\4\7\5\t\6\13\7\r\2\17\b\21\t\23\2\25\n\27\13\31"+
		"\f\33\r\35\16\37\17!\20#\2%\21\'\2)\2+\22-\2/\2\61\23\63\24\65\25\67\26"+
		"9\2\3\2\5\4\2C\\c|\5\2\13\f\16\17\"\"\4\2,-AA\u00a4\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2%\3\2\2\2\2+\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\3;\3\2\2\2\5=\3\2\2\2\7?\3\2\2\2\tA\3\2\2\2\13"+
		"C\3\2\2\2\rJ\3\2\2\2\17L\3\2\2\2\21N\3\2\2\2\23P\3\2\2\2\25R\3\2\2\2\27"+
		"T\3\2\2\2\31V\3\2\2\2\33X\3\2\2\2\35Z\3\2\2\2\37\\\3\2\2\2!_\3\2\2\2#"+
		"e\3\2\2\2%j\3\2\2\2\'s\3\2\2\2)x\3\2\2\2+\u0085\3\2\2\2-\u0087\3\2\2\2"+
		"/\u008b\3\2\2\2\61\u0091\3\2\2\2\63\u0093\3\2\2\2\65\u0095\3\2\2\2\67"+
		"\u0097\3\2\2\29\u009e\3\2\2\2;<\7~\2\2<\4\3\2\2\2=>\7`\2\2>\6\3\2\2\2"+
		"?@\7.\2\2@\b\3\2\2\2AB\7<\2\2B\n\3\2\2\2CD\7f\2\2DE\7g\2\2EF\7h\2\2FG"+
		"\7k\2\2GH\7p\2\2HI\7g\2\2I\f\3\2\2\2JK\4\62;\2K\16\3\2\2\2LM\7\60\2\2"+
		"M\20\3\2\2\2NO\7?\2\2O\22\3\2\2\2PQ\t\2\2\2Q\24\3\2\2\2RS\7}\2\2S\26\3"+
		"\2\2\2TU\7*\2\2U\30\3\2\2\2VW\7\177\2\2W\32\3\2\2\2XY\7+\2\2Y\34\3\2\2"+
		"\2Z[\7=\2\2[\36\3\2\2\2\\]\7\61\2\2] \3\2\2\2^`\t\3\2\2_^\3\2\2\2`a\3"+
		"\2\2\2a_\3\2\2\2ab\3\2\2\2bc\3\2\2\2cd\b\21\2\2d\"\3\2\2\2ef\5/\30\2f"+
		"g\7-\2\2gh\5/\30\2hi\7k\2\2i$\3\2\2\2jo\5\23\n\2kn\5\23\n\2ln\5\r\7\2"+
		"mk\3\2\2\2ml\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2p&\3\2\2\2qo\3\2\2\2"+
		"rt\7/\2\2sr\3\2\2\2st\3\2\2\2tu\3\2\2\2uv\5)\25\2v(\3\2\2\2wy\5\r\7\2"+
		"xw\3\2\2\2yz\3\2\2\2zx\3\2\2\2z{\3\2\2\2{*\3\2\2\2|\u0086\5)\25\2}\u0086"+
		"\5\'\24\2~\u0086\5-\27\2\177\u0086\5/\30\2\u0080\u0086\5#\22\2\u0081\u0082"+
		"\7*\2\2\u0082\u0083\5+\26\2\u0083\u0084\7+\2\2\u0084\u0086\3\2\2\2\u0085"+
		"|\3\2\2\2\u0085}\3\2\2\2\u0085~\3\2\2\2\u0085\177\3\2\2\2\u0085\u0080"+
		"\3\2\2\2\u0085\u0081\3\2\2\2\u0086,\3\2\2\2\u0087\u0088\5\'\24\2\u0088"+
		"\u0089\5\37\20\2\u0089\u008a\5)\25\2\u008a.\3\2\2\2\u008b\u008f\5\'\24"+
		"\2\u008c\u008d\5\17\b\2\u008d\u008e\5\'\24\2\u008e\u0090\3\2\2\2\u008f"+
		"\u008c\3\2\2\2\u008f\u0090\3\2\2\2\u0090\60\3\2\2\2\u0091\u0092\5\3\2"+
		"\2\u0092\62\3\2\2\2\u0093\u0094\5\5\3\2\u0094\64\3\2\2\2\u0095\u0096\t"+
		"\4\2\2\u0096\66\3\2\2\2\u0097\u0098\7)\2\2\u0098\u0099\59\35\2\u0099\u009a"+
		"\7)\2\2\u009a8\3\2\2\2\u009b\u009d\13\2\2\2\u009c\u009b\3\2\2\2\u009d"+
		"\u00a0\3\2\2\2\u009e\u009f\3\2\2\2\u009e\u009c\3\2\2\2\u009f:\3\2\2\2"+
		"\u00a0\u009e\3\2\2\2\13\2amosz\u0085\u008f\u009e\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}