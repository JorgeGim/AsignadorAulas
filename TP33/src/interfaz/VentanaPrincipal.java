package interfaz;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import datos.MateriasGSON;
import negocio.Aula;
import negocio.Solver;

public class VentanaPrincipal {

	JFrame frame;
	JInternalFrame _internalFrame;
	JButton _boton;
	MainForm _main;


	public VentanaPrincipal(MainForm main) {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
	}

}
