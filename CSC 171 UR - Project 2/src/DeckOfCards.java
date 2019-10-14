import java.util.ArrayList;
import java.util.Arrays;
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
	
	public void shuffle() {//d
		Collections.shuffle(Arrays.asList(this.DECK));
	}
	
	public Card getRandomCard() {
		return this.DECK.get(((int) (52*Math.random())));
	}
	
	public Card dealCard(boolean POP) {
		if (POP) {
			int INDEX = (int) (52*Math.random());
			Card TEMP_CARD = this.DECK.get(INDEX);
			DECK.remove(INDEX);
			
			return TEMP_CARD;
			
		} else {
			return this.getRandomCard();
		}
	}
	
	@Override
	public String toString() {
		String str = "";
		
		for (int i = 0; i < 52; i++) {
			str += this.DECK.get(i) + "\n";
		}
		return str;
	}
}
