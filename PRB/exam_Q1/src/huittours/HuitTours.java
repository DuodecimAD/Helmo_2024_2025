package huittours;

import java.util.Arrays;
import io.Console;
import util.TableauCaracteres;
import util.TableauEntier;

public class HuitTours {

	public static void main(String[] args) {

		// Version minimale

//		// simulation saisies
//		// Console.simulerSaisies("4");
//
//		// Variables / Acquisition
//		int taille = Console.lireInt("Taille de l'échiquier (de 2 à 8) ? ");
//		
//		// Tableau
//		char[][] echiquier = creerEchiquier(taille);
//		
//		// Traitement
//		TableauCaracteres.melanger(echiquier);
//		
//		// Affichage
//		System.out.println("Echiquier après 1 mélange : ");
//		System.out.println(Arrays.deepToString(echiquier));
//
//		
		// Version idéale

		// simulation saisies
		Console.simulerSaisies("14", "4");

		// Variables / Acquisition
		final String DEMANDE_TAILLE = "Taille de l'échiquier (de 2 à 8) ? ";
		int nbEssais = 0;
		String taille = null;

		do {
			taille = Console.lireString(DEMANDE_TAILLE).trim();
		} while (taille == null || !taille.matches("[2-8]"));

		System.out.println();

		// Tableau
		char[][] echiquier = creerEchiquier(Integer.parseInt(taille));

		// Traitement
		do {

			TableauCaracteres.melanger(echiquier);

			// Algorithme

			int[] algo = TableauCaracteres.positionsParLigne(echiquier, 'T');

			Arrays.sort(algo);

			int[] checkAlgo = TableauEntier.intervalle(0, echiquier.length - 1);

			if (!Arrays.equals(algo, checkAlgo)) {
				nbEssais++;
			} else {
				break;
			}
		} while (true);

		// Affichage
		afficherEchiquier(echiquier);
		System.out.println(nbEssais + " tentatives ont été nécessaires.");

	}

	/**
	 * crée un tableau à deux dimensions de caractères en l’initialisant avec des
	 * caractères espace (désignent les cases vides), à l’exception de la 1ère ligne
	 * qui est initialisée avec des lettres T majuscules
	 * 
	 * @param taille : la taille de l’échiquier à créer.
	 * @return
	 */
	public static char[][] creerEchiquier(int taille) {

		char[][] array = new char[taille][taille];

		for (int i = 0; i < array.length; i++) {
			if (i == 0) {
				Arrays.fill(array[i], 'T');
			} else {
				Arrays.fill(array[i], ' ');
			}

		}

		return array;
	}

	/**
	 * affiche un échiquier.
	 * 
	 * @param echiquier : désigne l’échiquier à afficher.
	 */
	public static void afficherEchiquier(char[][] echiquier) {

		String contours = "+";

		for (int i = 0; i < echiquier.length; i++) {
			contours += "---+";
		}

		for (int i = 0; i < echiquier.length; i++) {
			System.out.println(contours);
			for (int j = 0; j < echiquier[i].length; j++) {
				if (j == 0) {
					System.out.print("|");
				}
				System.out.print(" " + echiquier[i][j] + " |");
			}
			System.out.println();
		}
		System.out.println(contours);
	}

}
