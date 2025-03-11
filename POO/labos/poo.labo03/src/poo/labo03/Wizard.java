package poo.labo03;

/**
 * Un sorcier est une personne possédant un nom.
 * 
 * Cette définition est une version simplifiée du labo 02.
 * 
 * @author Nicolas Hendrikx
 * */
public class Wizard {
	/**
	 * Nom du sorcier utilisé par défaut.
	 * */
	public static final String YOU_KNOW_WHO_NAME = "Lord Voldemort";

	/**
	 * Un sorcier maléfique faisant office de valeurs par défaut.
	 * 
	 * */
	public static final Wizard YOU_KNOW_WHO = new Wizard(YOU_KNOW_WHO_NAME);
	
	private final String fullname;
	
	/**
	 * Construit un sorcier dont le nom complet est {@code givenName}.
	 * 
	 * Si le nom donné est {@code null} ou blanc, 
	 * la constante {@code YOU_KNOW_WHO_NAME} est utilisée.
	 * 
	 * @param givenName le nom complet, éventuellement {@code null} ou blanc.
	 * @see poo.labo03.Wizard.YOU_KNOW_WHO_NAME
	 * */
	public Wizard(String givenName) {
		fullname = checkName(givenName);
	}

	private String checkName(String givenName) {
		return givenName == null || givenName.isBlank() ? YOU_KNOW_WHO_NAME : givenName;
	}

	/**
	 * Retourne le nom complet de ce sorcier.
	 * */
	public String getName() {
		return fullname;
	}
	
	public String getLastName() {
		String[] lastname = fullname.split(" ");
		return lastname[lastname.length-1];
	}
	
	/**
	 * Compare le nom de ce sorcier avec {@code wizardName}.
	 * 
	 * La comparaison est sensible à la casse et aux espacements.
	 * 
	 * @param wizardName le nom à comparer à celui de ce sorcier.
	 * @return {@code true} si {@code wizardName} est équivalent au nom de ce sorcier et {@code false} dans les autres cas.
	 * */
	public boolean hasName(String wizardName) {
		if(wizardName == null) {
			return false;
		}
		
		if(this.fullname == wizardName) {
			return true;
		}
		
		return fullname.equals(wizardName);
	}
	
	@Override
	public boolean equals(Object other) {
		if(this == other) {
			return true;
		}
		
		if(!(other instanceof Wizard)) {
			return false;
		}
		
		Wizard that = (Wizard)other;
		return this.hasName(that.getName());
	}
	
	public String toString() {
		return String.format("Wizard(name: %s)", fullname);
	}
}
