package shifumi;

import java.util.Iterator;

import io.Console;
import util.TableauChaines;

public class Shifumi {

	private static final String[] ARMES = { "Ciseaux", "Feuille", "Pierre", "Lézard", "Spock" };

	public static void main(String[] args) {

		// version minimale
		
//		// Variables
//		String armeJoueur = null;
//		String armeChoisie;
//		String armeAi = null;
//		String menu;
//		System.out.println("JEU DU SHIFUMI");
//
//		do {
//			do {
//				String choix = Console.lireString("Ciseaux, Feuille, Pierre, Lézard, Spock ? ").trim().toLowerCase();
//				if(!choix.isEmpty()){
//					armeChoisie = choix.substring(0,1).toUpperCase() + choix.substring(1);
//					
//					for (int i = 0; i < ARMES.length; i++) {
//						if(armeChoisie.equals(ARMES[i])) {
//							armeJoueur = ARMES[i];
//						}
//					}
//				}
//
//			} while (armeJoueur == null);
//
//			armeAi = TableauChaines.valeurAleatoire(ARMES);
//			
//			System.out.println(armeJoueur + " contre " + armeAi);
//			do {
//				menu = Console.lireString("(C)ontinuer, (Q)uitter ? ").trim().toUpperCase();
//			} while (menu.isEmpty() || !menu.substring(0,1).matches("[CQ]"));
//			
//			System.out.println();
//			
//			if(menu.charAt(0) == 'Q') {
//				break;
//			}
//
//		} while (true);
//		
//		System.out.println("Fin du programme.");

		
		// version idéale

		// simulation saisies
		Console.simulerSaisies("spok", "spock", "s", "f", "léz");
		
		
		// Tableaux
		String[][] interactionsArmes = {
				{ "ne font rien contre", "coupent", "sont émoussés par", "décapitent", "sont cassés par" },
				{ "est coupée par", "ne fait rien contre", "enveloppe", "est mangée par", "discrédite" },
				{ "émousse", "est enveloppée par", "ne fait rien contre", "écrase", "est vaporisée par" },
				{ "est décapité par", "mange", "est écrasé par", "ne fait rien	contre", "empoisonne" },
				{ "casse", "est discrédité par", "vaporise", "est empoisonné par", "ne fait rien contre" } };

		String[][] historiqueArmes = new String[2][0];
		
		// Variables
		String armeJoueur = null;
		String armeAi = null;
		int joueurPoints = 0;
		int aiPoints = 0;

		do {
			armeJoueur = selectionnerChaine(ARMES);
			armeAi = TableauChaines.valeurAleatoire(ARMES);
			historiqueArmes[0] = TableauChaines.ajouterElement(historiqueArmes[0], armeJoueur);
			historiqueArmes[1] = TableauChaines.ajouterElement(historiqueArmes[1], armeAi);

			if (comparer(armeJoueur, armeAi) == 1) {
				joueurPoints++;
			} else if (comparer(armeJoueur, armeAi) == -1) {
				aiPoints++;
			} else if (comparer(armeJoueur, armeAi) == 0) {

			} else {
				System.out.println("qqchose a foiré !");
			}

			int armeJoueurIndex = TableauChaines.commencePar(ARMES, armeJoueur);
			int armeAiIndex = TableauChaines.commencePar(ARMES, armeAi);

			System.out.printf("%s %s %s\n", armeJoueur, interactionsArmes[armeJoueurIndex][armeAiIndex], armeAi);
			System.out.printf("Vous %d - %d IA\n\n", joueurPoints, aiPoints);

		} while (joueurPoints < 3 && aiPoints < 3);

		if (joueurPoints == 3) {
			System.out.println("Bravo ! Vous gagnez la partie.");
		} else {
			System.out.println("Dommage ! Vous perdez la partie.");
		}

		System.out.println();
		System.out.println("STATISTIQUES");
		System.out.println();

		int k = 0;
		do {
			int armeUsed = 0;
			for (int i = 0; i < historiqueArmes.length; i++) {
				for (int j = 0; j < historiqueArmes[i].length; j++) {
					if (historiqueArmes[i][j].equals(ARMES[k])) {
						armeUsed++;
					}
				}
			}
			System.out.println(armeUsed + " fois " + ARMES[k]);
			k++;
		} while (k < ARMES.length);

	}

	/**
	 * demande à l’utilisateur de sélectionner une chaîne de caractères parmi celles
	 * qui lui sont proposées. Pour ce faire, l’utilisateur doit saisir une chaîne
	 * de caractères qui correspond, sans tenir compte de la casse,
	 * 
	 * @param chainesAdmises : tableau contenant les chaînes de caractères
	 *                       proposées.
	 * @return
	 */
	public static String selectionnerChaine(String[] chainesAdmises) {

		String armeChoisie;
		int indexArme = -1;

		do {
			String choix = Console.lireString("Ciseaux, Feuille, Pierre, Lézard, Spock ? ").trim().toLowerCase();
			if (!choix.isEmpty()) {
				armeChoisie = choix.substring(0, 1).toUpperCase() + choix.substring(1);

				indexArme = TableauChaines.commencePar(chainesAdmises, armeChoisie);
			}

		} while (indexArme == -1);

		return ARMES[indexArme];
	}

	/**
	 * compare deux armes entre elles afin de déterminer le résultat de la
	 * confrontation.
	 * 
	 * @param arme1 : noms des deux armes qui se confrontent.
	 * @param arme2 : noms des deux armes qui se confrontent.
	 * @return
	 */
	public static int comparer(String arme1, String arme2) {

		int armeJoueur = TableauChaines.commencePar(ARMES, arme1);
		int armeAi = TableauChaines.commencePar(ARMES, arme2);

		if (armeAi == ((armeJoueur + 1) % 5) || armeAi == ((armeJoueur + 3) % 5)) {
			return 1;
		} else if (armeJoueur == ((armeAi + 1) % 5) || armeJoueur == ((armeAi + 3) % 5)) {
			return -1;
		}

		return 0;
	}

}
