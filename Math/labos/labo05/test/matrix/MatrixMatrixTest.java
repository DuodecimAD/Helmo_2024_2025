package matrix;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


/**
 * Plan de test : Matrix.java
 * 
 * @author François Schumacker
 */

public class MatrixMatrixTest {
   
    /* --- public Matrix(Matrix mat) --- */
    
	@Test
	public void testMatrixMatrix_CasGeneral() {
		Matrix m = new Matrix(MatrixTestUtils.matriceRect34);
		assertNotNull(m);
		assertNotEquals(m, MatrixTestUtils.matriceRect34);
		assertTrue(m.equals(MatrixTestUtils.matriceRect34));
	}

	@Test
	public void testMatrixMatrix_Copie() {
		Matrix orig = new Matrix(new int[][]{{1, 2}, {3, 4}, {5, 6}});
		Matrix m = new Matrix(orig);
		assertNotNull(m);
		assertNotEquals(m, orig);
		assertTrue(m.equals(orig));
		m.set(1, 1, 0);
		assertNotEquals(0, orig.get(1, 1));
	}

}
