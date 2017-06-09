package negocio;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SolverTest {

	@Test
	public void asignarMateria1Test()
	{
		ArrayList<Materia> materias = inicializarMaterias();
		Solver solver = new Solver(materias);
		solver.asignarMaterias();
		
		assertTrue(solver._aulas.get(0)._materias[14].get_id()==1);
	}
	
	@Test
	public void asignarMateria2Test()
	{
		ArrayList<Materia> materias = inicializarMaterias();
		Solver solver = new Solver(materias);
		solver.asignarMaterias();
		
		assertTrue(solver._aulas.get(0)._materias[8].get_id()==2);
	}
	
	@Test
	public void asignarMateria3Test()
	{
		ArrayList<Materia> materias = inicializarMaterias();
		Solver solver = new Solver(materias);
		solver.asignarMaterias();
		
		assertTrue(solver._aulas.get(1)._materias[8].get_id()==3);
	}
	
	@Test
	public void asignarMateria4Test()
	{
		ArrayList<Materia> materias = inicializarMaterias();
		Solver solver = new Solver(materias);
		solver.asignarMaterias();
		
		assertTrue(solver._aulas.get(1)._materias[18].get_id()==4);
	}
	
	@Test
	public void mismosHorariosTest()
	{
		ArrayList<Materia> materias = mismosHorarios();
		Solver solver = new Solver(materias);
		solver.asignarMaterias();
		
		assertTrue(solver._aulas.size() == materias.size());
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
	
	private ArrayList<Materia> mismosHorarios() 
	{
		ArrayList<Materia> materias = new ArrayList<Materia>();
		
		Materia m1 = new Materia("Base de datos", 8, 12, 1);
		Materia m2 = new Materia("Programación I", 8, 12, 2);
		Materia m3 = new Materia("SOR", 8, 12, 3);
		Materia m4 = new Materia("Lógica", 8, 12, 4);
		materias.add(m1);
		materias.add(m2);
		materias.add(m3);
		materias.add(m4);
		
		return materias;
	}
}
