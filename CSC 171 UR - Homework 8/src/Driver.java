/*
 * Name: Joshua Loysch
 * NetID: jloysch
 * Assignment Number: Homework Eight
 * Lab Section Day/Time: MW, 2:00-3:15PM
 * 
 * I did not collaborate with anyone on this assignment.
 */

/**
 * @author Joshua John Reuben Loysch
 * @Version 1.0.1r0
 * Intellectual property of Joshua John Reuben Loysch, all rights reserved.
 */

import java.awt.Dimension;

import javax.swing.JFrame;

public class Driver {
	
	public static void main(String args[]) {
		JFrame f = new JFrame();
		f.setSize(new Dimension(1050,600));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new Canvas2());
		f.setTitle("The Fun Canvas");
		
		f.setVisible(true);
		
		
		
	}

}
