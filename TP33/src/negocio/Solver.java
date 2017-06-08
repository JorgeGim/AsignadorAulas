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
	}
	
	public void asignarMaterias()
	{
		if(_aulas.size()==0) _aulas.add(new Aula());
		
		int i = 0;
		
		for(Materia materia : _materias)
		{
			while(!(_aulas.get(i).asignar(materia)))
			{
				i++;
				if(i >= _aulas.size())
				{
					Aula aula = new Aula();
					_aulas.add(aula);
				}
			}
		}
	}
}
