import javax.swing.JFrame;

public class Driver {
	public static void main(String args[]) {
		
		JFrame a = new JFrame();
		a.add(new WalkingSquare());
		a.setTitle("The Happy Walking Square");
		a.setSize(500,500);
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		a.setVisible(true);
	}
}
