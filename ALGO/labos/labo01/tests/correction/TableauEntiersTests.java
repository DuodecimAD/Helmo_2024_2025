package correction;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TableauEntiersTests {

	@Test
	void decalageCirculaireDroiteTableauVide() {
		int[] vide  = {};
		int[] autreVide = {};
		TableauEntiers.decalageCirculaireDroite(vide);
		assertArrayEquals(autreVide, vide);
	}
	
	@Test
	void decalageCirculaireDroiteTableauCasGeneral1() {
		int[] initial = {1, 2, 3, 4, 5};
		int[] attendu = {5, 1, 2, 3, 4};
		TableauEntiers.decalageCirculaireDroite(initial);
		assertArrayEquals(attendu, initial);
	}
	
	@Test
	void decalageCirculaireDroiteTableauPresLimite() {
		int[] initial = {1,2};
		int[] attendu = {2,1};
		TableauEntiers.decalageCirculaireDroite(initial);
		assertArrayEquals(attendu, initial);
	}
	
	@Test
	void decalageCirculaireDroiteTableau42() {
		int[] initial = {42};
		int[] attendu = {42};
		TableauEntiers.decalageCirculaireDroite(initial);
		assertArrayEquals(attendu, initial);
	}
	
	@Test
	void decalageCirculaireDroiteTableauCasGeneral2() {
		int[] initial = {18, 25, 314, -47, 5, 6, 78, -23};
		int[] attendu = {-23, 18, 25, 314, -47, 5, 6, 78};
		TableauEntiers.decalageCirculaireDroite(initial);
		assertArrayEquals(attendu, initial);
	}
	
	@Test
	void decalageCirculaireDroiteImpossibleOnNull() {
		/* Pour vérifier que le code crache bien rapidement lorsqu'on passe
		 * une référence null, on peut procéder ainsi. Note: cela dépasse le
		 * cadre du cours mais c'est utilisé dans les labos de mathématiques. */
		assertThrows(NullPointerException.class, () -> {TableauEntiers.decalageCirculaireDroite(null);});
	}
}
