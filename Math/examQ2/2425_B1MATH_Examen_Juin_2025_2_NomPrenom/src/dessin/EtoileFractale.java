package dessin;


/**
 * Etoile fractale  
 *  
 * Conception de l'étoile fractale : 
 *  - On part d’un point central.
 *  - On trace des segments issus de ce point, répartis régulièrement (les branches).
 *  - On répète le tracé de nouveaux segments, à partir de chaque extrémité des segments précédents, 
 *    avec une longueur réduite. 
 *     
 */

public class EtoileFractale {
	
	private static final double LONGUEURDEPART = 100;  // Longueur segment initial (tronc)
	private static final int NB_BRANCHES = 5;          // Nombre de directions (branches de l'étoile)
    private static final double REDUCTION = 0.5;       // Réduction de la longueur
    private static final int ORDRE = 3;                // Ordre de la récursion
			
    /**
     * Dessine une étoile fractale de manière récursive, <br>
     * 
     * @param dessin référence vers l'objet de dessin graphique
     * @param x abscisse du point origine (centre de l'étoile)
     * @param y ordonnée du point origine (centre de l'étoile)
     * @param longueur longueur des segments (branches de l'étoile)
     * @param n ordre de la récursion
     */		
    
    private static void dessinerEtoile(Dessin2D dessin, double x, double y, double longueur, int n) {

    	// TODO pas le temps ...
		if(n > 0 ) {
			Point2D point1 = new Point2D(x,y);
			Point2D point2 = new Point2D(x+longueur*Math.sin(n), y+longueur*Math.cos(n));
			
			Ligne2D ligne = new Ligne2D(point1, point2);
			dessin.ajouterLigne(ligne);
			dessinerEtoile(dessin,x,y,longueur, n-72);
		}

    }

        
    /**
	 * Programme principal
	 */	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		if (ORDRE >= 10) 
    		System.out.println("\nL'ordre de récursion est au maximum 10 (exclu) !");
    	else {							
			// Créer la fenêtre de dessin
			Dessin2D dessinEtoile = new Dessin2D(600, 600, 30, true, "Etoile fractale");
		
			// Démarrer la récurrence
			dessinerEtoile(dessinEtoile, 0, 0, LONGUEURDEPART, ORDRE);
			
			// Dessiner la courbe
			dessinEtoile.dessiner();
    	}
	}

}
