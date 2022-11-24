package graphics;

import javax.swing.table.AbstractTableModel;

public class ToursModel extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String donnees[][] = new String[10][1];
   
   public int getColumnCount(){ 
      return donnees[0].length; 
   }
   public Object getValueAt(int parm1, int parm2){ 
      return parm1+1; 
   }
   
   public int getRowCount() { 
      return donnees.length; 
   }
   public String getColumnName(int col){ 
      return null; 
   } 
   
   public Class<?> getColumnClass(int columnIndex) {
       return String.class;
    }
}
