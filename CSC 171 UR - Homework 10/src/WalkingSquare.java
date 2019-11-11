import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class WalkingSquare extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Timer TIMER;
	private int ANIMATION_DELAY_MS, STEPS;
	private Color DRAWING_COLOR;
	private Dimension SQUARE_DIMS, SCREEN_DIMS, SQUARE_LOC;
	
	
	public WalkingSquare() {
		 this.TIMER = new Timer();
	     this.ANIMATION_DELAY_MS = 300;
	     this.DRAWING_COLOR = Color.RED;
	     this.SQUARE_DIMS = new Dimension(20,20);
	     this.SCREEN_DIMS = new Dimension();
	     this.SQUARE_LOC = new Dimension(0,0);
	     this.STEPS = 0;
	     addComponentListener(this.resizeListener());
	     setSize(this.SCREEN_DIMS);
	     this.animate();
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		
		super.paintComponent(g);
		this.updateSquarePlacement();
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(this.DRAWING_COLOR);
        g2.drawRect(this.SQUARE_LOC.width, this.SQUARE_LOC.height, this.SQUARE_DIMS.width, this.SQUARE_DIMS.height);
        g2.fillRect(this.SQUARE_LOC.width, this.SQUARE_LOC.height, this.SQUARE_DIMS.width, this.SQUARE_DIMS.height);
        //System.out.println("Drew rect at " + this.SQUARE_LOC.toString());

	}
	
	public void updateScreenDims() {
		
		this.SCREEN_DIMS.setSize(getWidth(), getHeight());
    	assertSquareSize();
		System.out.println(SCREEN_DIMS);
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

		ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();


		Runnable task = new Runnable() {
		    public void run() {
		        repaint();
		        
		        if (SQUARE_LOC.width >= SCREEN_DIMS.width || SQUARE_LOC.height >= SCREEN_DIMS.height) {
		        	STEPS = 0;
		        	SQUARE_LOC.setSize(0,0);
		        }
		    }
		};
			
		scheduler.scheduleAtFixedRate(task, 20, 1, TimeUnit.MILLISECONDS);		
		
	}
	

}
