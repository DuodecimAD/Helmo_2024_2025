package eval4;

import java.util.Arrays;

public class CarreMagique {
	
	public static void main(String[] args) {
		
		// Test 1 	
//		int[][] t = {
//				{ 2, 7, 6 },
//				{ 9, 5, 1 },
//				{ 4, 3, 8 }
//			};
//			for (int[] ligne : t) {
//				for (int element : ligne) {
//					System.out.printf("%2d ", element);
//				}
//				System.out.println();
//			}
//			if (CarreMagique.carreMagique(t)) {
//				System.out.println("C'est un carré magique.");
//			} else {
//				System.out.println("Ce n'est pas un carré magique.");
//			}
			
		// Test 2
//		int[][] t = {
//				{ 1, 2 },
//				{ 3, 4 }
//			};
//			for (int[] ligne : t) {
//				for (int element : ligne) {
//					System.out.printf("%2d ", element);
//				}
//				System.out.println();
//			}
//			if (CarreMagique.carreMagique(t)) {
//				System.out.println("C'est un carré magique.");
//			} else {
//				System.out.println("Ce n'est pas un carré magique.");
//			}
//			
		// Test 3 
		int[][] t = new int[0][];
		for (int[] ligne : t) {
			for (int element : ligne) {
				System.out.printf("%2d ", element);
			}
			System.out.println();
		}
		if (CarreMagique.carreMagique(t)) {
			System.out.println("C'est un carré magique.");
		} else {
			System.out.println("Ce n'est pas un carré magique.");
		}

	}
	

	/**
	 * Détermine si un tableau à deux dimensions vérifie toutes les propriétés d'un
	 * carré magique, autrement dit : s'il est parfaitement carré ; si les sommes de
	 * ses diagonales, lignes et colonnes sont égales ; s'il comporte les nombres
	 * entiers allant de 1 à n² (n étant la taille du carré).
	 * 
	 * @param t La référence du tableau à deux dimensions.
	 * @return true si le tableau spécifié est un carré magique, false dans le cas
	 *         contraire.
	 */
	public static boolean carreMagique(int[][] t) {
	    // Suggestion : utilisez les fonctions "estCarre", "somme", "extraireDiagonaleDescendante",
	    // "extraireDiagonaleMontante", "extraireColonne", "enUneDimension" ci-dessous, ainsi que
	    // la fonction "Arrays.sort".
		
//		if(t.length == 0) {
//			return false;
//		}
		
		if(!estCarre(t)) {
			return false;
		}
		
		int result = somme(t[0]);
		for (int i = 1; i < t.length; i++) {
			if(somme(t[i]) !=  result) {
				return false;
			}
		}

		int[] diagonaleAsc = extraireDiagonaleMontante(t);
		if(somme(diagonaleAsc) != result) {
			return false;
		}
		
		int[] diagonaleDesc = extraireDiagonaleDescendante(t);
		if(somme(diagonaleDesc) != result) {
			return false;
		}
		
		for (int i = 0; i < t.length; i++) {
			int[] colonne = extraireColonne(t, i);
			if(somme(colonne) != result) {
				return false;
			}
		}
		
		int[] tableauNbDifferents = enUneDimension(t);
		Arrays.sort(tableauNbDifferents);
		
		for (int i = 1; i < tableauNbDifferents.length; i++) {
			int diff = tableauNbDifferents[i] - tableauNbDifferents[i-1];
			if(diff != 1) {
				return false;
			}
		}
		
		
		return true;
	}

	/**
	 * Détermine si un tableau à deux dimensions est parfaitement carré, autrement
	 * dit si ses largeur et hauteur sont identiques et si ses lignes sont toutes de
	 * même longueur. Le tableau vide (aucune ligne) n'est pas considéré comme
	 * formant un carré.
	 * 
	 * @param t La référence du tableau.
	 * @return true si le tableau spécifié forme un carré, false dans le cas
	 *         contraire.
	 */
	public static boolean estCarre(int[][] t) {
		if(t.length == 0) {
			return false;
		}
		
		for (int i = 0; i < t.length; i++) {
			if(t.length != t[i].length) {
				return false;
			}
		}
		
		return true;
	}

