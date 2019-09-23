package com.jloysch;

import java.util.Scanner;

/*
 * Name: Joshua Loysch
 * NetID: jloysch
 * Assignment Number: Homework 3 problem 6
 * Lab Section Day/Time: MW, 2:00-3:15PM
 * 
 * I did not collaborate with anyone on this assignment.
 * 
 */

/*
 * Write a program that reads words from the user until they enter the word “stop”, at
which point it prints out all the words they entered on one line separated by spaces.
Use String.equals to test whether two Strings are the same.
 */

public class Homework_3_6 {
	
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int a = 0;
		String str = "";
		
		System.out.print("Keep entering words and I'll read them until you say 'stop'.\n[Word " + ++a + "] >> ");
		String tmp = s.next();
		
		while (!(tmp.equalsIgnoreCase("stop"))) {
			str+=tmp + " ";
			System.out.print("[Word " + ++a + "] >> ");
			tmp = s.next();
		}
		
		System.out.print(str);
		s.close();
	}
	
}
