package com.jloysch;

import java.util.Scanner;

/*
 * Name: Joshua Loysch
 * NetID: jloysch
 * Assignment Number: Homework 3 problem 2
 * Lab Section Day/Time: MW, 2:00-3:15PM
 * 
 * I did not collaborate with anyone on this assignment.
 * 
 */

public class Homework_3_2 {
	
	public static void main(String args[]) {
		
		Scanner s = new Scanner(System.in);
		boolean err = false;
		String str = "";
		int n = 0;
		
		while (!err) {
			
			try {
				System.out.print("Please enter a number, and I'll give you the first ten multiples.\n>> ");
				n = s.nextInt();
				err = !err;
			} catch (Exception e) {
				System.out.println("I didn't recognize that number, please try again.\n\n");
				s.nextLine();
			}
		}
		
		for (int i = 1; i <= 10; i++) {
			str+="" + i + "*" + n + " = " + (i*n) + "\n";
		}
		
		System.out.println(str);
		s.close();
		
	}


}
