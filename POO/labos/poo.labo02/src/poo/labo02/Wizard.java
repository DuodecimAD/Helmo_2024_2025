package poo.labo02;

import java.util.Objects;

public class Wizard {
	
	private final static String DEFAULT_NAME = "You-Know-Who";
	private final static String NULL_CAST = "nothing.";
	private final static int DEFAULT_EXP = 0;
	
	private String name;
	private Level level;
	private int exp;
	
	 public Wizard(String givenName, Level givenLevel) {
		 this.name = Objects.requireNonNullElse(givenName, DEFAULT_NAME);
		 this.level = Objects.requireNonNullElse(givenLevel, Level.STUDENT);
		 
		 if(this.name.isBlank()) {
			 this.name = DEFAULT_NAME;
		 } else if(this.name.equals(DEFAULT_NAME)) {
			 this.level = Level.HEADMASTER;
		 }
		 
		 this.exp = DEFAULT_EXP;
	 }
	 
	 public String getName() {
		return this.name;
	 }
	 
	 public Level getLevel() {
		return this.level;
	 }
	 
	 public boolean hasBeenPromoted() {
			return exp == 0;
		 }
	 
	 public String cast(Spell s) {
		
		String castString;
		if(s == null) {
			castString = NULL_CAST;
		} else {
			this.exp++;
			if (this.exp == this.level.getTime() && !this.level.equals(Level.HEADMASTER)) {
				this.level = this.level.next();
				this.exp = DEFAULT_EXP;
			}
			
			castString = s.cast(this.level.getTime());

		}
		return this.name + " casts " + castString;
	 }
	 
	 
	 
	 

}
