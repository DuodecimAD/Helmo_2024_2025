package utils;

import java.util.StringJoiner;

public class StringUtils {

	public static String min(String s1, String s2) {
		//s1 = Objects.requireNonNullElse(s1, "");
		
		s1 = checkNotNullOrReturnEmpty(s1);
		s2 = checkNotNullOrReturnEmpty(s2);
		
		if (s1.compareTo(s2) > 0) {
			 return s2;
		 }
		 return s1;
	}
	
	public static String max(String s1, String s2) {
		s1 = checkNotNullOrReturnEmpty(s1);
		s2 = checkNotNullOrReturnEmpty(s2);
		
		if (s1.compareTo(s2) > 0) {
			 return s1;
		 }
		 return s2;
	}
	
	private static String checkNotNullOrReturnEmpty(String s) {
		if(s == null) {
			return "";
		} else {
			return s;
		}
	}
	
	public static String wordToTitleCase(String w) {
		
		if( w == null || w.isBlank()) {
			return "";
		} else {
			w = w.trim();
			return Character.toTitleCase(w.charAt(0)) + w.substring(1).toLowerCase();
		}
	}
	
	public static String sentenceToTitleCase(String s) {
		s = checkNotNullOrReturnEmpty(s);
		s = s.trim();
		//String[] array = s.split("[ ,.!]+");
		String[] array = s.split("( |\\p{Punct})+");
		
		for (int i = 0; i < array.length; i++) {
			array[i] = wordToTitleCase(array[i]);
		}
		
		StringJoiner arrayJoiner = new StringJoiner(" ");
		
		for (int i = 0; i < array.length; i++) {
			arrayJoiner.add(array[i]);
		}
		
		return arrayJoiner.toString();
		
	}

}
