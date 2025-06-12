package recursivite;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Plan de test pour ElementManquant.elementManquantIteratif(int[][] tab)
 * 
 *
 */
public class ElementManquantIteratif2DTest {
	
	@Test
	public void testElementManquant2dPairPairOuiLigne1() {
		assertEquals(3, ElementManquant.elementManquantIteratif(new int[][] {{0,1,2,6}, {7,8,10,11}}));
	}
	
	@Test
	public void testElementManquant2dImpairPairOuiLigne1() {
		assertEquals(3, ElementManquant.elementManquantIteratif(new int[][] {{0,1,2,6}, {7,8,10,11}, {12,14,16,17}}));
	}
	
	@Test
	public void testElementManquant2dPairImpairOuiLigne1() {
		assertEquals(2, ElementManquant.elementManquantIteratif(new int[][] {{0,1,3}, {7,8,10}}));
	}
	
	@Test
	public void testElementManquant2dImpairImpairOuiLigne1() {
		assertEquals(2, ElementManquant.elementManquantIteratif(new int[][] {{0,1,3}, {7,8,10}, {12,14,16}}));
	}
	
	@Test
	public void testElementManquant2dPairPairOuiLigne2() {
		assertEquals(5, ElementManquant.elementManquantIteratif(new int[][] {{0,1,2,3}, {4,8,10,11}}));
	}
	
	@Test
	public void testElementManquant2dImpairPairOuiLigne2() {
		assertEquals(5, ElementManquant.elementManquantIteratif(new int[][] {{0,1,2,3}, {4,8,10,11}, {12,14,16,17}}));
	}
	
	@Test
	public void testElementManquant2dPairImpairOuiLigne2() {
		assertEquals(4, ElementManquant.elementManquantIteratif(new int[][] {{0,1,2}, {3,8,10}}));
	}
	
	@Test
	public void testElementManquant2dImpairImpairOuiLigne2() {
		assertEquals(4, ElementManquant.elementManquantIteratif(new int[][] {{0,1,2}, {3,8,10}, {12,14,16}}));
	}
	
	@Test
	public void testElementManquant2dPairPairOuiAvantDernier() {
		assertEquals(11, ElementManquant.elementManquantIteratif(new int[][] {{0,1,2,3,4,5},{6,7,8,9,10,12}}));
	}
	
	@Test
	public void testElementManquant2dImpairImpairOuiAvantDernier() {
		assertEquals(9, ElementManquant.elementManquantIteratif(new int[][] {{0,1,2,3,4},{5,6,7,8,10}}));
	}

	@Test
	public void testElementManquant2dPairPairOuiZero() {
		assertEquals(0, ElementManquant.elementManquantIteratif(new int[][] {{4,5,10,11}, {14,15,20,21}}));
	}
	
	@Test
	public void testElementManquant2dImpairImpairOuiZero() {
		assertEquals(0, ElementManquant.elementManquantIteratif(new int[][] {{4,5,10,11,12}, {14,15,20,21,22}}));
	}
	
	@Test
	public void testElementManquant2dDeuxFoisDeuxOuiMilieuLigne1() {
		assertEquals(1, ElementManquant.elementManquantIteratif(new int[][] {{0,2}, {3,4}}));
	}
	
	@Test
	public void testElementManquant2dDeuxFoisDeuxOuiMilieuLigne2() {
		assertEquals(3, ElementManquant.elementManquantIteratif(new int[][] {{0,1}, {2,4}}));
	}

	@Test
	public void testElementManquant2dDeuxFoisunOui() {
		assertEquals(1, ElementManquant.elementManquantIteratif(new int[][] {{0}, {2}}));
	}

	@Test
	public void testElementManquant2dDeuxFoisDeuxNon() {
		assertEquals(-1, ElementManquant.elementManquantIteratif(new int[][] {{0,1}, {2,3}})); 
	}
	
	@Test
	public void testElementManquant1dDeuxFoisUnNon() {
		assertEquals(-1, ElementManquant.elementManquantIteratif(new int[][] {{0}, {1}}));
	}
	
	@Test
	public void testElementManquant2dPairNon() {
		assertEquals(-1, ElementManquant.elementManquantIteratif(new int[][] {{0,1,2,3,4,5},{6,7,8,9,10,11}}));
	}
	
	@Test
	public void ElementManquant2dImpairNon() {
		assertEquals(-1, ElementManquant.elementManquantIteratif(new int[][] {{0,1,2,3,4},{5,6,7,8,9}}));
	}
}
