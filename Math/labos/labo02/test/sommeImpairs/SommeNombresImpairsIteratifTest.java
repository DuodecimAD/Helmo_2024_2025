package sommeImpairs;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


/**
 * Plan de test pour SommeNombresImpairs.sommeNombresImpairsIteratif()
 *
 */
public class SommeNombresImpairsIteratifTest {
	@Test
	public void testSommeNombresImpairsIteratifNegatif() {
		assertThrows(IllegalArgumentException.class, () -> { SommeNombresImpairs.sommeNombresImpairsIteratif(-10); });
	}

	@Test
	public void testSommeNombresImpairsIteratifNul() {
		assertThrows(IllegalArgumentException.class, () -> { SommeNombresImpairs.sommeNombresImpairsIteratif(0); });
	}

	@Test
	public void testPuissanceIteratifGeneral() {
		for(int i = 1; i < 100; i++) {
			assertEquals(SommeNombresImpairs.sommeNombresImpairs(i), SommeNombresImpairs.sommeNombresImpairsIteratif(i));
		}
	}
	
}
