import java.util.Scanner;

//import java.util.HashMap;

public class Poker {
	
	private int ROUND_NUMBER;
	private Scanner SC;
	private DeckOfCards DECK;
	private Player[] PLAYERS;
	private int[] PLAYER_POINTS;
	private boolean GAME_IN_PROGRESS;


	public Poker() {
		
	}
	
	public void setPlayers(int p) {
		this.PLAYERS = new Player[p];
		this.PLAYER_POINTS = new int[p];
		this.DECK = new DeckOfCards();
		this.populateNewPlayers();
	}
	
	private void populateNewPlayers() {
		for (int i = 0; i < this.PLAYERS.length; i++) {
			this.PLAYERS[i] = new Player();
			this.PLAYER_POINTS[i] = 0;
		}
	}
	
	public Player getPlayer(int PlayerID) {
		return this.PLAYERS[PlayerID];
	}
	
	public String getPlayerName(int PlayerID) {
		return this.PLAYERS[PlayerID].getName();
	}
	
	public void setPlayerName(int PlayerID, String Name) {
		this.PLAYERS[PlayerID].setName(Name);
	}
	
	
	
	public void sortHand() {
		
	}
	
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
