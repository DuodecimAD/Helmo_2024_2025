package chap13;

import java.util.Arrays;
import java.util.Iterator;

import io.Fichier;

public class consonnes {
	
	public static void main(String[] args) {
		String[] string = Fichier.lireLignes("data/consonnes.txt");
		
		String word= "";
	    
	    int max = 0;
		for (int i = 0; i < string.length; i++) {
			int num = 0;
			for (int j = 0; j < string[i].length(); j++) {
				if ("aeiouáàâäéèêëíìîïóòôöúùûü ".indexOf(Character.toLowerCase(string[i].charAt(j))) == -1) {
					num++;
				}
			}
			if(max < num) {
				max = num;
				word = string[i];
			}
		}
		
		System.out.println(word +" "+ max);
		
	}

	

}
