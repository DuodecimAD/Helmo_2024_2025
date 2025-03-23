package suite;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


/**
 * Plan de test : TermesSuite.java -> termesSuiteRecursif()
 *
 */
public class TermesSuiteRecursifTest {
	
	@Test
	public void testSuiteRecursifNegatif() {
		assertThrows(IllegalArgumentException.class, () -> { TermesSuite.termesSuiteRecursif(-10); });
	}
	@Test
	public void testSuiteRecursifNul() {
		assertThrows(IllegalArgumentException.class, () -> { TermesSuite.termesSuiteRecursif(0); });
	}

	@Test
	public void testSuiteRecursif() {
		for (int i = 1; i <= 30; i++) {
			assertEquals(7 * Math.pow(2, i - 1) - 4, TermesSuite.termesSuiteRecursif(i));
		}
	}

}
