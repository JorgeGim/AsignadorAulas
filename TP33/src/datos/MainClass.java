package datos;

import java.util.ArrayList;

import negocio.Materia;

public class MainClass 
{
	public static void main(String args[])
	{
		Materia m1 = new Materia("Programacion", 8, 12, 1);
		Materia m2 = new Materia("Organizacion del computador", 8, 12, 1);
		Materia m3 = new Materia("SOR", 8, 12, 1);
		
		MateriasGSON lasMaterias = new MateriasGSON(new ArrayList<Materia>());
		lasMaterias.addMateria(m1);
		lasMaterias.addMateria(m2);
		lasMaterias.addMateria(m3);
		
		lasMaterias.generarGSON("materias.GSON");
		
		MateriasGSON leidas = MateriasGSON.leerGSON("materias.GSON");
		
		for(int i=0; i<leidas.getTamaño(); ++i)
		{
			Materia materia = leidas.getMateria(i);
			
			System.out.println(materia.getNombre() +" "+ materia.getInicio() + " " + materia.getFin() + " " + materia.get_id());
		}
	}
}
