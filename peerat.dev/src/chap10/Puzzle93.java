package chap10;

import io.Fichier;

public class Puzzle93 {

	public static void main(String[] args) {
		
		String[] string = Fichier.lireLignes("data/Puzzle93.txt");

		for (int i = 0; i < string.length; i++) {
			for (int j = 0; j < string[i].length(); j++) {
				if(string[i].charAt(j) == 'x') {
					System.out.println("("+i+", "+j+")");
					break;
				}
			}
		}
		
		
	}

}
