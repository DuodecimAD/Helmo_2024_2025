package dessin;

/**
 * La classe 'Ligne3D' modélise une ligne dans un système de coordonnées
 * cartésiennes à 3 dimensions. Une ligne est représentée par 2 Point3D.
 *
 * @author François Schumacker
 */
public class Ligne3D {
	private final Point3D p1;
	private final Point3D p2;
	
	public Ligne3D(Point3D p1, Point3D p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	public Point3D getP1() {
		return p1;
	}

	public Point3D getP2() {
		return p2;
	}

}
