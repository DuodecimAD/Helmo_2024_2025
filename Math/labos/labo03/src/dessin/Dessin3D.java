package dessin;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.LinkedList;

import graphics.DrawingPanel;

/**
 * La classe 'Dessin3D' permet de créer un dessin en 3 dimensions consitué d'un
 * ensemble de lignes ou de polygones et de l'afficher en perspective dans une
 * fenêtre graphique.
 *
 * @author François Schumacker
 */
public class Dessin3D {
	
	// Fenêtre d'affichage
	private final int largeur;
	private final int hauteur;
	private final int marge;
	private final DrawingPanel panel;
	private final Graphics graphics;

	// Facteurs d'échelle
	private double xMin, xMax;
	private double yMin, yMax;
	private double zMin, zMax;
	private double echelleXY, echelleZ;
	private boolean proportions;

	// Données à afficher
	private final LinkedList<Ligne3D> lignes;
	private final LinkedList<Polygone3D> polygones;

	// Coefficients pour le calcul de la perspective cavalière
	private static final double ALPHA = Math.PI * 30 / 180; // 30 degrés
	private static final double K = 0.6; // coefficient de réduction
	private static final double SIN_ALPHA = Math.sin(ALPHA);
	private static final double COS_ALPHA = Math.cos(ALPHA);

	
	/**
	 * Crée une nouvelle fenêtre de dessin.
	 * 
	 * @param largeur
	 *            La largeur totale de la zone de dessin.
	 * @param hauteur
	 *            La hauteur totale de la zone de dessin.
	 * @param marge
	 *            L'épaisseur de la marge qui restera vide.
	 * @param proportions
	 *            Indique s'il faut conserver les proportions (true) ou pas (false)
	 * @param titre
	 *            Le titre de la fenêtre de dessin.
	 */
	public Dessin3D(int largeur, int hauteur, int marge, boolean proportions, String titre) {
		
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.marge = marge;
		this.proportions = proportions;
		
		this.panel = new DrawingPanel(largeur, hauteur);
		this.panel.setTitle(titre);
		this.graphics = panel.getGraphics();
		this.lignes = new LinkedList<>();
		this.polygones = new LinkedList<>();
		
		initData();
	}
	
	/**
	 * (Ré)initialise les données de dessin.
	 */
	public void initData() {
		
		this.lignes.clear();
		this.polygones.clear();

		this.xMin = Double.POSITIVE_INFINITY;
		this.xMax = Double.NEGATIVE_INFINITY;
		this.yMin = Double.POSITIVE_INFINITY;
		this.yMax = Double.NEGATIVE_INFINITY;
		this.zMin = Double.POSITIVE_INFINITY;
		this.zMax = Double.NEGATIVE_INFINITY;

		this.echelleXY = 1;
		this.echelleZ = 1;
	}
	
	/**
	 * Ajoute une ligne à la liste de lignes à dessiner. La méthode met
	 * également à jour les bornes min/max ainsi que les facteurs d'échelle.
	 * 
	 * @param ligne
	 *            La ligne ajoutée.
	 */
	public void ajouterLigne(Ligne3D ligne) {
		
		// Ajout de la ligne à la collection
		lignes.add(ligne);

		// Mise à jour des bornes min/max
		miseAJourBornesMinMax(ligne.getP1());
		miseAJourBornesMinMax(ligne.getP2());

		// Mise à jour des facteurs d'échelle
		miseAJourEchelleXY();
		miseAJourEchelleZ();
		
		if(proportions) {
			echelleXY = echelleZ =  Math.min(echelleXY, echelleZ);
		}
	}
	
	/**
	 * Ajoute un polygone à la liste de polygones à dessiner. La méthode met
	 * également à jour les bornes min/max ainsi que les facteurs d'échelle.
	 * 
	 * @param polygone
	 *            Le polygone ajouté.
	 */
	public void ajouterPolygone(Polygone3D polygone) {
		
		// Ajout du polygone à la collection
		polygones.add(polygone);

		// Mise à jour des bornes min/max
		miseAJourBornesMinMax(polygone.getP1());
		miseAJourBornesMinMax(polygone.getP2());
		miseAJourBornesMinMax(polygone.getP3());
		miseAJourBornesMinMax(polygone.getP4());

		// Mise à jour des facteurs d'échelle
		miseAJourEchelleXY();
		miseAJourEchelleZ();
		
		if(proportions) {
			echelleXY = echelleZ =  Math.min(echelleXY, echelleZ);
		}
	}
	
