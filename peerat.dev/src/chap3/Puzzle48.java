package chap3;

public class Puzzle48 {

	public static void main(String[] args) {
		
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.printf("%02d x %d = %02d", j, i, i*j);
				if(j < 9) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}

	}

}
