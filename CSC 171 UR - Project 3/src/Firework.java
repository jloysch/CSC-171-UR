import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;

import javax.swing.JComponent;

public class Firework extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Color[] COLORS;
	private Color FIREWORK_COLOR;
	private int EXPLOSION_RADIUS;
	private Point LOCATION = new Point(0,0);
	private boolean EXPLODED, explosionAlphaReset;
	
	private int alphaTracker = 255;
	
	private int timeTracker = 0;
	
	private int initMaxAlphaFromSrc = 0;
	
	private int VELOCITY, FLIGHT_TIME, ANGLE;
	
	private boolean isInThreshold = true, DONE = false, FX = false;
	
	private final boolean DEBUG = false;
	
	private int MAX_X;


	private int MAX_Y;

	
	public Firework() {
		this.populateColors();
		this.FIREWORK_COLOR = this.COLORS[1];
		this.EXPLOSION_RADIUS = 10;
		this.EXPLODED = false;
		this.VELOCITY = 15;
		this.FLIGHT_TIME = 10;
		this.ANGLE = 90;
		this.calculateMax();
	}
	
	public Firework(int colorIndex) {
		this.populateColors();
		this.FIREWORK_COLOR = this.COLORS[colorIndex];
		this.EXPLODED = false;
		this.VELOCITY = 15;
		this.FLIGHT_TIME = 10;
		this.ANGLE = 90;
		this.calculateMax();
	}
	
	public Firework(int colorIndex, int explosionRadius) {
		this.populateColors();
		this.FIREWORK_COLOR = this.COLORS[colorIndex];
		this.EXPLOSION_RADIUS = explosionRadius;
		this.EXPLODED = false;
		this.VELOCITY = 15;
		this.FLIGHT_TIME = 10;
		this.ANGLE = 90;
		this.calculateMax();
		
		//System.out.println(this);
	}
	
	public Firework(int colorIndex, int explosionRadius, int velocity, int flightTime) {
		this.populateColors();
		this.FIREWORK_COLOR = this.COLORS[colorIndex];
		this.EXPLOSION_RADIUS = explosionRadius;
		this.EXPLODED = false;
		this.VELOCITY = velocity;
		this.FLIGHT_TIME = flightTime;
		this.ANGLE = 90;
		this.calculateMax();
		
		//System.out.println(this);
	}
	
	public Firework(Color color, int explosionRadius, int velocity, int flightTime) {
		//this.populateColors();
		this.FIREWORK_COLOR = color;
		this.EXPLOSION_RADIUS = explosionRadius;
		this.EXPLODED = false;
		this.VELOCITY = velocity;
		this.FLIGHT_TIME = flightTime;
		this.ANGLE = 90;
		this.calculateMax();
	}
	
	public Firework(Color color, int explosionRadius, int velocity, int flightTime, int angle) {
		//this.populateColors();
		this.FIREWORK_COLOR = color;
		this.EXPLOSION_RADIUS = explosionRadius;
		this.EXPLODED = false;
		this.VELOCITY = velocity;
		this.FLIGHT_TIME = flightTime;
		this.ANGLE = angle;
		this.calculateMax();
		if (this.DEBUG) { System.out.println(this); }
	}
	
	public void calculateMax() {
		this.calculateMaxX();
		this.calculateMaxY();
	}
	
	public void calculateMaxX() {
		this.MAX_X = (int) (this.VELOCITY * Math.cos(Math.toRadians(this.ANGLE)) * this.FLIGHT_TIME);
	}
	
	public void calculateMaxY() {
		this.MAX_Y = (int) ((this.VELOCITY * Math.sin(Math.toRadians(this.ANGLE)) * this.FLIGHT_TIME) - ((9.8 * Math.pow(this.FLIGHT_TIME, 2)/2)));
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		
		
		if (this.timeTracker < this.FLIGHT_TIME*1000) {
			this.timeTracker+=100;
			
			
			if ((double) ((getHeight()*.5)) < (double) this.LOCATION.y) {
				this.incrementFirework();
			}
			
			
			System.out.println(this.timeTracker + " : " + this.FLIGHT_TIME*1000);
			
			g2d.setColor(Color.WHITE);
			
			g2d.fillRect(this.getLocation().x, this.getLocation().y, 20, 30);
			
			g2d.setColor(Color.RED);
			
			Polygon pg = new Polygon(new int[] {this.getLocation().x-10, this.getLocation().x+9, this.getLocation().x+29}, 
					new int[] {this.getLocation().y, this.getLocation().y-30, this.getLocation().y}, 3);
			
			
			g2d.drawPolygon(pg);
			g2d.fill(pg);
			
			
			//Fancy Fill
			g2d.setStroke(new BasicStroke(3));
			g2d.setColor(Color.RED);
			
			
			for (int i = this.getLocation().y; i < this.getLocation().y+35; i+=5) {
				g2d.drawLine(this.getLocation().x, i, this.getLocation().x+20, i-8);
			}
			
			//System.out.println("Firework >> canvas size = " + getWidth() + " " + getHeight());
			
			//Threshold check
			if (this.DEBUG) { System.out.println(this.getLocation()); }
			if (this.getLocation().y <= (int) (getWidth() - (getWidth()*.80))) {
				this.isInThreshold = false;
			}
			//System.out.println("Threshold : " + (getWidth() - (getWidth()*.20)));
			
		} else if (!this.EXPLODED){
			System.out.println("Out of threshold");
			
			g2d.setColor(new Color(255, 255, 255, this.alphaTracker));
			
			g2d.fillRect(this.getLocation().x, this.getLocation().y, 20, 30);
			
			g2d.setColor(new Color(255, 0, 0, this.alphaTracker));
			
			Polygon pg = new Polygon(new int[] {this.getLocation().x-10, this.getLocation().x+9, this.getLocation().x+29}, 
					new int[] {this.getLocation().y, this.getLocation().y-30, this.getLocation().y}, 3);
			
			
			g2d.drawPolygon(pg);
			g2d.fill(pg);
			
			
			//Fancy Fill
			g2d.setStroke(new BasicStroke(3));
			
			
			
			for (int i = this.getLocation().y; i < this.getLocation().y+35; i+=5) {
				g2d.drawLine(this.getLocation().x, i, this.getLocation().x+20, i-8);
			}
			
			//System.out.println("Firework >> canvas size = " + getWidth() + " " + getHeight());
			
			this.alphaTracker-=15;
			
			if (this.alphaTracker == 0) {
				this.explode(g, g2d);
			}
		} else {
			this.explode(g,g2d);
		}
		
	}
	

	public void explode(Graphics g, Graphics2D g2d) {
		boolean otp = false;
		if (!this.DONE) {
			if (!this.EXPLODED) {
				this.alphaTracker = 0;
				
			} 
			
			if (!this.explosionAlphaReset) {
				this.alphaTracker+=5;
				
				if (this.alphaTracker >= this.initMaxAlphaFromSrc) {
					this.explosionAlphaReset = true;
				}
			} else {
				this.alphaTracker-=5;
			}
			
			if (this.alphaTracker == 0) {
				//this.DONE = true;
				this.alphaTracker = this.initMaxAlphaFromSrc;
			}
			
			
			
			
			//System.out.println("asdasdAnimating explosion");
			this.EXPLODED = true;
			
			if (this.DEBUG) { System.out.println("Exploding with radius " + (int) this.getExplosionRadius()*1.8); }
		
			
			otp = false;
		}
		
		if (!otp) {
			this.alphaTracker = this.initMaxAlphaFromSrc;
		}
		
		if (this.alphaTracker > 1) {
			this.alphaTracker-=1;
		}
		
		
		
		if (this.alphaTracker == 0) {
			this.DONE = true;
			this.EXPLODED = true;
			this.alphaTracker = 255;
			this.doFinalCircle(g2d);
		}
	}
	
	public void doFinalCircle(Graphics2D g2d) {
		
		System.out.println("Doing final circle");
		
		if (!this.FX) {
			this.alphaTracker = this.initMaxAlphaFromSrc;
			System.out.println("Max alpha " + this.initMaxAlphaFromSrc + " : " + this.alphaTracker);
			this.FX = true;
		}
		
			
				this.alphaTracker-=1;
				System.out.println("Max alpha " + this.initMaxAlphaFromSrc + " : " + this.alphaTracker);
				g2d.setColor(new Color(this.FIREWORK_COLOR.getRed(), this.FIREWORK_COLOR.getGreen(), this.FIREWORK_COLOR.getBlue(), this.alphaTracker));
				
				g2d.fillOval(this.getLocation().x-this.getExplosionRadius(), this.getLocation().y-this.getExplosionRadius(), (int) (this.getExplosionRadius()*1.8), 
					(int) (this.getExplosionRadius()*1.8));
				
				if (this.alphaTracker <=5) {
					this.FX = true;
				} 
				
				repaint();
			
			
	
	}
	public void incrementFirework() {
		this.incrementXLocation();
		this.incrementYLocation();
	}
	
	public void incrementXLocation() {
		//this.LOCATION.x+=2;
		this.LOCATION.x += (int) (this.VELOCITY * Math.cos(Math.toRadians(this.ANGLE)) * this.timeTracker/100);
	}
	
	public void incrementYLocation() {
		//this.LOCATION.y-=2;
		this.LOCATION.y += (int) ((this.VELOCITY * Math.sin(Math.toRadians(this.ANGLE)) * timeTracker/100) - ((9.8 * Math.pow(this.timeTracker/100, 2)/2)));
	}
	
	public Firework(Color c) {
		this.populateColors();
		this.FIREWORK_COLOR = this.COLORS[1];
		this.EXPLOSION_RADIUS = 10;
		this.EXPLODED = false;
		this.FIREWORK_COLOR = c;
	}
	
	public void populateColors() {
		this.COLORS = new Color[8];
		this.COLORS[0] = Color.BLACK;
		this.COLORS[1] = Color.RED;
		this.COLORS[2] = Color.BLUE;
		this.COLORS[3] = Color.GREEN;
		this.COLORS[4] = Color.YELLOW;
		this.COLORS[5] = Color.ORANGE;
		this.COLORS[6] = Color.MAGENTA;
		this.COLORS[7] = Color.CYAN;
	}
	
	public String getColorList() {
		String x = "";
		for (int i = 0; i < this.COLORS.length; i++) {
			x+= "[" + i + "] " + this.COLORS[i].toString() + "\n";
		}
		return x;
	}
	
	public void setExplosionRadius(int r) {
		this.EXPLOSION_RADIUS =  r;
	}
	
	
	public boolean isDone() {
		return this.DONE;
	}
	
	public void setColor(Color c) {
		this.FIREWORK_COLOR = c;
		this.initMaxAlphaFromSrc = c.getAlpha();
		
		
		//Fix alpha for good input first.
		
		if (this.DEBUG) { System.out.println("Fixing val from " + this.initMaxAlphaFromSrc); }
		
		this.initMaxAlphaFromSrc -= (this.initMaxAlphaFromSrc%5); 
		if (this.DEBUG) { System.out.println("\tTo " + this.initMaxAlphaFromSrc); }
		this.alphaTracker = this.initMaxAlphaFromSrc;
	}
	
	public boolean isExploded() {
		return this.EXPLODED;
	}

	
	public int getExplosionRadius() {
		return this.EXPLOSION_RADIUS;
	}
	
	public Point getLocation() {
		return this.LOCATION;
	}
	
	public void setLocation(Point p) {
		this.LOCATION = p;
	}
	

	
	public String getColorFromColorIndex(int i) {
		if (i < this.COLORS.length) {
			return this.COLORS[i].toString();
		} else {
			System.out.println(new Exception("INDEX OUT OF BOUNDS\n"
					+ "		[0] = Color.BLACK;\r\n" + 
					"		[1] = Color.RED;\r\n" + 
					"		[2] = Color.BLUE;\r\n" + 
					"		[3] = Color.GREEN;\r\n" + 
					"		[4] = Color.YELLOW;\r\n" + 
					"		[5] = Color.ORANGE;\r\n" + 
					"		[6] = Color.MAGENTA;\r\n" + 
					"		[7] = Color.CYAN;" +
				    "\n\t[*] Your Input i was " + i + " was not between 0 - " + this.COLORS.length + "\n\t** Please check your input."));
			return null;
		}
	}
	
	public void newCanvasSize(int width, int height) {
		setSize(width, height);
	}
	
	@Override
	public String toString() {
		return "[Firework]\n\tExplosion Radius > " + this.EXPLOSION_RADIUS + "ft\n\tVelocity > " + this.VELOCITY + "m/s\n\tFlight Time > " + this.FLIGHT_TIME + "\n\tAngle > " + this.ANGLE + "\n" ;
	}
}
