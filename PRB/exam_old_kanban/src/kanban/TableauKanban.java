package kanban;

import io.Console;
import util.TableauChaines;

public class TableauKanban {

	public static void main(String[] args) {
		
		// Arrays
		String[] intitules = {};
		String[][] colonnes = {{}, {}, {}};
		
		// Affichage Minimum
		
//		Simulation saisies
//		Console.simulerSaisies("A faire", "En cours", "Terminée", "", "Lire l'énoncé de l'exam");
//		
//		do {
//			
//			title = Console.lireString("Etape #" + (stepIndex+1) + " ('Entrée' pour terminer) ? ").toUpperCase().trim();
//			
//			if(title.isEmpty()) {
//				break;
//			}
//			
//			intitules = TableauChaines.ajouterElement(intitules, title);
//			stepIndex++;
//			
//		} while (true);
//		
//		System.out.println();
//		tache = lireChaineNonVide("Tâche à ajouter ? ");
//		colonnes[0] = TableauChaines.ajouterElement(colonnes[0], tache);
//		
//		System.out.println();
//		afficherTableauKanban(intitules, colonnes);
		
		
		// Affichage Idéal
		
		// Simulation saisies
		Console.simulerSaisies("A faire", "En cours", "Terminée", "", 
								"1", "Lire l'énoncé de l'examen", 
								"1", "Coder les fonctions indispensables",
								"1", "Réaliser les tests unitaires",
								"1", "Coder la fonction main",
								"2", "lire",
								"2", "lire",
								"2", "lire",
								"2", "codr",
								"2", "coder",
								"4",
								"3");
	
		// Variables
		int stepIndex = 0;
		String title;
		String tache;
		final String MENU = "MENU";
		final String MENU_1 = "1. Ajouter une tâche";
		final String MENU_2 = "2. Faire progresser une tâche";
		final String MENU_3 = "3. Quitter";
		
		// Traitement + Acquisition + Affichage
		
		// Création des titres de chaque colonne du Kanban
		do {
			title = Console.lireString("Etape #" + (stepIndex+1) + " ('Entrée' pour terminer) ? ").toUpperCase().trim();
			
			if(title.isEmpty()) {
				break;
			}
			
			intitules = TableauChaines.ajouterElement(intitules, title);
			stepIndex++;
			
		} while (true);
		
		System.out.println();
		
		// Menu et actions
		String choix;
		do {
			System.out.println(MENU);
			System.out.println(MENU_1);
			System.out.println(MENU_2);
			System.out.println(MENU_3);
			
			choix = lireChaineNonVide("Choix ? ");
			System.out.println();
			
			switch (choix) {
				case "3" -> {
					break;
				}
				case "1" -> {
					tache = lireChaineNonVide("Tâche à ajouter ? ");
					colonnes[0] = TableauChaines.ajouterElement(colonnes[0], tache);
					System.out.println();
					afficherTableauKanban(intitules, colonnes);
				}
				case "2" -> {
					tache = lireChaineNonVide("Tâche à faire progresser ? ");
					int[] position = TableauChaines.positionDe(colonnes, tache);
					
					 if (position == null){
						System.out.println("Cette tâche n'existe pas !");
						System.out.println();
					} else if(position[0] == colonnes.length-1) {
						System.out.println("Cette tâche ne peut plus progresser !");
						System.out.println();
					} else {
						colonnes[position[0]+1] = TableauChaines.ajouterElement(colonnes[position[0]+1], colonnes[position[0]][position[1]]);
						colonnes[position[0]] = TableauChaines.retirerElement(colonnes[position[0]], position[1]);
						System.out.println();
						afficherTableauKanban(intitules, colonnes);
					}
				}
				default ->	{
					System.out.println("Choix inccorect !");
					System.out.println();
				}
			}

		} while (!choix.equals("3"));
			
		System.out.println("Fin du programme.");
		
	}

	/**
	 * affiche un tableau de type kanban.
	 * @param intitules : tableau contenant les intitulés des colonnes du tableau kanban.
	 * @param colonnes : tableau contenant les tâches organisées par état d’avancement.
	 */
	public static void afficherTableauKanban(String[] intitules, String[][] colonnes) {
		
		for (int i = 0; i < intitules.length; i++) {
			System.out.println(intitules[i] + " : ");
			
			if(colonnes[i].length == 0) {
				System.out.println("(vide)");
			} else {
				for (int j = 0; j < colonnes[i].length; j++) {
					System.out.println("- " + colonnes[i][j]);
				}
			}
			System.out.println();
		}
	}
	
	/**
	 * effectue l’acquisition sécurisée d’une chaîne de caractères.
	 * @param question :  chaîne de caractères à afficher en guise de question pour spécifier la valeur que doit saisir l’utilisateur.
	 * @return string sécurisée.
	 */
	public static String lireChaineNonVide(String question) {
		String result;
		do {
			result = Console.lireString(question).trim();
		} while (result.isEmpty());
		
		return result;
	}
	
	
}
