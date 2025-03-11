package poo.lecon05;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class RepeatableEventTest {

	@Test
	void instanceOfBothEventAndReapeatableEvent() {
		RepeatableEvent evt = new RepeatableEvent(
				"Poo - theorie", 
				LocalDateTime.of(2025, 3, 11, 13, 30),
				LocalDateTime.of(2025, 3, 11, 15, 30),
				7
				);
		
		assertTrue(evt instanceof Event);
		assertTrue(evt instanceof RepeatableEvent);
						
	}
	
	@Test
	void computesTheNextInstanceOfItself() {
		RepeatableEvent evt = new RepeatableEvent(
				"Poo - theorie", 
				LocalDateTime.of(2025, 3, 11, 13, 30),
				LocalDateTime.of(2025, 3, 11, 15, 30),
				7
				);
		
		LocalDateTime nextEvt = evt.nextInstanceAfter(LocalDateTime.of(2025, 3, 13, 8, 30));
		assertEquals(LocalDateTime.of(2025, 3, 18, 13, 30), nextEvt);
	
		nextEvt = evt.nextInstanceAfter(LocalDateTime.of(2025, 3, 18, 17, 00));
		assertEquals(LocalDateTime.of(2025, 3, 25, 13, 30), nextEvt);
						
	}
	
	@Test
	void repeatableEventToString() {
		RepeatableEvent evt = new RepeatableEvent(
				"Poo - theorie", 
				LocalDateTime.of(2025, 3, 11, 13, 30),
				LocalDateTime.of(2025, 3, 11, 15, 30),
				7
				);
		
		System.out.println(evt);
						
	}

}
