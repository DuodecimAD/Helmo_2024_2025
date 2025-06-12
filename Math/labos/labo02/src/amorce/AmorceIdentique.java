package amorce;

/**
 * Détermine si une chaîne de caractères commence par une amorce donnée.
 */

public class AmorceIdentique {
	/**
     * Retourne true si la chaîne donnée commence par l'amorce donnée, 
     * false dans le cas contraire.
     * Version itérative.
     *
     * @param chaine La chaîne pour laquelle on souhaite savoir si elle commence par l'amorce donnée 
     * @param amorce L'amorce testée
     * @return true si la chaîne donnée commence par l'amorce donnée, false sinon.
     */
    public static boolean amorceIdentiqueIteratif(String chaine, String amorce) {
    	
    	if(chaine == null || amorce == null) {
    		throw new IllegalArgumentException();
    	} else if(chaine.length() < amorce.length()) {
    		return false;
    	} else if(amorce.length() == 0) {
    		return true;
    	}
    	
    	for (int i = 0; i < amorce.length(); i++) {
			if(chaine.toLowerCase().charAt(i) != amorce.toLowerCase().charAt(i)) {
				return false;
			}
		}
    	
    	return true;
    }

    /**
     * Retourne true si la chaîne donnée commence par l'amorce donnée, 
     * false dans le cas contraire.
     * Version récursive.
     *
     * @param chaine La chaîne pour laquelle on souhaite savoir si elle commence par l'amorce donnée 
     * @param amorce L'amorce testée 
     * @return true si la chaîne donnée commence par l'amorce donnée, false sinon.
     */
    public static boolean amorceIdentiqueRecursif(String chaine, String amorce) {
    	
    	if(chaine == null || amorce == null) {
    		throw new IllegalArgumentException();
    	} else if(chaine.length() < amorce.length()) {
    		return false;
    	} else if(amorce.length() == 0) {
    		return true;
    	} else if (chaine.toLowerCase().charAt(0) != amorce.toLowerCase().charAt(0)) {
    		return false;
    	}
    	System.out.println(amorce);
		return amorceIdentiqueRecursif(chaine.substring(1), amorce.substring(1));
    }
 
}
