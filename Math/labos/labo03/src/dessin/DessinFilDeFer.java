package dessin;

/**
 * La classe 'DessinFilDeFer' illustre l'utilisation des classes 'Dessins2D' et
 * 'Dessin3D' pour représenter des structures "fil de fer" en 2D et en 3D.
 *
 * @author François Schumacker
 */
public class DessinFilDeFer {

	public static void main(String[] args) {
		/*
		 *  Tests en 2D
		 */
		
		// Maison dans une fenêtre large, sans conserver les proportions.
//		creerDessinFilDeFer2D(600, 400, false, "Maison 2D", maison2D);

		// Maison dans une fenêtre haute, sans conserver les proportions.
//		creerDessinFilDeFer2D(400, 600, false, "Maison 2D", maison2D);

		// Maison dans une fenêtre large, conserver les proportions.
//		creerDessinFilDeFer2D(600, 400, true, "Maison 2D - proportions", maison2D);

		// Maison dans une fenêtre haute, conserver les proportions.
//		creerDessinFilDeFer2D(400, 600, true, "Maison 2D - proportions", maison2D);

		/*
		 *  Tests en 3D
		 */
		
		// Cube dans une fenêtre large, sans conserver les proportions.
//		creerDessinFilDeFer3D(600, 300, false, "Cube", cube);
		
		// Cube dans une fenêtre haute, sans conserver les proportions.
//		creerDessinFilDeFer3D(300, 600, false, "Cube", cube);
		
//		// Cube dans une fenêtre large, conserver les proportions.
		creerDessinFilDeFer3D(600, 300, true, "Cube - proportions", cube);
//		
//		// Cube dans une fenêtre haute, conserver les proportions.
		creerDessinFilDeFer3D(300, 600, true, "Cube - proportions", cube);
		
		/*
		 * Autres exemples en 3D
		 */
		
//		// Maison 3D - fil de fer
		creerDessinFilDeFer3D(800, 600, false, "Maison 3D - fil de fer", maisonFilDeFer3D);
//		
//		// Maison 3D - polygones remplis
		creerDessinSolide3D(800, 600, false, "Maison 3D - solide", maisonSolide3D);
	}

	/**
	 * Création d'un dessin "fil de fer" en 2D.
	 * 
	 * @param largeur
	 *            La largeur de la zone de dessin.
	 * @param hauteur
	 *            La hauteur de la zone de dessin.
	 * @param proportions
	 *            Conserver les proportions du dessin (true) ou utiliser tout l'espace (false)
	 * @param titre
	 *            Le titre de la fenêtre de dessin.
	 * @param data
	 *            Tableaux de données : [ligne][point][coordonnée].
	 */
	private static void creerDessinFilDeFer2D(int largeur, int hauteur, boolean proportions, String titre, double[][][] data) {
		
		// Création de la fenêtre de dessin 2D
		Dessin2D dessin2D = new Dessin2D(largeur, hauteur, 10, proportions, titre);
		
		// Création des lignes et ajout au dessin
		for (double[][] ligne : data) {
			dessin2D.ajouterLigne(
				// Une ligne 2D est définie par 2 points 2D [1er indice : 0,1]
				new Ligne2D(
					// Chaque point 2D est défini par ses coordonnées (x,y) [2e indice : 0,1]
					new Point2D(ligne[0][0], ligne[0][1]),
					new Point2D(ligne[1][0], ligne[1][1])
				)
			);
		}
		
		// Affichage du dessin
		dessin2D.dessiner();
	}
	
