package com.jloysch;

import java.util.Scanner;

public class ProblemSix {
	
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("I can give you the GCD between two numbers X and Y.");
		System.out.print("Please enter the first number\n>> ");
		int a = s.nextInt();
		System.out.print("Please enter the second number\n>> ");
		int b = s.nextInt();
		
		if ( a > b ) {
			if (a%b==0) {
				System.out.println("GCD >> " + b);
			}
		} else {
			for (int i = b; i >= 0; i--) {
				if ((a%i==0)&&(b%i==0)) {
					System.out.println("GCD >> " + i);
					break;
				}
			}
		}
	}

}
