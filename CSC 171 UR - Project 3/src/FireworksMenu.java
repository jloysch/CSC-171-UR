import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class FireworksMenu extends JComponent implements ChangeListener, ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton LAUNCH_BUTTON;
	
	
	
	private final Color MENU_COLOR = new Color(105,105,105, 100), TEXT_COLOR = Color.WHITE;
	
	private final String DEBUG_PFX = "[Fireworks Menu]\n\t";
	
	private final boolean DEBUG = false;
	
	private final Color NIGHT_BG = Color.decode("#001a33");
	
	private Color FIREWORK_COLOR = Color.RED;
	
	//private final BoxLayout LAYOUT_MANAGER = new BoxLayout(this, BoxLayout.Y_AXIS);
	
	private JSlider[] SLIDERS = new JSlider[9];
	
	private final JLabel[] COMPONENT_LABELS = new JLabel[9];
	
	private final JComboBox<String> EXPLOSION_OPTIONS = new JComboBox<String>();
	
	private final Font MENU_FONT = (new Font("Monospaced", Font.BOLD, 14));
	
	private int SLIDER_VALUE = 50;
	
	private int bgDrawn = 0;
	
	private Dimension MENU_DIMENSIONS;
	
	private String lastFX = "";
	
	private int DESIRED_EXPLOSION_RADIUS = 20;
	
	
	
	public FireworksMenu() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		//this.MENU_DIMENSIONS = new Dimension(800,800);
		this.addComponentListener(this.resizeListener());
		this.updateScreenDimensions();
		this.setAlignmentX(this.CENTER_ALIGNMENT);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		setBorder(BorderFactory.createTitledBorder(null, "Launch Mission Control", 
				TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, 
				(new Font("Monospaced", Font.BOLD, 14)), Color.WHITE));
		
		
		this.addMenuComponents();
		this.setupComboBoxOptions();
		
		
		this.LAUNCH_BUTTON.addActionListener(this);
		this.SLIDERS[4].setValue(255);
		this.SLIDERS[0].setValue(20);
		this.COMPONENT_LABELS[0].setText("Explosion Radius: 20 ft");
		this.setVisible(true);
	}
	
	   @Override
	    public Dimension getPreferredSize() {
		   JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
	        return new Dimension((int) (topFrame.getWidth()*.28), getHeight());
	    }
	
	   public void setupComboBoxOptions() {
		   this.EXPLOSION_OPTIONS.addItem("Simpe Circle");
		   this.EXPLOSION_OPTIONS.addItem("Stars");
		   this.EXPLOSION_OPTIONS.addItem("Lines");
		   this.EXPLOSION_OPTIONS.addItem("Crazy");
		   this.EXPLOSION_OPTIONS.addItem("Artifacts");
		   this.EXPLOSION_OPTIONS.addItem("Spell Hello");
		   this.EXPLOSION_OPTIONS.addItem("Swirly");
		   this.EXPLOSION_OPTIONS.addItem("Sparkles");
	   }
	
	public int genNum(int bound) {    
		return (int)(Math.random() * ((bound - 1) + 1)) + 1;
	}
	
	public void updateFireworkColor() {
		try {
			this.FIREWORK_COLOR = new Color(this.SLIDERS[1].getValue(), this.SLIDERS[2].getValue(), this.SLIDERS[3].getValue(), (this.SLIDERS[4].getValue()));
			if (this.DEBUG) { System.out.println("\tNew firework color >> " + this.FIREWORK_COLOR); }
			repaint(); //TODO REMEMBER THIS IS HERE
		} catch (NullPointerException iCouldNotCareLess){
			if (this.DEBUG) { System.out.println("\tError in updating firework color"); }
		}
	}
	
	public void initializeSliders() {
		for (int i = 0; i < this.SLIDERS.length; i++) {
			this.SLIDERS[i] = new JSlider();
			this.SLIDERS[i].setAlignmentX(Component.CENTER_ALIGNMENT);
			this.SLIDERS[i].addChangeListener(this);
			
			if (i == 0) {
				this.SLIDERS[i].setMaximum(100);
				this.SLIDERS[i].setValue(20);	
			}
			
			if (i >= 1) {
				this.SLIDERS[i].setMaximum(255);
				this.SLIDERS[i].setValue(128);
				
			}
		}
		
		
		
		
		this.SLIDERS[5].setValue(5);
		this.SLIDERS[5].setMinimum(1);
		this.SLIDERS[5].setMaximum(20);
		
		this.SLIDERS[6].setValue(0);
		this.SLIDERS[6].setMaximum(6);
		
		this.SLIDERS[4].setMinimum(60);
		
		this.SLIDERS[7].setMaximum(15);
		this.SLIDERS[7].setMinimum(1);
		this.SLIDERS[7].setValue(5);
		this.SLIDERS[8].setMaximum(180);
		this.SLIDERS[8].setValue(90);
	}
	
	public void initializeLabels() {
		for (int i = 0; i < this.COMPONENT_LABELS.length; i++) {
			this.COMPONENT_LABELS[i] = new JLabel();
			this.COMPONENT_LABELS[i].setForeground(this.TEXT_COLOR);
			this.COMPONENT_LABELS[i].setAlignmentX(Component.CENTER_ALIGNMENT);
		}
		
		this.setLabelNames();
	}
	
	public void setLabelNames() {
		this.COMPONENT_LABELS[0].setText("Explosion Radius: 20 ft");
		this.COMPONENT_LABELS[0].setFont(this.MENU_FONT);
		this.COMPONENT_LABELS[1].setText("R = 128");
		this.COMPONENT_LABELS[1].setFont(this.MENU_FONT);
		this.COMPONENT_LABELS[2].setText("G = 128");
		this.COMPONENT_LABELS[2].setFont(this.MENU_FONT);
		this.COMPONENT_LABELS[3].setText("B = 128");
		this.COMPONENT_LABELS[3].setFont(this.MENU_FONT);
		this.COMPONENT_LABELS[4].setText("A = 255");
		this.COMPONENT_LABELS[4].setFont(this.MENU_FONT);
		this.COMPONENT_LABELS[5].setText("Flight Time = 5 s");
		this.COMPONENT_LABELS[5].setFont(this.MENU_FONT);
		this.COMPONENT_LABELS[6].setText("Explosion = Simple Circle");
		this.COMPONENT_LABELS[6].setFont(this.MENU_FONT);
		this.COMPONENT_LABELS[7].setText("Speed = 5 m/s");
		this.COMPONENT_LABELS[7].setFont(this.MENU_FONT);
		this.COMPONENT_LABELS[8].setText("Angle = 90 degrees");
		this.COMPONENT_LABELS[8].setFont(this.MENU_FONT);
	}
	
	private void updateScreenDimensions() {
		this.MENU_DIMENSIONS = new Dimension(getWidth(), getHeight());
		if (this.DEBUG ) { System.out.println(this.MENU_DIMENSIONS); }
	}
	
	private ComponentAdapter resizeListener() {
		return new ComponentAdapter() {
    	    public void componentResized(ComponentEvent c) {
    	    	if (DEBUG) { System.out.println("@Resize event"); }
    	        updateScreenDimensions();
    	        
    	       // repaint();
    	    }
    	};
	}
	
	public Dimension getMenuDimensions() {
		return this.MENU_DIMENSIONS;
	}
	
	public void addMenuComponents() {
		
		this.initializeLabels();
		this.initializeSliders();
		this.LAUNCH_BUTTON = new JButton();
		
		this.LAUNCH_BUTTON.setText("LAUNCH!");
		
		this.LAUNCH_BUTTON.setPreferredSize(new Dimension(getWidth(),40));
		/*
		JPanel wrapper = new JPanel();
		
		
		
		this.EXPLOSION_OPTIONS.setRenderer(new MenuComboBox());

		this.EXPLOSION_OPTIONS.setSize(new Dimension(getWidth(),10));
		this.EXPLOSION_OPTIONS.setMinimumSize(new Dimension(getWidth(),10));
		
		this.EXPLOSION_OPTIONS.setPreferredSize(new Dimension(getWidth(),10));
		
		wrapper.setSize(getWidth(), 50);
		wrapper.add(this.EXPLOSION_OPTIONS);
		*/
		this.SLIDERS[0].setSize(new Dimension(getWidth()-50, 20));
		this.LAUNCH_BUTTON.setAlignmentX(this.CENTER_ALIGNMENT);
		//this.BLAST_RADIUS_SLIDER.setAlignmentX(this.getMenuDimensions().width/2);
		
		this.add(Box.createRigidArea(new Dimension(5, 15)));
		
		for (int i = 0; i < this.COMPONENT_LABELS.length; i++) {
			
			this.add(this.COMPONENT_LABELS[i]);
			this.add(this.SLIDERS[i]);
			this.add(Box.createRigidArea(new Dimension(5, 10)));
			
			if (i == 4) {
				this.add(Box.createRigidArea(new Dimension(5, 25)));
			}
			
			if (i == 0 || i == (this.COMPONENT_LABELS.length - 1)) {
				this.add(Box.createRigidArea(new Dimension(5, 25)));
			} 
		}
		/*
		this.add(this.COMPONENT_LABELS[0]);
		
		this.add(this.SLIDERS[0]);
		

		*/
		
		//this.add(this.EXPLOSION_OPTIONS);
		
		this.add(this.LAUNCH_BUTTON);
		
		this.updateFireworkColor();
	}
	
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
	

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
	    this.paintBackground(g); 
		g2d.setColor(this.MENU_COLOR);
		g2d.fill(getBounds());
		if (this.DEBUG ) { System.out.println("\t*Screen dimensions for menu " + this.getMenuDimensions());
		System.out.println(this.DEBUG_PFX + "[*] Finished repaint.");}
		
		g2d.setColor(this.FIREWORK_COLOR);
		
		g2d.drawRect(5, getHeight()-40, getWidth()-10, 40);
		g2d.fillRect(5, getHeight()-40, getWidth()-10, 40);
	}
	
	/*
	@Override
	public Dimension getPreferredSize() {
		return new Dimension((int) (getWidth()/2.5),getHeight());
	}
	*/

	public String getSliderAlias(ChangeEvent e) { //This could VERY easily break, I didn't want to have to do it this way but.. *shrug*
		if (this.DEBUG) { System.out.println(e); }
		switch (this.findSliderID(e)) {
			case 128:
				return "R";
			case 174:
				return "G";
			case 220:
				return "B";
			case 266:
				return "A";
			case 337:
				return "DEC";
			case 383:
				return "EXP";
			case 429:
				return "SPD";
			case 475:
				return "ANG";
			default:
				return "LR";
		}
	}
	
	public int findSliderID (ChangeEvent e) {
		String[] garbage = e.toString().split(",");
		return Integer.valueOf(garbage[2]);
	}
	
	
	public String adjustExplosionType(int pos) {
		switch (pos) {
			case 0:
				this.COMPONENT_LABELS[6].setText("Explosion = Simple Circle");
				
				this.SLIDERS[0].enable();
				return "Simple Circle";
			case 1:
				this.COMPONENT_LABELS[6].setText("Explosion = Sparkles");
				this.SLIDERS[0].disable();
				return "Sparkles";
			case 2:
				this.COMPONENT_LABELS[6].setText("Explosion = Nuclear");
				this.SLIDERS[0].enable();
				return "Nuclear";
			case 3:
				this.COMPONENT_LABELS[6].setText("Explosion = Randomness");
				this.SLIDERS[0].enable();
				return "Randomness";
			case 4:
				this.COMPONENT_LABELS[6].setText("Explosion = Hello!");
				this.SLIDERS[0].enable();
				return "Hello";
			case 5:
				this.COMPONENT_LABELS[6].setText("Explosion = Stars");
				this.SLIDERS[0].disable();
				return "Stars";
			case 6:
				this.COMPONENT_LABELS[6].setText("Explosion = Artifacts");
				this.SLIDERS[0].disable();
				return "Artifacts";
			default:
				return null;
		}
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
	        JSlider source = (JSlider)e.getSource();
	
	        //System.out.println(e);
	        
	        int r = (int)source.getValue();   
	        
	        //System.out.println(getSliderAlias(e) + " requested " );
	        switch(getSliderAlias(e)) {
	        	case "R":
	        		this.COMPONENT_LABELS[1].setText("R = " + r);
	        		break;
	        	case "G":
	        		this.COMPONENT_LABELS[2].setText("G = " + r);
	        		break;
	        	case "B":
	        		this.COMPONENT_LABELS[3].setText("B = " + r);
	        		break;
	        	case "A":
	        		this.COMPONENT_LABELS[4].setText("A = " + r);
	        		break;
	        	case "LR":
	        		this.COMPONENT_LABELS[0].setText("Explosion Radius: " + r + " ft");
	        		this.DESIRED_EXPLOSION_RADIUS = r;
	        		break;
	        	case "DEC":
	        		this.COMPONENT_LABELS[5].setText("Flight Time = " + r + " s");
	        		break;
	        	case "EXP":
	        		this.adjustExplosionType(r);
	        		break;
	        	case "SPD":
	        		this.COMPONENT_LABELS[7].setText("Speed = " + r + " m/s");
	        		break;
	        	case "ANG":
	        		this.COMPONENT_LABELS[8].setText("Angle = " + r + " degrees");
	        		break;
	        	default:
	        		break;
	        }     
	        
	        this.updateFireworkColor();
	}

	public void adjustRGBAPicker(int id) {
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Main.setDesiredExplosionStr(this.adjustExplosionType(this.SLIDERS[6].getValue()));
		int fixed = 0;
		
		Firework fw;
		
		try {
			fw = new Firework(this.FIREWORK_COLOR, 	  				 	 //Color
					Integer.valueOf(this.COMPONENT_LABELS[0].getText().split(" ")[2]),				 	 //ExplosionRadius
					Integer.valueOf(this.COMPONENT_LABELS[7].getText().split(" ")[2]),				 	 //Velocity
					(Integer.valueOf(this.COMPONENT_LABELS[5].getText().split(" ")[3])), 					//Flight Time
					Integer.valueOf(this.COMPONENT_LABELS[8].getText().split(" ")[2])			  			//Angle
					);
		} catch (Exception ex) {
			fw = new Firework(this.FIREWORK_COLOR, 	  				 	 //Color
					20,				 	 //ExplosionRadius
					Integer.valueOf(this.COMPONENT_LABELS[7].getText().split(" ")[2]),				 	 //Velocity
					(Integer.valueOf(this.COMPONENT_LABELS[5].getText().split(" ")[3])), 					//Flight Time
					Integer.valueOf(this.COMPONENT_LABELS[8].getText().split(" ")[2])			  			//Angle
					);
		}
		
		fw.setInitMaxAlpha(this.SLIDERS[4].getValue());
		
		Main.facilitateFireworkTransaction(fw);
	
		
	}
}