	/**
	 * Création d'un dessin "fil de fer" en 3D.
	 * 
	 * @param largeur
	 *            La largeur de la zone de dessin.
	 * @param hauteur
	 *            La hauteur de la zone de dessin.
	 * @param proportions
	 *            Conserver les proportions du dessin (true) ou utiliser tout l'espace (false)
	 * @param titre
	 *            Le titre de la fenêtre de dessin.
	 * @param data
	 *            Tableaux de données : [ligne][point][coordonnée].
	 */
	private static void creerDessinFilDeFer3D(int largeur, int hauteur, boolean proportions, String titre, double[][][] data) {
		
		// Création de la fenêtre de dessin 3D
		Dessin3D dessin3D = new Dessin3D(largeur, hauteur, 10, proportions, titre);
		
		// Création des lignes et ajout au dessin
		for (double[][] ligne : data) {
			dessin3D.ajouterLigne(
				// Une ligne 3D est définie par 2 points 3D [1er indice : 0,1]
				new Ligne3D(
					// Chaque point 3D est défini par ses coordonnées (x,y,z) [2e indice : 0,1,2]
					new Point3D(ligne[0][0], ligne[0][1], ligne[0][2]),
					new Point3D(ligne[1][0], ligne[1][1], ligne[1][2])
				)
			);
		}
		
		// Affichage du dessin
		dessin3D.dessinerLignes();
	}
	
	/**
	 * Création d'un dessin "solide" en 3D.
	 * 
	 * @param largeur
	 *            La largeur de la zone de dessin.
	 * @param hauteur
	 *            La hauteur de la zone de dessin.
	 * @param proportions
	 *            Conserver les proportions du dessin (true) ou utiliser tout l'espace (false)
	 * @param titre
	 *            Le titre de la fenêtre de dessin.
	 * @param data
	 *            Tableaux de données : [polygone][point][coordonnée].
	 */
	private static void creerDessinSolide3D(int largeur, int hauteur, boolean proportions, String titre, double[][][] data) {
		
		// Création de la fenêtre de dessin 3D
		Dessin3D dessin3D = new Dessin3D(largeur, hauteur, 10, proportions, titre);

		// Création des polygones et ajout au dessin
		for (double[][] polygone : data) {
			dessin3D.ajouterPolygone(
				// Un polygone 3D est défini par 4 points 3D [1er indice : 0,1,2,3]
				new Polygone3D(
					// Chaque point 3D est défini par ses coordonnées (x,y,z) [2e indice : 0,1,2]
					new Point3D(polygone[0][0], polygone[0][1], polygone[0][2]),
					new Point3D(polygone[1][0], polygone[1][1], polygone[1][2]),
					new Point3D(polygone[2][0], polygone[2][1], polygone[2][2]),
					new Point3D(polygone[3][0], polygone[3][1], polygone[3][2])
				)
			);
		}

		// Affichage du dessin
		dessin3D.dessinerPolygones(true); // true = polygones remplis
	}

	/*
	 * Données des différents dessins
	 */

	private static final double[][][] maison2D = { { { 10, -5 }, { 10, 3 } }, { { 10, 3 }, { 24, 3 } },
			{ { 24, 3 }, { 24, -5 } }, { { 24, -5 }, { 10, -5 } }, { { 12, -3 }, { 12, 0 } }, { { 12, 0 }, { 17, 0 } },
			{ { 17, 0 }, { 17, -3 } }, { { 17, -3 }, { 12, -3 } }, { { 19, -5 }, { 19, 0 } }, { { 19, 0 }, { 22, 0 } },
			{ { 22, 0 }, { 22, -5 } }, { { 10, 3 }, { 17, 9 } }, { { 17, 9 }, { 24, 3 } } };

	private static final double[][][] cube = { { { 0, 0, 0 }, { 0, 10, 0 } }, { { 0, 10, 0 }, { 10, 10, 0 } },
			{ { 10, 10, 0 }, { 10, 0, 0 } }, { { 10, 0, 0 }, { 0, 0, 0 } }, { { 0, 0, 10 }, { 0, 10, 10 } },
			{ { 0, 10, 10 }, { 10, 10, 10 } }, { { 10, 10, 10 }, { 10, 0, 10 } }, { { 10, 0, 10 }, { 0, 0, 10 } },
			{ { 0, 0, 0 }, { 0, 0, 10 } }, { { 0, 10, 0 }, { 0, 10, 10 } }, { { 10, 10, 0 }, { 10, 10, 10 } },
			{ { 10, 0, 0 }, { 10, 0, 10 } } };

