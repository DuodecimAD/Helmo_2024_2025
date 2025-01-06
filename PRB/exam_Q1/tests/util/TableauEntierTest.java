package util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TableauEntierTest {

	@Test
	void intervalle() {
		int[] attendu = {-2, -1, 0, 1, 2, 3};
		int[] tableau = TableauEntier.intervalle(-2, 3);
		
		assertArrayEquals(attendu, tableau);
	}
	
	@Test
	void intervalleSameNumber() {
		int value = -1;
		
		int[] attendu = {value};
		int[] tableau = TableauEntier.intervalle(value, value);
		
		assertArrayEquals(attendu, tableau);
	}

}
