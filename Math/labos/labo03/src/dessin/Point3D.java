package dessin;

/**
 * La classe 'Point3D' modélise un point dans un système de coordonnées
 * cartésiennes à 3 dimensions. Un point est représenté par son abscisse x,
 * son ordonnée y et sa hauteur z.
 *
 * @author François Schumacker
 */
public class Point3D {
	private final double x;
	private final double y;
	private final double z;
	
	public Point3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getZ() {
		return z;
	}
	
}
