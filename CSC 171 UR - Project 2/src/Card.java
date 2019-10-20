/**
 * @author Joshua John Reuben Loysch
 * @Version 1.2.1r0
 * Intellectual property of Joshua John Reuben Loysch, all rights reserved.
 */

import java.util.concurrent.ThreadLocalRandom;

public class Card implements Comparable <Card> {
	
	private int RANK;
	private String SUIT;
	private String[] SUITS = new String[] {"Spades","Diamonds","Clubs","Hearts"};
	
	/**
	 * Default constructor.
	 */
	
	public Card() { //TODO Decide between random() from Math, or ThreadLocalRandom | Just build a random card.
		this.RANK = ThreadLocalRandom.current().nextInt(1, 13 + 1); 
		this.SUIT = SUITS[ThreadLocalRandom.current().nextInt(0, 3 + 1)];
	}
	
	/**
	 * @param suit The suit of the card you wish to create as Integer (0-3 inclusive | 0 = Spades, 1 = Diamonds, 2 = Clubs, 3 = Hearts | Out-of-bounds argument will yield Spades.)
	 * @param rank The rank of the card you wish to create as Integer. (1-13 inclusive | 1 = Ace, (2-10 = the value), 11 = Jack, 12 = Queen, 13 = King | Out-of-bounds argument will yield the passed face-value.)
	 */
	
	public Card(int suit, int rank) { //Build regular deck.
		this.RANK = rank;
		this.SUIT = this.SUITS[suit];
	}
	
	/**
	 * @param suit The suit of the card you wish to create as a String, first letter or full name, ignoring case. ([diamonds == Diamonds] == [Dd])
	 * @param rank The rank of the card you wish to create as Integer. (1-13 inclusive | 1 = Ace, (2-10 = the value), 11 = Jack, 12 = Queen, 13 = King)
	 */
	
	public Card(String suit, int rank) { //Build regular deck.
		this.RANK = rank;
		this.SUIT = this.SUITS[this.toSuitIndex(suit)];
	}
	
	/**
	 * @return A String denoting the 'rank' of the card. (e.g. if the Integer value is 1, this will return "Ace")
	 */
	
	public String getRank() {
		switch (this.RANK) {
			case 1:
				return "Ace";
			case 11:
				return "Jack";
			case 12:
				return "Queen";
			case 13:
				return "King";
			default:
				return String.valueOf(this.RANK);
		}
	}
	
	/**
	 * @param suit String of the card wished to be created.
	 * @return Integer value of the corresponding suit.
	 */
	
	private int toSuitIndex(String suit) {
		switch (suit.toUpperCase()) {
			case "SPADES":
				return 0;
			case "DIAMONDS":
				return 1;
			case "CLUBS":
				return 2;
			case "HEARTS":
				return 3;
			default:
				return 0;
		}
	}
	
	/**
	 * @return String denoting the current Card's suit.
	 */
	
	public String getSuit() {
		return this.SUIT;
	}
	
	/**
	 * @return Integer denoting the current Card's rank. (Ace = 1, Jack = 11, etc.)
	 */
	
	public int getIntRank() {
		return this.RANK;
	}
	 
	/**
	 * @param c The other instance of Card to be compared to the other instance of Card.
	 * @return Integer in compliance with compareTo convention. (0 if they're equal, -1 if the passed card is greater, 1 if the passed card is less)
	 */
	
	@Override
	public int compareTo(Card c) { 
		return (this.getIntRank() == c.getIntRank())&&(this.getSuit().equalsIgnoreCase(c.getSuit())) ? 0 : (this.getIntRank() < c.getIntRank()) ? -1 : 1; 
	}
	
	/**
	 * @return This Card instance's Rank and Suit as a String. (e.g. "Ace of Spades");
	 */
	
	@Override
	public String toString() {
		return this.getRank() + " of " + this.SUIT;
	}

}
