import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

public class FireworkCanvas extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Firework> FIREWORKS;
	
	private boolean ANTI_ALIASING;
	
	private final Color NIGHT_BG = Color.decode("#001a33");
	
	private final BorderLayout LAYOUT_MANAGER = new BorderLayout();
	
	private final String DEBUG_PFX = "[Fireworks Canvas]\n\t";
	
	private Launcher LAUNCHER = new Launcher();
	
	//private final FireworksMenu MENU = new FireworksMenu();
	
	private boolean DEBUG = false, MENU_SKEWED = false;
	

	
	private Dimension SCREEN_DIMENSIONS;
	
	public FireworkCanvas() {
		this.setLayout(this.LAYOUT_MANAGER);
		this.FIREWORKS = new ArrayList<Firework>();
		this.ANTI_ALIASING = true;
		this.setSize(800,800);
		this.setBackground(this.NIGHT_BG);
		this.addComponentListener(this.resizeListener());
		this.updateScreenDimensions();
		//this.skewMenu();
		
		repaint();
		//this.add(new FireworksMenu(), BorderLayout.WEST);
		this.add(this.LAUNCHER);
		
		if (Main.MASTER_DEBUG) {
			this.DEBUG = true;
		}
		
		
	}
	
	public void addNewFirework() {
		this.FIREWORKS.add(new Firework());
	}
	
	public void addNewFirework(int colorIndex) {
		this.FIREWORKS.add(new Firework(colorIndex));
	}
	
	public void addNewFirework(int colorIndex, int explosionRadius) {
		this.FIREWORKS.add(new Firework(colorIndex, explosionRadius));
	}
	
	public void clearFireworks() {
		this.FIREWORKS.clear();
	}
	
	public void toggleAntiAliasing() {
		this.ANTI_ALIASING = !this.ANTI_ALIASING;
	}
	
	public void setAntiAliasing(boolean tf) {
		this.ANTI_ALIASING = tf;
	}
	
	public int genNum(int bound) {    
		return (int)(Math.random() * ((bound - 1) + 1)) + 1;
	}
	
	private void updateScreenDimensions() {
		this.SCREEN_DIMENSIONS = new Dimension(getWidth(), getHeight());
		if (this.DEBUG) { System.out.println("[Canvas Dimensions]\n\t>> " + this.SCREEN_DIMENSIONS); }
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
	
	/*
	public void skewMenu() {
		//return new Dimension((int) (getWidth()/2.5),getHeight());
		if (!this.MENU_SKEWED) {
			
			this.MENU_SKEWED = true;
		}
		
		this.MENU.setSize((int) (getWidth()/4),getHeight());
		
	}
	*/
	
	public void paintBackground(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		//BG Handling
		g2d.setColor(this.NIGHT_BG);
		g2d.fill(getBounds());
		//
		
		//Stars
		g2d.setColor(Color.WHITE);
		
		if (this.DEBUG) { System.out.println(this.DEBUG_PFX + "[Stars]"); }
		for (int i = 0; i < getHeight(); i+=5) {
			for (int j = 0; j < getWidth(); j+=3) {
				if ((j%this.genNum(getWidth())==0) && (!(j==0))) {
					g2d.drawLine(j, i, j, i);
					if (this.DEBUG) { System.out.println("\tStar added at (" + i + "," + j + ")"); }
				}
			}
		}
	}
	
	public void launchFirework(Firework f) {

		this.LAUNCHER.launch(f);
	}
	
	
	public void launchFirework(int id) {
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.paintBackground(g);
		
	}

}
