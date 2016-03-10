package antlr;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import caremelle.Program;
import exceptions.NoMatchingSignatureException;
import exceptions.NotANumberException;
import exceptions.UndefinedVariableException;
import executor.AremelleProgramExecutor;

public class ANTLRDemo {
    public static void main(String[] args) 
    		throws FileNotFoundException
    		, IOException
    		, UndefinedVariableException
    		, NoMatchingSignatureException
    		, NotANumberException  {
        AntlrAremelleProgramBuilder parser = new AntlrAremelleProgramBuilder();
        Program program = parser.build(new FileReader("Program1.rml"), new String[]{"test"});
        String out = (new AremelleProgramExecutor()).evaluateProgram(program);
        System.out.println(out);
    }
}