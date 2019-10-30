/**
 * @author Joshua John Reuben Loysch
 * @Version 1.0.1r0
 * Intellectual property of Joshua John Reuben Loysch, all rights reserved.
 */

//This was made because the project calls for two main methods to operate the game. This class will handle starting the game from a string.
import java.util.Scanner;

public class ProjectTwoDriverInputTwo {
	
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		Poker poker = new Poker();
		
		System.out.print("[Poker hand comparison]\n(For this release only two players are supported at once.)\n\n[*] For your input,"
				+ " each string will be of the form RSRSRSRSRS, where:\n"
				+ "\tR can be any one of the set (2,3,4,5,6,7,8,9,T,t,J,j,Q,q,K,k,A,a), and"
				+ "\n\tS can be any one of the set (C,c,H,h,S,s,D,d)\n");

		System.out.print("\nPlease enter the first players hand\n>> ");
		String str = s.next();
		System.out.print("\nPlease enter the second players hand\n>> ");
		poker.startFromStr(str, s.next());
		
		s.close();
		
	}

}
