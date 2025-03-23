package poo.labo04.starwars;

public class Sith extends ForceUser {

	private int attackCounter = 0;
	private static final int FORCE_LIGHTNING = 5;
	private static final int LIGHTNING_TRESHOLD = 5;
	private static final String LIGHTNING_MESSAGE = "%s lance des éclairs sur %s. Dégâts causés : %d.";
	private static final int FORCE_CHOKE = 2;
	private static final int CHOKE_TRESHOLD = 3;
	private static final String CHOKE_MESSAGE = "%s étrangle %s. Dégâts causés : %d.";

	/**
	 * 
	 * @param name
	 * @param hitPoints
	 * @param damagePoints
	 */
	public Sith(String name, int hitPoints, int damagePoints) {
		super(name, hitPoints, damagePoints);
	}

	@Override
	public String useForceOn(BaseCharacter target) {
		if (target == null) {
			return super.useForceOn(target);
		}

		attackCounter++;

		if (attackCounter % LIGHTNING_TRESHOLD == 0) {
			target.loseHP(this.getDamagePoints()*FORCE_LIGHTNING);
			return choke(target);
		} else if (attackCounter % CHOKE_TRESHOLD == 0) {
			target.loseHP(this.getDamagePoints()*FORCE_CHOKE);
			return bolt(target);
		}
		return super.useForceOn(target);
	}

	private String bolt(BaseCharacter target) {
		return CHOKE_MESSAGE.formatted(this.getName(), target.getName(),
				this.getDamagePoints() * FORCE_CHOKE);
	}

	private String choke(BaseCharacter target) {
		return LIGHTNING_MESSAGE.formatted(this.getName(), target.getName(),
				this.getDamagePoints() * FORCE_LIGHTNING);
	}
	
	
}
