package algo.labo02;

import poo.labo02.Wizard;

public class Tris {

	public static final int BYTES_NBR = 256;
	public static final int OFFSET = 128;
	
	/* ____________________ EXERCICE 2 _______________________ */
	
	/**
	 * Détermine l'emplacement que devrait avoir valeur pour qu'une fois inséré
	 * dans tableau[0 .. longueur-1], tableau[0 .. longueur] reste trié.
	 * @param tableau Un tableau dont les éléments entre les positions 0 et
	 * 		longueur - 1 sont triés.
	 * @param longueur la taille du préfixe du tableau (= les éléments au début)
	 * @param valeur la valeur dont il faut déterminer la postion
	 * @return la position que devrait avoir valeur si on l'insérait dans le tableau
	 * pour le maintenir trié.
	 */
	private static int positionInsersion(final int[] tableau, final int longueur, final int valeur) {
		int depart = 0;
		int fin = longueur;
		int m;

		while(depart < fin) {
			m = depart + (fin - depart) / 2; // TODO: Pourquoi pas (fin + depart) / 2 ? pour éviter overflow tableau quand nb trop grand et devienne -
			if (tableau[m] > valeur) {
				fin = m;
			} else {
				depart = m + 1; // TODO: Pourquoi pas depart = m ? m est exclu
			}
		}
		return depart;
	}
	
	// CTT O(log longueur) => à chaque iteration on divisive par 2 de manière iterative  TZ/2^i = 1 => log2 (TZ) = i
	

	
	/**
	 * Trie le tableau
	 * 
	 * Postcondition : Tous les éléments situés à des positions consécutives dans 
	 * 				aTrier sont tels que 
	 *    					aTrier[x]<=aTrier[x+1]
	 *    			ET aTrier est une permutation du tableau initial
	 *    					(= on n'a pas ajouté ou enlevé d'éléménts).
	 *    
	 * @implNote Utilise insertion sort
	 * @param tableau un tableau d'entiers.
	 */
	public static void insertionSort(int[] tableau) {
		for(int i = 1 /* INIT */; i < tableau.length/* GUARDIEN */; ++i) { // TODO: pourquoi i = 1 ?  car element 0 est seul et déjà trié 
			// INIT : 1 op O(1), GUARDIEN : 1 op O(tableau.length)
			int tmp = tableau[i]; // 2 op, O(1)
			int pos = positionInsersion(tableau, i, tmp);														 // O(log n)
			System.arraycopy(tableau, pos, tableau, pos + 1, i - pos); // TODO: justifier la valeur des paramètres (i - pos) le nbr d'element à bouger
						// i op => O(length) = O(i-pos) => pire des cas i - pos = i=> tri oredre décroissant 54321
			tableau[pos] = tmp;																					 // O(1)
		}/* FIN 0 op*/
		// boucle INIT + FIN + GUARDIEN_false + nb_tours         *  (Corps + Guardien_true)
		//			1  +  0	 +   1			  + tableau.length-1 *  (4 + log(i) + i + 1)
		// quadratique O(aleau.length²)
	}
	
	private static int positionInsersion(final Wizard[] tableau, final int longueur, final Wizard valeur) {

//		for (int i = 0; i < longueur; i++) {
//			if(tableau[i].compareTo(valeur) >= 0) {
//				return i;
//			}
//		}
//		return longueur; // FIXME C'est faux !
		
		
		int depart = 0;
		int fin = longueur;
		int m;

		while(depart < fin) {
			m = depart + (fin - depart) / 2;
		
			if(valeur.compareTo(tableau[m]) < 0) {
				fin = m;
			} else {
				depart = m + 1;
			}
		}
		return depart;	
		
	}
	
	public static void insertionSort(Wizard[] tableau) {
		
		for(int i = 1; i < tableau.length; ++i) { 
			Wizard tmp = tableau[i];
			int pos = positionInsersion(tableau, i, tmp);
			System.arraycopy(tableau, pos, tableau, pos + 1, i - pos);
			tableau[pos] = tmp;
		}
	}
	
	/* ____________________ EXERCICE 3 _______________________ */
	
	/**
	 * Postcondition : Tous les éléments situés à des positions consécutives dans aTrier sont tels que 
	 *    aTrier[x]<=aTrier[x+1]
	 *    ET aTrier est une permutation du tableau initial (= on n'a pas ajouté ou enlevé d'éléménts).   
	 * 
	 * @param aTrier Un tableau de bytes
	 */
	public static void trierBytes(final byte[] aTrier) {
		repartirValeurs(compter(aTrier), aTrier);
	}
	
	/**
	 * À programmer par vos soins
	 * 
	 * Postcondition : destination est trié par un ordre croissant.
	 * ET dans destination, pour chaque position p dans comptage, la valeur (p - OFFSET) apparait un nombre
	 * comptage[p] de fois.
	 * 
	 * @param comptage le comptage tel que renvoyé par la fonction compter.
	 * @param destination un tableau dont la taille est égale à la somme des éléments de comptage.
	 */
	private static void repartirValeurs(final int[] comptage, final byte[] destination) {
		
		// FIXME : Exercice 3
		
		int k = 0;
		for (int i = 0; i < comptage.length; i++) {
			for (int j = 0; j < comptage[i]; j++) {
				destination[k++] = (byte) (i - OFFSET);
			}
		}
		
	}


	/**
	 * Compte les occurrences de aCompter dans le tableau passé en résultat.
	 * 
	 * /!\ à l'ordre de classement des valeurs dans le tableau :
	 * Dans le tableau renvoyés le nombres d'occurence des valeurs rencontrées dans aCompter
	 * sont rangées ainsi :
	 * 
	 * indice | valeur de aCompter
	 * –––––––––––––––––––––––––––
	 *    0   | -128
	 *    1   | -127
	 *       ...
	 *   128  |   0
	 *   129  |   1
	 *   130  |   2
	 *       ...
	 *   255  |  127
	 *    
	 * Pour rappel les bytes utilisent une représentation par complément à 2 (voir cours d'Archi),
	 * c'est donc normal qu'ils varient entre -128 et +127.
	 * 
	 * Dit plus formellement, si on appelle « compter » le tableau renvoyé par la fonction,
	 * 
	 * Postcondition : compter[b - OFFSET] contient le nombre d'occurences de b dans aCompter, -128<=b<=127 
	 *
	 * @param aCompter un tableau de bytes dont il faut compter les éléments
	 * @return le résultat du comptage
	 */
	private static int[] compter(final byte[] aCompter) {

		int[] table = new int[BYTES_NBR];
		
		for(byte b : aCompter) {
			table[b + OFFSET]++;
		}
		return table;
	}
}
