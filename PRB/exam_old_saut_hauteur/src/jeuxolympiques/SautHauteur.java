package jeuxolympiques;

import io.Console;
import util.TableauCaracteres;
import util.TableauEntiers;

public class SautHauteur {

	public static void main(String[] args) {
		
		// Exemple Version idéale à décommenter si lazy :D
		Console.simulerSaisies("169", "229", "n");
		
		// Variables
		String hauteurSaut = "", sautReussi = "";
		
		// Tableaux
		char[] sauts = new char[0];
		int[] hauteurs = new int[0];
		char[][] resultsPourHauteur = new char[1][3];
		
		do {
			// Acquisitions
			
			// récupère hauteur
			do {
				hauteurSaut = Console.lireString("Hauteur du saut (en cm) ? ").trim();
				
			} while (!hauteurSaut.matches("[0-9]+") || hauteurSaut.isEmpty() || (Integer.parseInt(hauteurSaut) < 170));
			
			// récupère saut réussi ou raté
			do {
				sautReussi = Console.lireString("Saut réussi : (o)ui, (n)on ? ").trim().toUpperCase();
			} while (!sautReussi.matches("[ON]"));
			
			// Si saut raté, ajout de X
			if(sautReussi.charAt(0) == 'N') {
				sautReussi = "X";
			}
			
			// Traitement
			// dois créer plein de brol en plus, ici pour tester si hauteur existe dans array de hauteurs
			boolean hauteurExiste = false;
			for (int i = 0; i < hauteurs.length; i++) {
				if(Integer.parseInt(hauteurSaut) == hauteurs[i]) {
					hauteurExiste = true;
				}
			}
				
			if(hauteurs.length >= 0 && !hauteurExiste) {
				hauteurs = TableauEntiers.ajouterElement(hauteurs, Integer.parseInt(hauteurSaut));
				sauts = new char[0];
			}
			
			// si un saut est réussi, on tente une nouvelle hauteur donc nouvelle ligne
			if (sautReussi.charAt(0) == 'O') {
				
				resultsPourHauteur =  TableauCaracteres.ajouterLigne(resultsPourHauteur, sauts);
			}
			
			if(sauts.length < 3) {
				sauts = TableauCaracteres.ajouterElement(sauts, sautReussi.charAt(0));
				// ajout de la tentative au tableau 2D dans le main vu que pas de methode pour 
				// ajouterElement à un tableau 2D ... trop bizarre
				
				// --------------------------------------------
				// PROB ICI QUAND ON PASSE A UNE NOUVELLE LIGNE
				// --------------------------------------------
				
				resultsPourHauteur[hauteurs.length-1][sauts.length-1] = sautReussi.charAt(0);
			
			}
			
			// Affichage
			afficherSauts(hauteurs, resultsPourHauteur);
			
			// Sort de la boucle si X X X
			if(resultsPourHauteur[resultsPourHauteur.length-1].length == 3) {
				int count = 0;
				for (int i = 0; i < sauts.length; i++) {
					if(sauts[i] == 'X') {
						count++;
					}
				}
				
				if(count == 3) {
					break;
				}
			}
		} while (true);
		
		// affichage de fin
		System.out.println("L'épreuve est terminée pour cet athlète.");
		
	}
	
	/**
	 * produit en console une vue d’ensemble des sauts effectués par un athlète
	 * 
	 * @param hauteursSautsEnCm : désigne le tableau répertoriant les hauteurs des sauts déjà effectués
	 * @param indicateursParSaut : désigne le tableau répertoriant les indicateurs de réussite/échec correspondant aux hauteurs du tableau hauteursSautsEnCm
	 */
	public static void afficherSauts(int[] hauteursSautsEnCm, char[][] indicateursParSaut) {
		
		for (int i = 0; i < hauteursSautsEnCm.length; i++) {
			String cm = Integer.toString(hauteursSautsEnCm[i]);
			String m = cm.substring(0,1) + "m" + cm.substring(1,2)  + cm.substring(2,3);
			
			System.out.print(m + " : ");
			for (int j = 0; j < indicateursParSaut[i].length; j++) {
				if(j != 0) {
					System.out.print(" ");
				}
				System.out.print(indicateursParSaut[i][j]);
			}
			System.out.println("\n");
		}
		
	}


}
