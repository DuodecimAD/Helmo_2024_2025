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
    	
	    return valeurs.strip();
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
    	int max = (int) Math.pow(10, nbChiffres); // max / 10
    	
    	do {
			calcul = (int) ((Math.random() * (max - min)) + min);
			// Random rand = new Random();
			// min + rand.nextInt(max-min)
		} while (calcul % modulo != nombre);
    	
    	/*
    	 * solution optimisée :
    	 * 
    	 * on calcule min et max et on check combien de fois de chiffreavec lememe modulo sont présent 
    	 * puis on fait un math random sur cenombre qu'on multiplie par le modulo
    	 * 
    	 */
    	
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
		System.out.println(dechiffrer("60901 12062 60737 75827 24512 16745 58449 28761 13402 26212 92449 44506 40699 "
				+ "87154 44552 82700 90091 12117 50306 17224 32177 83654 84070 72053 60821 20486 "
				+ "69432 40605 35438 67078 31809 35485 27062 67950 18509 51387 97713 37133 43349 "
				+ "36196 83584 67989 91719 25530 26993 92799 94493 51861 46583 39708 68577 68240 "
				+ "46837 15918 45869 45939 45516 61559 38213 92530 78149 62010 37062 81765 44288 "
				+ "32905 66294 63740 24085 87099 89146 69077 82299 52857 32849 91411 97249 20516 "
				+ "63284 10169 33846 32229 58247 98861 68073 73547 84522 82139 57823 80508 55809 "
				+ "80966 19619 48485 37933 32653 91824 38925 90515 51925 40657 12646 65497 71433 "
				+ "38015 78628 83557 65424 67761 69851 39527 63817 56378 50812 84593 19116 23929 "
				+ "80157 86837 57723 31178 33032 47881 29074 40293 19277 73697 29997 70327 91180 "
				+ "43629 40827 61419 89745 37009 55766 96993 88801 29737 36334 59169 51721 18706 "
				+ "44101 94295 90543 86469 66221 98414 50825 46035 16109 21042 85042 25293 43666 "
				+ "98121 73289 78433 45514 52044 99488 82101 67286 10462 12425 86617 27193 18303 "
				+ "83385 18418 77257 65590 79305 68982 61153 15982 32905 98647 45736 74485 63666 "
				+ "53709 89082 24688 63228 96437 67072 69445 38491 57224 76501 77591 28267 84133 "
				+ "55208 80085 59722 92972 85657 39388 44273 22386 21793 92334 67128 46205 56212 "
				+ "22384 75629 28664 71640 83525 12905 11107 43865 93149 50549 31505 42523 56020 "
				+ "72420 13669 13033 56457 47381 16198", 28, 5));

	}
}
