package poo.labo04.starwars;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests de la classe ForceUser
 */
class ForceUserTest {

	@Test
	void instanceOfBaseCharacter() {
		ForceUser test = new ForceUser("Test", 20, 5);
		
		assertTrue(test instanceof BaseCharacter);
	}
	
	@Test
	void creationNormal() {
		ForceUser leia = new ForceUser("Leia Organa", 30, 5);
		
		assertEquals("Leia Organa est vivant : 30 hp. Ses damagePoints : 5 DP.", leia.toString());
	}
	
	@Test
	void forceUsedOnNull() {
		ForceUser leia = new ForceUser("Leia Organa", 30, 5);
		
		assertEquals("Leia Organa n'utilise pas la Force.", leia.useForceOn(null));
	}
	
	@Test
	void forceUsedOnTarget() {
		ForceUser leia = new ForceUser("Leia Organa", 30, 5);
		BaseCharacter trooper = new BaseCharacter("Storm Trooper", 15);
		leia.useForceOn(trooper);
		assertEquals("Storm Trooper est vivant : 10 hp.", trooper.toString());
	}

}
