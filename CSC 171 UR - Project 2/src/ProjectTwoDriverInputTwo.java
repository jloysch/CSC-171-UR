/**
 * @author Joshua John Reuben Loysch
 * @Version 1.0.1r0
 * Intellectual property of Joshua John Reuben Loysch, all rights reserved.
 */

//This was made because the project calls for two main methods to operate the game. This class will handle starting the game from a string.
import java.util.Scanner;

public class ProjectTwoDriverInputTwo {
	
	public static String randSuit() {

		int a = (int) (Math.random() * 10) + 3;

		if (a%2==0) {

			return "h";

		} else {

			return "s";

	}
}
	
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		Poker poker = new Poker();
		
		System.out.print("[Poker hand comparison]\n(For this release only two players are supported at once.)\n\n[*] For your input,"
				+ " each string will be of the form RSRSRSRSRS, where:\n"
				+ "\tR can be any one of the set (2,3,4,5,6,7,8,9,T,t,J,j,Q,q,K,k,A,a), and"
				+ "\n\tS can be any one of the set (C,c,H,h,S,s,D,d)\n");
		/*
		System.out.print("\nPlease enter the first players hand\n>> ");
		String str = s.next();
		System.out.print("\nPlease enter the second players hand\n>> ");
		poker.startFromStr(str, s.next());
		*/
		
		for (int i = 0; i < 9; i++) {
	        String a = "";
		int[] tmpArr  = new int[]{(i+1),(i+2),(i+3),(i+4),(i+5)};
			for (int j = 0; j < tmpArr.length; j++) {
				if (tmpArr[j] == 10) {
					a+="Td";
				} else if (tmpArr[j] == 11) {
					a+="Js";
				} else if (tmpArr[j] == 12) {
					a+="Qc";
				} else if (tmpArr[j] == 13) {
					a+="Kh";
				} else if (tmpArr[j] == 1){
					a+="Ad";
				} else {

					a+=String.valueOf(tmpArr[j]) + randSuit();
				}
			}
				System.out.println(a);
				poker.startFromStr(a, a);
			}


		poker.startFromStr("9hTdJsQcKh", "ThJdQsKcAh");
	
		s.close();
		
	}

}
