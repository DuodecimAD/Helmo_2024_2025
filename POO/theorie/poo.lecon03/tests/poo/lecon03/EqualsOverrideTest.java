package poo.lecon03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class EqualsOverrideTest {
	@Test
	public void validatingColorEquality() {
		Color helmo = new Color(211, 67, 26);
		Color same = helmo;
		Color clone = new Color(211, 67, 26);
		
		assertEquals(helmo, helmo, "a object should be equal to itself");
		assertEquals(helmo, same, "two references to the same objects should be equal");
		assertEquals(helmo, clone, "two colors in the same state should be equal");
//		fail("Décommente-moi");
	}
	
	@Test
	public void validatingColorInequality() {
		Color helmo = new Color(211, 67, 26);
		Color differentR = new Color(210, 67, 26);
		Color differentG = new Color(211, 68, 26);
		Color differentB = new Color(211, 67, 27);
		
		assertNotEquals(helmo, null, "an object should be different from null");
		assertNotEquals(helmo, new Dice(5), "objects should differ on different type");
		assertNotEquals(helmo, differentR, "a color should differ on red");
		assertNotEquals(helmo, differentG, "a color should differ on green");
		assertNotEquals(helmo, differentB, "a color should differ on blue");
//		fail("Décommente-moi");
	}
	
	@Test
	public void validatingDominoEquality() {
		Domino domino = new Domino(4, 5);
		Domino same = domino;
		Domino clone = new Domino(4, 5);
		
		assertEquals(domino, domino, "a object should be equal to itself");
		assertEquals(domino, same, "two references to the same objects should be equal");
		assertEquals(domino, clone, "two dominoes in the same state should be equal");
//		fail("Décommente-moi");
	}
	
	@Test
	public void validatingDominoInequality() {
		Domino domino = new Domino(4, 5);
		Domino differentSpot1 = new Domino(2, 5);
		Domino differentSpot2 = new Domino(4, 4);
		
		assertNotEquals(domino, null, "an object should be different from null");
		assertNotEquals(domino, new Dice(5), "objects should differ on different type");
		assertNotEquals(domino, differentSpot1, "a domino should differ on first spots");
		assertNotEquals(domino, differentSpot2, "a domino should differ on second spots");
//		fail("Décommente-moi");
	}
}
