package recursivite;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


/**
 * Plan de test pour NombreOccurrences.nombreOccurrencesRecursif(String chaine, char c)
 * 
 *
 */
public class NombreOccurrencesRecursifTest {
	
	@Test
	public void testNombreOccurrencesMinuscules() {
		assertEquals(4, NombreOccurrences.nombreOccurrencesRecursif("Mon petit chat est blanc", 't'));
	}
	
	@Test
	public void testNombreOccurrencesMinusculesMajuscules() {
		assertEquals(4, NombreOccurrences.nombreOccurrencesRecursif("Mon PETIT chat est blanc", 't'));
	}
	
	@Test
	public void testNombreOccurrences0() {
		assertEquals(0, NombreOccurrences.nombreOccurrencesRecursif("Mon petit chat est blanc", 'z'));
	}
	
	@Test
	public void testNombreOccurrencesPremiereLettre() {
		assertEquals(1, NombreOccurrences.nombreOccurrencesRecursif("Mon petit chat est blanc", 'm'));
	}

	@Test
	public void testNombreOccurrencesDerniereLettre() {
		assertEquals(2, NombreOccurrences.nombreOccurrencesRecursif("Mon petit chat est blanc", 'c'));
	}
	
	@Test
	public void testNombreOccurrencesLettresIdentiquesOk() {
		assertEquals(10, NombreOccurrences.nombreOccurrencesRecursif("MMMMMMMMMM", 'm'));
	}
	
	@Test
	public void testNombreOccurrencesLettresIdentiquesNok() {
		assertEquals(0, NombreOccurrences.nombreOccurrencesRecursif("MMMMMMMMMM", 'a'));
	}
	
	@Test
	public void testNombreOccurrencesChaineBlanc() {
		assertEquals(0, NombreOccurrences.nombreOccurrencesRecursif("     ", 'c'));
	}
	
	@Test
	public void testNombreOccurrencesChaineVide() {
		assertEquals(0, NombreOccurrences.nombreOccurrencesRecursif("", 'c'));
	}
	
}
