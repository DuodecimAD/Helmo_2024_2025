package suite;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


/**
 * Plan de test : TermesSuite.java -> suiteIteratif()
 *
 */
public class TermesSuiteIteratifTest {
	
	@Test
	public void testSuiteIteratifNegatif() {
		assertThrows(IllegalArgumentException.class, () -> { TermesSuite.termesSuiteIteratif(-10); });
	}
	@Test
	public void testSuiteIteratifNul() {
		assertThrows(IllegalArgumentException.class, () -> { TermesSuite.termesSuiteIteratif(0); });
	}

	@Test
	public void testSuiteIteratif() {
		for (int i = 1; i <= 30; i++) {
			assertEquals(7 * Math.pow(2, i - 1) - 4, TermesSuite.termesSuiteIteratif(i));
		}
	}

}
