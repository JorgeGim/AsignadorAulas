package negocio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import datos.MateriasJSON;

public class Solver 
{
	public ArrayList<Materia> _materias;
    public ArrayList<Aula> _aulas;
    ArrayList<Aula> _aulasDisponibles;
    ArrayList<Espectador> _espectadores;
	
	public Solver()
	{
		_materias = new ArrayList<>();
		_espectadores = new ArrayList<>();
		limpiarAulas();
	}
	
	public void agregarEspectador(Espectador e){
		
		_espectadores.add(e);
	}
	
	public void cargarMaterias(String archivo){
		try{
			MateriasJSON m = MateriasJSON.leerGSON(archivo);
			_materias = m.getMaterias();
			
			limpiarAulas();
			ordenarMaterias();
			
			asignarAulas();
		}
		catch(IllegalArgumentException e){
			
			throw new IllegalArgumentException("No se encuentra el listado de materias con nombre: "+ archivo);
		}
	}
	
	private void ordenarMaterias() {
		
		Collections.sort(_materias, new Comparador());
	}

	private void asignarAulas()
	{			
		for(Materia materia : _materias)
		{
			ubicarEnAula(materia);
		}
	}
	
	
	
	private void ubicarEnAula(Materia materia){
		
		int i = 0;
		
		while(!(_aulasDisponibles.get(i).asignar(materia)))
		{
			i++;
			
			if(i >= _aulasDisponibles.size())
			{
				Aula a = new Aula(_aulas.size());
				_aulas.add(a);
				_aulasDisponibles.add(a);
			}
		}
		
		for(Espectador e : _espectadores){
			
			e.notificar(i,materia);
		}
		
		Aula a = _aulasDisponibles.get(i);
		
		if(a.estaLlena()) _aulasDisponibles.remove(a);
	}
	
	private void limpiarAulas(){
		
		_aulas = new ArrayList<>();
		_aulasDisponibles = new ArrayList<>();
		Aula a = new Aula(_aulas.size());
		_aulas.add(a);
		_aulasDisponibles.add(a);
	}
	
	private class Comparador implements Comparator<Materia>{

		@Override
		public int compare(Materia arg0, Materia arg1) {
			// TODO Auto-generated method stub
			return arg0.getInicio() - arg1.getInicio();
		}
		
	}
}
