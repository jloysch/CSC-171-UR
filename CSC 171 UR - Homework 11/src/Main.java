import java.util.Scanner;

public class Main {
	
	/*
	 * The goal of this assignment is to give you experience with Java Collections. 
	 * These are very versatile classes that you will find in almost any non-trivial application. 
	 * All modern programming languages have something equivalent, 
	 * so knowing how to use collections effectively will help you no matter what kind of programming you’re doing. 
	 * 
	 * These questions only scratch the surface of what you can do with collections. Look at the javadoc and the Java tutorial for more. 
	 * You should turn in three separate Java files – one per question.
	 * 
Questions
1. Write a program that reads a series of strings from the user and stores them in a List of Strings. 
   Then read another string from the user, and iterate over the elements of the List and report whether the target string is equal (as in equals) to any element of the list.
   That is, report whether the list contains the final string.
   
   
2. Write a program that reads in a series of names and eliminates duplicates by storing them in a Set of Strings. 
   Then ask the user for a name and report whether it was one of the names that was read in.
   
3. Write a simple phonebook program that reads in a series of name-number pairs from the user (that is, name and number on one line separated by whitespace) 
   and stores them in a Map from Strings to Integers. Then ask the user for a name and return the matching number, or tell the user that the name wasn’t found.

	 */
	

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("Please enter a series of strings seperated by a space.\n>> ");
		String[] l = s.nextLine().split(" ");
		System.out.print("\nPlease enter the target string to search for in your series\n>> ");
		String t = s.next();
		System.out.print("\nWould you like the search to be case-sensitive? [Yy/Nn]\n>> ");
		
		if (s.next().equalsIgnoreCase("Y")) {
			for (int i = 0; i < l.length; i++) {
				if (l[i].equals(t)) {
					System.out.println("\n-----\nFound a match at index[" + i + "]\n['" + t + "' = '" + l[i] + "']\n-----");
				}
			}
		} else {
			for (int i = 0; i < l.length; i++) {
				if (l[i].equalsIgnoreCase(t)) {
					System.out.println("\n-----\nFound a match at index[" + i + "]\n['" + t + "' = '" + l[i] + "']\n-----");
				}
			}
		}
		
		
	s.close();
	}
}
