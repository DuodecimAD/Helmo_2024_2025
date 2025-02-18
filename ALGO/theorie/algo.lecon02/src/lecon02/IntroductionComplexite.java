package lecon02;

import java.util.StringJoiner;

import io.Console;
import io.Fichiers;
import time.Timer;

public class IntroductionComplexite {

	private static int count = 3;
	private static final int COUNT_START = 0;
	private static final int COUNT_STOP = 100000;
	private static final int COUNT_STEP = 10000;
	private static final String MENU = """
			\nChoix ?
			1 – Comparaison des exemples 1 et 2
			2 - Tabultation de « exemple1 »
			3 - Tabultation de « exemple2 »
			Autre – Quitter
			""";
	private static final int QUITTER = 4;

	private static String[] lignes = Fichiers.lireCSV("data/pokemon.csv");

	public static void main(String[] args) {

		int choice;
		do {
			choice = Console.lireInt(MENU);
			switch (choice) {
			case 1 -> {
				count = Console.lireInt("Nombre d'itérations ?");
				/* Ne faites pas attention à la notation Classe::méthode pour l'instant
				 * En gros, on passe la référence à une autre fonction qui contrôle 
				 * exactement quand l'appeler et mesure précisément son temps d'exécution.
				 * Plus d'info en Bloc 2 sur cette syntaxe ! */
				Timer.printExecutionTimeWithTitle(IntroductionComplexite::exemple1, "Exemple 1");
				Timer.printExecutionTimeWithTitle(IntroductionComplexite::exemple2, "Exemple 2");
			}
			case 2 -> tabulateExemple1();
			case 3 -> tabulateExemple2();
			default -> {
				System.out.println("Fin.");
				choice = QUITTER;
			}
			}
		} while(choice != QUITTER);
	}

	private static String exemple1() {
		StringJoiner sj = new StringJoiner("");
		for (int i = 0; i < count; i++) {
			String s = lignes[i % lignes.length];
			sj.add(s.split(",")[1]);
		}
		return sj.toString();
	}

	private static String exemple2() {
		String result = "";
		for (int i = 0; i < count; i++) {
			String s = lignes[i % lignes.length];
			result += s.split(",")[1];
		}
		return result;
	}

	private static void tabulateExemple1() {
		for(count = COUNT_START; count <= COUNT_STOP; count += COUNT_STEP) {
			System.out.print(count + ", ");
			Timer.printExecutionTime(IntroductionComplexite::exemple1);
			System.out.println();
		}
	}

	private static void tabulateExemple2() {
		for(count = COUNT_START; count <= COUNT_STOP; count += COUNT_STEP) {
			System.out.print(count + ", ");
			Timer.printExecutionTime(IntroductionComplexite::exemple2);
			System.out.println();
		}
	}
}
