package recursivite;

/**
 * Détermine le nombre d'occurrences d'un caractère dans une chaine.
 * 
 */

public class NombreOccurrences {
	/**
	 * Renvoie le nombre d'occurrences du caractère c dans la chaine passée en paramètre.<br>
	 * Version ITERATIVE
	 * 
	 * @param chaine une chaine de caractères
	 * @param c le caractère pour lequel on veut connaitre le nombre d'occurrences dans la chaine
	 * @return le nombre d'occurrences du caractère c.
	 */
	public static int nombreOccurrencesIteratif(String chaine, char c) {
				
		// TODO DONE
		int count = 0;
		// je compte combien de fois le caractère apparait dans la string avec une loop
		// je mets la String et le Character en lowercase pour gérer la casse
		for (int i = 0; i < chaine.length(); i++) {
			if(chaine.toLowerCase().charAt(i) == Character.toLowerCase(c)) {
				count++;
			}
		}
    	return count;
	}

	/**
	 * Renvoie le nombre d'occurrences du caractère c dans la chaine passée en paramètre.<br>
	 * Version RECURSIVE
	 * 
	 * @param chaine une chaine de caractères
	 * @param c le caractère pour lequel on veut connaitre le nombre d'occurrences dans la chaine
	 * @return le nombre d'occurrences du caractère c.
	 */
	public static int nombreOccurrencesRecursif(String chaine, char c) {
		// TODO HALF DONE 
		// comment on garde le nombre d'occurence si on peut pas modif signature ?
		if(chaine.length() == 0) {
			return 0;
		}else if(chaine.toLowerCase().charAt(0) == Character.toLowerCase(c)) {
			return 1;
		}
    	return nombreOccurrencesRecursif(chaine.substring(1),c);
	}

}
