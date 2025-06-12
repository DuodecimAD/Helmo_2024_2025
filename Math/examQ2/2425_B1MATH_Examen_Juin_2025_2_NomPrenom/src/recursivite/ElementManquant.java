package recursivite;

import java.util.Arrays;

/**
 * 
 */
public class ElementManquant {
    /*
     * Tableau 1D
     */
	
    /**
     * Recherche le plus petit entier manquant dans un tableau 1D 
     * (tableau d'entiers positifs, trié, sans répétition).
     * Version itérative.
     *
     * @param tab Tableau à 1 dimension
     * @return le plus petit entier manquant dans le tableau, -1 s'il n'y a pas d'élément manquant
     */
    public static int elementManquantIteratif(int[] tab) {
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] > i) return i;
        }
        return -1;
    }
    
    /**
     * Recherche le plus petit entier manquant dans un tableau 1D 
     * (tableau d'entiers positifs, trié, sans répétition).
     * Version récursive avec 1 paramètre supplémentaire.
     * 
     * @param tab Tableau à 1 dimension 
     * @return le plus petit entier manquant dans le tableau, -1 s'il n'y a pas d'élément manquant
     */
    public static int elementManquantRecursif(int[] tab) {
    	
    	// TODO HALF DONE
    	if(tab.length == 1) { // si array est de taille 1, pas trouvé
    		return -1;
    	} else if(tab[1]-tab[0] > 1) { // si différence trop grande on garde la première valeur
    		return tab[0]+1;
    	} else if(tab[0] != 0) { // si array commence pas par 0, return 0, comme on peut pas changer
    		return 0;            // la signature, je ne vois pas comment garder en mémoire sa position
    	}
    	// on copie le tableau avec 1er element en moins
    	int[] newArray = Arrays.copyOfRange(tab, 1, tab.length);
    	return elementManquantRecursif(newArray);
    }
    private static int elementManquantRecursif(int[] tab, int colonne) {
    	
    	// TODO
    	return 0; // <- à modifier !!!
    }
    
    /*
     * Tableau 2D
     */

    /**
     * Recherche le plus petit nombre manquant dans un tableau 2D 
     * (tableau d'entiers positifs, trié, sans répétition).
     * Version itérative.
     * 
     * @param tab Tableau à 2 dimensions
     * @return le plus petit nombre manquant dans le tableau, -1 s'il n'y a pas d'élément manquant
     */
	public static int elementManquantIteratif(int[][] tab) {
		
		int n = tab.length;
		int m = tab[0].length;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (tab[i][j] > i * m + j) return i * m + j;
			}
		}
		return -1;
	}

    /**
     * Recherche le plus petit nombre manquant dans un tableau 2D 
     * (tableau d'entiers positifs, trié, sans répétition).
     * Version récursive avec 2 paramètres supplémentaires.
     * 
     * @param tab Tableau à 2 dimensions
     * @return le plus petit nombre manquant dans le tableau, -1 s'il n'y a pas d'élément manquant
     */
	public static int elementManquantRecursif(int[][] tab) {
		
		// TODO
    	return 0; // <- à modifier !!!
	}

	private static int elementManquantRecursif(int[][] tab, int ligne, int colonne) {
		
		// TODO
    	return 0; // <- à modifier !!!
	}
}
