package lecon13.cake;

/**
 * Interface que doit respecter une classe implémentant la méthode 
 * coupe(longueur).
 */
public interface CoupeCake {
	
	/**
	 * Calcule le prix maximal de vente pour un cake de longueur longueur
	 * @param longueur un nombre entre 1 et tailleMax()
	 * @return le meilleur prix possible pour ce cake après coupes.
	 * @throws IllegalArgumentException si longueur hors de [1..tailleMax()]
	 */
	int coupe(int longueur);
	
	/**
	 * @return la taille maximale que gère cette classe.
	 */
	int tailleMax();
	
	/**
	 * @return une description courte de la stratégie sous la forme d'une chaine.
	 */
	String descriptionMethode();
}
