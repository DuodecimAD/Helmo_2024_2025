package algo.labo02;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.Test;

import poo.labo02.Level;
import poo.labo02.Wizard;

class TrisTests {

	private static Random rand = new Random();

	@Test
	void testTrierBytesPetitTableau() {
		byte[] aTrier = {5, 4, 3, 2, 1, 1, 2, 3, 4, 5};
		byte[] attendu = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};

		Tris.trierBytes(aTrier);
		System.out.println(Arrays.toString(attendu));
		System.out.println(Arrays.toString(aTrier));
		assertArrayEquals(attendu, aTrier);
	}

	@Test
	void testTrierBytesTableauVide() {
		byte[] aTrier = {};
		byte[] attendu = {};

		Tris.trierBytes(aTrier);
		assertArrayEquals(attendu, aTrier);
	}

	@Test
	void testTrierBytesSingleton() {
		byte[] aTrier = {-7};
		byte[] attendu = {-7};

		Tris.trierBytes(aTrier);
		assertArrayEquals(attendu, aTrier);
	}


	@Test
	void testTrierBytesGrandTableauAleatoire() {
		byte[] aTrier = new byte[150000];
		byte[] attendu ;

		for(int i = 0; i < 10; i++) {
			rand.nextBytes(aTrier);
			attendu = Arrays.copyOf(aTrier, aTrier.length);
			Arrays.sort(attendu);
			Tris.trierBytes(aTrier);
			assertArrayEquals(attendu, aTrier);
		}
	}

	@Test
	void testTrierInsertionSort() {
		int[] aTrier = {5, 4, 3, 2, 1, 1, 2, 3, 4, 5};
		int[] attendu = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};

		Tris.insertionSort(aTrier);
		assertArrayEquals(attendu, aTrier);
	}

	@Test
	void testTrierInsertionSortVide() {
		int[] aTrier = {};
		int[] attendu = {};

		Tris.insertionSort(aTrier);
		assertArrayEquals(attendu, aTrier);
	}

	@Test
	void testTrierInsertionSortSingleton() {
		int[] aTrier = {17};
		int[] attendu = {17};

		Tris.insertionSort(aTrier);
		assertArrayEquals(attendu, aTrier);
	}

	@Test
	void testTrierInsertionSortRandom() {
		int[] aTrier = new int[10000];
		for(int i = 0; i < aTrier.length; ++i) {
			aTrier[i] = rand.nextInt();
		}

		int[] attendu = Arrays.copyOf(aTrier, aTrier.length);

		Tris.insertionSort(aTrier);
		Arrays.sort(attendu);

		assertArrayEquals(attendu, aTrier);
	}

	@Test
	void testWizardSort() {
		Wizard[] wizards = {
				new Wizard("Gerard Choipeau", Level.PROFESSOR),
				new Wizard("Texas Granger", Level.STUDENT),
				new Wizard("Georges Tusseki", Level.PROFESSOR),
				new Wizard("Severe Roguelike", Level.PROFESSOR),
				new Wizard("Henri Potdebeurre", Level.STUDENT),
				new Wizard("Albus Humblebundledore", Level.HEADMASTER)
		};
		
		Wizard[] clone = Arrays.copyOf(wizards, wizards.length);
		Arrays.sort(clone);
		//System.out.println(Arrays.toString(clone));
		Tris.insertionSort(wizards);
		//System.out.println(Arrays.toString(wizards));
		assertArrayEquals(clone, wizards);
	}

	// FIXME: Exercice 2
	
	@Test
	void testWizardCompareTo() {
		
		Wizard wiz1 = new Wizard("Gerard Choipeau", Level.PROFESSOR);
		Wizard wiz2 = new Wizard("Texas Granger", Level.STUDENT);
		Wizard wiz3 = new Wizard("Georges Tusseki", Level.PROFESSOR);
		Wizard wiz4 = new Wizard("Severe Roguelike", Level.PROFESSOR);
		Wizard wiz5 = new Wizard("Henri Potdebeurre", Level.STUDENT);
		Wizard wiz6 = new Wizard("Albus Humblebundledore", Level.HEADMASTER);
		
		
		assertEquals(0, wiz1.compareTo(wiz1));
		assertEquals(1, wiz1.compareTo(wiz2));
		
		// TODO à finir
	}
}
