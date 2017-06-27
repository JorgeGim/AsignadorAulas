package interfaz;

import java.awt.EventQueue;

import datos.PDF_to_JSON;
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
					PDF_to_JSON.toGSON("OFERTA-1-2017-ANUAL-2017-v14");
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
