package interfaz;

import java.awt.EventQueue;
import negocio.*;

public class MainForm 
{
	private static Solver _solver;
	private static VentanaPrincipal _ventana;
	private static Gatillo _gatillo;
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_solver = new Solver();
					_gatillo = new Gatillo(_solver);
					_ventana = new VentanaPrincipal(_gatillo);
					_solver.agregarEspectador(_ventana.getEspectador());
					_ventana.visualizar();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
