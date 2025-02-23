package lecon04;

import java.util.Arrays;

/**
 * @author Adapté de Christiane Mathy
 */
public class GrilleLotto {
	private final int nbBoules;
	private final int tailleGrille;
	private int[] grille; // numéros tirés
	private int nbreTiragesEffectues;

	public GrilleLotto(int nbBoules, int tailleGrille) {
		this.nbBoules = Math.max(2, nbBoules);
		this.tailleGrille = Math.max(1, tailleGrille);
		this.grille = new int[tailleGrille];
		this.nbreTiragesEffectues = 0;
	}
	
	public void tirageGrille() {
		this.nbreTiragesEffectues = 0;
		for(int i = 0; i < tailleGrille; i++) {
			tirageBoule(); 
		}
	}
	
	public int[] getGrille() {
		return Arrays.copyOf(grille, tailleGrille);
	}
	
	/**
	 * Complexité spatiale
	 * 3 var + 1 array tailleGrille
	 * 3 + tailleGrille => O(tailleGrille)
	 */
	// tours de boucles ? nbreTiragesEffectues
	private boolean numéroUnique (int numéro) {
		for (int indiceTirage=0; indiceTirage < nbreTiragesEffectues; indiceTirage++) // init 2 op, guardien 2 op
			if (this.grille[indiceTirage] == numéro) { // Corps : 3 operation
				return false;
			}

		return true;
	}
	// total : 2 + 1 + (nbreTiragesEffectues * (3+2)) = 5*nbreTiragesEffectues + 3
	// O(nbreTiragesEffectues)
	
	
	/**
	 * Complexité spatiale
	 * 2 var + tailleGrille => O(tailleGrille)
	 * 
	 */
	private int tirageBoule() { // utilise numéro_unique()
		int n; // 1 op elementaire
		do {
			n = 1 + ((int)(Math.random() * nbBoules)); // n dans[1,42]   n, +, *, cast, rand, nbBoule, = : 6 opérations
		} while (!numéroUnique(n)) ; // function -> aller voir dans fct : O(nbreTiragesEffectues)
		// Hypothèse ? nbBoules >> tailleGrille => numériqueUnique sera le plus souvent vrai
		// => nbittérations ? 1 ittération

		// mise à jour de la grille
		this.grille[nbreTiragesEffectues] = n; // 3 op
		nbreTiragesEffectues += 1;				// 1 op

		return n;	// 1 op
		// total : 6 + 5 + nbreTiragesEffectues => O(nbreTiragesEffectues)
	}
}

