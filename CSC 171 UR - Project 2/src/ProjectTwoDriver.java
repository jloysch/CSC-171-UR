/*
 * Name: Joshua Loysch
 * NetID: jloysch
 * Assignment Number: Project Two
 * Lab Section Day/Time: MW, 2:00-3:15PM
 * 
 * I did not collaborate with anyone on this assignment, this was entirely me.
 */

/**
 * @author Joshua John Reuben Loysch
 * @Version 1.4.2r0
 * Intellectual property of Joshua John Reuben Loysch, all rights reserved.
 */

public class ProjectTwoDriver {
	
	public static void testAllHands() {
		System.out.println("[DEBUG] Testing Straight Flush");
		System.out.println("[DEBUG] Testing Four of a Kind");
		System.out.println("[DEBUG] Testing Full House");
		System.out.println("[DEBUG] Testing Flush");
		System.out.println("[DEBUG] Testing Straight");
		System.out.println("[DEBUG] Testing Three of a Kind");
		System.out.println("[DEBUG] Testing Two Pair");
		System.out.println("[DEBUG] Testing One Pair");
		System.out.println("[DEBUG] Testing High Card");
		
	}
	
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
		
		//game.setPlayers(1);
		
		/*
		for (int i = 0; i < game.getPlayers(); i++) {
			for (int j = 0; j < 5; j++) {
				//game.getPlayer(i).addToHand(cards.dealCard(true));
				game.getPlayer(i).addToHand(new Card(1,1));
			}
		}
		*/
		
		game.getPlayer(0).setName("Daniel");
		
		
		/* -- Hand test 1, 3 Ace of diamonds & 2 (3 of hearts); -- (3 of a kind ACE, pair of 3s) --WORKING
		game.getPlayer(0).addToHand(new Card(1,1));
		game.getPlayer(0).addToHand(new Card(1,1));
		game.getPlayer(0).addToHand(new Card(1,1));
		game.getPlayer(0).addToHand(new Card(3,3));
		game.getPlayer(0).addToHand(new Card(3,3));*/
		
		
		/* -- Hand test, ROYAL flush (Ace,10,jack,queen,king) all spades. --WORKING
		game.getPlayer(0).addToHand(new Card(1,1));
		game.getPlayer(0).addToHand(new Card(1,10));
		game.getPlayer(0).addToHand(new Card(1,11));
		game.getPlayer(0).addToHand(new Card(1,12));
		game.getPlayer(0).addToHand(new Card(1,13));*/
		
		
		
		/* STRAIGHT FLUSH - Five cards in a sequence, all in the same suit. --WORKING
		game.getPlayer(0).addToHand(new Card(0,3));
		game.getPlayer(0).addToHand(new Card(0,4));
		game.getPlayer(0).addToHand(new Card(0,5));
		game.getPlayer(0).addToHand(new Card(0,6));
		game.getPlayer(0).addToHand(new Card(0,7)); */
		
		
		
		/* STRAIGHT - Five cards in a sequence, but not of the same suit. --WORKING
		game.getPlayer(0).addToHand(new Card(1,7));
		game.getPlayer(0).addToHand(new Card(1,6));
		game.getPlayer(0).addToHand(new Card(2,8));
		game.getPlayer(0).addToHand(new Card(3,9));
		game.getPlayer(0).addToHand(new Card(0,10)); */
		
		/* FLUSH - Any five cards of the same suit, but not in a sequence. -- WORKING 
		game.getPlayer(0).addToHand(new Card(1,7));
		game.getPlayer(0).addToHand(new Card(1,4));
		game.getPlayer(0).addToHand(new Card(1,3));
		game.getPlayer(0).addToHand(new Card(1,1));
		game.getPlayer(0).addToHand(new Card(1,11));*/
		
		/* TWO PAIR - Two different pairs. --WORKING 
		game.getPlayer(0).addToHand(new Card(1,4));
		game.getPlayer(0).addToHand(new Card(0,4));
		game.getPlayer(0).addToHand(new Card(2,3));
		game.getPlayer(0).addToHand(new Card(2,3));
		game.getPlayer(0).addToHand(new Card(1,11)); */
		
		/* Full house - Three of a kind with a pair. --WORKING BECAUSE PAIRS & KIND WORKS, COMBINE LOGIC TO PRINT FULL HOUSE
		game.getPlayer(0).addToHand(new Card(0,10));
		game.getPlayer(0).addToHand(new Card(1,10));
		game.getPlayer(0).addToHand(new Card(2,10));
		game.getPlayer(0).addToHand(new Card(1,3));
		game.getPlayer(0).addToHand(new Card(2,3));*/
		
		/* Four of a kind -  Four cards of a kind. --WORKING
		game.getPlayer(0).addToHand(new Card(0,10));
		game.getPlayer(0).addToHand(new Card(1,10));
		game.getPlayer(0).addToHand(new Card(2,10));
		game.getPlayer(0).addToHand(new Card(3,10));
		game.getPlayer(0).addToHand(new Card(2,3));*/
		
		//testAllHands();
		
		//game.testHandSorting(); //WORKING
		
		//game.evaluateHands();
		
		//game.start();
		
		//game.startFromStr("2c2d7c7dTc","3h3s5c5s6c");
		
		//game.caseAudit(true);
		
		game.randomHandIterativeAudit(Integer.MAX_VALUE, false);
		
		/*Each string will be of the form RSRSRSRSRS where R can be any one of the
		set (2,3,4,5,6,7,8,9,T,t,J,j,Q,q,K,k,A,a) and S can be any one of the set (C,c,H,h,S,s,D,d).
		Your program must then classify both hands and print the winner
		*/
	}

}
