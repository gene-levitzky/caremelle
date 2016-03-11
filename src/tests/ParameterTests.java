package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import aremelle.Argument;

public class ParameterTests {
	
	private Argument any = new Argument("any string ought to do");
	
	@Test
	public void testParameter() {
		aremelle.AtomicParameter atom = new aremelle.AtomicParameter("name");
		aremelle.Parameter param = new aremelle.Parameter(atom);
		assertTrue(param.fitArgument(any));
	}

	@Test
	public void testParameterAtomicParameterValue() {
		aremelle.AtomicParameter atom = new aremelle.AtomicParameter("name");
		aremelle.Parameter param = new aremelle.Parameter(atom);
		param.fitArgument(any);
		assertEquals(any, atom.getValue());
	}
	
	@Test
	public void testParameter1() {
		aremelle.Parameter param = new aremelle.Parameter(
				new aremelle.AtomicParameter(null, "A|B"),
				new aremelle.AtomicParameter("name"),
				new aremelle.AtomicParameter(null, "C*"));
		Argument testString = new Argument("AbunchofStuffCCCCCCCC");
		assertTrue(param.fitArgument(testString));
	}

	@Test
	public void testParameterAtomicParameterValue1() {

		aremelle.AtomicParameter a1 = new aremelle.AtomicParameter(null, "A|B");
		aremelle.AtomicParameter a2 = new aremelle.AtomicParameter("name");
		aremelle.AtomicParameter a3 = new aremelle.AtomicParameter(null, "C+");
		aremelle.Parameter param = new aremelle.Parameter(a1, a2, a3);
		Argument testString = new Argument("AbunchofStuffCCCCCCCC");
		param.fitArgument(testString);
		assertEquals(a1.getValue(), "A");
		assertEquals(a2.getValue(), "bunchofStuff");
		assertEquals(a3.getValue(), "CCCCCCCC");
	}
	
	@Test
	public void testParameterAtomicParameterValue2() {

		aremelle.AtomicParameter a1 = new aremelle.AtomicParameter(null, "A|B");
		aremelle.AtomicParameter a2 = new aremelle.AtomicParameter("name");
		aremelle.AtomicParameter a3 = new aremelle.AtomicParameter(null, "C+");
		aremelle.AtomicParameter a4 = new aremelle.AtomicParameter("name1");
		aremelle.Parameter param = new aremelle.Parameter(a1, a2, a3, a4);
		Argument testString = new Argument("AbunchofStuffCCCCCCCC");
		param.fitArgument(testString);
		assertEquals(a1.getValue(), "A");
		assertEquals(a2.getValue(), "bunchofStuff");
		assertEquals(a3.getValue(), "CCCCCCCC");
		assertEquals(a4.getValue(), "");
	}
	
	@Test
	public void testParameterAtomicParameterValue3() {

		aremelle.AtomicParameter a1 = new aremelle.AtomicParameter("name");
		aremelle.AtomicParameter a2 = new aremelle.AtomicParameter(null, "toReplace");
		aremelle.AtomicParameter a3 = new aremelle.AtomicParameter("name1");
		aremelle.Parameter param = new aremelle.Parameter(a1, a2, a3);
		Argument testString = new Argument("bunchofrandomnonesense1-toReplace-anotherbunchofRandomNoise");
		param.fitArgument(testString);
		assertEquals(a1.getValue(), "bunchofrandomnonesense1-");
		assertEquals(a2.getValue(), "toReplace");
		assertEquals(a3.getValue(), "-anotherbunchofRandomNoise");
	}
	
	@Test
	public void testParameterAtomicParameterValueNestedGroups() {

		aremelle.AtomicParameter a1 = new aremelle.AtomicParameter(null, "((A)|B)");
		aremelle.AtomicParameter a2 = new aremelle.AtomicParameter("name");
		aremelle.AtomicParameter a3 = new aremelle.AtomicParameter(null, "(C+)");
		aremelle.Parameter param = new aremelle.Parameter(a1, a2, a3);
		Argument testString = new Argument("AbunchofStuffCCCCCCCC");
		param.fitArgument(testString);
		assertEquals(a1.getValue(), "A");
		assertEquals(a2.getValue(), "bunchofStuff");
		assertEquals(a3.getValue(), "CCCCCCCC");
	}
}
