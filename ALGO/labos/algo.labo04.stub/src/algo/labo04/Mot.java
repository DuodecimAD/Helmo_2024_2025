package algo.labo04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.List;

/**
 * Classe qui gère toutes les opérations concernant un mot dans le jeu du Pendu.
 * 
 * <p>Responsabilités :
 * 	<ul>
 * 		<li> Connait ses lettres et leurs positions.
 * 		<li> Fournit une représentation des lettres découvertes jusqu'à présent.
 * 	</ul>
 */
public class Mot {

	/** Le caractère inconnu */
	public static final String INCONNU = "_";
	
	private static final List<Integer> ABSENT = List.of();
	
	/* Attributs */
	private final String reponse;
	private final StringBuilder motPartiel;
	private final Map<Character, List<Integer>> structure;
	private int nbTrous;
	
	/**
	 * Constructeur.
	 * @param reponse une reference non null de la réponse attendue.
	 */
	private Mot(final String reponse) {
		this.reponse = reponse.toUpperCase();
		nbTrous = reponse.length();
		motPartiel = new StringBuilder(INCONNU.repeat(nbTrous));
		structure = new HashMap<>();
		initialiserStructure();
	}
	
	/**
	 * Crée un mot dont les lettres sont à deviner
	 * @param reponse la réponse attendue
	 * @return un Mot dont le nombre de trous est égal au nombre de lettres dans 
	 * réponse.
	 * @throws NullPointerException si reponse est une référence null
	 */
	public static Mot aDeviner(final String reponse) {
		return new Mot(Objects.requireNonNull(reponse));
	}
	
	/**
	 * @return vrai ssi le mot a été complètement trouvé et ne contient plus
	 * de caractères inconnus.
	 */
	public boolean estRempli() {
		return nbTrous == 0;
	}
	
	/**
	 * Détermine si une lettre fait partie du mot. Si c'est le cas, met à jour la
	 * représentation du mot.
	 * 
	 * @param lettre une lettre jouée, la casse n'importe pas.
	 * @return vrai ssi la lettre fait partie du mot à deviner.
	 */
	public boolean contientLettre(final char lettre) {
		char majuscule = Character.toUpperCase(lettre);
		Character cle = Character.valueOf(majuscule);
		
		for(int pos : structure.getOrDefault(cle, ABSENT)) {
			if (motPartiel.charAt(pos) != majuscule) {
				motPartiel.setCharAt(pos, majuscule);
				nbTrous--;
			}
		}
		
		return structure.containsKey(cle);
	}
	

	/**
	 * @return le mot à deviner où les lettres qui n'ont pas encore été proposée sont
	 * remplacées par le caractère {@code Mot.INCONNU}.
	 */
	public String partiel() {
		return motPartiel.toString();
	}
	
	/**
	 * @return le mot correct, à deviner.
	 */
	public String correct() {
		return reponse;
	}
	
	/**
	 * Initialise la structure du mot.
	 * 
	 * <p>La structure est une {@code Map<Character, List<Integer>>}.
	 * Chaque clé caractère est mis en correspondance avec une liste de ses positions
	 * dans le mot reponse.
	 * 
	 * <p>Exemple :<br>
	 * Le mot « ANACONDA » créera le mapping suivant : 
	 * {A: [0, 2, 7], C: [3], D: [6], N: [1, 5], O: [4]}
	 */
	private void initialiserStructure() {
		for (int i = 0; i < reponse.length(); ++i) {
			char letter = reponse.charAt(i);
			structure.putIfAbsent(letter, new ArrayList<>());
			structure.get(letter).add(i);
		}
	}
}
