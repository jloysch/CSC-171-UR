/*
 * Name: Joshua Loysch
 * NetID: jloysch
 * Assignment Number: Homework 1 Problem 3
 * Lab Section Day/Time: MW, 2:00-3:15PM
 * 
 * I did not collaborate with anyone on this assignment.
 * 
 */

package com.jloysch;

import java.util.Scanner;

public class Homework_3 {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		double a,b;

		System.out.println("Please enter two decimal numbers.");
		
		a = sc.nextDouble(); 
		b = sc.nextDouble();
		
		System.out.println("Basic arithmetic operations from given input >>\nAddition:\t\t"+(a+b)+"\nSubtration:\t\t" +
													(a-b)+"\nMultiplication:\t\t"+(a*b)+"\nDivision:\t\t"+(a/b));
		sc.close();
	}

}
