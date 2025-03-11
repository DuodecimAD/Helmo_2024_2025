package correction;

import java.util.Objects;

public class TableauEntiers {
	
	/**
	 * Décale toutes les cases du tableau d'une case vers la droite, de manière
	 * circulaire.
	 * 
	 * Ex. [1, 2, 3, 4] devient [4, 1, 2, 3] 
	 * 
	 * Implémentation donnée à titre d'exemple. Utiliser
	 * <code>System.arraycopy</code> sera sans doute plus efficace.
	 * 
	 * Précondition : valeurs est une référence non-nulle vers un tableau d'entiers.
	 * Postcondition : les entiers contenus dans valeurs ont été décalés
	 * circulairement vers la droite.
	 * 
	 * @param valeurs le tableau dont il faut décaler les éléments.
	 */
	public static void decalageCirculaireDroite(int[] valeurs) {
		Objects.requireNonNull(valeurs);
		
		if (valeurs.length == 0) {
			return;
		}
		int tmp = valeurs[valeurs.length - 1];
		int pos = valeurs.length - 1;
		while(pos > 0) {
			valeurs[pos] = valeurs[pos - 1];
			pos--;
		}
		valeurs[0] = tmp;
	}
}
