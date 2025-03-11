package poo.lecon04;

public class Dice {
	private int facesCount;
	private int topFace;
	
	public Dice(int facesCount) {
		this(facesCount, 1);
		roll();	
	}
	
	public Dice(int facesCount, int topFace) {
		this.facesCount = (2 <= facesCount && facesCount <= 6) ? facesCount : 6;
		this.topFace = Math.max(1, Math.min(topFace,  this.facesCount));
	}

	public int getFacesCount() {
		return facesCount;
	}

	public int getTopFace() {
		return topFace;
	}
	
	public void roll() {		
		int candidate = (int)(1 + Math.floor(Math.random()*facesCount));
		while(candidate == topFace) {
			candidate = (int)(1 + Math.floor(Math.random()*facesCount));
		}
		topFace = candidate;
	}
	
	public String toString() {
		return String.format("Dice(facesCount: %d, topFace: %d)", facesCount, topFace);
	}
}
