package correction;

import java.util.Objects;
import java.util.Set;

public class PierreQuiRoule {

	public static final char MUR = '#';
	public static final char PIERRE = 'O';
	public static final char VIDE = ' ';
	private static final Set<Character> AUTORISES = 
			Set.of(MUR, PIERRE, VIDE); // Voir Thème 2 :-)

	/**
	 * Crée une planche qui respecte les règles des planches
	 * @param source Une chaine de caractère
	 * @return Un tableau de char qui contient les caractères de la chaine, aux 
	 * même positions s'ils sont autorisés (dans {'#', ' ', 'O'}). Les 
	 * caractères non autorisés sont remplacés par ' '.
	 */
	public static char[] nouvellePlanche(String source) {
		char[] planche = new char[Objects.requireNonNullElse(source,"").length()];
		for (int i = 0; i < planche.length; i++) {
			planche[i] = AUTORISES.contains(source.charAt(i)) ? 
					source.charAt(i) : VIDE;
		}
		return planche;
	}

	/**
	 * Implémente la fonction de l'énoncé B.
	 * Précondition : la planche ne contient que des MUR, PIERRE ou VIDE.
	 * On supposera que la précondition est respectée.
	 * Pour faciliter les tests et manip, j'ajoute une méthode de création de
	 * planche valide
	 * 
	 * Postcondition :
	 * Ce qui doit être conservé : 
	 * 1. Conservation des murs : les cases MUR ne peuvent pas se déplacer.
	 *    Pour toute position i, 
	 *       planche[i] = MUR si et seulement si planche_init[i] = MUR
	 *    (on ne crée pas de murs, on n'en supprime pas, on n'en déplace pas).
	 * 2. Conservation des éléments dans le tableau :
	 *    planche est une PERMUTATION du tableau initial.
	 * 3. Les rochers ne peuvent pas traverser les murs. 
	 *    // Ici, je vais exprimer que le nombre de rochers entre deux murs ne
	 *    // varie pas.
	 *    
	 *    Notation : nb_rochers(planche, debut, fin) le nombre de rochers dans 
	 *                                     le sous-tableau planche[debut, fin-1]
	 *    
	 *    Pour toutes les positions i, j telles que:
	 *                         i < j ET planche[i] == MUR ET planche[j] == MUR :
	 *       nb_rochers(planche_init, i, j) == nb_rochers(planche, i, j)
	 *       
	 *    Dit autrement : si dans le tabelau initial, il y a x rochers entre 2 
	 *    murs précis, on retrouve le même nombre x de rochers entre ces deux 
	 *    murs dans le tableau final. (Je ne récise pas que les deux murs dont 
	 *    je parle doivent être proches, parce que ce n'est pas nécessaire)
	 *       
	 * Ce qui doit être modifié:
	 * ⚠️ On se concentre sur le QUOI et pas le COMMENT !
	 * 1. Dans le tableau final, il n'y a pas d'espace entre deux rochers
	 *    (à moins qu'il n'y ait aussi un mur entre eux).
	 * 2. Si aGauche est vrai : il n'y pas d'espace entre un rocher et le 
	 *    premier mur qui se trouve à sa gauche (le bord gauche de la planche si
	 *    ce mur n'existe pas)
	 * 3. Si aGauche est faux : il n'y pas d'espace entre un rocher et le 
	 *    premier mur qui se trouve à sa droite (le bord droit de la planche si
	 *    ce mur n'existe pas)
	 * 
	 * @param planche une planche (tableau de char composés de MUR, PIERRE ou 
	 *        cases VIDE).
	 * @param aGauche vrai ssi la planche penche vers la gauche.
	 */
	public static void penche(char[] planche, boolean aGauche) {
		// Précondition (supposée OK)
		if(planche.length == 0)
			return;
		
		if(aGauche)
			penche_gauche(planche);
		else
			penche_droite(planche);
	}

	private static void penche_gauche(char[] planche) {
		/* Le COMMENT :

                     |          |posLibre  |i            |Len
           planche : |OOO__#OOOO|__________|___O_O_#__OOO|

           posLibre : première position libre où doit venir le 'O'.
                  i : variable de parcours du tableau
             /!\ toutes les cases dans [posLibre .. i-1] sont libres

             planche[i] : 3 possibilités
               ' ' : ne rien faire, sinon incrémenter i.
               'O' : permuter ce rocher avec une position libre 
                      + incrémenter posLibre et i après
               '#' : décaler la position libre au premier VIDE qui suit ce mur.
		 */
		// INITIALISATION : posLibre et i complètement à gauche
		int posLibre = indexOf(planche, VIDE, 0);
		int i = posLibre + 1;
		// CONDITION ARRET : arrêt si fin de planche ou déborde (i >= planche.length)
		// GARDIEN !(i >= planche.length) <=> i < planche.length
		while(i < planche.length) {
			// CORPS : voir section « COMMENT »
			switch(planche[i]) {
			case PIERRE -> {
				permuter(planche, i, posLibre);
				posLibre++;
				i++;
			}
			case VIDE -> i++;
			case MUR -> {
				posLibre = indexOf(planche, VIDE, i);
				i = posLibre + 1;
			}
			}
		}
		// FIN ? Il n'y a rien à faire !
	}

	/**
	 * Permute deux cases d'un tableau
	 * @param tableau le tableau à permuter
	 * @param i une position valide dans le tableau 
	 * @param j une position valide dans le tableau 
	 */
	private static void permuter(char[] tableau, int i, int j) {
		char tmp = tableau[i];
		tableau[i] = tableau[j];
		tableau[j] = tmp;
	}

	/**
	 * Recherche une valeur dans un tableau, à partir de fromIndex
	 * @param array un tableau
	 * @param ch la valeur recherchée
	 * @param fromIndex l'indice à partir duquel rechercher
	 * @return si ch appartient à array[fromIndex length-1], l'indice i minimum
	 * 			tel que fromIndex <= i < length et array[i] == ch.
	 *         si ch n'appartient pas à array, retourne length.
	 */
	private static int indexOf(char[] array, char ch, int fromIndex) {
		Objects.checkIndex(fromIndex, array.length);
		int i = fromIndex;

		while (i < array.length && array[i] != ch)
			++i;

		return i;
	}

	private static void penche_droite(char[] planche) {
		/* Pas franchement optimal, mais pourquoi pas ? */
		reverse(planche);
		penche_gauche(planche);
		reverse(planche);
	}

	/**
	 * Inverse le contenu d'un tableau
	 * @param planche le tableau à inverser
	 */
	private static void reverse(char[] planche) {
		int len = planche.length - 1;
		for (int i = 0; i <= len; i++, len--) {
			permuter(planche, i, len);
		}
	}
}
