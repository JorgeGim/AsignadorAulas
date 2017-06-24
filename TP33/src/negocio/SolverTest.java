package negocio;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import datos.MateriasJSON;

public class SolverTest {
	
	@Before
	public void inicializar(){
		
		inicializarMaterias();
		mismosHorarios();
		aulaCompleta();
	}

	@Test
	public void asignarMateria1Test()
	{
		Solver solver = new Solver();
		solver.cargarMaterias("materiasTest.GSON");
		
		assertTrue(solver._aulas.get(0)._materias[14].get_id()==1);
	}
	
	@Test
	public void asignarMateria2Test()
	{
		Solver solver = new Solver();
		solver.cargarMaterias("materiasTest.GSON");
		
		assertTrue(solver._aulas.get(0)._materias[8].get_id()==2);
	}
	
	@Test
	public void asignarMateria3Test()
	{
		Solver solver = new Solver();
		solver.cargarMaterias("materiasTest.GSON");
		
		assertTrue(solver._aulas.get(1)._materias[8].get_id()==3);
	}
	
	@Test
	public void asignarMateria4Test()
	{
		Solver solver = new Solver();
		solver.cargarMaterias("materiasTest.GSON");
		
		assertTrue(solver._aulas.get(0)._materias[18].get_id()==4);
	}
	
	@Test
	public void mismosHorariosTest()
	{
		Solver solver = new Solver();
		solver.cargarMaterias("mismosHorariosTest.GSON");
		
		assertTrue(solver._aulas.size() == MateriasJSON.leerGSON("mismosHorariosTest.GSON").getTamaño());
	}
	
	@Test
	public void llenarAulaTest()
	{
		Solver solver = new Solver();
		solver.cargarMaterias("aulaCompleta.GSON");
		
		assertTrue(solver._aulasDisponibles.size() == 0);
		assertTrue(solver._aulas.size() == 1);
	}

	private void inicializarMaterias() 
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
		
		MateriasJSON m = new MateriasJSON(materias);
		m.generarGSON("materiasTest.GSON");
	}
	
	private void mismosHorarios() 
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
		
		MateriasJSON m = new MateriasJSON(materias);
		m.generarGSON("mismosHorariosTest.GSON");
	}
	
	private void aulaCompleta() 
	{
		ArrayList<Materia> materias = new ArrayList<Materia>();
		
		Materia m1 = new Materia("Base de datos", 0, 8, 1);
		Materia m2 = new Materia("Programación I", 8, 12, 2);
		Materia m3 = new Materia("SOR", 12, 18, 3);
		Materia m4 = new Materia("Lógica", 18, 24, 4);
		materias.add(m1);
		materias.add(m2);
		materias.add(m3);
		materias.add(m4);
		
		MateriasJSON m = new MateriasJSON(materias);
		m.generarGSON("aulaCompleta.GSON");
	}
}
