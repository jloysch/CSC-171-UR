import java.awt.Color;

import javax.swing.JComponent;

public class Firework extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Color[] COLORS;
	private Color FIREWORK_COLOR;
	private int EXPLOSION_RADIUS;
	private boolean EXPLODED;
	
	public Firework() {
		this.populateColors();
		this.FIREWORK_COLOR = this.COLORS[1];
		this.EXPLOSION_RADIUS = 10;
		this.EXPLODED = false;
	}
	
	public Firework(int colorIndex) {
		this.populateColors();
		this.FIREWORK_COLOR = this.COLORS[colorIndex];
		this.EXPLODED = false;
	}
	
	public Firework(int colorIndex, int explosionRadius) {
		this.populateColors();
		this.FIREWORK_COLOR = this.COLORS[colorIndex];
		this.EXPLOSION_RADIUS = explosionRadius;
		this.EXPLODED = false;
		
		System.out.println(this);
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
		this.EXPLOSION_RADIUS = r;
	}
	
	public void explode() {
		this.EXPLODED = true;
		
	}
	
	public boolean isExploded() {
		return this.EXPLODED;
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
	
	@Override
	public String toString() {
		return "[Firework] >> " + this.FIREWORK_COLOR + " with explosion radius " + this.EXPLOSION_RADIUS;
	}
}
