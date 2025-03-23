package pgcd;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Plan de test pour Pgcd.pgcdIteratif()
 *
 */

public class PgcdIteratifTest {

	@Test
	public void testPgcdIteratifNegatifNombre1() {
		assertThrows(IllegalArgumentException.class, () -> { Pgcd.pgcdIteratif(-120, 24); });
	}

	@Test
	public void testPgcdIteratifNegatifNombre2() {
		assertThrows(IllegalArgumentException.class, () -> { Pgcd.pgcdIteratif(120, -24); });
	}
	
	@Test
	public void testPgcdIteratifNombre1EgalNombre2EgalZero() {
		assertThrows(IllegalArgumentException.class, () -> { Pgcd.pgcdIteratif(0, 0); });
	}

	@Test
	public void testPgcdIteratifNombre1EgalZero() {
		assertEquals(24, Pgcd.pgcdIteratif(24, 0));
	}
	
	@Test
	public void testPgcdIteratifNombre2EgalZero() {
		assertEquals(12, Pgcd.pgcdIteratif(0, 12));
	}
	
	@Test
	public void testPgcdIteratifNombre1EgalNombre2() {
		assertEquals(12, Pgcd.pgcdIteratif(12, 12));
	}

	@Test
	public void testPgcdIteratifCasGeneral1() {
		assertEquals(75, Pgcd.pgcdIteratif(675, 375));
	}
	
	@Test
	public void testPgcdIteratifCasGeneral2() {
		assertEquals(12, Pgcd.pgcdIteratif(96, 36));
	}

	@Test
	public void testPgcdIteratifCasGeneral1Inverse() {
		assertEquals(75, Pgcd.pgcdIteratif(375, 675));
	}
	
	@Test
	public void testPgcdIteratifNombre1MultipleNombre2() {
	    assertEquals(6, Pgcd.pgcdIteratif(48, 6));
	}

	@Test
	public void testPgcdIteratifNombresPremiersEntreEux() {
		assertEquals(1, Pgcd.pgcdIteratif(84, 275));
	}
}