	/**
	 * Met à jour les bornes min/max de x, y et z en fonction des coordonnées
	 * du point fourni.
	 * 
	 * @param point
	 */
	private void miseAJourBornesMinMax(Point3D point) {
		double pointX = point.getX();
		double pointY = point.getY();
		double pointZ = point.getZ();

		this.xMin = Math.min(this.xMin, pointX);
		this.xMax = Math.max(this.xMax, pointX);
		this.yMin = Math.min(this.yMin, pointY);
		this.yMax = Math.max(this.yMax, pointY);
		this.zMin = Math.min(this.zMin, pointZ);
		this.zMax = Math.max(this.zMax, pointZ);
	}

	/**
	 * Calcule le facteur d'échelle en X et en Y en fonction de la largeur utile de
	 * la fenêtre de dessin et des intervalles de valeurs utilisées en X et en Y
	 * pour la figure.
	 */
	private void miseAJourEchelleXY() {
		double delta = (this.xMax - this.xMin) + (this.yMax - this.yMin) * COS_ALPHA * K;
		if(delta != 0) {
			this.echelleXY = (largeur - 2 * marge) / delta;
		}
	}

	/**
	 * Calcule le facteur d'échelle en Z en fonction de la moitié de la hauteur
	 * de la fenêtre de dessin et de l'intervalle des valeurs utilisées en Z.
	 */
	private void miseAJourEchelleZ() {
		if(zMin != zMax)
		this.echelleZ = (hauteur * 0.5) / (this.zMax - this.zMin) ;
	}

	/**
	 * Calcule l'abscisse du point dans la fenêtre d'affichage en effectuant
	 * la mise à l'échelle et la translation adéquates.
	 * 
	 * @param x
	 *            Abscisse réelle.
	 * @param y
	 *            Ordonnée réelle.
	 * @return Abscisse dans la fenêtre d'affichage.
	 */
	private int xAffichage(double x, double y) {
		return marge + (int) (((x - xMin) + (y - yMin) * K * COS_ALPHA) * this.echelleXY);
	}

	/**
	 * Calcule l'ordonnée du point dans la fenêtre d'affichage en effectuant
	 * la mise à l'échelle et la translation adéquates.
	 * 
	 * @param y
	 *            Ordonnée réelle.
	 * @param z
	 *            Hauteur réelle.
	 * @return Ordonnée dans la fenêtre d'affichage.
	 */
	private int yAffichage(double y, double z) {
		return hauteur - (marge + (int)((y- yMin) * K * SIN_ALPHA * this.echelleXY + (z - zMin) * this.echelleZ));
	}

	/**
	 * Dessine les lignes présentes dans la liste.
	 */
	public void dessinerLignes() {
		
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, largeur, hauteur);
		graphics.setColor(Color.BLACK);

		for (Ligne3D l : lignes) {
			graphics.drawLine(
					xAffichage(l.getP1().getX(), l.getP1().getY()),
					yAffichage(l.getP1().getY(), l.getP1().getZ()),
					xAffichage(l.getP2().getX(), l.getP2().getY()),
					yAffichage(l.getP2().getY(), l.getP2().getZ()));
		}
	}

	/**
	 * Dessine les polygones présents dans la liste.
	 * 
	 * @param opaque
	 *            Indique si les polygones sont remplis (true) ou pas (false).
	 */
	public void dessinerPolygones(boolean opaque) {
		
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, largeur, hauteur);
		
		for (Polygone3D p : polygones) {
			Polygon polygoneADessiner = new Polygon();
			polygoneADessiner.addPoint(xAffichage(p.getP1().getX(), p.getP1().getY()),
					yAffichage(p.getP1().getY(), p.getP1().getZ()));
			polygoneADessiner.addPoint(xAffichage(p.getP2().getX(), p.getP2().getY()),
					yAffichage(p.getP2().getY(), p.getP2().getZ()));
			polygoneADessiner.addPoint(xAffichage(p.getP3().getX(), p.getP3().getY()),
					yAffichage(p.getP3().getY(), p.getP3().getZ()));
			polygoneADessiner.addPoint(xAffichage(p.getP4().getX(), p.getP4().getY()),
					yAffichage(p.getP4().getY(), p.getP4().getZ()));
			if (opaque) {
				graphics.setColor(p.getFillColor());
				graphics.fillPolygon(polygoneADessiner);
			}
			graphics.setColor(p.getStrokeColor());
			graphics.drawPolygon(polygoneADessiner);
		}
	}
}
