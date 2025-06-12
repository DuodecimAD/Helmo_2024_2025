package dessin;

/**
 * La classe 'Ligne2D' modélise une ligne dans un système de coordonnées
 * cartésiennes à 2 dimensions. Une ligne est représentée par 2 Point2D.
 *
 * @author François Schumacker
 */
public class Ligne2D {
	private final Point2D p1;
	private final Point2D p2;
	
	public Ligne2D(Point2D p1, Point2D p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	public Point2D getP1() {
		return p1;
	}

	public Point2D getP2() {
		return p2;
	}

}
