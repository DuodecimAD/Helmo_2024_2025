package poo.labo02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LevelTest {
	@Test
	void knowsHisName() {
		assertEquals("Headmaster", Level.HEADMASTER.getName());
		assertEquals("Professor", Level.PROFESSOR.getName());
		assertEquals("Graduated", Level.GRADUATED.getName());
		assertEquals("Student", Level.STUDENT.getName());
	}
	
	@Test
	void knowsHisTime() {
		assertEquals(1, Level.HEADMASTER.getTime());
		assertEquals(3, Level.PROFESSOR.getTime());
		assertEquals(5, Level.GRADUATED.getTime());
		assertEquals(7, Level.STUDENT.getTime());
	}
}
