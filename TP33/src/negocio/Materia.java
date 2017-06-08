package negocio;

public class Materia
{
	private String _nombre;
	private int _inicio;
	private int _fin;
	private int _id;
	
	public Materia(String nombre, int inicio, int fin, int id)
	{
		chequearHorario(inicio);
		chequearHorario(fin);
			
		_nombre = nombre;
		_inicio = inicio;
		_fin = fin;
		_id = id;
	}

	private void chequearHorario(int horario) {
		if(horario < 0 || horario > 24 )
			throw new IllegalArgumentException("Se intentó agregar una materia con horario incorrecto!");
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}

	public int getInicio() {
		return _inicio;
	}

	public void setInicio(int inicio) {
		_inicio = inicio;
	}

	public int getFin() {
		return _fin;
	}

	public void set_fin(int fin) {
		_fin = fin;
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int id) {
		_id = id;
	}
}
