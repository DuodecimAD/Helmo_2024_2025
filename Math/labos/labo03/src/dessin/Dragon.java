package dessin;


/**
 * Courbe du dragon
 *  
 */

public class Dragon {
		
	// Longueur du segment de départ
	private final static int LINE = 10; 
			
    /**
     * Dessine une courbe du dragon de manière récursive
     *
     * @param dessinCourbe référence vers l'objet de dessin graphique
     * @param x1 abscisse du point 1
     * @param y1 ordonnée du point 1
     * @param x2 abscisse du point 2
     * @param y2 ordonnée du point 2
     * @param ordre numéro du niveau à dessiner
     */
    public static void dragonRecursion(Dessin2D dessinCourbe, double x1, double y1, double x2, double y2, int ordre) {
       
    	if(ordre <= 0) {
    		
    		dessinCourbe.ajouterLigne(
				// Une ligne 2D est définie par 2 points 2D [1er indice : 0,1]
				new Ligne2D(
					// Chaque point 2D est défini par ses coordonnées (x,y) [2e indice : 0,1]
					new Point2D(x1, y1),
					new Point2D(x2, y2)
				)
    		);
    		
    	} else {
    		double x3 = (x1+x2-y2+y1) / 2;
    		double y3 = (y1+y2+x2-x1) / 2;
    		
    		dragonRecursion(dessinCourbe, x1, y1, x3, y3, ordre-1);
    		dragonRecursion(dessinCourbe, x2, y2, x3, y3, ordre-1);
    	}
    	
    		
  
    }
    
    /**
	 * Programme principal
	 */	
	public static void main(String[] args) {
    	// Créer la fenêtre de dessin
    	Dessin2D dessinCourbe = new Dessin2D(720, 720, 10, true, "Courbe du dragon");
    	
		// Démarrer la récurrence
		dragonRecursion(dessinCourbe, 200, 500,  200 + LINE, 500, 20);
		
		// Dessiner la courbe
		dessinCourbe.dessiner();
	}

}
