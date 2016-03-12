package caremelle;

import java.io.FileReader;
import java.io.IOException;

import exceptions.NoMatchingSignatureException;
import exceptions.NotANumberException;
import exceptions.UndeclaredVariableException;
import exceptions.UndefinedVariableException;

public class Caremelle {
	
	public static void main(String [] args) throws 
			UndefinedVariableException, 
			NoMatchingSignatureException, 
			NotANumberException, 
			UndeclaredVariableException {
		
		if (args.length == 0) {
			System.out.println("To run an Aremelle program, supply the path to "
					+ "the source code as the first argument followed by the "
					+ "arguments to the Aremelle program. Exiting program.");
			return;
		}
		
		String[] aremelleArgs = new String[args.length - 1];
		for (int i = 1; i < args.length; i++) {
			aremelleArgs[i - 1] = args[i];
		}
		
		AremelleProgramBuilder builder = new AremelleProgramBuilder();
		AremelleProgramExecutor executor = new AremelleProgramExecutor();
		
		try {
			String result = 
					executor.evaluateProgram(builder.build(new FileReader(args[0]), aremelleArgs));
			System.out.println(result);
			
		} catch (IOException e) {
			System.out.println("File " + args[0] + " not found. Exiting program.");
		}
	}

}
