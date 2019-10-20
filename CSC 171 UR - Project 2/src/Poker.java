/**
 * @author Joshua John Reuben Loysch
 * @Version 1.4.0b11
 * Intellectual property of Joshua John Reuben Loysch, all rights reserved.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Poker {

	private int ROUND_NUMBER, DECK_NUMBER, DEAL_NUMBER;
	private boolean GAME_IN_PROGRESS, DEBUG;
	private String[] SATISFIED_CASES;
	private int[] PLAYER_POINTS;
	private DeckOfCards DECK;
	private Player[] PLAYERS;
	private Scanner SC;
	
	public Poker() {
		this.setPlayers(2); //If you don't specify we will assume 2 people playing.
		this.SATISFIED_CASES = new String[this.PLAYERS.length];
		this.SC = new Scanner(System.in);
		this.DECK = new DeckOfCards();
		this.ROUND_NUMBER = 0;
		this.DECK_NUMBER = 0;
		this.DEAL_NUMBER = 1;
		
		this.DECK.shuffle();
	}
	
	/**
	 * @param p Integer depicting the amount of players going to play Poker.
	 */
	
	public void setPlayers(int p) {
		this.PLAYERS = new Player[p];
		this.PLAYER_POINTS = new int[p];
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
	
	public int getPlayersPlaying() {
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
	 * @param PlayerID Which player to do this to.
	 */
	
	private void newPlayerHand(int PlayerID) {
		if (PlayerID == -1) {
			 for (int i = 0; i < this.PLAYERS.length; i++) {
				 this.PLAYERS[i].getHand().clear();
				 for (int j = 0; j < 5; j++) {
					 this.PLAYERS[i].addToHand(this.DECK.dealCard(true));
				 }
			 }
		} else {
			this.PLAYERS[PlayerID].getHand().clear();
			
			for (int i = 0; i < 5; i++) {
				this.PLAYERS[PlayerID].addToHand(this.DECK.dealCard(true));
			}	
		}
	}
	
	/**
	 * Makes each player compliant with the rules of Poker. (5 hands, shuffled deck, no duplicate cards).
	 * @param interactive True/False. True for the initial setup of the game, False when called within the game play.
	 */
	
	private void doGameCompliance(boolean interactive) {
		int NONCOMPLIANT_PLAYERS = 0;

		if (!interactive) {
			this.DECK = new DeckOfCards();
			this.DECK.shuffle();
			this.newPlayerHand(-1);
		} else {
			for (int i = 0; i < this.PLAYERS.length; i++) {
				if (!(this.PLAYERS[i].getHand().size() == 5)) {
					System.out.println("Player " + (i+1) + ", also known as '" + this.PLAYERS[i].getName() + "' doesn't have 5 cards, they have " + this.PLAYERS[i].getHand().size() + ".");
					NONCOMPLIANT_PLAYERS++;
				} else {
					System.out.println("Removing the following cards due to Player '" + this.PLAYERS[i].getName() + "' having a compliant pre-set hand.\n" + this.PLAYERS[i].getHand());
					
					for (int j = 0; j < this.PLAYERS[i].getHand().getCards().size() ; j++) {
						for (int k = 0; k < this.DECK.cardsRemaining(); k++) {//
							if (this.PLAYERS[i].getHand().getCardAt(j).compareTo(this.DECK.toArray().get(k))==0) {
								this.DECK.discardFromIndex(k);
							}
						}
					}
					System.out.println("\nDeck size is now " + this.DECK.cardsRemaining() + "\n");
				}
			}
			
			if (NONCOMPLIANT_PLAYERS > 0) {
				System.out.print("\nYou have players without five cards to play Poker.\n\nWould you like to deal them from this deck or manually assign the cards?\n[Yy=Assign//Nn=Manual] >> ");
	
				if (this.SC.next().equalsIgnoreCase("Y")) {
					System.out.println("\n");
					this.DECK = new DeckOfCards();
					this.DECK.shuffle();
					
					for (Player p : this.PLAYERS) {
						
						while (!(p.getHand().size() == 5)) {
							if (p.getHand().size() < 5) {
								p.addToHand(this.DECK.dealCard(true));
								System.out.println("Player '" + p.getName() + "' has been given a card.");
							} else {
								p.getHand().discardLast();
								System.out.println("Player '" + p.getName() + "' has had a card removed from their Hand");
							}
						}
						
						if (this.DEBUG) { System.out.println("\n[*] Player '" + p.getName() + "' is now compliant with five cards."); }
					}
					
				} else {
					
				}
			}
			
			System.out.print("\n[*] All players are" + (NONCOMPLIANT_PLAYERS > 0 ? " now " : " pre-") + "compliant. Would you like to begin?\n\t[Yy\\Nn] >> ");
	
			if (this.SC.next().equalsIgnoreCase("Y")) {
				this.GAME_IN_PROGRESS = true;
			}
		}
	}
	
	/**
	 * @param lines How many lines to flood to the console.
	 */
	
	private void floodConsoleSpace(int lines) {
		for (int i = 0; i < lines; i++) {
			System.out.print("\n");
		}
	}
	
	/**
	 * Starts the poker game, interactive with console.
	 */
	
	public void start() {
		this.doGameCompliance(true);
		this.DEAL_NUMBER = 1;
		this.SATISFIED_CASES = new String[this.PLAYERS.length];
		
		while (this.GAME_IN_PROGRESS) {
			this.floodConsoleSpace(50);
			System.out.println("[Deck Number >> " + ++this.DECK_NUMBER + " | Round Number >> " + ++this.ROUND_NUMBER + "]");

			while (this.DECK.cardsRemaining() > 0) {	
				for (int i = 0; i < this.PLAYERS.length; i++) {
					System.out.println("\n\n  Deal " + this.DEAL_NUMBER + " --->> ");
					System.out.println("\t" + 
							(this.PLAYERS[i].getName().equalsIgnoreCase("Player") ? ("Player " + (i+1) + " has " + this.PLAYERS[i].getHand().size()) 
							+ " cards >>\n" + this.PLAYERS[i].explicitToStr(): this.PLAYERS[i]) + "\n");
					
					this.evaluateHand(i);	
				}
				
				compareHands();
				
				DEAL_NUMBER++;

				if (this.DECK.cardsRemaining() < 5*this.PLAYERS.length) {
					break;
				} else {
					for (int i = 0; i < this.PLAYERS.length; i++) {
						
						this.newPlayerHand(i);
					}
				}	
			}
			
			System.out.print("\n  [*] You don't have enough cards for the next deal! Would you like to collect and re-deal?\n\t[Yy\\Nn] >> ");
			
			if (this.SC.next().equalsIgnoreCase("N")) {
				break;
			} else {
				this.doGameCompliance(false);
				this.ROUND_NUMBER = 0;
				this.DEAL_NUMBER = 1;
				this.floodConsoleSpace(50);	
			}
		}
		
		this.SC.close();
	}

	/**
	 * @param str The String value of a given suit index as pertains to the Card object (Card(int suit, int rank)). This is a sub-routine.
	 * @see inputStrToCardArr(String str)
	 * @return The integer value returned from the passed String value representing the index of the Suit desired.
	 */
	
	private int inputStrToSuitIndex(String str) {
		switch (str.toUpperCase()) {
			case "S":
				return 0;
			case "D":
				return 1;
			case "C":
				return 2;
			case "H":
				return 3;
			default:
				return -1;
		}
	}
	
	/**
	 * @param s The String value of a single character that expresses the rank of the card to be created. This is a sub-routine.
	 * @see inputStrToCardArr(String str)
	 * @return The Integer value corresponding with the passed rank.
	 */
	
	private int inputStrToRankIndex(String s) {
		switch (s.toUpperCase()) {
			case "T":
				return 10;
			case "J":
				return 11;
			case "Q":
				return 12;
			case "K":
				return 13;
			case "A":
				return 1;
			default:
				return Integer.valueOf(s);
		}
	}
	
	/**
	 * @param str The "RSRSRSRSRS" String passed from the input. 
	 * @return The string expressed as an ArrayList<Card>, to be assigned to the given Player's Hand.
	 */
	
	private ArrayList<Card> inputStrToCardArr(String str) {
		ArrayList<Card> TMP = new ArrayList<Card>();
		
		for (int i = 0; i < str.length(); i+=2) {
			if (this.DEBUG) { System.out.println("inputStrToCardARR >> i = " + i); }
			
			if (this.DEBUG) { System.out.print("\tSUIT=" + str.charAt(i+1) + " && RANK=" + str.charAt(i) + "\n"); }
			

			TMP.add(new Card((this.inputStrToSuitIndex(String.valueOf(str.charAt(i+1)))),(this.inputStrToRankIndex(String.valueOf(str.charAt(i))))));
			if (this.DEBUG) { System.out.println("* Added a new card succesfully"); }
		}
		
		return TMP;
	}
	
	/**
	 * @param str A string in the form "RSRSRSRSRS" (R= Rank, S = Suit), not case sensitive, player one's hand will be built from this.
	 * @param str2 A string in the form "RSRSRSRSRS" (R= Rank, S = Suit), not case sensitive, player two's hand will be built from this.
	 */
	
	public void startFromStr(String str, String str2) { //Since I'll always be given two, I won't make this as dynamic as I'd like.
		
			this.PLAYERS[0].getHand().setHand(this.inputStrToCardArr(str));
			this.PLAYERS[1].getHand().setHand(this.inputStrToCardArr(str2));
			
			for (int n = 0; n < this.PLAYERS.length; n++) {
				System.out.println("\n[*] Hand for player " + (n+1) + " >> ");
				
				for (int i = 0; i < this.PLAYERS[n].getHand().size(); i++) {
					System.out.println("\t[Card " + (i+1) + "] " + this.PLAYERS[n].getHand().getCardAt(i));
				}
				System.out.println("\n");
				this.evaluateHand(n);
			}
			this.compareHands();
	}
	
	/**
	 * Sorts the Hand of a Player in accordance with it's Integer rank correspondent, where Ace = 1.
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
	 * @param str Pass a string that a number couldn't be found in. This is a catch-all for getting the int value back from a rank. This is a sub-routine.
	 * @see findNumberInString(String)
	 * @return The Integer value corresponding to the passed String rank.
	 */
	
	private int tryBackToInt(String str) {
		if (str.toUpperCase().contains("KING")) {
			return 13;
		} else if (str.toUpperCase().contains("QUEEN")) {
			return 12;
		} else if (str.toUpperCase().contains("JACK")) {
			return 11;
		} else if (str.toUpperCase().contains("ACE")) {
			return 13;
		} else {
			return 0;
		}
	}
	
	/**
	 * @param str The String that you wish to find an Integer in. This is a sub-routine.
	 * @see caseToPoints(String)
	 * @return The Integer that is found within the String.
	 */
	
	private int findNumberInString(String str) {
		String[] TMP = str.split("_");
		int a = 0;
		while (true) {
			try {
				if ( a > TMP.length) {
					if (this.DEBUG) { System.out.println("Couldn't find number in string '" + str + "'\n from sub-method returning >> " + tryBackToInt(str)); }
					break;
				}
				
				a = Integer.parseInt(TMP[a]);
				if (this.DEBUG) { System.out.println(" FOUND NUMBER >> " + a); }
				return a;
			} catch (Exception e) {
				a++;
			}
		}
		
		/*if (!NUMBER_FOUND && this.DEBUG) {
			System.out.println("COULDN'T ID A NUMBER, tryBackToInt will give " + tryBackToInt(str));
		}*/
		
		return tryBackToInt(str);
	}
	
	/**
	 * @param CASE The case from the private class-level array that describes what kinds of cases the Player's Hand has met. This is a sub-routine.
	 * @see addPoints(String, Integer)
	 * @return An Integer denoting the point value for that specific kind of hand.
	 */

	public int caseToPoints(String CASE) { //----------- HIGHEST CARD 14
		if (CASE.contains("PAIR")) {
			return 1 + findNumberInString(CASE.substring(0, CASE.length() - 1)); // 3-15
		}  else if (CASE.contains("FULL")) {
			return 15+30; //45
		} else if (CASE.contains("KIND")) {
			int tmp = 0;
			
			if (CASE.contains("FOUR")) {
				tmp+=10;
			} 
			
			return tmp + 20 + findNumberInString(CASE.substring(0, CASE.length() - 1)); //20-34
		} else if (CASE.contains("ROYAL")) {
			return Integer.MAX_VALUE; //ALWAYS WIN
		} else if (CASE.contains("STRAIGHT") && CASE.contains("FLUSH")) { //*Straight flush
			return (Integer.MAX_VALUE-100); //ALWAYS WIN BEHIND ROYAL FLUSH
		} else if (CASE.contains("STRAIGHT")) {
			return 35; //40
		} else if (CASE.contains("FLUSH")) {
			return 40; //35
		}
		
		else {
			return 0;
		}
	}
	
	/**
	 * @param CASE The specific case from the cases the Player's Hand has met.
	 * @param PlayerID Which Player to add the points to.
	 */
	public void addPoints(String CASE, int PlayerID) {
		this.PLAYER_POINTS[PlayerID]=caseToPoints(CASE);
		if (this.DEBUG) { System.out.println("Player " + (PlayerID+1) + " now has " + caseToPoints(CASE) + " symbollic points."); }
	}
	
	
	/**
	 * Compares the hands of all the Players.
	 */
	
	public void compareHands() {
		
		boolean trueWinner = true;
		
		int HIGHEST_POINTS_IN_INDEX = Integer.MIN_VALUE; //Find which player corresponds with the highest point
		int WINNER = 0; //index
		
		int[] matchingPoints = new int[this.PLAYERS.length];
		
		for (int i = 0; i < this.PLAYERS.length; i++) {
			if (this.PLAYER_POINTS[i] > HIGHEST_POINTS_IN_INDEX) {
				HIGHEST_POINTS_IN_INDEX = this.PLAYER_POINTS[i];
				if (this.DEBUG) { System.out.println("\t[HIGH_CARD_CASE_INIT_CHECK] >>Player " + (i+1) + " with " + this.PLAYER_POINTS[i] + " points."); }
				WINNER = i;
			}
		}
		
		//If they're the 'winner' but match even with someone elses points then it's a draw.
		
		for (int i = 0; i < this.PLAYERS.length; i++) {
			if ((this.PLAYER_POINTS[i] == HIGHEST_POINTS_IN_INDEX) && (!(i==WINNER))) {
				matchingPoints[i]++;
				trueWinner = false;
			}
		}
		
		if (trueWinner) {
			System.out.println("\n\t[*]--- Player " + (WINNER+1) + ", " + (this.PLAYERS[WINNER].getName().equalsIgnoreCase("Player") ? "" : this.PLAYERS[WINNER].getName()) + " wins this round! (Deal " + this.DEAL_NUMBER + ") -->");
		} else {
			int highest = Integer.MIN_VALUE, pIndexHighCard = 0, pDoubles = 0;
			
			for (int i = 0; i < this.PLAYERS.length; i++) {
				if (this.PLAYERS[i].getHand().getCardAt(this.PLAYERS[i].getHand().size()-1).getIntRank() > highest) {
					highest = this.PLAYERS[i].getHand().getCardAt(this.PLAYERS[i].getHand().size()-1).getIntRank();
					pIndexHighCard = i;
				}
			}
			
			//The highest value of this round because of our unique situation (high card territory) will be stored in 'highest'
			
			for (int i = 0; i < this.PLAYERS.length; i++) {
				if (highest == (this.PLAYERS[i].getHand().getCardAt(this.PLAYERS[i].getHand().size()-1).getIntRank()) && (!(i==pIndexHighCard))) {
					pDoubles++;
				}
			}
			
			if (pDoubles == 0) {
				System.out.println("\n\t[*] The highest card for this round was a(n) " + this.PLAYERS[pIndexHighCard].getHand().getCardAt(this.PLAYERS[pIndexHighCard].getHand().size()-1).getRank() 
						+ ", Player " + (pIndexHighCard+1) + ", '" + (this.PLAYERS[WINNER].getName().equalsIgnoreCase("Player") ? ("Player'") : (this.PLAYERS[pIndexHighCard].getName())) + "'" 
						+ " wins this round. (Deal " + this.DEAL_NUMBER + ")");
			} else {
				String str = "\n\t[*] The highest card for this round was a(n) " + this.PLAYERS[WINNER].getHand().getCardAt(this.PLAYERS[WINNER].getHand().size()-1).getRank() + ".\n\tThe following players had the same score:\n\n";
				for (int i = 0; i < matchingPoints.length; i++) {
					if (matchingPoints[i] > 0) {
						str += "\t* Player " + (i+1) + "\n";
					}
				}
				
				str += "\n\tThe round (Deal " + this.DEAL_NUMBER + ") is a draw."; //TODO check logic for high card
				
				System.out.println(str);
			}
		}

		for (int i = 0; i < this.PLAYER_POINTS.length; i++) {
			this.PLAYER_POINTS[i]=0;
		}
	}
	
	/**
	 * Posts the stats (populates the array which holds the cases that the Player's Hand meets) 
	 * @param PlayerID Which Player to do this for.
	 */
	public void postHandStats(int PlayerID) {
		
		String[] TMP = this.SATISFIED_CASES[PlayerID].split("\n");
		int ct = 0;
		
		for (int i = 0; i < TMP.length; i++) {
			if ((TMP[i].length()>0) && (!(TMP[i].equals(null)))) {
				if (!(TMP[i].equals("null"))) {
					System.out.println("\t" + (this.PLAYERS[PlayerID].getName().equalsIgnoreCase("Player") ? ("Player " + (PlayerID+1)) : this.PLAYERS[PlayerID].getName()) + " has a " + TMP[i] + "!");
					this.addPoints(TMP[i], PlayerID);
					ct++;
				}
				
			}
		}
		
		if (ct==0) {
			System.out.println("\tNo hand this round. High card plays!\n\n\t" + this.PLAYERS[PlayerID].getHand().getCardAt(this.PLAYERS[PlayerID].getHand().size()-1));
		}
		
		this.SATISFIED_CASES[PlayerID]="";	
	}
	
	/**
	 * @param PlayerID Which Player's Hand you'd like to calculate the pairs and kinds of.
	 */
	
	private void calculatePairsKinds(int PlayerID) { //Also takes care of full house.
		
		int[] CARD_FREQUENCIES = this.getCardFrequency(PlayerID);
		
		int PAIRS = 0, THREE_OF_A_KIND = 0, KINDS = 0; //Three of a kind is special, (full house).
		
		String TMP_STATS = "";
		
		for (int j = 0; j < CARD_FREQUENCIES.length; j++) { //Calculate pairs and kinds
			
			if (this.DEBUG) { System.out.println("CARD FREQUENCY FOR " + j + " = " + CARD_FREQUENCIES[j]); }
			
			if (CARD_FREQUENCIES[j] == 2) { 
				if (this.DEBUG) { System.out.println("\t+" + this.PLAYERS[PlayerID].getName() + " has a pair of " + j + "s!"); }
				TMP_STATS += ("\nPAIR_OF_" + this.rankProper(j) + "s");
				PAIRS++;
			} else if (CARD_FREQUENCIES[j] == 3) {
				if (this.DEBUG) { System.out.println("\t+" + this.PLAYERS[PlayerID].getName() + " has " + CARD_FREQUENCIES[j] + " of a kind of " + this.rankProper(j) + "s!"); };
				TMP_STATS += ("\nTHREE_OF_A_KIND_" + this.rankProper(j) + "s");
				THREE_OF_A_KIND++;
				KINDS++;
			} else if (CARD_FREQUENCIES[j] == 4) {
				TMP_STATS += ("\nFOUR_OF_A_KIND_" + this.rankProper(j) + "s");
				KINDS++;
			}			
			
		}
		
		if (this.DEBUG) { System.out.println("KINDS PAIRS >>\nKINDS = " + KINDS + "\n\tPAIRS = " + PAIRS); }
		if ((PAIRS == 1) && (THREE_OF_A_KIND == 1)) {
			//System.out.println("\t+FULL HOUSE");
			this.SATISFIED_CASES[PlayerID]+=("\nFULL_HOUSE");
		} else {
			String[] tmp = TMP_STATS.split("\n");
			
			for (int i = 0; i < tmp.length; i++) {
				if (!(tmp[i].equalsIgnoreCase("null") && !(tmp[i].equals(null)))) {
					if (this.DEBUG) { System.out.println("KINDS/E added " + tmp[i]); }
					this.SATISFIED_CASES[PlayerID]+=(tmp[i] + "\n");	
				}
				
			}
		}
		
	}
	
	/**
	 * @param arr1 An Integer array.
	 * @param arr2 Another Integer array.
	 * @return True if they're equal, false otherwise.
	 */
	
	private boolean arrEq(int[] arr1, int[] arr2) {
		int tmp = 0;
		if (arr1.length == arr2.length) {
			for (int i = 0; i < arr1.length; i++) {
				if (arr1[i]==arr2[i]) {
					tmp++;
				}
			}
			
			if (tmp==arr1.length) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	/**
	 * @precodition Player hands are sorted.
	 * @param PlayerID The player at index (PlayerID)
	 */
	
	private void calculateStraights(int PlayerID) {
		int matches = 0, suitMatches = 0;
		boolean fiveMatches = false;
		int[] tmpArr;
		
		if (this.DEBUG) {

			System.out.println("\n\t\t*Starting Suit Match Loop*");
			for (int j = 1; j < 5; j++) {
				
				if (this.PLAYERS[PlayerID].getHand().toPrimArray()[j-1].getSuit().equalsIgnoreCase(this.PLAYERS[PlayerID].getHand().toPrimArray()[j].getSuit())) {
					suitMatches++;
				}
				
				if ((j==4) && (this.PLAYERS[PlayerID].getHand().toPrimArray()[4].getSuit().equalsIgnoreCase(this.PLAYERS[PlayerID].getHand().toPrimArray()[3].getSuit()))) { //Missing a comparison, tried the rubber ducky, didn't work.
					suitMatches++;
				}

				System.out.println("\t[i=" + j + "] " + suitMatches + " suit matches.");
			}
			
			if((suitMatches == 5) && (this.arrEq(this.PLAYERS[PlayerID].getHand().toIntArray(), new int[]{1,10,11,12,13}))) { //Known case, Royal Flush.
				//cardCase = "ROYAL FLUSH";
				this.SATISFIED_CASES[PlayerID]+=("ROYAL_FLUSH\n");
				//System.out.println("ROYAL FLUSH");
				
			} else { //If it's not a Royal Flush
				System.out.println("\t\t*Starting Ascending Match Loop*");
				
				for (int i = 0; i < 9; i++) {
					tmpArr  = new int[]{(i+1),(i+2),(i+3),(i+4),(i+5)};
					matches = 0;
					System.out.println("[*] Outer Loop >> [i = " + i + "] & Array = [" + (i+1) + "," + (i+2) + "," + (i+3) + "," + (i+4) + "," + (i+5) + "]");
					
					for (int j = 0; j < 5; j++) {
						if (this.PLAYERS[PlayerID].getHand().toPrimArray()[j].getIntRank() == tmpArr[j]) {
							System.out.println("\t\tMatch at [i=" + j +"]\t(" + this.PLAYERS[PlayerID].getHand().toPrimArray()[j] + " = " + tmpArr[j] + ")");
							matches++;
						}
						
						if((matches==5)) { //break loop
							System.out.println("\n\t[*]-- Ascending pattern found for loops @ [" + i + "," + j + "] --->");
							fiveMatches = true;
							break;
						} else {
							System.out.println("\t\t[*] " + matches + " ascending card matches for loop [i=" + j + "]");
						}
						
					}
					
					if (fiveMatches) {
						break;
					}
				}

				System.out.println("\n\t[*]--- " + this.PLAYERS[PlayerID].getName() + " has " + matches + " matches and " + suitMatches + " matching suits.");

				if ((matches==5) && (suitMatches==5)) {
					//cardCase = "STRAIGHT FLUSH";
					//System.out.println("STRAIGHT FLUSH");
					this.SATISFIED_CASES[PlayerID]+=("STRAIGHT_FLUSH\n");
					//cardCase = "STRAIGHT FLUSH";
				} else if (!(matches==5) && (suitMatches==5)) {
					//System.out.println("FLUSH");
					this.SATISFIED_CASES[PlayerID]+=("FLUSH\n");
					//cardCase = "FLUSH";
				} else if ((matches==5) && !(suitMatches==5)) {
					//System.out.println("STRAIGHT");
					//cardCase = "STRAIGHT";
					this.SATISFIED_CASES[PlayerID]+=("STRAIGHT\n");
				}		
			}
			
		} else {
		
			for (int j = 1; j < 5; j++) {
				if (this.PLAYERS[PlayerID].getHand().toPrimArray()[j-1].getSuit().equalsIgnoreCase(this.PLAYERS[PlayerID].getHand().toPrimArray()[j].getSuit())) {
					suitMatches++;
				}
				
				if ((j==4) && (this.PLAYERS[PlayerID].getHand().toPrimArray()[4].getSuit().equalsIgnoreCase(this.PLAYERS[PlayerID].getHand().toPrimArray()[3].getSuit()))) {
					suitMatches++;
				}
			}
			
			if((suitMatches == 5) && (this.arrEq(this.PLAYERS[PlayerID].getHand().toIntArray(), new int[]{1,10,11,12,13}))) { //Known case, Royal Flush.
				//cardCase = "ROYAL FLUSH";
				this.SATISFIED_CASES[PlayerID]+=("ROYAL_FLUSH\n");
				//System.out.println("ROYAL FLUSH");
			} else {
				for (int i = 0; i < 9; i++) {
					tmpArr  = new int[]{(i+1),(i+2),(i+3),(i+4),(i+5)};
					matches = 0;
					for (int j = 0; j < 5; j++) {
						if (this.PLAYERS[PlayerID].getHand().toPrimArray()[j].getIntRank() == tmpArr[j]) {
							matches++;
						}
						
						if (matches==5) { 
							fiveMatches = true;
							break;
						} 
					}
					
					if (fiveMatches) {
						break;
					}
				}

				if ((matches==5) && (suitMatches==5)) {
					//System.out.println("STRAIGHT FLUSH");
					//cardCase = "STRAIGHT FLUSH";
					this.SATISFIED_CASES[PlayerID]+=("STRAIGHT_FLUSH\n");
				} else if (!(matches==5) && (suitMatches==5)) {
					//System.out.println("FLUSH");
					this.SATISFIED_CASES[PlayerID]+=("FLUSH\n");
					//cardCase = "FLUSH";
				} else if ((matches==5) && !(suitMatches==5)) {
					//System.out.println("STRAIGHT");
					this.SATISFIED_CASES[PlayerID]+=("STRAIGHT\n");
					//cardCase = "STRAIGHT";
				}		
			}
		}
		//System.out.println("\t+" + cardCase);
	}
	
	/**
	 * Evaluates the hand of a Player (checks which cases the Player's Hand meets)
	 * @param PlayerID Which player to do this for.
	 */
	
	public void evaluateHand(int PlayerID) { //TODO finish & break down into sub-methods

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

		this.sortHand(PlayerID);
		this.calculatePairsKinds(PlayerID);	
		this.calculateStraights(PlayerID);
		this.postHandStats(PlayerID);
	}
	
	/**
	 * Test the Hand sorting of the Poker class.
	 */
	
	public void testHandSorting() {
		System.out.println("**Before player hand sort >> \n\n" + this.PLAYERS[0]);
		this.sortHand(0);
		System.out.println("\n\n**After >> \n\n" + this.PLAYERS[0]);
	}
	
	/**
	 * Loops through a player's hand and prints each card for it.
	 * @param PlayerID which player to do this to.
	 */
	
	private void printLoopThroughHand(int PlayerID) {
		for (int i = 0; i < this.PLAYERS[PlayerID].getHand().size(); i++) {
			System.out.println("\t[Card " + (i+1) + "] " + this.PLAYERS[PlayerID].getHand().getCardAt(i));
		}
		
		System.out.println();
	}
	
	/**
	 * Sets a specific case for a player, auditing purposes.
	 * @param PlayerID Which player to give a specified case to
	 * @param caseName Which case to give the player. (e.g. "FULL_HOUSE")
	 */
	
	private void setCase(int PlayerID, String caseName) {
		this.PLAYERS[PlayerID].getHand().clear();
		
		switch (caseName.toUpperCase()) {
			case "FULL_HOUSE":
				this.PLAYERS[PlayerID].addToHand(new Card(1,1));
				this.PLAYERS[PlayerID].addToHand(new Card(1,1));
				this.PLAYERS[PlayerID].addToHand(new Card(1,1));
				this.PLAYERS[PlayerID].addToHand(new Card(3,3));
				this.PLAYERS[PlayerID].addToHand(new Card(3,3));
				break;
			case "ROYAL_FLUSH":
				this.PLAYERS[PlayerID].addToHand(new Card(1,1));
				this.PLAYERS[PlayerID].addToHand(new Card(1,10));
				this.PLAYERS[PlayerID].addToHand(new Card(1,11));
				this.PLAYERS[PlayerID].addToHand(new Card(1,12));
				this.PLAYERS[PlayerID].addToHand(new Card(1,13));
				break;
			case "STRAIGHT_FLUSH":
				this.PLAYERS[PlayerID].addToHand(new Card(0,3));
				this.PLAYERS[PlayerID].addToHand(new Card(0,4));
				this.PLAYERS[PlayerID].addToHand(new Card(0,5));
				this.PLAYERS[PlayerID].addToHand(new Card(0,6));
				this.PLAYERS[PlayerID].addToHand(new Card(0,7));
				break;
			case "STRAIGHT":
				this.PLAYERS[PlayerID].addToHand(new Card(1,7));
				this.PLAYERS[PlayerID].addToHand(new Card(1,6));
				this.PLAYERS[PlayerID].addToHand(new Card(2,8));
				this.PLAYERS[PlayerID].addToHand(new Card(3,9));
				this.PLAYERS[PlayerID].addToHand(new Card(0,10));
				break;
			case "FLUSH":
				this.PLAYERS[PlayerID].addToHand(new Card(1,7));
				this.PLAYERS[PlayerID].addToHand(new Card(1,4));
				this.PLAYERS[PlayerID].addToHand(new Card(1,3));
				this.PLAYERS[PlayerID].addToHand(new Card(1,1));
				this.PLAYERS[PlayerID].addToHand(new Card(1,11));
				break;
			case "TWO_PAIR":
				this.PLAYERS[PlayerID].addToHand(new Card(1,4));
				this.PLAYERS[PlayerID].addToHand(new Card(0,4));
				this.PLAYERS[PlayerID].addToHand(new Card(2,3));
				this.PLAYERS[PlayerID].addToHand(new Card(2,3));
				this.PLAYERS[PlayerID].addToHand(new Card(1,11));
				break;
			case "FOUR_OF_A_KIND":
				this.PLAYERS[PlayerID].addToHand(new Card(0,10));
				this.PLAYERS[PlayerID].addToHand(new Card(1,10));
				this.PLAYERS[PlayerID].addToHand(new Card(2,10));
				this.PLAYERS[PlayerID].addToHand(new Card(3,10));
				this.PLAYERS[PlayerID].addToHand(new Card(2,3));
				break;
			case "THREE_OF_A_KIND":
				this.PLAYERS[PlayerID].addToHand(new Card(0,10));
				this.PLAYERS[PlayerID].addToHand(new Card(1,10));
				this.PLAYERS[PlayerID].addToHand(new Card(2,10));
				this.PLAYERS[PlayerID].addToHand(new Card(3,8));
				this.PLAYERS[PlayerID].addToHand(new Card(2,3));
				break;
			case "HIGH_CARD":
				this.PLAYERS[PlayerID].addToHand(new Card(0,10));
				this.PLAYERS[PlayerID].addToHand(new Card(1,2));
				this.PLAYERS[PlayerID].addToHand(new Card(3,7));
				this.PLAYERS[PlayerID].addToHand(new Card(1,4));
				this.PLAYERS[PlayerID].addToHand(new Card(0,13));
				break;
			default:
				break;
				
		}
	}
	
	/**
	 * Audit every possible case for poker through a variety of hands.
	 * @param verbose Verbose mode for in-depth debugging.
	 */
	
	public void caseAudit(boolean verbose) {
		this.setPlayers(1);
		
		String[] SET_CASES = new String[] { "FULL_HOUSE", "ROYAL_FLUSH", "STRAIGHT_FLUSH", "STRAIGHT", "FLUSH", "TWO_PAIR", "FOUR_OF_A_KIND", "THREE_OF_A_KIND", "HIGH_CARD" };
		
		if (verbose) { this.DEBUG = true; };
		
		for (int i = 0; i < SET_CASES.length; i++) {
			this.PLAYERS[0].getHand().clear();
			this.floodConsoleSpace(3);
			System.out.println("[*] Auditing " + SET_CASES[i] + " -->");
			setCase(0, SET_CASES[i]);
			this.sortHand(0);
			printLoopThroughHand(0);
			
			evaluateHand(0);
		}
	}
	
	/**
	 * @param loops How many times to loop through a game audit.
	 * @param verbose Spit out everything from the debug channel? (true/false)
	 */
	
	public void randomHandIterativeAudit(int loops, boolean verbose) {
		this.setPlayers(2);
		this.PLAYERS[0].setName("Adam");
		this.PLAYERS[1].setName("Johnny");
		this.doGameCompliance(false);
		this.DEAL_NUMBER = 1;
		this.SATISFIED_CASES = new String[this.PLAYERS.length];
		int j = 0;
		
		while (j < loops) {
			j++;
			this.floodConsoleSpace(5);
			System.out.println("[Deck Number >> " + ++this.DECK_NUMBER + " | Round Number >> " + ++this.ROUND_NUMBER + "]");
			while (this.DECK.cardsRemaining() > 0) {	
				for (int i = 0; i < this.PLAYERS.length; i++) {
					System.out.println("\n\n  Deal " + this.DEAL_NUMBER + " --->> ");
					System.out.println("\t" + 
							(this.PLAYERS[i].getName().equalsIgnoreCase("Player") ? ("Player " + (i+1) + " has " + this.PLAYERS[i].getHand().size()) 
							+ " cards >>\n" + this.PLAYERS[i].explicitToStr(): this.PLAYERS[i]) + "\n");	
					this.evaluateHand(i);	
				}
				this.compareHands();				
				DEAL_NUMBER++;

				if (this.DECK.cardsRemaining() < 5*this.PLAYERS.length) {
					break;
				} else {
					for (int i = 0; i < this.PLAYERS.length; i++) {
						this.newPlayerHand(i);
					}
				}	
			}
			this.doGameCompliance(false);
			this.floodConsoleSpace(5);	
			}
		}
}