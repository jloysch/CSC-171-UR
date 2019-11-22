import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class MenuComboBox extends JLabel implements ListCellRenderer {
	
	public MenuComboBox() {
		
	}
	
	 @Override
	  public Component getListCellRendererComponent(JList list, Object value,
	      int index, boolean isSelected, boolean cellHasFocus) {

	    JLabel label = new JLabel() {
	      public Dimension getPreferredSize() {
	        return new Dimension(200, 40);
	      }
	    };
	    label.setText(String.valueOf(value));

	    return label;
	  }

}
