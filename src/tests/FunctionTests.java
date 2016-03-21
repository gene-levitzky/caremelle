package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import aremelle.AtomicExpression;
import aremelle.AtomicExpressionIdentifier;
import aremelle.AtomicExpressionLiteral;
import aremelle.Parameter;
import aremelle.Expression;
import aremelle.Function;
import aremelle.Pattern;
import aremelle.Signature;
import aremelle.RewriteRule;
import aremelle.exceptions.NoMatchingSignatureException;
import aremelle.exceptions.NotANumberException;
import aremelle.exceptions.UndefinedVariableException;

public class FunctionTests {
	
	/*@Test
	public void testConstantFunction() throws UndefinedVariableException, NoMatchingSignatureException, NotANumberException {
		String constant = "3.14";
		AtomicExpression atom = new AtomicExpressionLiteral(constant);
		Expression e = new Expression(atom);
		Function function = new Function("pi", null, e, null);
		String result = function.evaluate(new String[]{});
		assertEquals(constant, result);
	}
	
	@Test
	public void testEchoFunction() throws UndefinedVariableException, NoMatchingSignatureException, NotANumberException {
		AtomicExpression a1 = new AtomicExpressionIdentifier("param1");
		AtomicExpression a2 = new AtomicExpressionIdentifier("param1");
		Expression e = new Expression(a1, a2);
		Parameter parameter = new caremelle.Parameter(new AtomicParameter("param1"));
		Parameters parameters = new Parameters(parameter);
		Statement s = new Statement(new Parameters[]{parameters}, e);
		
		Function function = new Function("echo", null, null, new Statement[]{s});
		String result = function.evaluate(new String[]{"Hello"});
		assertEquals("HelloHello", result);
	}

	@Test
	public void testGetFirstCharFunction() throws UndefinedVariableException, NoMatchingSignatureException, NotANumberException {
		AtomicExpression a = new AtomicExpressionIdentifier("firstChar");
		Expression e = new Expression(a);
		Parameter parameter = new caremelle.Parameter(
				new AtomicParameter("firstChar", "."),
				new AtomicParameter("param"));
		Parameters parameters = new Parameters(parameter);
		Statement s = new Statement(new Parameters[]{parameters}, e);
		
		Function function = new Function("getFirstCharacter", null, null, new Statement[]{s});
		String result = function.evaluate(new String[]{"Hello"});
		assertEquals("H", result);
	}
	
	@Test
	public void testGetAllButFirstCharFunction() throws UndefinedVariableException, NoMatchingSignatureException, NotANumberException {
		AtomicExpression a = new AtomicExpressionIdentifier("param");
		Expression e = new Expression(a);
		Parameter parameter = new caremelle.Parameter(
				new AtomicParameter("firstChar", "."),
				new AtomicParameter("param"));
		Parameters parameters = new Parameters(parameter);
		Statement s = new Statement(new Parameters[]{parameters}, e);
		
		Function function = new Function("getFirstCharacter", null, null, new Statement[]{s});
		String result = function.evaluate(new String[]{"Hello"});
		assertEquals("ello", result);
	}
	
	@Test
	public void testReplaceHardCodedFunction() throws UndefinedVariableException, NoMatchingSignatureException, NotANumberException {
		
		// Define the expression that generates the result (RHS)
		AtomicExpression a1 = new AtomicExpressionIdentifier("left");
		AtomicExpression a2 = new AtomicExpressionIdentifier("new");
		AtomicExpression a3 = new AtomicExpressionIdentifier("right");
		Expression e = new Expression(a1, a2, a3);
		
		// Define parameters for function signature (LHS)
		Parameter parameter1 = new Parameter(new AtomicParameter("new"));
		Parameter parameter2 = new Parameter(
				new AtomicParameter("left"),
				new AtomicParameter("toReplace", "A"),
				new AtomicParameter("right"));
		Parameters parameters = new Parameters(parameter1, parameter2);
		
		// Define the statement (LHS = RHS)
		Statement s = new Statement(new Parameters[]{parameters}, e);
		
		Function function = new Function("replace", null, null, new Statement[]{s});
		String result = function.evaluate(new String[]{
				"B",
				"12345 A 6789"
		});
		assertEquals("12345 B 6789", result);
	}
	
	@Test
	public void testReplaceFunction() throws UndefinedVariableException, NoMatchingSignatureException, NotANumberException {
		
		// Define the expression that generates the result (RHS)
		AtomicExpression a1 = new AtomicExpressionIdentifier("left");
		AtomicExpression a2 = new AtomicExpressionIdentifier("new");
		AtomicExpression a3 = new AtomicExpressionIdentifier("right");
		Expression e = new Expression(a1, a2, a3);
		
		// Define parameters for function signature (LHS)
		Parameter parameter1 = new Parameter(new AtomicParameter("old"));
		Parameter parameter2 = new Parameter(new AtomicParameter("new"));
		Parameter parameter3 = new Parameter(
				new AtomicParameter("left"),
				new AtomicParameter("old"),
				new AtomicParameter("right"));
		Parameters parameters = new Parameters(parameter1, parameter2, parameter3);
		
		// Define the statement (LHS = RHS)
		Statement s = new Statement(new Parameters[]{parameters}, e);
		
		Function function = new Function("replace", null, null, new Statement[]{s});
		String result = function.evaluate(new String[]{
				"A",
				"B",
				"12345 A 6789"
		});
		assertEquals("12345 B 6789", result);
	}
	
	@Test
	public void testIncFunction() throws UndefinedVariableException, NoMatchingSignatureException, NotANumberException {
		Function inc = Function.INC;
		String result = inc.evaluate(new String[]{"0"});
		assertEquals("1", result);
	}
	
	@Test
	public void testDecFunction() throws UndefinedVariableException, NoMatchingSignatureException, NotANumberException {
		Function dec = Function.DEC;
		String result = dec.evaluate(new String[]{"12345"});
		assertEquals("12344", result);
	}
	
	@Test
	public void testDecFunctionDouble() throws UndefinedVariableException, NoMatchingSignatureException, NotANumberException {
		Function dec = Function.DEC;
		String result = dec.evaluate(new String[]{"12345.0"});
		assertEquals("12344.0", result);
	}
	
	@Test
	public void testOutFunction() throws UndefinedVariableException, NoMatchingSignatureException, NotANumberException {
		Function out = Function.OUT;
		String result = out.evaluate(new String[]{"Hello, World!"});
		assertEquals("", result);
	}*/
}
