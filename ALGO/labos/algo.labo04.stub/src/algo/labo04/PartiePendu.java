package algo.labo04;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

import io.Console;

/**
 * Gère une partie de pendu.
 * 
 * <p>Responsabilités :
 * <ul>
 * 		<li> Connait les règles du Pendu
 * </ul>
 * 
 * <p>Collaborateurs :
 * <ul>
 * 		<li> Console pour les entrées utilisateurs
 * 		<li> Mot pour les opérations concernant les lettres
 * 		<li> Potence pour l'affichage de l'état de la partie
 * 		<li> Une Collection pour retenir les lettres déjà jouées
 * </ul>
 */
public class PartiePendu {

	private static final String BRAVO = "Bravo !";
	private static final String DEJA_JOUEE = "Cette lettre a déjé été jouée !";
	private static final String DOMMAGE = "Dommage, le mot était : ";
	private static final String Q_LETTRE = "Lettre ? ";

	private final Mot mot;
	private final Set<Character> dejaJoues; 
	private Potence potence;

	/**
	 * Constructeur
	 * @param motCorrect une chaine non null.
	 */
	private PartiePendu(final String motCorrect) {
		dejaJoues = new HashSet<>();
		mot = Mot.aDeviner(motCorrect);
		potence = Potence.BOIS;
	}

	/**
	 * Crée et renvoie une nouvelle partie
	 * @param motCorrect la réponse souhaitée à la partie.
	 * @return une nouvelle partie de Pendu
	 * @throws NullPointerException si motCorrect est null
	 */
	public static PartiePendu nouvellePartie(final String motCorrect) {		
		return new PartiePendu(Objects.requireNonNull(motCorrect));
	}

	/**
	 * Joue une partie de Pendu via l'entrée et la sortie standard.
	 */
	public void jouer() {

		do {
			afficherPartie();
			char joue = demanderLettre();
			tenirCompteLettre(joue);
		} while(!estFinie());

		afficherFinPartie();
	}

	/**
	 * Affiche la partie.
	 * L'affichage comporte :
	 * <ol>
	 * 		<li> Une potence (= l'instrument de torture qui permet la pendaison)
	 * 		<li> Le mot en train d'être deviné. Les caractères inconnus sont représentés par le symbole INCONNU.
	 * 		<li> Les lettres qui ont déjà été jouées par le joueurs.
	 * </ol> 
	 */
	private void afficherPartie() {
		System.out.println(potence.enImage());
		System.out.println(mot.partiel());
		System.out.println("Lettres jouées : " + dejaJoues);
	}

	/**
	 * @return la lettre que le joueur souhaite jouer.
	 */
	private char demanderLettre() {
		return Console.lireChar(Q_LETTRE);
	}

	/**
	 * Modifie l'état de la partie à la suite de la proposition d'une lettre
	 * <ul>
	 * 		<li> Si la lettre a déjà été proposée, ne fais rien ;
	 * 		<li> Si la lettre n'a pas été proposée,
	 * 		<ul>
	 * 			<li> On retient la proposition ;
	 * 			<li> On complète le dessin de la potence si la lettre était incorrecte ;
	 * 			<li> On complète le mot en train d'être deviné à toutes les positions où apparait la proposition.
	 * 		</ul>
	 * </ul>
	 * @param proposee lettre proposée par le joueur.
	 */
	private void tenirCompteLettre(final char proposee) {
		if (dejaJoues.contains(proposee)) {
			System.out.println(DEJA_JOUEE);
		} else {
			dejaJoues.add(proposee);
			if (!mot.contientLettre(proposee))
				potence = potence.suivante();
		}
	}

	/**
	 * Affiche la fin de la partie.
	 * Identique à l'affichage en cours de partie, auquel on ajoute une phrase de conclusion, contenant la bonne
	 * réponse en cas de partie perdue.
	 * @see afficherPartie
	 */
	private void afficherFinPartie() {
		afficherPartie();
		if (mot.estRempli()) {
			System.out.println(BRAVO);
		} else {
			System.out.println(DOMMAGE + mot.correct());
		}
		System.out.println();
	}

	/**
	 * @return vrai ssi la partie est finie (= la potence représente un homme pendu ou le mot est complètement
	 * découvert).
	 */
	private boolean estFinie() {
		return potence == Potence.PENDU || mot.estRempli();
	}
}
