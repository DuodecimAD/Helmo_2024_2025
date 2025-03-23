package poo.labo04.starwars;

/**
 * class ForceUser hérite de BaseCharacter
 */
public class ForceUser extends BaseCharacter{
	
	// private static final String FORCE_USAGE = "%s n'utilise pas la Force."
	private int damagePoints;
	
	/**
	 * 
	 * @param name
	 * @param hitPoints
	 * @param damagePoints
	 */
	public ForceUser(String name, int hitPoints, int damagePoints) {
		super(name, hitPoints);
		this.damagePoints = Math.abs(damagePoints);
	}

	public int getDamagePoints() {
		return damagePoints;
	}

	public void setDamagePoints(int damagePoints) {
		this.damagePoints = damagePoints;
	}

	/**
	 * 
	 * @param target
	 * @return
	 */
	public String useForceOn(BaseCharacter target) {
		if (target == null){
			return this.getName() + " n'utilise pas la Force.";
			// return FORCE_USAGE.formatted(getName());
		}
		
		target.loseHP(damagePoints);
		
		return this.getName() + " utilise la Force sur " + target.getName() + ". Dégâts causés : "
				+ damagePoints + ".";

	}

	@Override
	public String toString() {
		return super.toString() + " Ses damagePoints : " + damagePoints + " DP.";
	}
	
	

}
