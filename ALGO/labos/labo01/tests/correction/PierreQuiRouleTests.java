package correction;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PierreQuiRouleTests {

	@Test
	void testPencheVersGaucheEnonce() {
		char[] avant = PierreQuiRoule.nouvellePlanche(" O# O  O    ");
		char[] apres = PierreQuiRoule.nouvellePlanche("O #OO       ");
		PierreQuiRoule.penche(avant, true);
		assertArrayEquals(apres, avant);
	}
	
	@Test
	void neFaitRienSiPasDeplacementPossible() {
		char[] avant = PierreQuiRoule.nouvellePlanche("#OOOO#OO#OOO##O");
		char[] apres = PierreQuiRoule.nouvellePlanche("#OOOO#OO#OOO##O");
		PierreQuiRoule.penche(avant, true);
		assertArrayEquals(apres, avant);
		PierreQuiRoule.penche(avant, false);
		assertArrayEquals(apres, avant);
	}
	
	@Test
	void neFaitRienSiPasDeRochers() {
		char[] avant = PierreQuiRoule.nouvellePlanche("#    #  #   ## #");
		char[] apres = PierreQuiRoule.nouvellePlanche("#    #  #   ## #");
		PierreQuiRoule.penche(avant, true);
		assertArrayEquals(apres, avant);
		PierreQuiRoule.penche(avant, false);
		assertArrayEquals(apres, avant);
	}
	
	@Test
	void testPencheVersGaucheEnonce2() {
		char[] avant = PierreQuiRoule.nouvellePlanche(" O# O  O #   OOO");
		char[] apres = PierreQuiRoule.nouvellePlanche("O #OO    #OOO   ");
		PierreQuiRoule.penche(avant, true);
		assertArrayEquals(apres, avant);
	}
	
	@Test
	void testPencheVersDroiteEnonce() {
		char[] avant = PierreQuiRoule.nouvellePlanche(" O# O  O    ");
		char[] apres = PierreQuiRoule.nouvellePlanche(" O#       OO");
		PierreQuiRoule.penche(avant, false);
		assertArrayEquals(apres, avant);
	}
	
	@Test
	void testPencheUnSeulMurNonModifie() {
		char[] avant = {'#'};
		char[] apres = {'#'};
		PierreQuiRoule.penche(avant, true);
		assertArrayEquals(apres, avant);
		PierreQuiRoule.penche(avant, false);
		assertArrayEquals(apres, avant);
	}
	
	@Test
	void testPenchePlancheVide() {
		char[] avant = {};
		char[] apres = {};
		PierreQuiRoule.penche(avant, true);
		assertArrayEquals(apres, avant);
		PierreQuiRoule.penche(avant, false);
		assertArrayEquals(apres, avant);
	}

}
