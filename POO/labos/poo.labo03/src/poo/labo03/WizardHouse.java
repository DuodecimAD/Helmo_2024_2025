package poo.labo03;

import java.util.Arrays;
import java.util.Objects;

public class WizardHouse implements Comparable<WizardHouse>{
	
	private final Wizard founder;
	private Wizard[] membres = new Wizard[1];
	private int counter = 1;
	private int points = 0;
	private final static int GROWTH_FACTOR = 2;
	private final static int FOUNDER = 0;

	public WizardHouse(Wizard wizard) {
		this(wizard, new Wizard[]{});
	}
	
	public WizardHouse(Wizard wizard, Wizard...members) {
		this.founder = Objects.requireNonNullElse(wizard, Wizard.YOU_KNOW_WHO);
		membres = new Wizard[members.length+1];
		membres[FOUNDER] = this.founder;

		int exist = 1;
		for (int i = 0; i < members.length; i++) {
			if(members[i] != null) {
				membres[exist] = members[i];
				exist++;
				counter++;
			}
		}
		
	}
	
	public String getName() {
		return founder.equals(Wizard.YOU_KNOW_WHO)  ? "Death Eaters" : this.founder.getLastName();
	}

	@Override
	public String toString() {
		return "WizardHouse(name: " + this.getName() + ", founder: " + this.founder.getName() + ")";
	}
	
	public void add(Wizard w) {
		
		if(w != null && !Arrays.asList(membres).contains(w)) {
			if(counter == membres.length) {
				membres = Arrays.copyOf(membres, membres.length * GROWTH_FACTOR);
			}
			
			membres[counter] = w;
			counter++;
		}
	}
	
	public int getWizardsCount() {	
		return counter;
	}
	
	public void remove(Wizard w) {
		if(w != null && !membres[FOUNDER].equals(w)) {
			if(Arrays.asList(membres).contains(w)) {
			
				int index = Arrays.asList(membres).indexOf(w);

				membres[index] = membres[counter-1];
				membres[counter-1] = null;
				counter--;

			}
		}
	}
	
	public String[] getWizardsNames() {
		
		String[] membresNames = new String[counter];
		for (int i = 0; i < counter; i++) {
			membresNames[i] = membres[i].getName();
		}
		
		return membresNames;
	}
	
	public void grantPoints(String wizardName, int newPoints) {
		
		for (Wizard wizard : membres) {
			if(wizardName != null && wizardName.equals(wizard.getName())) {
				this.setPoints(this.getPoints()+newPoints);
				return;
			}
		}
		
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getPoints() {
		return points;
	}
	
	@Override
	public int compareTo(WizardHouse other) {

		int result = this.getPoints() - other.getPoints();
		if(result == 0) {
			result = this.getName().compareTo(other.getName());
		}
		return result;
	}
	
	
}
