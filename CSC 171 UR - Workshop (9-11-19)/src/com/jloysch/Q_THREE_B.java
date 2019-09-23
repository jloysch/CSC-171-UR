package com.jloysch;

import java.util.Scanner;

public class Q_THREE_B {
	
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.println("Give me a number >> ");
		int a = s.nextInt();
		int b = 2*a;
		
		System.out.println("OG Number >> " + a + "\nNew number >> " + b);
		s.close();
		
	}

}
