package util;

public class TableauCaracteres {

	/**
	 * effectue la permutation des caractères situés aux deux positions spécifiées
	 * d’un tableau à deux dimensions
	 * 
	 * @param t  tableau dans lequel la permutation doit être effectuée.
	 * @param i1 : désigne l’indice de la ligne du premier caractère.
	 * @param j1 : désigne l’indice de la colonne du premier caractère.
	 * @param i2 : désigne l’indice de la ligne du deuxième caractère.
	 * @param j2 : désigne l’indice de la colonne du deuxième caractère.
	 */
	public static void permuter(char[][] t, int i1, int j1, int i2, int j2) {

		char temp = t[i2][j2];
		t[i2][j2] = t[i1][j1];
		t[i1][j1] = temp;
	}

	/**
	 * mélange aléatoirement les caractères présents dans un tableau à deux
	 * dimensions
	 * 
	 * @param t tableau dont les caractères doivent être mélangés.
	 */
	public static void melanger(char[][] t) {

		int i1, j1;

		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t.length; j++) {

				i1 = Aleatoire.aleatoire(t.length - 1);
				j1 = Aleatoire.aleatoire(t.length - 1);

				permuter(t, i1, j1, i, j);
			}
		}

	}

	/**
	 * détermine la position de la première occurrence d’un caractère au sein d’un
	 * tableau
	 * 
	 * @param t : tableau dans lequel la recherche doit s’effectuer.
	 * @param c : caractère à rechercher.
	 * 
	 * @return
	 */
	public static int positionDe(char[] t, char c) {

		for (int i = 0; i < t.length; i++) {
			if (c == t[i]) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * retourne un tableau répertoriant les positions de la première occurrence d’un
	 * caractère au sein de chacune des lignes d’un tableau à deux dimensions
	 * 
	 * @param t : tableau dans lequel les recherches doivent s’effectuer.
	 * @param c : le caractère à rechercher.
	 * @return
	 */
	public static int[] positionsParLigne(char[][] t, char c) {

		int[] newArray = new int[t.length];
		for (int i = 0; i < t.length; i++) {
			newArray[i] = positionDe(t[i], 'T');
		}
		return newArray;
	}

}
