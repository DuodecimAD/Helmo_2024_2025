package poo.labo03;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class WizardHouseRanking {
	
	private WizardHouse[] houses;

	public WizardHouseRanking(WizardHouse...houses) {
		if(houses == null) {
			this.houses = new WizardHouse[]{};
		} else {
			this.houses = houses;
			Arrays.sort(this.houses, Collections.reverseOrder());
		}

	}
	
	public String[] getWizardsNames() {
		
		String[] names = new String[0];

		for (int i = 0; i < houses.length; i++) {
			
			String[] namesInAHouse = houses[i].getWizardsNames();

			int count = names.length;
			names = Arrays.copyOf(names, names.length + namesInAHouse.length);
			
			for (int j = 0; j < namesInAHouse.length; j++) {

				names[count++] = namesInAHouse[j];
			}
			
		}
		Arrays.sort(names);
		return names;
	}
	
	public WizardHouse getHouseByRank(int rank){
		Objects.checkIndex(rank, houses.length);
		return houses[rank];
	}
	
	public int getHousesCount() {
		return houses.length;
	}
	
	public void grantPoints(String wizardName, int newPoints) {
		for (int i = 0; i < houses.length; i++) {
			houses[i].grantPoints(wizardName, newPoints);
		}
		Arrays.sort(houses, Collections.reverseOrder());
	}

	@Override
	public String toString() {
		return Arrays.deepToString(houses);
	}
	

}
