package util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TableauChainesTest {

	@Test
	void ajoutElement1() {
		String[] tableau = {"A", "B", "C"};
		String[] attendu = {"A", "B", "C", "D"};
		
		assertArrayEquals(attendu, TableauChaines.ajouterElement(tableau, "D"));
	}
	
	@Test
	void ajoutElement2() {
		String[] tableau = {};
		String[] attendu = {"D"};
		
		assertArrayEquals(attendu, TableauChaines.ajouterElement(tableau, "D"));
	}
	
	@Test
	void retirerElement1() {
		String[] tableau = {"A", "B", "C", "D"};
		String[] attendu = {"A", "B", "C"};
		
		assertArrayEquals(attendu, TableauChaines.retirerElement(tableau, tableau.length-1));
	}
	
	@Test
	void retirerElement2() {
		String[] tableau = {"A"};
		String[] attendu = {};
		
		assertArrayEquals(attendu, TableauChaines.retirerElement(tableau, 0));
	}

	@Test
	void positionDe() {
		String[] tableau = {"Camille", "Bilal", "Aline", "Alice", "Diego"};
		String recherche = "ali";
		int attendu = 2;
		
		assertEquals(attendu, TableauChaines.positionDe(tableau, recherche));
	}
	
	@Test
	void positionDePas() {
		String[] tableau = {"Camille", "Bilal", "Aline", "Alice", "Diego"};
		String recherche = "ant";
		int attendu = -1;
		
		assertEquals(attendu, TableauChaines.positionDe(tableau, recherche));
	}
	
	@Test
	void positionDeAvecNull() {
		String[] tableau = {"Camille", "Bilal", null, "Alice", "Diego"};
		String recherche = "ali";
		int attendu = 3;
		
		assertEquals(attendu, TableauChaines.positionDe(tableau, recherche));
	}
	
	@Test
	void positionDe2D() {
		String[][] tableau = {{"Camille", "Bilal", "Eloi"}, {"Aline"}, {"Alice", "Diego"}};
		String recherche = "ali";
		int[] attendu = {1, 0};
		
		assertArrayEquals(attendu, TableauChaines.positionDe(tableau, recherche));
	}
	
	@Test
	void positionDe2DPas() {
		String[][] tableau = {{"Camille", "Bilal", "Eloi"}, {"Aline"}, {"Alice", "Diego"}};
		String recherche = "ant";
		int[] attendu = null;
		
		assertArrayEquals(attendu, TableauChaines.positionDe(tableau, recherche));
	}
	
	void positionDe2DAvecNull() {
		String[][] tableau = {{"Camille", "Bilal", "Eloi"}, null, {"Alice", "Diego"}};
		String recherche = "ali";
		int[] attendu = {2, 0};
		
		assertArrayEquals(attendu, TableauChaines.positionDe(tableau, recherche));
	}
	

}
