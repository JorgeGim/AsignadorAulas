package negocio;

import java.util.ArrayList;

public class Solver 
{
	private ArrayList<Materia> _materias;
    ArrayList<Aula> _aulas;
	
	public Solver(ArrayList<Materia> materias)
	{
		_materias = materias;
		_aulas = new ArrayList<Aula>();
		_aulas.add(new Aula());
	}
	
	public void asignarAulas()
	{			
		for(Materia materia : _materias)
		{
			ubicarEnAula(materia);
		}
	}
	
	private void ubicarEnAula(Materia materia){
		
		int i = 0;
		
		while(!(_aulas.get(i).asignar(materia)))
		{
			i++;
			
			if(i >= _aulas.size())	_aulas.add(new Aula());
		}
	}
}
