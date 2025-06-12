package trianglePascal;

/**
 * Calcul des coefficients du triangle de Pascal et affichage de celui-ci
 */

public class TrianglePascal {
	
	/**
     * Calcule le coefficient binomial correspondant à la ligne et à la colonne données 
     * Version itérative.
     * 
     * Indication : le calcul du coefficient binomial correspondant à la ligne n et à la colonne p
     * peut être réalisé à l'aide de la formule :
     * 
     * coefficient(n, p) = n * (n-1)/2 * (n-2)/3 * ... * (n-p+2)/(p-1) * (n-p+1)/p
     *
     * @param ligne numéro de la ligne du coefficient à calculer 
     * @param colonne numéro de la colonne du coefficient à calculer 
     * @return le coefficient binomial
     */
    public static int coefficientPascalIteratif(int ligne, int colonne) {    	
        
        
    	if(ligne < 0 || colonne < 0 || colonne > ligne) {
			throw new IllegalArgumentException();
		} 
    	
    	int result = 1;
    	for (int i = 1; i <= colonne; i++) {
			result = result * (ligne - i + 1) / i;
		}
    	
        return result;
    }

    /**
     * Calcule le coefficient binomial correspondant à la ligne et à la colonne données 
     * Version récursive.
     * 
     * Définition mathématique, par récurrence : 
     * coefficient(n, p) = 1  si p = 0 ou p = n
     * coefficient(n, p) = coefficient(n-1, p) + coefficient(n-1, p-1)  sinon
     *
     * @param ligne numéro de la ligne du coefficient à calculer 
     * @param colonne numéro de la colonne du coefficient à calculer 
     * @return le coefficient binomial 
     */
    public static int coefficientPascalRecursif(int ligne, int colonne) {
    	
    	if(ligne < 0 || colonne < 0 || colonne > ligne) {
			throw new IllegalArgumentException();
		} else if(colonne  == 0 || colonne == ligne){
			return 1;
		}
    	
        return coefficientPascalRecursif(ligne - 1, colonne) + coefficientPascalRecursif(ligne - 1, colonne - 1);
    }
  
    
    public static void main(String[] args) {
		
		System.out.println("Triangle de Pascal - version itérative");

		for (int i = 0; i < 17; i++) {
			for (int j = 0; j < i; j++) {
				System.out.printf("%5d ", coefficientPascalIteratif(i, j));
			}
			System.out.println();
		}
		
		System.out.println();
		
		System.out.println("Triangle de Pascal - version récursive");

		for (int i = 0; i < 17; i++) {
			for (int j = 0; j < i; j++) {
				System.out.printf("%5d ", coefficientPascalRecursif(i, j));
			}
			System.out.println();
		}
	}
}
