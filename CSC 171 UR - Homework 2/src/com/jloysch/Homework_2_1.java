package com.jloysch;

import java.util.Scanner;

/*
 * Name: Joshua Loysch
 * NetID: jloysch
 * Assignment Number: Homework 2 Problem 1
 * Lab Section Day/Time: MW, 2:00-3:15PM
 * 
 * I did not collaborate with anyone on this assignment.
 * 
 */

public class Homework_2_1 {
	
	public static void main(String args[]) {
		
		Scanner s = new Scanner(System.in);
		int g, secret = 5;
		boolean a = false;
		
		while (!a) {
			System.out.println("[Type -1 to exit]\nGuess the number >> ");
			g = s.nextInt();
			
			if (g == secret) {
				a = true;
				System.out.println("You're a winner!");
			} else if (g == -1) {
				a=true;
				System.out.println("Exiting.");
			} else {
				System.out.println("Sorry, that's not correct. Try again.\n");
			}
			
		}
		s.close();
		
	}
}
