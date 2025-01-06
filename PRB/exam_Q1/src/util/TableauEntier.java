package util;

public class TableauEntier {

	/**
	 * crée un tableau énumérant les nombres entiers compris entre les deux bornes
	 * spécifiées
	 * 
	 * @param min : désigne la borne inférieure inclusive de l’intervalle.
	 * @param max : désigne la borne supérieure inclusive de l’intervalle.
	 * @return tableau de int
	 */
	public static int[] intervalle(int min, int max) {

		int length = max - min + 1;

		int[] tableau = new int[length];
		tableau[0] = min;
		for (int i = 1; i < length; i++) {
			tableau[i] = tableau[i - 1] + 1;
		}

		return tableau;
	}

}
