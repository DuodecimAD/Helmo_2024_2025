package poo.lecon05;

import java.time.LocalDateTime;

public class Event {
	private String name;
	private LocalDateTime start;
	private LocalDateTime end;
	
	public Event(String name, LocalDateTime start, LocalDateTime end) {
		this.name = name;
		this.start = start;
		this.end = end;
	}
	
	public String getName() {
		return name;
	}

	public LocalDateTime getStart() {
		return start;
	}

	public LocalDateTime getEnd() {
		return end;
	}
	
	public boolean isNow() {
		return contains(LocalDateTime.now());
	}
	
	public boolean contains(LocalDateTime datetime) {
		return start.compareTo(datetime) <= 0 &&
			   datetime.compareTo(end) <= 0;
	}
	
	@Override
	public String toString() {
		return getName() + " " + getStart() + " " + getEnd();
	}
}
