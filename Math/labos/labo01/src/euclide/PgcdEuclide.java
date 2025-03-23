package euclide;

/**
 * L'algorithme d'Euclide permet de calculer le PGCD de deux entiers naturels a
 * et b.
 * 
 */

public class PgcdEuclide {
	/**
	 * Calcul du PGCD de manière itérative en suivant l'algorithme d'Euclide
	 * standard (par division euclidienne). Cet algorithme est applicable dans le
	 * cas de deux nombres entiers positifs a et b.
	 * 
	 * @param a premier nombre naturel
	 * @param b deuxième nombre naturel
	 * @return PGCD(a, b)
	 */
	public static int pgcdEuclide(int a, int b) {
		int r;
		if (a < 0 || b < 0) {
			throw new IllegalArgumentException("erreur : a ou b n'est pas un chiffre naturel");
		} else if (b == 0) {
			return a;
		} else {
			r = a % b;
		}

		return pgcdEuclide(b, r);
	}

}
