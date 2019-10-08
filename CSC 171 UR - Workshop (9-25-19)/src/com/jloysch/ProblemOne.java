package com.jloysch;

import java.util.Scanner;

public class ProblemOne {
	
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter any integer to count to from 1, and I'll give you the sum that are divisible by three or five. (inclusive)\n>> ");
	
		int a = s.nextInt();
		String str = "1 ";
		int sum = 0;
		
		for (int i = 1; i <= a; i++) {
			if (!((i%3==0)&&(i%5==0))) {
				if ((i%3==0)) {
					str+=" " + i + " ";
					sum+=i;
				} else if (i%5==0) {
					str+=" " + i + " ";
					sum+=i;
				} else {
					
				}
			}
		}
		System.out.println(str);
		System.out.println("SUM >> " + sum);
	}

}
