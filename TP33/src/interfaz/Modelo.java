package interfaz;

import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class Modelo extends DefaultTableModel {
	
	   public boolean isCellEditable (int row, int column)
	   {
	       // Aquí evitamos que todas las celdas sean editables;
	       return false;
	   }

}
