package matrix;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Plan de test : Matrix.java
 * 
 * @author François Schumacker
 */

public class IsNullTest {

	/* --- public boolean isNull() --- */
	
	@Test
	public void testIsNull_SingletonNull() {
		assertEquals(true, MatrixTestUtils.matriceSingletonNulle.isNull());
	}
	
	@Test
	public void testIsNull_SingletonNotNull() {
		assertEquals(false, MatrixTestUtils.matriceSingleton.isNull());
	}
	
	@Test
	public void testIsNull_CarreNull() {
		assertEquals(true, MatrixTestUtils.matriceCarreeNulle.isNull());
	}
	
	@Test
	public void testIsNull_CarreNotNull() {
		assertEquals(false, MatrixTestUtils.matriceCarreeDiagonale.isNull());
	}
	
	@Test
	public void testIsNull_RectNull() {
		assertEquals(true, MatrixTestUtils.matriceRect43Nulle.isNull());
	}
	
	@Test
	public void testIsNull_RectNotNull() {
		assertEquals(false, MatrixTestUtils.matriceRect43mult2.isNull());
	}

	@Test
	public void testIsNull_FirstElemNull() {
		assertEquals(false, MatrixTestUtils.matriceRect43FirstNull.isNull());
	}
}
