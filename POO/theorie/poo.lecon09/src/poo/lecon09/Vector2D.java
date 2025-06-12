package poo.lecon09;

public class Vector2D {
	
	private double x;
	private double y;
	
	public Vector2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getMagnitude(){
		return Math.sqrt(x*x + y*y);
	}
	
	public double getTheta() {
		return Math.atan2(y, x);
	}
	
	@Override
	public String toString() {
		return String.format(" ");
	}
	
	// R2. Calculer de nouveaux vecteurs sur base de vecteurs ou de scalaire
	public Vector2D plus(Vector2D other) {
		return new Vector2D(x + other.x, y + other.y);
	}
	
	public Vector2D plus(double scalar) {
		return new Vector2D(x + scalar, y + scalar);
	}
	
	public double dotProduct(Vector2D other) {
		return x * other.x+ y * other.y;
	}
	
	// R3. Se comparer à d'autres vecteurs
	public int compareTo(Vector2D other) {
		return 0;//this > other;
	}
	
	public boolean isLessThan(Vector2D other) {
		return false;//this.compareTo(other);
	}
	
}
