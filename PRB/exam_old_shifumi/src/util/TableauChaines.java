package util;

import java.util.Arrays;

public class TableauChaines {

	/**
	 * e copie des éléments d'un tableau de chaînes de caractères à une dimension
	 * augmentée d’un nouvel élément
	 * 
	 * @param t       : tableau dont les éléments doivent être copiés.
	 * @param element : élément à ajouter aux éléments du tableau t
	 * @return
	 */
	public static String[] ajouterElement(String[] t, String element) {

		String[] newArray = Arrays.copyOf(t, t.length+1);
		newArray[newArray.length-1] = element;
		
		return newArray;
	}

	/**
	 * retourne une chaîne de caractères choisie aléatoirement parmi toutes celles
	 * présentes dans un tableau de chaînes de caractères à une dimension
	 * 
	 * @param t tableau dans lequel la valeur doit être choisie.
	 * @return
	 */
	public static String valeurAleatoire(String[] t) {

		int aleat = Aleatoire.aleatoire(t.length-1);
		
		return t[aleat];
	}

	/**
	 * détermine la position d’une chaîne de caractères au sein d’un tableau de
	 * chaînes de caractères à une dimension, et ce, sans tenir compte de la casse
	 * 
	 * @param t       : tableau contenant les éléments parmi lesquels la recherche
	 *                doit être effectuée.
	 * @param prefixe : début (ou l’entièreté) de la chaîne de caractères
	 *                recherchée.
	 * @return
	 */
	public static int commencePar(String[] t, String prefixe) {

		for (int i = 0; i < t.length; i++) {

			if(t[i] != null && t[i].toLowerCase().startsWith(prefixe.toLowerCase())) {
				return i;
			}
		}
		
		return -1;
	}

	/**
	 * détermine le nombre d’apparitions d’une chaîne de caractères au sein d’un
	 * tableau de chaînes de caractères à une dimension, et ce, en tenant compte de
	 * la casse
	 * 
	 * @param t      : tableau contenant les éléments parmi lesquels le dénombrement
	 *               doit être effectuée.
	 * @param chaine : chaîne de caractères à dénombrer.
	 * @return
	 */
	public static int compter(String[] t, String chaine) {
		int nb = 0;
		for (int i = 0; i < t.length; i++) {
			if(t[i] != null) {
				if(t[i].equals(chaine)) {
					nb++;
				}
			}
			
		}
		
		if (nb != 0) {
			return nb;
		}
		
		return -1;
	}

}
