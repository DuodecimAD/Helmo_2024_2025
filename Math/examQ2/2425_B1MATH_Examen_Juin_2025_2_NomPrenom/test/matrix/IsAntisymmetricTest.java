package matrix;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Plan de test : Matrix.java
 * 
 */

public class IsAntisymmetricTest {
	
    /* --- public boolean isAntisymmetric() --- */
	
	@Test
	public void testIsAntisymmetric_Rect() {
		assertFalse(MatrixTestUtils.matriceRect43.isAntisymmetric());
	}
	
	@Test
	public void testIsAntisymmetric_SingletonNonNul() {
		assertFalse(MatrixTestUtils.matriceSingleton.isAntisymmetric());
	}
	
	@Test
	public void testIsAntisymmetric_SingletonNul() {
		assertTrue(MatrixTestUtils.matriceSingletonNulle.isAntisymmetric());
	}
	
	@Test
	public void testIsAntisymmetric_CarreeOrdre2Ok() {
		assertTrue(MatrixTestUtils.matriceAntisymmetric1.isAntisymmetric());
	}
	
	@Test
	public void testIsAntisymmetric_CarreeOrdre3Ok() {
		assertTrue(MatrixTestUtils.matriceAntisymmetric3.isAntisymmetric());
	}
	
	@Test
	public void testIsAntisymmetric_CarreeOrdre3CoursOk() {
		assertTrue(MatrixTestUtils.matriceAntisymmetric5.isAntisymmetric());
	}
	
	@Test
	public void testIsAntisymmetric_CarreeOrdre2Ko() {
		assertFalse(MatrixTestUtils.matriceAntisymmetric2.isAntisymmetric());
	}
	
	@Test
	public void testIsAntisymmetric_CarreeKo() {
		assertFalse(MatrixTestUtils.matriceCarree.isAntisymmetric());
	}
	
	@Test
	public void testIsAntisymmetric_CarreeOrdre3Ko() {
		assertFalse(MatrixTestUtils.matriceAntisymmetric4.isAntisymmetric());
	}
	
	@Test
	public void testIsAntisymmetric_CarreeOrdre3Ko2() {
		assertFalse(MatrixTestUtils.matriceAntisymmetric6.isAntisymmetric());
	}
}	
	