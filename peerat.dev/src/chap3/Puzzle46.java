package chap3;

public class Puzzle46 {

	public static void main(String[] args) {

		int result = -1, i = 0;

		do {
			i++;
			result = i * 9;
			System.out.println(result);

		} while (result < 7101);

		System.out.println("i final = " + i);

	}

}
