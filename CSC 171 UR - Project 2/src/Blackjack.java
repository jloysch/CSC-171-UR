/**
 * @author Joshua John Reuben Loysch
 * @Version 1.2.1a0
 * Intellectual property of Joshua John Reuben Loysch, all rights reserved.
 */

//----- Incomplete ----- DO NOT USE -----

import java.util.Scanner;

public class Blackjack {
	
	private int ROUND_NUMBER;
	private Scanner SC;
	private DeckOfCards DECK;
	private Player[] PLAYERS;
	private boolean GAME_IN_PROGRESS;
	
	public Blackjack() {
		this.ROUND_NUMBER = 0;
		this.SC = new Scanner(System.in);
		this.PLAYERS = new Player[2];
		this.populateNewPlayers();
		this.DECK = new DeckOfCards();
		this.DECK.shuffle();
		this.GAME_IN_PROGRESS = true;
	}
	
	public void setPlayers(int p) {
		this.PLAYERS = new Player[p];
		this.populateNewPlayers();
	}
	
	private void populateNewPlayers() {
		for (int i = 0; i < this.PLAYERS.length; i++) {
			this.PLAYERS[i] = new Player();
		}
	}
	
	public Player getPlayer(int PlayerID) {
		return this.PLAYERS[PlayerID];
	}
	
	public void setPlayerName(int PlayerID, String Name) {
		this.PLAYERS[PlayerID].setName(Name);
	}
	
	public void start() { //TODO Finish as a fun personal side project & Push to GIT
		while (this.GAME_IN_PROGRESS) {
			System.out.println("[Round " + ++this.ROUND_NUMBER + "]\n");
			
		}
		this.SC.close();
	}

}
