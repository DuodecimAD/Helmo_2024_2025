package shifumi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import util.TableauChaines;

class ShifumiTest {

	@Test
	void comparerTestPerd() {
		String arme1 = "Spock";
		String arme2 = "Feuille";

		assertEquals(-1, Shifumi.comparer(arme1, arme2));
	}
	
	@Test
	void comparerTestGagne() {
		String arme1 = "Spock";
		String arme2 = "Feuille";

		assertEquals(1, Shifumi.comparer(arme2, arme1));
	}
	
	@Test
	void comparerTestEgal() {
		String arme1 = "Feuille";
		String arme2 = "Feuille";

		assertEquals(0, Shifumi.comparer(arme1, arme2));
	}
	

}
