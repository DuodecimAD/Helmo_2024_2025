package sommeImpairs;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


/**
 * Plan de test pour SommeNombresImpairs.sommeNombresImpairsRecursif()
 *
 */
public class SommeNombresImpairsRecursifTest {
	@Test
	public void testSommeNombresImpairsRecursifNegatif() {
		assertThrows(IllegalArgumentException.class, () -> { SommeNombresImpairs.sommeNombresImpairsRecursif(-10); });
	}

	@Test
	public void testSommeNombresImpairsRecursifNul() {
		assertThrows(IllegalArgumentException.class, () -> { SommeNombresImpairs.sommeNombresImpairsRecursif(0); });
	}

	@Test
	public void testPuissanceRecursifGeneral() {
		for(int i = 1; i < 100; i++) {
			assertEquals(SommeNombresImpairs.sommeNombresImpairs(i), SommeNombresImpairs.sommeNombresImpairsRecursif(i));
		}
	}
	
}
