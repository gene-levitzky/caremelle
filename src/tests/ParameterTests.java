package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import caremelle.Argument;

public class ParameterTests {
	
	private Argument any = new Argument("any string ought to do");
	
	@Test
	public void testParameter() {
		caremelle.AtomicParameter atom = new caremelle.AtomicParameter("name");
		caremelle.Parameter param = new caremelle.Parameter(atom);
		assertTrue(param.fitArgument(any));
	}

	@Test
	public void testParameterAtomicParameterValue() {
		caremelle.AtomicParameter atom = new caremelle.AtomicParameter("name");
		caremelle.Parameter param = new caremelle.Parameter(atom);
		param.fitArgument(any);
		assertEquals(any, atom.getValue());
	}
	
	@Test
	public void testParameter1() {
		caremelle.Parameter param = new caremelle.Parameter(
				new caremelle.AtomicParameter(null, "A|B"),
				new caremelle.AtomicParameter("name"),
				new caremelle.AtomicParameter(null, "C*"));
		Argument testString = new Argument("AbunchofStuffCCCCCCCC");
		assertTrue(param.fitArgument(testString));
	}

	@Test
	public void testParameterAtomicParameterValue1() {

		caremelle.AtomicParameter a1 = new caremelle.AtomicParameter(null, "A|B");
		caremelle.AtomicParameter a2 = new caremelle.AtomicParameter("name");
		caremelle.AtomicParameter a3 = new caremelle.AtomicParameter(null, "C+");
		caremelle.Parameter param = new caremelle.Parameter(a1, a2, a3);
		Argument testString = new Argument("AbunchofStuffCCCCCCCC");
		param.fitArgument(testString);
		assertEquals(a1.getValue(), "A");
		assertEquals(a2.getValue(), "bunchofStuff");
		assertEquals(a3.getValue(), "CCCCCCCC");
	}
	
	@Test
	public void testParameterAtomicParameterValue2() {

		caremelle.AtomicParameter a1 = new caremelle.AtomicParameter(null, "A|B");
		caremelle.AtomicParameter a2 = new caremelle.AtomicParameter("name");
		caremelle.AtomicParameter a3 = new caremelle.AtomicParameter(null, "C+");
		caremelle.AtomicParameter a4 = new caremelle.AtomicParameter("name1");
		caremelle.Parameter param = new caremelle.Parameter(a1, a2, a3, a4);
		Argument testString = new Argument("AbunchofStuffCCCCCCCC");
		param.fitArgument(testString);
		assertEquals(a1.getValue(), "A");
		assertEquals(a2.getValue(), "bunchofStuff");
		assertEquals(a3.getValue(), "CCCCCCCC");
		assertEquals(a4.getValue(), "");
	}
	
	@Test
	public void testParameterAtomicParameterValue3() {

		caremelle.AtomicParameter a1 = new caremelle.AtomicParameter("name");
		caremelle.AtomicParameter a2 = new caremelle.AtomicParameter(null, "toReplace");
		caremelle.AtomicParameter a3 = new caremelle.AtomicParameter("name1");
		caremelle.Parameter param = new caremelle.Parameter(a1, a2, a3);
		Argument testString = new Argument("bunchofrandomnonesense1-toReplace-anotherbunchofRandomNoise");
		param.fitArgument(testString);
		assertEquals(a1.getValue(), "bunchofrandomnonesense1-");
		assertEquals(a2.getValue(), "toReplace");
		assertEquals(a3.getValue(), "-anotherbunchofRandomNoise");
	}
	
	@Test
	public void testParameterAtomicParameterValueNestedGroups() {

		caremelle.AtomicParameter a1 = new caremelle.AtomicParameter(null, "((A)|B)");
		caremelle.AtomicParameter a2 = new caremelle.AtomicParameter("name");
		caremelle.AtomicParameter a3 = new caremelle.AtomicParameter(null, "(C+)");
		caremelle.Parameter param = new caremelle.Parameter(a1, a2, a3);
		Argument testString = new Argument("AbunchofStuffCCCCCCCC");
		param.fitArgument(testString);
		assertEquals(a1.getValue(), "A");
		assertEquals(a2.getValue(), "bunchofStuff");
		assertEquals(a3.getValue(), "CCCCCCCC");
	}
}
