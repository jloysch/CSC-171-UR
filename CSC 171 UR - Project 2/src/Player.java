
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

	public String getName() {
		return this.NAME;
	}
	
	public Hand getHand() {
		return this.HAND;
	}
}
