package poo.lecon07;

/**
 * représente des objets capable de détecter descolisions
 */
public interface Collideable extends HasPosition {
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @return {@code true} si l'objet qui reçoit l'appel occupe la position {@code (x, y)
	 */
	default boolean collideWith(int x, int y) {
		return getX() == x && getY() == y;
	}
}
