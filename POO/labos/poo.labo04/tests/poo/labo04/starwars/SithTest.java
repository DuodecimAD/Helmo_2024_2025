package poo.labo04.starwars;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 */
class SithTest {
	
	

	private static final String MACE_WINDU = "Mace Windu";
	private static final String DARTH_SIDIOUS = "Darth Sidious";
	private static final String DARTH_VADER = "Darth Vader";
	private static final String Z6PO = "Z-6PO";
	

	@Test
	void instanceOfBaseCharacter() {
		Sith sidious = new Sith(DARTH_SIDIOUS, 20, 5);

		assertTrue(sidious instanceof BaseCharacter);
	}

	@Test
	void instanceOfForceUser() {
		Sith sidious = new Sith(DARTH_SIDIOUS, 20, 5);

		assertTrue(sidious instanceof ForceUser);
	}

	@Test
	void useForceNormal() {
		Sith sidious = new Sith(DARTH_SIDIOUS, 305, 21);
		Jedi windu = new Jedi(MACE_WINDU, 300, 25);

		assertEquals(DARTH_SIDIOUS + " utilise la Force sur "+ MACE_WINDU +". Dégâts causés : 21.", sidious.useForceOn(windu));

		assertEquals(279, windu.getHP());
	}

	@Test
	void useForceChoke() {
		Sith sidious = new Sith(DARTH_SIDIOUS, 305, 21);
		Jedi windu = new Jedi(MACE_WINDU, 300, 25);

		sidious.useForceOn(windu);
		sidious.useForceOn(windu);
		assertEquals(DARTH_SIDIOUS + " étrangle "+ MACE_WINDU +". Dégâts causés : 42.", sidious.useForceOn(windu));
		assertEquals(216, windu.getHP());
	}

	@Test
	void useForceLightning() {
		Sith sidious = new Sith(DARTH_SIDIOUS, 305, 21);
		Jedi windu = new Jedi(MACE_WINDU, 300, 25);

		for (int i = 1; i < 5; i++) {
			sidious.useForceOn(windu);
		}

		assertEquals(DARTH_SIDIOUS + " lance des éclairs sur "+ MACE_WINDU +". Dégâts causés : 105.", sidious.useForceOn(windu));
		assertEquals(90, windu.getHP());
	}

	@Test
	void useForceLightningOverChoke() {
		Sith sidious = new Sith(DARTH_SIDIOUS, 305, 21);
		Jedi windu = new Jedi(MACE_WINDU, 300, 25);

		for (int i = 1; i < 15; i++) {
			sidious.useForceOn(windu);
		}

		assertEquals(DARTH_SIDIOUS + " lance des éclairs sur "+ MACE_WINDU +". Dégâts causés : 105.", sidious.useForceOn(windu));
		assertEquals(0, windu.getHP());
	}
	
	@Test
	void useForceOnNull() {
		Sith vader = new Sith(DARTH_VADER, 400, 50);
		BaseCharacter z6po = new BaseCharacter(Z6PO, 150);

		assertEquals(DARTH_VADER + " n'utilise pas la Force.", vader.useForceOn(null));
	}
	
	@Test
	void useNotForceChokeOnNull() {
		Sith vader = new Sith(DARTH_VADER, 400, 50);
		BaseCharacter z6po = new BaseCharacter(Z6PO, 150);

		vader.useForceOn(z6po);
		vader.useForceOn(z6po);
		assertEquals(DARTH_VADER + " n'utilise pas la Force.", vader.useForceOn(null));
		assertEquals(50, z6po.getHP());
	}

	@Test
	void useNotForceLightningOnNull() {
		Sith jarjar = new Sith("Jar Jar Binks", 305, 21);
		BaseCharacter r2d2 = new BaseCharacter("R2D2", 1500);

		for (int i = 1; i < 5; i++) {
			jarjar.useForceOn(r2d2);
		}

		assertEquals("Jar Jar Binks n'utilise pas la Force.", jarjar.useForceOn(null));
		assertEquals(1395, r2d2.getHP());
		
	}

	
	
}
