import javax.swing.JFrame;

public class GUI extends JFrame {

	private static final long serialVersionUID = -6180697778066189149L;
	
	private String GAME_TYPE;
	
	public GUI() {
		this.GAME_TYPE = null;
	}
	
	public GUI(String game) {
		switch (game.toUpperCase()) {
			case "POKER":
				this.GAME_TYPE = "POKER";
				break;
			case "BLACKBACK":
				this.GAME_TYPE = "BLACKJACK";
				break;
			default:
				this.GAME_TYPE = null;
		}
		
	}
	
	public void buildGame() {
		switch (this.GAME_TYPE) {
		case "POKER":
			this.doPoker();
			break;
		case "BLACKJACK":
			this.doBlackjack();
			break;
		default:
			break;
		}
	}
	
	public void doPoker() {
		//Poker POKER = new Poker();
		boolean PLAY = true;
		
		while (PLAY) {
			
		}
		
		
	}
	
	public void doBlackjack() {
		
	}

	public void repaint() {
		
	}


}
