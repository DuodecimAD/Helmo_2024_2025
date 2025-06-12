package matrix;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Plan de test : Matrix.java
 * 
 */

public class ExtractFromThisTest {
	
	/* --- public Matrix extractFromThis(int insertRow, int insertCol, int height, int width) --- */

	@Test
	public void testExtractFromThis_ExtractRowNegatif() {
		assertThrows(IllegalArgumentException.class, () -> { MatrixTestUtils.matriceRect43.extractFromThis(-5, 0, 2, 2); },
			"extractRow ne peut pas être négatif");
	}
	
	@Test
	public void testExtractFromThis_ExtracttRowTropGrand() {
		assertThrows(IllegalArgumentException.class, () -> { MatrixTestUtils.matriceRect43.extractFromThis(0, 4, 2, 2); },
			"extractRow est trop grand");
	}
	
	@Test
	public void testExtractFromThis_ExtractColNegatif() {
		assertThrows(IllegalArgumentException.class, () -> { MatrixTestUtils.matriceRect43.extractFromThis(0, -5, 2, 2); },
			"extractCol ne peut pas être négatif");
	}
	
	@Test
	public void testExtractFromThis_ExtractColTropGrand() {
		assertThrows(IllegalArgumentException.class, () -> { MatrixTestUtils.matriceRect43.extractFromThis(0, 3, 2, 2); },
			"extractCol est trop grand");
	}
	
	@Test
	public void testExtractFromThis_PasAssezDeLignes() {
		assertThrows(IllegalArgumentException.class, () -> { MatrixTestUtils.matriceRect43.extractFromThis(2, 0, 3, 2); },
			"nombre de lignes insuffisant");
	}
	
	@Test
	public void testExtractFromThis_PasAssezDeColonnes() {
		assertThrows(IllegalArgumentException.class, () -> { MatrixTestUtils.matriceRect43.extractFromThis(0, 1, 2, 3); },
			"nombre de colonnes insuffisant");
	}
	
	@Test
	public void testExtractFromThis_CasGeneral() {
		Matrix mExtract = MatrixTestUtils.matriceRect43.extractFromThis(1, 1, 3, 2);
		assertNotNull(mExtract);
        assertNotEquals(mExtract, MatrixTestUtils.matriceRect43);
        assertEquals(mExtract.getNumRows(), MatrixTestUtils.matriceRect32b.getNumRows());
        assertEquals(mExtract.getNumCols(), MatrixTestUtils.matriceRect32b.getNumCols());
        assertEquals(true, mExtract.equals(MatrixTestUtils.matriceRect32b));		
	}
}
