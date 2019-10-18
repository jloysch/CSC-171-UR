/**
 * @author Joshua John Reuben Loysch
 * @Version 1.4.0
 * This is intellectual property of Joshua John Reuben Loysch, all rights reserved.
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Poker {

	private int ROUND_NUMBER;
	private Scanner SC;
	private DeckOfCards DECK;
	private Player[] PLAYERS;
	private int[] PLAYER_POINTS;
	private boolean GAME_IN_PROGRESS, DEBUG;

	public Poker() {
		this.DECK = new DeckOfCards();
	}
	
	/**
	 * @param p Integer resembling amount of players.
	 */
	
	public void setPlayers(int p) {
		this.PLAYERS = new Player[p];
		this.PLAYER_POINTS = new int[p];
		this.DECK = new DeckOfCards();
		this.populateNewPlayers();
	}
	
	/**
	 * Create the players for the game, initialize their points to zero.
	 */
	
	private void populateNewPlayers() {
		for (int i = 0; i < this.PLAYERS.length; i++) {
			this.PLAYERS[i] = new Player();
			this.PLAYER_POINTS[i] = 0;
		}
	}
	
	
	/**
	 * @param PlayerID Integer ID of the player in the game. e.g. 0.
	 * @return Returns the Player object at given index (PlayerID).
	 */
	
	public Player getPlayer(int PlayerID) {
		return this.PLAYERS[PlayerID];
	}
	
	/**
	 * @param PlayerID Integer ID of the player in the game. e.g. 0.
	 * @return Returns the name of the player at given index (PlayerID) as String.
	 */
	
	public String getPlayerName(int PlayerID) {
		return this.PLAYERS[PlayerID].getName();
	}
	
	/**
	 * @return How many players are playing Poker.
	 */
	
	public int getPlayers() {
		return this.PLAYERS.length;
	}
	
	/**
	 * @param PlayerID Integer ID of the player in the game. e.g. 0.
	 * @param Name Assign a players name through this instance of Poker as a String.
	 */
	
	public void setPlayerName(int PlayerID, String Name) {
		this.PLAYERS[PlayerID].setName(Name);
	}
	
	
	/**
	 * Starts the poker game, interactive with console.
	 */
	
	public void startGame() {
		while (this.GAME_IN_PROGRESS) {
			System.out.println("[Round " + ++this.ROUND_NUMBER + "]\n");
		}
		this.SC.close();
	}
	
	/**
	 * Sorts the Hand of a Player in accordance with it's Integer rank correspondent.
	 * @param PlayerID Which Player's hand to sort. (0 to (amount of players) inclusive && -1 to sort all hands.)
	 */
	
	private void sortHand(int PlayerID) {
		if (PlayerID == -1) {
			for (int i = 0; i < this.PLAYERS.length; i++) {
				Collections.sort(this.PLAYERS[i].getHand().getCards());
			}
		} else {
			Collections.sort(this.PLAYERS[PlayerID].getHand().getCards());
		}
	}
	
	private int calculatePoints(int handCase) { //TODO finish
		switch (handCase) {
			case 1:
				return 10;
			case 2:
				return 9;
			case 3:
				return 8;
			case 4:
				return 7;
			case 5:
				return 6;
			case 6:
				return 5;
			case 7:
				return 4;
			case 8:
				return 3;
			case 9:
				return 2;
			default:
				return 0;
		}
	}
	
	private String rankProper(int n) {
		switch (n) {
		case 1:
			return "Ace";
		case 11:
			return "Jack";
		case 12:
			return "Queen";
		case 13:
			return "King";
		default:
			return String.valueOf(n);
	}
	}
	
	public void evaluateHands() { //TODO finish

		/* [Poker Game Cases]
		 		1. Straight flush – all the same suit, all cards in order.
				2. Four of a Kind
				3. Full House – three of a kind and two of a kind.
				4. Flush – all cards of the same suit.
				5. Straight – all cards in order
				6. Three of a Kind
				7. Two Pair
				8. One Pair
				9. High Card 
		 */

		this.sortHand(-1);
		//this.calculatePoints();
		
		for (int i = 0; i < this.PLAYERS.length; i++) {
			
			int[] CARD_FREQ = new int[14]; 
			int[] CARD_NUMBERS = new int[14];
			Card[] C_ARR  = this.PLAYERS[i].getHand().toPrimArray();
			
			int PAIRS = 0;
			
			if (this.DEBUG) { System.out.println("---Card Numbers ---"); }
			
			for (int j = 0; j < C_ARR.length; j++) {
				CARD_NUMBERS[C_ARR[j].getIntRank()]++;
			}
			
			if (this.DEBUG) { System.out.print("["); }
			for (int j = 0; j < CARD_NUMBERS.length; j++) {
				if (this.DEBUG) { System.out.print(" " + CARD_NUMBERS[j] + " "); }
			}
			
			if (this.DEBUG) { System.out.println("]\n---"); }
			
			for (int j = 0; j < CARD_NUMBERS.length; j++) {
				
				if (CARD_NUMBERS[j] == 2) { // Gets pairs and kinds
					System.out.println("Player has a pair of " + j + "s!");
					PAIRS++;
				} else if (CARD_NUMBERS[j] > 2) {
					System.out.println("Player has " + CARD_NUMBERS[j] + " of a kind of " + this.rankProper(j) + "s!");
				}
			}
			
			if (this.DEBUG) {
				for (int j = 0; j < CARD_FREQ.length; j++) {
					System.out.println("Frequency of " + j + " >> " + CARD_FREQ[(j)]);
				}
				System.out.println("\n---");
			}
		}
	}
	
	public void testHandSorting() {
		System.out.println("**Before player hand sort >> \n\n" + this.PLAYERS[0]);
		this.sortHand(0);
		System.out.println("\n\n**After >> \n\n" + this.PLAYERS[0]);
	}
}
