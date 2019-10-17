
public class ProjectTwoDriver {
	
	public static void main(String args[]) {
		
		DeckOfCards cards = new DeckOfCards();
		Player player1 = new Player();
		Player player2 = new Player();
		
		System.out.println(cards);
		
		cards.shuffle();
		
		System.out.println("\n\n\nShuffled >> ");
		
		System.out.println(cards);
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 5; j++) {
				player1.addToHand(cards.dealCard(true));
				player2.addToHand(cards.dealCard(true));
			}
		}
		
		System.out.println("Player one toString >>\n" + player1 + "\n\nPlayer two toString >>\n" + player2);
		System.out.println("Deck after pops >>\n" + cards);
	}

}
