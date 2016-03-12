package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AtomicParameterTests {

	@Test
	public void testNumberofCaptureGroups() {
		aremelle.Parameter atom = new aremelle.Parameter("name", "(A)(B|(C))((D))");
		assertEquals(5, atom.getNumberOfCaptureGroups());
	}
	
	@Test
	public void testNumberofCaptureGroupsWithQuotes() {
		aremelle.Parameter atom = new aremelle.Parameter("name", "(A)'(B|(C))'((D))");
		assertEquals(3, atom.getNumberOfCaptureGroups());
	}
}
