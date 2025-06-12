package bitwise;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


/**
 * Plan de test pour Chiffrement.encoder(int x)
 * 
 *
 */
public class ChiffrementTest {
	
	@Test
	public void testEntierPositifExemple() {
		assertEquals(1515538525, Chiffrement.encoder(123456));
	}

	
	@Test
	public void testEntierNegatifExemple() {
		assertEquals(-1929297819, Chiffrement.encoder(-85236921));
	}
	
	@Test
	public void testEntierPositif() {
		assertEquals(212410325, Chiffrement.encoder(0x0ade68b1));
	}
	
	@Test
	public void testEntierNegatif() {
		assertEquals(-1935073323, Chiffrement.encoder(0xfade68b1));
	}
	
	@Test
	public void testEntierUn() {
		assertEquals(1515870805, Chiffrement.encoder(1));
	}
	
	@Test
	public void testEntierMoinsUn() {
		assertEquals(-1515870811, Chiffrement.encoder(-1));
	}
	
	@Test
	public void testEntierZero() {
		assertEquals(1515870813, Chiffrement.encoder(0));
	}
	
}
