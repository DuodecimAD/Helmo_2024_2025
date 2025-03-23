package amorce;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Plan de test pour AmorceIdentique.amorceIdentiqueIteratif()
 */
public class AmorceIdentiqueIteratifTests {
	
	@Test
	public void testAmorceIdentiqueIteratifChaineNull() {
		assertThrows(IllegalArgumentException.class, () -> { AmorceIdentique.amorceIdentiqueIteratif(null, "abc"); });
	}
	
	@Test
	public void testAmorceIdentiqueIteratifAmorceNull() {
		assertThrows(IllegalArgumentException.class, () -> { AmorceIdentique.amorceIdentiqueIteratif("abc", null); });
	}
	
	@Test
	public void testAmorceIdentiqueIteratifChainePlusCourteMemeCasse() {
		assertFalse(AmorceIdentique.amorceIdentiqueIteratif("chat", "chateau"));
	}

	@Test
	public void testAmorceIdentiqueIteratifChainePlusCourteCasseDifferente() {
		assertFalse(AmorceIdentique.amorceIdentiqueIteratif("CHAT", "chateau"));
	}
	
	@Test
	public void testAmorceIdentiqueIteratifChaineVide() {
		assertFalse(AmorceIdentique.amorceIdentiqueIteratif("", "ab"));
	}
	
	@Test
	public void testAmorceIdentiqueIteratifAmorceVide() {
		assertTrue(AmorceIdentique.amorceIdentiqueIteratif("abcd", ""));
	}
	
	@Test
	public void testAmorceIdentiqueIteratifChaineVideAmorceVide() {
		assertTrue(AmorceIdentique.amorceIdentiqueIteratif("", ""));
	}

	@Test
	public void testAmorceIdentiqueIteratifCasOkMemeCasse() {
		assertTrue(AmorceIdentique.amorceIdentiqueIteratif("chateau", "chat"));
	}

	@Test
	public void testAmorceIdentiqueIteratifCasOkCasseDifferente() {
		assertTrue(AmorceIdentique.amorceIdentiqueIteratif("Chateau", "chat"));
	}

	@Test
	public void testAmorceIdentiqueIteratifCasKoMemeCasseDebutsDifferents() {
		assertFalse(AmorceIdentique.amorceIdentiqueIteratif("chateau", "plat"));
	}
	
	@Test
	public void testAmorceIdentiqueIteratifCasKoMemeCasseMemeDebut() {
		assertFalse(AmorceIdentique.amorceIdentiqueIteratif("chateau", "choc"));
	}

	@Test
	public void testAmorceIdentiqueIteratifMeLongueurMemeCasse() {
		assertTrue(AmorceIdentique.amorceIdentiqueIteratif("chat", "chat"));
	}

	@Test
	public void testAmorceIdentiqueIteratifMeLongueurCasseDifferente() {
		assertTrue(AmorceIdentique.amorceIdentiqueIteratif("CHAT", "chat"));
	}
	
	@Test
	public void testAmorceIdentiqueIteratifMeLongueurKo() {
		assertFalse(AmorceIdentique.amorceIdentiqueIteratif("CHAT", "plat"));
	}
}
