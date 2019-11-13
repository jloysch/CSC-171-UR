import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FindStr {

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("Please enter a series of strings seperated by a space.\n>> ");
		List<String> l = Arrays.asList(s.nextLine().split(" "));
		
		System.out.print("\nPlease enter the target string to search for in your series\n>> ");
		String t = s.next();
		System.out.print("\nWould you like the search to be case-sensitive? [Yy/Nn]\n>> ");
		
		if (s.next().equalsIgnoreCase("Y")) {
			for (int i = 0; i < l.size(); i++) {
				if (l.get(i).equals(t)) {
					System.out.println("\n-----\nFound a match at index[" + i + "]\n['" + t + "' = '" + l.get(i) + "']\n-----");
				}
			}
		} else {
			for (int i = 0; i < l.size(); i++) {
				if (l.get(i).equalsIgnoreCase(t)) {
					System.out.println("\n-----\nFound a match at index[" + i + "]\n['" + t + "' = '" + l.get(i) + "']\n-----");
				}
			}
		}
		
		
	s.close();
	}

}
