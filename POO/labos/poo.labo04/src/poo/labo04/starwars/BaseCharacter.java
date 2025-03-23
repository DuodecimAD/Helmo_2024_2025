package poo.labo04.starwars;

import java.util.Objects;

/**
 * Charactere de base pour l'exercice Star Wars
 */
public class BaseCharacter {
	private final String name;
	private int hp;
	
	/**
	 * construteur de la classe BaseCharacter
	 * @param name si null = "?"
	 * @param hitPoints
	 */
	public BaseCharacter(String name, int hitPoints) {
		//this.name = Objects.requireNonNullElse(name, "Inconnu");
		this.name = name == null || name.isBlank() ? "Inconnu" : name;
		hp = Math.abs(hitPoints);
	}

	public int getHP() {
		return hp < 0 ? 0 : hp;
	}

	public void setHP(int hitPoints) {
		hp = hitPoints;
	}

	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @param points but if points are negatives return 0
	 */
	public void loseHP(int points) {
		this.setHP(this.getHP() - points);
	}
	
	/**
	 * 
	 * @return true if hit points > 0
	 */
	public boolean isAlive() {
		return this.getHP() > 0;
	}

	@Override
	public String toString() {
		return name + " est " + (isAlive() ? "vivant" : "mort") + " : " + getHP() +" hp.";
	}
	
	
	
	
}
