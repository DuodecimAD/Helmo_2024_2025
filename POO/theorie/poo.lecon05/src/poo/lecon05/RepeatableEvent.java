package poo.lecon05;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class RepeatableEvent extends Event {
	private int freq;

	public RepeatableEvent(String name, LocalDateTime start, LocalDateTime end, int freq) {
		super(name, start, end);
		this.freq = freq;
	}

	public LocalDateTime nextInstanceAfter(LocalDateTime datetime) {
//		 TODO : correction prof, à comprendre
		 long durationInDays = Duration.between(getStart(), datetime).toDays();
		 int nextMultiple = (int) (durationInDays/freq) + 1;
		 return getStart().plusDays(nextMultiple*freq);

//		mon code
//		 
//		LocalDateTime check = getStart();
//
//		if (datetime != null && datetime.isAfter(check)) {
//			do {
//				check = check.plusDays(freq);
//			} while (check.isBefore(datetime));
//		}
//
//		return check;

	}

	@Override
	public boolean contains(LocalDateTime datetime) {
		LocalDateTime instanceBeforeStart = nextInstanceAfter(datetime).minusDays(freq);
		LocalDateTime instanceBeforeEnd = instanceBeforeStart.plus(Duration.between(getStart(), getEnd()));
		return datetime.compareTo(instanceBeforeEnd) < 0;

//		mon code ... not sure if it works
//		if(datetime.isAfter(getStart()) && datetime.isBefore(getEnd())) {
//			return true;
//		}
//		return false;
	}

	@Override
	public String toString() {
		return "RepeatableEvent(super="+ super.toString() +", freq=" + freq + ")";
	}

	// @Override - neither or surcharge
	public boolean equals(RepeatableEvent evt) {

		return freq == evt.freq && this.getName().equals(evt.getName()) && this.getStart().equals(evt.getStart())
				&& this.getEnd().equals(evt.getEnd());

	}

}
