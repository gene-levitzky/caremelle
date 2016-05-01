package tests2.caremelle2.resources;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import aremelle.exceptions.CannotImportFunctionException;
import caremelle2.resources.Representation;
import caremelle2.resources.RepresentationConstructor;

public class RepresentationConstructionTests {
	
	private static final RepresentationConstructor CONSTRUCTOR = new RepresentationConstructor();
	
	@Test
	public void firstTest() throws FileNotFoundException, CannotImportFunctionException, IOException {
		Representation representation = CONSTRUCTOR.build(new File("examples/Palindrome.rml"), new String[]{"otto"});
		for (String s : representation.getFunctionStore().keySet()) {
			System.out.println(s);
		}
	}

}
