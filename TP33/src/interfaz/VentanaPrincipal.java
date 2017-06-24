package interfaz;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import negocio.Gatillo;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal {

	private JFrame _frame;
	private Gatillo _gatillo;
	private VentanaTabla _tabla;
	private JTextField _texto;
	private JButton _buscar;
	private JButton _cargar;

	public VentanaPrincipal(Gatillo g) {
		
		_frame = new JFrame();
		_gatillo = g;
		_tabla = new VentanaTabla();
		_texto = new JTextField();
		_buscar = new JButton("BUSCAR");
		_cargar = new JButton("CARGAR");
	
		_frame.setBounds(0, 0, 800, 600);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.getContentPane().setLayout(null);
		_frame.setVisible(true);
		
		JInternalFrame iFrame = _tabla.frame;
		_frame.getContentPane().add(iFrame);
		
		_texto.setBounds(10, 56, 765, 30);
		Font aux = _texto.getFont();
		_texto.setFont(new Font(aux.getFontName(), aux.getStyle(), 25));
		_frame.getContentPane().add(_texto);
		
		_buscar.setBounds(10, 11, 200, 30);
		_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		_frame.getContentPane().add(_buscar);
		
		_cargar.setBounds(220, 11, 200, 30);
		_cargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
