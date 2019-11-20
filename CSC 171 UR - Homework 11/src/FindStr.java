import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FindStr {

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("Please enter a series of strings seperated by a space.\n>> ");
		
		/*
		 * Doing this allows only unique values in the List.
		 */
		
		String d = s.nextLine();
		String[] e = d.split(" ");
		
		List<String> l = Arrays.asList(e).stream().distinct().collect(Collectors.toList());
		
		System.out.println("\n[*] Given set [" + d + "] stored as >>\n\t" + l);
		
		System.out.print("\nPlease enter the target string to search for in your series\n>> ");
		String t = s.next();
		
		
		
		System.out.print("\nWould you like the search to be case-sensitive? [Yy/Nn]\n>> ");
		
		
		
		/*
		 * Case sensitive check.
		 */
		
		if (s.next().equalsIgnoreCase("Y")) {
			for (int i = 0; i < l.size(); i++) {
				if (l.get(i).equals(t)) {
					System.out.println("\n-----\nFound a match at index [i=" + i + "]\n['" + t + "' = '" + l.get(i) + "']\n-----");
					break;
					
					/*
					 * This may appear as flawed logic, but if it's case-sensitive and the set doesn't contain duplicates then there
					 * must be at most one match.
					 */
				}
				
				if (i == l.size()-1) {
					System.out.println("No matches found.");
				}
			}
		} else {
			boolean x = false;
			
			for (int i = 0; i < l.size(); i++) {
				if (l.get(i).equalsIgnoreCase(t)) {
					System.out.println("\n-----\nFound a match at index [i=" + i + "]\n['" + t + "' = '" + l.get(i) + "']\n-----");
					x=true;
				}
				
				if (i == l.size()-1 && !x) {
					System.out.println("No matches found.");
				}
			}
		}
		
		
	s.close();
	}

}
