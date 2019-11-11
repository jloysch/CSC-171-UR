import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.Ellipse2D;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;

public class OrbitingSquare extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private Color DRAWING_COLOR;
	
	private Dimension SCREEN_DIMENSIONS, SQUARE_DIMENSIONS;
	
	private Point SQUARE_LOCATION;
	
	private double ORBIT_RADIUS_SCREEN_PERCENTAGE, ORBIT_ANGLE_INCREMENT;
		
	

	public OrbitingSquare() {
		this.DRAWING_COLOR = Color.RED;
		this.SCREEN_DIMENSIONS = new Dimension(0,0);
		
		this.SQUARE_DIMENSIONS = new Dimension(20,20);
		this.ORBIT_RADIUS_SCREEN_PERCENTAGE = .67d;
		this.ORBIT_ANGLE_INCREMENT= 0d;
		
		addComponentListener(this.resizeListener());
		setSize(this.SCREEN_DIMENSIONS);
		repaint();
		this.updateScreenDimensions();
		
		this.animate();
	}
	
	public Shape orbit(double radius) {
		return new Ellipse2D.Double(((this.SCREEN_DIMENSIONS.width - radius)/2.0),
									((this.SCREEN_DIMENSIONS.height - radius)/2.0),
									(radius),
									(radius));
	}
	
	public Rectangle square() {
		return new Rectangle(this.SQUARE_LOCATION.x, this.SQUARE_LOCATION.y, this.SQUARE_DIMENSIONS.width, this.SQUARE_DIMENSIONS.height);
	}
	
	private Point getSquareLocation() {
		return this.SQUARE_LOCATION;
	}
	
	public double getRadius() {
		return this.ORBIT_RADIUS_SCREEN_PERCENTAGE
		* (this.SCREEN_DIMENSIONS.width > this.SCREEN_DIMENSIONS.height ? this.SCREEN_DIMENSIONS.height : this.SCREEN_DIMENSIONS.width);
	}
	
	private ComponentAdapter resizeListener() {
		return new ComponentAdapter() {
    	    public void componentResized(ComponentEvent c) {
    	        updateScreenDimensions();
    	        
    	        repaint();
    	    }
    	};
	}
	
	private Point getCenterOfScreen() {
		return new Point(this.SCREEN_DIMENSIONS.width/2, this.SCREEN_DIMENSIONS.height/2);
	}
	
	private void updateScreenDimensions() {
		
		this.SCREEN_DIMENSIONS.setSize(getWidth(), getHeight());
		System.out.println("[*] Screen Dimensions >> " + "(" + this.SCREEN_DIMENSIONS + ")");
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(this.DRAWING_COLOR);
        
        g2.draw(this.orbit(this.getRadius()));
        
        Rectangle r = this.square();
        
        
        if ((int) this.ORBIT_ANGLE_INCREMENT >= 45 && this.ORBIT_ANGLE_INCREMENT <= 90) {
        	//System.out.println("ROTATING 45 | MOD REMAIN > " + this.ORBIT_ANGLE_INCREMENT%45);
        	System.out.println(" 45 < ANGLE < 90");
        	g2.rotate(Math.toRadians(45), getSquareLocation().x, getSquareLocation().y+this.SQUARE_DIMENSIONS.height/2);//
        } else if ((int) this.ORBIT_ANGLE_INCREMENT >= 135 && this.ORBIT_ANGLE_INCREMENT <= 180) {
        	System.out.println(" 135 < ANGLE < 180");
        	g2.rotate(Math.toRadians(45), getSquareLocation().x + this.SQUARE_DIMENSIONS.width/2, getSquareLocation().y);
        } else if ((int) this.ORBIT_ANGLE_INCREMENT >= 225 && this.ORBIT_ANGLE_INCREMENT <= 270) {
        	System.out.println(" 225 < ANGLE < 270");
        	g2.rotate(Math.toRadians(-45), getSquareLocation().x, getSquareLocation().y);
        } else if ((int) this.ORBIT_ANGLE_INCREMENT > 315 && this.ORBIT_ANGLE_INCREMENT <= 360) {
        	System.out.println(" 270 < ANGLE < 315");
        	g2.rotate(Math.toRadians(-45), getSquareLocation().x, getSquareLocation().y+10+this.SQUARE_DIMENSIONS.height/2);//
        }
        
        
        if (this.ORBIT_ANGLE_INCREMENT == 360) {
        	this.ORBIT_ANGLE_INCREMENT = 0;
        }
       
        g2.draw(r);
        g2.fill(r);
        
        g2.setTransform(g2.getTransform());
        
        
        //System.out.println("[*] Frame Update");
	}
	
	public void rotateSquare() {
		
	}
	
	public void advanceSquare() {
		/*System.out.println("[*] Advancing square to (" + ((int) Math.cos(Math.toRadians(this.ORBIT_ANGLE_INCREMENT)) 
							+ ", " + ((int) Math.sin(Math.toRadians(this.ORBIT_ANGLE_INCREMENT)) + ")"
							+ " @ " + (Math.toRadians(this.ORBIT_ANGLE_INCREMENT)) + " radians.")));*/
		
		this.SQUARE_LOCATION.x = ((int) (Math.sin(Math.toRadians((double) this.ORBIT_ANGLE_INCREMENT)) * (this.getRadius()/2))) + this.getCenterOfScreen().x - this.SQUARE_DIMENSIONS.width/2;
		this.SQUARE_LOCATION.y = ((int) (Math.cos(Math.toRadians((double) this.ORBIT_ANGLE_INCREMENT)) * (this.getRadius()/2))) + this.getCenterOfScreen().y - this.SQUARE_DIMENSIONS.height/2;
		this.ORBIT_ANGLE_INCREMENT++;
	}
	
	public void postSquareLocation() {
		System.out.println("[*] Square Located at (" + this.SQUARE_LOCATION.x + ", " + this.SQUARE_LOCATION.y + ") | Angle @" + this.ORBIT_ANGLE_INCREMENT);
	}
	
	public void animate() {
		ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

		Runnable task = new Runnable() {
			int t = 0;
		    public void run() {
		    	if (++t == 1) {
		    		System.out.println("t is 0");
		    		SQUARE_LOCATION = new Point((int) (getCenterOfScreen().x + getRadius()), (int) (getCenterOfScreen().y + getRadius())) ;
		    	}
		        repaint();
		        advanceSquare();
		        //postSquareLocation();
		       
		    }
		};
			
		scheduler.scheduleAtFixedRate(task, 0, 10, TimeUnit.MILLISECONDS);		
		
	}
	
	
	
	
	/*
	 *  x = r cos(Θ) y = r sin(Θ)
	 */

}
