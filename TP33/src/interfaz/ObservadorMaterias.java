package interfaz;

import javax.swing.JTable;

import negocio.Espectador;
import negocio.Solver;

public class ObservadorMaterias implements Espectador 
{
	Solver _solver;
	JTable _table;
	public ObservadorMaterias(Solver solver, JTable table)
	{
		_solver = solver;
		_table = table;
	}
	
	@Override
	public void notificar() 
	{
	
	}
	
}
