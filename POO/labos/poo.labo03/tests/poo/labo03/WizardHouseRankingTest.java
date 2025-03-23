package poo.labo03;

import static org.junit.jupiter.api.Assertions.*;
import static poo.labo03.WizardTestData.BRANDY_BROCKLEHURST;
import static poo.labo03.WizardTestData.DRAGO_MALEFOY;
import static poo.labo03.WizardTestData.GODRIC_GRYFFINDOR;
import static poo.labo03.WizardTestData.HARRY_POTTER;
import static poo.labo03.WizardTestData.HELGA_HUFFLEPUFF;
import static poo.labo03.WizardTestData.HERMIONE_GRANGER;
import static poo.labo03.WizardTestData.MILLICENT_BUBSTRODE;
import static poo.labo03.WizardTestData.SALAZAR_SLYTHERIN;
import static poo.labo03.WizardTestData.TERRY_BOOT;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class WizardHouseRankingTest {

	@Test
	void getWizardNamesFromRanking() {
		
		WizardHouse gryffindor = new WizardHouse(GODRIC_GRYFFINDOR, new Wizard[] {HARRY_POTTER, HERMIONE_GRANGER});
		WizardHouse slytherin  = new WizardHouse(SALAZAR_SLYTHERIN, new Wizard[] {DRAGO_MALEFOY, MILLICENT_BUBSTRODE});
		WizardHouse hufflepuff = new WizardHouse(HELGA_HUFFLEPUFF,  new Wizard[] {TERRY_BOOT, BRANDY_BROCKLEHURST});
		
		WizardHouse[] houses = new WizardHouse[] {gryffindor, slytherin, hufflepuff};
		
		WizardHouseRanking ranks = new WizardHouseRanking(houses);
		
		String[] names = new String[] {
				GODRIC_GRYFFINDOR.getName(),
				HARRY_POTTER.getName(),
				HERMIONE_GRANGER.getName(),
				SALAZAR_SLYTHERIN.getName(),
				DRAGO_MALEFOY.getName(),
				MILLICENT_BUBSTRODE.getName(),
				HELGA_HUFFLEPUFF.getName(),
				TERRY_BOOT.getName(),
				BRANDY_BROCKLEHURST.getName()
		};
		Arrays.sort(names);
		assertArrayEquals(names, ranks.getWizardsNames());
	}
	
	@Test
	void getHouseRank() {
		
		WizardHouse gryffindor = new WizardHouse(GODRIC_GRYFFINDOR, new Wizard[] {HARRY_POTTER, HERMIONE_GRANGER});
		WizardHouse slytherin  = new WizardHouse(SALAZAR_SLYTHERIN, new Wizard[] {DRAGO_MALEFOY, MILLICENT_BUBSTRODE});
		WizardHouse hufflepuff = new WizardHouse(HELGA_HUFFLEPUFF,  new Wizard[] {TERRY_BOOT, BRANDY_BROCKLEHURST});
		
		WizardHouse[] houses = new WizardHouse[] {gryffindor, slytherin, hufflepuff};
		
		WizardHouseRanking ranks = new WizardHouseRanking(houses);
		System.out.println("init : " + ranks);
		
		ranks.grantPoints(HARRY_POTTER.getName(), 10);
		ranks.grantPoints(HERMIONE_GRANGER.getName(), 10);
		ranks.grantPoints(DRAGO_MALEFOY.getName(), 10);
		System.out.println(ranks);
		assertEquals(gryffindor, ranks.getHouseByRank(0));
		
		ranks.grantPoints(DRAGO_MALEFOY.getName(), 30);
		System.out.println(ranks);
		assertEquals(slytherin, ranks.getHouseByRank(0));
	}

}
