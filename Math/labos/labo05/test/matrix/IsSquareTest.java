package matrix;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Plan de test : Matrix.java
 * 
 * @author François Schumacker
 */

public class IsSquareTest {
	
    /* --- public boolean isSquare() --- */
	
	@Test
	public void testIsSquare_Singleton() {
		assertEquals(true, MatrixTestUtils.matriceSingleton.isSquare());
	}
	
	@Test
	public void testIsSquare_Rect() {
		assertEquals(false, MatrixTestUtils.matriceRect43.isSquare());
	}
	
	@Test
	public void testIsSquare_Carree() {
		assertEquals(true, MatrixTestUtils.matriceCarree.isSquare());
	}
}
