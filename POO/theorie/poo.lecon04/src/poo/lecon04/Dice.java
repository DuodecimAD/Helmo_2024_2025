package poo.lecon04;

public class Dice {
	private int facesCount;
	private int topFace;
	
	public Dice(int n) {
		facesCount = (2 <= n && n <= 6) ? n : 6;
		roll();	
	}
	
//	public void init(int n) {
//		facesCount = (2 <= n && n <= 6) ? n : 6;
//		roll();
//		
//	}

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
