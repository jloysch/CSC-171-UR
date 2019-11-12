import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Driver {
	
	private static JFrame a;
	
	private static void swapPanel(int index) {
		a.removeAll();
		switch (index) {
			case 1:				

				
	
				a.add(new WalkingSquare());
				break;
			case 2:
				a.add(new OrbitingSquare());
				break;
				
				
			case 3:
				
					
					a.add(new ScreenSaver());
					break;
				
				
			default:
				break;
		}
		
		
		a.revalidate();
		a.repaint();
		
	}
	
	public static void main(String args[]) {
		
	    a = new JFrame();
		a.add(new WalkingSquare());
		a.setTitle("The Happy Times");
		a.setSize(800,800);
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		KeyListener listener = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println(e);
				switch (e.getKeyCode()) {
					
				case KeyEvent.VK_1:
					swapPanel(1);
					break;
				case KeyEvent.VK_2:
					swapPanel(2);
					break;
				case KeyEvent.VK_3:
					swapPanel(3);
					break;
				default:
					break;
				}
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			};
			
			
			a.addKeyListener(listener);
			a.setFocusable(true);
			a.setVisible(true);
	}
}
