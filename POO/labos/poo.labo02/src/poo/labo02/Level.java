package poo.labo02;

/**
 * Définit les niveaux qu'un sorcier peut atteindre.
 * 
 * Vous ne pouvez pas créer de nouveaux objets avec cette classe.
 * Vous pouvez par contre utiliser les objets prédéfinis tels que Level.STUDENT, Level.HEADMASTER, etc.
 * */
public enum Level {
	HEADMASTER(1, "Headmaster"){
		@Override
		public Level next() {
			return HEADMASTER;
		}
	},
	PROFESSOR(3, "Professor"){
		@Override
		public Level next() {
			return HEADMASTER;
		}
	},
	GRADUATED(5, "Graduated"){
		@Override
		public Level next() {
			return PROFESSOR;
		}
	},
	STUDENT(7, "Student"){
		@Override
		public Level next() {
			return GRADUATED;
		}
	};
	
	private final int time;
	private final String name;
	
	Level(int time, String name) {
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
	public abstract Level next();
	
}
