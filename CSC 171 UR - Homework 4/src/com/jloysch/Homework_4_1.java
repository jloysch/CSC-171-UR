package com.jloysch;

import java.util.Scanner;

/*
 *  Write a program that uses a do-while loop to print the squares of numbers read from
 *	the user until they enter the number 0. Do not print the final square of 0 (hint: use a
 *	nested control structure).
 */
public class Homework_4_1 {
	public static void main(String args[]) {
	   System.out.print("-- [Square My Number] --\nEnter an integer and I'll square it!\n");
	   Scanner s = new Scanner(System.in);
	   int a;
	   
	   do {
	      System.out.print("Number >> ");
	      
		   try {
		      if (!((a = (int) Math.pow(s.nextInt(),2))==0)) {
			     System.out.println("\tSquared >> " + a);
			  } else {
			       break;
			    }
		   } 
		   catch (Exception e) {
		      System.out.println("\t>> Unrecognized input, try again. <<\n");
			  s.nextLine();
		   }
	   } while (true); //Conditional doesn't matter whether it be true, !(a==0)	
	   s.close();
	}
}