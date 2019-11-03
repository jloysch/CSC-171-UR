/**
 * ----- DEPRECATED -----
 * @author Joshua John Reuben Loysch
 * @Version 1.7.0r0
 * Intellectual property of Joshua John Reuben Loysch, all rights reserved.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JComponent;

public class Canvas extends JComponent implements MouseListener, MouseMotionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	private ArrayList<Point> CIRCLE_POINTS;
	private ArrayList<Point> TMP_POINTS;
	private Point CURRENT_POSITION;
	private ArrayList<Character> CHAR_DATA;
	private boolean TEXT_IN_PROGRESS;
	private Color DRAWING_COLOR;
	
	public Canvas() {
		setBackground(Color.WHITE);
		setFocusable(true);
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
		this.CIRCLE_POINTS = new ArrayList<Point>();
		this.TMP_POINTS = new ArrayList<Point>();
		this.CURRENT_POSITION = new Point();
		this.CHAR_DATA = new ArrayList<Character>();
		this.TEXT_IN_PROGRESS = false;
		this.DRAWING_COLOR = Color.BLACK;
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(e);
		
		if (!this.TEXT_IN_PROGRESS || this.CHAR_DATA.size() > 0) {
			this.CIRCLE_POINTS.add(new Point(e.getX(), e.getY()));
		}

		this.TEXT_IN_PROGRESS = false;
		this.CHAR_DATA.clear();
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println(e);

		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println(e);
		
		
		if (this.TMP_POINTS.size() > 0) {
			System.out.println((int) this.TMP_POINTS.get(0).getX() + "\n" + 
					(int) this.TMP_POINTS.get(0).getY() + "\n" + 
					(int) this.TMP_POINTS.get(this.TMP_POINTS.size()-1).getX() + "\n" +  
					(int) this.TMP_POINTS.get(this.TMP_POINTS.size()-1).getY());
		
			this.getGraphics().setColor(this.DRAWING_COLOR);
			
			this.getGraphics().drawLine((int) this.TMP_POINTS.get(0).getX(),
					(int) this.TMP_POINTS.get(0).getY(), 
					e.getX(), 
					e.getY());
		
			this.TMP_POINTS.clear();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println(e);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println(e);
		
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(this.DRAWING_COLOR);
        
        for (Point point : this.CIRCLE_POINTS) {
            g2.fillOval(point.x, point.y, 20, 20);
        }
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		this.TMP_POINTS.add(new Point(e.getX(), e.getY()));
		System.out.println(e);
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {

			this.CURRENT_POSITION = new Point(e.getX(), e.getY());
	
		
		
	}
	
	private char[] getCharArray() {
		char[] c = new char[this.CHAR_DATA.size()];
		
		for (int i = 0; i < this.CHAR_DATA.size(); i++) {
			c[i] = this.CHAR_DATA.get(i);
		}
		
		return c;
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		this.TEXT_IN_PROGRESS = true;
		
		System.out.println((int) e.getKeyChar());
		
		if ((int) e.getKeyChar() == 8) {
			System.out.println("\n\n!! BACKSPACE");
			if (this.CHAR_DATA.size() > 0) {
				System.out.println("Removing " + (int) this.CHAR_DATA.get(this.CHAR_DATA.size()-1));
				this.CHAR_DATA.remove(this.CHAR_DATA.size()-1);
				repaint();
			}
			System.out.println("REDRAWING CHAR ARRAY");
			
		}
		
		System.out.println(e);
		
		this.getGraphics().drawChars(getCharArray(), 0, getCharArray().length, (int) this.CURRENT_POSITION.getX(), (int) this.CURRENT_POSITION.getY());
		
	}
/*
 * Let the user change the color used for painting by pressing a number key. Let the
different numeric keys correspond to different colors and switch the drawing color
depending on which key is pressed. If you want to use the numeric keypad for this, you
might look into KeyEvent.getKeyLocation() and KeyEvent.KEY LOCATION NUMPAD,
as well as the VK NUMPAD constants.
 */

	public void checkColorChange(KeyEvent e) {
		switch ((int) e.getKeyChar()) {
			case 48:
				System.out.println("0");
				this.DRAWING_COLOR = Color.BLACK;
				break;
			case 49:
				System.out.println("1");
				this.DRAWING_COLOR = Color.RED;
				break;
			case 50:
				System.out.println("2");
				this.DRAWING_COLOR = Color.ORANGE;
				break;
			case 51:
				System.out.println("3");
				this.DRAWING_COLOR = Color.GREEN;
				break;
			case 52:
				System.out.println("4");
				this.DRAWING_COLOR = Color.BLUE;
				break;
			case 53:
				System.out.println("5");
				this.DRAWING_COLOR = Color.CYAN;
				break;
			case 54:
				System.out.println("6");
				this.DRAWING_COLOR = Color.darkGray;
				break;
			case 55:
				System.out.println("7");
				this.DRAWING_COLOR = Color.magenta;
				break;
			case 56:
				System.out.println("8");
				this.DRAWING_COLOR = Color.decode("#7F4D6C");
				break;
			case 57:
				System.out.println("9");
				this.DRAWING_COLOR = Color.decode("#3D1F3C");
				break;
			default:
				break;
		}
		repaint();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		this.checkColorChange(e);
		
		if (!(((int) e.getKeyChar()) == 8)) {
			this.CHAR_DATA.add(e.getKeyChar());
		}
		
		System.out.println(e);	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println(e);	
	}
}
