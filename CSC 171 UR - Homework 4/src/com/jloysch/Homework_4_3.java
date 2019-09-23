package com.jloysch;

import java.util.Scanner;

/*
 *  Write a program that does the following repeatedly:
 	Asks the user for three numbers.
 	If all three numbers are 0, the program should finish.
 	Otherwise, print the numbers from the first number to the second incrementing by
	the third.
 	Repeat
 */
public class Homework_4_3 {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		String beautifulStr = "";
		boolean run = true;
		int a, b, c, runs, numLen;
		System.out.print("-- [Number Counter] --\n"
				+ "Please enter three numbers (e.g. (A,B,C)) and I'll count from A to B in increments of C.\n" 
				+ "You may keep going until you enter the numbers 0 0 0\n" 
				+ "Please enter your numbers >> ");
		runs = 1; //For formatting purposes.
		
		
		while (run) {
			
		   try {
			 
		      a = s.nextInt();
		      b = s.nextInt();
		      c = s.nextInt();
		      
		      if ((a==0)&&(b==0)&&(c==0)) {
		         break;
		      } 
		      
		      if (!(a==b)) {
		         if ((Math.abs((a-b)) < c)) {
				    System.out.println("Given increment was bigger than difference between A and B. Try again.\n>> ");
				 } 
		         else {
	    	        beautifulStr += "\n|";
		
	                for (int i = a; i <= b; i+=c) {
		               if (i == a) {
			              beautifulStr += i + "|";
			           } 
		               else if (i == b) {
			              beautifulStr += "\t|" + i + "|";
			            } 
		               else {
			              beautifulStr += "\t" + i;
			           }
		            }
		            System.out.print("\n>> Number Counter Results For Run " + runs++ + " - >" + beautifulStr + "\n\nNEXT INPUT >> ");
		            beautifulStr="";
	            }
		     }
		     else {
		        System.out.print("Sorry, you're counting from the same number to the same number. Please try again.\n>> ");  
		     }
		  }
	      catch (Exception e) {
		     System.out.print("Unrecognized input, try entering your three numbers again.\n>> ");
		     s.nextLine();
		     beautifulStr="";
	      }
	   }
   s.close();
   }
}
