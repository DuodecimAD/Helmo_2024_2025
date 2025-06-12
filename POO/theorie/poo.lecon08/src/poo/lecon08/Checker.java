package poo.lecon08;

/**
 * représente une couleur de piont
 */
public enum Checker {
	RED('R'), 
	BLACK('B'), 
	NONE(' ');
	
	private final char content;


	private Checker(char c) {
		this.content = c;
	}
	

	public boolean isNone() {
		return this == NONE;
	}
	
	public Checker getOpposite() {
		return switch(this) {
		case RED -> BLACK;
		case BLACK -> RED;
		case NONE -> NONE;
		};
	}
	
	@Override
	public String toString() {
		return ""+content;
	}
}
