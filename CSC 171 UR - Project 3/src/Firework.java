import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JComponent;

public class Firework extends JComponent {

	
	private static final long serialVersionUID = 1L;
	
	private boolean hasPeaked = false, exploded = false, hasFaded = false, doingFX = false, fireworkDone = false;
	private boolean enforceXBounds = true;
	private boolean DEBUG = true;
	private boolean alphaZeroed = false, alphaApproaching = false, alphaLeaving = false, inExplosionPhase = false;
	
	private Color EXPLOSION_COLOR;
	private Color[] COLORS;
	
	private int EXPLOSION_RADIUS;
	private int timeTracker = 0;
	private int initMaxAlphaFromSrc = 0;
	private int VELOCITY, FLIGHT_TIME, ANGLE;
	private int MAX_X, MAX_Y;
	
	private final double radiusExplosionScaler = 2.2;
	
	private final int MATH_FUNCTION_SCALE_X = 1; //Each y and x modification will be divided by this in an effort to scale the canvas.
	private final int MATH_FUNCTION_SCALE_Y = 1; //Each y and x modification will be divided by this in an effort to scale the canvas. 1= no scaling
	
	private double alphaTracker = 255;
	
	private Point LOCATION = new Point(0,0);
	
	public Firework() {
		this.populateColors();
		this.EXPLOSION_COLOR = this.COLORS[1];
		this.EXPLOSION_RADIUS = 10;
		this.VELOCITY = 15;
		this.FLIGHT_TIME = 10;
		this.ANGLE = 90;
		this.calculateMax();
		
		if (Main.MASTER_DEBUG) {
			this.DEBUG = true;
		}
	}
	
	public Firework(int colorIndex) {
		this.populateColors();
		this.EXPLOSION_COLOR = this.COLORS[colorIndex];
		this.VELOCITY = 15;
		this.FLIGHT_TIME = 10;
		this.ANGLE = 90;
		this.calculateMax();
		
		if (Main.MASTER_DEBUG) {
			this.DEBUG = true;
		}
	}
	
	public Firework(int colorIndex, int explosionRadius) {
		this.populateColors();
		this.EXPLOSION_COLOR = this.COLORS[colorIndex];
		this.EXPLOSION_RADIUS = explosionRadius;
		this.VELOCITY = 15;
		this.FLIGHT_TIME = 10;
		this.ANGLE = 90;
		this.calculateMax();
		
		if (Main.MASTER_DEBUG) {
			this.DEBUG = true;
		}
	}
	
	public Firework(int colorIndex, int explosionRadius, int velocity, int flightTime) {
		this.populateColors();
		this.EXPLOSION_COLOR = this.COLORS[colorIndex];
		this.EXPLOSION_RADIUS = explosionRadius;
		this.VELOCITY = velocity;
		this.FLIGHT_TIME = flightTime;
		this.ANGLE = 90;
		this.calculateMax();
		
		if (Main.MASTER_DEBUG) {
			this.DEBUG = true;
		}
	}
	
	public Firework(Color color, int explosionRadius, int velocity, int flightTime) {
		this.EXPLOSION_COLOR = color;
		this.EXPLOSION_RADIUS = explosionRadius;
		this.VELOCITY = velocity;
		this.FLIGHT_TIME = flightTime;
		this.ANGLE = 90;
		this.calculateMax();
		
		if (Main.MASTER_DEBUG) {
			this.DEBUG = true;
		}
	}
	
	public Firework(Color color, int explosionRadius, int velocity, int flightTime, int angle) {
		this.EXPLOSION_COLOR = color;
		this.EXPLOSION_RADIUS = explosionRadius;
		this.VELOCITY = velocity;
		this.FLIGHT_TIME = flightTime;
		this.ANGLE = angle;
		this.calculateMax();
		if (this.DEBUG) { System.out.println(this); }
		
		if (Main.MASTER_DEBUG) {
			this.DEBUG = true;
		}
	}
	
	public void setInitMaxAlpha(int initMaxAlpha) {
		this.initMaxAlphaFromSrc = initMaxAlpha;
	}
	
	public int getExplosionRadius() {
		return this.EXPLOSION_RADIUS;
	}
	
