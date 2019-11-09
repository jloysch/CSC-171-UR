import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

public class GUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton SWITCH, PRESS_ME;
	private JLabel BUTTON_PRESSES_INDICATOR;
	private int PRESSES;
	
	public GUI() {
		setLayout(new FlowLayout());
		setSize(new Dimension(800,800));
		setMinimumSize(new Dimension(300,300));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setupGUIElements();
	}
	
	private void setupGUIElements() {
		this.SWITCH = new JButton();
		this.SWITCH.setText("Off");
		
		this.PRESS_ME = new JButton();
		this.PRESS_ME.setText("Press me!");
		
		this.BUTTON_PRESSES_INDICATOR = new JLabel();
		this.BUTTON_PRESSES_INDICATOR.setText(String.valueOf("You've hit the button " + this.PRESSES + " times."));
		
		this.SWITCH.addActionListener(this);	
		this.PRESS_ME.addActionListener(this);
		
		add(this.PRESS_ME);
		add(this.BUTTON_PRESSES_INDICATOR);
		add(this.SWITCH);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.SWITCH) {
			SWITCH.setText(SWITCH.getText().equals("On") ? "Off" : "On");
		} else {
			this.BUTTON_PRESSES_INDICATOR.setText(String.valueOf("You've now hit the button " + ++this.PRESSES + " time(s)!"));
		}
	}

	public static void main(String args[]) {
		GUI gui = new GUI();
		gui.setVisible(true);
	}
}
