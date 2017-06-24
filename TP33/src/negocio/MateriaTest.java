package negocio;

import org.junit.Test;

public class MateriaTest {

	@SuppressWarnings("unused")
	@Test
	public void happyPath()
	{
		Materia materia = new Materia("Base de datos", 14, 18, 2);
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
