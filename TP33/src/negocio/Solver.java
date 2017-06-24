package negocio;

import java.util.ArrayList;
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
		_aulas = new ArrayList<>();
		_aulasDisponibles = new ArrayList<>();
		_espectadores = new ArrayList<>();
		
		Aula a = new Aula(_aulas.size());
		_aulas.add(a);
		_aulasDisponibles.add(a);
	}
	
	public void agregarEspectador(Espectador e){
		
		_espectadores.add(e);
	}
	
	public void cargarMaterias(String archivo){
		
		MateriasJSON m = MateriasJSON.leerGSON(archivo);
		_materias = m.getMaterias();
		
		asignarAulas();
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
}
