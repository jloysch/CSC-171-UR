package com.jloysch;

import java.util.Scanner;

public class ProblemFour {
	
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("Ellipse calculator!\nGive me the lower bound (a) of the ellipse\n>> ");
		double aLow = s.nextDouble();
		System.out.println("\nGive me the upper bound of (a)\n>> ");
		double aHigh = s.nextDouble();
		
		System.out.print("\nGive me the lower bound (b) of the ellipse\n>> ");
		double bLow = s.nextDouble();
		System.out.print("\nGive me the upper bound (b) of the ellipse\n>> ");
		double bHigh = s.nextDouble();
		
		for (double i = aLow; i <= aHigh; i++) {
			System.out.print("At a = " + i + "\n");
			for (double j = bLow; j <= bHigh; j++) {
				System.out.print("\tB = " + j + " & area at (PI*" + i + "*" + j + ") = " + (Math.PI*i*j) + "\n");
			}
			System.out.print("\n");
		}
	}

}
