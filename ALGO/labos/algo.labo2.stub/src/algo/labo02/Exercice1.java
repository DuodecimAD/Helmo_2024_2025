package algo.labo02;

import java.util.Objects;

import contracts.Contracts;
import io.Console;

public class Exercice1 {

	private static final String MENU = """
			== Exercice 1 ==
			1 – Fonction 1
			2 – Fonction 2
			3 – Fonction 3
			* – Quitter
			> """;

	private static final String AU_REVOIR = "Au revoir.";
	private static final String INPUT_1 = "Choisissez un nombre positif ? ";
	private static final String INPUT_2 = "Entrez une chaine de caractères : ";
	private static final String INPUT_3 = "Choisissez un nombre positif ? ";

	public static void main(String[] args) {

		switch(Console.lireInt(MENU)) {
		case 1 -> {
			System.out.println(fonction1(Console.lireInt(INPUT_1)));
		}
		case 2 -> {
			System.out.println(fonction2(Console.lireString(INPUT_2)));
		}
		case 3 -> {
			System.out.println(fonction3(Console.lireInt(INPUT_3), 2));
		}
		default -> {
			auRevoir();
		}
		}
	}

	private static void auRevoir() {
		System.out.println(AU_REVOIR);
	}

	/**
	 * @param x
	 * @return true si x ... est premier
	 */
	public static boolean fonction1(int x) {
		Contracts.requires(x >= 0, "x doit être positif");

		if (x <= 1 || x % 2 == 0) { 			// 4 op
			return x == 2;						// pas besoin car 1x
		}

		for(int i = 3;  i * i <= x; i += 2) { 	// INIT + END + (nb_tours * (corps + guardien))
												//  2   +  1  + (racine²x *	(3     +    4))
			
			if (x % i == 0)						// pas besoin
				return false;					
		}

		return true;							// 1 op
	}
	
	// CTT = O (racine²n)
	// CST = 
	

	/**
	 * Si vous lisez cette description, c'est très bien. Voici un indice : le code 
	 * est particulièrement mal indenté (c'est d'ailleurs pour cela que c'est un point
	 * d'attention en PrB ;-) 
	 *
	 * @param entree une chaine de caractcarac.
	 * @return vrai si entree ... est un palindrome
	 */
	public static boolean fonction2(String entree) {
		Objects.requireNonNull(entree);

		int j = 0;																	// 1 op
		int len = entree.length();													// 1 op

		while(j < len / 2 && entree.charAt(j) == entree.charAt(len - 1 - j)) ++j;	// franchit la moitié ou chiffre !=
																					// on s'en tape 1 ou 9 ops
			return j == len / 2; // 3 ops
			
	}
	
	// CST = O(entree.length)   
	// CTT = O(entree.length) -> 6 + 9 + (len/2  * 10) = 15 + 5 = lineaire
	
	
	/**
	 * @param x
	 * @return le [...] de x (la sommedes chiffre en base b du nombre)
	 */
	public static int fonction3(final int x, final int b) {
		Contracts.requires(x >= 0 && b > 1, "x doit être positif et b > 1");

		int compteur = 0;					// 1 op
		int nombre = x;						// 1 op
		
		while (nombre > 0) {				// log x (en base b) 
			compteur += nombre % b;
			nombre /= b;
		}

		return compteur;	// retourne la somme de chaque chiffre du nombre en base b 
	}
	
	// CTT = O(log(x))

}
