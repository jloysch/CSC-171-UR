import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Driver {
	
	private static KeyListener listener;
	private static JFrame a;
	private static JPanel[] PANELS = new JPanel[3];
	private static int ACTIVE_PANEL;
	
	private static void swapPanel(int index) {
		a.getContentPane().removeAll();
		switch (index) {
			case 1:			
				a.getContentPane().add(PANELS[0]);
				a.setTitle("Homework 8 | The Happy Walking Square");
				ACTIVE_PANEL=1;
				break;
			case 2:
				a.getContentPane().add(PANELS[1]);
				a.setTitle("Homework 8 | The Happy Orbiting Square");
				ACTIVE_PANEL=2;
				break;
			case 3:
				a.getContentPane().add(PANELS[2]);
				a.setTitle("Homework 8 | The Happy Screen Saver");
				ACTIVE_PANEL=3;
				break;	
			default:
				break;
		}

		a.revalidate();
		a.repaint();
	}
	
	public static int getCurrentPanel() {
		return ACTIVE_PANEL;
	}
	
	public static void sendUpDown(boolean up) {
		switch (ACTIVE_PANEL) {
			case 1:
				((WalkingSquare) PANELS[ACTIVE_PANEL-1]).upDownHandler(up);
				break;
			case 2:
				((OrbitingSquare) PANELS[ACTIVE_PANEL-1]).upDownHandler(up);
				break;
			case 3:
				((ScreenSaver) PANELS[ACTIVE_PANEL-1]).upDownHandler(up);
				break;
			default:
				break;
		}
		
	}
	
	public static void main(String args[]) {
		
	    a = new JFrame();
	    
	    PANELS[0] = new WalkingSquare();
	    PANELS[1] = new OrbitingSquare();
	    PANELS[2] = new ScreenSaver();
	    
	   
	    a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    a.setSize(800,800);
	    a.setVisible(true);
	    swapPanel(1);
	    
	    listener = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				
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
				case KeyEvent.VK_UP:
					sendUpDown(true);
					break;
				case KeyEvent.VK_DOWN:
					sendUpDown(false);
					break;
				case KeyEvent.VK_SPACE:
					
						((OrbitingSquare) PANELS[1]).reset();
					
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
