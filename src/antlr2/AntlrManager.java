package antlr2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import antlr2.AremelleParser.ProgramContext;

public class AntlrManager {
	
	public static AremelleLexer getLexer(FileReader reader) throws IOException {
		return new AremelleLexer(new ANTLRInputStream(reader));
	}

	public static AremelleLexer getLexer(String code) throws IOException {
		return new AremelleLexer(new ANTLRInputStream(code));
	}

	public static ProgramContext getProgramContext(AremelleLexer lexer) {
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		AremelleParser parser = new AremelleParser(tokens);
		return parser.program();
	}
	
	public static ProgramContext getProgramContextFromFilename(String filename) throws FileNotFoundException, IOException {
		AremelleLexer lexer = AntlrManager.getLexer(new FileReader(filename));
		ProgramContext newCont = AntlrManager.getProgramContext(lexer);
		return newCont;
	}	
}
