/**
 * @author Joshua John Reuben Loysch
 * @Version 1.2.2r0
 * This is intellectual property of Joshua John Reuben Loysch, all rights reserved.
 */

import java.util.ArrayList;
import java.util.Collections;

public class DeckOfCards {
	
	private ArrayList<Card> DECK;
	
	/**
	 * Default constructor yields a standard in-order deck with 52 cards.
	 */
	
	public DeckOfCards() {
		this.DECK = new ArrayList<Card>();
		
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < 14; j++) {
				this.DECK.add(new Card(i,j));
			}
		}
	}
	
	/**
	 * @param specificDeck An ArrayList comprised of Card objects that you wish for this deck to be made of.
	 */
	public DeckOfCards(ArrayList<Card> specificDeck) {
		this.DECK = specificDeck;
	}
	
	/**
	 * Shuffles this instance of DeckOfCards.
	 */
	
	public void shuffle() {
		Collections.shuffle(this.DECK);
	}
	
	/**
	 * @return Returns a random Card object from the deck, *Preserves deck.
	 */
	
	public Card getRandomCard() {
		return this.DECK.get(((int) (this.DECK.size()*Math.random())));
	}
	
	/**
	 * @param POP Boolean True of False for preservation of the DeckOfCards, True to Destroy after dealing and false to preserve the DeckOfCards.
	 * @return A Card object that's at the back-most index. (Imagine dealing from the deck face-down on the table.)
	 */
	
	public Card dealCard(boolean POP) {
		Card TEMP_CARD;
		
		if (POP) {
			if ((this.DECK.size() > 2)) {
				TEMP_CARD = this.DECK.get(this.DECK.size()-1);
				DECK.remove(this.DECK.size()-1);
				
				return TEMP_CARD;
			} else { //Is there more than one card?
				TEMP_CARD = this.DECK.get(0);
				this.DECK.remove(0);
				return TEMP_CARD;
			}
			
			
		} else {
			return this.getRandomCard();
		}
	}
	
	public void discard(Card c) {
		this.DECK.remove(c);
	}
	
	public void discardFromIndex(int i) {
		this.DECK.remove(i);
	}
	
	/**
	 * @return How many cards remain in the Deck of Cards.
	 */
	
	public int cardsRemaining() {
		return this.DECK.size();
	}
	
	public ArrayList<Card> toArray() {
		return this.DECK;
	}
	
	public Card[] toPrimArray() {
		Card[] tmp = new Card[this.DECK.size()];
		for (int i = 0; i < this.DECK.size(); i++) {
			tmp[i] = this.DECK.get(i);
		}
		return tmp;
	}
	
	@Override
	public String toString() {
		String str = "";
		
		for (int i = 0; i < this.DECK.size(); i++) {
			str += this.DECK.get(i) + "\n";
		}
		
		return str;
	}
}
