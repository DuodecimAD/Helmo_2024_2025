package eval4;

import java.util.Arrays;
import java.util.Random;

public class DistributionCartes {

	public static void main(String[] args) {
		
		// Test 1 
		final int NB_JOUEURS = 4;
		String[] cartes = DistributionCartes.getJeuDeCartes();
		DistributionCartes.melanger(cartes);
		String[][] cartesParJoueur = DistributionCartes.distribuerCartes(cartes, NB_JOUEURS);
		for (String[] cartesJoueur : cartesParJoueur) {
			System.out.println(Arrays.toString(cartesJoueur));
		}
		
		// Test 2
//		final int NB_JOUEURS = 1;
//		String[] cartes = DistributionCartes.getJeuDeCartes();
//		DistributionCartes.melanger(cartes);
//		String[][] cartesParJoueur = DistributionCartes.distribuerCartes(cartes, NB_JOUEURS);
//		for (String[] cartesJoueur : cartesParJoueur) {
//			System.out.println(Arrays.toString(cartesJoueur));
//		}
		
		// Test 3
//		final int NB_JOUEURS = 2;
//		String[] cartes = DistributionCartes.getJeuDeCartes();
//		DistributionCartes.melanger(cartes);
//		String[][] cartesParJoueur = DistributionCartes.distribuerCartes(cartes, NB_JOUEURS);
//		for (String[] cartesJoueur : cartesParJoueur) {
//			System.out.println(Arrays.toString(cartesJoueur));
//		}

	}
	
	/**
	 * Crée un tableau à deux dimensions contenant un nombre de lignes égal au
	 * nombre de joueurs. Les cartes spécifiées sont réparties dans les différentes
	 * lignes de manière équilibrée.
	 * 
	 * @param cartes    La référence du tableau contenant les cartes à distribuer.
	 * @param nbJoueurs Le nombre de joueurs pour lesquels les cartes doivent être
	 *                  ditribuées.
	 * @return la référence d'un tableau à deux dimensions contenant, pour chaque
	 *         joueur, la liste des cartes qui lui ont été distribuées.
	 */
	public static String[][] distribuerCartes(String[] cartes, int nbJoueurs) {
		// Suggestion : utiliser la fonction "ajouterElement" ci-dessous.
		
		String[][] cartesDistrib = new String[nbJoueurs][0];
		
		for (int i = 0; i < cartes.length; i++) {
			int joueur = i % nbJoueurs;
			
			cartesDistrib[joueur] = ajouterElement(cartesDistrib[joueur], cartes[i]);
		}
		
		return  cartesDistrib;
	}

	/**
	 * Crée une copie d'un tableau à une dimension en y ajoutant un élément.
	 * 
	 * @param t       La référence du tableau à copier.
	 * @param element L'élément à ajouter à la copie.
	 * @return la référence d'un tableau constitué des éléments du tableau spécifié
	 *         ainsi que du nouvel element.
	 */
	public static String[] ajouterElement(String[] t, String element) {
		final int N = t.length;
		String[] nouveau = Arrays.copyOf(t, N + 1);
		nouveau[N] = element;
		return nouveau;
	}

	public static String[] getJeuDeCartes() {
		// Constantes
		final String[] COULEURS = { "coeur", "carreau", "trèfle", "pique" };
		final String[] CARTES = { "9", "10", "Valet", "Dame", "Roi", "As" };

		// Variable pour le résultat
		String[] jeuDeCartes;

		// Créer un jeu de cartes
		jeuDeCartes = new String[COULEURS.length * CARTES.length];
		for (int i = 0; i < COULEURS.length; i++) {
			for (int j = 0; j < CARTES.length; j++) {
				jeuDeCartes[CARTES.length * i + j] = CARTES[j] + " de " + COULEURS[i];
			}
		}

		// Retourner le jeu de cartes
		return jeuDeCartes;
	}

	public static void permuter(String[] tableau, int i, int j) {
		String temp = tableau[i];
		tableau[i] = tableau[j];
		tableau[j] = temp;
	}

	public static void melanger(String[] tableau) {
		Random aleatoire = new Random(0);
		final int N = tableau.length;
		for (int i = 0; i < N; i++) {
			permuter(tableau, i, aleatoire.nextInt(N));
		}
	}

}
