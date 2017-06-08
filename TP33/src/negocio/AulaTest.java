package negocio;

import static org.junit.Assert.*;

import org.junit.Test;

public class AulaTest {

	@Test
	public void asignarTest()
	{
		Aula aula = new Aula();
		Materia materia = new Materia("Base de datos", 14, 18, 1);
		aula.asignar(materia);
		assertTrue(aula._materias[14] != null);
	}
}
