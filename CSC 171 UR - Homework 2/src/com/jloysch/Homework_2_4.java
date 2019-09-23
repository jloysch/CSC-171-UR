package com.jloysch;

import java.util.Scanner;

/*
 * Name: Joshua Loysch
 * NetID: jloysch
 * Assignment Number: Homework 2 Problem 4
 * Lab Section Day/Time: MW, 2:00-3:15PM
 * 
 * I did not collaborate with anyone on this assignment.
 * 
 */

public class Homework_2_4 {
	
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int n;
		
		System.out.print("How old are you?\n>> ");
		n = s.nextInt();
		
		if (n >= 30) {
			System.out.println("You must be wise.");
		} else if (n >= 20) {
			System.out.println("You're getting there...");
		} else if ( n >= 13 ) {
			System.out.println("You're a teenager!");
		} else {
			System.out.println("You're just a kid!");
		}
		
		s.close();
	}

}
