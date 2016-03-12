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
		BAR=1, CARET=2, COMMA=3, COLON=4, DEFINE=5, DOLLAR=6, DOT=7, EQUAL=8, 
		LEFT_BRACE=9, LEFT_PAREN=10, RIGHT_BRACE=11, RIGHT_PAREN=12, SEMICOLON=13, 
		SLASH=14, SPACE=15, Identifier=16, IdentifierParameter=17, Number=18, 
		RegexpOperatorBinary=19, RegexpOperatorExponent=20, RegexpOperatorUnary=21, 
		String=22;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"BAR", "CARET", "COMMA", "COLON", "DEFINE", "DIGIT", "DOLLAR", "DOT", 
		"EQUAL", "LETTER", "LEFT_BRACE", "LEFT_PAREN", "RIGHT_BRACE", "RIGHT_PAREN", 
		"SEMICOLON", "SLASH", "SPACE", "Complex", "IdentifierFragment", "Identifier", 
		"IdentifierParameter", "Integer", "Natural", "Number", "Rational", "Real", 
		"RegexpOperatorBinary", "RegexpOperatorExponent", "RegexpOperatorUnary", 
		"String", "StringText"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'|'", "'^'", "','", "':'", "'define'", "'$'", "'.'", "'='", "'{'", 
		"'('", "'}'", "')'", "';'", "'/'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "BAR", "CARET", "COMMA", "COLON", "DEFINE", "DOLLAR", "DOT", "EQUAL", 
		"LEFT_BRACE", "LEFT_PAREN", "RIGHT_BRACE", "RIGHT_PAREN", "SEMICOLON", 
		"SLASH", "SPACE", "Identifier", "IdentifierParameter", "Number", "RegexpOperatorBinary", 
		"RegexpOperatorExponent", "RegexpOperatorUnary", "String"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\30\u00ae\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7"+
		"\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17"+
		"\3\20\3\20\3\21\3\21\3\22\6\22h\n\22\r\22\16\22i\3\22\3\22\3\23\3\23\3"+
		"\23\3\23\3\23\3\24\3\24\3\24\7\24v\n\24\f\24\16\24y\13\24\3\25\3\25\3"+
		"\26\3\26\3\26\3\27\5\27\u0081\n\27\3\27\3\27\3\30\6\30\u0086\n\30\r\30"+
		"\16\30\u0087\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u0093\n"+
		"\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\5\33\u009d\n\33\3\34\3\34"+
		"\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3\37\3 \7 \u00aa\n \f \16 \u00ad\13"+
		" \3\u00ab\2!\3\3\5\4\7\5\t\6\13\7\r\2\17\b\21\t\23\n\25\2\27\13\31\f\33"+
		"\r\35\16\37\17!\20#\21%\2\'\2)\22+\23-\2/\2\61\24\63\2\65\2\67\259\26"+
		";\27=\30?\2\3\2\5\4\2C\\c|\5\2\13\f\16\17\"\"\4\2,-AA\u00b0\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2\61\3\2"+
		"\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\3A\3\2\2\2\5C\3\2\2"+
		"\2\7E\3\2\2\2\tG\3\2\2\2\13I\3\2\2\2\rP\3\2\2\2\17R\3\2\2\2\21T\3\2\2"+
		"\2\23V\3\2\2\2\25X\3\2\2\2\27Z\3\2\2\2\31\\\3\2\2\2\33^\3\2\2\2\35`\3"+
		"\2\2\2\37b\3\2\2\2!d\3\2\2\2#g\3\2\2\2%m\3\2\2\2\'r\3\2\2\2)z\3\2\2\2"+
		"+|\3\2\2\2-\u0080\3\2\2\2/\u0085\3\2\2\2\61\u0092\3\2\2\2\63\u0094\3\2"+
		"\2\2\65\u0098\3\2\2\2\67\u009e\3\2\2\29\u00a0\3\2\2\2;\u00a2\3\2\2\2="+
		"\u00a4\3\2\2\2?\u00ab\3\2\2\2AB\7~\2\2B\4\3\2\2\2CD\7`\2\2D\6\3\2\2\2"+
		"EF\7.\2\2F\b\3\2\2\2GH\7<\2\2H\n\3\2\2\2IJ\7f\2\2JK\7g\2\2KL\7h\2\2LM"+
		"\7k\2\2MN\7p\2\2NO\7g\2\2O\f\3\2\2\2PQ\4\62;\2Q\16\3\2\2\2RS\7&\2\2S\20"+
		"\3\2\2\2TU\7\60\2\2U\22\3\2\2\2VW\7?\2\2W\24\3\2\2\2XY\t\2\2\2Y\26\3\2"+
		"\2\2Z[\7}\2\2[\30\3\2\2\2\\]\7*\2\2]\32\3\2\2\2^_\7\177\2\2_\34\3\2\2"+
		"\2`a\7+\2\2a\36\3\2\2\2bc\7=\2\2c \3\2\2\2de\7\61\2\2e\"\3\2\2\2fh\t\3"+
		"\2\2gf\3\2\2\2hi\3\2\2\2ig\3\2\2\2ij\3\2\2\2jk\3\2\2\2kl\b\22\2\2l$\3"+
		"\2\2\2mn\5\65\33\2no\7-\2\2op\5\65\33\2pq\7k\2\2q&\3\2\2\2rw\5\25\13\2"+
		"sv\5\25\13\2tv\5\r\7\2us\3\2\2\2ut\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2"+
		"\2x(\3\2\2\2yw\3\2\2\2z{\5\'\24\2{*\3\2\2\2|}\5\17\b\2}~\5\'\24\2~,\3"+
		"\2\2\2\177\u0081\7/\2\2\u0080\177\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082"+
		"\3\2\2\2\u0082\u0083\5/\30\2\u0083.\3\2\2\2\u0084\u0086\5\r\7\2\u0085"+
		"\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2"+
		"\2\2\u0088\60\3\2\2\2\u0089\u0093\5/\30\2\u008a\u0093\5-\27\2\u008b\u0093"+
		"\5\63\32\2\u008c\u0093\5\65\33\2\u008d\u0093\5%\23\2\u008e\u008f\7*\2"+
		"\2\u008f\u0090\5\61\31\2\u0090\u0091\7+\2\2\u0091\u0093\3\2\2\2\u0092"+
		"\u0089\3\2\2\2\u0092\u008a\3\2\2\2\u0092\u008b\3\2\2\2\u0092\u008c\3\2"+
		"\2\2\u0092\u008d\3\2\2\2\u0092\u008e\3\2\2\2\u0093\62\3\2\2\2\u0094\u0095"+
		"\5-\27\2\u0095\u0096\5!\21\2\u0096\u0097\5/\30\2\u0097\64\3\2\2\2\u0098"+
		"\u009c\5-\27\2\u0099\u009a\5\21\t\2\u009a\u009b\5-\27\2\u009b\u009d\3"+
		"\2\2\2\u009c\u0099\3\2\2\2\u009c\u009d\3\2\2\2\u009d\66\3\2\2\2\u009e"+
		"\u009f\5\3\2\2\u009f8\3\2\2\2\u00a0\u00a1\5\5\3\2\u00a1:\3\2\2\2\u00a2"+
		"\u00a3\t\4\2\2\u00a3<\3\2\2\2\u00a4\u00a5\7)\2\2\u00a5\u00a6\5? \2\u00a6"+
		"\u00a7\7)\2\2\u00a7>\3\2\2\2\u00a8\u00aa\13\2\2\2\u00a9\u00a8\3\2\2\2"+
		"\u00aa\u00ad\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac@\3"+
		"\2\2\2\u00ad\u00ab\3\2\2\2\13\2iuw\u0080\u0087\u0092\u009c\u00ab\3\2\3"+
		"\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}