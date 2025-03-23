package equationModulaire;

import euclide.EuclideEtendu;
import euclide.PgcdEuclide;

/**
 * Solveur d'équation modulaire.
 * 
 */
public class EquationModulaire {
    /*
     * Equation du type x + a ≡ b mod n
     */

    /**
     * Détermine la solution de l'équation modulaire du type x + a ≡ b mod n.
     * NB : la valeur renvoyée appartient à l'intervalle [0, n[
     *
     * @param a un entier
     * @param b un entier
     * @param n la valeur du modulo, un naturel supérieur à 2
     * @return la solution de l'équation modulaire du type x + a ≡ b mod n
     */
    public static int solveurAddition(int a, int b, int n) {
    	
    	// TODO : on a zappé, à faire
	    return 0;  // A modifier !!!
    }
    
    /*
     * Equation du type ax ≡ b mod n (avec a > 0 et n >= 2)
     */

    /**
     * Détermine la solution de l'équation modulaire du type ax ≡ b mod n.
     * NB : la valeur renvoyée appartient à l'intervalle [0, n[
     *
     * @param a un coefficient entier strictement positif
     * @param b un entier
     * @param n la valeur du modulo, un naturel supérieur à 2
     * @return la solution de l'équation modulaire du type ax ≡ b mod n
     *         -1 s'il n'y a pas de solution ou si la méthode ne traite pas ce cas
     */
    public static int solveurMultiplication(int a, int b, int n) {
    	
    	// TODO : on a zappé, à faire
	    return 0;  // A modifier !!!
    }
   
}
