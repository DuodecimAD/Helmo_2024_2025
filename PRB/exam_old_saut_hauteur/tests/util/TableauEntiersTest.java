package util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TableauEntiersTest {

	@Test
	void ajouterIntElementTest() {
		int[] expected = { 1, 2, 3, 4, 5 };
		int[] old = { 1, 2, 3, 4 };
		assertArrayEquals(expected, TableauEntiers.ajouterElement(old, 5));
	}

}
