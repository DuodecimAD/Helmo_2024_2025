package poo.lecon07;

public interface Moveable extends HasPosition  {

	/**
	 * Déplace l'objet de position {@code (x, y) à (x + dx, y + dy)}
	 * @param dx
	 * @param dy
	 */
	
	// public abstract par défaut donc pas besoin
	public abstract void move(int dx, int dy);
	
	/**
	 *  deplace  l'object à la position {@code (x, y)}
	 * @param x
	 * @param y
	 */
	void moveTo(int x, int y);
}
