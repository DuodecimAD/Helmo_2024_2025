package algo.labo03.remplacement;

import java.util.Arrays;
import java.util.Map;

public class RemplacementMot {

	/*
	 * Voici comment vous pouvez facilement créer un dictionnaire : l'interface Map contient des méthodes de fabrique statique:
	 * - ofEntries
	 * - entry
	 * Je vous laisse lire la doc pour en savoir plus.
	 */
//	Map<String, String> dictionnaire = Map.ofEntries(
//			Map.entry("madame", "monsieur"),
//			Map.entry("voiture", "train"),
//			Map.entry("magic", "yugioh"),
//			Map.entry("coca-cola", "café noir"),
//			Map.entry("ocarina", "masque")
//			);
	
	Map<String, String> dictionnaire = Map.ofEntries(
			Map.entry("jour", " « Ap"),
			Map.entry("maman", "petit» "),
			Map.entry("appetit", " anniversaire")
			);

public String switchWords(String str) {
		
		if(!str.contains("«")) {
			return str;
		}
		
		String wordFound = str.matches("« ?[a-zA-Z-]+ ?»");
//		String[] array = str.split("« ?| ?»");
		
		String newString = "";
		
//		for (int i = 0; i < array.length; i++) {
//			if(array[i].charAt(0) == '«' && array[i].charAt(array.length-1) == '»') {
//				array[i] = array[i].substring(1, array[i].length()-1).trim();
//				array[i] = dictionnaire.get(array[i]);
//			}
//			newString += array[i];
//		}
		
		for (int i = 0; i < array.length; i++) {
			if(array[i].charAt(0) != ' ' && array[i].charAt(array[i].length()-1) != ' ') {
				array[i] = dictionnaire.get(array[i]);
			}
			newString += array[i];
		}
		
		System.out.println(newString);
		
		return switchWords(newString);
		
	}
	
	
//	public String switchWords(String str) {
//		
//		int first = str.indexOf("«");
//		if(first == -1) {
//			return str;
//		}
//		int last = str.indexOf("»");
//		
//		int secondFirst = str.indexOf("«", first+1);
//		if(secondFirst != -1) {
//			if(secondFirst < last) {
//				first = secondFirst;
//			}
//		}
//		
//		
//		String word = str.substring(first+2, last-1);
//		
//		String newWord = dictionnaire.get(word);
//		
//		String newString = str.substring(0, first) + " " + newWord + " " + str.substring(first + word.length() + 4); // "«", " ", " ", "»"
//		
//		System.out.println(newString);
//		
//		return switchWords(newString);
//		
//	}

	public static void main(String[] args) {
		
		RemplacementMot test = new RemplacementMot();
		
		String str = "Bonjour « madame », avez vous du « coca-cola » ? Il m'en faut pour jouer à « magic »";
//		String str = "Bon«jour»« Maman »";
		
		test.switchWords(str);

	}
}
