package lecon09.requests;

import java.util.Objects;

public class Form {
	
	private static int current_id;

	public static String NO_NAME = "";
	public static String NO_DESCRIPTION = "(vide)";
	
	private final String name;
	private final String description;
	private final int id;
	
	public Form(String givenName, String givenDescription) {
		name = Objects.requireNonNull(givenName);
		description = Objects.requireNonNull(givenDescription);
		id = current_id++;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getId() {
		return id;
	}
}
