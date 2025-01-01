package util;

import java.util.Arrays;

public class TableauCaracteres {
	
	/**
	 * retourne une copie des éléments d'un tableau de caractères à 
	 * une dimension augmentée d’un nouvel élément
	 * 
	 * @param t : désigne le tableau dont les éléments doivent être copiés
	 * @param element : désigne l’élément à ajouter à ceux du tableau t
	 * @return nouveau tableau avec l'element ajouté
	 */
	public static char[] ajouterElement(char[] t, char element) {
		char[] newArray = new char[t.length+1];
		
		for (int i = 0; i < t.length; i++) {
			newArray[i] = t[i];
		}
		newArray[newArray.length-1] = element;
		
		return newArray;
	}
	
	/**
	 *  retourne une copie des références des lignes d'un tableau de caractères 
	 *  à deux dimensions augmentée de la référence d’une nouvelle ligne 
	 *  
	 * @param t : désigne le tableau dont les références des lignes doivent être copiées
	 * @param element : désigne la référence de ligne à ajouter à celles du tableau t
	 * @return nouveau tableau avec la ligne ajoutée
	 */
	public static char[][] ajouterLigne(char[][] t, char[] ligne){
		
		char [][] newArray = Arrays.copyOf(t, t.length+1);	

		newArray[newArray.length-1] = ligne;
		
		return newArray;
	}
	
	/**
	 * retourne la référence d’un tableau à une dimension contenant 
	 * une copie des éléments d’un tableau à deux dimensions
	 * 
	 * @param t : désigne le tableau contenant les éléments à copier dans le tableau à une dimension
	 * @return
	 */
	public static char[] enUneDimension(char[][] t) {
		
		char[] newArray = null;
		String tToString = "";
		
		// Je sais pas si il y a une méthode pour récup d'un coup 
		// le nombre d'element total d'un double array
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[i].length; j++) {
				tToString += t[i][j];
			}
		}
		
		newArray = new char[tToString.length()];
		
		// après ajout de chaque element du tableau 2D dans une string
		// ajoute chaque char de la string au nouveau tableau
		for (int i = 0; i < tToString.length(); i++) {
			newArray[i] = tToString.charAt(i);
		}
		
		return newArray;
	}
	
	/**
	 * à faire
	 * 
	 * @param t : désigne le tableau contenant les éléments parmi lesquels la recherche doit être effectuée.
	 * @param valeur : désigne le caractère à rechercher
	 * @return
	 */
	public static int dernierePositionDe(char[] t, char valeur) {
		int index = 0;
		
		for (int i = 0; i < t.length; i++) {
			if(t[i] == valeur) {
				index = i;
			}
		}
		
		if(index != 0) {
			return index;
		} else {
			return -1;
		}
		
		
	}



}
