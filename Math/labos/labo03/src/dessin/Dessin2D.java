package dessin;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import graphics.DrawingPanel;

/**
 * La classe 'Dessin2D' permet de créer un dessin en 2 dimensions consitué d'un
 * ensemble de lignes et de l'afficher dans une fenêtre graphique.
 *
 * @author François Schumacker
 */
public class Dessin2D {
	
	// Fenêtre d'affichage
	private final int largeur;
	private final int hauteur;
	private final int marge;
	private final DrawingPanel panel;
	private final Graphics graphics;

	// Facteurs d'échelle
	private double xMin, xMax;
	private double yMin, yMax;
	private double echelleX, echelleY;
	private boolean proportions;

	// Données à afficher
	private final LinkedList<Ligne2D> lignes;

	
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
	public Dessin2D(int largeur, int hauteur, int marge, boolean proportions, String titre) {
		
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.marge = marge;
		this.proportions = proportions;
		this.panel = new DrawingPanel(largeur, hauteur);
		this.panel.setTitle(titre);
		this.graphics = panel.getGraphics();
		this.lignes = new LinkedList<>();

		initData();
	}
	
	/**
	 * (Ré)initialise les données de dessin.
	 */
	public void initData() {
		
		this.lignes.clear();

		this.xMin = Double.POSITIVE_INFINITY;
		this.xMax = Double.NEGATIVE_INFINITY;
		this.yMin = Double.POSITIVE_INFINITY;
		this.yMax = Double.NEGATIVE_INFINITY;

		this.echelleX = 1;
		this.echelleY = 1;
	}

	/**
	 * Ajoute une ligne à la liste de lignes à dessiner. La méthode met
	 * également à jour les bornes min/max ainsi que les facteurs d'échelle.
	 * 
	 * @param ligne
	 *            La ligne ajoutée.
	 */
	public void ajouterLigne(Ligne2D ligne) {
		
		lignes.add(ligne);

		// Mise à jour des min/max
		miseAJourBornesMinMax(ligne.getP1());
		miseAJourBornesMinMax(ligne.getP2());

		// Mise à jour des facteurs d'échelle
		miseAJourEchelleX();
		miseAJourEchelleY();
		
		if(proportions) {
			echelleX = echelleY = Math.min(echelleX, echelleY);
		}
	}

	/**
	 * Met à jour les bornes min/max de x et y en fonction des coordonnées du
	 * point fourni.
	 * 
	 * @param point
	 */
	private void miseAJourBornesMinMax(Point2D point) {
		double pointX = point.getX();
		double pointY = point.getY();
		this.xMin = Math.min(this.xMin, pointX);
		this.xMax = Math.max(this.xMax, pointX);
		this.yMin = Math.min(this.yMin, pointY);
		this.yMax = Math.max(this.yMax, pointY);

	}
	
	/**
	 * Calcule le facteur d'échelle en X en fonction de la largeur de la fenêtre
	 * de dessin et de l'intervalle des abscisses utilisées.
	 */
	private void miseAJourEchelleX() {
		if (xMin != xMax) {
			this.echelleX = (this.largeur - (2 * marge)) / (this.xMax - this.xMin);
		}
	}

	/**
	 * Calcule le facteur d'échelle en Y en fonction de la hauteur de la fenêtre
	 * de dessin et de l'intervalle de ordonnées utilisées.
	 */
	private void miseAJourEchelleY() {
		if (yMin != yMax) {
			this.echelleY = (this.hauteur - (2 * marge)) / (this.yMax - this.yMin);
		}
	}

	/**
	 * Calcule l'abscisse du point dans la fenêtre d'affichage en effectuant
	 * la mise à l'échelle et la translation adéquates.
	 * 
	 * @param x
	 *            Abscisse réelle.
	 * @return Abscisse dans la fenêtre d'affichage.
	 */
	private int xAffichage(double x) {
		double xP = x - this.xMin;
		double xE = xP * echelleX;
		double xFinal = xE + marge;
		
		return (int) xFinal;
	}

	/**
	 * Calcule l'ordonnée du point dans la fenêtre d'affichage en effectuant
	 * la mise à l'échelle et la translation adéquates.
	 * 
	 * @param y
	 *            Ordonnée réelle.
	 * @return Ordonnée dans la fenêtre d'affichage.
	 */
	private int yAffichage(double y) {
		double yP = y - this.yMin;
		double yE = yP * echelleY;
		double yFinal = hauteur - (yE + marge);
		
		return (int) yFinal;
	}

	/**
	 * Dessine les lignes présentes dans la liste et réinitialise les données.
	 */
	public void dessiner() {
		
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, largeur, hauteur);
		graphics.setColor(Color.BLACK);

		for (Ligne2D l : lignes) {
			graphics.drawLine(
					xAffichage(l.getP1().getX()),
					yAffichage(l.getP1().getY()),
					xAffichage(l.getP2().getX()),
					yAffichage(l.getP2().getY()));
			
//			try {
//				Thread.sleep(1);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
		
	}
}
