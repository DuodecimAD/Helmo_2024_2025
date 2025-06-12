package poo.lecon06;

import java.time.LocalDate;
import java.util.*;
import java.util.regex.Pattern;

public class GenericPolymorphim {
	public static void main(String[] args) {
		
		var list = List.of(
		    LocalDate.of(2020, 01, 2),LocalDate.of(1970, 01, 02),
			LocalDate.of(1983, 07, 29),LocalDate.of(2000, 01, 01),
			LocalDate.of(2001, 11, 9),LocalDate.of(1974, 01, 02)
		);
		
		// Pattern n'implemente pas la methode Comparable<Pattern> => refus compilateur
//		var list = List.of(
//				  Pattern.compile("[a-zA-Z_][0-9a-zA-Z_]+"), 
//				  Pattern.compile("[a-z]\\d{6}"), 
//				  Pattern.compile(",\\s*")
//		);
		
		var min = GenericPolymorphim.findMin(list);
		
		System.out.printf("min of %s is %s\n", list, min);
	}
	
	public static <T extends Comparable<T>> T findMin(List<? extends T> list) {
		Objects.requireNonNull(list, "arg not defined");
		if(list.size() < 1) {
			throw new IllegalArgumentException("Need at least one element");
		}
		
		T currentMin = list.getFirst();
		for(int i = 1; i < list.size(); ++i) {
			if(list.get(i).compareTo(currentMin) < 0) {
				currentMin = list.get(i);
			}
		}
		
		return currentMin;
	}
}
