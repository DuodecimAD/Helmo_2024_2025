package time;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Supplier;

public class Timer {

	private static final String PRETTY_TIME_OUTPUT_FMT = "Temps écoulé : %d ns\n";
	private static final String TIME_OUTPUT_FMT = "%d";

	/**
	 * Imprime le temps d'exécution d'une fonction.</br>
	 * 
	 * Format de sortie :</br>
	 * Titre</br>
	 * La « Taille du résultat », inférée en appelant <code>toString().length()</code> sur 
	 * l'instance de T produite.</br>
	 * Le temps d'exécution</br>
	 * 
	 * @param <T> Le type produit par la fonction
	 * @param function Une fonction produisant une valeur et ne prenant pas de paramètre
	 * @param title Le titre à afficher sur la sortie standard.
	 */
	public static <T> void printExecutionTimeWithTitle(Supplier<T> function, String title) {
		System.out.println(title);
		Instant before = Instant.now();
		var res = function.get();
		Instant after = Instant.now();
		System.out.println(res.toString().length());
		printReadableDuration(Duration.between(before, after));
	}
	
	/**
	 * Imprime le temps d'exécution d'une fonction.</br>
	 * 
	 * Format de sortie :</br>
	 * Titre</br>
	 * La « Taille du résultat », inférée en appelant <code>toString().length()</code> sur 
	 * l'instance de T produite.</br>
	 * Le temps d'exécution</br>
	 * 
	 * @param <T> Le type produit par la fonction
	 * @param function Une fonction produisant une valeur et ne prenant pas de paramètre
	 * @param title Le titre à afficher sur la sortie standard.
	 */
	public static <T> void printExecutionTime(Supplier<T> function) {
		Instant before = Instant.now();
		function.get();
		Instant after = Instant.now();
		printDuration(Duration.between(before, after));
	}
	
	private static void printReadableDuration(Duration time) {
		System.out.printf(PRETTY_TIME_OUTPUT_FMT,
				time.toNanos());
	}
	
	private static void printDuration(Duration time) {
		System.out.printf(TIME_OUTPUT_FMT,
				time.toMillis());
	}
}
