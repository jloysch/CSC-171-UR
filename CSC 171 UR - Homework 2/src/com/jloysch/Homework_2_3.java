package com.jloysch;

import java.util.Scanner;

/*
 * Name: Joshua Loysch
 * NetID: jloysch
 * Assignment Number: Homework 2 Problem 3
 * Lab Section Day/Time: MW, 2:00-3:15PM
 * 
 * I did not collaborate with anyone on this assignment.
 * 
 */

public class Homework_2_3 {
	
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		float n;
		
		System.out.println("Enter a number and I'll tell you if it's negative, positive, or zero.");
		n = s.nextFloat();
		
		if (n == 0) {
			System.out.println("Your number is zero.");
		} else if (n < 0) {
			System.out.println("Your number is negative.");
		} else {
			System.out.println("Your number is positive.");
		}
		
		
		s.close();
		
	}

}
