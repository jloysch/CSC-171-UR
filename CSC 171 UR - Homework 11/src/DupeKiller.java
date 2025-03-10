import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * 2. Write a program that reads in a series of names and eliminates duplicates by storing them in a Set of Strings. 
   Then ask the user for a name and report whether it was one of the names that was read in.
 */

public class DupeKiller {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Please enter a series of names seperated by spaces and I'll eliminate the duplicates.\n>> ");
		
		/*
		 * Will eliminate duplicates.
		 */
		String a = sc.nextLine();
		String[] d = a.split(" "); //Didn't want to have to store it, but needed it for clarity and showing the duplicate removal.
		
		Set<String> s = new HashSet<String>(Arrays.asList(d));
		
		System.out.println("\n[*] Given set [" + a + "] is now >>\n\t" + s);
		System.out.print("\nPlease enter a string and I'll check if it's in your given series.\n>> ");
		String t = sc.next();
		
		System.out.println((s.contains(t) ? ("\n'" + t + "' is contained in the set.\n\t(is one of the names read in)") : ("\n'" + t + "' is not contained in the set.\n\t(is NOT one of the names read in)")));
		
		sc.close();
	}

}
