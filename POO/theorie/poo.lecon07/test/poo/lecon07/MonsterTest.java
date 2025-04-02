package poo.lecon07;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MonsterTest {

	@Test
	void checkIfCollideable() {
		var monster = new Monster(1,2);

		assertTrue(monster instanceof Collideable);
		assertTrue(monster instanceof Moveable);
		assertTrue(monster instanceof Monster);
		assertTrue(monster instanceof Object);

	}

	@Test
	void collision() {
		var monster = new Monster(1,2);
		
		assertTrue(monster.collideWith(1,2));
	}
	
	@Test
	void noCollision() {
		var monster = new Monster(1,2);
		
		assertFalse(monster.collideWith(3,5));
	}
	
	@Test
	void makeAStep() {
		var monster = new Monster(1,2);
		monster.move(2,1);
		// 1ere approche
		assertTrue(monster.getX() == 3 && monster.getY() == 3);
		// autre approche
		assertTrue(monster.collideWith(3, 3));
	}
	
	@Test
	void makeAStepFalse() {
		var monster = new Monster(1,2);
		monster.move(2,1);
		// 1ere approche
		assertFalse(monster.getX() == 5 && monster.getY() == 9);
		// autre approche
		assertFalse(monster.collideWith(5, 5));
	}
	
	@Test
	void moveToTrue() {
		var monster = new Monster(1,2);
		monster.moveTo(2,1);
		assertTrue(monster.getX() == 2 && monster.getY() == 1);
	}
	
	@Test
	void moveToFalse() {
		var monster = new Monster(1,2);
		monster.moveTo(2,1);
		assertFalse(monster.getX() == 3 && monster.getY() == 4);
	}

}
