package util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TableauEntiersTest {

	@Test
	void ajouterElementTest() {
		int[] expected = { 1, 2, 3, 4, 5 };
		int[] old = { 1, 2, 3, 4 };
		assertArrayEquals(expected, TableauEntiers.ajouterElement(old, 5));
	}
	
	@Test
	void ajouterElementTestVide() {
		int[] expected = {1};
		int[] old = {};
		assertArrayEquals(expected, TableauEntiers.ajouterElement(old, 1));
	}

}
