package util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TableauCaracteresTest {

	@Test
	void ajouterCharElementTest() {
		char[] expected = { 'A', 'B', 'C', 'D', 'E' };
		char[] old = { 'A', 'B', 'C', 'D' };
		assertArrayEquals(expected, TableauCaracteres.ajouterElement(old, 'E'));
	}
	
	@Test
	void ajouterCharLigneTest() {
		char[][] expected = { {'X', 'X', 'O'}, {'O'},  {'X', 'X'} };
		char[][] old = { {'X', 'X', 'O'}, {'O'} };
		char[] newLine = {'X', 'X'};
		assertArrayEquals(expected, TableauCaracteres.ajouterLigne(old, newLine));
	}

	@Test
	void enUneDimensionTest() {
		char[][] old = { {'X', 'X', 'O'}, {'O'},  {'X', 'X'} };
		char[] expected = { 'X', 'X', 'O', 'O', 'X', 'X' };
		assertArrayEquals(expected, TableauCaracteres.enUneDimension(old));
	}
	
	@Test
	void dernierePositionDeTest() {
		char[] old = { 'X', 'X', 'O', 'O', 'X', 'X' };
		char rechercheChar = 'O';
		int expected = 3;
		assertEquals(expected, TableauCaracteres.dernierePositionDe(old,rechercheChar));
	}
	
	@Test
	void dernierePositionDeTestPas() {
		char[] old = { 'X', 'X', 'O', 'O', 'X', 'X' };
		char rechercheChar = 'O';
		int expected = 3;
		assertEquals(expected, TableauCaracteres.dernierePositionDe(old,rechercheChar));
	}
}
