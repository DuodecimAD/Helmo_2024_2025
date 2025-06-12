package io;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Objects;
import java.util.Scanner;

/**
 * Permet de lire les mots d'un fichier
 */
public final class LecteurFichier {

	private final String chemin;

	private LecteurFichier(String chemin) {
		this.chemin = chemin;
	}
	
	/**
	 * Méthode de fabrique statique qui prend en argument un chemin
	 * @param chemin fichier à lire
	 * @return un LecteurFichier nouvellement créé.
	 * @throws NullPointerException si le chemin est null
	 */
	public static LecteurFichier depuis(String chemin) {
		return new LecteurFichier(Objects.requireNonNull(chemin));
	}
	
	/**
	 * Lit le fichier dans la liste fournie en argument.
	 * Si le fichier n'existe pas, la collection ne contient que le mot « DEBUG » 
	 * @param collection une collection dans laquelle on lit des mots.
	 */
	public void dans(Collection<String> collection) {
		try(Scanner s = new Scanner(new java.io.File(chemin))) {
			while(s.hasNext()) {
				collection.add(s.next());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			collection.add("DEBUG");
		}
	}
}
