package huittours;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HuitToursTest {

	@Test
	void creerEchiquier3() {
		char[][] attendu = {{'T', 'T', 'T'},{' ', ' ', ' '},{' ', ' ', ' '}};
		int valeur = 3;
		
		assertArrayEquals(attendu, HuitTours.creerEchiquier(valeur));
	}

}
