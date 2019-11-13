import java.util.HashMap;
import java.util.Scanner;

/*
 * 3. Write a simple phonebook program that reads in a series of name-number pairs from the user 
 * (that is, name and number on one line separated by whitespace) 
   and stores them in a Map from Strings to Integers. Then ask the user for a name and return the matching number,
    or tell the user that the name wasn’t found.
 
 */
public class Phonebook {
	
	public static boolean VERBOSE = true;
	
	public static long assertNumber(String x) {
		
		String y = "";
		
		for (int i = 0; i < x.length(); i++) {
			if (((x.charAt(i) == ('(') || (x.charAt(i) == (')') || x.charAt(i)==('-'))))) {
					
			} else {
				y+=x.charAt(i);
			}
		}
		
		System.out.println("\n\t[*] Number assertion result >> " + y);
		try {
			return Long.parseLong(y);
		} catch (Exception e) {
			return -1L;
		}
	}

	
	public static void main(String args[]) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("[Please enter a series of name number pairs]\n\t[*] Valid entry formats: (FIRSTNAME LASTNAME 0000000000)"
				+ "\n\t\t(FIRSTNAME 0000000000)" 
				+ "\n\t\t(NICKNAME  0000000000) "
				+ "\n\t\t(ANYNAME   0000000000)"
				+ "\n\t[*] Phone numbers can also be recognized as:\n\t\t'000-000-0000'\n\t\t'(000)-000-0000'"
				+ "\n\nPlease enter your series\n>> ");
		
		
		String[] RAW = s.nextLine().split(" ");
		
		int[] BREAKS = new int[RAW.length];
		
		
		String FINAL_NUMBERS = "";
				
		for (int i = 0; i < RAW.length; i++) {
			System.out.println("\n");
			try {
				Long.parseLong(RAW[i]);
				if (VERBOSE) { System.out.println("\nCaught number " + RAW[i]);}
				FINAL_NUMBERS += RAW[i] + "\n";
				BREAKS[i]=1;
			} catch (Exception e) {
				if (VERBOSE) { System.out.println("Number catch failed, double checking >> " + RAW[i]); }
				
				long a = assertNumber(RAW[i]);
				
				if((a==-1)) {
					if (VERBOSE) { System.out.println(RAW[i] + " is truly a string, moving on."); }
				} else {
					if (VERBOSE) { System.out.println("\n\tSecondary check passed, got number from " + RAW[i] + "\n\t\t>> " + a);
					FINAL_NUMBERS += a + "\n";
					BREAKS[i]=1;
				}
			}
		}
		
		}
		
		//ADAM CENA 5708086767 HAILIE GG (570)-280-5960 DONNY YEN 576-435-5454
		
		//RECOMBINATE STAGE
		
		String FINAL_NAMES = "";
		
		for (int i = 0; i < BREAKS.length; i++) {
			System.out.println(BREAKS[i]);
		}
		
		for (int i = 0; i < RAW.length; i++) {
			if (BREAKS[i]==0) {
				FINAL_NAMES+=RAW[i] + " ";
			} else {
				FINAL_NAMES = (FINAL_NAMES.substring(0, FINAL_NAMES.length() - 1));
				FINAL_NAMES+="\n";
			}
		}
		
		System.out.println("List of names >> ");
		
		System.out.println(FINAL_NAMES);
		
		System.out.println(FINAL_NUMBERS);
		
		String[] FINAL_NAMES_ARR = FINAL_NAMES.split("\n");
		
		String[] FINAL_NUMBERS_TMP_ARR = FINAL_NUMBERS.split("\n");
		
		long[] FINAL_NUMBERS_ARR = new long[FINAL_NUMBERS_TMP_ARR.length];
		
		for (int i = 0; i < FINAL_NUMBERS_TMP_ARR.length; i++) {
			FINAL_NUMBERS_ARR[i] = Long.parseLong(FINAL_NUMBERS_TMP_ARR[i]);
		}
		
		HashMap<String,Long> DB = new HashMap();
		
		if (FINAL_NUMBERS_ARR.length == FINAL_NAMES_ARR.length) {
			for (int i = 0; i < FINAL_NUMBERS_ARR.length; i++) {
				DB.put(FINAL_NAMES_ARR[i].toUpperCase(), FINAL_NUMBERS_ARR[i]);
			}
		} else {
			System.out.println("You have some kind of error in input, didn't match names to numbers.");
		}
		
		System.out.println("Results from database >> \n\n");
		
		
		System.out.println(DB.toString());
		
		System.out.print("\n[*] Map created successfuly. Please enter a target's name to search for in the database\n>> ");
		
		
		
		while (true) {
			String target = s.nextLine();
			
			try {
				if (Integer.parseInt(target)==-1) {
					break;
				}
			} catch (Exception e) {
				//dn
			}
			
			if (DB.containsKey(target.toUpperCase())) {
				System.out.println("\nFound target '" + target.toUpperCase() + "' with number >> '" + DB.get(target.toUpperCase())+ "'");
			} else {
				System.out.println("\nNo targets found for query '" + target + "'");
			}
			System.out.print("\nPlease enter another query, or enter -1 to quit.\n>> ");
		}
		
		s.close();
	}
}
