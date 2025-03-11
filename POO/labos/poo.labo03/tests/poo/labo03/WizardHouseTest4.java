package poo.labo03;

import static poo.labo03.WizardTestData.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class WizardHouseTest4 {

	// EXERCICE 4
	// DONE: écrire des tests pour l'exercice 4.
	@Test
	public void getWizardsNames() {
		WizardHouse gryffindor = new WizardHouse(GODRIC_GRYFFINDOR);
		gryffindor.add(HARRY_POTTER);
		gryffindor.add(HERMIONE_GRANGER);
		
		assertArrayEquals(new String[]{"Godric Gryffindor", "Harry Potter", "Hermione Granger"}, gryffindor.getWizardsNames());
	}
	
	@Test
	public void getWizardsNamesWithDelete() {
		WizardHouse gryffindor = new WizardHouse(GODRIC_GRYFFINDOR);
		gryffindor.add(HARRY_POTTER);
		gryffindor.add(HERMIONE_GRANGER);
		gryffindor.remove(HARRY_POTTER);
		gryffindor.add(HARRY_POTTER);
		assertArrayEquals(new String[]{"Godric Gryffindor", "Hermione Granger", "Harry Potter"}, gryffindor.getWizardsNames());
	}

	// EXERCICE 5
	// DONE : écrire des tests validant l'exercice 5.
	@Test
	public void constructorWithTableau() {
		
		Wizard[] membres = new Wizard[] {HARRY_POTTER, HERMIONE_GRANGER};
		WizardHouse gryffindor = new WizardHouse(GODRIC_GRYFFINDOR, membres);
		membres[0] = DRAGO_MALEFOY;

		assertArrayEquals(new String[]{"Godric Gryffindor", "Harry Potter", "Hermione Granger"}, gryffindor.getWizardsNames());
	}
	

	// EXERCICE 6
	// DONE : écrire des tests validant l'exercice 6.
	@Test
	public void giveHousePoints() {

		WizardHouse gryffindor = new WizardHouse(GODRIC_GRYFFINDOR, new Wizard[] {HARRY_POTTER, HERMIONE_GRANGER});
		WizardHouse slytherin  = new WizardHouse(SALAZAR_SLYTHERIN, new Wizard[] {DRAGO_MALEFOY, MILLICENT_BUBSTRODE});
		WizardHouse hufflepuff = new WizardHouse(HELGA_HUFFLEPUFF,  new Wizard[] {TERRY_BOOT, BRANDY_BROCKLEHURST});

		gryffindor.grantPoints(HARRY_POTTER.getName(), 10);
		slytherin.grantPoints(DRAGO_MALEFOY.getName(), 10);
		hufflepuff.grantPoints(null, 0);

		assertEquals(10, gryffindor.getPoints());
		assertEquals(10, slytherin.getPoints());
		assertEquals(0, hufflepuff.getPoints());
		
		assertEquals(0, gryffindor.compareTo(gryffindor));
		assertTrue(hufflepuff.compareTo(gryffindor) < 0);
		assertTrue(gryffindor.compareTo(hufflepuff) > 0);
		assertThrows(NullPointerException.class, () -> { slytherin.compareTo(null); }); 
		assertTrue(slytherin.compareTo(gryffindor) > 0);
		
	}
}
