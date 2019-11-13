import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ScreenSaver extends JPanel {
	
	private int LINES, DECAY_TIME_MS, LINE_THICKNESS, ALPHA_MIN;
	
	private Color LINE_COLOR;
	
	private boolean MIXED_COLOR_LINES, DEBUG, AA_FILTER, VARY_ALPHA;
	
	private Dimension SCREEN_DIMENSIONS;
	
	private Point[] LINE_POINTS;
	
	private Color[] PALETTE;
	
	private Runnable ANIMATION;
	
	private ScheduledExecutorService SCHEDULER;
	
	/**
		 4. Create a â€œscreen saverâ€� application:
		(a) Create a graphical application that draws 100 random lines in a canvas. 
		(b) Extend your application so that it repaints itself every five seconds.
		(c) Extend your application to provide a GUI for setting the number of lines to draw.
	 */
	
	private static final long serialVersionUID = 1L;
	
	public ScreenSaver() {
		
		this.SCREEN_DIMENSIONS = new Dimension(0,0);
		this.LINES = 100;
		
		this.PALETTE = new Color[] {Color.BLACK, Color.RED, Color.GREEN, Color.BLUE, Color.CYAN, Color.magenta, Color.decode("#FECEAB")};
		
		this.DEBUG = false;
		this.AA_FILTER = true;
		
		this.VARY_ALPHA = true;
		
		this.ALPHA_MIN = 50;
		
		this.LINE_COLOR = Color.RED;
		this.LINE_THICKNESS = 2;
		
		this.MIXED_COLOR_LINES = true;
		
		this.DECAY_TIME_MS = 5000; //Be careful with this.
		
		setSize(800,800);
	
		addComponentListener(this.resizeListener());
		//this.addKeyListener(this);
		
		setFocusable(true);
		
		
		
		setBackground(Color.BLACK);
		setVisible(true);	
		crazyLines();
		animate();
		if (this.DEBUG) { System.out.println("animating"); }
		//updateGUI();
		
		
	}
	
	public void toggleMixedColors(boolean tf) {
		this.MIXED_COLOR_LINES = tf;
	}
	
	public void setLineAmount(int l) {
		this.LINES = l;
	}
	
	public void setLineColor(Color c) {
		this.LINE_COLOR = c;
	}
	
	public void toggleAlphaVariation(boolean tf) {
		this.VARY_ALPHA = tf;
	}
	
	public void setColorPalette(Color[] c) {
		this.PALETTE = c;
	}
	
	public void toggleAntiAliasing(boolean tf) {
		this.AA_FILTER = tf;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		long startTime = 0;
		
		if (this.DEBUG) {
		System.out.println("[Frame update request]");
		startTime = System.nanoTime();
		}
		
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		if (this.AA_FILTER) {
		g2d.setRenderingHint(
	            RenderingHints.KEY_ANTIALIASING,
	            RenderingHints.VALUE_ANTIALIAS_ON);
		}
		
		
		for (int i = 1; i < this.LINE_POINTS.length; i++) {
			
			Color cCol;
			
			if (this.MIXED_COLOR_LINES) {
				cCol = this.PALETTE[genNum(this.PALETTE.length-1)];
			} else {
				cCol = this.LINE_COLOR;
			}
			
			if (this.VARY_ALPHA) {
				g2d.setColor(new Color(cCol.getRed(), cCol.getGreen(), cCol.getBlue(), (int) this.genAlpha()));
			} else {
				g2d.setColor(cCol);
			}
			
			//System.out.println("ALPHA COLOR = " + g2d.getColor().getAlpha());
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
		
		if (this.DEBUG) { System.out.println("\tcompleted in " + ( (double) (System.nanoTime()-startTime)/100000000) + "s");}
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
    	    	if (DEBUG) { System.out.println("@Resize event"); }
    	        updateScreenDimensions();
    	        
    	        repaint();
    	    }
    	};
	}
	
	public void crazyLines() {//p1 start, p2 end. hence 2*lines
		if (this.DEBUG) { System.out.println("Generating random lines"); }
		this.LINE_POINTS = new Point[this.LINES*2];
		
		for (int i = 0; i < this.LINES*2; i++) {
			this.LINE_POINTS[i] = new Point(this.genNum(getWidth()), this.genNum(getHeight()));
		}
	}
	
	private void progressiveLines() {
		this.LINE_POINTS = new Point[this.LINES*2];
		for (int i = 0; i < this.LINES*2; i++) {
			this.LINE_POINTS[i] = new Point(genNum(getWidth()), (i*this.LINE_THICKNESS));
		}
	}
	
	public void updateGUI() {
		   if (!SwingUtilities.isEventDispatchThread()) {
		     SwingUtilities.invokeLater(new Runnable() {
		       @Override
		       public void run() {
		          updateGUI();
		       }
		     });
		     return;
		   }
		   animate();
		
		}
	
	public void animate() {
		this.SCHEDULER = Executors.newSingleThreadScheduledExecutor();
		
		this.ANIMATION = new Runnable() {
			public void run() {
				repaint();
				progressiveLines();
			}
		};
					
		this.SCHEDULER.scheduleAtFixedRate(this.ANIMATION, 0, this.DECAY_TIME_MS, TimeUnit.MILLISECONDS);			
	}
	
	public void upDownHandler(boolean up) {
		if (up) {
			this.speedUp();
		} else {
			this.slowDown();
		}
	}

	public void speedUp() {
		if (this.DECAY_TIME_MS <= 100 && this.DECAY_TIME_MS > 11) {
			System.out.println("[*] Increasing animation speed to " + (this.DECAY_TIME_MS-=10) +"ms / frame update.");
		} else if (this.DECAY_TIME_MS > 100 ){
			System.out.println("[*] Increasing animation speed to " + (this.DECAY_TIME_MS-=100) +"ms / frame update.");
		} else {
			System.out.println("You can't get much faster than " + this.DECAY_TIME_MS);
		}
		this.SCHEDULER.shutdown();
		this.animate();
	}
	
	public void slowDown() {
		if (this.DECAY_TIME_MS == 10) {
			System.out.println("[*] Decreasing animation speed to " + (this.DECAY_TIME_MS+=90) +"ms / frame update.");
		} else {
			System.out.println("[*] Decreasing animation speed to " + (this.DECAY_TIME_MS+=100) +"ms / frame update.");
		}
		this.SCHEDULER.shutdown();
		this.animate();
	}
	/*
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				if (this.DECAY_TIME_MS <= 100 && this.DECAY_TIME_MS > 11) {
					System.out.println("[*] Increasing animation speed to " + (this.DECAY_TIME_MS-=10) +"ms / frame update.");
				} else if (this.DECAY_TIME_MS > 100 ){
					System.out.println("[*] Increasing animation speed to " + (this.DECAY_TIME_MS-=100) +"ms / frame update.");
				} else {
					System.out.println("You can't get much faster than " + this.DECAY_TIME_MS);
				}
				this.SCHEDULER.shutdown();
				this.animate();
				break;
			case KeyEvent.VK_DOWN:
				
				if (this.DECAY_TIME_MS == 10) {
					System.out.println("[*] Decreasing animation speed to " + (this.DECAY_TIME_MS+=90) +"ms / frame update.");
				} else {
					System.out.println("[*] Decreasing animation speed to " + (this.DECAY_TIME_MS+=100) +"ms / frame update.");
				}
				this.SCHEDULER.shutdown();
				this.animate();
				break;
			default:
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {	
		
	}
	*/
}
