import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("n^13 mod " + (43*59));
		System.out.print("n >> ");
		
		System.out.println(( Math.pow(s.nextLong(),13)) % (43*59.));
	}

}
