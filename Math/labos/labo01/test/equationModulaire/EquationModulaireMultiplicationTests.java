package equationModulaire;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


/**
 * Plan de test pour EquationModulaire.solveurMultiplication
 *
 */

public class EquationModulaireMultiplicationTests {

	@Test
	public void testsolveurMultiplicationANegatif() {
		assertThrows(IllegalArgumentException.class, () -> { EquationModulaire.solveurMultiplication(-17, 8, 2); });
	}
	
	@Test
	public void testsolveurMultiplicationANul() {
		assertThrows(IllegalArgumentException.class, () -> { EquationModulaire.solveurMultiplication(0, 8, 3); });
	}
	
	@Test
	public void testsolveurMultiplicationNNegatif() {
		assertThrows(IllegalArgumentException.class, () -> { EquationModulaire.solveurMultiplication(17, 8, -2); });
	}

	@Test
	public void testsolveurMultiplicationNNul() {
		assertThrows(IllegalArgumentException.class, () -> { EquationModulaire.solveurMultiplication(17, 8, 0); });
	}
	
	@Test
	public void testsolveurMultiplicationNEgalUn() {
		assertThrows(IllegalArgumentException.class, () -> { EquationModulaire.solveurMultiplication(17, 8, 1); });
	}
	
	@Test
	public void testsolveurMultiplicationNEgalDeux() {
		assertEquals(0, EquationModulaire.solveurMultiplication(15, 4, 2));
	}
	
	@Test
	public void testsolveurMultiplicationAEgalUN() {
		assertEquals(1, EquationModulaire.solveurMultiplication(1, 7, 3));
	}
	
	@Test
	public void testsolveurMultiplicationAPostifBPositifSolution() {
		assertEquals(4, EquationModulaire.solveurMultiplication(2, 8, 5));
	}	
	
	@Test
	public void testsolveurMultiplicationAPostifBPositifPasSolution() {
		assertEquals(-1, EquationModulaire.solveurMultiplication(10, 13, 5));
	}
	
	@Test
	public void testsolveurMultiplicationAPositifBNegatif() {
		assertEquals(3, EquationModulaire.solveurMultiplication(4, -72, 7));
	}
	
	@Test
	public void testsolveurMultiplicationPlusGrandsNombres() {
		assertEquals(9, EquationModulaire.solveurMultiplication(35795, -159753, 42));
	}
	
	
}
