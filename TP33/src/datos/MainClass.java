package datos;

import negocio.Materia;

public class MainClass 
{
	public static void main(String args[])
	{
		Materia m1 = new Materia("Programacion", 8, 12, 1);
		Materia m2 = new Materia("Organizacion del computador", 8, 12, 1);
		Materia m3 = new Materia("SOR", 8, 12, 1);
		
		MateriasGSON lasMaterias = new MateriasGSON();
		lasMaterias.addMateria(m1);
		lasMaterias.addMateria(m2);
		lasMaterias.addMateria(m3);
		
		lasMaterias.generarJSON("materias.JSON");
		
		MateriasGSON leidas = new MateriasGSON().leerJSON("materias.JSON");
		
		for(int i=0; i<leidas.getTamaño(); ++i)
		{
			Materia materia = leidas.getMateria(i);
			
			System.out.println(materia.getNombre() +" "+ materia.getInicio() + " " + materia.getFin() + " " + materia.get_id());
		}
	}
}
