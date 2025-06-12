package algo.labo03.remplacement;

import java.util.Arrays;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		
		Pattern pattern = Pattern.compile("« ?([a-zA-Z-]+) ?»");
        Matcher matcher = pattern.matcher(str);

        matcher.find();
        String matchedWord = matcher.group(1).toLowerCase();
        System.out.println("Found: " + matchedWord);

        str = matcher.replaceFirst(dictionnaire.get(matchedWord));
        
		
		System.out.println(str);
		return switchWords(str);
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
		
//		String str = "Bonjour « madame », avez vous du « coca-cola » ? Il m'en faut pour jouer à « magic »";
		String str = "Bon«jour»« Maman »";
		
		test.switchWords(str);

	}
}
