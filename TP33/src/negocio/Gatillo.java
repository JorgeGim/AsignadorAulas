package negocio;

public class Gatillo {
	
	private Solver _solver;
	
	public Gatillo(Solver s){
		
		_solver = s;
	}
	
	public boolean gatillar(String archivo){
		
		
		try{
			_solver.cargarMaterias(archivo);
			return true;
		}
		catch(IllegalArgumentException e){
			
			return false;
		}
	}
}
