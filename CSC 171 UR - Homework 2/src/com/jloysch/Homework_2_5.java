package com.jloysch;

import java.util.Scanner;

/*
 * Name: Joshua Loysch
 * NetID: jloysch
 * Assignment Number: Homework 2 Problem 5
 * Lab Section Day/Time: MW, 2:00-3:15PM
 * 
 * I did not collaborate with anyone on this assignment.
 * 
 */

public class Homework_2_5 {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int c;
		
		System.out.print("What would you like to discuss?\n[1] Sports\n[2] Food\n>> ");
		c = s.nextInt();
		
		if (c==1) {
			System.out.print("\nDo you play ice hockey? [1 Yes / 0 No] >> ");
			if (s.nextInt() == 1) {
				System.out.println("Awesome!");
			} else {
				System.out.println("You should try it some day.");
			}
		} else if (c==2) {
			System.out.print("\nHow many times did you eat pizza last week?\n>> ");
			if (s.nextInt() > 5) {
				System.out.println("You need to eat better, friend.");
			} else {
				System.out.println("OK.");
			}
		} else {
			System.out.print("Well gee.. I'm not one with that subject.");
		}
		s.close();
	}
}
