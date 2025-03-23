package amorce;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Plan de test pour AmorceIdentique.amorceIdentiqueRecursif()
 */
public class AmorceIdentiqueRecursifTests {
	
	@Test
	public void testAmorceIdentiqueRecursifChaineNull() {
		assertThrows(IllegalArgumentException.class, () -> { AmorceIdentique.amorceIdentiqueRecursif(null, "abc"); });
	}
	
	@Test
	public void testAmorceIdentiqueRecursifAmorceNull() {
		assertThrows(IllegalArgumentException.class, () -> { AmorceIdentique.amorceIdentiqueRecursif("abc", null); });
	}
	
	@Test
	public void testAmorceIdentiqueRecursifChainePlusCourteMemeCasse() {
		assertFalse(AmorceIdentique.amorceIdentiqueRecursif("chat", "chateau"));
	}

	@Test
	public void testAmorceIdentiqueRecursifChainePlusCourteCasseDifferente() {
		assertFalse(AmorceIdentique.amorceIdentiqueRecursif("CHAT", "chateau"));
	}
	
	@Test
	public void testAmorceIdentiqueRecursifChaineVide() {
		assertFalse(AmorceIdentique.amorceIdentiqueRecursif("","ab"));
	}
	
	@Test
	public void testAmorceIdentiqueRecursifAmorceVide() {
		assertTrue(AmorceIdentique.amorceIdentiqueRecursif("abcd",""));
	}
	
	@Test
	public void testAmorceIdentiqueRecursifChaineVideAmorceVide() {
		assertTrue(AmorceIdentique.amorceIdentiqueRecursif("",""));
	}

	@Test
	public void testAmorceIdentiqueRecursifCasOkMemeCasse() {
		assertTrue(AmorceIdentique.amorceIdentiqueRecursif("chateau", "chat"));
	}

	@Test
	public void testAmorceIdentiqueRecursifCasOkCasseDifferente() {
		assertTrue(AmorceIdentique.amorceIdentiqueRecursif("Chateau", "chat"));
	}

	@Test
	public void testAmorceIdentiqueRecursifCasKoMemeCasseDebutsDifferents() {
		assertFalse(AmorceIdentique.amorceIdentiqueRecursif("chateau", "plat"));
	}
	
	@Test
	public void testAmorceIdentiqueRecursifCasKoMemeCasseMemeDebut() {
		assertFalse(AmorceIdentique.amorceIdentiqueRecursif("chateau", "choc"));
	}

	@Test
	public void testAmorceIdentiqueRecursifMeLongueurMemeCasse() {
		assertTrue(AmorceIdentique.amorceIdentiqueRecursif("chat", "chat"));
	}

	@Test
	public void testAmorceIdentiqueRecursifMeLongueurCasseDifferente() {
		assertTrue(AmorceIdentique.amorceIdentiqueRecursif("CHAT", "chat"));
	}
	
	@Test
	public void testAmorceIdentiqueRecursifMeLongueurKo() {
		assertFalse(AmorceIdentique.amorceIdentiqueRecursif("CHAT", "plat"));
	}
}
