package negocio;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SolverTest {

	@Test
	public void asignarMateriaTest()
	{
		ArrayList<Materia> materias = inicializarMaterias();
		Solver solver = new Solver(materias);
		solver.asignarMaterias();
		
		assertTrue(solver._aulas.get(0)._materias[14].get_id()==1);
		assertTrue(solver._aulas.get(0)._materias[8].get_id()==2);
		assertTrue(solver._aulas.get(1)._materias[8].get_id()==3);
		assertTrue(solver._aulas.get(1)._materias[18].get_id()==4);
	}

	private ArrayList<Materia> inicializarMaterias() 
	{
		ArrayList<Materia> materias = new ArrayList<Materia>();
		
		Materia m1 = new Materia("Base de datos", 14, 18, 1);
		Materia m2 = new Materia("Programación I", 8, 12, 2);
		Materia m3 = new Materia("SOR", 8, 10, 3);
		Materia m4 = new Materia("Lógica", 18, 22, 4);
		materias.add(m1);
		materias.add(m2);
		materias.add(m3);
		materias.add(m4);
		
		return materias;
	}

}
