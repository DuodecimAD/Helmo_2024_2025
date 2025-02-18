package labos.labo01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DecalageCircDroiteTest {

	@Test
	void decalageCircDroite_casNormauxtest1() {
		int[] depart = new int[]{1, 2, 3, 4, 5};
		int[] attendu = new int[]{5, 1, 2, 3, 4};
		
		DecalageCircDroite.decalageCircDroite(depart);
		assertArrayEquals(attendu, depart);
	}
	
	@Test
	void decalageCircDroite_casNormauxtest2() {
		int[] depart = new int[]{18, 25, 317, -4, 59, 67, 3, 12};
		int[] attendu = new int[]{12, 18, 25, 317, -4, 59, 67, 3};
		
		DecalageCircDroite.decalageCircDroite(depart);
		assertArrayEquals(attendu, depart);
	}
	
	@Test
	void decalageCircDroite_casNulltest() {
		int[] depart = null;
		int[] attendu = new int[]{12, 18, 25, 317, -4, 59, 67, 3};
		assertThrows(NullPointerException.class, () -> {DecalageCircDroite.decalageCircDroite(null);});
	}
	
	@Test
	void decalageCircDroite_casLimitetest() {
		int[] depart = new int[]{};
		int[] attendu = new int[]{};
		assertArrayEquals(attendu, depart);
	}
	
	@Test
	void decalageCircDroite_combinaisonCastest() {
		int[] depart = new int[]{1,2};
		int[] attendu = new int[]{2,1};
		assertArrayEquals(attendu, depart);
		
	}
	
	

}
