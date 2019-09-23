/*
 * Name: Joshua Loysch
 * NetID: jloysch
 * Assignment Number: Homework 1 Problem 5
 * Lab Section Day/Time: MW, 2:00-3:15PM
 * 
 * I did not collaborate with anyone on this assignment.
 * 
 */

package com.jloysch;

import java.util.Scanner;

public class Homework_5 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int c = 299792458; //Required variable for speed of light.
		
		System.out.print("|Grams -> Energy Convertor (E = mc^2)|\n\tPlease the mass in grams you're solving for: ");
		System.out.println("\t>> Energy = " + String.format(("%,d"),( (long) (sc.nextDouble()*Math.pow(c, 2))))+" Joules. <<");
		sc.close();
	}
}
