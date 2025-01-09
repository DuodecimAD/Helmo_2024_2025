package chap12;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.Fichier;

public class Puzzle110 {

	public static void main(String[] args) {
		
		String[] string = Fichier.lireLignes("data/Puzzle110.txt");
		
		ArrayList<Integer> numbers = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\d+");
        for (int i = 0; i < string.length; i++) {
			Matcher matcher = pattern.matcher(string[i]);
			
			while (matcher.find()) {
	            int number = Integer.parseInt(matcher.group());
	            numbers.add(number);
	        }
		}
        
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
			sum += numbers.get(i);
		}
        
        System.out.println(sum);

	}

}
