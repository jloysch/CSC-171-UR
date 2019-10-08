/*
 * Name: Joshua Loysch
 * NetID: jloysch
 * Assignment Number: Homework 7
 * Lab Section Day/Time: MW, 2:00-3:15PM
 * 
 * I did not collaborate with anyone on this assignment.
 * 
 */

import java.util.Scanner;

public class Main {
	
	public static int[] incrementArrVals(int[] a, int b) {
		int[] c = cloneArr(a);
		
		for (int i = 0; i < a.length; i++) {
			c[i]+=b;
		}
		return c;
	}
	
	public static int[] cloneArr(int[] a) {
		int[] b = new int[a.length];
		
		for (int i = 0; i < a.length; i++) {
			b[i]=a[i];
		}
		return b;
	}
	
	public static int[] addIntArr(int[] a, int[] b) {
		if (!(a.length==b.length)) {
			return null;
		} else {
			for (int i = 0; i < a.length; i++) {
				a[i]+=b[i];
			}
			return a;
		}
	}
	
	public static int getArrMinimum(int[] d) {
		int tmp = Integer.MAX_VALUE;
		
		for (int i = 0; i < d.length; i++) {
			if (d[i] < tmp) {
				tmp = d[i];
			}
		}
		
		return tmp;
	}
	public static double getArrMiddleValue(int[] d) { //Simply calculate the median based on either the length being odd, or even.
		if (d.length%2==0) {
			return ((d[(d.length-1)/2] + d[(d.length/2)])/ (double) 2);
		} else {
			return d[d.length/2];
		}
	}
	
	public static void printArray(int[] d) {
		for (int i = 0; i < d.length; i++) {
			if (i==0) {
				System.out.print("[");
			}
			if (i < (d.length-1)) {
				System.out.print(d[i] + " ");
			} else {
				System.out.print(d[i] + "]");
			}
		}
	}
	
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("[Homework 7 Arrays]\nPlease give me an integer for the length of the array >> ");
		int[] arr = new int[s.nextInt()];
		
		for (int i = 0; i < arr.length; i++) {
			if (i==0) {
				System.out.print("\nPlease enter the first number for the array >> ");
			} else if (i == (arr.length-1)) {
				System.out.print("\nPlease enter the last number for the array >> ");
			} else {
				System.out.print("\nPlease enter the next number for the array >> ");
			}
			arr[i] = s.nextInt();
		}
		
		int[] arr2 = cloneArr(arr);
		
		System.out.print("\n[*] Printed Array >> ");
		printArray(arr);
	
		if (getArrMiddleValue(arr)%1==0) {
			System.out.println("\n\tMedian\t>> " + (int) getArrMiddleValue(arr));
		} else {
			System.out.println("\n\tMedian\t>> " + getArrMiddleValue(arr));
		}
		
		System.out.println("\tMinimum\t>> " + getArrMinimum(arr));
		
		System.out.print("\n[Array Shallow Copy]\n\tOrignal Array\t>> "); 
		printArray(arr);
		System.out.print("\n\tShallow Clone\t>> ");
		printArray(arr2);
		
		System.out.print("\n\n[Array Addition]\n");
		
		System.out.print("\t[*] Please enter an integer to increment the array by >> ");
		int t = s.nextInt(); //I don't usually bother creating variables when I don't need them, but for formatting purposes I needed this.
		System.out.print("\t\tArray after incremenent\t>> ");
		printArray(incrementArrVals(arr, t));
		
		System.out.print("\n\n\tOriginal Array\t>> ");
		printArray(arr);
		System.out.print("\n\tShallow Clone\t>> ");
		printArray(arr2);
		
		System.out.print("\n\tAddition\t>> ");
		
		printArray(arr);
		System.out.print(" + ");
		printArray(arr2);
		System.out.print(" = ");
		
		printArray(addIntArr(arr,arr2));

		System.out.print("\n\n\t*Original Array\t>> ");
		printArray(arr);
		System.out.print("\n\tShallow Clone\t>> ");
		printArray(arr2);
		
		System.out.print("\n\n\t*The original array has been preserved while\n\tthe shallow copy has been preserved.");
		
		s.close();
	}
}
