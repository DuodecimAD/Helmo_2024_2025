package chap9;

import java.util.Arrays;

import io.Console;

public class CollecteDonsTab2d {

	public static void main(String[] args) {
		// Tableaux
		String[] collecteurs = { };
		int[][] donsRecoltes;

		// Variables
		String collecteurSaisi, choixContinuer, saisie;
		int donSaisi, posCollecteur;

		// DEBUT DEBUG
		Console.simulerSaisies("Lucas", "Sophie", "Jeanne", "Tobias", "");
		Console.simulerSaisies("Jeanne", "100", "c");
		Console.simulerSaisies("Jeanne", "70", "c");
		Console.simulerSaisies("Sophie", "150", "c");
		Console.simulerSaisies("Sophie", "50", "c");
		Console.simulerSaisies("Sophie", "30", "c");
		Console.simulerSaisies("Lucas", "140", "q");
//		donsRecoltes = new int[] { 140, 150, 100, 60 };
		// FIN DEBUG

		// Acquisition des prénoms des collecteurs

		saisie = Console.lireString("Prénom du collecteur ? ").trim();
		while (!saisie.isEmpty()) {

			collecteurs = ajouterElement(collecteurs, saisie);
			saisie = Console.lireString("Prénom du collecteur ? ").trim();
		}
		System.out.println("Fin encodage.");
		donsRecoltes = new int[collecteurs.length][0];

		// Traitement
		do {

			do {
				collecteurSaisi = Console.lireString("\nPrénom du collecteur ? ").trim();
				posCollecteur = positionDe(collecteurs, collecteurSaisi);
			} while (posCollecteur < 0);

			donSaisi = Console.lireInt("Montant des dons récoltés ? ");
			//donsRecoltes[posCollecteur] += donSaisi;
			donsRecoltes[posCollecteur] = ajouterElement(donsRecoltes[posCollecteur], donSaisi);
			// System.out.println(Arrays.toString(donsRecoltes)); // DEBUG

			choixContinuer = Console.lireString("(C)ontinuer, (q)uitter ? ").trim();

		} while (choixContinuer.toLowerCase().startsWith("c"));

		
		int[] totaux = sommerLignes(donsRecoltes);
		
		// Afficher le meilleur montant récolté
		System.out.printf("\nMeilleur montant récolté = %d EUR\n", maximum(totaux));

		// Afficher le collecteur qui a réussi à récolter ce montant
		System.out.printf("Meilleur collecteur = %s\n", collecteurs[posMaximum(totaux)]);
		
		// Afficher le total global des dons récoltés
		System.out.printf("Total de la collecte = %d EUR\n\n", sommerElements(totaux));
		
		// Afficher un bilan de la récolte dans lequel le total et le nombre de dons est
		// affiché pour chaque collecteur
		for (int i = 0; i < donsRecoltes.length; i++) {
//			System.out.println(collecteurs[i] + " a récolté " + donsRecoltes[i].length + " dons pour un total de " + totaux[i] + ".");
			System.out.printf("%8s a récolté %d dons pour un total de %d EUR.\n", collecteurs[i], donsRecoltes[i].length, totaux[i]);
		}
		
	}
	
	public static String evaluer(int totalDons) {
		if( totalDons < 0) {
			return "Montant impossible !";
		} else if(totalDons >= 0 && totalDons < 100) {
			return "Très mauvais !";
		} else if (totalDons < 500) {
			return "Peut faire mieux !";
		} else if (totalDons < 1000) {
			return "Pas mal !";
		} else {
			return "Super !";
		}
		
	}
	
	public static int lireDon(String demande) {
		String saisie;
		
		do {
			saisie = Console.lireString(demande);
		} while (saisie.matches("\\+?0*[1-9][0-8]{0,8}") == false);
		
		return Integer.parseInt(saisie);
	}
	
	public static double moyenne(int[] t) {
		if(t.length == 0) {
			return Double.NaN;
		}
		return (double) sommerElements(t) / t.length;
	}
	
	public static int sommerElements(int[] t) {
		int somme = 0;
		for (int element : t) {
			somme += element;
		}
		return somme;
	}
	
	public static int[] sommerLignes(int[][] t) {
		int[] sommes = new int[t.length];
		
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[i].length; j++) {
				sommes[i] += t[i][j];
			}
		}
		//System.out.println(Arrays.toString(sommes));
		return sommes;
	}

	public static int[] ajouterElement(int[] t, int nouvelElement) {
		int[] nouveau = Arrays.copyOf(t,  t.length +1);
		nouveau[nouveau.length -1] = nouvelElement;
		return nouveau;
	}

	/**
	 * Permet de créer un tableau contenant les éléments d'un tableau existant
	 * et d'un élément supplémentaire.
	 * 
	 * @param t       La référence du tableau contenant les éléments à copier.
	 * @param element L'élément à ajouter.
	 * @return La référence du tableau contenant les éléments de t et l'élément
	 *         supplémentaire.
	 */
	public static String[] ajouterElement(String[] t, String element) {
		// 1. Créer un nouveau tableau avec une case supplémentaire par rapport à t
		String[] nouveau = new String[t.length + 1];

		// 2. Copier dans le nouveau tableau les éléments de t
		for (int i = 0; i < t.length; i++) {
			nouveau[i] = t[i];
		}

		// 3. Ajouter l'élément supplémentaire au nouveau tableau
		nouveau[nouveau.length - 1] = element;

		// 4. Retourner la référence du nouveau tableau
		return nouveau;
	}

	public static String[] ajouterElementCopyOf(String[] t, String element) {
		String[] nouveau = Arrays.copyOf(t, t.length + 1);
		nouveau[nouveau.length - 1] = element;
		return nouveau;
	}

	public static int maximum(int[] t) {
		int max = t[0];
		for (int i = 1; i < t.length; i++) {
			if (t[i] > max) {
				max = t[i];
			}
		}
		return max;
	}

	public static int posMaximum(int[] t) {
		if (t.length == 0) {
			return -1;
		}
		int posMax = 0;
		for (int i = 1; i < t.length; i++) {
			if (t[i] > t[posMax]) {
				posMax = i;
			}
		}
		return posMax;
	}

	/**
	 * Détermine la position à laquelle se situe une chaîne au sein d'un tableau.
	 * 
	 * @param t          La référence du tableau.
	 * @param chaineRech La chaîne recherchée.
	 * @return la position de la première (en partant de la position 0) chaîne
	 *         correspondante si celle-ci est trouvée, -1 dans le cas contraire.
	 */
	public static int positionDe(String[] t, String chaineRech) {
		for (int i = 0; i < t.length; i++) {
			if (t[i].equalsIgnoreCase(chaineRech)) {
				return i;
			}
		}
		return -1;
	}

}
