package bitwise;

/**
 * Manipulation de bits – Chiffrement simple
 *
 * Voici la méthode d'encodage :
 *  - Prendre un entier x.
 *  - Inverser tous les bits.
 *  - Appliquer un décalage vers la gauche de 3 positions.
 *  - Appliquer un masque secret (par exemple, 0xA5A5A5A5) 
 *    de manière à inverser la valeur des bits correspondant aux "1" du masque.
 *
 */
 
 
public class Chiffrement {

    // Masque secret utilisé pour le chiffrement
    private static final int MASQUE_SECRET = 0xA5A5A5A5;

    /**
     * Encode un entier en appliquant une série de transformations bit à bit.
     * 
     * @param x l'entier auquel on applique le chiffrement
     * @return l'entier encodé
     */
    public static int encoder(int x) {
    	
    	// TODO DONE
    	int inverse = ~x; // NOT
    	int decalage = inverse << 3; // decalage de 3 bits vers la gauche
    	int afterMask = decalage ^ MASQUE_SECRET; // XOR avec le masque
    	return afterMask;

    }

    /**
     * Décode un entier (encodé avec la méthode précédente) en appliquant une série de transformations bit à bit;
     * x = decoder(y).
     * 
     * @param y l'entier à décoder
     * @return l'entier décodé
     */
    public static int decoder(int y) {
    	
    	// TODO DONE
    	int afterMask = y ^ MASQUE_SECRET; // XOR avec le masque
    	int decalage = afterMask >> 3; // décalage de 3 bits vers la droite
    	int inverse = ~decalage; // NOT
    	return inverse;
    }

    /**
     * Affiche la représentation binaire d'un entier sur 32 bits.
     * 
     * @param x l'entier à afficher
     * @return la chaine correspondant à la représentation binaire sur 32 bits de l'entier donné 
     */ 
    public static String toBinaryString(int x) {
        return String.format("%32s", Integer.toBinaryString(x)).replace(" ", "0");
    }

    
    /**
	 * Programme principal
	 */	
    public static void main(String[] args) {
    	
    	int[] entiersDepart = new int[] {123456, -85236921, 0x0ade68b1, 0xfade68b1};
    	
    	int encode, decode, original;

        for(int i = 0; i < entiersDepart.length; i++) {
    
        	original = entiersDepart[i];
        	encode = encoder(original);
        	decode = decoder(encode);
        	System.out.printf("\nOriginal : %15d   " + toBinaryString(original), original);        
            System.out.printf("\nEncodé   : %15d   "  + toBinaryString(encode), encode);        
            System.out.printf("\nDécodé   : %15d   "  + toBinaryString(decode), decode);
            System.out.println();  
        }    
    }
}

