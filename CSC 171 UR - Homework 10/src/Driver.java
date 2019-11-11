import javax.swing.JFrame;

public class Driver {
	public static void main(String args[]) {
		
		JFrame a = new JFrame();
		a.add(new ScreenSaver());
		a.setTitle("The Happy Times");
		a.setSize(800,800);
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		a.setVisible(true);
	}
}