	public Point getLocation() {
		return this.LOCATION;
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
		return (this.fireworkDone);
	}
	
	public void setColor(Color c) {
		this.EXPLOSION_COLOR = c;
		this.initMaxAlphaFromSrc = c.getAlpha();
		
		
		//Fix alpha for good input first.
		
		if (this.DEBUG) { System.out.println("Fixing val from " + this.initMaxAlphaFromSrc); }
		
		this.initMaxAlphaFromSrc -= (this.initMaxAlphaFromSrc%5); 
		if (this.DEBUG) { System.out.println("\tTo " + this.initMaxAlphaFromSrc); }
		this.alphaTracker = (double) this.initMaxAlphaFromSrc;
	}
	
	public boolean isExploded() {
		return this.exploded;
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
	
	public void checkPeak() {
		if ((double) ((getHeight()*.20)) < (double) this.LOCATION.y) { 
			this.incrementFirework(); 
		} else {
			this.hasPeaked = true;
		}
	}
	
	public void calculateMaxX() {
		this.MAX_X = (int) (this.VELOCITY * Math.cos(Math.toRadians(this.ANGLE)) * this.timeTracker);
	}
	
	public void calculateMaxY() {
		this.MAX_Y = (int) ((this.VELOCITY * Math.sin(Math.toRadians(this.ANGLE)) * this.timeTracker) - ((9.8 * Math.pow(this.timeTracker, 2)/2)));
		
	}
	
	public void incrementFirework() {
		this.incrementXLocation();
		this.incrementYLocation();
	}
	
	public void incrementXLocation() {
		if (this.enforceXBounds) {
			if (!(this.LOCATION.x<10) && (this.LOCATION.x < (getWidth()-10))) {
				this.LOCATION.x += (((int) (this.VELOCITY * Math.cos(Math.toRadians(this.ANGLE)) * this.timeTracker/100))/this.MATH_FUNCTION_SCALE_X);
			}
		} else {
			this.LOCATION.x += (((int) (this.VELOCITY * Math.cos(Math.toRadians(this.ANGLE)) * this.timeTracker/100))/this.MATH_FUNCTION_SCALE_X);
		}
	}
	
	public void incrementYLocation() {
		this.LOCATION.y += ((int) ((this.VELOCITY * Math.sin(Math.toRadians(this.ANGLE)) * timeTracker/100) - ((9.8 * Math.pow(this.timeTracker/100, 2)/2)))/this.MATH_FUNCTION_SCALE_Y);
	}
	
	
	public void calculateMax() {
		this.calculateMaxX();
		this.calculateMaxY();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		if (!this.hasPeaked || (this.timeTracker < this.FLIGHT_TIME*1000)) { 
			this.paintLaunchPhase(g, g2d);
		} else if (!this.hasFaded ){
			this.fadeFirework(g, g2d);
		} else {
			this.paintExplosion(g, g2d);
		}
	}
	
	public void paintLaunchPhase(Graphics g, Graphics2D g2d) {
		this.checkPeak();

		this.timeTracker++;
		
		if (this.DEBUG) { System.out.println(this.timeTracker + " : " + this.FLIGHT_TIME*1000); }
		
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
		
		for (int i = this.getLocation().y+10; i < this.getLocation().y+35; i+=5) {
			g2d.drawLine(this.getLocation().x, i, this.getLocation().x+20, i-8);
		}		
	}
	
	public void fadeFirework(Graphics g, Graphics2D g2d) {
		g2d.setColor(new Color(255, 255, 255, (int) this.alphaTracker));
		g2d.fillRect(this.getLocation().x, this.getLocation().y, 20, 30);
		g2d.setColor(new Color(255, 0, 0, (int) this.alphaTracker));
		
		Polygon pg = new Polygon(new int[] {this.getLocation().x-10, this.getLocation().x+9, this.getLocation().x+29}, 
				new int[] {this.getLocation().y, this.getLocation().y-30, this.getLocation().y}, 3);
		
		g2d.drawPolygon(pg);
		g2d.fill(pg);

		g2d.setStroke(new BasicStroke(3));
		
		for (int i = this.getLocation().y+10; i < this.getLocation().y+35; i+=5) {
			g2d.drawLine(this.getLocation().x, i, this.getLocation().x+20, i-8);
		}

		if (this.alphaTracker >=1) {
			this.alphaTracker-=0.5;
		} else {
			this.hasFaded = true;
			
		}
	}
	
	public void paintExplosion(Graphics g, Graphics2D g2d) {
		
		
		switch(Main.getDesiredExplosionStr()) {
			case "Simple Circle":
				if (this.DEBUG) { System.out.println("Exploding with the simple circle effect."); }
				this.doCircleExplosion(g, g2d);
				break;
			case "Sparkles":
				if (this.DEBUG) { System.out.println("Exploding with sparkle effect."); }
				this.doSparkleExplosion(g, g2d);
				break;
			case "Nuclear":
				if (this.DEBUG) { System.out.println("Exploding with line effect."); }
				this.doLineExplosion(g, g2d);
				break;
			case "Randomness":
				if (this.DEBUG) { System.out.println("Exploding with randomness effect."); } 
				this.doRandomnessExplosion(g, g2d);
				break;
			case "Hello":
				if (this.DEBUG) { System.out.println("Exploding with hello effect."); } 
				this.doHelloExplosion(g, g2d);
				break;
			case "Stars":
				if (this.DEBUG) { System.out.println("Exploding with stars effect."); }
				this.doStarExplosion(g, g2d);
				break;
			case "Artifacts":
				if (this.DEBUG) { System.out.println("Exploding with artifact effect."); } 
				this.doArtifactExplosion(g, g2d);
				break;
			default:
				break;
		}
	}

	
	private void adjustAlpha(double adjustmentAmount) {
		if (!this.alphaZeroed) {
			this.alphaTracker = 0;
			this.alphaZeroed = true;
			this.alphaApproaching = true;
			if (this.DEBUG) { System.out.println("Alpha zeroed"); }
		} else {
			
			if (this.alphaApproaching) {
				
				if (this.alphaTracker+adjustmentAmount <= this.initMaxAlphaFromSrc) {
					this.alphaTracker+=adjustmentAmount;
					if (this.DEBUG) { System.out.println("Added 0.5 to alpha"); }
				}
				
				else if (this.alphaTracker >= this.initMaxAlphaFromSrc) {
					this.alphaApproaching = false;
					if (this.DEBUG) { System.out.println("Alpha tracker is greater than or equal to init : " + this.alphaTracker + ">=" + this.initMaxAlphaFromSrc); }
				}
				
			} else {
				
				if (this.alphaTracker-adjustmentAmount > 0) {
					this.alphaTracker-=adjustmentAmount;
					if (this.DEBUG) { System.out.println("Removed 0.5 from alpha, " + this.alphaTracker); }
				} else {
					
					this.fireworkDone = true;
					if (this.DEBUG) { System.out.println("Firework done, alpha tracker " + this.alphaTracker ); }
				}
				
			}
		}
	}
	
	//Explosion FX Central >
	public void doCircleExplosion(Graphics g, Graphics2D g2d) {
		this.adjustAlpha(0.5);
		
		g2d.setColor(new Color(this.EXPLOSION_COLOR.getRed(), this.EXPLOSION_COLOR.getGreen(), this.EXPLOSION_COLOR.getBlue(), (int) (this.alphaTracker - (this.alphaTracker%1))));
		g2d.fillOval(this.LOCATION.x, this.LOCATION.y, (int) (this.EXPLOSION_RADIUS*this.radiusExplosionScaler), (int) (this.EXPLOSION_RADIUS*this.radiusExplosionScaler));
		
	}
	
	public void doSparkleExplosion(Graphics g, Graphics2D g2d) {
		this.adjustAlpha(0.5);
		
		for (int i = (int) (getWidth()*.20) ; i < (getWidth()*.8); i+=40) {
			for (int j = 0; j < getHeight()*.5 + this.EXPLOSION_RADIUS; j+=20) {
				g2d.rotate((int) Math.toRadians(Math.random() * 57));
				g2d.setStroke(new BasicStroke((int) (Math.random() * 4.) + 1));
				g2d.setColor(new Color(this.EXPLOSION_COLOR.getRed(), this.EXPLOSION_COLOR.getGreen(), this.EXPLOSION_COLOR.getBlue(), (int) (this.alphaTracker - (this.alphaTracker%1))));
				g2d.drawLine(i+7, j + (int) (Math.random()*3. +2), i+2, j + (int) (Math.random()*6. +2));
				g2d.drawLine(i-(int) (Math.random() *3), j + (int) (Math.random()*3. +2), i+4, j + (int) (Math.random()*6. +2));
			}
		}
	}
	
	
	public void doLineExplosion(Graphics g, Graphics2D g2d) {
		this.adjustAlpha(0.5);
		g2d.setColor(new Color(this.EXPLOSION_COLOR.getRed(), this.EXPLOSION_COLOR.getGreen(), this.EXPLOSION_COLOR.getBlue(), (int) (this.alphaTracker - (this.alphaTracker%1))));
		
		for (int i = 0; i < this.getWidth(); i++) {
			for (int j = 0; j < this.getHeight(); j+=10) {
				g2d.rotate((Math.random() * 57));
				
				g2d.drawLine(i*2, j, i, j&i);
			}
		}
		
	}
	
	public void doRandomnessExplosion(Graphics g, Graphics2D g2d) {
		this.adjustAlpha(1);
		g2d.setColor(new Color(this.EXPLOSION_COLOR.getRed(), this.EXPLOSION_COLOR.getGreen(), this.EXPLOSION_COLOR.getBlue(), (int) (this.alphaTracker - (this.alphaTracker%1))));
		
		for (int i = 0; i < this.getWidth()/.8; i++) {
			for (int j = 0; j < this.getHeight()/.8; j+=10) {
				g2d.rotate((Math.random() * 57));
				
				g2d.drawLine(i*2, j, i, (int) (j%(i*.2)+1));
			}
		}
	}
	
	public void doHelloExplosion(Graphics g, Graphics2D g2d) {
		this.adjustAlpha(0.25);
		g2d.setColor(new Color(this.EXPLOSION_COLOR.getRed(), this.EXPLOSION_COLOR.getGreen(), this.EXPLOSION_COLOR.getBlue(), (int) (this.alphaTracker - (this.alphaTracker%1))));
		g2d.rotate(Math.toRadians(10));
		g2d.setFont(new Font("Monospaced", Font.BOLD, this.EXPLOSION_RADIUS));
		g2d.drawString("H e l l o!", this.LOCATION.x, this.LOCATION.y);
	}
	
	public void doStarExplosion(Graphics g, Graphics2D g2d) {
		this.adjustAlpha(.5);
		g2d.setColor(new Color(this.EXPLOSION_COLOR.getRed(), this.EXPLOSION_COLOR.getGreen(), this.EXPLOSION_COLOR.getBlue(), (int) (this.alphaTracker - (this.alphaTracker%1))));
		
		
		for (int i = 0; i < getWidth(); i+=(getWidth()/5)) {
			
		
			int[] x  = {42+i,52+i,72+i,52+i,60+i,40+i,15+i,28+i,9+i,32+i,42+i};
			int[] y = {38+i,62+i,68+i,80+i,105+i,85+i,102+i,75+i,58+i,60+i,38+i};
			g2d.fillPolygon(x, y, 11);
		}
		
	
	}
	
	public void doArtifactExplosion(Graphics g, Graphics2D g2d) {
		this.adjustAlpha(.25);
		g2d.setColor(new Color(this.EXPLOSION_COLOR.getRed(), this.EXPLOSION_COLOR.getGreen(), this.EXPLOSION_COLOR.getBlue(), (int) (this.alphaTracker - (this.alphaTracker%1))));
		
		for (int i = 0; i < getWidth(); i+=10) {
			g2d.rotate(Math.toRadians(20));
			g2d.fillPolygon(new int[] {10+i, 20+i, 30+i}, new int[] {100, 20, 100}, 3);
		}
		
	}
	//
	
	@Override
	public String toString() {
		return "[Firework]\n\tExplosion Radius > " + this.EXPLOSION_RADIUS + "ft\n\tVelocity > " + this.VELOCITY + "m/s\n\tFlight Time > " + this.FLIGHT_TIME + "\n\tAngle > " + this.ANGLE + "\n" ;
	}
}
