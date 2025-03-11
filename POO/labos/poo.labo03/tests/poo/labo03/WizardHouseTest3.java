package poo.labo03;

import static poo.labo03.WizardTestData.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class WizardHouseTest3 {
	@Test
	public void removesMembers() {
		WizardHouse slytherinHouse = new WizardHouse(SALAZAR_SLYTHERIN);

		slytherinHouse.add(MILLICENT_BUBSTRODE);
		slytherinHouse.add(DRAGO_MALEFOY);

		slytherinHouse.remove(MILLICENT_BUBSTRODE);

		assertEquals(2, slytherinHouse.getWizardsCount());
//		fail("Uncomment-me");
	}

	@Test
	public void ignoresRemovalOfUnregisteredMember() {
		WizardHouse slytherinHouse = new WizardHouse(SALAZAR_SLYTHERIN);

		slytherinHouse.add(MILLICENT_BUBSTRODE);
		slytherinHouse.add(DRAGO_MALEFOY);

		slytherinHouse.remove(HARRY_POTTER);

		assertEquals(3, slytherinHouse.getWizardsCount());
//		fail("Uncomment-me");
	}

	@Test
	public void ignoresRemovalOfNull() {
		WizardHouse slytherinHouse = new WizardHouse(SALAZAR_SLYTHERIN);

		slytherinHouse.add(MILLICENT_BUBSTRODE);

		slytherinHouse.remove(null);

		assertEquals(2, slytherinHouse.getWizardsCount());
//		fail("Uncomment-me");
	}

	@Test
	public void ignoresRemovalOfFounder() {
		WizardHouse slytherinHouse = new WizardHouse(SALAZAR_SLYTHERIN);

		slytherinHouse.add(MILLICENT_BUBSTRODE);
		slytherinHouse.add(DRAGO_MALEFOY);

		slytherinHouse.remove(SALAZAR_SLYTHERIN);

		assertEquals(3, slytherinHouse.getWizardsCount());
//		fail("Uncomment-me");
	}

	@Test
	public void addsPreviouslyRemovedMember() {
		WizardHouse slytherinHouse = new WizardHouse(SALAZAR_SLYTHERIN);
		slytherinHouse.add(MILLICENT_BUBSTRODE);
		slytherinHouse.add(DRAGO_MALEFOY);

		slytherinHouse.remove(DRAGO_MALEFOY);
		slytherinHouse.remove(MILLICENT_BUBSTRODE);
		slytherinHouse.add(DRAGO_MALEFOY);

		assertEquals(2, slytherinHouse.getWizardsCount());
//		fail("Uncomment-me");
	}
	
	@Test
	public void addsPreviouslyRemovedMemberInTheMiddle() {
		WizardHouse slytherinHouse = new WizardHouse(SALAZAR_SLYTHERIN);
		slytherinHouse.add(MILLICENT_BUBSTRODE);
		slytherinHouse.add(DRAGO_MALEFOY);
		slytherinHouse.remove(MILLICENT_BUBSTRODE);
		slytherinHouse.remove(DRAGO_MALEFOY);
		
		slytherinHouse.add(DRAGO_MALEFOY);

		assertEquals(2, slytherinHouse.getWizardsCount());
//		fail("Uncomment-me");
	}
}
