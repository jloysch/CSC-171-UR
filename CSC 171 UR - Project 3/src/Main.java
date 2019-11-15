import javax.swing.JFrame;

public class Main {
	
	public static void main(String args[]) {
		JFrame jf = new JFrame();
		jf.setTitle("jloysch - Fireworks Display");
		jf.setSize(1000,800);
		
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(new FireworkCanvas());
		jf.setVisible(true);
	}
}
