/*
 * Name: Joshua Loysch
 * NetID: jloysch
 * Assignment Number: Project Two
 * Lab Section Day/Time: MW, 2:00-3:15PM
 * 
 * I did not collaborate with anyone on this assignment.
 */

/**
 * @author Joshua John Reuben Loysch
 * @Version 1.4.2r0
 * Intellectual property of Joshua John Reuben Loysch, all rights reserved.
 */

import java.util.Scanner;

public class ProjectTwoDriver {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		Poker poker = new Poker();
		
		poker.getPlayer(0).setName("Daniel");
		
		
		
		//Problem 1 solution demonstrated:
		DeckOfCards d = new DeckOfCards();
		System.out.println("Original -->\n\n" + d);
		d.shuffle();
		System.out.println("\nShuffled -->\n\n" + d);
		
		//Problem 2 solution demonstrated:
		Player[] players = new Player[] {new Player("Daniel"), new Player("Stanley")};
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 5; j++) {
				players[i].addToHand(d.dealCard(true));
			}
		}
		
		System.out.println("Player " + players[0].getName() + "'s hand -->\n" + players[0].getHand());
		System.out.println("Player " + players[1].getName() + "'s hand -->\n" + players[1].getHand());
		
		System.out.println("Cards remaining in deck (" + d.cardsRemaining() + ") -->\n\n" + d);
		
		//Problem 3 solution demonstrated:
		
		/*
		 * Hands will be classified in the 'Poker' class, as it handles aspects of the game. To demonstrate this I'll add the players to the game from the last solution demonstration.
		 */
		
		poker.swapPlayer(0, players[0]);
		poker.swapPlayer(1, players[1]);
		
		poker.startSingleRound(); //Will do game compliance and run a single round of poker evaluating the hands that are pre-set. 'Poker' creates it's own deck, game compliance makes sure there are no dupes.
		
		//Problem 4 solution demonstrated:
		/*
		 * @see ProjectTwoDriverInputTwo
		 */
	}

}
