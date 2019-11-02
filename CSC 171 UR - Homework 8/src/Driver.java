import java.awt.Dimension;

import javax.swing.JFrame;

public class Driver {
	
	public static void main(String args[]) {
		JFrame f = new JFrame();
		f.setSize(new Dimension(1050,600));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new Canvas());
		f.setTitle("The Fun Canvas");
		
		f.setVisible(true);
		
		
		
	}

}
