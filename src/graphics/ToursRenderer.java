package graphics;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ToursRenderer extends DefaultTableCellRenderer{
	private static final long serialVersionUID = 1L;
	private Color background;
	private int tour;
	
	public ToursRenderer(Color c) {
		this.background = c;
		tour = 1;
	}
	
	public void setTour(int i) {
		this.tour = i;
	}
	
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		Font fonte = new Font("TimesRoman",Font.BOLD,12);
		
		cell.setBackground(this.background);
		cell.setForeground(Color.BLACK);
		if(((int)value) == tour) {
			cell.setFont(fonte);
			cell.setForeground(Color.RED);
		}
		return cell;
	}	
	
}
