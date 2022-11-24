package graphics;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

public class MastermindRenderer extends DefaultTableCellRenderer{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color[] colors = {Color.red, Color.blue, Color.cyan, Color.yellow, Color.MAGENTA, Color.orange,Color.GREEN,Color.BLACK, Color.WHITE};
    private ArrayList<String> colorsS = new ArrayList<String>() {{add("RED"); add("BLUE"); add("CYAN"); add("YELLOW"); add("MAGENTA"); add("ORANGE");add("GREEN"); add("BLACK"); add("WHITE");}};

    public Color findColor(String s) {
    	int i = 0;
    	for(String elem : colorsS) {
    		if(elem.compareTo(s) == 0) {
    			return colors[i];
    		}
    		++i;
    	}
    	System.out.println("Not found! "+s+"!");
    	return Color.GREEN;
    }
    
    
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		this.setOpaque(true);
		Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		
		Object o = table.getModel().getValueAt(row,column);
		Color c = Color.WHITE;
		if(o != null) {
				c = this.findColor(o.toString());
		}
		cell.setForeground(c);
		cell.setBackground(c);
	    return cell;
	}	
}
