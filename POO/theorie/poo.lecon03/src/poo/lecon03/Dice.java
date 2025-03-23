package poo.lecon03;

public class Dice {

	private int facesCount;
	private int topFace;
	
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
	
	public void setFacesCount(int facesCount) {
		this.facesCount = facesCount;
	}

	public void setTopFace(int topFace) {
		this.topFace = topFace;
	}
	
	@Override
	public String toString() {
		return "Dice(facesCount: "+ getFacesCount() +", topFace: "+ getTopFace() +")";
	}
}
