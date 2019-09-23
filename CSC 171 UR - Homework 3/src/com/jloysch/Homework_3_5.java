package com.jloysch;

import java.util.Scanner;

/*
 * Name: Joshua Loysch
 * NetID: jloysch
 * Assignment Number: Homework 3 problem 5
 * Lab Section Day/Time: MW, 2:00-3:15PM
 * 
 * I did not collaborate with anyone on this assignment.
 * 
 */

public class Homework_3_5 {
	
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int a, b = 0;
		
		System.out.print("Please enter some numbers for me to sum! (0 to exit).\n>> ");
		a = s.nextInt();
		b+=a;
		
		while (!(a==0)) {
			System.out.print(">> ");
			a = s.nextInt();
			b+=a;
		}
		
		System.out.println("SUM >> " + b);
		
		s.close();
		
	}

}
