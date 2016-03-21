package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import aremelle.Program;
import aremelle.exceptions.CannotImportFunctionException;
import aremelle.exceptions.NoMatchingSignatureException;
import aremelle.exceptions.NotANumberException;
import aremelle.exceptions.UndeclaredVariableException;
import aremelle.exceptions.UndefinedVariableException;

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
			throws FileNotFoundException
			, IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException
			, UndeclaredVariableException, CannotImportFunctionException {
		builder = new AremelleProgramBuilder();
        Program program = builder.build(
        		"define echo: input = input.", 
        		new String[]{"test"});
        String out = executor.evaluateProgram(program);
        assertEquals("test", out);
	}
	
	@Test
	public void testMultiParameterPattern() 
			throws FileNotFoundException
			, IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException
			, UndeclaredVariableException, CannotImportFunctionException {
		builder = new AremelleProgramBuilder();
        Program program = builder.build(
        		new FileReader("examples/MultiParameterPattern"), 
        		new String[]{"left,right", "other"});
        String out = executor.evaluateProgram(program);
        assertEquals("right", out);
	}
	
	@Test
	public void testParameterPersistence() 
			throws FileNotFoundException
			, IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException
			, UndeclaredVariableException, CannotImportFunctionException {
		builder = new AremelleProgramBuilder();
        Program program = builder.build(
        		new FileReader("examples/Persistence.rml"), 
        		new String[]{"nonce", "remember?"});
        String out = executor.evaluateProgram(program);
        assertEquals("testing...remember?", out);
	}
	
	@Test(expected=UndeclaredVariableException.class)
	public void testShouldntPersist() 
			throws FileNotFoundException
			, IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException
			, UndeclaredVariableException, CannotImportFunctionException {
		builder = new AremelleProgramBuilder();
        Program program = builder.build(
        		new FileReader("examples/ShouldntPersist"), 
        		new String[]{"dontremember", "1"});
        String out = executor.evaluateProgram(program);
        assertEquals("dontremeber", out);
	}
	
	@Test
	public void testOutterScope() 
			throws FileNotFoundException
			, IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException
			, UndeclaredVariableException, CannotImportFunctionException {
		builder = new AremelleProgramBuilder();
        Program program = builder.build(
        		new FileReader("examples/Scope.rml"), 
        		new String[]{"test"});
        String out = executor.evaluateProgram(program);
        assertEquals("test", out);
	}
	
	@Test
	public void testParameterOverwriting() 
			throws FileNotFoundException
			, IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException
			, UndeclaredVariableException, CannotImportFunctionException {
		builder = new AremelleProgramBuilder();
        Program program = builder.build(
        		new FileReader("examples/ParameterOverwriting.rml"), 
        		new String[]{"3"});
        String out = executor.evaluateProgram(program);
        assertEquals("done", out);
	}
	
	@Test
	public void testDollarParam() 
			throws FileNotFoundException
			, IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException
			, UndeclaredVariableException, CannotImportFunctionException {
		builder = new AremelleProgramBuilder();
        Program program = builder.build(
        		"define echo: $empty = 'it works!'.", 
        		new String[]{""});
        String out = executor.evaluateProgram(program);
        assertEquals("it works!", out);
	}
	
	@Test
	public void testDollarParamSplit() 
			throws FileNotFoundException
			, IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException
			, UndeclaredVariableException, CannotImportFunctionException {
		builder = new AremelleProgramBuilder();
		
        Program program = builder.build(
        		"define split: $left ',' $right = left.", 
        		new String[]{"left,right"});
        String out = executor.evaluateProgram(program);
        assertEquals("left", out);
        
        program = builder.build(
        		"define split: $left ',' $right = left.", 
        		new String[]{",right"});
        out = executor.evaluateProgram(program);
        assertEquals("", out);
        
        program = builder.build(
        		"define split: $left ',' $right = left.", 
        		new String[]{","});
        out = executor.evaluateProgram(program);
        assertEquals("", out);
	}
	
	@Test
	public void testCallNestedFunctionDoubleHelper() 
			throws FileNotFoundException
			, IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException
			, UndeclaredVariableException, CannotImportFunctionException {
		builder = new AremelleProgramBuilder();
        Program program = builder.build(
        		"define double: define doubleHelper: b = b b. a = doubleHelper(a) a.", 
        		new String[]{"test"});
        String out = executor.evaluateProgram(program);
        assertEquals("testtesttest", out);
	}
	
	@Test
	public void testConstant() 
			throws FileNotFoundException
			, IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException
			, UndeclaredVariableException, CannotImportFunctionException {
		builder = new AremelleProgramBuilder();
        Program program = builder.build(
        		"define pi: 3.14.", 
        		new String[]{"test"});
        String out = executor.evaluateProgram(program);
        assertEquals("3.14", out);
	}
	
	@Test
	public void testInc() 
			throws FileNotFoundException
			, IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException
			, UndeclaredVariableException, CannotImportFunctionException {
		builder = new AremelleProgramBuilder();
        Program program = builder.build(
        		"define test: int = inc(int).", 
        		new String[]{"1"});
        String out = executor.evaluateProgram(program);
        assertEquals("2", out);
	}
	
	@Test
	public void testSingleFunctionCall() 
			throws FileNotFoundException
			, IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException
			, UndeclaredVariableException, CannotImportFunctionException {
		builder = new AremelleProgramBuilder();
        Program program = builder.build(
        		"define outer: define inner: a = a. b = inner(b).", 
        		new String[]{"1"});
        String out = executor.evaluateProgram(program);
        assertEquals("1", out);
	}

	@Test
	public void testMultiExpressionResult() 
			throws 
			IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException
			, UndeclaredVariableException, CannotImportFunctionException {
		builder = new AremelleProgramBuilder();
        Program program = builder.build(
        		"define outer: a = inc(a) inc(a).", 
        		new String[]{"1"});
        String out = executor.evaluateProgram(program);
        assertEquals("22", out);
	}
	
	@Test
	public void testRecursiveCall() 
			throws IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException
			, UndeclaredVariableException, CannotImportFunctionException {
		builder = new AremelleProgramBuilder();
        Program program = builder.build(
        		"define count: 10 = 'done'; counter = count(inc(counter)).", 
        		new String[]{"1"});
        String out = executor.evaluateProgram(program);
        assertEquals("done", out);
	}
	
	@Test
	public void testOut() 
			throws IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException
			, UndeclaredVariableException, CannotImportFunctionException {
		builder = new AremelleProgramBuilder();
        Program program = builder.build(
        		"define echo: output = out(output).", 
        		new String[]{"Hello, World!"});
        String out = executor.evaluateProgram(program);
        assertEquals("", out);
	}
	
	@Test
	public void testIn() 
			throws IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, UndeclaredVariableException, CannotImportFunctionException {
		builder = new AremelleProgramBuilder();
        Program program = builder.build(
        		"define echo: in().", 
        		new String[]{"Hello, World!"});
        //String out = executor.evaluateProgram(program);
	}
	
	@Test
	public void testInComplex() 
			throws IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException
			, UndeclaredVariableException, CannotImportFunctionException {
		builder = new AremelleProgramBuilder();
        Program program = builder.build(
        		"define echo: define helper: input = input input. helper(in()).",
        		new String[]{"Hello, World!"});
        //String out = executor.evaluateProgram(program);
	}
	
	@Test
	public void testAddNaive() 
			throws IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException
			, UndeclaredVariableException, CannotImportFunctionException {
		builder = new AremelleProgramBuilder();
        Program program = builder.build(
        		new FileReader("examples/Program0.rml"), 
        		new String[]{"200000", "10000"});
        String out = executor.evaluateProgram(program);
        assertEquals("210000", out);
	}
	
	@Test
	public void testMultNaiveFlatFunctions() 
			throws IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException
			, UndeclaredVariableException, CannotImportFunctionException {
		builder = new AremelleProgramBuilder();
        Program program = builder.build(
        		new FileReader("examples/Program1.rml"), 
        		new String[]{"100000", "2"});
        String out = executor.evaluateProgram(program);
        assertEquals("200000", out);
	}
	
	@Test
	public void testMultNaiveNestedFunctions() 
			throws IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException
			, UndeclaredVariableException, CannotImportFunctionException {
		builder = new AremelleProgramBuilder();
        Program program = builder.build(
        		new FileReader("examples/Program2.rml"), 
        		new String[]{"100000", "2"});
        String out = executor.evaluateProgram(program);
        assertEquals("200000", out);
	}
	
	@Test
	public void testAppendDigitWithCarry() 
			throws IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException
			, UndeclaredVariableException, CannotImportFunctionException {
		builder = new AremelleProgramBuilder();
        assertEquals("c52", executor.evaluateProgram(builder.build(
        		new FileReader("examples/AppendDigitWithCarry.rml"), 
        		new String[]{"15", "2"})));
        assertEquals("60", executor.evaluateProgram(builder.build(
        		new FileReader("examples/AppendDigitWithCarry.rml"), 
        		new String[]{"5", "c0"})));
        assertEquals("c01", executor.evaluateProgram(builder.build(
        		new FileReader("examples/AppendDigitWithCarry.rml"), 
        		new String[]{"9", "c1"})));
        assertEquals("45", executor.evaluateProgram(builder.build(
        		new FileReader("examples/AppendDigitWithCarry.rml"), 
        		new String[]{"4", "5"})));
        assertEquals("c55", executor.evaluateProgram(builder.build(
        		new FileReader("examples/AppendDigitWithCarry.rml"), 
        		new String[]{"14", "c5"})));
        assertEquals("55", executor.evaluateProgram(builder.build(
        		new FileReader("examples/AppendDigitWithCarry.rml"), 
        		new String[]{"4", "c5"})));
        assertEquals("9", executor.evaluateProgram(builder.build(
        		new FileReader("examples/AppendDigitWithCarry.rml"), 
        		new String[]{"9", ""})));
        assertEquals("20", executor.evaluateProgram(builder.build(
        		new FileReader("examples/AppendDigitWithCarry.rml"), 
        		new String[]{"1", "c0"})));
	}
	
	@Test
	public void testGetLastCharacter() 
			throws IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException
			, UndeclaredVariableException, CannotImportFunctionException {
        assertEquals("r", executor.evaluateProgram(builder.build(
        		new FileReader("examples/GetLastCharacter.rml"), 
        		new String[]{"lastcharacter"})));
        assertEquals("r", executor.evaluateProgram(builder.build(
        		new FileReader("examples/GetLastCharacter.rml"), 
        		new String[]{"r"})));
	}
	
	@Test(expected = NoMatchingSignatureException.class)
	public void testGetLastCharacterEmptyString() 
			throws IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException
			, UndeclaredVariableException, CannotImportFunctionException {
		Program program = builder.build(
				new FileReader("examples/GetLastCharacter.rml"), 
				new String[]{""});
        String out = executor.evaluateProgram(program);
        assertEquals("", out);
	}
	
	@Test
	public void testGetAllButLastCharacter() 
			throws IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException
			, UndeclaredVariableException, CannotImportFunctionException {
        assertEquals("lastcharacte", executor.evaluateProgram(builder.build(
        		new FileReader("examples/GetAllButLastCharacter.rml"), 
        		new String[]{"lastcharacter"})));
        assertEquals("", executor.evaluateProgram(builder.build(
        		new FileReader("examples/GetAllButLastCharacter.rml"), 
        		new String[]{"r"})));
	}
	
	@Test
	public void testPadWithZeros() 
			throws IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException
			, UndeclaredVariableException, CannotImportFunctionException {
		builder = new AremelleProgramBuilder();
        assertEquals("100000", executor.evaluateProgram(builder.build(
        		new FileReader("rml/utility/PadWithZeros.rml"), 
        		new String[]{"1", "123456"})));
        assertEquals("10", executor.evaluateProgram(builder.build(
        		new FileReader("rml/utility/PadWithZeros.rml"), 
        		new String[]{"1", "19"})));
        assertEquals("19", executor.evaluateProgram(builder.build(
        		new FileReader("rml/utility/PadWithZeros.rml"), 
        		new String[]{"19", "1"})));
        assertEquals("123", executor.evaluateProgram(builder.build(
        		new FileReader("rml/utility/PadWithZeros.rml"), 
        		new String[]{"123", "123"})));
        assertEquals("123456", executor.evaluateProgram(builder.build(
        		new FileReader("rml/utility/PadWithZeros.rml"), 
        		new String[]{"123456", "12345"})));
        assertEquals("4", executor.evaluateProgram(builder.build(
        		new FileReader("rml/utility/PadWithZeros.rml"), 
        		new String[]{"4", "5"})));
        assertEquals("5", executor.evaluateProgram(builder.build(
        		new FileReader("rml/utility/PadWithZeros.rml"), 
        		new String[]{"5", "4"})));
	}
	
	@Test
	public void testNaiveAdd() 
			throws IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException
			, UndeclaredVariableException, CannotImportFunctionException {
		builder = new AremelleProgramBuilder();
        assertEquals("9", executor.evaluateProgram(builder.build(
        		"define naiveAdd: a, 0 = a; a, b = naiveAdd(inc(a), dec(b)).", 
        		new String[]{"4", "5"})));
	}
	
	@Test
	public void testAdd() 
			throws IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException
			, UndeclaredVariableException, CannotImportFunctionException {
		builder = new AremelleProgramBuilder();
        assertEquals("2", executor.evaluateProgram(builder.build(
        		new FileReader("rml/math/arithmetic/add.rml"), 
        		new String[]{"1", "1"})));
        assertEquals("100", executor.evaluateProgram(builder.build(
        		new FileReader("rml/math/arithmetic/add.rml"), 
        		new String[]{"47", "53"})));
        assertEquals("10", executor.evaluateProgram(builder.build(
        		new FileReader("rml/math/arithmetic/add.rml"), 
        		new String[]{"1", "9"})));
        assertEquals("20", executor.evaluateProgram(builder.build(
        		new FileReader("rml/math/arithmetic/add.rml"), 
        		new String[]{"1", "19"})));
        assertEquals("15299172044422", executor.evaluateProgram(builder.build(
        		new FileReader("rml/math/arithmetic/add.rml"), 
        		new String[]{"9999084587961", "5300087456461"})));
        assertEquals("-15299172044422", executor.evaluateProgram(builder.build(
        		new FileReader("rml/math/arithmetic/add.rml"), 
        		new String[]{"-9999084587961", "-5300087456461"})));
        assertEquals("2.2", executor.evaluateProgram(builder.build(
        		new FileReader("rml/math/arithmetic/add.rml"), 
        		new String[]{"1.1", "1.1"})));
        assertEquals("2.11", executor.evaluateProgram(builder.build(
        		new FileReader("rml/math/arithmetic/add.rml"), 
        		new String[]{"1.1", "1.01"})));
        assertEquals("2.11", executor.evaluateProgram(builder.build(
        		new FileReader("rml/math/arithmetic/add.rml"), 
        		new String[]{"1.01", "1.1"})));
        assertEquals("5.9256", executor.evaluateProgram(builder.build(
        		new FileReader("rml/math/arithmetic/add.rml"), 
        		new String[]{"3.1456", "2.78"})));
        assertEquals("10.001", executor.evaluateProgram(builder.build(
        		new FileReader("rml/math/arithmetic/add.rml"), 
        		new String[]{"10", "0.001"})));
        assertEquals("-10.001", executor.evaluateProgram(builder.build(
        		new FileReader("rml/math/arithmetic/add.rml"), 
        		new String[]{"-10", "-0.001"})));
        assertEquals("0.000001", executor.evaluateProgram(builder.build(
        		new FileReader("rml/math/arithmetic/add.rml"), 
        		new String[]{"0.00", "00.000001"})));
	}
	
	@Test
	public void testMultiParamStatements() 
			throws IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException
			, UndeclaredVariableException, CannotImportFunctionException {
		builder = new AremelleProgramBuilder();
        assertEquals("test", executor.evaluateProgram(builder.build(
        		"define func: a | {''}:a = a.", 
        		new String[]{"test"})));
        assertEquals("", executor.evaluateProgram(builder.build(
        		"define func: a | {''}:a = a.", 
        		new String[]{""})));
        assertEquals("2", executor.evaluateProgram(builder.build(
        		"define func: {1}:a | {2}:a = a.", 
        		new String[]{"2"})));
        assertEquals("2", executor.evaluateProgram(builder.build(
        		"define func: {2}:a | {1}:a = a.", 
        		new String[]{"2"})));
        try {
        	executor.evaluateProgram(builder.build(
        			"define func: {1}:a | {2}:a = a.", 
        			new String[]{"3"}));
        	assertTrue(false);
        }
        catch (NoMatchingSignatureException e) {}
	}
	
	@Test
	public void testEquals() 
			throws IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException
			, UndeclaredVariableException, CannotImportFunctionException {
		builder = new AremelleProgramBuilder();
        assertEquals("true", executor.evaluateProgram(builder.build(
        		new FileReader("rml/utility/equals.rml"), 
        		new String[]{"test", "test"})));
        assertEquals("false", executor.evaluateProgram(builder.build(
        		new FileReader("rml/utility/equals.rml"), 
        		new String[]{"test", "ssd"})));
        assertEquals("false", executor.evaluateProgram(builder.build(
        		new FileReader("rml/utility/equals.rml"), 
        		new String[]{"", "test"})));
        assertEquals("false", executor.evaluateProgram(builder.build(
        		new FileReader("rml/utility/equals.rml"), 
        		new String[]{"test", ""})));
        assertEquals("true", executor.evaluateProgram(builder.build(
        		new FileReader("rml/utility/equals.rml"), 
        		new String[]{"", ""})));
	}
	
	@Test
	public void testPalindrome() 
			throws FileNotFoundException
			, IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException
			, UndeclaredVariableException, CannotImportFunctionException {
		builder = new AremelleProgramBuilder();
        assertEquals("false", executor.evaluateProgram(builder.build(
        		new FileReader("examples/Palindrome.rml"), 
        		new String[]{"test"})));
        assertEquals("true", executor.evaluateProgram(builder.build(
        		new FileReader("examples/Palindrome.rml"), 
        		new String[]{"otto"})));
        assertEquals("true", executor.evaluateProgram(builder.build(
        		new FileReader("examples/Palindrome.rml"), 
        		new String[]{"madamimadam"})));
        assertEquals("false", executor.evaluateProgram(builder.build(
        		new FileReader("examples/Palindrome.rml"), 
        		new String[]{"ta"})));
        assertEquals("true", executor.evaluateProgram(builder.build(
        		new FileReader("examples/Palindrome.rml"), 
        		new String[]{"aa"})));
        assertEquals("true", executor.evaluateProgram(builder.build(
        		new FileReader("examples/Palindrome.rml"), 
        		new String[]{""})));
        assertEquals("false", executor.evaluateProgram(builder.build(
        		new FileReader("examples/Palindrome.rml"), 
        		new String[]{"abcd"})));
	}
	
	@Test
	public void testImport() 
			throws FileNotFoundException
			, IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException
			, UndeclaredVariableException, CannotImportFunctionException {
		builder = new AremelleProgramBuilder();
        assertEquals("false", executor.evaluateProgram(builder.build(
        		new FileReader("examples/Import1.rml"), 
        		new String[]{"test"})));
	}
	
	@Test
	public void testGt() 
			throws FileNotFoundException
			, IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException
			, UndeclaredVariableException, CannotImportFunctionException {
		builder = new AremelleProgramBuilder();
        assertEquals("true", executor.evaluateProgram(builder.build(
        		new FileReader("rml/math/relations/gt.rml"), 
        		new String[]{"10", "8"})));
        assertEquals("true", executor.evaluateProgram(builder.build(
        		new FileReader("rml/math/relations/gt.rml"), 
        		new String[]{"10", "8.0"})));
        assertEquals("true", executor.evaluateProgram(builder.build(
        		new FileReader("rml/math/relations/gt.rml"), 
        		new String[]{"10", "8"})));
        assertEquals("false", executor.evaluateProgram(builder.build(
        		new FileReader("rml/math/relations/gt.rml"), 
        		new String[]{"10", "88"})));
        assertEquals("true", executor.evaluateProgram(builder.build(
        		new FileReader("rml/math/relations/gt.rml"), 
        		new String[]{"10", "8.9"})));
        assertEquals("true", executor.evaluateProgram(builder.build(
        		new FileReader("rml/math/relations/gt.rml"), 
        		new String[]{"10", "08"})));
        assertEquals("false", executor.evaluateProgram(builder.build(
        		new FileReader("rml/math/relations/gt.rml"), 
        		new String[]{"-10", "-8"})));
        assertEquals("false", executor.evaluateProgram(builder.build(
        		new FileReader("rml/math/relations/gt.rml"), 
        		new String[]{"10", "10"})));
        assertEquals("false", executor.evaluateProgram(builder.build(
        		new FileReader("rml/math/relations/gt.rml"), 
        		new String[]{"10.0", "10"})));
        assertEquals("false", executor.evaluateProgram(builder.build(
        		new FileReader("rml/math/relations/gt.rml"), 
        		new String[]{"100.230001", "200.23"})));
        assertEquals("true", executor.evaluateProgram(builder.build(
        		new FileReader("rml/math/relations/gt.rml"), 
        		new String[]{"0.00012", "0.000000000012"})));
        assertEquals("true", executor.evaluateProgram(builder.build(
        		new FileReader("rml/math/relations/gt.rml"), 
        		new String[]{"0.000000000013", "0.000000000012"})));
        assertEquals("false", executor.evaluateProgram(builder.build(
        		new FileReader("rml/math/relations/gt.rml"), 
        		new String[]{"0.0000000000013", "0.000000000012"})));
        assertEquals("false", executor.evaluateProgram(builder.build(
        		new FileReader("rml/math/relations/gt.rml"), 
        		new String[]{"0.000000000012", "0.000000000012"})));
        assertEquals("false", executor.evaluateProgram(builder.build(
        		new FileReader("rml/math/relations/gt.rml"), 
        		new String[]{"0.000000000000", "0.000000000000"})));
        assertEquals("false", executor.evaluateProgram(builder.build(
        		new FileReader("rml/math/relations/gt.rml"), 
        		new String[]{"-0.000000000000", "0.000000000000"})));
        assertEquals("false", executor.evaluateProgram(builder.build(
        		new FileReader("rml/math/relations/gt.rml"), 
        		new String[]{"0.000000000000", "-0.000000000000"})));
        try {
        	assertEquals("true", executor.evaluateProgram(builder.build(
            		new FileReader("rml/math/relations/gt.rml"), 
            		new String[]{"NaN", "8"})));
        	fail();
        }
        catch (NoMatchingSignatureException e) {}
        try {
        	assertEquals("true", executor.evaluateProgram(builder.build(
            		new FileReader("rml/math/relations/gt.rml"), 
            		new String[]{"8", ""})));
        	fail();
        }
        catch (NoMatchingSignatureException e) {}
	}
	
	@Test
	public void testLt() 
			throws FileNotFoundException
			, IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException
			, UndeclaredVariableException, CannotImportFunctionException {
		builder = new AremelleProgramBuilder();
		String filepath = "rml/math/relations/lt.rml";
        assertEquals("false", executor.evaluateProgram(builder.build(
        		new FileReader(filepath), 
        		new String[]{"10", "8"})));
        assertEquals("false", executor.evaluateProgram(builder.build(
        		new FileReader(filepath), 
        		new String[]{"10", "8.0"})));
        assertEquals("false", executor.evaluateProgram(builder.build(
        		new FileReader(filepath), 
        		new String[]{"10", "8"})));
        assertEquals("true", executor.evaluateProgram(builder.build(
        		new FileReader(filepath), 
        		new String[]{"10", "88"})));
        assertEquals("false", executor.evaluateProgram(builder.build(
        		new FileReader(filepath), 
        		new String[]{"10", "8.9"})));
        assertEquals("false", executor.evaluateProgram(builder.build(
        		new FileReader(filepath), 
        		new String[]{"10", "08"})));
        assertEquals("true", executor.evaluateProgram(builder.build(
        		new FileReader(filepath), 
        		new String[]{"-10", "-8"})));
        assertEquals("false", executor.evaluateProgram(builder.build(
        		new FileReader(filepath), 
        		new String[]{"10", "10"})));
        assertEquals("false", executor.evaluateProgram(builder.build(
        		new FileReader(filepath), 
        		new String[]{"10.0", "10"})));
        assertEquals("true", executor.evaluateProgram(builder.build(
        		new FileReader(filepath), 
        		new String[]{"100.230001", "200.23"})));
        assertEquals("false", executor.evaluateProgram(builder.build(
        		new FileReader(filepath), 
        		new String[]{"0.00012", "0.000000000012"})));
        assertEquals("false", executor.evaluateProgram(builder.build(
        		new FileReader(filepath), 
        		new String[]{"0.000000000013", "0.000000000012"})));
        assertEquals("true", executor.evaluateProgram(builder.build(
        		new FileReader(filepath), 
        		new String[]{"0.0000000000013", "0.000000000012"})));
        assertEquals("false", executor.evaluateProgram(builder.build(
        		new FileReader(filepath), 
        		new String[]{"0.000000000012", "0.000000000012"})));
        assertEquals("false", executor.evaluateProgram(builder.build(
        		new FileReader(filepath), 
        		new String[]{"0.000000000000", "0.000000000000"})));
        assertEquals("false", executor.evaluateProgram(builder.build(
        		new FileReader(filepath), 
        		new String[]{"-0.000000000000", "0.000000000000"})));
        assertEquals("false", executor.evaluateProgram(builder.build(
        		new FileReader(filepath), 
        		new String[]{"0.000000000000", "-0.000000000000"})));
        try {
        	assertEquals("true", executor.evaluateProgram(builder.build(
            		new FileReader(filepath), 
            		new String[]{"NaN", "8"})));
        	fail();
        }
        catch (NoMatchingSignatureException e) {}
        try {
        	assertEquals("true", executor.evaluateProgram(builder.build(
            		new FileReader(filepath), 
            		new String[]{"8", ""})));
        	fail();
        }
        catch (NoMatchingSignatureException e) {}
	}
	
	@Test
	public void testFunctionAsArgument() 
			throws FileNotFoundException
			, IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException
			, UndeclaredVariableException, CannotImportFunctionException {
		builder = new AremelleProgramBuilder();
		String filepath = "examples/FunctionAsArgument.rml";
        assertEquals("22", executor.evaluateProgram(builder.build(
        		new FileReader(filepath), 
        		new String[]{"add", "15", "7"})));
        assertEquals("22", executor.evaluateProgram(builder.build(
        		new FileReader(filepath), 
        		new String[]{"'add'", "15", "7"})));
        try {
        	assertEquals("22", executor.evaluateProgram(builder.build(
            		new FileReader(filepath), 
            		new String[]{"add", "1j5", "14"})));
        	fail();
        }
        catch (NotANumberException e) {}
	}
	
	@Test
	public void testIf() 
			throws FileNotFoundException
			, IOException
			, UndefinedVariableException
			, NoMatchingSignatureException
			, NotANumberException
			, UndeclaredVariableException, CannotImportFunctionException {
		builder = new AremelleProgramBuilder();
		String filepath = "examples/IfTest.rml";
        assertEquals("True Condition Executed", executor.evaluateProgram(builder.build(
        		new FileReader(filepath), 
        		new String[]{"true"})));
        assertEquals("False Condition Executed", executor.evaluateProgram(builder.build(
        		new FileReader(filepath), 
        		new String[]{"false"})));
	}
}
