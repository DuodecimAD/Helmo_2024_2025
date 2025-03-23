package poo.lecon06;

import java.time.LocalDate;
import java.util.*;

public class AdHocPolymorphism {

	// DONE exercice 6.1 adHocPolymorphism
	
	public static void main(String[] args) {
		LocalDate[] array = 
				
		new LocalDate[]{
				LocalDate.of(2020, 01, 2),LocalDate.of(1970, 01, 02),
				LocalDate.of(1983, 07, 29),LocalDate.of(2000, 01, 01),
				LocalDate.of(2001, 11, 9),LocalDate.of(1974, 01, 02)
		};
		 
//		 new int[] {
//		 		2,21,42,1,3
//		 };
		 

		
		var min = min(array); // en donnant le même nom de méthode,
							  // l'expression min(array) ne doit plus changer
		
		System.out.printf("min of %s is %s\n", Arrays.toString(array), min);
	}
	
	public static LocalDate min(LocalDate[] dates) {
		Objects.requireNonNull(dates, "arg not defined");
		if(dates.length < 1) {
			throw new IllegalArgumentException("Need at least one element");
		}
		
		LocalDate currentMin = dates[0];
		for(int i = 1; i < dates.length; ++i) {
			if(dates[i].compareTo(currentMin) < 0) {
				currentMin = dates[i];
			}
		}
		
		return currentMin;
	}
	
	public static int min(int[] integers) {
		Objects.requireNonNull(integers, "arg not defined");
		if(integers.length < 1) {
			throw new IllegalArgumentException("Need at least one element");
		}
		
		int currentMin = integers[0];
		for(int i = 1; i < integers.length; ++i) {
			if(integers[i] < currentMin) {
				currentMin = integers[i];
			}
		}
		
		return currentMin;
	}
	
	
}
