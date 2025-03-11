package equationModulaire;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


/**
 * Plan de test pour EquationModulaire.solveurAddition
 *
 */

public class EquationModulaireAdditionTests {

	@Test
	public void testsolveurAdditionNNegatif() {
		assertThrows(IllegalArgumentException.class, () -> { EquationModulaire.solveurAddition(17, 8, -2); });
	}

	@Test
	public void testsolveurAdditionNNul() {
		assertThrows(IllegalArgumentException.class, () -> { EquationModulaire.solveurAddition(17, 8, 0); });
	}
	
	@Test
	public void testsolveurAdditionNEgalUn() {
		assertThrows(IllegalArgumentException.class, () -> { EquationModulaire.solveurAddition(17, 8, 1); });
	}
	
	@Test
	public void testsolveurAdditionNEgalDeux() {
		assertEquals(1, EquationModulaire.solveurAddition(15, 4, 2));
	}	
	
	@Test
	public void testsolveurAdditionAPostifBPositif() {
		assertEquals(3, EquationModulaire.solveurAddition(17, 8, 6));
	}	
	
	@Test
	public void testsolveurAdditionANegatifBPositif() {
		assertEquals(6, EquationModulaire.solveurAddition(-14, 6, 7));
	}
	
	@Test
	public void testsolveurAdditionAPositifBNegatif() {
		assertEquals(4, EquationModulaire.solveurAddition(14, -7, 5));
	}
	
	@Test
	public void testsolveurAdditionANegatifBNegatif() {
		assertEquals(12, EquationModulaire.solveurAddition(-143, -79, 13));
	}
	
	@Test
	public void testsolveurAdditionPlusGrandsNombres() {
		assertEquals(19, EquationModulaire.solveurAddition(2468, 9753, 42));
	}
	
	
}
