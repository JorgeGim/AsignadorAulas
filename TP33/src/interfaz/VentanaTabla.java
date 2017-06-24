package interfaz;

import java.awt.Dimension;
import java.awt.Panel;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VentanaTabla {

	JInternalFrame frame;
	JTable _tabla;
	DefaultTableModel _model;
	EspectadorTabla _espectador;
	
	public VentanaTabla() {

		frame = new JInternalFrame();
		frame.setBounds(0,100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		_tabla = new JTable();
		_model = new DefaultTableModel();
		
		_model.addColumn("AULAS");
		
		for(int i=0;i<24;i++){
			_model.addColumn(i+"hs");
		}
		
		_tabla.setModel(_model);
		
		 _tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		JScrollPane scrollPane = new JScrollPane(_tabla);
	    
		Panel panel = new Panel();
		panel.add(scrollPane);
		
		_tabla.setPreferredScrollableViewportSize(new Dimension(800, 500));
		_tabla.setFillsViewportHeight(true);
		
		frame.getContentPane().add(panel);
		
		_espectador = new EspectadorTabla(frame,_tabla,_model);
	}
}
