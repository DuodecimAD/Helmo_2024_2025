package util;

import java.util.Arrays;

public class TableauChaines {
	
	
	/**
	 * copie des éléments d'un tableau de chaînes de caractères à une dimension augmentée d’un nouvel élément.
	 * @param t : tableau dont les éléments doivent être copiés.
	 * @param element : élément à ajouter aux éléments du tableau t.
	 * @return : tableau t + element. 
	 */
	public static String[] ajouterElement(String[] t, String element) {
		
		String[] newArray = Arrays.copyOf(t, t.length+1);
		
		newArray[newArray.length-1] = element;
		
		return newArray;
	}

	/**
	 * copie des éléments d'un tableau de chaînes de caractères à une dimension diminuée de l’un d’entre eux.
	 * @param t : tableau dont les éléments doivent être copiés.
	 * @param position : position de l’élément du tableau t à exclure de la copie.
	 * @return : tableau t - element.
	 */
	public static String[] retirerElement(String[] t, int position) {
		
		String[] newArray = new String[t.length-1];
		int index = 0;

		for (int i = 0; i < t.length; i++) {
			if(i != position) {
				newArray[index] = t[i];
				index++;
			}
		}
		return newArray;
	}
	
	/**
	 * détermine la position d’une chaîne de caractères au sein d’un tableau de chaînes de caractères à une dimension, et ce, sans tenir compte de la casse.
	 * @param t : tableau contenant les éléments parmi lesquels la recherche doit être effectuée.
	 * @param prefixe : début de la chaîne de caractères recherchée
	 * @return : position de la string.
	 */
	public static int positionDe(String[] t, String prefixe) {
		
		for (int i = 0; i < t.length; i++) {
			if(t[i] != null) {
				if(t[i].toLowerCase().startsWith(prefixe)) {
					return i;
				}
			}
		}
		return -1;
	}
	
	
	/**
	 * détermine la position [i, j] (i et j) correspondant respectivement aux indices d’une ligne et d’une colonne) d’une chaîne 
	 * de caractères au sein d’un tableau de chaînes de caractères à deux dimensions
	 * @param t : tableau contenant les éléments parmi lesquels la recherche doit être effectuée.
	 * @param prefixe : début de la chaîne de caractères recherchée.
	 * @return : position i et j de la string dans le tableau.
	 */
	public static int[] positionDe(String[][] t, String prefixe) {
		
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[i].length; j++) {
				if(t[i][j] != null) {
					if(t[i][j].toLowerCase().startsWith(prefixe)) {
						return new int[] {i, j};
					}
				}
			}	
		}
		return null;
	}


}
