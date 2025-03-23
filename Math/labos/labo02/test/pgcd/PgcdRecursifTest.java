package pgcd;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Plan de test pour Pgcd.pgcdRecursif()
 *
 */

public class PgcdRecursifTest {

	@Test
	public void testPgcdRecursifNegatifNombre1() {
		assertThrows(IllegalArgumentException.class, () -> { Pgcd.pgcdRecursif(-120, 24); });
	}

	@Test
	public void testPgcdRecursifNegatifNombre2() {
		assertThrows(IllegalArgumentException.class, () -> { Pgcd.pgcdRecursif(120, -24); });
	}
	
	@Test
	public void testPgcdRecursifNombre1EgalNombre2EgalZero() {
		assertThrows(IllegalArgumentException.class, () -> { Pgcd.pgcdRecursif(0, 0); });
	}

	@Test
	public void testPgcdRecursifNombre1EgalZero() {
		assertEquals(24, Pgcd.pgcdRecursif(24, 0));
	}
	
	@Test
	public void testPgcdRecursifNombre2EgalZero() {
		assertEquals(12, Pgcd.pgcdRecursif(0, 12));
	}
	
	@Test
	public void testPgcdRecursifNombre1EgalNombre2() {
		assertEquals(12, Pgcd.pgcdRecursif(12, 12));
	}

	@Test
	public void testPgcdRecursifCasGeneral1() {
		assertEquals(75, Pgcd.pgcdRecursif(675, 375));
	}
	
	@Test
	public void testPgcdRecursifCasGeneral2() {
		assertEquals(12, Pgcd.pgcdRecursif(96, 36));
	}

	@Test
	public void testPgcdRecursifCasGeneral1Inverse() {
		assertEquals(75, Pgcd.pgcdRecursif(375, 675));
	}
	
	@Test
	public void testPgcdRecursifNombre1MultipleNombre2() {
	    assertEquals(6, Pgcd.pgcdRecursif(48, 6));
	}

	@Test
	public void testPgcdRecursifNombresPremiersEntreEux() {
		assertEquals(1, Pgcd.pgcdRecursif(84, 275));
	}
}
