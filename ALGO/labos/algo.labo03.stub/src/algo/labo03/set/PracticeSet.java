package algo.labo03.set;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;

public class PracticeSet {

	private static final Pattern WORD_DELIMITER = Pattern.compile("[\\p{Punct}\\p{Space}]+");
	
	/**
	 * Retourne l'ensemble qui contient les éléments de s1 et de s2 qui ne sont pas communs aux deux
	 * ensembles.
	 * Remplace une référence nulle par l'ensemble vide.
	 * 
	 * @implNote Utiliser un HashSet pour la classe concrète.
	 * @param s1 le premier ensemble
	 * @param s2 le second ensemble
	 * @return la différence symétrique des deux ensembles.
	 * 🌟 : 1
	 */
	public static Set<Integer> symetricDifference(final Set<Integer> s1,final Set<Integer> s2) {
		return null; // FIXME
	}
	
	/**
	 * Crée une liste de chaine de caractères de même longueur que la chaine candidate
	 * La chaine résultat en position i dépend de la valeur de candidate en position i :
	 * - "fizz" si l'ensemble fizz contient candidat[i]
	 * - "buzz" si l'ensemble buzz contient candidat[i]
	 * - "fizzbuzz" si les deux ensemblent contiennent candidat[i]
	 * - "candidat[i]" sinon
	 * 
	 * Exemple, fizz = {3, 5}; buzz = {1, 5} : 
	 * 
	 * (1, 2, 3, 5, 4) -> ("buzz", "2", "fizz", "fizzbuzz", "4")
	 * 
	 * @param candidates une chaine de nombre
	 * @param s1
	 * @param s2
	 * @return
	 * 🌟 : 1
	 */
	public static List<String> ultimateFizzBuzz(List<Integer> candidates, Set<Integer> fizz, Set<Integer> buzz) {
		return null; // FIXME
	}
	
	/**
	 * Retourne l'ensemble des mots de longueur maximale d'un texte donné en paramètre.
	 * Conseil : utiliser le Pattern wordDelimiter pour séparer les mots.
	 * 
	 * Attention, une chaine vide contiendra le mot vide !
	 * @param text
	 * @return
	 * 🌟 : 2
	 */
	public static Set<String> longestWords(String text) {
		return null; // FIXME
	}
}
