package serrureModulaire;

import io.Console;


/**
 * La serrure modulaire - un système de serrure mathématique.
 * 
 */
public class SerrureModulaire {
    
    /**
     * Vérifie si un code entré par un utilisateur est correct.
     *
     * @param nombreSecret le nombre secret choisi par l'utilisateur de la serrure
     * @param facteur le facteur aléatoire
     * @param modulo la valeur du modulo
     * @param codeEntree le code fourni par l'utilisateur
     * @return true si le code entré est correct, false sinon.
     */

	public static boolean verifierCode(int nombreSecret, int facteur, int modulo, int codeEntree) {
		
		// DONE verifierCode
		int codeAcces = nombreSecret * facteur % modulo;
		int nbTentatives = 0;
		
    	while(codeEntree != codeAcces && nbTentatives < 5) {
    		nbTentatives++;
    		if(nbTentatives < 5) {
    			System.out.println("Code incorrect. Accès refusé.");
    			System.out.println("Plus que " + (5 - nbTentatives) + " tentatives !");
    			codeEntree = Console.lireInt("Entrez votre code : ");
			}
    		
    		if(codeEntree == codeAcces) {
				return true;
			}
    	}
		return false;  
	}
	

	// Fonction principale illustrant le fonctionnement de la serrure modulaire
    public static void main(String[] args) {
    	
        // Paramètres de la serrure
    	
    	// DONE 1. Demande du nombre secret à l'utilisateur
    	int nombreSecret = Console.lireInt("Entrez le nombre secret : ");
    	
    	// DONE 2. Demande du modulo
    	int modulo = Console.lireInt("Entrez le modulo : ");
    	
    	// DONE 3. Détermination du facteur aléatoire
    	int facteur = (int) ((Math.random() * (100 - 10)) + 10);
    	System.out.println("Le facteur aléatoire est : " + facteur);
    	
		// DONE 4. Calcul du code d'accès
    	int codeAcces = nombreSecret * facteur % modulo;
    	System.out.println("Le code d'accès est : " + codeAcces);
    	
        // DONE Demande du code à l'utilisateur et vérification du code - 5 tentatives maximum
    	int codeEntree = Console.lireInt("Entrez votre code : ");
    	boolean found = verifierCode(nombreSecret, facteur, modulo, codeEntree);
    	
    	if(found) {
    		System.out.println("Code correct. Accès autorisé.");
    	} else {
    		System.out.println("Code incorrect. Accès définitivement refusé.");
    	}

    }	
}
