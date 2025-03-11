package chiffrementModulo;

import java.util.Arrays;
import java.util.Random;

/**
 * Chiffrement/déchiffrement par Modulo.
 * 
 */
public class ChiffrementModulo {
    
    /**
     * Chiffre un texte donné sous la forme d'une chaîne de nombres.
     * Les caractères sont convertis en nombre en appliquant la règle 
     * A = 1, B = 2, C = 3, ..., Z = 26.
     * NB : une espace séparera les nombres.
     *
     * @param texte le texte à chiffrer
     * @param modulo la valeur du modulo
     * @param nbChiffres le nombre de chiffres souhaités dans chaque nombre (min 3)
     * @return le message codé sous la forme d'une chaîne de nombres 
     *         comprenant chacun nbChiffres chiffres.
     */
    public static String chiffrer(String texte, int modulo, int nbChiffres) {
    	
    	if (texte.isBlank() || texte == null || modulo < 1 || nbChiffres > 3) {
			throw new IllegalArgumentException("erreur");
		}
    	
    	String string = texte.toUpperCase();
    	String valeurs = "";

    	for (int i = 0; i < texte.length(); i++) {
    		int valeurChar = (string.charAt(i)-64);
    		
			valeurs +=  nombreCongru(valeurChar, modulo, nbChiffres);
			
			if(i < texte.length()-1) {
				valeurs += " ";
			}
		}
    	
	    return valeurs;
    }
    
    /**
     * Génère un nombre aléatoire de nbChiffres chiffres congru au nombre donné modulo n.
     *
     * @param nombre le nombre à remplacer
     * @param modulo la valeur du modulo
     * @param nbChiffres le nombre de chiffres souhaité dans chaque nombre
     * @return le nombre de nbChiffres chiffres congru au nombre donné modulo n.
     */
    public static int nombreCongru(int nombre, int modulo, int nbChiffres) {
    	int calcul = nombre;
    	
    	int min = (int) Math.pow(10, nbChiffres-1);
    	int max = (int) Math.pow(10, nbChiffres);
    	
    	do {
			calcul = (int) ((Math.random() * (max - min)) + min);
		} while (calcul % modulo != nombre);
    	
	    return calcul;
    }        

    /**
     * Déchiffre un message donné sous la forme d'une chaîne de nombres.
     * Les caractères sont convertis en nombre en appliquant la règle 
     * A = 1, B = 2, C = 3, ..., Z = 26.
     * NB : le texte renoyé sera en majuscules.
     *
     * @param message le message à déchiffrer
     * @param modulo la valeur du modulo
     * @param nbChiffres le nombre de chiffres composant chaque nombre
     * @return le message décodé sous la forme d'une chaîne de caractères.
     */
    public static String dechiffrer(String texte, int modulo, int nbChiffres) {
    	   	
    	String[] strings = texte.split(" ");
    	String valeurs = "";

    	for (int i = 0; i < strings.length; i++) {
    		
    		int result = Integer.parseInt(strings[i]) % modulo;
    		int valeurChar = result+64;
    		
			valeurs += (char) valeurChar;
		}
    	
	    return valeurs;
    }
    
    
    	
	/*
	 * Exemples d'utilisation.
	 */
	public static void main(String[] args) {
		
		// Chiffrement
		System.out.println("1. Math ->  " + chiffrer("MATH", 26, 3)); 
//		System.out.println("2. Math ->  " + chiffrer("MATH", 26, 5));		
		System.out.println();
		
		// Déchiffrement
		System.out.println("143 573 592 372 ->  " + dechiffrer("143 573 592 372", 26, 3));
		System.out.println("33761 36375 26410 5000 ->  " + dechiffrer("33761 36375 26410 50006", 26, 5));
		System.out.println("6620 5225 7114 1837 7985 4382 4568 2551 4753 5798 5787 2339 7662 3488 7417 9789 8141 4658 7025 8616 5091 7708 8440 1530 8672 1877 3676 4795 3970 4528 9543 6485 3286 6213 8216 3147 2989 6107 9874 4173 5846 5662 5290 8999 4159 2864 3168 5528 4584 2543 \n -> " + dechiffrer("6620 5225 7114 1837 7985 4382 4568 2551 4753 5798 5787 2339 7662 3488 7417 9789 8141 4658 7025 8616 5091 7708 8440 1530 8672 1877 3676 4795 3970 4528 9543 6485 3286 6213 8216 3147 2989 6107 9874 4173 5846 5662 5290 8999 4159 2864 3168 5528 4584 2543", 27, 4));
		// Citation de John von Neumann - Mathématicien, Physicien, Scientifique (1903 - 1957)

	}
}
