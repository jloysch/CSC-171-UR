package com.jloysch;

import java.util.Scanner;

public class ProblemTwo {
	
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("Give me the speed of a moving car\n>> ");
		double a = s.nextDouble();
		
		System.out.print("\nGive me the time in seconds\n>> ");
		double b = s.nextDouble();
		
		for (double i = 0; i <= b; i+=(b/10)) {
			System.out.println("Distance traveled at time t= " + i + " is " + (a*i));
		}
		
	}

}
