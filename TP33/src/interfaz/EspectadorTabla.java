package interfaz;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import negocio.Espectador;

public class EspectadorTabla implements Espectador{
	
	JInternalFrame _frame;
	JTable _tabla;
	DefaultTableModel _model;
	
	public EspectadorTabla(JInternalFrame frame, JTable tabla, DefaultTableModel model){
		
		_frame = frame;
		_tabla = tabla;
		_model = model;
	}

	@Override
	public void notificar() {
		// TODO Auto-generated method stub
		
	}

}
