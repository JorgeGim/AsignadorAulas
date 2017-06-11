package negocio;

public class Aula 
{
    Materia[] _materias;
    private int _espacio;
	private boolean _llena;
	
	public Aula()
	{
		_espacio = 24;
		_materias = new Materia[_espacio];
		_llena = false;
	}
	
	public boolean asignar(Materia materia)
	{
		if(chequearEspacio(materia))
		{
			for(int i=materia.getInicio(); i<materia.getFin(); ++i)
			{
				_materias[i] = materia;
				_espacio--;
			}
			
			if(_espacio==0) _llena = true;
			
			return true;
		}
			
		return false;
	}

	private boolean chequearEspacio(Materia materia) 
	{
		for(int i=materia.getInicio(); i<materia.getFin(); i++)
		{
			if(_materias[i] != null)
				return false;
		}
		
		return true;
	}
}
