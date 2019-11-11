import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class ScreenSaver extends JPanel {

	private JComponent MENU;
	
	private int LINES, DECAY_TIME_MS, LINE_THICKNESS, DRAMATIC_EFFECT_TIME_MS, ALPHA_MIN;
	
	private Color LINE_COLOR;
	
	private boolean MIXED_COLOR_LINES, MIXED_THICKNESS, DEBUG, AA_FILTER, DRAMATIC_EFFECT, VARY_ALPHA;
	
	private Dimension SCREEN_DIMENSIONS;
	
	private Point[] LINE_POINTS;
	
	private Color[] PALETTE;
	
	/**
		 4. Create a “screen saver” application:
		(a) Create a graphical application that draws 100 random lines in a canvas. 
		(b) Extend your application so that it repaints itself every five seconds.
		(c) Extend your application to provide a GUI for setting the number of lines to draw.
	 */
	
	private static final long serialVersionUID = 1L;
	
	public ScreenSaver() {
		this.setLayout(new FlowLayout());
		this.MENU = new ScreenSaverMenu();
		
		this.SCREEN_DIMENSIONS = new Dimension(0,0);
		this.LINES = 100;
		
		this.PALETTE = new Color[] {Color.BLACK, Color.RED, Color.GREEN, Color.BLUE, Color.CYAN, Color.magenta, Color.decode("#FECEAB")};
		
		this.DEBUG = false;
		this.AA_FILTER = true;
		
		this.DRAMATIC_EFFECT = false;
		
		this.VARY_ALPHA = true;
		
		this.ALPHA_MIN = 50;
		
		this.LINE_COLOR = Color.RED;
		this.LINE_THICKNESS = 2;
		
		this.DECAY_TIME_MS = 5000; //Be careful with this, don't make your processor have a heart attack and throw-up on itself.
		this.DRAMATIC_EFFECT_TIME_MS = 100;
		
		setSize(800,800);
	
		addComponentListener(this.resizeListener());
		setBackground(Color.BLACK);
		setVisible(true);	
		crazyLines();
		animate();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		if (this.AA_FILTER) {
		g2d.setRenderingHint(
	            RenderingHints.KEY_ANTIALIASING,
	            RenderingHints.VALUE_ANTIALIAS_ON);
		}
		
		
		for (int i = 1; i < this.LINE_POINTS.length; i++) {
			Color cCol = this.PALETTE[genNum(this.PALETTE.length-1)];
			
			if (this.VARY_ALPHA) {
				g2d.setColor(new Color(cCol.getRed(), cCol.getGreen(), cCol.getBlue(), (int) this.genAlpha()));
			} else {
				g2d.setColor(cCol);
			}
			
			System.out.println("ALPHA COLOR = " + g2d.getColor().getAlpha());
			if (this.DEBUG) {
			System.out.println("Drew (" + this.LINE_POINTS[i-1].x 
					+ "," + this.LINE_POINTS[i-1].y 
					+ ") to (" + this.LINE_POINTS[i].x + "," 
					+ this.LINE_POINTS[i].y + ")");
			}
			g2d.drawLine(this.LINE_POINTS[i-1].x, this.LINE_POINTS[i-1].y, this.LINE_POINTS[i].x, this.LINE_POINTS[i].y);
				
				if (i%3==0) {
					g2d.rotate(Math.toRadians(38));
				}
			}
		
		
	}
	
	private double genAlpha() {
		return (Math.random() * (255 - this.ALPHA_MIN)) + this.ALPHA_MIN;
	}
	
	public int genNum(int bound) {    
		return (int)(Math.random() * ((bound - 1) + 1)) + 1;
	}
	
	private void updateScreenDimensions() {
		this.SCREEN_DIMENSIONS = new Dimension(getWidth(), getHeight());
		System.out.println(this.SCREEN_DIMENSIONS);
	}
	
	private ComponentAdapter resizeListener() {
		return new ComponentAdapter() {
    	    public void componentResized(ComponentEvent c) {
    	    	System.out.println("@Resize event");
    	        updateScreenDimensions();
    	        
    	        repaint();
    	    }
    	};
	}
	
	public void crazyLines() {//p1 start, p2 end. hence 2*lines
		System.out.println("Generating random lines");
		this.LINE_POINTS = new Point[this.LINES*2];
		
		for (int i = 0; i < this.LINES*2; i++) {
			this.LINE_POINTS[i] = new Point(this.genNum(getWidth()), this.genNum(getHeight()));
		}
	}
	
	public void showMenu() {
		
	}
	
	private void progressiveLines() {
		this.LINE_POINTS = new Point[this.LINES*2];
		for (int i = 0; i < this.LINES*2; i++) {
			this.LINE_POINTS[i] = new Point(genNum(getWidth()), (i*this.LINE_THICKNESS));
		}
	}
	
	public void animate() {
		ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

		
		Runnable task = new Runnable() {
		    public void run() {
		       
		        repaint();
		        progressiveLines();
		        
		        
		    }
		};
		
		scheduler.scheduleAtFixedRate(task, 0, this.DECAY_TIME_MS, TimeUnit.MILLISECONDS);		
		
	}

}
