package suite;

/**
 * Calcul et affichage des n premiers termes d'une suite définie par récurrence :
 * 
 * 	u(1) = 3  et  u(n + 1) = 2*u(n) + 4  (n > 0)
 * 
 */

public class TermesSuite {
    
    /**
     * Calcule et affiche les n premiers termes de la suite décrite ci-dessus.
     * Renvoie le terme d'indice n.
     * Version itérative.
     *
     * @param n Indice du dernier terme à calculer et à afficher
     * @return  le dernier terme, u(n)
     */
    public static long termesSuiteIteratif(int n) {
    	
    	// DONE
    	if(n <= 0 ) {
    		throw new IllegalArgumentException("erreur");
    	} 
    	long somme = 3;
    	for (int i = 2; i <= n; i++) {
			somme = 2 * somme + 4;
		}
    	System.out.println(somme);
        return somme;
    }

    /**
     * Calcule et affiche les n premiers termes de la suite décrite ci-dessus.
     * Renvoie le terme d'indice n.
     * Version récursive.
     *
     * @param n Indice du dernier terme à calculer et à afficher
     * @return le dernier terme , u(n)
     */
    public static long termesSuiteRecursif(int n) {
    	    	
    	// DONE
    	if(n <= 0 ) {
    		throw new IllegalArgumentException("erreur");
    	} else if (n == 1) {
    		return 3;
    	}
    	
        return termesSuiteRecursif(n-1) * 2 + 4;
    }    
   
}
