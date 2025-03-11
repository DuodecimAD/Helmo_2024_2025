package poo.lecon05;

import java.time.LocalDateTime;

public class RepeatableEvent extends Event {
	private int freq;
	
	public RepeatableEvent(String name, LocalDateTime start, LocalDateTime end, int freq) {
		super(name, start, end);
		this.freq = freq;
	}
	
	public LocalDateTime nextInstanceAfter(LocalDateTime datetime) {
		// long durationInDays = Duration.between(Start(), datetime).toDays();
		// int nextMultiple = durationInDays/freq) + 1;
		// return getStart().plusDays(nextMultiple*freq);
		
		LocalDateTime check = getStart();
		
		if(datetime != null && datetime.isAfter(check)) {
			do {
				check = check.plusDays(freq);
			} while (check.isBefore(datetime));
		}
		
		return check;
		
	}
	
	// TODO exercice 8 b
	public LocalDateTime nextInstance() {
		return null;
		
	}
	
	// TODO exercice 9 a
	@Override
	public boolean contains(LocalDateTime datetime) {
		if(datetime.isAfter(getStart()) && datetime.isBefore(getEnd())) {
			return true;
		}
		return false;
	}
	
	
	// DONE exercice 9 b2
	@Override
	public String toString() {
		return super.toString() + " " + freq;
	}
	
	
	
	
	
	
}
