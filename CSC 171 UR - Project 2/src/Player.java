
public class Player {
	
	private String NAME;
	private Hand HAND;
	
	public Player() {
		this.NAME="Player";
		this.HAND = new Hand();
	}
	
	public Player(String name) {
		this.NAME = name;
	}
	
	public void setName(String name) {
		this.NAME = name;
	}

	public void addToHand(Card c) {
		this.HAND.add(c);
	}
	
	public String getName() {
		return this.NAME;
	}
	
	public Hand getHand() {
		return this.HAND;
	}
	
	@Override
	public String toString() {
		String str = "";
		str+= this.NAME + " has " + this.HAND.size() + " cards >>\n";
		
		for (int i = 0; i < this.HAND.size(); i++) {
			str+="[Card " + (i+1) +"] " + this.HAND.getCardAt(i) + "\n";
		}
		return str;
	}
}
