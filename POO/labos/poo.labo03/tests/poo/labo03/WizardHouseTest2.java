package poo.labo03;

import static poo.labo03.WizardTestData.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class WizardHouseTest2 {
	@Test
	public void addsNewMembers() {
		WizardHouse ravenclawHouse = new WizardHouse(ROWENA_RAVENCLAW);

		ravenclawHouse.add(TERRY_BOOT);
		ravenclawHouse.add(BRANDY_BROCKLEHURST);

		assertEquals(3, ravenclawHouse.getWizardsCount());
//		fail("Uncomment-me");
	}

	@Test
	public void hasOneMembersOnCreation() {
		WizardHouse slytherinHouse = new WizardHouse(SALAZAR_SLYTHERIN);

		assertEquals(1, slytherinHouse.getWizardsCount());
//		fail("Uncomment-me");
	}

	@Test
	public void ignoresAddOnNull() {
		WizardHouse slytherinHouse = new WizardHouse(SALAZAR_SLYTHERIN);

		slytherinHouse.add(null);

		assertEquals(1, slytherinHouse.getWizardsCount());
//		fail("Uncomment-me");
	}

	@Test
	public void ignoresAddOnAlreadyRegisteredMember() {
		WizardHouse slytherinHouse = new WizardHouse(SALAZAR_SLYTHERIN);

		slytherinHouse.add(MILLICENT_BUBSTRODE);
		slytherinHouse.add(DRAGO_MALEFOY);
		slytherinHouse.add(MILLICENT_BUBSTRODE);
		slytherinHouse.add(DRAGO_MALEFOY);

		assertEquals(3, slytherinHouse.getWizardsCount());
//		fail("Uncomment-me");
	}

	@Test
	public void ignoresAddOnFounder() {
		WizardHouse slytherinHouse = new WizardHouse(SALAZAR_SLYTHERIN);

		slytherinHouse.add(MILLICENT_BUBSTRODE);
		slytherinHouse.add(SALAZAR_SLYTHERIN);

		assertEquals(2, slytherinHouse.getWizardsCount());
//		fail("Uncomment-me");
	}

}
