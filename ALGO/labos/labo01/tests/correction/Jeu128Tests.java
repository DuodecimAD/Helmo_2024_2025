package correction;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Jeu128Tests {

	@Test
	void compacteValeursGauche() {
		int[] avant = {2, 0, 4, 0, 2, 0, 0, 4, 0};
		int[] apres = {2, 4, 2, 4, 0, 0, 0, 0, 0};
		Jeu128.mouvement(avant, true);
		assertArrayEquals(apres, avant);
	}
	
	@Test
	void fusionneCorrectementGauche() {
		int[] avant = {2, 2, 2, 2, 2, 2, 2, 2};
		int[] apres = {4, 4, 4, 4, 0, 0, 0, 0};
		Jeu128.mouvement(avant, true);
		assertArrayEquals(apres, avant);
	}
	
	@Test
	void compacteValeursDroite() {
		int[] avant = {2, 0, 4, 0, 2, 0, 0, 4, 0};
		int[] apres = {0, 0, 0, 0, 0, 2, 4, 2, 4};
		Jeu128.mouvement(avant, false);
		assertArrayEquals(apres, avant);
	}
	
	@Test
	void fusionneCorrectementDroite() {
		int[] avant = {2, 2, 2, 2, 2, 2, 2, 2};
		int[] apres = {0, 0, 0, 0, 4, 4, 4, 4};
		Jeu128.mouvement(avant, false);
		assertArrayEquals(apres, avant);
	}
	
	@Test
	void aucunEffetSiTableauVide() {
		int[] avant = {};
		int[] apres = {};
		Jeu128.mouvement(avant, true);
		assertArrayEquals(apres, avant);
		Jeu128.mouvement(avant, false);
		assertArrayEquals(apres, avant);
	}
	
	@Test
	void aucunEffetSiTableau1Case0() {
		int[] avant = {0};
		int[] apres = {0};
		Jeu128.mouvement(avant, true);
		assertArrayEquals(apres, avant);
		Jeu128.mouvement(avant, false);
		assertArrayEquals(apres, avant);
	}
	
	@Test
	void aucunEffetSiTableauDejaCompacteGauche() {
		int[] avant = {2, 4, 2, 4, 0, 0, 0, 0, 0};
		int[] apres = {2, 4, 2, 4, 0, 0, 0, 0, 0};
		Jeu128.mouvement(avant, true);
		assertArrayEquals(apres, avant);
	}
}
