
public class ProjectTwoDriver {
	
	public static void main(String args[]) {
		
		DeckOfCards c = new DeckOfCards();
		
		System.out.println(c);
		
		c.shuffle();
		
		System.out.println("\n\n\nShuffled >> ");
		
		System.out.println(c);
	}

}
