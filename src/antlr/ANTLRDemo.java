package antlr;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import caremelle.AremelleProgramBuilder;
import caremelle.AremelleProgramExecutor;
import aremelle.Program;
import exceptions.NoMatchingSignatureException;
import exceptions.NotANumberException;
import exceptions.UndefinedVariableException;

public class ANTLRDemo {
    public static void main(String[] args) 
    		throws FileNotFoundException
    		, IOException
    		, UndefinedVariableException
    		, NoMatchingSignatureException
    		, NotANumberException  {
        AremelleProgramBuilder parser = new AremelleProgramBuilder();
        Program program = parser.build(new FileReader("Program1.rml"), new String[]{"test"});
        String out = (new AremelleProgramExecutor()).evaluateProgram(program);
        System.out.println(out);
    }
}