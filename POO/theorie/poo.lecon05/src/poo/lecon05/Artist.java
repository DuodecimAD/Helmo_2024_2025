package poo.lecon05;

import java.time.LocalDate;
import java.time.Period;

public class Artist {

	private String name;
	private LocalDate birthday;

	public Artist(String name) {
		this.name = name;
	}
	
	public Artist(String name, LocalDate date) {
		this.name = name;
		
		if(date == null || date.isAfter(LocalDate.now())) {
			this.birthday = LocalDate.EPOCH;
		} else {
			this.birthday = date;
		}
		
	}

	public int getAge() {
		return Period.between(birthday, LocalDate.now()).getYears();
	}

	public String getName() {
		return name;
	}

	
}
