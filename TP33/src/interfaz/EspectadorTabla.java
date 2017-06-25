package interfaz;

import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;

import negocio.Espectador;
import negocio.Materia;

public class EspectadorTabla implements Espectador{
	
	private JInternalFrame _frame;
	private DefaultTableModel _model;
	
	public EspectadorTabla(JInternalFrame frame, DefaultTableModel model){
		
		_frame = frame;
		_model = model;
	}

	@Override
	public void notificar(int aula, Materia m) {
		System.out.println("Materia "+ m.getNombre()+" asignada al aula: "+aula);
		
		if(_model.getRowCount()<=aula){
		
			String[] fila = new String[25];
			_model.addRow(fila);
		}	
		_model.setValueAt(aula, aula, 0);
			
		for(int i=m.getInicio(); i<m.getFin()+1;i++){
				
			_model.setValueAt(m.getNombre(), aula, i);
		}
		_frame.updateUI();
	}

}
