package interfaz;

import java.awt.EventQueue;
import java.util.ArrayList;

import datos.MateriasJSON;
import negocio.Aula;
import negocio.Solver;

public class MainForm 
{
	static ArrayList<Aula> _aulas;
	static MateriasJSON _materias;
	static Solver _solver;
	static VentanaPrincipal _ventana;
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_ventana = new VentanaPrincipal();
					_ventana.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

}
