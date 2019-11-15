import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class FireworksMenu extends JComponent implements ChangeListener, ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton LAUNCH_BUTTON;
	
	private JSlider BLAST_RADIUS_SLIDER;
	
	private final Color MENU_COLOR = new Color(105,105,105, 100), TEXT_COLOR = Color.WHITE;
	
	private final String DEBUG_PFX = "[Fireworks Menu]\n\t";
	
	private final boolean DEBUG = true;
	
	//private final BoxLayout LAYOUT_MANAGER = new BoxLayout(this, BoxLayout.Y_AXIS);
	
	private final JLabel[] COMPONENT_LABELS = new JLabel[3];
	
	private int SLIDER_VALUE = 50;
	
	private Dimension MENU_DIMENSIONS;
	
	public FireworksMenu() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.MENU_DIMENSIONS = new Dimension(800,800);
		this.addComponentListener(this.resizeListener());
		this.updateScreenDimensions();
		this.setAlignmentX(this.CENTER_ALIGNMENT);
		
		setBorder(BorderFactory.createTitledBorder(null, "Launch Mission Control", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, (new Font("Monospaced", Font.BOLD, 14)), Color.WHITE));
		
		
		this.addMenuComponents();
		this.setVisible(true);
		this.BLAST_RADIUS_SLIDER.addChangeListener(this);
		this.LAUNCH_BUTTON.addActionListener(this);
		//this.setResizeable(false);
		
		repaint();
	}
	
	public void initializeLabels() {
		for (int i = 0; i < this.COMPONENT_LABELS.length; i++) {
			this.COMPONENT_LABELS[i] = new JLabel();
			this.COMPONENT_LABELS[i].setForeground(this.TEXT_COLOR);
		}
		
		this.setLabelNames();
	}
	
	public void setLabelNames() {
		this.COMPONENT_LABELS[0].setText("Launch Radius: 50ft");
		this.COMPONENT_LABELS[0].setFont(new Font("Monospaced", Font.BOLD, 14));
		this.COMPONENT_LABELS[1].setText("Launch Mission Control");
		//this.COMPONENT_LABELS[0].setAlignmentX(this.CENTER_ALIGNMENT);
	}
	
	private void updateScreenDimensions() {
		this.MENU_DIMENSIONS = new Dimension(getWidth(), getHeight());
		System.out.println(this.MENU_DIMENSIONS);
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
	
	public Dimension getMenuDimensions() {
		return this.MENU_DIMENSIONS;
	}
	
	public void addMenuComponents() {
		
		this.initializeLabels();
		
		this.LAUNCH_BUTTON = new JButton();
		this.BLAST_RADIUS_SLIDER = new JSlider();
		
		this.LAUNCH_BUTTON.setText("LAUNCH!");
		
		this.BLAST_RADIUS_SLIDER.setMaximumSize(new Dimension(this.getMenuDimensions().width, 20));
		this.BLAST_RADIUS_SLIDER.setMinimumSize(new Dimension(this.getMenuDimensions().width, 20));
		//this.BLAST_RADIUS_SLIDER.setAlignmentX(this.getMenuDimensions().width/2);
		
		this.add(this.COMPONENT_LABELS[0]);
		
		this.add(this.BLAST_RADIUS_SLIDER);
		this.add(this.LAUNCH_BUTTON);
	}
	

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(this.MENU_COLOR);
		g2d.fill(getBounds());
		System.out.println("\t*Screen dimensions for menu " + this.getMenuDimensions());
		if (this.DEBUG) { System.out.println(this.DEBUG_PFX + "[*] Finished repaint."); }
	}
	/*
	@Override
	public Dimension getPreferredSize() {
		return new Dimension((int) (getWidth()/2.5),getHeight());
	}
	*/

	@Override
	public void stateChanged(ChangeEvent e) {
	        JSlider source = (JSlider)e.getSource();
	        if (!source.getValueIsAdjusting()) {
	            int r = (int)source.getValue();   
	            this.COMPONENT_LABELS[0].setText("Launch Radius: " + r + "ft");
	            this.SLIDER_VALUE = r;
	            
	           
	    }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Firework x = new Firework();
		x.getColorFromColorIndex(8);
		
		this.add(new Firework(1,this.SLIDER_VALUE));
		
	}
}
