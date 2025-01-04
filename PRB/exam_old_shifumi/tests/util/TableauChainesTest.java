package util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class TableauChainesTest {

	@Test
	void ajouterElementTest() {
		String[] tableau = { "Feuille", "Spock" };
		String[] attendu = { "Feuille", "Spock", "Spock" };
		assertArrayEquals(attendu, TableauChaines.ajouterElement(tableau, "Spock"));
	}

	@Test
	void ajouterElementVideTest() {
		String[] tableau = {};
		String[] attendu = { "Spock" };
		assertArrayEquals(attendu, TableauChaines.ajouterElement(tableau, "Spock"));
	}

	@Test
	void valeurAleatoireTest() {
		String[] tableau = { "Ciseaux", "Feuille", "Pierre", "Lézard", "Spock" };

		String valeur = TableauChaines.valeurAleatoire(tableau);

		for (int i = 0; i < tableau.length; i++) {
			if (valeur.equals(tableau[i])) {
				assertEquals(valeur, tableau[i]);
			}
		}

	}

	@Test
	void valeurAleatoireTest2() {
		String[] tableau = { "Ciseaux", "Feuille", "Pierre", "Lézard", "Spock" };
		String[] newTableau = new String[3];

		for (int i = 0; i < 3; i++) {
			newTableau[i] = TableauChaines.valeurAleatoire(tableau);
		}
		
		int differentElement = 0;
		for (int j = 1; j < newTableau.length; j++) {
			if(!newTableau[j-1].equals(newTableau[j])) {
				differentElement++;
			}
		}
		assertNotEquals(0, differentElement);

	}
	
	@Test
	void commenceParTest() {
		String[] tableau = { "Ciseaux", "Feuille", "Splash", "Lézard", "Spock" };
		String prefixe = "sp";

		assertEquals(2, TableauChaines.commencePar(tableau, prefixe));
	}
	
	@Test
	void commenceParTestNull() {
		String[] tableau = { "Ciseaux", "Feuille", null, "Lézard", "Spock" };
		String prefixe = "sp";

		assertEquals(4, TableauChaines.commencePar(tableau, prefixe));

	}
	
	@Test
	void compterTest() {
		String[] tableau = { "Feuille", "Lézard", "Spock", "Pierre", "Feuille", "Feuille" };
		String value = "Feuille";

		assertEquals(3, TableauChaines.compter(tableau, value));

	}
	
	@Test
	void compterTestNull() {
		String[] tableau = { "Feuille", "Lézard", "Spock", "Pierre", null, "Feuille" };
		String value = "Feuille";

		assertEquals(2, TableauChaines.compter(tableau, value));

	}
	
	@Test
	void compterTestPas() {
		String[] tableau = { "Feuille", "Lézard", "Spock", "Pierre" };
		String value = "papier";

		assertEquals(-1, TableauChaines.compter(tableau, value));

	}


}
