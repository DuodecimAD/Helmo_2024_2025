package poo.lecon03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class WeekDayTest {
	@Test
	public void validatingMonday() {
		WeekDay today = WeekDay.Monday;
		
		assertEquals(WeekDay.Tuesday, today.tomorrow());
		assertEquals(WeekDay.Sunday, today.yesterday());		
	}
	
	@Test
	public void validatingTuesday() {
		WeekDay today = WeekDay.Tuesday;
		
		assertEquals(WeekDay.Wednesday, today.tomorrow());
		assertEquals(WeekDay.Monday, today.yesterday());		
	}
	
	@Test
	public void validatingWednesday() {
		WeekDay today = WeekDay.Wednesday;
		
		assertEquals(WeekDay.Thursday, today.tomorrow());
		assertEquals(WeekDay.Tuesday, today.yesterday());		
	}
	
	@Test
	public void validatingThursday() {
		WeekDay today = WeekDay.Thursday;
		
		assertEquals(WeekDay.Friday, today.tomorrow());
		assertEquals(WeekDay.Wednesday, today.yesterday());		
	}
	
	@Test
	public void validatingFriday() {
		WeekDay today = WeekDay.Friday;
		
		assertEquals(WeekDay.Saturday, today.tomorrow());
		assertEquals(WeekDay.Thursday, today.yesterday());		
	}
	
	@Test
	public void validatingSaturday() {
		WeekDay today = WeekDay.Saturday;
		
		assertEquals(WeekDay.Sunday, today.tomorrow());
		assertEquals(WeekDay.Friday, today.yesterday());		
	}
	
	@Test
	public void validatingSunday() {
		WeekDay today = WeekDay.Sunday;
		
		assertEquals(WeekDay.Monday, today.tomorrow());
		assertEquals(WeekDay.Saturday, today.yesterday());		
	}
}
