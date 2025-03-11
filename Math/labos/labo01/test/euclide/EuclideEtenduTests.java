package euclide;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


/**
 * Plan de test pour EuclideEtendu.EuclideEtendu()
 *
 */

public class EuclideEtenduTests {

	@Test
	public void testEuclideEtenduNegatifNombre1() {
		assertThrows(IllegalArgumentException.class, () -> { EuclideEtendu.euclideEtendu(-120, 24); });
	}

	@Test
	public void testEuclideEtenduNegatifNombre2() {
		assertThrows(IllegalArgumentException.class, () -> { EuclideEtendu.euclideEtendu(120, -24); });
	}
	
	@Test
	public void testEuclideEtenduNombre1EtNombre2EgalZero() {
		assertArrayEquals(new int[] {0, 1, 0}, EuclideEtendu.euclideEtendu(0, 0));
	}	
	
	@Test
	public void testEuclideEtenduNombre1EgalZero() {
		assertArrayEquals(new int[] {14, 0, 1}, EuclideEtendu.euclideEtendu(0, 14));
	}
	
	
	@Test
	public void testEuclideEtenduNombre2EgalZero() {
		assertArrayEquals(new int[] {24, 1, 0}, EuclideEtendu.euclideEtendu(24, 0));
	}
	
	@Test
	public void testEuclideEtenduNombre1EgalNombre2() {
		assertArrayEquals(new int[] {12, 0, 1}, EuclideEtendu.euclideEtendu(12, 12));
	}

	@Test
	public void testEuclideEtenduCasGeneral1() {
		assertArrayEquals(new int[] {75, -1, 2}, EuclideEtendu.euclideEtendu(675, 375));
	}
	
	@Test
	public void testEuclideEtenduCasGeneral2() {
		assertArrayEquals(new int[] {12, -1, 3}, EuclideEtendu.euclideEtendu(96, 36));
	}

	@Test
	public void testEuclideEtenduCasGeneral1Inverse() {
		assertArrayEquals(new int[] {75, 2, -1}, EuclideEtendu.euclideEtendu(375, 675));
	}
	
	@Test
	public void testEuclideEtenduNombre1MultipleNombre2() {
	    assertArrayEquals(new int[] {6, 0, 1}, EuclideEtendu.euclideEtendu(48, 6));
	}

	@Test
	public void testEuclideEtenduNombresPremiersEntreEux() {
		assertArrayEquals(new int[] {1, -36, 11}, EuclideEtendu.euclideEtendu(84, 275));
	}
}
