package poo.lecon05;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

class AgendaTest {

	@Test
	void getsTodaysEventAtAGivenTime() {
		Agenda a = new Agenda("Tata");
		Event evt1 = new Event("Titi", 
				LocalDateTime.of(LocalDate.now(), LocalTime.of(13, 00)),
				LocalDateTime.of(LocalDate.now(), LocalTime.of(16, 00)));
		Event evt2 = new Event("Titi", 
				LocalDateTime.of(LocalDate.now(), LocalTime.of(15, 30)),
				LocalDateTime.of(LocalDate.now(), LocalTime.of(17, 00)));
		RepeatableEvent revt1 = new RepeatableEvent(
				"Poo - theorie", 
				LocalDateTime.of(LocalDate.now(), LocalTime.of(13, 30)),
				LocalDateTime.of(LocalDate.now(), LocalTime.of(15, 30)),
				7);
		RepeatableEvent revt2 = new RepeatableEvent(
				"Poo - labo", 
				LocalDateTime.of(LocalDate.now().minusDays(1), LocalTime.of(13, 30)),
				LocalDateTime.of(LocalDate.now().minusDays(1), LocalTime.of(15, 30)),
				7);
		
		
		a.add(evt1);
		a.add(evt2);
		a.add(revt1);
		a.add(revt2);
		
		String[] actual = a.getTodayEventAt(LocalTime.of(15, 0));
		String[] expected = {"Titi", "Poo - theorie"};
		
		assertArrayEquals(expected, actual);
 	}

}
