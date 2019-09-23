package com.jloysch;

import java.util.Scanner;

/*
 * 4. The alternating harmonic series is the following:
· · ·
Write a program that asks the user for a number n and then calculates and prints the
sum of the first n terms of the sequence. Try your program with n equal to 10, 100, and
1000. Compare to the value of Math.log(2). Hints: You’ll need to use a double for
the sum, and be sure you don’t use integer division for the individual terms. You’ll also
need to switch between addition and subtraction. I can think of two ways (one using a
variable that changes value and one using a conditional).
 */

public class Homework_4_4 {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		double sum = 0;
		
		System.out.print("-- [Harmonic Series] --\nPlease enter a number (n) to calculate to. Enter -1 for automated mode (You will need to manually quit the program)\nChoice >> ");

		int n = s.nextInt();
		double a = Math.log(2);
		
		if (n==-1) { //Just thought I'd throw in an automated mode.
			int i = 1;
			
			while (true) {
				if (i%2==0) {
					sum-= (1/ (double) i);
					i++;
				} else {
					sum+= (1/ (double) i);
					i++;
				}
				System.out.print("\r" + "LOG COMPARISON >> (n = " + i + ") | MATH_LOG(2) >> " + a + " | Calculated output >> " + sum + " | DIFFERENCE >> " + Math.abs(a-sum));
			} //can't seem to dynamically update the text.
		} else {
			for (int i = 1; i <= n; i++) {
				if (i%2==0) {
					sum-= (1/ (double) i);
				} else {
					sum+= (1/ (double) i);
				}
			}
			System.out.println("\nLOG COMPARISON >> (n = " + n + ")\n\tMATH_LOG(2)\t\t>> " + a + "\n\tCalculated output\t>> " + sum + "\n\tDIFFERENCE\t\t>> " + Math.abs(a-sum));
		}
		
	}

}
