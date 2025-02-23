package lecon04;

import java.util.Arrays;

/**
 * @author Adapté de Christiane Mathy
 */
public class GrilleLottoV2 {
	private final int nbBoules;
	private final int tailleGrille;
	private int[] grille; // numéros tirés
	private int nbreTiragesEffectues;
	private boolean[] déjàTiré; // numéros tirés
		
	public GrilleLottoV2(int nbBoules, int tailleGrille) {
		this.nbBoules = Math.max(2, nbBoules);
		this.tailleGrille = Math.max(1, tailleGrille);
		this.grille = new int[tailleGrille];
		this.nbreTiragesEffectues = 0;
		this.déjàTiré = new boolean[nbBoules + 1]; // la position [0] sera inutilisée
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

	private boolean numéroUnique (int numéro) {
		if (déjàTiré[numéro]) {
			return false;
		}
		else {
			déjàTiré[numéro] = true;
			return  true;
		}
	}

	private int tirageBoule() { // utilise numéro_unique()
		int n;	// 1 op
		do {
			n = 1 + ((int)(Math.random() * nbBoules)); // n dans [1,42] // 6 op
		} while (!numéroUnique(n)) ; // 1-2 op

		// mise à jour de la grille
		this.grille[nbreTiragesEffectues] = n; // 3 op
		nbreTiragesEffectues += 1; // 1 op

		return n; // 1 op
		// total : 6 + 6 + 6*1 => O(1) - O(n)
	}
}