import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static boolean listContains(List<String> l, String tg) {
		
	    for (String t : l) {

	        if (t.equals(tg)) {

	            return true;
	        }
	    }
	    
	    return false;
	}
	
	
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		
		List<String> f = new ArrayList<String>();
		
		f.add("DD");
		f.add("XX");
		
		System.out.println(listContains(f, s.next()));
	}
}
