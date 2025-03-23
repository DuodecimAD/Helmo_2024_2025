package poo.labo04.starwars;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BaseCharacterTest {

	@Test
	void baseCharacterCreation() {
		BaseCharacter obiwan = new BaseCharacter("Obiwan Kenobi", 20);
		
		assertEquals("Obiwan Kenobi est vivant : 20 hp.", obiwan.toString());
	}
	
	@Test
	void baseCharacterCreationNull() {
		BaseCharacter inconnu = new BaseCharacter(null, 20);
		
		assertEquals("Inconnu est vivant : 20 hp.", inconnu.toString());
	}
	
	@Test
	void baseCharacterCreationHpNegative() {
		BaseCharacter inconnu = new BaseCharacter("  ", -5);
		
		assertEquals("Inconnu est vivant : 5 hp.", inconnu.toString());
	}
	
	@Test
	void baseCharacterCreationEmpty() {
		BaseCharacter inconnu = new BaseCharacter("  ", 20);
		
		assertEquals("Inconnu est vivant : 20 hp.", inconnu.toString());
	}
	
	@Test
	void loseHpButAlive() {
		BaseCharacter obiwan = new BaseCharacter("Obiwan Kenobi", 20);
		obiwan.loseHP(15);
		assertEquals("Obiwan Kenobi est vivant : 5 hp.", obiwan.toString());
	}
	
	@Test
	void loseHpAndDead() {
		BaseCharacter obiwan = new BaseCharacter("Obiwan Kenobi", 20);
		obiwan.loseHP(25);
		assertEquals("Obiwan Kenobi est mort : 0 hp.", obiwan.toString());
	}
	
	

}
