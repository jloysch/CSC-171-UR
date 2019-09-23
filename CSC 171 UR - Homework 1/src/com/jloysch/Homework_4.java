/*
 * Name: Joshua Loysch
 * NetID: jloysch
 * Assignment Number: Homework 1 Problem 4
 * Lab Section Day/Time: MW, 2:00-3:15PM
 * 
 * I did not collaborate with anyone on this assignment.
 * 
 */

package com.jloysch;

import java.util.Scanner;

public class Homework_4 {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		float degF;
		
		System.out.print("|Fahrenheit > Kelvin Converter|\nPlease enter a number in degrees farenheit: ");
		degF = sc.nextFloat();
		System.out.println(degF + " degrees fahrenheit is " + String.format("%.3f", (( (float) ((5*(degF-32))/9)) + 273.15))
								+ " degrees Kelvin.");
		sc.close();
	}

}
