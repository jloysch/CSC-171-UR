import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JComponent;

public class Launcher extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Color LAUNCHER_COLOR = Color.RED, LAUNCHER_TAG_COLOR = Color.WHITE;
	
	private final String LAUNCHER_TAG = "LAUNCHER";
	
	
	private final Font LAUNCHER_TAG_FONT = (new Font("Monospaced", Font.BOLD, 20));
	
	private final boolean DEBUG = true;
	
	public boolean fireworkInProgress = false;
	
	private Firework CURRENT_FIREWORK;
	
	private Runnable ANIMATION;
	
	private ScheduledExecutorService SCHEDULER;
	
	private int ANIMATION_TIME_MS;

	public Launcher() {
		this.CURRENT_FIREWORK = null;
		this.ANIMATION = null;
		this.SCHEDULER = null;
		this.ANIMATION_TIME_MS = 20; //Real time update for firework (1ms)
	}
	
	public Point getMiddleOfCanvas() {
		return new Point(getWidth()/2, getHeight()/2);
	}
	

	public Dimension getLauncherDimensions() {
		return new Dimension((int) (getWidth()*.22), + (int) (getHeight()*.12));
	}
	
	public Point getTextCenterOfLauncher() {
		return new Point(getWidth()/2 - (this.getLauncherDimensions().width/2), getHeight()-this.getLauncherDimensions().height/2);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		//super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(this.LAUNCHER_COLOR);
		
		/*g2d.drawRect(this.getMiddleOfCanvas().x - (this.getLauncherDimensions().width/2),
				(getWidth() - this.getLauncherDimensions().height), 
				this.getLauncherDimensions().width, 
				this.getLauncherDimensions().height);
				*/
		
		g2d.fillRect(this.getMiddleOfCanvas().x - (this.getLauncherDimensions().width/2),
				(this.getMiddleOfCanvas().y*2) - this.getLauncherDimensions().height,
				this.getLauncherDimensions().width,
				this.getLauncherDimensions().height);
		

		g2d.setColor(this.LAUNCHER_TAG_COLOR);
		
		//int xxa = (int) (g2d.getFontMetrics().getStringBounds(this.LAUNCHER_TAG, g2d).getWidth()/2);
		

		g2d.setFont(this.LAUNCHER_TAG_FONT);
		
		g2d.drawString(this.LAUNCHER_TAG, 
				this.getMiddleOfCanvas().x - (int) (g2d.getFontMetrics().getStringBounds(this.LAUNCHER_TAG, g2d).getWidth()/2),
				getHeight() - this.getLauncherDimensions().height/2);
		
		g2d.setColor(Color.BLACK);
		
		if (!(this.CURRENT_FIREWORK == null)) {
			//this.CURRENT_FIREWORK.incrementXLocation();
			
		}
		
		//System.out.println("Launcher repaint done.");
		
	
}
		
	
	
	public void doFireworkAnimation() {
		this.SCHEDULER = Executors.newSingleThreadScheduledExecutor();
		
		this.ANIMATION = new Runnable() {
			public void run() {
				//System.out.println("Animation req");
				repaint();
				
				if (CURRENT_FIREWORK.isExploded() && CURRENT_FIREWORK.isDone()) {
					fireworkInProgress = false;
					SCHEDULER.shutdown();
				}
			}
		};
					
		this.SCHEDULER.scheduleAtFixedRate(this.ANIMATION, 0, this.ANIMATION_TIME_MS, TimeUnit.MILLISECONDS);	
	}		
	
	
	public void launch(Firework fw) {
		if (!this.fireworkInProgress) {
			this.CURRENT_FIREWORK = fw;
			this.CURRENT_FIREWORK.newCanvasSize(getWidth(), getHeight());
			this.CURRENT_FIREWORK.setLocation(new Point(this.getMiddleOfCanvas().x, getHeight()-(int) (this.getLauncherDimensions().height*1.44)));
		
			this.add(this.CURRENT_FIREWORK);
			
			if (this.DEBUG) { System.out.println("Launching firework : " + fw + " location = " + fw.getLocation()); }
			this.fireworkInProgress = true;
			this.doFireworkAnimation();
		}
	}
}
