package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import aremelle.Program;
import exceptions.NoMatchingSignatureException;
import exceptions.NotANumberException;
import exceptions.UndefinedVariableException;

import org.junit.Before;
import org.junit.Test;

import caremelle.AremelleProgramBuilder;
import caremelle.AremelleProgramExecutor;

public class ExecutorTest {
	
	private AremelleProgramBuilder builder;
	private AremelleProgramExecutor executor;
	
	@Before
	public void setup() {
		builder = new AremelleProgramBuilder();
		executor = new AremelleProgramExecutor();
	}
	
	@Test
	public void testEcho() 
			throws FileNotFoundException, IOException, UndefinedVariableException, NoMatchingSignatureException, NotANumberException {
		builder = new AremelleProgramBuilder();
        Program program = builder.build("define echo: input = input.", new String[]{"test"});
        String out = executor.evaluateProgram(program);
        assertEquals("test", out);
	}
	
	@Test
	public void testCallNestedFunctionDoubleHelper() 
			throws FileNotFoundException, IOException, UndefinedVariableException, NoMatchingSignatureException, NotANumberException {
		builder = new AremelleProgramBuilder();
        Program program = builder.build("define double: define doubleHelper:	b = b b. a = doubleHelper(a) a.", new String[]{"test"});
        String out = executor.evaluateProgram(program);
        assertEquals("testtesttest", out);
	}
	
	@Test
	public void testConstant() 
			throws FileNotFoundException, IOException, UndefinedVariableException, NoMatchingSignatureException, NotANumberException {
		builder = new AremelleProgramBuilder();
        Program program = builder.build("define pi: 3.14.", new String[]{"test"});
        String out = executor.evaluateProgram(program);
        assertEquals("3.14", out);
	}
	
	@Test
	public void testInc() 
			throws FileNotFoundException
			, IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException {
		builder = new AremelleProgramBuilder();
        Program program = builder.build("define test: int = inc(int).", new String[]{"1"});
        String out = executor.evaluateProgram(program);
        assertEquals("2", out);
	}
	
	@Test
	public void testSingleFunctionCall() 
			throws FileNotFoundException
			, IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException {
		builder = new AremelleProgramBuilder();
        Program program = builder.build("define outer: define inner: a = a. b = inner(b).", new String[]{"1"});
        String out = executor.evaluateProgram(program);
        assertEquals("1", out);
	}

	@Test
	public void testMultiExpressionResult() 
			throws FileNotFoundException
			, IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException {
		builder = new AremelleProgramBuilder();
        Program program = builder.build("define outer: a = inc(a) inc(a).", new String[]{"1"});
        String out = executor.evaluateProgram(program);
        assertEquals("22", out);
	}
	
	@Test
	public void testRecursiveCall() 
			throws FileNotFoundException
			, IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException {
		builder = new AremelleProgramBuilder();
        Program program = builder.build("define count: 10 = 'done'; counter = count(inc(counter)).", new String[]{"1"});
        String out = executor.evaluateProgram(program);
        assertEquals("done", out);
	}
	
	@Test
	public void testOut() 
			throws FileNotFoundException
			, IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException {
		builder = new AremelleProgramBuilder();
        Program program = builder.build("define echo: output = out(output).", new String[]{"Hello, World!"});
        String out = executor.evaluateProgram(program);
        assertEquals("", out);
	}
	
	@Test
	public void testIn() 
			throws FileNotFoundException
			, IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException {
		builder = new AremelleProgramBuilder();
        Program program = builder.build("define echo: in().", new String[]{"Hello, World!"});
        //String out = executor.evaluateProgram(program);
	}
	
	@Test
	public void testInComplex() 
			throws FileNotFoundException
			, IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException {
		builder = new AremelleProgramBuilder();
        Program program = builder.build("define echo: define helper: input = input input. helper(in()).", new String[]{"Hello, World!"});
        //String out = executor.evaluateProgram(program);
	}
	
	@Test
	public void testAddNaive() 
			throws FileNotFoundException
			, IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException {
		builder = new AremelleProgramBuilder();
        Program program = builder.build(new FileReader("Program0.rml"), new String[]{"200000", "10000"});
        String out = executor.evaluateProgram(program);
        assertEquals("210000", out);
	}
	
