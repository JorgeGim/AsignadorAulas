package interfaz;

import java.awt.Dimension;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

public class VentanaTabla {

	JInternalFrame frame;
	JTable _tabla;
	DefaultTableModel _model;
	EspectadorTabla _espectador;
	
	public VentanaTabla() {

		frame = new JInternalFrame();
		frame.setBounds(0,100, 784, 462);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		((BasicInternalFrameUI) frame.getUI()).setNorthPane(null);
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
		scrollPane.setBounds(0,0,757,410);
		
		scrollPane.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
	    
		Panel panel = new Panel();
		panel.setBounds(0,0,757,410);
		panel.add(scrollPane);
		
		_tabla.setPreferredScrollableViewportSize(new Dimension(757, 410));
		_tabla.setFillsViewportHeight(true);
		
		frame.getContentPane().add(panel);
		
		_espectador = new EspectadorTabla(frame,_model);
	}
	
	public void limpiarTabla(){
		
		while(_model.getRowCount()>0)
			for(int i=0;i<_model.getRowCount();i++){
				_model.removeRow(i);
			}
	}
}
