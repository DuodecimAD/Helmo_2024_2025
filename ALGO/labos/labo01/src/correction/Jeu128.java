package correction;

public class Jeu128 {

	/**
	 * Implémente la fonction de l'énoncé A.
	 * 
	 * Préconditions : tableau rempli de puissances de 2 (2, 4, 8) et 0, 
	 *                 taille du tableau >= 0 (d'office)
	 *
	 * Postconditions :
	 * Ce qui doit être conservé :
	 *    -> la somme des élément dans le tableau est identique à la somme des 
	 *       éléments du tableau initial :
	 *			somme(valeurs) = somme(valeurs_init).
	 *		 (Vous pouvez utiliser la notation math (Σ) si vous aimez)
	 *
	 * Ce qui doit être modifié :
	 * 1. Compactage
	 *    Il n'y a plus d'espace entre les cases non-nulles et le bord gauche 
	 *    (resp. droit) si décalage à gauche (droite).
	 *    Signification de « resp. » : voir https://fr.wiktionary.org/wiki/resp.
	 * 2. Décrire la fusion de deux cases successives (que ce soit en Français 
	 *    ou en mathématique, ce sera difficile à expliquer, c'est normal : 
	 *    c'est complexe)
	 *    Pour le décalage vers la gauche : 
	 *       « après le compactage, certaines valeurs identiques adjacentes sont
	 *         fusionnées : comme si on inspectait chaque valeur de la gauche 
	 *         vers la droite et que si à une position i et à une position i + 1,
	 *         valeurs[i] = valeurs[i + 1], alors valeur[i] est doublée et 
	 *         valeur[i + 1] devient 0. Une fois l'entièreté du tableau parcouru,
	 *         il est à nouveau compacté. »
	 *    NOTE : on décrit ici deux compactages, même si la fonction le fera en 
	 *           une seule passe.
	 *           
	 *    (Pour aller plus loin : exprimer ceci en mathématique demanderait
	 *    d'utiliser la récursion (voir cours de math). Si vous voulez vous y 
	 *    atteler, vous pouvez envoyer un mail avec votre proposition de 
	 *    solution : <a>mailto:s.lienardy@helmo.be</a>)
	 *
	 * @param valeurs le tableau de valeurs à traiter
	 * @param aGauche vrai ssi les valeurs doivent être bougées vers la gauche.
	 */
	public static void mouvement(int[] valeurs, boolean aGauche) {
		if(valeurs.length == 0)
			return;

		if(aGauche)
			mouvement_gauche(valeurs);
		else
			mouvement_droite(valeurs);
	}

	private static void mouvement_gauche(int[] valeurs) {
		/* Le Comment ?


				      |          |posLibre   |i        |Len
			valeurs : |2424228244|___________|___4___2_|
				       "compacté"   libres

			fusionne : vrai si la case en posLibre-1 est le résultat d'une fusion
			posLibre : première position libre où doit venir la case
				   i : variable de parcours du tableau
				     ⚠️ toutes les cases dans [posLibre .. i-1] sont libres
				     Remarque : si i = posLibre, la zone est vide

			Que faire en fonction de valeurs[i] : 
				- 0 ne rien faire (inc. i)
				- autre chiffre :
				  	si = à valeurs[posLibre-1] et fusionne faux -> doubler valeurs[posLibre-1] et valeurs[i] à zéro
				    sinon : swap(posLibre, i), inc posLibre

				Dans tous les cas, incrémenter i
				
			Quand modifier fusionne ?
				- mettre à true après une fusion
				- remettre à false dans les autres cas
		 */
		// INITIALISATION : pas de fusion, posLibre et i en début de tableau
		int posLibre = 0;
		int i = 0;
		boolean fusionne = false;
		// CONDITION D'ARRET : débordement du tableau (i >= valeurs.length)
		// GARDIEN : i < valeurs.length
		while(i < valeurs.length) {
			// CORPS : voir section « COMMENT »
			if(valeurs[i] != 0) {
				if(posLibre > 0 && !fusionne && valeurs[posLibre - 1] == valeurs[i]) {
					valeurs[i] = 0;
					valeurs[posLibre - 1] *= 2; // Fusion !
					fusionne = true; // On vient de fusionner
				} else {
					permuter(valeurs, posLibre, i);
					posLibre++; // Puisqu'on vient de positionner un chiffre 
								// dans la case posLibre, c'est sûr qu'il faut
								// l'incrémenter pour qu'il référence toujours 
					 			// le prochain espace libre (si posLibre < i)
					fusionne = false; // À l'évidence, on n'a pas fusionné.
				}
			} else {
				fusionne = false; // À l'évidence, on n'a pas fusionné.
			}
			++i;
		}
		// FIN ? Il n'y a rien à faire !
	}

	private static void mouvement_droite(int[] valeurs) {
		// C'est pas « opti », mais ça fonctionne !
		reverse(valeurs);
		mouvement_gauche(valeurs);
		reverse(valeurs);
	}

	/**
	 * Permute deux cases d'un tableau
	 * @param tableau le tableau à permuter
	 * @param i une position valide dans le tableau 
	 * @param j une position valide dans le tableau 
	 */
	private static void permuter(int[] tableau, int i, int j) {
		int tmp = tableau[i];
		tableau[i] = tableau[j];
		tableau[j] = tmp;
	}

	/**
	 * Inverse le contenu d'un tableau
	 * @param planche le tableau à inverser
	 */
	private static void reverse(int[] ligne) {
		int len = ligne.length - 1;
		for (int i = 0; i <= len; i++, len--) {
			permuter(ligne, i, len);
		}
	}
}
