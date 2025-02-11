package poo.lecon03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class DominoTest {
//	@Test
//	public void initsWithValidValues() {
//		Domino domino = new Domino();
//		domino.init(3,4);
//		
//		assertEquals(3, domino.getSpotsAt(0), "this domino should have 3 spots for the first group");
//		assertEquals(4, domino.getSpotsAt(1), "this domino should have 4 spots for the first group");
////		fail("Décommente-moi");
//	}
//	
//	@Test
//	public void initsWithZeroes() {
//		Domino domino = new Domino();
//		domino.init(0, 0);
//		
//		assertEquals(0, domino.getSpotsAt(0), "this domino should have no spots for the first group");
//		assertEquals(0, domino.getSpotsAt(1), "this domino should have no spots for the first group");
////		fail("Décommente-moi");
//	}
//	
//	@Test
//	public void initsWithInvalidSpotsForFirstGroup() {
//		Domino domino = new Domino();
//		domino.init(7,0);
//		
//		assertTrue(0 <= domino.getSpotsAt(0), "this domino should have at least 0 spots for his first group");
//		assertTrue(domino.getSpotsAt(0) <= 6, "this domino should have at most 6 spots for his first group");
////		fail("Décommente-moi");
//	}
//	
//	@Test
//	public void initsWithInvalidSpotsForSecondGroup() {
//		Domino domino = new Domino();		
//		domino.init(4,-1);
//		
//		assertTrue(0 <= domino.getSpotsAt(1), "this domino should have at least 0 spots for his second group");
//		assertTrue(domino.getSpotsAt(1) <= 6, "this domino should have at most 6 spots for his second group");
////		fail("Décommente-moi");
//	}
//	
//	@Test
//	public void initsWithInvalidSpotsForBothGroups() {
//		Domino domino = new Domino();
//		domino.init(-2, 8);
//		
//		assertTrue(0 <= domino.getSpotsAt(0), "this domino should have at least 0 spots for his first group");
//		assertTrue(domino.getSpotsAt(0) <= 6, "this domino should have at most 6 spots for his first group");
//	
//		assertTrue(0 <= domino.getSpotsAt(1), "this domino should have at least 0 spots for his second group");
//		assertTrue(domino.getSpotsAt(1) <= 6, "this domino should have at most 6 spots for his second group");
////		fail("Décommente-moi");
//	}
	
	@Test
	public void checksCompatibilityWithAnothorDominoOnOppositeGroups() {
		Domino domino1 = new Domino(2,6);
		Domino domino2 = new Domino(6,3);
//		domino1.init(2,6);
//		domino2.init(6,3);
		
		assertTrue(domino1.isCompatibleWith(domino2));
		assertTrue(domino2.isCompatibleWith(domino1));
//		fail("Décommente-moi");
	}
	
	@Test
	public void checksCompatibilityWithAnothorDominoOnFirstGroup() {
		Domino domino1 = new Domino(5,1);
		Domino domino2 = new Domino(5,2);	
//		domino1.init(5,1);
//		domino2.init(5,2);
		
		assertTrue(domino1.isCompatibleWith(domino2));
		assertTrue(domino2.isCompatibleWith(domino1));
//		fail("Décommente-moi");
	}
	
	@Test
	public void checksCompatibilityWithAnothorDominoOnSecondGroup() {
		Domino domino1 = new Domino(3, 2);
		Domino domino2 = new Domino(4, 2);	
//		domino1.init(3, 2);
//		domino2.init(4, 2);
		
		assertTrue(domino1.isCompatibleWith(domino2));
		assertTrue(domino2.isCompatibleWith(domino1));
//		fail("Décommente-moi");
	}
	
	@Test
	public void checksIncompatibility() {
		Domino domino1 = new Domino(0, 1);
		Domino domino2 = new Domino(2, 3);	
//		domino1.init(0, 1);
//		domino2.init(2, 3);
		
		assertFalse(domino1.isCompatibleWith(domino2));
		assertFalse(domino2.isCompatibleWith(domino1));
//		fail("Décommente-moi");
	}

}

