package zanzibar.domains;

import java.util.List;

/**
 * Implémentation factice de groupe de dés.
 * <p>
 * Permet de prévoir l'évolution du score d'un joueur
 * </p>
 * */
class FakeDices implements Dices {

	private List<List<Integer>> rollResults;
	private int currentRoll;
	
	/**
	 * Initialise un groupe de dés pipés avec une liste de lancers prédéfinis.
	 * */
	public FakeDices(List<List<Integer>> rollResults) {
		this.rollResults = List.copyOf(rollResults);
		this.currentRoll = 0;
	}
	
	/**
	 * Retourne le lancer attendu et passe au suivant.
	 * <p>
	 * Si cet objet retourne le dernier lancer, il recommence à zéro.
	 * </p>
	 * */
	@Override
	public List<Integer> roll() {
		var result = rollResults.get(currentRoll);
		currentRoll = (currentRoll + 1)%rollResults.size();
		
		return result;
	}
	
}