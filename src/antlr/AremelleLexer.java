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
		BAR=1, CARET=2, COMMA=3, COLON=4, DEFINE=5, DOLLAR=6, DOT=7, EQUAL=8, 
		IMPORT=9, LEFT_BRACE=10, LEFT_PAREN=11, PAREN=12, RIGHT_BRACE=13, RIGHT_PAREN=14, 
		SEMICOLON=15, SLASH=16, SPACE=17, Comment=18, Identifier=19, IdentifierParameter=20, 
		Number=21, RegexpOperatorBinary=22, RegexpOperatorExponent=23, RegexpOperatorUnary=24, 
		String=25;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"BAR", "CARET", "COMMA", "COLON", "DEFINE", "DIGIT", "DOLLAR", "DOT", 
		"EQUAL", "IMPORT", "LETTER", "LEFT_BRACE", "LEFT_PAREN", "PAREN", "RIGHT_BRACE", 
		"RIGHT_PAREN", "SEMICOLON", "SLASH", "SPACE", "Comment", "Complex", "IdentifierFragment", 
		"Identifier", "IdentifierParameter", "Integer", "Natural", "Number", "Rational", 
		"Real", "RegexpOperatorBinary", "RegexpOperatorExponent", "RegexpOperatorUnary", 
		"String", "StringText"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'|'", "'^'", "','", "':'", "'define'", "'$'", "'.'", "'='", "'import'", 
		"'{'", "'('", "'\"'", "'}'", "')'", "';'", "'/'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "BAR", "CARET", "COMMA", "COLON", "DEFINE", "DOLLAR", "DOT", "EQUAL", 
		"IMPORT", "LEFT_BRACE", "LEFT_PAREN", "PAREN", "RIGHT_BRACE", "RIGHT_PAREN", 
		"SEMICOLON", "SLASH", "SPACE", "Comment", "Identifier", "IdentifierParameter", 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\33\u00c3\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22"+
		"\3\22\3\23\3\23\3\24\6\24w\n\24\r\24\16\24x\3\24\3\24\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\7\27\u008b\n\27"+
		"\f\27\16\27\u008e\13\27\3\30\3\30\3\31\3\31\3\31\3\32\5\32\u0096\n\32"+
		"\3\32\3\32\3\33\6\33\u009b\n\33\r\33\16\33\u009c\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\5\34\u00a8\n\34\3\35\3\35\3\35\3\35\3\36\3\36"+
		"\3\36\3\36\5\36\u00b2\n\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3\"\3\"\3#\7"+
		"#\u00bf\n#\f#\16#\u00c2\13#\3\u00c0\2$\3\3\5\4\7\5\t\6\13\7\r\2\17\b\21"+
		"\t\23\n\25\13\27\2\31\f\33\r\35\16\37\17!\20#\21%\22\'\23)\24+\2-\2/\25"+
		"\61\26\63\2\65\2\67\279\2;\2=\30?\31A\32C\33E\2\3\2\5\4\2C\\c|\5\2\13"+
		"\f\16\17\"\"\4\2,-AA\u00c5\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\67\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\3G\3\2\2\2\5I\3\2\2"+
		"\2\7K\3\2\2\2\tM\3\2\2\2\13O\3\2\2\2\rV\3\2\2\2\17X\3\2\2\2\21Z\3\2\2"+
		"\2\23\\\3\2\2\2\25^\3\2\2\2\27e\3\2\2\2\31g\3\2\2\2\33i\3\2\2\2\35k\3"+
		"\2\2\2\37m\3\2\2\2!o\3\2\2\2#q\3\2\2\2%s\3\2\2\2\'v\3\2\2\2)|\3\2\2\2"+
		"+\u0082\3\2\2\2-\u0087\3\2\2\2/\u008f\3\2\2\2\61\u0091\3\2\2\2\63\u0095"+
		"\3\2\2\2\65\u009a\3\2\2\2\67\u00a7\3\2\2\29\u00a9\3\2\2\2;\u00ad\3\2\2"+
		"\2=\u00b3\3\2\2\2?\u00b5\3\2\2\2A\u00b7\3\2\2\2C\u00b9\3\2\2\2E\u00c0"+
		"\3\2\2\2GH\7~\2\2H\4\3\2\2\2IJ\7`\2\2J\6\3\2\2\2KL\7.\2\2L\b\3\2\2\2M"+
		"N\7<\2\2N\n\3\2\2\2OP\7f\2\2PQ\7g\2\2QR\7h\2\2RS\7k\2\2ST\7p\2\2TU\7g"+
		"\2\2U\f\3\2\2\2VW\4\62;\2W\16\3\2\2\2XY\7&\2\2Y\20\3\2\2\2Z[\7\60\2\2"+
		"[\22\3\2\2\2\\]\7?\2\2]\24\3\2\2\2^_\7k\2\2_`\7o\2\2`a\7r\2\2ab\7q\2\2"+
		"bc\7t\2\2cd\7v\2\2d\26\3\2\2\2ef\t\2\2\2f\30\3\2\2\2gh\7}\2\2h\32\3\2"+
		"\2\2ij\7*\2\2j\34\3\2\2\2kl\7$\2\2l\36\3\2\2\2mn\7\177\2\2n \3\2\2\2o"+
		"p\7+\2\2p\"\3\2\2\2qr\7=\2\2r$\3\2\2\2st\7\61\2\2t&\3\2\2\2uw\t\3\2\2"+
		"vu\3\2\2\2wx\3\2\2\2xv\3\2\2\2xy\3\2\2\2yz\3\2\2\2z{\b\24\2\2{(\3\2\2"+
		"\2|}\5\35\17\2}~\5E#\2~\177\5\35\17\2\177\u0080\3\2\2\2\u0080\u0081\b"+
		"\25\2\2\u0081*\3\2\2\2\u0082\u0083\5;\36\2\u0083\u0084\7-\2\2\u0084\u0085"+
		"\5;\36\2\u0085\u0086\7k\2\2\u0086,\3\2\2\2\u0087\u008c\5\27\f\2\u0088"+
		"\u008b\5\27\f\2\u0089\u008b\5\r\7\2\u008a\u0088\3\2\2\2\u008a\u0089\3"+
		"\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d"+
		".\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0090\5-\27\2\u0090\60\3\2\2\2\u0091"+
		"\u0092\5\17\b\2\u0092\u0093\5-\27\2\u0093\62\3\2\2\2\u0094\u0096\7/\2"+
		"\2\u0095\u0094\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098"+
		"\5\65\33\2\u0098\64\3\2\2\2\u0099\u009b\5\r\7\2\u009a\u0099\3\2\2\2\u009b"+
		"\u009c\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\66\3\2\2"+
		"\2\u009e\u00a8\5\65\33\2\u009f\u00a8\5\63\32\2\u00a0\u00a8\59\35\2\u00a1"+
		"\u00a8\5;\36\2\u00a2\u00a8\5+\26\2\u00a3\u00a4\7*\2\2\u00a4\u00a5\5\67"+
		"\34\2\u00a5\u00a6\7+\2\2\u00a6\u00a8\3\2\2\2\u00a7\u009e\3\2\2\2\u00a7"+
		"\u009f\3\2\2\2\u00a7\u00a0\3\2\2\2\u00a7\u00a1\3\2\2\2\u00a7\u00a2\3\2"+
		"\2\2\u00a7\u00a3\3\2\2\2\u00a88\3\2\2\2\u00a9\u00aa\5\63\32\2\u00aa\u00ab"+
		"\5%\23\2\u00ab\u00ac\5\65\33\2\u00ac:\3\2\2\2\u00ad\u00b1\5\63\32\2\u00ae"+
		"\u00af\5\21\t\2\u00af\u00b0\5\63\32\2\u00b0\u00b2\3\2\2\2\u00b1\u00ae"+
		"\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2<\3\2\2\2\u00b3\u00b4\5\3\2\2\u00b4"+
		">\3\2\2\2\u00b5\u00b6\5\5\3\2\u00b6@\3\2\2\2\u00b7\u00b8\t\4\2\2\u00b8"+
		"B\3\2\2\2\u00b9\u00ba\7)\2\2\u00ba\u00bb\5E#\2\u00bb\u00bc\7)\2\2\u00bc"+
		"D\3\2\2\2\u00bd\u00bf\13\2\2\2\u00be\u00bd\3\2\2\2\u00bf\u00c2\3\2\2\2"+
		"\u00c0\u00c1\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1F\3\2\2\2\u00c2\u00c0\3"+
		"\2\2\2\13\2x\u008a\u008c\u0095\u009c\u00a7\u00b1\u00c0\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}