package com.jloysch;

import java.util.Scanner;

public class Q_THREE_A {
	
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a number: ");
		System.out.println("New number: " + (s.nextInt()+1));
		
		s.close();
	}

}
