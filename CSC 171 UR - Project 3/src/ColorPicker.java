import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColorPicker extends JComponent implements ChangeListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//RGBA 
	
	private Component[] COMPONENTS = new Component[8];
	
	private JSlider[] SLIDERS = new JSlider[4];
	private JLabel[] LABELS = new JLabel[4];
	
	public ColorPicker() {
		this.setAlignmentX(this.CENTER_ALIGNMENT);
		this.setFocusable(true);
		this.build();
		repaint();
		setVisible(true);
	}
	
	public void build() {
		/*
		for (int i = 0; i < this.COMPONENTS.length; i++) {
			if ( i < 4) { 
				this.COMPONENTS[i] = new JLabel();
				((JLabel) this.COMPONENTS[i]).setAlignmentX(this.CENTER_ALIGNMENT);
			} else {
				this.COMPONENTS[i] = new JSlider();
				((JSlider) this.COMPONENTS[i]).addChangeListener(this);
				((JSlider) this.COMPONENTS[i]).setMaximum(255);
			}
			
			this.COMPONENTS[i].setVisible(true);
			this.add(COMPONENTS[i]);
			this.COMPONENTS[i].setVisible(true);
			System.out.println("ADDED A " + this.COMPONENTS[i]);
		}
		
		((JLabel) this.COMPONENTS[0]).setText("R | (Red)");
		((JLabel) this.COMPONENTS[0]).setText("G | (Green)");
		((JLabel) this.COMPONENTS[0]).setText("B | (Blue) ");
		((JLabel) this.COMPONENTS[0]).setText("A | (Alpha) ");
		*/
		this.buildSliders();
		this.buildLabels();
	}
	
	public void buildLabels() {
		for (int i = 0; i < this.LABELS.length; i++) {
			this.LABELS[i] = new JLabel();
			this.LABELS[i].setAlignmentX(this.CENTER_ALIGNMENT);
			this.add(this.LABELS[i]);
		}
		
		this.LABELS[0].setText("R = ");
		this.LABELS[1].setText("G = ");
		this.LABELS[2].setText("B = ");
		this.LABELS[3].setText("A = ");
	}
	
	public void buildSliders() {
		for (int i = 0; i < this.SLIDERS.length; i++) {
			this.SLIDERS[i] = new JSlider();
			this.SLIDERS[i].addChangeListener(this);
			this.SLIDERS[i].setMaximum(255);
			this.add(this.SLIDERS[i]);
		}
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
	        JSlider source = (JSlider)e.getSource();

	}

	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.RED);
		g2d.drawRect(20,20,20,20);
	}

}
