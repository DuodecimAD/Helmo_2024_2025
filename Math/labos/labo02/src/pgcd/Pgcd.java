package pgcd;

/**
 * Calcul du PGCD de deux nombres naturels
 * 
 * Méthode des soustractions successives
 * 
 */

public class Pgcd {
	/**
	 * Calcul du PGCD - version itérative.
	 * 
	 * @param p premier naturel
	 * @param q deuxième naturel
	 * @return PGCD(p, q)
	 */
	public static int pgcdIteratif(int p, int q) {
		
		if(p < 0 || q < 0 || p == 0 && q == 0) {
			throw new IllegalArgumentException();
		} else if(p == 0) {
			return q;
		} else if (q == 0) {
			return p;
		} else if(p == q) {
			return p;
		}

		
		while (p != q) {
			if (p > q) {
				p = p - q;
			} else {
				q = q - p;
			}
		}
		
        return p;
	}
	
	/**
	 * Calcul du PGCD - version récursive.
	 * 
	 * @param p premier nombre naturel
	 * @param q deuxième nombre naturel
	 * @return PGCD(p, q)
	 */
	public static int pgcdRecursif(int p, int q) {
		
		if(p < 0 || q < 0 || p == 0 && q == 0) {
			throw new IllegalArgumentException();
		} else if(p == 0) {
			return q;
		} else if (q == 0) {
			return p;
		} else if(p == q) {
			return p;
		}
		
		if(p > q) {
			return pgcdRecursif(p - q, q);
		} else {
			return pgcdRecursif(p, q - p);
		}

	}

}
