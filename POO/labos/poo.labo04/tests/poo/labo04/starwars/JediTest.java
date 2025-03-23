package poo.labo04.starwars;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 */
class JediTest {

	@Test
	void instanceOfBaseCharacter() {
		Jedi test = new Jedi("Test", 20, 5);

		assertTrue(test instanceof BaseCharacter);
	}

	@Test
	void instanceOfForceUser() {
		Jedi test = new Jedi("Test", 20, 5);

		assertTrue(test instanceof ForceUser);
	}

	@Test
	void useForceNormal() {
		Jedi windu = new Jedi("Mace Windu", 300, 25);
		BaseCharacter trooper2 = new BaseCharacter("Storm Trooper 2", 15);

		assertEquals("Mace Windu utilise la Force sur Storm Trooper 2. Dégâts causés : 25.",
				windu.useForceOn(trooper2));

		assertEquals("Storm Trooper 2 est mort : 0 hp.", trooper2.toString());
	}

	@Test
	void useForceOnNull() {
		Jedi mon = new Jedi("Mon Li-esi", 18, 25);

		assertEquals("Mon Li-esi n'utilise pas la Force.", mon.useForceOn(null));
	}

	@Test
	void useRageOnNull() {
		Jedi mon = new Jedi("Mon Li-esi", 18, 25);
		mon.loseHP(16);
		assertEquals("Mon Li-esi n'utilise pas la Force.", mon.useForceOn(null));
	}

	@Test
	void useRageNormal() {
		Jedi windu = new Jedi("Mace Windu", 300, 25);
		BaseCharacter walker = new BaseCharacter("AT-AT Walker", 1000);

		windu.loseHP(298);

		assertEquals("Mace Windu utilise la rage de la Force sur AT-AT Walker. Dégâts causés : 250.",
				windu.useForceOn(walker));
	}
	
	@Test
	void useRageOnceOnly() {
		Jedi windu = new Jedi("Mace Windu", 300, 25);
		BaseCharacter walker = new BaseCharacter("AT-AT Walker", 1000);

		windu.loseHP(298);

		assertEquals("Mace Windu utilise la rage de la Force sur AT-AT Walker. Dégâts causés : 250.",
				windu.useForceOn(walker));
		assertEquals("Mace Windu utilise la Force sur AT-AT Walker. Dégâts causés : 25.",
				windu.useForceOn(walker));
		assertEquals(725, walker.getHP());
	}

}
