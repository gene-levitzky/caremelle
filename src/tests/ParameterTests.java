package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import aremelle.Argument;

public class ParameterTests {
	
	private Argument any = new Argument("any string ought to do");
	
	@Test
	public void testParameter() {
		aremelle.Parameter atom = new aremelle.Parameter("name");
		aremelle.Pattern param = new aremelle.Pattern(atom);
		assertTrue(param.fitArgument(any));
	}

	@Test
	public void testParameterAtomicParameterValue() {
		aremelle.Parameter atom = new aremelle.Parameter("name");
		aremelle.Pattern param = new aremelle.Pattern(atom);
		param.fitArgument(any);
		assertEquals(any, atom.getValue());
	}
	
	@Test
	public void testParameter1() {
		aremelle.Pattern param = new aremelle.Pattern(
				new aremelle.Parameter(null, "A|B"),
				new aremelle.Parameter("name"),
				new aremelle.Parameter(null, "C*"));
		Argument testString = new Argument("AbunchofStuffCCCCCCCC");
		assertTrue(param.fitArgument(testString));
	}

	@Test
	public void testParameterAtomicParameterValue1() {

		aremelle.Parameter a1 = new aremelle.Parameter(null, "A|B");
		aremelle.Parameter a2 = new aremelle.Parameter("name");
		aremelle.Parameter a3 = new aremelle.Parameter(null, "C+");
		aremelle.Pattern param = new aremelle.Pattern(a1, a2, a3);
		Argument testString = new Argument("AbunchofStuffCCCCCCCC");
		param.fitArgument(testString);
		assertEquals(a1.getValue(), "A");
		assertEquals(a2.getValue(), "bunchofStuff");
		assertEquals(a3.getValue(), "CCCCCCCC");
	}
	
	@Test
	public void testParameterAtomicParameterValue2() {

		aremelle.Parameter a1 = new aremelle.Parameter(null, "A|B");
		aremelle.Parameter a2 = new aremelle.Parameter("name");
		aremelle.Parameter a3 = new aremelle.Parameter(null, "C+");
		aremelle.Parameter a4 = new aremelle.Parameter("name1");
		aremelle.Pattern param = new aremelle.Pattern(a1, a2, a3, a4);
		Argument testString = new Argument("AbunchofStuffCCCCCCCC");
		param.fitArgument(testString);
		assertEquals(a1.getValue(), "A");
		assertEquals(a2.getValue(), "bunchofStuff");
		assertEquals(a3.getValue(), "CCCCCCCC");
		assertEquals(a4.getValue(), "");
	}
	
	@Test
	public void testParameterAtomicParameterValue3() {

		aremelle.Parameter a1 = new aremelle.Parameter("name");
		aremelle.Parameter a2 = new aremelle.Parameter(null, "toReplace");
		aremelle.Parameter a3 = new aremelle.Parameter("name1");
		aremelle.Pattern param = new aremelle.Pattern(a1, a2, a3);
		Argument testString = new Argument("bunchofrandomnonesense1-toReplace-anotherbunchofRandomNoise");
		param.fitArgument(testString);
		assertEquals(a1.getValue(), "bunchofrandomnonesense1-");
		assertEquals(a2.getValue(), "toReplace");
		assertEquals(a3.getValue(), "-anotherbunchofRandomNoise");
	}
	
	@Test
	public void testParameterAtomicParameterValueNestedGroups() {

		aremelle.Parameter a1 = new aremelle.Parameter(null, "((A)|B)");
		aremelle.Parameter a2 = new aremelle.Parameter("name");
		aremelle.Parameter a3 = new aremelle.Parameter(null, "(C+)");
		aremelle.Pattern param = new aremelle.Pattern(a1, a2, a3);
		Argument testString = new Argument("AbunchofStuffCCCCCCCC");
		param.fitArgument(testString);
		assertEquals(a1.getValue(), "A");
		assertEquals(a2.getValue(), "bunchofStuff");
		assertEquals(a3.getValue(), "CCCCCCCC");
	}
}
