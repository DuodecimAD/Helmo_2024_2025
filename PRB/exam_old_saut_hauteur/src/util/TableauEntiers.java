package util;

public class TableauEntiers {
	
	/**
	 * retourne une copie des éléments d'un tableau d’entiers à une dimension augmentée d’un nouvel élément
	 * @param t : tableau reçu
	 * @param element : ajout de l'element au tableau
	 * @return
	 */
	public static int[] ajouterElement(int[] t, int element) {
		int[] newArray = new int[t.length+1];
		
		for (int i = 0; i < t.length; i++) {
			newArray[i] = t[i];
		}
		newArray[newArray.length-1] = element;
		
		return newArray;
	}

}
