package com.jloysch;

import java.util.Scanner;

public class Q_SIX {
	
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Please enter the day, month, and year, respectively.");
		//e.g. 22, 01, 2001
		
		int d = s.nextInt(), m = s.nextInt(), y = s.nextInt();
								
		int yZ = (y - ((14-m) / 12));
		int x = (yZ + ((yZ/4) - (yZ/100) + (yZ/400)));
		int mZ = (m + (12 * ((14-m)/12)) - 2);
		
		System.out.println((d + x + ((31 * mZ)/12))%7);
		
		s.close();
	}

}
