package poo.lecon03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class DiceTest {
	@Test
	public void initsWithValidFacesCount() {
		Dice dice = new Dice(5);		
//		dice.init(5);
		
		assertEquals(5, dice.getFacesCount(), "dice face count should be 5");
		
		assertTrue(1 <= dice.getTopFace(), "a dice top face should be >= 1");
		assertTrue(dice.getTopFace() <= 5, "a dice top face should be <= facesCount");
//		fail("Décommente-moi");
	}
	
	@Test
	public void initsWithTooFewFacesCount() {
		Dice dice = new Dice(1);
//		dice.init(1);
		
		assertEquals(6, dice.getFacesCount(), "a dice top face should be >= 1");
		
		assertTrue(1 <= dice.getTopFace(), "a dice top face should be >= 1");		
		assertTrue(dice.getTopFace() <= 6, "a dice top face should be <= facesCount");
//		fail("Décommente-moi");
	}
	
	@Test
	public void initsWithTooManyFacesCount() {
		Dice dice = new Dice(7);
//		dice.init(7);
		
		assertEquals(6, dice.getFacesCount(), "a dice top face should be >= 1");
		
		assertTrue(1 <= dice.getTopFace(), "a dice top face should be >= 1");
		assertTrue(dice.getTopFace() <= 6, "a dice top face should be <= facesCount");
//		fail("Décommente-moi");
	}
	
	@Test
	public void returnsTheSameTopFaceOnManyCalls() {
		Dice dice = new Dice(6);
//		dice.init(6);
		
		int oldTopFace = dice.getTopFace();
		int newTopFace = dice.getTopFace();
		
		assertEquals(oldTopFace, newTopFace);
//		fail("Décommente-moi");
	}
	
	@Test
	public void updatesTopFaceOnRoll() {
		Dice dice = new Dice(6);
//		dice.init(6);
		
		int oldTopFace = dice.getTopFace();
		
		dice.roll();
		
		assertNotEquals(oldTopFace, dice.getTopFace());
//		fail("Décommente-moi");
	}
}
