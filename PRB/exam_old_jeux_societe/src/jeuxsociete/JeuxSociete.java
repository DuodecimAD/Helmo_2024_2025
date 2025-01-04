package jeuxsociete;

import io.Console;
import util.TableauEntiers;

public class JeuxSociete {

	public static void main(String[] args) {

		// Tableaux
		String[] appreciations = { "Meilleur", "Recommandé", "Pas recommandé" };
		int[][] votes = {};
		// int[][] votes = {{3, 12, 5}, {21, 6, 0}, {5, 13, 0}, {0, 0, 0}};

		// Variables
		int nbMinJoueurs, nbMaxJoueurs;

		// Version minimale

//		String voteLettre;
//		nbMinJoueurs = Console.lireInt("Nombre minimum de joueurs ? ");
//		nbMaxJoueurs = Console.lireInt("Nombre maximum de joueurs ? ");
//
//		votes = new int[nbMaxJoueurs - nbMinJoueurs + 1][3];
//
//		System.out.println("Votre Appréciation ...");
//
//		for (int i = 0; i < appreciations.length; i++) {
//			System.out.println("(" + appreciations[i].charAt(0) + ")" + appreciations[i].substring(1));
//		}
//		System.out.println("(N)SP");
//
//		for (int i = nbMinJoueurs; i <= nbMaxJoueurs; i++) {
//
//			//voteLettre = lireCaractere("... pour " + i + " joueur(s) ? ", "MRPN");
//
//			for (int j = 0; j < appreciations.length; j++) {
//				if (appreciations[j].substring(0,1).equals(voteLettre)) {
//					votes[i - nbMinJoueurs][j]++;
//				}
//			}
//		}
//
//		afficherTableauRecapitulatif(appreciations, votes, nbMinJoueurs);

		// Version optimale

		// Simulation saisies
		Console.simulerSaisies(
								  "2", "4"
								, "1", "n", "r", "m"
								, "1", "n", "m", "n"
								, "1", "n", "r", "m"
								, "1", "n", "m", "r"
								, "2", "3"
								);

		char voteLettre;
		nbMinJoueurs = lireEntier("Nombre minimum de joueurs ? ");
		nbMaxJoueurs = lireEntier("Nombre maximum de joueurs ? ", nbMinJoueurs);
		votes = new int[nbMaxJoueurs - nbMinJoueurs + 1][3];
		String choix = "";

		do {

			System.out.println();
			System.out.println("MENU");
			System.out.println("1. Voter");
			System.out.println("2. Consulter les résultats");
			System.out.println("3. Quitter");

			do {
				choix = Console.lireString("Choix ? ").trim();
			} while (!choix.matches("[1-3]"));

			switch (choix) {
			case "1" -> {
				
				System.out.println();
				System.out.println("Votre Appréciation ...");

				for (int i = 0; i < appreciations.length; i++) {
					System.out.println("(" + appreciations[i].charAt(0) + ")" + appreciations[i].substring(1));
				}
				System.out.println("(N)SP");

				for (int i = nbMinJoueurs; i <= nbMaxJoueurs; i++) {

					voteLettre = lireCaractere("... pour " + i + " joueur(s) ? ", "MRPN");

					for (int j = 0; j < appreciations.length; j++) {
						if (appreciations[j].charAt(0) == voteLettre) {
							votes[i - nbMinJoueurs][j]++;
						}
					}
				}
			}
			case "2" -> {
				afficherTableauRecapitulatif(appreciations, votes, nbMinJoueurs);
			}
			}

		} while (!choix.matches("3"));

		System.out.println();
		System.out.println("Fin du programme.");

	}

	/**
	 * affiche le résultat des votes en indiquant pour chaque configuration de
	 * joueurs et chaque appréciation le nombre de votes récoltés et le taux
	 * correspondant, ainsi que le total des votes
	 * 
	 * @param appreciations : tableau contenant les appellations des appréciations.
	 * 
	 * @param votes         : n tableau contenant les votes par nombre de joueurs et
	 *                      par appréciation.
	 * @param nbMinJoueurs  : nombre minimum de joueurs pour lequel le jeu est
	 *                      prévu.
	 */
	public static void afficherTableauRecapitulatif(String[] appreciations, int[][] votes, int nbMinJoueurs) {

		System.out.printf("# joueurs %14s %14s %14s # votes\n", appreciations[0], appreciations[1], appreciations[2]);

		double[][] taux = TableauEntiers.calculerTaux(votes);

		for (int i = 0; i < votes.length; i++) {

			System.out.printf("%9d ", nbMinJoueurs);

			for (int j = 0; j < votes[i].length; j++) {

				double value = taux[i][j];
				if (Double.isNaN(value)) {
					System.out.printf("%10s ", "-");
				} else {
					System.out.printf("%9.1f%% ", value);
				}

				System.out.printf("%s ", "(" + votes[i][j] + ")");
			}

			System.out.printf("%7d\n", TableauEntiers.sommer(votes[i]));
			nbMinJoueurs++;
		}

	}

	/**
	 * effectue l’acquisition sécurisée d’un entier :
	 * 
	 * @param question : chaîne de caractères à afficher en guise de question pour
	 *                 spécifier la valeur que doit saisir l’utilisateur
	 * @return
	 */
	public static int lireEntier(String question) {
		String recup = "";
		do {
			recup = Console.lireString(question).trim();
		} while (!recup.matches("[-+]?[1-9]+"));

		return Integer.parseInt(recup);
	}

	/**
	 * effectue l’acquisition sécurisée d’un entier.
	 * 
	 * @param question : chaîne de caractères à afficher en guise de question pour
	 *                 spécifier la valeur que doit saisir l’utilisateur.
	 * 
	 * @param min      : indique le nombre entier minimum admis.
	 * @return
	 */
	public static int lireEntier(String question, int min) {

		int nombre = -1;
		do {
			nombre = lireEntier(question);
		} while (nombre < min);

		return nombre;
	}

	/**
	 * effectue l’acquisition sécurisée d’un caractère sous sa forme majuscule :
	 * 
	 * @param question : chaîne de caractères à afficher en guise de question pour
	 *                 spécifier la valeur que doit saisir l’utilisateur.
	 * @param admis    : chaîne spécifiant tous les caractères admis. La casse n’est
	 *                 pas prise en compte
	 * @return
	 */
	public static char lireCaractere(String question, String admis) {
		String recup = null;
		do {
			// je pige pas... comment récupérer le char quand seulement un nombre est permis
			// avec lireEntier ...
			// recup = Integer.toString(lireEntier(question)).toUpperCase();

			recup = Console.lireString(question).trim().toUpperCase();

		} while (recup.isEmpty() || !recup.substring(0, 1).matches("[" + admis + "]"));

		return recup.charAt(0);
	}

}
