package recursivite;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Plan de test pour ElementManquant.elementManquantIteratif(int[] tab)
 * 
 *
 */
public class ElementManquantIteratif1DTest {
	
	@Test
	public void testElementManquant1dPairOui() {
		assertEquals(3, ElementManquant.elementManquantIteratif(new int[] {0,1,2,6,8,10}));
	}
	
	@Test
	public void testElementManquant1dImPairOui() {
		assertEquals(3, ElementManquant.elementManquantIteratif(new int[] {0,1,2,6,10}));
	}
	
	@Test
	public void testElementManquant1dPairOuiAvantDernier() {
		assertEquals(11, ElementManquant.elementManquantIteratif(new int[] {0,1,2,3,4,5,6,7,8,9,10,12}));
	}
	
	@Test
	public void testElementManquant1dImpairOuiAvantDernier() {
		assertEquals(12, ElementManquant.elementManquantIteratif(new int[] {0,1,2,3,4,5,6,7,8,9,10,11,13}));
	}

	@Test
	public void testElementManquant1dPairOuiZero() {
		assertEquals(0, ElementManquant.elementManquantIteratif(new int[] {4,5,10,12}));
	}
	
	@Test
	public void testElementManquant1dImpairOuiZero() {
		assertEquals(0, ElementManquant.elementManquantIteratif(new int[] {4,5,10,11,13}));
	}
	
	@Test
	public void testElementManquant1dCoupleOuiMilieu() {
		assertEquals(1, ElementManquant.elementManquantIteratif(new int[] {0,2}));
	}
	
	@Test
	public void testElementManquant1dCoupleOuiZero() {
		assertEquals(0, ElementManquant.elementManquantIteratif(new int[] {1,2}));
	}

	@Test
	public void testElementManquant1dSingletonOui() {
		assertEquals(0, ElementManquant.elementManquantIteratif(new int[] {3}));
	}
	
	@Test
	public void ElementManquant1dCoupleNon() {
		assertEquals(-1, ElementManquant.elementManquantIteratif(new int[] {0,1}));
	}
	
	@Test
	public void ElementManquant1dSingletonNon() {
		assertEquals(-1, ElementManquant.elementManquantIteratif(new int[] {0}));
	}
	
	@Test
	public void ElementManquant1dPairNon() {
		assertEquals(-1, ElementManquant.elementManquantIteratif(new int[] {0,1,2,3,4,5}));
	}
	
	@Test
	public void ElementManquant1dImpairNon() {
		assertEquals(-1, ElementManquant.elementManquantIteratif(new int[] {0,1,2,3,4}));
	}
}
