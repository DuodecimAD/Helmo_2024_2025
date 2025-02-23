package poo.labo02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WizardTest {
	@Test
	void knowsHisName() {
		Wizard harry = new Wizard("Harry Potter", Level.HEADMASTER);
		Wizard tom = new Wizard(null, Level.HEADMASTER);
	
		assertEquals("Harry Potter", harry.getName());
		assertEquals("You-Know-Who", tom.getName());
//		fail("Décommente-moi");
	}
	
	@Test
	void initsLevelWithStudentWhenGivenLevelIsNull() {
		Wizard harry = new Wizard("Harry Potter", null);
	
		assertEquals(Level.STUDENT, harry.getLevel());
//		fail("Décommente-moi");
	}
	
	@Test
	void initsLevelWithHeadmasterWhenActualNameIsYouKnowWho() {
		Wizard voldemort = new Wizard(null, null);
		Wizard tomRiddle = new Wizard("You-Know-Who", Level.PROFESSOR);
		
		assertEquals(Level.HEADMASTER, voldemort.getLevel());
		assertEquals(Level.HEADMASTER, tomRiddle.getLevel());
//		fail("Décommente-moi");
	}
	
	@Test
	void castsSpell() {
		Wizard harry = new Wizard("Harry Potter", Level.GRADUATED);
		Spell stupefy = new Spell("Stupefy");
		
		assertEquals("Harry Potter casts STUPEFY !", harry.cast(stupefy));
//		fail("Décommente-moi");
	}
	
	@Test
	void castsNothingOnNull() {
		Wizard harry = new Wizard("Harry Potter", Level.GRADUATED);
		
		assertEquals("Harry Potter casts nothing.", harry.cast(null));
//		fail("Décommente-moi");
	}
	
	@Test
	void levelsUpToGraduatedAfterTimeCasts() {
		Wizard harry = new Wizard("Harry Potter", Level.STUDENT);
		Spell stupefy = new Spell("Stupefy");
		
		// Cette méthode est la dernière de la classe. Elle est à décommenter.
		repeatCasts(harry, stupefy, Level.STUDENT.getTime());
		
		assertEquals(Level.GRADUATED, harry.getLevel());
//		fail("Décommente-moi");
	}
	
	@Test
	void levelsUpToProfessorAfterTimeCasts() {
		Wizard harry = new Wizard("Remus Lupin", Level.GRADUATED);
		Spell stupefy = new Spell("Stupefy");
		
		repeatCasts(harry, stupefy,  Level.GRADUATED.getTime());
		
		assertEquals( Level.PROFESSOR, harry.getLevel());
//		fail("Décommente-moi");
	}
	
	@Test
	void levelsUpToDirectorAfterTimeCasts() {
		Wizard rogue = new Wizard("Severus Rogue", Level.PROFESSOR);
		Spell stupefy = new Spell("Stupefy");
		
		repeatCasts(rogue, stupefy, Level.PROFESSOR.getTime());
		
		assertEquals(Level.HEADMASTER, rogue.getLevel());
//		fail("Décommente-moi");
	}
	
	@Test
	void stopsLevellingAtHeadmaster() {
		Wizard ron = new Wizard(null, Level.HEADMASTER);
		Spell stupefy = new Spell("Stupefy");
		
		repeatCasts(ron, stupefy, 10);
		
		assertEquals(Level.HEADMASTER, ron.getLevel());
//		fail("Décommente-moi");
	}
	
	@Test
	void ignoresLevelUpWhenCastingNull() {
		Wizard ron = new Wizard("Ron Weasley", Level.STUDENT);
		
		repeatCasts(ron, null, 10);
		
		assertEquals(Level.STUDENT, ron.getLevel());
//		fail("Décommente-moi");
	}
	
	private void repeatCasts(Wizard w, Spell s, int times) {
		for(int i=0; i < times; ++i) {
			w.cast(s);
		}
	}
}
