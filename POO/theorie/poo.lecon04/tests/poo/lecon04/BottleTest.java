package poo.lecon04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class BottleTest {
	private static final float ERROR = 0.001f;

	@Test
	void initsAnEmptyBottle() {
		Bottle beerBottle = new Bottle(25);
	
		assertTrue(beerBottle.isEmpty());
	}
	
	
	@Test
	void fillsUpAnEmptyBottle() {
		Bottle beerBottle = new Bottle(25);
		beerBottle.fill(25);
		
		
		assertFalse(beerBottle.isEmpty());
		assertTrue(beerBottle.isFull());
		assertEquals(1.0f, beerBottle.getFillRatio(), ERROR);
	}
	
	@Test
	void handlesFillOverflow() {
		Bottle beerBottle = new Bottle(25);
		beerBottle.fill(20);
		beerBottle.fill(6); //Overflowed volume should be ignored
		
		assertEquals(25, beerBottle.getVolume());
		assertFalse(beerBottle.isEmpty());
		assertTrue(beerBottle.isFull());
		assertEquals(1.0f, beerBottle.getFillRatio(), ERROR);
	}	
	
	@Test
	void ignoresFillOnNegativeVolume() {
		Bottle beerBottle = new Bottle(25);
		
		beerBottle.fill(-1);
		
		assertTrue(beerBottle.isEmpty());
		assertEquals(0.0f, beerBottle.getFillRatio(), ERROR);
	}	
	
	@Test
	void emptiesSomeVolume() {
		Bottle beerBottle = new Bottle(25);
		beerBottle.fill(25);
		
		beerBottle.empty(5);
		
		assertFalse(beerBottle.isEmpty());
		assertFalse(beerBottle.isFull());
		assertEquals(0.8f, beerBottle.getFillRatio(), ERROR);
	}
	
	@Test
	void handlesEmptyUndeflow() {
		Bottle beerBottle = new Bottle(25);
		beerBottle.fill(15);
		
		beerBottle.empty(15);
		
		assertTrue(beerBottle.isEmpty());
		assertFalse(beerBottle.isFull());
		assertEquals(0.0f, beerBottle.getFillRatio(), ERROR);
	}
	

	@Test
	void copiesItself() {
		Bottle beerBottle = new Bottle(25);
		beerBottle.fill(25);
		Bottle clone = new Bottle(beerBottle);
		
		clone.empty(5);
		
		assertEquals(25, beerBottle.getVolume());
		assertEquals(20, clone.getVolume());
	}
}
