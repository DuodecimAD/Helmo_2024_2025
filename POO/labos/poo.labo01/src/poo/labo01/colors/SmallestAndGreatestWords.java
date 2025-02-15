package poo.labo01.colors;

import io.Console;
import utils.StringUtils;

public class SmallestAndGreatestWords {

	public static void main(String[] args) {
		
		Console.simulerSaisies("BONJOUR", "TOUT", "VA", "BIEN", "42", "FIN");
		//Console.simulerSaisies("fin");
		
		String mot = "";
		String min = "\uffff";
		String max = null;
		boolean fin;
		System.out.println("Poo - Labo 1 - Exercice 4");
		System.out.println("=========================");
		
		do {
			mot = Console.lireString("Encodez un mot (Fin pour terminer) : ").toUpperCase();
			fin = mot.equals("FIN") ? true : false;
		 
		 if(!fin) {
			 mot = StringUtils.wordToTitleCase(mot);
			 min = StringUtils.min(min, mot);
			 max = StringUtils.max(max, mot);
		 }
		 
		} while (!fin);
		
		if(min.equals("\uffff") && max == null) {
			System.out.println("Aucun mot encodé");
		} else {
			System.out.println("Plus petit mot : " + min);
			System.out.println("Plus grand mot : " + max);
		}
		System.out.println("Fin d'éxécution");
	}

}
