
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main extends JFrame{

	private static JPanel container = new JPanel();

	private static FireworksMenu fwm = new FireworksMenu();
    private static FireworkCanvas fwc = new FireworkCanvas();
    
    public static void main(String[] args) {
    	SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }

    
    public static void facilitateFireworkTransaction(Firework fw) {
    	fwc.launchFirework(fw);
    }
    
    public Main(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 800);
        //this.setLayout(new BorderLayout());
        this.setVisible(true);
       
        try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel"); 
        } catch(Exception doesntMatterDontCare){}
        

        

        container.setLayout(new GridBagLayout());
        
        this.setTitle("JLoysch - Fireworks Simulator");
 
        GridBagConstraints c = new GridBagConstraints();
        c.gridheight = 1;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.VERTICAL;
        c.weightx = 0;
        c.weighty = 0;
        c.gridx=0;
        c.gridy=0;
        container.add(fwm, c);

        c.fill = GridBagConstraints.BOTH;
        c.weightx=1;
        c.weighty=1;
        c.gridx = 1;
        c.gridy = 0;
        
        container.add(fwc, c);
        
        this.add(container);

        this.setMinimumSize(new Dimension(800,600));
        this.pack();
        this.revalidate();
        
        this.repaint();


        this.setVisible(true);
    }

 }
	