	/**
	 * Calcule la somme des éléments d'un tableau à une dimension.
	 * 
	 * @param t La référence du tableau à une dimension.
	 * @return la valeur de la somme des éléments, 0 si le tableau est vide.
	 */
	public static int somme(int[] t) {
		
		if(t.length == 0) {
			return 0;
		}
		
		int somme = 0;
		
		for (int i = 0; i < t.length; i++) {
			somme += t[i];
		}
		
		return somme;
	}

	/**
	 * Crée un tableau à une dimension constitué des éléments de l'une des colonnes
	 * d'un tableau à deux dimensions.
	 * 
	 * @param t             La référence du tableau à deux dimensions.
	 * @param indiceColonne La position de la colonne (de 0 à t[0].length).
	 * @return la référence du tableau à une dimension contenant les éléments de la
	 *         colonne spécifiée.
	 */
	public static int[] extraireColonne(int[][] t, int indiceColonne) {
		int[] colonne = new int[t.length];
		
		for (int i = 0; i < t.length; i++) {
			colonne[i] = t[i][indiceColonne];
		}
		
		return colonne;
	}

	/**
	 * Crée un tableau à une dimension constitué des éléments de la diagonale
	 * descendante d'un tableau à deux dimensions.
	 * 
	 * @param t La référence du tableau à deux dimensions.
	 * @return la référence du tableau à une dimension contenant les éléments de la
	 *         diagonale descendante.
	 */
	public static int[] extraireDiagonaleDescendante(int[][] t) {
		int[] diagonale = new int[t.length];
		int j = 0;
		
		for (int i = 0; i < t.length; i++) {
			diagonale[i] = t[i][j++];
		}
		return diagonale;
	}

	/**
	 * Crée un tableau à une dimension constitué des éléments de la diagonale
	 * montante d'un tableau à deux dimensions.
	 * 
	 * @param t La référence du tableau à deux dimensions.
	 * @return la référence du tableau à une dimension contenant les éléments de la
	 *         diagonale montante.
	 */
	public static int[] extraireDiagonaleMontante(int[][] t) {
		int[] diagonale = new int[t.length];
		int j = t.length-1;
		
		for (int i = 0; i < t.length; i++) {
			diagonale[i] = t[i][j--];
		}
		return diagonale;
	}

	/**
	 * Crée un tableau à une dimension constitué des éléments d'un tableau à deux
	 * dimensions.
	 * 
	 * @param t2D La référence du tableau à deux dimensions.
	 * @return la référence du tableau à une dimension contenant tous les éléments
	 *         du tableau à deux dimensions.
	 */
	public static int[] enUneDimension(int[][] t2D) {
	    // Suggestion : utilisez la fonction "ajouterElements" ci-dessous.
		
		int[] array = new int[0];
		
		for (int i = 0; i < t2D.length; i++) {
			array = ajouterElements(array, t2D[i]);
		}
		
		return array;
	}

	/**
	 * Crée un tableau étant la copie d'un tableau à une dimension, augmentée des
	 * éléments spécifiés dans le second tableau.
	 * 
	 * @param t        La référence du tableau à une dimension qui doit être copié.
	 * @param elements La référence du tableau contenant les éléments à ajouter.
	 * @return la référence du tableau à une dimension contenant les éléments des
	 *         deux tableaux.
	 */
	public static int[] ajouterElements(int[] t, int[] elements) {
	    // Suggestion : utilisez les fonctions "Arrays.copyOf" et "System.arraycopy".
		int newLength = t.length + elements.length;
		
		int[] newArray = Arrays.copyOf(t,  newLength);
		
		System.arraycopy(elements, 0, newArray, t.length, elements.length);
		
		return newArray;
	}
	
}