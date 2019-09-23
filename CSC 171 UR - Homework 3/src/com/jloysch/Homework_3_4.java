package com.jloysch;

import java.util.Scanner;

/*
 * Name: Joshua Loysch
 * NetID: jloysch
 * Assignment Number: Homework 3 problem 4
 * Lab Section Day/Time: MW, 2:00-3:15PM
 * 
 * I did not collaborate with anyone on this assignment.
 * 
 */

public class Homework_3_4 {
	
	public static void main(String args[]) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("Please enter a number to count down from >> ");

		for (int i = s.nextInt(); i >= 0; i--) {
			System.out.println(i);
		}
		
		s.close();
	}

}
