package poo.lecon05;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class RepeatableEventTest {

	
	@Test
	void instanceOfBothEventAndRepeatableEvent() {
		RepeatableEvent evt = new RepeatableEvent(
				"Poo - theorie", 
				LocalDateTime.of(2025, 3, 11, 13, 30),
				LocalDateTime.of(2025, 3, 11, 15, 30),
				7);
		
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

	@Test
	void containsTest() {
		RepeatableEvent evt = new RepeatableEvent(
				"Poo - theorie", 
				LocalDateTime.of(2025, 3, 11, 13, 30),
				LocalDateTime.of(2025, 3, 11, 15, 30),
				7
				);
		
		System.out.println(evt);
						
	}
	
	@Test
	void equalsEquivalent() {
		RepeatableEvent evt = new RepeatableEvent(
				"Poo - theorie", 
				LocalDateTime.of(2025, 3, 11, 13, 30),
				LocalDateTime.of(2025, 3, 11, 15, 30),
				7
				);
		RepeatableEvent evt2 = new RepeatableEvent(
				"Poo - theorie", 
				LocalDateTime.of(2025, 3, 11, 13, 30),
				LocalDateTime.of(2025, 3, 11, 15, 30),
				7
				);
		assertTrue(evt.equals(evt2));
	}
	
	@Test
	void equalsDifferent() {
		RepeatableEvent evt = new RepeatableEvent(
				"Poo - theorie", 
				LocalDateTime.of(2025, 3, 11, 13, 30),
				LocalDateTime.of(2025, 3, 11, 15, 30),
				7
				);
		RepeatableEvent evt2 = new RepeatableEvent(
				"Algo - Labo", 
				LocalDateTime.of(2025, 3, 19, 13, 30),
				LocalDateTime.of(2025, 3, 19, 15, 30),
				7
				);
		assertFalse(evt.equals(evt2));
	}
	
	
	
	@Test
	void computesTheNextOccurenceOfItself() {
		RepeatableEvent evt = new RepeatableEvent(
				"Poo - theorie", 
				LocalDateTime.of(2025, 3, 11, 13, 30),
				LocalDateTime.of(2025, 3, 11, 15, 30),
				7);
		
		LocalDateTime nextEvt = evt.nextInstanceAfter(LocalDateTime.of(2025, 3, 13, 8, 30));
		assertEquals(LocalDateTime.of(2025, 3, 18, 13, 30), nextEvt);
		
		nextEvt = evt.nextInstanceAfter(LocalDateTime.of(2025, 3, 18, 17, 00));
		assertEquals(LocalDateTime.of(2025, 3, 25, 13, 30), nextEvt);
		
	}

	@Test
	void equatesToAnotherRepteableEvent() {
		RepeatableEvent evt1 = new RepeatableEvent(
				"Poo - theorie", 
				LocalDateTime.of(2025, 3, 11, 13, 30),
				LocalDateTime.of(2025, 3, 11, 15, 30),
				7);
		RepeatableEvent evt2 = new RepeatableEvent(
				"Poo - theorie", 
				LocalDateTime.of(2025, 3, 11, 13, 30),
				LocalDateTime.of(2025, 3, 11, 15, 30),
				7);
		
		//assertEquals(evt1, evt2); // appelle equals(Object), pas equals(RepeatableEvent)
		assertTrue(evt1.equals(evt2)); // appelle equals(RepeatableEvent)
	}
	
	@Test
	void inequatesToAnotherRepteableEvent() {
		RepeatableEvent evt1 = new RepeatableEvent(
				"Poo - theorie", 
				LocalDateTime.of(2025, 3, 11, 13, 30),
				LocalDateTime.of(2025, 3, 11, 15, 30),
				7);
		RepeatableEvent evt2 = new RepeatableEvent(
				"Poo - labo", 
				LocalDateTime.of(2025, 3, 11, 13, 30),
				LocalDateTime.of(2025, 3, 11, 15, 30),
				7);
		
		//assertNotEquals(evt1, evt2); // appelle equals(Object), pas equals(RepeatableEvent)
		assertFalse(evt1.equals(evt2)); // appelle equals(RepeatableEvent)
	}
	
	@Test
	void overiddesToString() {
		RepeatableEvent evt = new RepeatableEvent(
				"Poo - theorie", 
				LocalDateTime.of(2025, 3, 11, 13, 30),
				LocalDateTime.of(2025, 3, 11, 15, 30),
				7);
		
		String actual = evt.toString();
		
		assertTrue(actual.contains("freq=7"));
		// the fuck ?
		//assertTrue(actual.contains("super=Event"));
	}
	
	@Test
	void containsADateTime() {
		RepeatableEvent evt = new RepeatableEvent(
				"Poo - theorie", 
				LocalDateTime.of(2025, 3, 11, 13, 30),
				LocalDateTime.of(2025, 3, 11, 15, 30),
				7);
		
		assertFalse(evt.contains(LocalDateTime.of(2025, 3, 18, 13, 29)));
		assertTrue(evt.contains(LocalDateTime.of(2025, 3, 18, 13, 30)));
		assertTrue(evt.contains(LocalDateTime.of(2025, 3, 18, 14, 30)));
		assertFalse(evt.contains(LocalDateTime.of(2025, 3, 18, 15, 30)));
		
		assertFalse(evt.contains(LocalDateTime.of(2025, 3, 25, 13, 29)));
		assertTrue(evt.contains(LocalDateTime.of(2025, 3, 25, 13, 30)));
		assertTrue(evt.contains(LocalDateTime.of(2025, 3, 25, 14, 30)));
		assertFalse(evt.contains(LocalDateTime.of(2025, 3, 25, 15, 30)));
		
	}
	
}
