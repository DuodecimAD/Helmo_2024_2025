package AoC;

import java.util.Arrays;

import io.Fichier;

public class ex1 {
	public static void main(String[] args) {
		int result;
		String[] test = Fichier.lireLignes("data/input2.txt");
		String[] string = Fichier.lireLignes("data/input1.txt");

		result = TrierTableau(string);
		System.out.println(result);


		similarity(test);
}

	public static int TrierTableau(String[] string) {

		String[] temp = new String[2];

		Integer [] tableau1 = new Integer[1000];
		Integer [] tableau2 = new Integer[1000];


		//System.out.println(string);

		for (int i = 0; i < tableau1.length; i++) {
			temp = string[i].split("   ");
			tableau1[i] = Integer.parseInt(temp[0]);
			tableau2[i] = Integer.parseInt(temp[1]);
		}

		Arrays.sort(tableau1);
		Arrays.sort(tableau2);

		Integer[] diff = new Integer[1000];
		int result=0;
		for (int i = 0; i < diff.length; i++) {
			diff[i] = Math.abs(tableau1[i]-tableau2[i]);
			result+=diff[i];
		}

		return result;

	}

	public static void similarity(String[] string) {
		String[] temp = new String[2];

		Integer [] tableau1 = new Integer[6];
		Integer [] tableau2 = new Integer[6];


		//System.out.println(string);

		for (int i = 0; i < tableau1.length; i++) {
			temp = string[i].split("   ");
			tableau1[i] = Integer.parseInt(temp[0]);
			tableau2[i] = Integer.parseInt(temp[1]);
		}

		Integer[] diff = new Integer[1000];
		int count, result=0;
		for (int i = 0; i < tableau1.length; i++) {
			count=0;
			for (Integer element : tableau2) {
				if(tableau1[i].equals(element)) {
					count++;
				}
			}
			diff[i] = tableau1[i]*count;
			//System.out.println(diff[i]);
			result+= diff[i];
		}
		System.out.println(result);

	}
}
