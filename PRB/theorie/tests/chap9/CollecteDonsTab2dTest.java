package chap9;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.Console;

class CollecteDonsTab2dTest {

	@Test
	void sommerLignesTest() {
		int[][] tab2d = {{5,10}, {}, {20}, {15,10,20}};
		
		int[] tabAttendu  = { 15, 0, 20, 45};
		CollecteDonsTab2d.sommerLignes(tab2d);
		assertArrayEquals(tabAttendu, CollecteDonsTab2d.sommerLignes(tab2d));
	}
	
	@Test
	void moyenne_avecTableauDe6ElementsTest() {
		assertEquals(4.333, CollecteDonsTab2d.moyenne(new int[] { 1,8,9,5,3,0 }), 0.001); // approximation
	}
	
	@Test
	void moyenne_avecTableauVideTest() {
		assertEquals(Double.NaN, CollecteDonsTab2d.moyenne(new int[] { }), 0.001); 
	}
	
	@BeforeEach
	void reset() {
		Console.nettoyerSaisies();
	}
	
	@Test
	void lireDon_premiereSaisieCorrecteTest() {
		Console.simulerSaisies("+100");
		assertEquals(100, CollecteDonsTab2d.lireDon("Montant du don ? "));
	}
	
	@Test
	void lireDon_deuxSaisiesSaisieCorrecteTest() {
		Console.simulerSaisies("cent", "-50", "+100");
		assertEquals(100, CollecteDonsTab2d.lireDon("Montant du don ? "));
	}
	
	@Test
	void evaluer_montantImpossibleTest() {
		assertEquals("Montant impossible !", CollecteDonsTab2d.evaluer(-100));
	}
	
	@Test
	void evaluer_montantTresMauvaisTest() {
		assertEquals("Très mauvais !", CollecteDonsTab2d.evaluer(50));
	}
	
	@Test
	void evaluer_montantSuperTest() {
		assertEquals("Super !", CollecteDonsTab2d.evaluer(1500));
	}
	
	@Test
	void evaluer_montantPeutFaireMieuxTest() {
		assertEquals("Peut faire mieux !", CollecteDonsTab2d.evaluer(250));
	}
	
	@Test
	void evaluer_montantPasMalTest() {
		assertEquals("Pas mal !", CollecteDonsTab2d.evaluer(900));
	}
	

	
}
