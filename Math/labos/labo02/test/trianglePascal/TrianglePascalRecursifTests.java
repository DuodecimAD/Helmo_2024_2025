package trianglePascal;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Plan de test pour TrianglePascal.coefficientPascalRecursif()
 */
public class TrianglePascalRecursifTests {
	
	@Test
	public void testTrianglePascalRecursifLigneNegatif() {
		assertThrows(IllegalArgumentException.class, () -> { TrianglePascal.coefficientPascalRecursif(-2, 2); });
	}
	@Test
	public void testTrianglePascalRecursifColonneNegatif() {
		assertThrows(IllegalArgumentException.class, () -> { TrianglePascal.coefficientPascalRecursif(2, -2); });
	}
	@Test
	public void testTrianglePascalRecursifLigneColonneNegatif() {
		assertThrows(IllegalArgumentException.class, () -> { TrianglePascal.coefficientPascalRecursif(-2, -2); });
	}
	@Test
	public void testTrianglePascalRecursifColonnePlusGrandeQueLigne() {
		assertThrows(IllegalArgumentException.class, () -> { TrianglePascal.coefficientPascalRecursif(2, 4); });
	}
	
	@Test
	public void testTrianglePascalRecursifLigneColonneNul() {
		assertEquals(1, TrianglePascal.coefficientPascalRecursif(0,0));
	}
	
	@Test
	public void testTrianglePascalRecursifLigne1Colonne0() {
		assertEquals(1, TrianglePascal.coefficientPascalRecursif(1,0));
	}
	
	@Test
	public void testTrianglePascalRecursifLigne16() {
		for(int l = 0; l <= 16; l++) {
			for(int c = 0; c <= l; c++) {
				assertEquals(coefficientBinomial(l, c), TrianglePascal.coefficientPascalRecursif(l, c));
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
