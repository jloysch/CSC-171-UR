package com.jloysch;

import java.util.Scanner;

public class ProblemFive {
	
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Infinite series calculator!\nPlease enter a number n to count to.\n>> ");
		double n = s.nextDouble();
		double sum = 0;
		int denom = 1;
		
		for (int i = 0; i < n; i++) {
			sum += (double) 1 / denom;
			denom = denom * 2;
		}
		System.out.println("SUM >> " + sum);
	}

}
