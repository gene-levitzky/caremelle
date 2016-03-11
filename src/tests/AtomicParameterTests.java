package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AtomicParameterTests {

	@Test
	public void testNumberofCaptureGroups() {
		aremelle.AtomicParameter atom = new aremelle.AtomicParameter("name", "(A)(B|(C))((D))");
		assertEquals(5, atom.getNumberOfCaptureGroups());
	}
	
	@Test
	public void testNumberofCaptureGroupsWithQuotes() {
		aremelle.AtomicParameter atom = new aremelle.AtomicParameter("name", "(A)'(B|(C))'((D))");
		assertEquals(3, atom.getNumberOfCaptureGroups());
	}
}
