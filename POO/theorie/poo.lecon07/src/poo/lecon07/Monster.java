package poo.lecon07;

import java.util.Objects;

public class Monster implements Collideable, Moveable {
	
	private int x;
	private int y;
	
	public Monster(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void move(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	};
	
	@Override
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	
}
