import java.util.ArrayList;
import java.util.Collections;

public class DeckOfCards {
	
	private ArrayList<Card> DECK;
	
	public DeckOfCards() {
		this.DECK = new ArrayList<Card>();
		
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < 14; j++) {
				this.DECK.add(new Card(i,j));
			}
		}
	}
	
	public DeckOfCards(ArrayList<Card> specificDeck) {
		this.DECK = specificDeck;
	}
	
	public void shuffle() {
		Collections.shuffle(this.DECK);
	}
	
	public Card getRandomCard() {
		return this.DECK.get(((int) (52*Math.random())));
	}
	
	public Card dealCard(boolean POP) {
		Card TEMP_CARD;
		
		if (POP) {
			
			if (!(this.DECK.size() == 1)) {
				TEMP_CARD = this.DECK.get(this.DECK.size()-1);
				DECK.remove(this.DECK.size()-1);
				
				return TEMP_CARD;
			} else {
				TEMP_CARD = this.DECK.get(0);
				this.DECK.remove(0);
				return TEMP_CARD;
			}
			
			
		} else {
			return this.getRandomCard();
		}
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
