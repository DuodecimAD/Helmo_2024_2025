package trianglePascal;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Plan de test pour TrianglePascal.coefficientPascalIteratif()
 */
public class TrianglePascalIteratifTests {
	
	@Test
	public void testTrianglePascalIteratifLigneNegatif() {
		assertThrows(IllegalArgumentException.class, () -> { TrianglePascal.coefficientPascalIteratif(-2, 2); });
	}
	@Test
	public void testTrianglePascalIteratifColonneNegatif() {
		assertThrows(IllegalArgumentException.class, () -> { TrianglePascal.coefficientPascalIteratif(2, -2); });
	}
	@Test
	public void testTrianglePascalIteratifLigneColonneNegatif() {
		assertThrows(IllegalArgumentException.class, () -> { TrianglePascal.coefficientPascalIteratif(-2, -2); });
	}
	@Test
	public void testTrianglePascalIteratifColonnePlusGrandeQueLigne() {
		assertThrows(IllegalArgumentException.class, () -> { TrianglePascal.coefficientPascalIteratif(2, 4); });
	}
	
	@Test
	public void testTrianglePascalIteratifLigneColonneNul() {
		assertEquals(1, TrianglePascal.coefficientPascalIteratif(0,0));
	}
	
	@Test
	public void testTrianglePascalIteratifLigne1Colonne0() {
		assertEquals(1, TrianglePascal.coefficientPascalIteratif(1,0));
	}
	
	@Test
	public void testTrianglePascalIteratifLigne16() {
		for(int l = 0; l <= 16; l++) {
			for(int c = 0; c <= l; c++) {
				assertEquals(coefficientBinomial(l, c), TrianglePascal.coefficientPascalIteratif(l, c));
			}
		}
	}
	
	private static long coefficientBinomial(int n, int p) {
		return factorielle(n) / (factorielle(n-p) * factorielle(p));
	}
	private static long factorielle(long n) {
		return((n == 0) ? 1 : n * factorielle(n - 1));
	}
}
