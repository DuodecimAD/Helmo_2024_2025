package poo.lecon07;

import java.util.Objects;

public class Tree implements Collideable {
	private final int x;
	private final int y;
	
	public Tree(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public boolean collideWith(int x, int y) {
		Objects.requireNonNull(x);
		Objects.requireNonNull(y);

		return this.x == x && this.y == y;
	}

	@Override
	public int getX() {
		
		return x;
	}

	@Override
	public int getY() {
		
		return y;
	}
	

}
