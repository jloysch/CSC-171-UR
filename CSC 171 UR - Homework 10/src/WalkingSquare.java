import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class WalkingSquare extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int ANIMATION_DELAY_MS, STEPS;
	private Color DRAWING_COLOR;
	private Dimension SQUARE_DIMS, SCREEN_DIMS, SQUARE_LOC;
	private ScheduledExecutorService SCHEDULER;
	
	public WalkingSquare() {
	     this.ANIMATION_DELAY_MS = 300;
	     this.DRAWING_COLOR = Color.RED;
	     this.SQUARE_DIMS = new Dimension(20,20);
	     this.SCREEN_DIMS = new Dimension();
	     this.SQUARE_LOC = new Dimension(0,0);
	     this.STEPS = 0;
	     
	     addComponentListener(this.resizeListener());
	     //addKeyListener(this);
	     
	     setFocusable(true);
	     
	     
	     setSize(this.SCREEN_DIMS);
	     this.animate();
	   
	}
	
	public Action x() {
		return null;
		
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.updateSquarePlacement();
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(this.DRAWING_COLOR);
        g2.drawRect(this.SQUARE_LOC.width, this.SQUARE_LOC.height, this.SQUARE_DIMS.width, this.SQUARE_DIMS.height);
        g2.fillRect(this.SQUARE_LOC.width, this.SQUARE_LOC.height, this.SQUARE_DIMS.width, this.SQUARE_DIMS.height);
	}
	
	public void updateScreenDims() {
		
		this.SCREEN_DIMS.setSize(getWidth(), getHeight());
    	assertSquareSize();
		//System.out.println(SCREEN_DIMS);
	}
	
	private ComponentAdapter resizeListener() {
		return new ComponentAdapter() {
    	    public void componentResized(ComponentEvent c) {
    	        updateScreenDims();
    	        SQUARE_LOC.setSize(0,0);
    	        repaint();
    	    }
    	};
	}
	
	private void updateSquarePlacement() {
		this.SQUARE_LOC.setSize(++this.STEPS, this.STEPS);
	}
	
	private void assertSquareSize() {
		if (this.SCREEN_DIMS.width == this.SCREEN_DIMS.height) {
			
		} else {
			if (this.SCREEN_DIMS.width > this.SCREEN_DIMS.height) {
				this.SCREEN_DIMS.height += (this.SCREEN_DIMS.height%this.SCREEN_DIMS.width);
			} else {
				this.SCREEN_DIMS.height += (this.SCREEN_DIMS.width%this.SCREEN_DIMS.height);
			}
		}
		setSize(this.SCREEN_DIMS);
		
	
	}
	
	public void animate() {

		this.SCHEDULER = Executors.newSingleThreadScheduledExecutor();


		Runnable task = new Runnable() {
		    public void run() {
		        repaint();
		        
		        if (SQUARE_LOC.width >= SCREEN_DIMS.width || SQUARE_LOC.height >= SCREEN_DIMS.height) {
		        	STEPS = 0;
		        	SQUARE_LOC.setSize(0,0);
		        }
		    }
		};
			
		this.SCHEDULER.scheduleAtFixedRate(task, 20, this.ANIMATION_DELAY_MS, TimeUnit.MILLISECONDS);		
		
	}
	
	public void upDownHandler(boolean up) {
		if (up) {
			if (this.ANIMATION_DELAY_MS > 50) {
			this.ANIMATION_DELAY_MS-=50;
			System.out.println("Increasing speed to " + this.ANIMATION_DELAY_MS + " ms/frame update");
			} else if (this.ANIMATION_DELAY_MS > 5) {
				this.ANIMATION_DELAY_MS-=5;
				System.out.println("Increasing speed to " + this.ANIMATION_DELAY_MS + "ms/frame update");
			} else {
				System.out.println("You can't get any faster than " + this.ANIMATION_DELAY_MS + " ms/frame update");
			}
		} else {
			if (this.ANIMATION_DELAY_MS < 10) {
				this.ANIMATION_DELAY_MS +=5;
				System.out.println("Slowing down to " + this.ANIMATION_DELAY_MS+ "ms/frame update");
			} else {
				this.ANIMATION_DELAY_MS+=10;
				System.out.println("Slowing down to " + this.ANIMATION_DELAY_MS+ "ms/frame update");
			}
		}
		
		this.SCHEDULER.shutdown();
		this.animate();
	}

	/*
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) { //TBC
		System.out.println(e);
		switch (e.getKeyCode()) {
			
			default:
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	*/
}
