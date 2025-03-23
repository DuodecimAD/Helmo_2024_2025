package lecon09.cards;

public enum Frame {
	NORMAL("yellow"),
	EFFECT("brown"),
	SPELL("green"),
	TRAP("purple"),
	RITUAL("blue"),
	FUSION("violet"),
	SYNCHRO("white"),
	XYZ("black"),
	PENDULUM("mixed"),
	LINK("navy");
	
	private final String color;
	
	private Frame(String color){
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
}
