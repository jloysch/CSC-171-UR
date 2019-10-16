import java.util.ArrayList;

public class Hand {
	
	ArrayList<Card> HAND;
	
	public Hand() {
		this.HAND = new ArrayList<Card>();
	}
	
	public void add(Card c) {
		this.HAND.add(c);
	}
	
	public void discard(Card c) {
		this.HAND.remove(c);
	}
	
	public ArrayList<Card> toArrayList() {
		return this.HAND;
	}
	
	public Card[] toPrimArray() {
		Card[] tmp = new Card[this.HAND.size()];
		
		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = this.HAND.get(i);
		}
		return tmp;
	}
	
	
	public int size() {
		return this.HAND.size();
	}

}
