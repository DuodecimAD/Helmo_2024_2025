package contracts;

public final class Contracts {

	/**
	 * Constructeur. Je ne m'attends pas à ce que vous lisiez ceci mais vous semblez intéressé par le code.
	 * Un constructeur privé qui ne fait rien est utilisé pour empêcher l'instanciation de classes utilitaire
	 * comme celle-ci. La classe java.lang.Math fait la même chose.
	 */
	private Contracts() {} 
	
	/**
	 * Assure qu'une condition est vraie. Échoue Sinon
	 * @param condition une condittion à tester
	 * @throw IllegalArgumentException si la condition est fausse
	 */
	public static void requires(final boolean condition) throws IllegalArgumentException {
		requires(condition, "");
	}
	
	/**
	 * Assure qu'une condition est vraie. Échoue Sinon
	 * @param condition une condittion à tester
	 * @throw IllegalArgumentException si la condition est fausse
	 */
	public static void requires(final boolean condition, final String message) throws IllegalArgumentException {
		if (!condition)
			throw new IllegalArgumentException(message);
	}
	
	/**
	 * Fait en sorte que valeur soit dans [min max]
	 * @param min valeur minimale de l'intervalle.
	 * @param max valeur maximale de l'intervalle.
	 * @param valeur la valeur à tester
	 * @return valeur si valeur_0 est dans [min max] ou la borne la plus proche.
	 */
	public static int ensures(final int min, final int max, final int valeur) {
		return Math.max(min, Math.min(max, valeur));
	}
}
