package util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class TableauCaracteresTest {

	@Test
	void permuterTest() {
		char[][] tableau = { { 'T', 'T', 'T' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
		char[][] attendu = { { 'T', 'T', ' ' }, { 'T', ' ', ' ' }, { ' ', ' ', ' ' } };
		TableauCaracteres.permuter(tableau, 1, 0, 0, 2);
		assertArrayEquals(attendu, tableau);
	}

	@Test
	void positionDeTest() {
		char[] tableau = { ' ', ' ', 'T', ' ', 'T' };
		char aChercher = 'T';

		assertEquals(2, TableauCaracteres.positionDe(tableau, aChercher));
	}

	@Test
	void positionDePasTest() {
		char[] tableau = { ' ', ' ', ' ', ' ', ' ' };
		char aChercher = 'T';

		assertEquals(-1, TableauCaracteres.positionDe(tableau, aChercher));
	}

	@Test
	void positionsParLigneTest() {
		char[][] tableau = { { 'T', ' ', ' ' }, { 'T', 'T', ' ' }, { ' ', ' ', ' ' } };
		char aChercher = 'T';
		int[] attendu = { 0, 0, -1 };

		assertArrayEquals(attendu, TableauCaracteres.positionsParLigne(tableau, aChercher));
	}
	
	@Test
	void melangerTest() {
		char[][] tableau    = { { 'T', 'T', 'T' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
		char[][] newTableau = { { 'T', 'T', 'T' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
		
		TableauCaracteres.melanger(newTableau);

		assertFalse(Arrays.equals(tableau, newTableau));
		
	}
	
	

}
