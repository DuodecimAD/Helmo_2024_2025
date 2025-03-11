package poo.labo02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WizardsTests {

	@Test
	void compareToThrowsNull() {
		Wizard nullReff = null;
		Wizard notNull = new Wizard(null, null);
		
		assertThrows(NullPointerException.class, () -> {notNull.compareTo(nullReff);});
	}
	
	@Test
	void compareToSelfIs0() {
		Wizard notNull = new Wizard(null, null);
		Wizard x = new Wizard("Albus", Level.HEADMASTER);
		Wizard y =  new Wizard("Albus", Level.HEADMASTER);
		
		assertEquals(0, notNull.compareTo(notNull));
		assertEquals(0, x.compareTo(y));
		assertEquals(0, y.compareTo(x));
	}
	
	@Test
	void compareToReversedIsOpposed() {
		Wizard x = new Wizard("Albus", Level.HEADMASTER);
		Wizard y = new Wizard("Sirius", Level.GRADUATED);
		Wizard z = new Wizard("Severus", Level.HEADMASTER);
		
		assertSignumEquals(x.compareTo(y), -y.compareTo(x));
		assertSignumEquals(x.compareTo(z), -z.compareTo(x));
		assertSignumEquals(z.compareTo(y), -y.compareTo(z));
	}
	
	/**
	 * Assert qui vérifie que les signes des entiers espérés et effectifs sont égaux.
	 * @param expected valeur attendue
	 * @param actual valeur effectivement obtenue et à tester
	 */
	private static void assertSignumEquals(int expected, int actual) {
		assertEquals(Integer.signum(expected), Integer.signum(actual));
	}
	
	@Test
	void compareToIsTransitive() {
		Wizard x = new Wizard("Albus", Level.HEADMASTER);
		Wizard y = new Wizard("Severus", Level.HEADMASTER);
		Wizard z = new Wizard("Sirius", Level.GRADUATED);
			
		assertTrue(x.compareTo(y) < 0);
		assertTrue(y.compareTo(x) > 0);
		assertTrue(y.compareTo(z) < 0);
		assertTrue(z.compareTo(y) > 0);
		assertTrue(x.compareTo(z) < 0);
		assertTrue(z.compareTo(x) > 0);
	}
	
	@Test
	void comapreToIsConsistentWhenComparingToEqualRef() {
		Wizard x = new Wizard("Albus", Level.HEADMASTER);
		Wizard y = new Wizard("Sirius", Level.GRADUATED);
		Wizard z = new Wizard("Severus", Level.HEADMASTER);
		Wizard zAgain = new Wizard("Severus", Level.HEADMASTER);
		
		assertEquals(0, z.compareTo(zAgain));
		
		assertTrue(z.compareTo(y) < 0);
		assertTrue(zAgain.compareTo(y) < 0);
		
		assertTrue(z.compareTo(x) > 0);
		assertTrue(zAgain.compareTo(x) > 0);
	}
}