	private static final double[][][] maisonFilDeFer3D = { { { 0, 8, 0 }, { 10, 8, 0 } }, { { 10, 8, 0 }, { 10, 8, 5 } },
			{ { 10, 8, 5 }, { 0, 8, 5 } }, { { 0, 8, 5 }, { 0, 8, 0 } }, { { 0, 8, 5 }, { 10, 8, 5 } },
			{ { 10, 8, 5 }, { 8, 4, 8 } }, { { 8, 4, 8 }, { 2, 4, 8 } }, { { 2, 4, 8 }, { 0, 8, 5 } },
			{ { 0, 0, 0 }, { 0, 8, 0 } }, { { 0, 8, 0 }, { 0, 8, 5 } }, { { 0, 8, 5 }, { 0, 0, 5 } },
			{ { 0, 0, 5 }, { 0, 0, 0 } }, { { 0, 8, 5 }, { 2, 4, 8 } }, { { 2, 4, 8 }, { 0, 0, 5 } },
			{ { 0, 0, 5 }, { 0, 8, 5 } }, { { 0, 0, 5 }, { 10, 0, 5 } }, { { 10, 0, 5 }, { 8, 4, 8 } },
			{ { 8, 4, 8 }, { 2, 4, 8 } }, { { 2, 4, 8 }, { 0, 0, 5 } }, { { 10, 8, 5 }, { 8, 4, 8 } },
			{ { 8, 4, 8 }, { 10, 0, 5 } }, { { 10, 0, 5 }, { 10, 8, 5 } }, { { 10, 0, 0 }, { 10, 8, 0 } },
			{ { 10, 8, 0 }, { 10, 8, 5 } }, { { 10, 8, 5 }, { 10, 0, 5 } }, { { 10, 0, 5 }, { 10, 0, 0 } },
			{ { 0, 0, 0 }, { 10, 0, 0 } }, { { 10, 0, 0 }, { 10, 0, 5 } }, { { 10, 0, 5 }, { 0, 0, 5 } },
			{ { 0, 0, 5 }, { 0, 0, 0 } }, { { 2, 0, 1 }, { 4, 0, 1 } }, { { 4, 0, 1 }, { 4, 0, 3 } },
			{ { 4, 0, 3 }, { 2, 0, 3 } }, { { 2, 0, 3 }, { 2, 0, 1 } }, { { 6, 0, 0 }, { 6, 0, 3 } },
			{ { 6, 0, 3 }, { 8, 0, 3 } }, { { 8, 0, 3 }, { 8, 0, 0 } }, { { 8, 0, 0 }, { 6, 0, 0 } } };
	
	private static final double[][][] maisonSolide3D = {
			{ { 0, 8, 0 }, { 10, 8, 0 }, { 10, 8, 5 }, { 0, 8, 5 } },   // mur fond
			{ { 0, 8, 5 }, { 10, 8, 5 }, { 8, 4, 8 }, { 2, 4, 8 } },    // toit fond
			{ { 0, 0, 0 }, { 0, 8, 0 }, { 0, 8, 5 }, { 0, 0, 5 } },     // mur gauche
			{ { 0, 8, 5 }, { 2, 4, 8 }, { 0, 0, 5 }, { 0, 8, 5 } },     // toit gauche
			{ { 0, 0, 5 }, { 10, 0, 5 }, { 8, 4, 8 }, { 2, 4, 8 } },    // toit avant
			{ { 10, 8, 5 }, { 8, 4, 8 }, { 10, 0, 5 }, { 10, 8, 5 } },  // toit droite
			{ { 10, 0, 0 }, { 10, 8, 0 }, { 10, 8, 5 }, { 10, 0, 5 } }, // mur droite
			{ { 0, 0, 0 }, { 10, 0, 0 }, { 10, 0, 5 }, { 0, 0, 5 } },   // mur avant
			{ { 2, 0, 1 }, { 4, 0, 1 }, { 4, 0, 3 }, { 2, 0, 3 } },     // fenêtre
			{ { 6, 0, 0 }, { 6, 0, 3 }, { 8, 0, 3 }, { 8, 0, 0 } }      // porte
	};

}
