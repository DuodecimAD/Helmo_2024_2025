package algo.labo03.remplacement;

import java.util.Map;

public class RemplacementMot {

	/*
	 * Voici comment vous pouvez facilement créer un dictionnaire : l'interface Map contient des méthodes de fabrique statique:
	 * - ofEntries
	 * - entry
	 * Je vous laisse lire la doc pour en savoir plus.
	 */
	Map<String, String> dictionnaire = Map.ofEntries(
			Map.entry("madame", "monsieur"),
			Map.entry("voiture", "train"),
			Map.entry("magic", "yugioh"),
			Map.entry("coca-cola", "café noir"),
			Map.entry("ocarina", "masque")
			);
}
