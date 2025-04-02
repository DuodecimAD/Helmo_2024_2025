package lecon13.mine;

public interface GoldmineSolver {
	
	/**
	 * Résoud le problème de la mine :
	 * Cherche le meilleur profit réalisable en sommant les valeurs entières composant une veine
	 * dans la mine.
	 * 
	 * Une veine de mine est une succession de cases mine[r_i][i] avec i allant de 0 à nbCol - 1 de
	 * sorte que |r_k - r_(k+1)|<=1 
	 * 
	 * @implNote La stratégie utilisée est de la reponsabilité de l'implémenteur. Elle n'est pas
	 * forcément optimale.
	 * @param mine une mine (un tableau 2D rectangulaire)
	 * @return le profit maximal réalisable dans une mine.
	 */
	int solve(final int[][] mine);
	
	/**
	 * @return une description courte de la stratégie sous la forme d'une chaine.
	 */
	String getStrategyName();
}
