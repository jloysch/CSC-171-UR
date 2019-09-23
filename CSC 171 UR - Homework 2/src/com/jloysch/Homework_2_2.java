package com.jloysch;

import java.util.Scanner;

/*
 * Name: Joshua Loysch
 * NetID: jloysch
 * Assignment Number: Homework 2 Problem 2
 * Lab Section Day/Time: MW, 2:00-3:15PM
 * 
 * I did not collaborate with anyone on this assignment.
 * 
 */


public class Homework_2_2 {
	
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a number and I'll check if it's a multiple of 5! >> ");
		
		if (s.nextInt()%5==0) {
			System.out.println("Your number IS a multiple of five!");
		} else {
			System.out.println("Your number is NOT a multiple of five!");
		}
		s.close();
	}

}
