package negocio;

public class Aula 
{
    Materia[] _materias;
	private boolean _llena;
	
	public Aula()
	{
		_materias = new Materia[24];
		_llena = false;
	}
	
	public boolean asignar(Materia materia)
	{
		if(chequearEspacio(materia))
		{
			for(int i=materia.getInicio(); i<materia.getFin(); ++i)
			{
				_materias[i] = materia;
			}
			
			return true;
		}
			
		return false;
	}

	private boolean chequearEspacio(Materia materia) 
	{
		for(int i=materia.getInicio(); i<materia.getFin(); ++i)
		{
			if(_materias[i] != null)
				return false;
		}
		
		return true;
	}
}
