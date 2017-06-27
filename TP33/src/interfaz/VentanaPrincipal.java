package interfaz;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import negocio.Gatillo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

public class VentanaPrincipal {

	private JFrame _frame;
	private Gatillo _gatillo;
	private VentanaTabla _tabla;
	private JLabel _instruccion;
	private JTextField _ubicacion;
	private JLabel _error;
	private JButton _buscar;
	private JFileChooser _buscador;
	private JButton _cargar;

	public VentanaPrincipal(Gatillo g) {
		
		_frame = new JFrame();
		_gatillo = g;
		_tabla = new VentanaTabla();
		_instruccion = new JLabel("**Ingrese la dirección del archivo**");
		_ubicacion = new JTextField();
		_error = new JLabel("Archivo no encontrado!!!");
		_buscar = new JButton("BUSCAR");
		_buscador = new JFileChooser();
		_cargar = new JButton("CARGAR");
	
		_frame.setBounds(0, 0, 800, 600);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.getContentPane().setLayout(null);
		_frame.setVisible(true);
		
		JInternalFrame iFrame = _tabla._frame;
		_frame.getContentPane().add(iFrame);
		
		_instruccion.setBounds(10,56,765,17);
		_frame.getContentPane().add(_instruccion);
		
		_ubicacion.setBounds(10, 76, 765, 17);
		Font aux = _ubicacion.getFont();
		_ubicacion.setFont(new Font(aux.getFontName(), aux.getStyle(), 12));
		_frame.getContentPane().add(_ubicacion);
		
		_error.setBounds(450, 11, 350, 30);
		_error.setFont(_ubicacion.getFont());
		_error.setForeground(Color.RED);
		_error.setVisible(false);
		_frame.getContentPane().add(_error);
		
		_buscar.setBounds(10, 11, 200, 30);
		_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				_buscador.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				_buscador.showOpenDialog(_buscador);
				
				File archivo = _buscador.getSelectedFile(); // obtiene el archivo seleccionado
				_ubicacion.setText(archivo.getAbsolutePath());
			
			}
		});
		_frame.getContentPane().add(_buscar);
		
		_cargar.setBounds(220, 11, 200, 30);
		_cargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				_tabla.limpiarTabla();
				
				if(_gatillo.gatillar(_ubicacion.getText()))
					_error.setVisible(false);
				
				else
					_error.setVisible(true);
			}
		});
		_frame.getContentPane().add(_cargar);
	}
	
	public EspectadorTabla getEspectador(){
		
		return _tabla._espectador;
	}
	
	public void visualizar(){
		
		_frame.setVisible(true);
	}
}
