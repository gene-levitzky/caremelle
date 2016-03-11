package aremelle;

import java.util.Scanner;

public class Resources {
	
	private static final Scanner in = new Scanner(System.in);

	public static Scanner getIn() {
		return in;
	}
	
	public void shutdown() {
		in.close();
	}

}
