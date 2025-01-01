package jeuxolympiques;

import io.Console;
import util.TableauCaracteres;
import util.TableauEntiers;

public class SautHauteur {

	public static void main(String[] args) {

		// Exemple Version idéale à décommenter si lazy :D
		Console.simulerSaisies("169", "229", "n", "229", "N", "219", "229", "0", "o", "229", "231", "o", 
								"233", "n", "233", "n", "234", "o", "237", "n", "238", "n", "238", "n"
								);

		// Variables
		String hauteurSaut, sautReussi = "";
		int lastHauteur = 0;
		

		// Tableaux
		int[] hauteurs = {};
		char[][] resultsPourHauteur = {};

		do {
			// récupère hauteur
			boolean maxTries;
			do {
				maxTries = false;
				hauteurSaut = Console.lireString("Hauteur du saut (en cm) ? ").trim();
				
				if(hauteurs.length > 0) {
					boolean sameHauteurTest = Integer.parseInt(hauteurSaut) == hauteurs[hauteurs.length-1];
					boolean troisEssaisPourHauteur = resultsPourHauteur[resultsPourHauteur.length-1].length == 3;
					
					if(sameHauteurTest && troisEssaisPourHauteur) {
						maxTries = true;
					}
				}
				
			} while (
					!hauteurSaut.matches("[0-9]+") 
					|| Integer.parseInt(hauteurSaut) < 170 
					|| Integer.parseInt(hauteurSaut) < lastHauteur
					|| maxTries
					);

			// au premier tour, ajout de la 1ere hauteur et creation de la premiere ligne dans tableau 2d
			if(hauteurs.length == 0) {
				hauteurs = TableauEntiers.ajouterElement(hauteurs, Integer.parseInt(hauteurSaut));
				
				// on ajoute une nouvelle ligne au tableau 2D
				resultsPourHauteur = TableauCaracteres.ajouterLigne(resultsPourHauteur, new char[]{});
			}
			
			// check si la hauteur est deja dans le tableau des hauteurs
			boolean hauteurExiste = false;
			for (int i = 0; i < hauteurs.length; i++) {
				if(Integer.parseInt(hauteurSaut) == hauteurs[i]) {
					hauteurExiste = true;
					break;
				}
			}
			
			// si hauteur n'est pas dans le tableau on l'ajoute
			if(!hauteurExiste) {
				hauteurs = TableauEntiers.ajouterElement(hauteurs, Integer.parseInt(hauteurSaut));
				
				// on ajoute une nouvelle ligne au tableau 2D
				resultsPourHauteur = TableauCaracteres.ajouterLigne(resultsPourHauteur, new char[]{});
			}
			
			// garde en memoire hauteur du saut precedent pour eviter sortir boucle si next saut est en dessous
			lastHauteur = hauteurs[hauteurs.length-1];
			
			// récupère saut réussi ou raté
			do {
				sautReussi = Console.lireString("Saut réussi : (o)ui, (n)on ? ").trim().toUpperCase();
			} while (!sautReussi.matches("[ON]"));

			// Si saut raté, ajout de X
			if (sautReussi.charAt(0) == 'N') {
				sautReussi = "X";
			}
			
			resultsPourHauteur[hauteurs.length-1] = TableauCaracteres.ajouterElement(resultsPourHauteur[hauteurs.length-1], sautReussi.charAt(0));		
			
			
			// Affichage
			afficherSauts(hauteurs, resultsPourHauteur);
			
			char[] oneDimension = TableauCaracteres.enUneDimension(resultsPourHauteur);
			
			int lastReussi = TableauCaracteres.dernierePositionDe(oneDimension, 'O');
			
			if (((oneDimension.length-1) - lastReussi) >= 3) {
				break;
			}
			
		} while (true);

		// affichage de fin
		System.out.println("L'épreuve est terminée pour cet athlète.");

	}

	/**
	 * produit en console une vue d’ensemble des sauts effectués par un athlète
	 * 
	 * @param hauteursSautsEnCm  : désigne le tableau répertoriant les hauteurs des
	 *                           sauts déjà effectués
	 * @param indicateursParSaut : désigne le tableau répertoriant les indicateurs
	 *                           de réussite/échec correspondant aux hauteurs du
	 *                           tableau hauteursSautsEnCm
	 */
	public static void afficherSauts(int[] hauteursSautsEnCm, char[][] indicateursParSaut) {

		for (int i = 0; i < hauteursSautsEnCm.length; i++) {
			String cm = Integer.toString(hauteursSautsEnCm[i]);
			String m = cm.substring(0, 1) + "m" + cm.substring(1, 2) + cm.substring(2, 3);

			System.out.print(m + " : ");
			for (int j = 0; j < indicateursParSaut[i].length; j++) {
				if (j != 0) {
					System.out.print(" ");
				}
				System.out.print(indicateursParSaut[i][j]);
			}
			System.out.println();
		}
		System.out.println();

	}

}
