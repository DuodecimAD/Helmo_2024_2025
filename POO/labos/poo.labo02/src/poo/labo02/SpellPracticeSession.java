package poo.labo02;

import java.util.Arrays;

public class SpellPracticeSession {
	
	private Wizard[] camarades = {
									new Wizard("Albus Dumbledore", Level.HEADMASTER),
									new Wizard("Severus Rogue", Level.PROFESSOR),
									new Wizard("Harry Potter", Level.GRADUATED),
									new Wizard("Hermione Granger", Level.GRADUATED),
									new Wizard("Ronald Weasley", Level.STUDENT),
									new Wizard("", Level.HEADMASTER)
								 };
	
	private Spell[] sorts = {
								new Spell("Stupefy"),
								new Spell("Expecto patronum"),
								new Spell("Wingardium leviosa"),
								new Spell("Mucus ad nuseum"),
								new Spell("Silencio"),
							  };
	
	
	public String[] getWizardNames() {
		String[] camaradesNoms = new String[camarades.length];
		
		for (int i = 0; i < camarades.length; i++) {
			camaradesNoms[i] = camarades[i].getName();
		}
		return camaradesNoms;
	}
	
	public String[] getSpellNames() {
		String[] sortsNoms = new String[sorts.length];
		
		for (int i = 0; i < sorts.length; i++) {
			sortsNoms[i] = sorts[i].getIncantation();
		}
		return sortsNoms;
	}
	
	public String[] practice(int wizardIndex, int spellIndex) {
		
		String result = camarades[wizardIndex].cast(sorts[spellIndex]);
		
		if(camarades[wizardIndex].hasBeenPromoted()) {
			return hasLeveledUpToHeadmaster(wizardIndex, spellIndex, result);
		} else {
			return new String[]{result};
		}

	}
	
	public String[] hasLeveledUpToHeadmaster(int wizardIndex, int spellIndex, String result) {
		String wizardName = camarades[wizardIndex].getName();
		String levelName = camarades[wizardIndex].getLevel().getName();
		
		
		if(camarades[wizardIndex].getLevel().equals(Level.HEADMASTER)) {
			
			Wizard[] newArray = new Wizard[camarades.length-1];
			int counter = 0;
			for (int i = 0; i < newArray.length; i++) {
				if(i == wizardIndex) {
					counter++;
				}
				newArray[i] = camarades[counter];
				counter++;
			}
			
			camarades = newArray;
			
		}
		return new String[]{result, "Level up : " + wizardName + " became " + levelName};
	}
}
