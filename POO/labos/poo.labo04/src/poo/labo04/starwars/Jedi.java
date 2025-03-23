package poo.labo04.starwars;

/**
 * 
 */
public class Jedi extends ForceUser {

	private boolean hasForceFury = true;
	private static final int RAGE_TRESHOLD = 2;
	private static final int RAGE_FACTOR = 10;
	
	/**
	 * 
	 * @param name
	 * @param hitPoints
	 * @param damagePoints
	 */
	public Jedi(String name, int hitPoints, int damagePoints) {
		super(name, hitPoints, damagePoints);
	}
	
	/**
	 * 
	 */
	@Override
	public String useForceOn(BaseCharacter target) {
		if(target != null && canUseRage() ) {
			return useForceRageOn(target);
		}
		return super.useForceOn(target);
	}

	private boolean canUseRage() {
		return this.getHP() <= RAGE_TRESHOLD && hasForceFury;
	}

	private String useForceRageOn(BaseCharacter target) {
		target.loseHP(this.getDamagePoints()*RAGE_FACTOR);
		hasForceFury = false;
		return this.getName() + " utilise la rage de la Force sur " + target.getName() + ". Dégâts causés : "
				+ (this.getDamagePoints()*RAGE_FACTOR) + ".";
	}
}
