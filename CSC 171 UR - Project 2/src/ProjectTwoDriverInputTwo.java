import java.util.Scanner;

/**
 * @author Joshua John Reuben Loysch
 * @Version 1.0.1r0
 * Intellectual property of Joshua John Reuben Loysch, all rights reserved.
 */

//This was made because the project calls for two main methods to operate the game. This class will handle starting the game from a string.

public class ProjectTwoDriverInputTwo {
	
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		Poker poker = new Poker();
		
		System.out.print("Please enter how many players you'd like to have play poker.\n(For this release only two are supported.)\n>> ");
		poker.setPlayers(s.nextInt()); //Already in default constructor, but proof-of-concept. (n>2 players not supported.)
		System.out.print("\nPlease enter the first players hand\n>> ");
		String str = s.next();
		System.out.print("\nPlease enter the second players hand\n>> ");
		poker.startFromStr(str, s.next());
		
		s.close();
		
	}

}
