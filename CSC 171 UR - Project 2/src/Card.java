import java.util.concurrent.ThreadLocalRandom;

public class Card {
	
	private int RANK;
	private String SUIT;
	private String[] SUITS = new String[] {"Spades","Diamonds","Clubs","Hearts"};
	
	public Card() { //TODO Decide between random() from Math, or ThreadLocalRandom | Just build a random card.
		this.RANK = ThreadLocalRandom.current().nextInt(1, 13 + 1); 
		this.SUIT = SUITS[ThreadLocalRandom.current().nextInt(0, 3 + 1)];
	}
	
	public Card(int suit, int rank) { //Build regular deck.
		this.RANK = rank;
		this.SUIT = this.SUITS[suit];
	}
	
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
	
	public String getSuit() {
		return this.SUIT;
	}
	
	public int getIntRank() {
		return this.RANK;
	}
	
	@Override
	public String toString() {
		return this.getRank() + " of " + this.SUIT;
	}

}