	@Test
	public void testMultNaiveFlatFunctions() 
			throws FileNotFoundException
			, IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException {
		builder = new AremelleProgramBuilder();
        Program program = builder.build(new FileReader("Program1.rml"), new String[]{"100000", "2"});
        String out = executor.evaluateProgram(program);
        assertEquals("200000", out);
	}
	
	@Test
	public void testMultNaiveNestedFunctions() 
			throws FileNotFoundException
			, IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException {
		builder = new AremelleProgramBuilder();
        Program program = builder.build(new FileReader("Program2.rml"), new String[]{"100000", "2"});
        String out = executor.evaluateProgram(program);
        assertEquals("200000", out);
	}
	
	@Test
	public void testAppendDigitWithCarry() 
			throws FileNotFoundException
			, IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException {
		builder = new AremelleProgramBuilder();
        assertEquals("c52", 
        		executor.evaluateProgram(builder.build(new FileReader("AppendDigitWithCarry.rml"), new String[]{"15", "2"})));
        assertEquals("60", 
        		executor.evaluateProgram(builder.build(new FileReader("AppendDigitWithCarry.rml"), new String[]{"5", "c0"})));
        assertEquals("c01", 
        		executor.evaluateProgram(builder.build(new FileReader("AppendDigitWithCarry.rml"), new String[]{"9", "c1"})));
        assertEquals("45", 
        		executor.evaluateProgram(builder.build(new FileReader("AppendDigitWithCarry.rml"), new String[]{"4", "5"})));
        assertEquals("c55", 
        		executor.evaluateProgram(builder.build(new FileReader("AppendDigitWithCarry.rml"), new String[]{"14", "c5"})));
        assertEquals("55", 
        		executor.evaluateProgram(builder.build(new FileReader("AppendDigitWithCarry.rml"), new String[]{"4", "c5"})));
        assertEquals("9", 
        		executor.evaluateProgram(builder.build(new FileReader("AppendDigitWithCarry.rml"), new String[]{"9", ""})));
        assertEquals("20", 
        		executor.evaluateProgram(builder.build(new FileReader("AppendDigitWithCarry.rml"), new String[]{"1", "c0"})));
	}
	
	@Test
	public void testGetLastCharacter() 
			throws FileNotFoundException
			, IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException {
        assertEquals("r", 
        		executor.evaluateProgram(builder.build(new FileReader("GetLastCharacter.rml"), new String[]{"lastcharacter"})));
        assertEquals("r", 
        		executor.evaluateProgram(builder.build(new FileReader("GetLastCharacter.rml"), new String[]{"r"})));
	}
	
	@Test(expected = NoMatchingSignatureException.class)
	public void testGetLastCharacterEmptyString() 
			throws FileNotFoundException
			, IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException {
		Program program = builder.build(new FileReader("GetLastCharacter.rml"), new String[]{""});
        String out = executor.evaluateProgram(program);
        assertEquals("", out);
	}
	
	@Test
	public void testGetAllButLastCharacter() 
			throws FileNotFoundException
			, IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException {
        assertEquals("lastcharacte", 
        		executor.evaluateProgram(builder.build(new FileReader("GetAllButLastCharacter.rml"), new String[]{"lastcharacter"})));
        assertEquals("", 
        		executor.evaluateProgram(builder.build(new FileReader("GetAllButLastCharacter.rml"), new String[]{"r"})));
	}
	
	@Test
	public void testPadWithZeros() 
			throws FileNotFoundException
			, IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException {
		builder = new AremelleProgramBuilder();
        assertEquals("000001", 
        		executor.evaluateProgram(builder.build(new FileReader("PadWithZeros.rml"), new String[]{"1", "123456"})));
        assertEquals("01", 
        		executor.evaluateProgram(builder.build(new FileReader("PadWithZeros.rml"), new String[]{"1", "19"})));
        assertEquals("19", 
        		executor.evaluateProgram(builder.build(new FileReader("PadWithZeros.rml"), new String[]{"19", "1"})));
        assertEquals("123", 
        		executor.evaluateProgram(builder.build(new FileReader("PadWithZeros.rml"), new String[]{"123", "123"})));
        assertEquals("123456", 
        		executor.evaluateProgram(builder.build(new FileReader("PadWithZeros.rml"), new String[]{"123456", "12345"})));
        assertEquals("4", 
        		executor.evaluateProgram(builder.build(new FileReader("PadWithZeros.rml"), new String[]{"4", "5"})));
        assertEquals("5", 
        		executor.evaluateProgram(builder.build(new FileReader("PadWithZeros.rml"), new String[]{"5", "4"})));
	}
	
