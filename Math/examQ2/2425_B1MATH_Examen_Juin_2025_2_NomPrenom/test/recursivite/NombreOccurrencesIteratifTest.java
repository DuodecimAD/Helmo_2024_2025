package recursivite;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


/**
 * Plan de test pour NombreOccurrences.nombreOccurrencesIteratif(String chaine, char c)
 * 
 *
 */
public class NombreOccurrencesIteratifTest {
	
	@Test
	public void testNombreOccurrencesMinuscules() {
		assertEquals(4, NombreOccurrences.nombreOccurrencesIteratif("Mon petit chat est blanc", 't'));
	}
	
	@Test
	public void testNombreOccurrencesMinuscules2() {
		assertEquals(4, NombreOccurrences.nombreOccurrencesIteratif("Mon petit chat est blanc", 'T'));
	}
	
	@Test
	public void testNombreOccurrencesMinusculesMajuscules() {
		assertEquals(4, NombreOccurrences.nombreOccurrencesIteratif("Mon PETIT chat est blanc", 't'));
	}
	
	@Test
	public void testNombreOccurrencesMinusculesMajuscules2() {
		assertEquals(4, NombreOccurrences.nombreOccurrencesIteratif("Mon PETIT chat est blanc", 'T'));
	}
	
	@Test
	public void testNombreOccurrences0() {
		assertEquals(0, NombreOccurrences.nombreOccurrencesIteratif("Mon petit chat est blanc", 'z'));
	}
	
	@Test
	public void testNombreOccurrencesPremiereLettre() {
		assertEquals(1, NombreOccurrences.nombreOccurrencesIteratif("Mon petit chat est blanc", 'm'));
	}

	@Test
	public void testNombreOccurrencesDerniereLettre() {
		assertEquals(2, NombreOccurrences.nombreOccurrencesIteratif("Mon petit chat est blanc", 'c'));
	}
	
	@Test
	public void testNombreOccurrencesLettresIdentiquesOk() {
		assertEquals(10, NombreOccurrences.nombreOccurrencesIteratif("MMMMMMMMMM", 'm'));
	}
	
	@Test
	public void testNombreOccurrencesLettresIdentiquesNok() {
		assertEquals(0, NombreOccurrences.nombreOccurrencesIteratif("MMMMMMMMMM", 'a'));
	}
	
	@Test
	public void testNombreOccurrencesChaineBlanc() {
		assertEquals(0, NombreOccurrences.nombreOccurrencesIteratif("     ", 'c'));
	}
	
	@Test
	public void testNombreOccurrencesChaineVide() {
		assertEquals(0, NombreOccurrences.nombreOccurrencesIteratif("", 'c'));
	}
	
}
