package util;

import java.util.Arrays;

public class TableauEntiers {

	/**
	 * Retourne la somme des éléments d'un tableau d'entiers
	 * 
	 * @param tableau à une dimension
	 * @return somme des éléments
	 */
	public static int sommer(int[] t) {
		int somme = 0;

		if (t.length == 0) {
			return 0;
		}

		for (int i = 0; i < t.length; i++) {
			somme += t[i];
		}

		return somme;
	}

	/**
	 * retourne un tableau dans lequel les valeurs provenant d’un autre tableau ont
	 * été exprimées en taux
	 * 
	 * @param t : tableau contenant les valeurs à exprimer en taux.
	 * @return nouveau tableau avec valeurs en taux
	 */
	public static double[] calculerTaux(int[] t) {

		double[] newArray = new double[t.length];

		int total = sommer(t);

		if (total == 0) {
			Arrays.fill(newArray, Double.NaN);
		} else {
			for (int i = 0; i < newArray.length; i++) {
				newArray[i] = ((double) t[i] / total) * 100;
			}
		}

		return newArray;
	}

	/**
	 * retourne un tableau dans lequel les valeurs provenant d’un autre tableau ont
	 * été exprimées en taux, les taux d’une même ligne étant établis uniquement sur
	 * base des valeurs apparaissant dans cette ligne
	 * 
	 * @param t : tableau contenant les valeurs à exprimer en taux.
	 * @return tableau 2D avec taux
	 */
	public static double[][] calculerTaux(int[][] t) {

		double[][] newArray = new double[t.length][];

		for (int i = 0; i < newArray.length; i++) {

			if (t[i] == null) {
				newArray[i] = null;
			} else {
				newArray[i] = calculerTaux(t[i]);
			}
		}

		return newArray;
	}

}
