import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;


/* -- Don't actually have to make this. ---
 * 
	1. Create an application that allows a user to direct a “robot” around its window. Start
	with the robot (some shape or icon) at the center of the window. The user can enter X
	and Y coordinates and then press a “Go” button to send the robot to that location. Your
	application should animate the robot’s move to the new location. If you like, allow the
	user to set the speed of the robot also, and use that in the animation.
 */

public class Robot extends JPanel implements KeyListener {
	
	private static final long serialVersionUID = 1L;
	
	private JButton GO;
	
	private JTextField DIRECTIONS_INPUT;
	
	private Point ROBOT_LOCATION, DESIRED_LOCATION;

	public Robot() {
		this.GO = new JButton();
		this.GO.setText("GO");
		this.DIRECTIONS_INPUT = new JTextField();
		this.DIRECTIONS_INPUT.setText("(Enter coordinates seperated by a comma or a space)");
		this.setSize(800,800);
		this.setFocusable(true);
		this.addKeyListener(this);
		
		this.GO.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				go();
				
			}
			
		});
		
		this.animate();
	}
	
	public void go() {
		this.animate();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
	}
	
	public void animate() {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
