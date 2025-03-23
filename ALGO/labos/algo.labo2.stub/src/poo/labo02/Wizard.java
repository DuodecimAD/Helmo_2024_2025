package poo.labo02;

import java.util.Objects;

public class Wizard implements Comparable<Wizard> {
	public static final String UNKNOWN = "You-Know-Who";

	private String name;
	private Level level;

	public Wizard(String name, Level level) {
		this.name = Objects.requireNonNullElse(name, UNKNOWN); // Simplifié
		this.level = Objects.requireNonNullElse(level, Level.STUDENT);
	}

	public String getName() {
		return name;
	}

	public Level getLevel() {
		return level;
	}

	/* Modifié % au labo2 de POO... */
	public String cast(String spell) {
		return name + " casts " + (spell == null ? "nothing" : spell);
	}

	@Override
	public String toString() {
		return "Wizard(" + name + " – " + level + ")";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(Wizard other) {
		Objects.requireNonNull(other);
		
		int result = this.getLevel().compareTo(other.getLevel());

		if(result == 0) {
			return this.getName().compareTo(other.getName());
		}
		
		return result; // DONE: Fakenews !
	}

	
	

}
