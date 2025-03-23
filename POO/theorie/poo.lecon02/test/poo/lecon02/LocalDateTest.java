package poo.lecon02;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class LocalDateTest {

	@Test
	public void date_55() {
		LocalDate dayOfYear = LocalDate.of(2020,02,24);
		assertEquals(55, dayOfYear.getDayOfYear());
	}
	
	@Test
	public void datePlusAWeek() {
		LocalDate dayOfYear = LocalDate.of(2020,02,24);
		assertEquals("2020-03-02", dayOfYear.plusWeeks(1).toString());
		
	}
}
