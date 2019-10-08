package com.jloysch;

import java.util.Scanner;

public class ProblemThree {
	
	public static void main (String args[]) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("Give me an amount of money!\n>> ");
		double money = s.nextDouble();
		System.out.print("\nGive me a number of years!\n>> ");
		double years = s.nextDouble();
		System.out.println("\nHow about an interest rate?\n>> ");
		double interest = s.nextDouble();
		
		for (int i = 1; i <= years; i++) {
			money+=money*(interest/100);
			System.out.println("Amount after year " + i + " = " + money);
		}
		
	}

}
