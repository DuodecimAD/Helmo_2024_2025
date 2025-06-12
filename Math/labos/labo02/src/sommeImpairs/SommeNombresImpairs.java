package sommeImpairs;

/**
 *  Somme des n premiers entiers impairs positifs :  1 + 3 + 5 + ... + (2 * n-1)
 *
 */
public class SommeNombresImpairs {

	/**
	 * Somme des n premiers entiers impairs positifs.
	 * Solution explicite.
	 * 
	 * @param n Un entier strictement positif
	 * @return la somme demandée
	 */
	public static int sommeNombresImpairs(int n) {
		// Validation du paramètre volontairement omise		
		// Calcul de la somme
		return n * n;
	}
	
	/**
	 * Somme des n premiers entiers impairs positifs.
	 * Solution itérative.
	 * 
	 * @param n Un entier strictement positif
	 * @return la somme demandée
	 */
	public static int sommeNombresImpairsIteratif(int n) {
		
		if(n <= 0) {
			throw new IllegalArgumentException("erreur");
		}
		
		int somme = 0;
		
		for (int i = 1; i <= n; i++) {
			somme += (i*2)-1;
		}
		
		return somme;
	}
	
	/**
	 * Somme des n premiers nombres impairs positifs.
	 * Solution récursive.
	 * 
	 * @param n Un entier strictement positif
	 * @return la somme demandée
	 */
	public static int sommeNombresImpairsRecursif(int n) {

		if(n <= 0) {
			throw new IllegalArgumentException("erreur");
		} else if(n == 1) {
			return 1;
		}
		return sommeNombresImpairsRecursif(n-1) + (2 * n -  1);
	}
	
}
