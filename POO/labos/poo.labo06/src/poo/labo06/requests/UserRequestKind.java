package poo.labo06.requests;

import java.util.Objects;

/**
 * Enumère les types de requêtes que l'utilisateur peut faire.
 * */
public enum UserRequestKind {
	LIST, SHOW_TAGS, FILTER_BY_TAG, EXIT, UNKNOWN;
	
	/**
	 * Analyse val et retourne le code correspondant ou UNKNOWN.
	 * 
	 * Cette méthode n'est pas sensible à la casse.
	 * */
	static UserRequestKind parse(String val) {
		try {
			String sanitizedVal = sanitize(Objects.requireNonNullElse(val, ""));
			return UserRequestKind.valueOf(sanitizedVal);
		} catch(IllegalArgumentException ex) {
			return UserRequestKind.UNKNOWN;
		}
	}

	private static String sanitize(String str) {
		return str.toUpperCase().replace('-', '_');
	}
	
}
