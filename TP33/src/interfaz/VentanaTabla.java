package interfaz;

import java.awt.Dimension;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class VentanaTabla {

	JInternalFrame _frame;
	JTable _tabla;
	Modelo _model;
	EspectadorTabla _espectador;
	
	public VentanaTabla() {
		
		_model = new Modelo();
		_model.addColumn("AULAS");
	
		for(int i=0;i<24;i++){
			_model.addColumn(i+"hs");
		}
		
		_tabla = new JTable();
		_tabla.getTableHeader().setReorderingAllowed(false) ;
		_tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		_tabla.setPreferredScrollableViewportSize(new Dimension(757, 410));
		_tabla.setModel(_model);
		
		JScrollPane scrollPane = new JScrollPane(_tabla);
		scrollPane.setBounds(0,0,757,410);
		
		scrollPane.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
	    
		Panel panel = new Panel();
		panel.setBounds(0,0,757,410);
		panel.add(scrollPane);
		

		_frame = new JInternalFrame();
		_frame.setBounds(0,100, 784, 462);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		((BasicInternalFrameUI) _frame.getUI()).setNorthPane(null);
		_frame.getContentPane().add(panel);
		_frame.setVisible(true);
		
		_espectador = new EspectadorTabla(_frame,_model);
	}
	
	public void limpiarTabla(){
		
		while(_model.getRowCount()>0)
			for(int i=0;i<_model.getRowCount();i++){
				_model.removeRow(i);
			}
	}
}