	@Test
	public void testNaiveAdd() 
			throws FileNotFoundException
			, IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException {
		builder = new AremelleProgramBuilder();
        assertEquals("9", 
        		executor.evaluateProgram(builder.build("define naiveAdd: aaa, 0 = aaa; aaa, bbb = naiveAdd(inc(aaa), dec(bbb)).", 
        				new String[]{"4", "5"})));
	}
	
	@Test
	public void testAdd() 
			throws FileNotFoundException
			, IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException {
		builder = new AremelleProgramBuilder();
        assertEquals("2", 
        		executor.evaluateProgram(builder.build(new FileReader("Add.rml"), new String[]{"1", "1"})));
        assertEquals("100", 
        		executor.evaluateProgram(builder.build(new FileReader("Add.rml"), new String[]{"47", "53"})));
        assertEquals("10", 
                		executor.evaluateProgram(builder.build(new FileReader("Add.rml"), new String[]{"1", "9"})));
        assertEquals("20", 
        		executor.evaluateProgram(builder.build(new FileReader("Add.rml"), new String[]{"1", "19"})));
        assertEquals("15299172044422", 
        		executor.evaluateProgram(builder.build(new FileReader("Add.rml"), new String[]{"9999084587961", "5300087456461"})));
        assertEquals("-15299172044422", 
        		executor.evaluateProgram(builder.build(new FileReader("Add.rml"), new String[]{"-9999084587961", "-5300087456461"})));
	}
	
	@Test
	public void testMultiParamStatements() 
			throws FileNotFoundException
			, IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException {
		builder = new AremelleProgramBuilder();
        assertEquals("test", 
        		executor.evaluateProgram(builder.build("define func: a | {''}:a = a.", new String[]{"test"})));
        assertEquals("", 
        		executor.evaluateProgram(builder.build("define func: a | {''}:a = a.", new String[]{""})));
        assertEquals("2", 
        		executor.evaluateProgram(builder.build("define func: {1}:a | {2}:a = a.", new String[]{"2"})));
        try {
        	executor.evaluateProgram(builder.build("define func: {1}:a | {2}:a = a.", new String[]{"3"}));
        	assertTrue(false);
        }
        catch (NoMatchingSignatureException e) {}
	}
	
	@Test
	public void testEquals() 
			throws FileNotFoundException
			, IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException {
		builder = new AremelleProgramBuilder();
        assertEquals("true", 
        		executor.evaluateProgram(builder.build(new FileReader("Equals.rml"), new String[]{"test", "test"})));
        assertEquals("false", 
        		executor.evaluateProgram(builder.build(new FileReader("Equals.rml"), new String[]{"test", "ssd"})));
        assertEquals("false", 
        		executor.evaluateProgram(builder.build(new FileReader("Equals.rml"), new String[]{"", "test"})));
        assertEquals("false", 
        		executor.evaluateProgram(builder.build(new FileReader("Equals.rml"), new String[]{"test", ""})));
        assertEquals("true", 
        		executor.evaluateProgram(builder.build(new FileReader("Equals.rml"), new String[]{"", ""})));
	}
	
	@Test
	public void testPalindrome() 
			throws FileNotFoundException
			, IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException {
		builder = new AremelleProgramBuilder();
        assertEquals("false", 
        		executor.evaluateProgram(builder.build(new FileReader("Palindrome.rml"), new String[]{"test"})));
        assertEquals("true", 
        		executor.evaluateProgram(builder.build(new FileReader("Palindrome.rml"), new String[]{"otto"})));
        assertEquals("true", 
        		executor.evaluateProgram(builder.build(new FileReader("Palindrome.rml"), new String[]{"madamimadam"})));
        assertEquals("false", 
        		executor.evaluateProgram(builder.build(new FileReader("Palindrome.rml"), new String[]{"ta"})));
        assertEquals("true", 
        		executor.evaluateProgram(builder.build(new FileReader("Palindrome.rml"), new String[]{"aa"})));
        assertEquals("true", 
        		executor.evaluateProgram(builder.build(new FileReader("Palindrome.rml"), new String[]{""})));
	}
}
