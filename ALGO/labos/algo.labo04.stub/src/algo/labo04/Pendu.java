package algo.labo04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import io.Console;
import io.LecteurFichier;

/**
 * Implémente le programme final.
 */
public class Pendu {

	public static final String AU_REVOIR = "Au revoir.";
	public static final String DEBUG_OFF = "Mode debug éteint";
	public static final String DEBUG_ON = "Mode debug activé";
	public static final String MENU = """
			== Jeu du Pendu ==
			1. Commencer une nouvelle partie
			2. (Dés)Activer le mode « debug »
			3. Quitter
			Votre choix ? 
			""";

	private static boolean debug = false;
	
	/**
	 * Afficher le menu et exécute le comportement correspondant.
	 * @param args (inutilsé ici)
	 */
	public static void main(String[] args) {

		List<String> collectionMots = new ArrayList<String>();
		
		/* Autodocumentant : lit depuis le fichier dans la liste. */
		LecteurFichier.depuis("data/mots.txt").dans(collectionMots);
		
		Collections.shuffle(collectionMots);
		
		boolean fini = false;

		do {
			switch(Console.lireInt(MENU)) {
				case 1  -> jouerUnePartie(collectionMots);
				case 2  -> inverserModeDebug();
				default -> fini = true;
			}
		} while(!fini);

		auRevoir();
	}

	/**
	 * Active ou désactive le mode « debug » en affichant un message.
	 */
	private static void inverserModeDebug() {
		System.out.println((debug = !debug) ? DEBUG_ON : DEBUG_OFF);
	}

	/**
	 * Lance une nouvelle partie de pendu en choisissant un mot au hasard dans une 
	 * liste.
	 * @param mots une liste de mots parmi lesquels piocher.
	 */
	private static void jouerUnePartie(final List<String> mots) {
		
		/* Sélectionne un mot dans la liste et le retire pour ne pas proposer deux fois
		 * le même mot */
		String motAleatoire = mots.get(mots.size()-1);
		mots.remove(mots.size()-1);
		if (debug) {
			System.err.println(motAleatoire);
		}
		
		PartiePendu partie = PartiePendu.nouvellePartie(motAleatoire);
		partie.jouer();
	}

	/**
	 * Affiche un message à la fin du programme.
	 */
	private static void auRevoir() {
		System.out.println(AU_REVOIR);
	}
}
