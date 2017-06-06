package datos;

import negocio.Materia;

public class MainClass 
{
	public static void main(String args[])
	{
		Materia m1 = new Materia("Programacion", 8, 12, 1);
		Materia m2 = new Materia("Organizacion del computador", 8, 12, 1);
		Materia m3 = new Materia("SOR", 8, 12, 1);
		
		MateriasJSON lasMaterias = new MateriasJSON();
		lasMaterias.addMateria(m1);
		lasMaterias.addMateria(m2);
		lasMaterias.addMateria(m3);
		
		lasMaterias.generarJSON("materias.JSON");
		
		MateriasJSON leidas = new MateriasJSON().leerJSON("materias.JSON");
		
		for(int i=0; i<leidas.getTama�o(); ++i)
		{
			Materia materia = leidas.getMateria(i);
			
			System.out.println(materia.getNombre() +" "+ materia.getInicio() + " " + materia.getFin() + " " + materia.get_id());
		}
	}
}
