package algo.labo03.queue;

import java.util.Deque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;


public class PracticeQueue {

	/**
	 * Renvoie vrai si les deux files q1 et q2 ont le même contenu (mêmes éléments dans le même ordre)
	 * 
	 * N'oubliez pas d'implémenter les propriétés suivantes (de java.lang.Object) :
	 * - Réflexivité  (une file est égale à elle-même)
	 * - Transitivité (deux files égales à une même troisième sont égales entre elles)
	 * - Symétrie (une file égale à une autre 
	 * - Consistence (l'égalité ne doit pas changer tant qu'une des deux files n'est pas modifiée) 
	 * - Inégalité à null (une file et null ne sont pas égales)
	 * 
	 * @see Object Rappel des propriétés générales de equals
	 * @see java.util.Queue Pourquoi q1.equals(q2) ne fonctionnera pas ici ?
	 * @param q1 une première file
	 * @param q2 une seconde file
	 * @return vrai si la file 1 et la file 2 ont le même contenu.
	 * 🌟 : 1
	 */
	public static boolean equals(final Queue<Integer> q1, final Queue<Integer> q2) {
		return false; // FIXME
	}
	
	/**
	 * Filtre tous les éléments de la file et ne laisse que les éléments pairs.
	 * Ces éléments doivent rester dans le même ordre.
	 * @param input
	 * @return
	 * 🌟 : 1
	 */
	public static Queue<Integer> even(final Queue<Integer> queue) {
		return null; // FIXME
	}
	
	/**
	 * Filtre tous les éléments de la file et ne laisse qu'une seule occurrence des éléments.
	 * @param queue
	 * @return
	 * 🌟 : 2
	 */
	public static Queue<String> unique(final Queue<String> queue) {
		return null; // FIXME
	}
}
