package data_structures;

import static org.junit.Assert.*;
import org.junit.*;
import model.data_structures.TablaHashSeparateChaining; 

public class testTablaHashSeparateChaining 
{
	TablaHashSeparateChaining<String, String> tabla;
	@Before
	public void setUp()
	{
		tabla = new TablaHashSeparateChaining<String, String>(3);
		tabla.put("1", "Barcelona");
		tabla.put("2", "Liverpool");
		tabla.put("3", "BVB");
	}
	
	@Test
	public void testAnadir()
	{	
		assertEquals("Barcelona", tabla.get("1"));
	}
	
	@Test
	public void testBorrar()
	{
		assertEquals("Barcelona",tabla.delete("1"));
		assertEquals(null, tabla.get("1"));
	}
}
