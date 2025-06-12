package matrix;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Plan de test : Matrix.java
 * 
 * @author François Schumacker
 */

public class IsSymmetricTest {

	@Test
	public void testIsSymmetric_SingletonNull() {
		assertEquals(true, MatrixTestUtils.matriceSingletonNulle.isSymmetric());
	}
	
	@Test
	public void testIsSymmetric_SingletonIsSym() {
		assertEquals(true, MatrixTestUtils.matriceSingleton.isSymmetric());
	}
		
	@Test
	public void testIsSymmetric_CarreeNull() {
		assertEquals(true, MatrixTestUtils.matriceCarreeNulle.isSymmetric());
	}
	
	@Test
	public void testIsSymmetric_CarreeIsSym() {
		assertEquals(true, MatrixTestUtils.matriceCarreeIdentite.isSymmetric());
	}
	
	@Test
	public void testIsSymmetric_CarreeNotSym() {
		assertEquals(false, MatrixTestUtils.matriceCarreeNotSymmetric.isSymmetric());
	}
	
	@Test
	public void testIsSymmetric_CarreeNotSym2() {
		assertEquals(false, MatrixTestUtils.matriceCarreeNotSymmetricMoitieInf.isSymmetric());
	}
	
	@Test
	public void testIsSymmetric_CarreeSym() {
		assertEquals(true, MatrixTestUtils.matriceCarreeSymmetric.isSymmetric());
	}
	
	@Test
	public void testIsSymmetric_RectNull() {
		assertEquals(false, MatrixTestUtils.matriceRect43Nulle.isSymmetric());
	}
	
	@Test
	public void testIsSymmetric_RectNotSym() {
		assertEquals(false, MatrixTestUtils.matriceRect43max5.isSymmetric());
	}
		
	@Test
	public void testIsSymmetric_CarreeNotSymOnLastColumn() {
		assertEquals(false, MatrixTestUtils.matriceCarreeNotSymmetricOnLastColumn.isSymmetric());
	}
}
