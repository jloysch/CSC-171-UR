import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter a year to check for the programmer convention meeting.");
		
		int a = s.nextInt();
		
		for (int i = 1800; i <= 2100; i++) {

			 if (i%3==0) {

			    if (!(i%30==0)) {
			      System.out.println("The year '" + i + "' is a meeting year.");   

			    }  else if (i%300==0) {
			      System.out.println("The year '" + i + "' is a meeting year.");
			    } else {
			    	System.out.println("The year '" + i + "' is NOT a meeting year.");
			    }
			 }
		}
	}
}
