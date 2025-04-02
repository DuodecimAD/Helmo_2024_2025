package dessin;

/**
 * La classe 'Point2D' modélise un point dans un système de coordonnées
 * cartésiennes à 2 dimensions. Un point est représenté par son abscisse x et
 * son ordonnée y.
 *
 * @author François Schumacker
 */
public class Point2D {
	private final double x;
	private final double y;
	
	public Point2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
}
