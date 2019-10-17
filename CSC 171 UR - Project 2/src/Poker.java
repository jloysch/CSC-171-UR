import java.util.Scanner;

public class Poker {
	
	private int ROUND_NUMBER;
	private Scanner SC;
	private DeckOfCards DECK;
	private Player[] PLAYERS;
	private int[] PLAYER_POINTS;
	private boolean GAME_IN_PROGRESS;

	public Poker() {
		
	}
	
	/**
	 * @param p Integer resembling amount of players.
	 */
	
	public void setPlayers(int p) {
		this.PLAYERS = new Player[p];
		this.PLAYER_POINTS = new int[p];
		this.DECK = new DeckOfCards();
		this.populateNewPlayers();
	}
	
	/*
	 * Create the players for the game, initialize their points to zero.
	 */
	
	private void populateNewPlayers() {
		for (int i = 0; i < this.PLAYERS.length; i++) {
			this.PLAYERS[i] = new Player();
			this.PLAYER_POINTS[i] = 0;
		}
	}
	
	/**
	 * @param PlayerID Integer ID of the player in the game. e.g. 0.
	 * @return Returns the Player object at given index (PlayerID).
	 */
	
	public Player getPlayer(int PlayerID) {
		return this.PLAYERS[PlayerID];
	}
	
	/**
	 * @param PlayerID Integer ID of the player in the game. e.g. 0.
	 * @return Returns the name of the player at given index (PlayerID) as String.
	 */
	
	public String getPlayerName(int PlayerID) {
		return this.PLAYERS[PlayerID].getName();
	}
	
	/**
	 * @param PlayerID Integer ID of the player in the game. e.g. 0.
	 * @param Name Assign a players name through this instance of Poker as a String.
	 */
	
	public void setPlayerName(int PlayerID, String Name) {
		this.PLAYERS[PlayerID].setName(Name);
	}
	
	
	
	public void sortHand() { //TODO complete
		
	}
	
	/*
	 * Starts the poker game, interactive with console.
	 */
	
	public void startGame() {
		while (this.GAME_IN_PROGRESS) {
			System.out.println("[Round " + ++this.ROUND_NUMBER + "]\n");
		}
		this.SC.close();
	}
		
	public boolean evaluateHands() { //F for first hand greater, S for second hand greater.
		
		
		return false;
	}
}
