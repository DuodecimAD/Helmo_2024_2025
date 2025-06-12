package matrix;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


/**
 * Plan de test : Matrix.java
 * 
 * @author François Schumacker
 */

public class DivTest {
	
	/* --- public Matrix div(int v) --- */
	
	@Test
	public void testDiv_Zero () {
		assertThrows(IllegalArgumentException.class, () -> { MatrixTestUtils.matriceRect43.div(0); }, "Division par zéro impossible");
	}
	
	@Test
	public void testDiv_CasGeneral () {
		Matrix mDiv = MatrixTestUtils.matriceRect43mult2.div(2);
		assertNotEquals(null, mDiv);
        assertNotEquals(mDiv, MatrixTestUtils.matriceRect43mult2);
        assertEquals(mDiv.getNumRows(), MatrixTestUtils.matriceRect43mult2.getNumRows());
        assertEquals(mDiv.getNumCols(), MatrixTestUtils.matriceRect43mult2.getNumCols());
        assertEquals(true, mDiv.equals(MatrixTestUtils.matriceRect43));		
	}
}
