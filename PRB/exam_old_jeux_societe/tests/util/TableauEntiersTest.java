package util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TableauEntiersTest {

	@Test
	void sommerTest() {
		assertEquals(20, TableauEntiers.sommer(new int[] { 3, 12, 5 }));
		assertEquals(0, TableauEntiers.sommer(new int[] {}));
	}

	@Test
	void calculerTauxTest() {
		int[] tableau = { 3, 12, 5 };
		double[] attendu = { 15.0, 60.0, 25.0 };

		assertArrayEquals(attendu, TableauEntiers.calculerTaux(tableau));
	}

	@Test
	void calculerTauxTestSans() {
		int[] tableau = { 0, 0, 0 };
		double[] attendu = { Double.NaN, Double.NaN, Double.NaN };

		assertArrayEquals(attendu, TableauEntiers.calculerTaux(tableau));
	}

	@Test
	void calculerTauxTest2D() {
		int[][] tableau = { { 3, 12, 5 }, { 24, 8, 0 }, { 2, 9, 4 }, { 0, 0, 0 } };
		double[][] attendu = { { 15.0, 60.0, 25.0 }, { 75.0, 25.0, 0.0 }, { 13.333, 60.0, 26.666 },
				{ Double.NaN, Double.NaN, Double.NaN } };

		//assertArrayEquals(attendu, TableauEntiers.calculerTaux(tableau));

		for (int i = 0; i < tableau.length; i++) {
			assertArrayEquals(attendu[i], TableauEntiers.calculerTaux(tableau[i]), 0.001);
		}
	}

	@Test
	void calculerTauxTest2DNull() {
		int[][] tableau = { { 3, 12, 5 }, { 24, 8, 0 }, null, { 0, 0, 0 } };
		double[][] attendu = { { 15.0, 60.0, 25.0 }, { 75.0, 25.0, 0.0 }, null,
				{ Double.NaN, Double.NaN, Double.NaN } };

		assertArrayEquals(attendu, TableauEntiers.calculerTaux(tableau));
	}
}
