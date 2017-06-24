package interfaz;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Panel;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import datos.MateriasJSON;
import negocio.Aula;
import negocio.Espectador;
import negocio.Solver;

public class VentanaTabla {

	JInternalFrame frame;
	JTable _tabla;
	DefaultTableModel _model;
	EspectadorTabla _espectador;
	
	public VentanaTabla() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JInternalFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		
		
		_tabla.setPreferredScrollableViewportSize(new Dimension(440, 219));
		_tabla.setFillsViewportHeight(true);
		
		frame.getContentPane().add(panel);
	}
}
