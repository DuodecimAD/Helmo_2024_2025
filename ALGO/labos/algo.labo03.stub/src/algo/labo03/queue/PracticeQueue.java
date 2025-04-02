package algo.labo03.queue;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
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
		if(q1 == null && q2 == null) {
			return true;
		} else if(q1 == null || q2 == null) {
			// Inégalité à null (une file et null ne sont pas égales)
			return false;
		} else if(q1.size() != q2.size()) {
			return false;
		} else if(q1.equals(q2)) {
			return true;
		} else if (q1.isEmpty() && q2.isEmpty()) {
			return true;
		}
		
		Iterator<Integer> it1 = q1.iterator();
		Iterator<Integer> it2 = q2.iterator();
		
		while (it1.hasNext()) {
			if(it1.next() != it2.next()) {
				return false;
			}
		}

		return true; 
	}
	
	
	
	/**
	 * Filtre tous les éléments de la file et ne laisse que les éléments pairs.
	 * Ces éléments doivent rester dans le même ordre.
	 * @param input
	 * @return
	 * 🌟 : 1
	 */
	public static Queue<Integer> even(final Queue<Integer> queue) {
		
		if(queue == null) {
			throw new NullPointerException();
		} else if (queue.size() == 1) {
			return queue;
		}
		
		Iterator<Integer> it = queue.iterator();
		
		int counter = 0;
		while(it.hasNext()) {
			it.next();
			if (counter % 2 == 0){
				it.remove();
			}
			counter++;
		}

		return queue; // FIXME
	}
	
	/**
	 * Filtre tous les éléments de la file et ne laisse qu'une seule occurrence des éléments.
	 * @param queue
	 * @return
	 * 🌟 : 2
	 */
	public static Queue<String> unique(final Queue<String> queue) {
		
		Set<String> unique = new HashSet<>();
		
		Iterator<String> it = queue.iterator();

		while(it.hasNext()) {
			String next = it.next();
			if(!unique.contains(next)) {
				unique.add(next);
			} else {
				it.remove();
			}
		}
		
		return queue; // FIXME
	}
}
