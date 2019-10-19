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
	 * @param PlayerID Which Player's hand to sort. (0 to (amount of players-1) inclusive && -1 to sort all hands.)
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
	
	/**
	 * @param handCase The combination of a scoring hand that's had (e.g. royal flush is case 1)
	 * @return the amount of points awarded for that hand
	 */
	
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
	
	/**
	 * @param n The Integer rank of the Card.
	 * @return The String rank of the passed Card.
	 */
	
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
	
	/**
	 * @param PlayerID Which Player's Hand to get the frequencies of. (0 to (amount of players-1) inclusive && -1 to sort all hands.)
	 * @return
	 */
	
	private int[] getCardFrequency(int PlayerID) {
		
		int[] CARD_FREQUENCIES = new int[14];
		Card[] C_ARR  = this.PLAYERS[PlayerID].getHand().toPrimArray();
		
		if (this.DEBUG) {
			for (int j = 0; j < C_ARR.length; j++) {
				CARD_FREQUENCIES[C_ARR[j].getIntRank()]++;
			}

			System.out.println("---Card Numbers ---");
			System.out.print("["); 
			
			for (int j = 0; j < CARD_FREQUENCIES.length; j++) {
				System.out.print(" " + CARD_FREQUENCIES[j] + " ");
			}
			
			System.out.println("]\n---"); 

			for (int j = 0; j < CARD_FREQUENCIES.length; j++) {
				System.out.println("Frequency of " + j + " >> " + CARD_FREQUENCIES[(j)]);
			}
		
			System.out.println("\n---");
			
		} else {

			CARD_FREQUENCIES = new int[14];
			C_ARR  = this.PLAYERS[PlayerID].getHand().toPrimArray();
			
			for (int j = 0; j < C_ARR.length; j++) { //Populate card frequencies
				CARD_FREQUENCIES[C_ARR[j].getIntRank()]++;
			}
		}

		return CARD_FREQUENCIES;
	}
	
	/**
	 * @param PlayerID Which Player's Hand you'd like to calculate the pairs and kinds of.
	 */
	
	private void calculatePairsKinds(int PlayerID) {
		
		int[] CARD_FREQUENCIES = this.getCardFrequency(PlayerID);
		
		for (int j = 0; j < CARD_FREQUENCIES.length; j++) { //Calculate pairs and kinds
			if (CARD_FREQUENCIES[j] == 2) { 
				System.out.println(this.PLAYERS[PlayerID].getName() + " has a pair of " + j + "s!");
			} else if (CARD_FREQUENCIES[j] > 2) {
				System.out.println(this.PLAYERS[PlayerID].getName() + " has " + CARD_FREQUENCIES[j] + " of a kind of " + this.rankProper(j) + "s!");
			}
		}
	}
	
	/**
	 * @precodition Player hands are sorted.
	 * @param PlayerID The player at index (PlayerID)
	 */
	private void calculateStraights(int PlayerID) {
		if (this.DEBUG) {
			
		} else {
			Card[] pArr = this.PLAYERS[PlayerID].getHand().toPrimArray();
			int matches = 0, suitMatches = 0, specialCaseRoyalFlushCount = 0;
			String cardCase = "";
			int[] tmpArr;
			
			for (int i = 0; i < 8; i++) {
				tmpArr  = new int[]{(i+1),(i+2),(i+3),(i+4),(i+5)};
				int[] specialCaseRoyalFlush = new int[] {1,10,11,12,13};
				matches = 0;
				specialCaseRoyalFlushCount = 0;
				suitMatches = 0;
				System.out.println("[*] i = " + i);
				
				for (int j = 0; j < 5; j++) {
					if (pArr[j].getIntRank() == tmpArr[j]) {
						matches++;
						System.out.println("Found a case match at i=" + j);
						
						if (pArr[j].getIntRank() == 1) { //Doesn't really matter if this isn't fully correct as of now because it's checked below.
							specialCaseRoyalFlushCount++;
						}
						
					}  else if (pArr[j].getIntRank() == specialCaseRoyalFlush[j]) {
						System.out.println("Matches royal flush pattern at i=" + j);
						specialCaseRoyalFlushCount++;
						matches++;
					}
				}
				
				for (int j = 1; j < 5; j++) {
				
					if (pArr[j-1].getSuit().equalsIgnoreCase(pArr[j].getSuit())) { //Ignore suit case to (lazily) avoid a bug.
						System.out.println("Index " + (j-1) + " matches index " + (j));
						suitMatches++;
					}
					
					if ((j==4) && (pArr[4].getSuit().equalsIgnoreCase(pArr[3].getSuit()))) { //Missing a comparison, tried the rubber ducky, didn't work.
						suitMatches++;
					}
					
					/*
					 * pArr[0]==pArr[1]
					 * pArr[1]==pArr[2]
					 * pArr[2]==pArr[3]
					 * pArr[3]==pArr[4]
					 * pArr[4]==pArr[5] -- MISSING CASE
					 */
				}
				
				if (matches == 5) {
					System.out.println("[*] Has five matches");
					System.out.println("\t[*] Suit Matches >> " + suitMatches);
					
					if (suitMatches == 5) {
						if (specialCaseRoyalFlushCount==5) {
							System.out.println("[*] Has five suit matches AND matches royal flush, therefore royal Flush");
							cardCase = "ROYAL FLUSH";
							if (this.DEBUG) { System.out.println(this.PLAYERS[i].getName() + " has a " + cardCase); }
							break;
						} else {
							System.out.println("[*] Has five suit matches, therefore Straight Flush");
							cardCase = "STRAIGHT FLUSH";
							if (this.DEBUG) { System.out.println(this.PLAYERS[i].getName() + " has a " + cardCase); }
							break;
						}
					} else { 
						System.out.println("[*] Doesn't have five suit matches, therefore just a flush.");
						cardCase = "STRAIGHT";
						if (this.DEBUG) { System.out.println(this.PLAYERS[i].getName() + " has a " + cardCase); }
						break;
					}
				}
				
			}
			
			if (!(cardCase.equals(""))) {
				System.out.println(this.PLAYERS[PlayerID].getName() + " has a " + cardCase);
			} else {
				System.out.println(this.PLAYERS[PlayerID].getName() + " has a no straights or flushes.");
			}
			
			
		}
	}
	
	
	public void evaluateHands() { //TODO finish & break down into sub-methods

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
				
				*https://www.cardplayer.com/rules-of-poker/hand-rankings
		 */

		this.sortHand(-1);
		//this.calculatePoints();
		
		for (int i = 0; i < this.PLAYERS.length; i++) {
			
			//int[] CARD_FREQ = new int[14]; 
			
			
			int PAIRS = 0;

			calculatePairsKinds(i);	
			calculateStraights(i);
		}
	}
	
	public void testHandSorting() {
		System.out.println("**Before player hand sort >> \n\n" + this.PLAYERS[0]);
		this.sortHand(0);
		System.out.println("\n\n**After >> \n\n" + this.PLAYERS[0]);
	}
}
