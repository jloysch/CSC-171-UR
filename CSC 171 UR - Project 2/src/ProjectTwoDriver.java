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
 * @Version 1.4.2
 * This is intellectual property of Joshua John Reuben Loysch, all rights reserved.
 */

public class ProjectTwoDriver {
	
	public static void main(String args[]) {
		
		DeckOfCards cards = new DeckOfCards();
		/*
		Player player1 = new Player();
		Player player2 = new Player();
		
		System.out.println(cards);
		
		
		
		System.out.println("\n\n\nShuffled >> ");
		
		System.out.println(cards);
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 5; j++) {
				player1.addToHand(cards.dealCard(true));
				player2.addToHand(cards.dealCard(true));
			}
		}
		
		System.out.println("Player one toString >>\n" + player1 + "\n\nPlayer two toString >>\n" + player2);
		System.out.println("Deck after pops >>\n" + cards);
		
		*/
		
		cards.shuffle();
		Poker game = new Poker();
		
		game.setPlayers(1);
		
		/*
		for (int i = 0; i < game.getPlayers(); i++) {
			for (int j = 0; j < 5; j++) {
				//game.getPlayer(i).addToHand(cards.dealCard(true));
				game.getPlayer(i).addToHand(new Card(1,1));
			}
		}
		*/
		
		game.getPlayer(0).addToHand(new Card(1,1));
		game.getPlayer(0).addToHand(new Card(1,1));
		game.getPlayer(0).addToHand(new Card(1,1));
		game.getPlayer(0).addToHand(new Card(3,3));
		game.getPlayer(0).addToHand(new Card(3,3));
		
		
		game.testHandSorting();
		
		game.evaluateHands();
	}

}
