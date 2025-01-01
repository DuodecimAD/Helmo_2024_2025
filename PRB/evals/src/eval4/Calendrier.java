package eval4;

import java.util.Calendar;

public class Calendrier {

	public static void main(String[] args) {
		
		// Test 1
//		int[][] calendrier = Calendrier.calendrierMois(12, 2023);
//		System.out.println("  D   L   M   M   J   V   S");
//		for (int[] ligne : calendrier) {
//			System.out.printf("[%2d", ligne[0]);
//			for (int j = 1; j < ligne.length; j++) {
//				System.out.printf(", %2d", ligne[j]);
//			}
//			System.out.println("]");
//		}
		
		// Test 2
		int[][] calendrier = Calendrier.calendrierMois(2, 2024);
		System.out.println("  D   L   M   M   J   V   S");
		for (int[] ligne : calendrier) {
			System.out.printf("[%2d", ligne[0]);
			for (int j = 1; j < ligne.length; j++) {
				System.out.printf(", %2d", ligne[j]);
			}
			System.out.println("]");
		}
		
		
	}

	/**
	 * Crée un tableau à deux dimensions répertoriant les jours d'un mois à la
	 * manière d'un calendrier mensuel (chaque colonne correspondant à l'un des
	 * jours de la semaine).
	 * 
	 * @param mois  Le numéro du mois (entre 1 et 12).
	 * @param annee L'année du mois.
	 * @return le tableau répertoriant les jours du mois par jour de la semaine.
	 */
	public static int[][] calendrierMois(int mois, int annee) {
		
		int nbJoursDansMois = nombreJoursDansMois(mois, annee);
		int premierJourDuMois = premierJourDuMois(mois, annee);
		
		int jour = 1;
		
		int[][] calendrier = new int[6][7];
		
		for (int i = 0; i < calendrier.length; i++) {
			for (int j = 0; j < calendrier[i].length; j++) {
				if(i == 0 && (j+1) < premierJourDuMois) {
					calendrier[i][j] = 0;
				} else if (jour > nbJoursDansMois) {
					calendrier[i][j] = 0;
				} else {
					calendrier[i][j] = jour;
					jour++;
				}
			}
		}
		
		return calendrier;
	}

	/**
	 * Détermine le jour de la semaine correspondant au 1er jour du mois spécifié.
	 * 
	 * @param mois  Le numéro du mois (entre 1 et 12).
	 * @param annee L'année du mois.
	 * @return le numéro du jour de la semaine : 1 (DIMANCHE), 2 (LUNDI), 3 (MARDI),
	 *         4 (MERCREDI), 5 (JEUDI), 6 (VENDREDI) et 7 (SAMEDI).
	 */
	public static int premierJourDuMois(int mois, int annee) {
		Calendar calendrier = Calendar.getInstance();
		calendrier.set(Calendar.YEAR, annee);
		calendrier.set(Calendar.MONTH, mois - 1);
		calendrier.set(Calendar.DAY_OF_MONTH, 1);
		return calendrier.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * Détermine le nombre de jours du mois spécifié.
	 * 
	 * @param mois  Le numéro du mois (entre 1 et 12).
	 * @param annee L'année du mois.
	 * @return le nombre de jours du mois (entre 1 et 31).
	 */
	public static int nombreJoursDansMois(int mois, int annee) {
		Calendar calendrier = Calendar.getInstance();
		calendrier.set(Calendar.YEAR, annee);
		calendrier.set(Calendar.MONTH, mois - 1);
		calendrier.set(Calendar.DAY_OF_MONTH, 1);
		return calendrier.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	
}