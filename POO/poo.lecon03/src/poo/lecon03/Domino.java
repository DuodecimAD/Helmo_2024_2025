package poo.lecon03;

public class Domino {
	// TODO exercice 02
	int group1;
	int group2;

	public Domino(int spots1, int spots2) {
		if ((spots1 >= 0 && spots1 <= 6) && (spots2 >= 0 && spots2 <= 6)) {
			group1 = spots1;
			group2 = spots2;
		} else {
			group1 = (int) (Math.random() * 7);
			group2 = (int) (Math.random() * 7);
		}
	}

//	void init(int spots1, int spots2) {
//		if ((spots1 >= 0 && spots1 <= 6) && (spots2 >= 0 && spots2 <= 6)) {
//			group1 = spots1;
//			group2 = spots2;
//		} else {
//			group1 = (int) (Math.random() * 7);
//			group2 = (int) (Math.random() * 7);
//		}
//
//	}

	int getSpotsAt(int pos) {
		if (pos == 0) {
			return group1;
		} else if (pos == 1){
			return group2;
		} else {
			return -1;
		}
	}

	boolean isCompatibleWith(Domino d) {
		if (d.getSpotsAt(0) == this.getSpotsAt(0) || d.getSpotsAt(0) == this.getSpotsAt(1)
				|| d.getSpotsAt(1) == this.getSpotsAt(0) || d.getSpotsAt(1) == this.getSpotsAt(1)) {
			return true;
		} else {
			return false;
		}
	}
}
