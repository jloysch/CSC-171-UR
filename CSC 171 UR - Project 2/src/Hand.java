/**
 * @author Joshua John Reuben Loysch
 * @Version 1.1.1
 * This is intellectual property of Joshua John Reuben Loysch, all rights reserved.
 */

import java.util.ArrayList;

public class Hand {
	
	ArrayList<Card> HAND;
	
	public Hand() {
		this.HAND = new ArrayList<Card>();
	}
	
	/**
	 * 
	 * @param c A card object to be added to this instance of Hand.
	 */
	
	public void add(Card c) {
		this.HAND.add(c);
	}
	
	/**
	 * @param c The card object to be removed from the hand.
	 */
	
	public void discard(Card c) {
		this.HAND.remove(c);
	}
	
	/**
	 * @return The instance of this hand expressed as an ArrayList.
	 */
	
	public ArrayList<Card> toArrayList() {
		return this.HAND;
	}
	
	/**
	 * @return The instance of this hand as a Card object array.
	 */
	
	public Card[] toPrimArray() {
		Card[] tmp = new Card[this.HAND.size()];
		
		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = this.HAND.get(i);
		}
		return tmp;
	}
	
	/**
	 * @param i An Integer for the index in hand at which a card is at.
	 * @return The card at the given index.
	 */
	
	public Card getCardAt(int i) {
		if ((i < 0) | (i > this.HAND.size())) {
			return null;
		} else {
			return this.HAND.get(i);
		}
	}
	
	/**
	 * @return The Cards held within this instance of Hand.
	 */
	
	public ArrayList<Card> getCards() {
		return this.HAND;
	}
	
	
	/**
	 * @return How many cards the player has as an Integer.
	 */
	
	public int size() {
		return this.HAND.size();
	}

}
