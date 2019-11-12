import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComponent;

public class ScreenSaverMenu extends JComponent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Dimension SCREEN_DIMENSIONS;
	
	public ScreenSaverMenu() {
		this.SCREEN_DIMENSIONS = new Dimension(50,50);
		setBackground(Color.RED);
		this.updateScreenDimensions();
		setSize(this.SCREEN_DIMENSIONS);
		setVisible(true);
	}
	
	public ScreenSaverMenu(Dimension d) {
		this.SCREEN_DIMENSIONS = d;
		setBackground(Color.RED);
		this.updateScreenDimensions();
		setSize(this.SCREEN_DIMENSIONS);
		setVisible(true);
	}
	
	public void updateScreenDimensions() {
		
		this.SCREEN_DIMENSIONS.setSize(getWidth(), getHeight());
		System.out.println("[*] Screen Dimensions >> " + "(" + this.SCREEN_DIMENSIONS + ")");
	}
	
	public void newScreenDim() {
		
	}
	
	public Dimension getDimensions() {
		return this.SCREEN_DIMENSIONS;
	}
	
	public void setDimensions(Dimension d) {
		this.SCREEN_DIMENSIONS = d;
	}

}
