package poo.labo06.requests;

import java.util.*;

/**
 * Représente une demande de l'utilisateur.
 * */
public final class UserRequest {
	private static final List<String> EMPTY_ARGS = List.of();
	private final UserRequestKind kind;
	private final List<String> args;
	
	/**
	 * Analyse une ligne de commande et retourne la requête utilisateur correspondante.
	 * */
	public static UserRequest ofLine(String line) {
		String[] tokens = line.split("\\s+");
		return new UserRequest(tokens);
	}
	
	private UserRequest(String... tokens) {
		if(tokens.length == 0) {
			this.kind = UserRequestKind.UNKNOWN;
			this.args = EMPTY_ARGS;
		} else {
			this.kind = UserRequestKind.parse(tokens[0]);
			this.args = new ArrayList<>(tokens.length);
			for(int i=1; i < tokens.length; ++i) {
				args.add(tokens[i].toUpperCase());
			}
		}
	}
	
	/**
	 * Retourne le type de cette requête.
	 */
	public UserRequestKind getKind() {
		return kind;
	}
	
	
	/**
	 * Retourne le nombre d'arguments.
	 * */
	public int getArgsCount() {
		return args.size();
	}
	
	/**
	 * Retourne l'argument de position {@code argPos} ou un texte vide.
	 * */
	public String getArgAt(int argPos) {
		if(0 <= argPos && argPos < args.size()) {
			return this.args.get(argPos);
		} else {
			return "";
		}
	}
}
