package negocio;

import static org.junit.Assert.*;

import org.junit.Test;

public class MateriaTest {


	@Test
	public void happyPath()
	{
		Materia materia = new Materia("Base de datos", 14, 18, 2);
		
		assertTrue(materia.getNombre().equals("Base de datos"));
		assertTrue(materia.getInicio()==14);
		assertTrue(materia.getFin()==18);
		assertTrue(materia.get_id()==2);
	}
	
	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void inicioErroneoTest()
	{
		Materia materia = new Materia("Base de datos", -2, 18, 2);
	}
	
	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void finErroneoTest()
	{
		Materia materia = new Materia("Base de datos", 14, -1, 2);
	}
}
