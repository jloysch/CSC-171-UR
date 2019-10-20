/**
 * @author Joshua John Reuben Loysch
 * @Version 1.2.1r0
 * Intellectual property of Joshua John Reuben Loysch, all rights reserved.
 */

public class Player {
	
	private String NAME;
	private Hand HAND;
	
	/**
	 * Default constructor.
	 */
	
	public Player() {
		this.NAME="Player";
		this.HAND = new Hand();
	}
	
	/**
	 * @param name	A name for the player.
	 */
	
	public Player(String name) {
		this.NAME = name;
		this.HAND = new Hand();
	}
	
	/**
	 * @param name Assign a String name to the player.
	 * @param hand Assign a Hand to the player.
	 */
	
	public Player(String name, Hand hand) {
		this.NAME="Player";
		this.HAND = new Hand();
	}
	
	/**
	 * @param name Assign a String name to the player.
	 */
	
	public void setName(String name) {
		this.NAME = name;
	}
	
	/**
	 * @param c	Add a Card object to the players hand.
	 */
	
	public void addToHand(Card c) {
		this.HAND.add(c);
	}
	
	/**
	 * @return This player's name as a String.
	 */
	
	public String getName() {
		return this.NAME;
	}
	
	/**
	 * @return This player's Hand object.
	 */
	
	public Hand getHand() {
		return this.HAND;
	}
	
	/**
	 * @return The toString of this Player object without the header. (Just the cards within)
	 */
	
	public String explicitToStr() {
		String str = "";
		
		for (int i = 0; i < this.HAND.size(); i++) {
			str+="\t[Card " + (i+1) +"] " + this.HAND.getCardAt(i) + "\n";
		}
		return str;
	}
	
	/**
	 * @return Formatted String describing the player, and their Hand.
	 */
	
	@Override
	public String toString() {
		String str = "";
		str+= this.NAME + " has " + this.HAND.size() + " cards >>\n";
		
		for (int i = 0; i < this.HAND.size(); i++) {
			str+="\t[Card " + (i+1) +"] " + this.HAND.getCardAt(i) + "\n";
		}
		return str;
	}
}
