
public class Player {
	
	private String NAME;
	private Hand HAND;
	
	public Player() {
		this.NAME="Player";//d
		this.HAND = new Hand();
	}
	
	public Player(String name) {
		this.NAME = name;
	}

	public String getName() {
		return this.NAME;
	}
}
