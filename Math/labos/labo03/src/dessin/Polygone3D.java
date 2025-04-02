package dessin;

import java.awt.Color;

/**
 * La classe 'Polygone3D' modélise un polygone à 4 côtés dans un système de
 * coordonnées cartésiennes à 3 dimensions. Le polygone est représenté par 4
 * Point3D qui correspondent à ses 4 sommets.
 *
 * @author François Schumacker
 */
public class Polygone3D {
	private final Point3D p1, p2, p3, p4;
	private Color couleurTrait;
	private Color couleurRemplissage;

	public Polygone3D(Point3D p1, Point3D p2, Point3D p3, Point3D p4) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
		this.couleurTrait = Color.BLACK;
		this.couleurRemplissage = Color.WHITE;
	}

	public Polygone3D(Point3D p1, Point3D p2, Point3D p3, Point3D p4, Color couleurTrait, Color couleurRemplissage) {
		this(p1, p2, p3, p4);
		this.couleurTrait = couleurTrait;
		this.couleurRemplissage = couleurRemplissage;
	}

	public Point3D getP1() {
		return p1;
	}

	public Point3D getP2() {
		return p2;
	}

	public Point3D getP3() {
		return p3;
	}

	public Point3D getP4() {
		return p4;
	}

	public Color getStrokeColor() {
		return couleurTrait;
	}

	public Color getFillColor() {
		return couleurRemplissage;
	}

}
