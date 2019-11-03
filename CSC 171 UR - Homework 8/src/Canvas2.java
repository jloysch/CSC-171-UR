/**
 * @author Joshua John Reuben Loysch
 * @Version 1.2.1r0
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

public class Canvas2 extends JComponent implements MouseListener, MouseMotionListener, KeyListener{

	private static final long serialVersionUID = 1L;
	private ArrayList<Point> CIRCLES;
	private Color DRAWING_COLOR;
	private Point MOUSE_CURSOR_POS, TEXT_INIT_POS;
	private String CHAR_DATA;
	boolean GOT_TEXT_INIT;
	
	public Canvas2() {
		setBackground(Color.WHITE);
		setFocusable(true);
		
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
		
		this.DRAWING_COLOR = Color.BLACK;
		this.CIRCLES = new ArrayList<Point>();
		this.CHAR_DATA = "";
		this.MOUSE_CURSOR_POS = new Point(0,0);
		this.TEXT_INIT_POS = new Point(0,0);
		this.GOT_TEXT_INIT = false;
	}
	
	public void drawCircle(Point p) {
		this.CIRCLES.add(p);
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(this.DRAWING_COLOR);
        
        for (Point p : this.CIRCLES) {
        	g2.drawOval(p.x, p.y, 20, 20);
        	g2.fillOval(p.x, p.y, 20, 20);
        }
        
        g2.drawChars(this.CHAR_DATA.toCharArray(), 0, this.CHAR_DATA.length(), this.TEXT_INIT_POS.x, this.TEXT_INIT_POS.y);
      

	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println(e);
		
		if (((int) e.getKeyChar() > 48) & ((int) e.getKeyChar() < 58)) {
			this.checkColorChange(e);
		} else {
			if (!(((int) e.getKeyChar()) == 8) & !((int) e.getKeyChar() == 16)) {
				this.CHAR_DATA+=e.getKeyChar();
			} else {
				if ((int) e.getKeyChar() == 8) {
					if (this.CHAR_DATA.length() > 1) {
						this.CHAR_DATA = this.CHAR_DATA.substring(0, this.CHAR_DATA.length()-1);
					} else if (this.CHAR_DATA.length() == 1) {
						this.CHAR_DATA = "";
					}
					
				}
			}
		}

		repaint();
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (!this.GOT_TEXT_INIT) {
			this.TEXT_INIT_POS = MOUSE_CURSOR_POS;
			this.GOT_TEXT_INIT = true;
		} 
	
		System.out.println(e);	
	}
	

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println(e);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		this.CIRCLES.add(e.getPoint());
		repaint();
		System.out.println(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println(e);
		this.MOUSE_CURSOR_POS = e.getPoint();
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(e);	
	}

	@Override
	public void mousePressed(MouseEvent e) { //Feels more responsive when it's here, but would also draw points at line beginnings.
		System.out.println(e);
		if (e.getButton() == MouseEvent.BUTTON1) {
			
			drawCircle(e.getPoint());
		
		} else if (e.getButton() == MouseEvent.BUTTON3) {
			this.CIRCLES.clear();
			repaint();
		}
	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println(e);
		this.CHAR_DATA = "";
		this.GOT_TEXT_INIT = false;
		this.MOUSE_CURSOR_POS = e.getPoint();
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println(e);	
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println(e);
	}

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
}
