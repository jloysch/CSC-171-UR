package com.jloysch;

import java.util.Scanner;

/*
 * Write a program that reads an integer from the user and then prints a “times table”
for the numbers from 1 to the given integer (inclusive). That is, for input n, you would
print a table of n rows (lines) each with n columns, where the cell at row i and column j
contains the value i×j. You do need separate rows, but don’t worry about the columns
lining up nicely.
 */
public class Homework_4_2 {
	
	public static void main(String args[]) {
	   Scanner s = new Scanner(System.in);
	   System.out.print("-- [Multiplicative Table] --\n"
						+ "I'll read a number from you, and I'll print all numbers\n"
						+ "in the form of a multiplication table from 1 to your given number (inclusive)"
						+ "\n\nPlease give me your first number >> ");
	   int n = s.nextInt();
	   String beautifulStr = "";

	   try {
		  for (int r = 1; r <=n; r++) {
		     for (int c = 1; c <= n; c++) {
				beautifulStr += (r*c)+"\t";
			 }
		     beautifulStr += "\n";
		  }
		  System.out.println(beautifulStr); 
	  } 
	  catch (Exception e) {
	     System.out.println("Unrecognized input, please try entering your integer again.");
		 s.nextLine();
	  }
	  s.close();
	}
}
