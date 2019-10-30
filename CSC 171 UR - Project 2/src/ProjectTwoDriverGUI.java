/**
 * @author Joshua John Reuben Loysch
 * @Version 1.1.0a0
 * Intellectual property of Joshua John Reuben Loysch, all rights reserved.
 */

//----- Incomplete ----- DO NOT USE -----

public class ProjectTwoDriverGUI implements Runnable {

	GUI gui = new GUI();
	
	public static void main(String args[]) {
		new Thread( new ProjectTwoDriverGUI()).start();
	}

	@Override
	public void run() {
		boolean PLAY = true;
		
		while (PLAY) {
			gui.repaint();
		}
		
		// TODO Auto-generated method stub
		
	}
}
