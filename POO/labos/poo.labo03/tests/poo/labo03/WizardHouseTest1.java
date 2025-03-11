package poo.labo03;

import static poo.labo03.WizardTestData.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class WizardHouseTest1 {
	@Test
	public void returnsFounderLastnameAsWizardHouseName() {
		WizardHouse gryffindorHouse = new WizardHouse(GODRIC_GRYFFINDOR);

		assertEquals("Gryffindor", gryffindorHouse.getName());
//		fail("Uncomment-me");
	}

	@Test
	public void initsWithYouKnowWhoOnNullFounder() {
		WizardHouse house = new WizardHouse(null);

		assertEquals("Death Eaters", house.getName());
//		fail("Uncomment-me");
	}

	@Test
	public void returnsFounderLastnameOnNoFirstname() {
		WizardHouse riddleHouse = new WizardHouse(new Wizard("Riddle"));

		assertEquals("Riddle", riddleHouse.getName());
//		fail("Uncomment-me");
	}

	@Test
	public void hasAStringRepresentation() {
		WizardHouse hufflepuffHouse = new WizardHouse(HELGA_HUFFLEPUFF);
		WizardHouse riddleHouse = new WizardHouse(null);

		assertEquals("WizardHouse(name: Hufflepuff, founder: Helga Hufflepuff)", hufflepuffHouse.toString());
		assertEquals("WizardHouse(name: Death Eaters, founder: Lord Voldemort)", riddleHouse.toString());
//		fail("Uncomment-me");
	}
}
