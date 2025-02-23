package poo.labo02;

/**
 * Définit les niveaux qu'un sorcier peut atteindre.
 * 
 * Vous ne pouvez pas créer de nouveaux objets avec cette classe.
 * Vous pouvez par contre utiliser les objets prédéfinis tels que Level.STUDENT, Level.HEADMASTER, etc.
 * */
public class Level {
	public static final Level HEADMASTER = new Level(1, "Headmaster");
	public static final Level PROFESSOR = new Level(3, "Professor");
	public static final Level GRADUATED = new Level(5, "Graduated");
	public static final Level STUDENT = new Level(7, "Student");
	
	private final int time;
	private final String name;
	
	private Level(int time, String name) {
		this.time = time;
		this.name = name;
	}
	
	/**
	 * Retourne le temps de ce niveau.
	 * */
	public int getTime() {
		return this.time;
	}
	
	/**
	 * Retourne le nom de ce niveau.
	 * */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Détermine si cet objet est équivalent à l'objet <code>other</code>.
	 * {@inheritDoc}
	 * */
	public boolean equals(Object other) {
		//Comme les objets sont prédéfinis, on peut utiliser la comparaison par référence.
		if(!(other instanceof Level)) {
			return false;
		}
		
		return this == other; 
	}
	
	/**
	 * Retourne une représentation de l'objet.
	 * {@inheritDoc}
	 */
	public String toString() {
		return this.name.toUpperCase();
	}
	
	/**
	 * Retourne le niveau supérieur à ce niveau.
	 * 
	 * Les règles suivantes sont appliquées :
	 * <ul>
	 * <li>Le niveau suivant étudiant et diplômé.
	 * <li>Le niveau suivant diplômé est professeur.
	 * <li>Le niveau suivant professeur et directeur est le niveau directeur.
	 * </ul>
	 * */
	public Level next() {
		if(this == STUDENT) {
			return GRADUATED;
		} else if(this == GRADUATED) {
			return PROFESSOR;
		} else {
			return HEADMASTER;
		}
	}
}
