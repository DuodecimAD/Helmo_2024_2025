package poo.lecon07;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TreeTest {
	
	@Test
	void checkIfCollideable() {
		Tree tree = new Tree(1,2);

		assertTrue(tree instanceof Collideable);
	}

	@Test
	void collision() {
		Collideable tree = new Tree(1,2);
		
		assertTrue(tree.collideWith(1,2));
	}
	
	@Test
	void noCollision() {
		Collideable tree = new Tree(1,2);
		
		assertFalse(tree.collideWith(3,5));
	}
	
	

}
