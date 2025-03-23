package poo.labo03;

import static poo.labo03.WizardTestData.*;

public class HousesCup {
	WizardHouse gryffindor = new WizardHouse(GODRIC_GRYFFINDOR, new Wizard[] {HARRY_POTTER, HERMIONE_GRANGER});
	WizardHouse slytherin  = new WizardHouse(SALAZAR_SLYTHERIN, new Wizard[] {MILLICENT_BUBSTRODE, DRAGO_MALEFOY});
	WizardHouse hufflepuff = new WizardHouse(HELGA_HUFFLEPUFF,  new Wizard[] {JUSTIN_FINCH_FLETCHEY, SUSAN_BONES, HANNAH_ABBOT});
	WizardHouse ravenclaw = new WizardHouse(ROWENA_RAVENCLAW,  new Wizard[] {TERRY_BOOT, BRANDY_BROCKLEHURST});
	WizardHouse[] houses = new WizardHouse[] {gryffindor, slytherin, hufflepuff, ravenclaw};
	WizardHouseRanking housesRanking;
	
	public HousesCup() {
		// créer le classement
		housesRanking = new WizardHouseRanking(houses);
	}
	
	public String[] getMembersNames() {
		// retourner les noms des sorciers
		return housesRanking.getWizardsNames();
		
	}
	
	public String[][] getRankingTable() {
		// retourner le classement sous forme de table
		String[][] table = new String[houses.length][2];
		for (int i = 0; i < houses.length; i++) {
				table[i][0] = housesRanking.getHouseByRank(i).getName();
				
				String wtf;
				if(housesRanking.getHouseByRank(i).getPoints() >= 10) {
					wtf = " ";
				} else {
					wtf = "  ";
				}
				table[i][1] = wtf + String.valueOf(housesRanking.getHouseByRank(i).getPoints()) + " pts";
		}
		return table;
	}

	public void grantPoints(String name, int points) {
		// modifier le classement selon les points
		housesRanking.grantPoints(name, points);
	}

}
