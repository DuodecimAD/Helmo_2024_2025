package poo.lecon03;

public class Dice {
	//TODO : exercice 01
	int facesCount;
	int topFace;
	
	public Dice(int n) {
		if (n > 6 || n < 2) {
			facesCount = 6;
		} else {
			facesCount = n;
		}
		
		roll();
	}
	
//	public void init(int n) {
//		if (n > 6 || n < 2) {
//			facesCount = 6;
//		} else {
//			facesCount = n;
//		}
//		
//		roll();
//	}
	
	public void roll() {
		double nb = Math.random();
		topFace = (int) (Math.random() * facesCount) + 1;
	}
	
	public int getFacesCount() {
		return facesCount;
	}
	
	public int getTopFace() {
		return topFace;
	}
}
