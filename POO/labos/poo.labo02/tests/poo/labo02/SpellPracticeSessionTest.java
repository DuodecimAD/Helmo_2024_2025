package poo.labo02;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SpellPracticeSessionTest {
	@Test
	public void returnsWizardsNames() {
		SpellPracticeSession session = new SpellPracticeSession();
		
		String[] expectedNames = new String[] {
			"Albus Dumbledore","Severus Rogue","Harry Potter","Hermione Granger", "Ronald Weasley", "You-Know-Who"
		};
		String[] actualNames = session.getWizardNames();
		
		assertArrayEquals(expectedNames, actualNames);
	}
	
	@Test
	public void returnsSpellsNames() {
		SpellPracticeSession session = new SpellPracticeSession();
		
		String[] expectedNames = new String[] {
			"STUPEFY","EXPECTO PATRONUM","WINGARDIUM LEVIOSA","MUCUS AD NUSEUM", "SILENCIO"
		};
		String[] actualNames = session.getSpellNames();
		
		assertArrayEquals(expectedNames, actualNames);
	}
	
	@Test
	public void asksWizardToCastSpell() {
		SpellPracticeSession session = new SpellPracticeSession();
		
		String[] actualMessages = session.practice(1, 0);
		String[] expectedMessages = new String[] {
				"Severus Rogue casts STUPEFY !"
		};
		
		assertEquals(actualMessages.length, expectedMessages.length);
		assertArrayEquals(expectedMessages, actualMessages);
	}
	
	@Test
	public void notifiesLevelUp() {
		SpellPracticeSession session = new SpellPracticeSession();
		
		session.practice(1, 2);
		session.practice(1, 1);
		String[] actualMessages = session.practice(1, 0);
		
		String[] expectedMessages = new String[] {
				"Severus Rogue casts STUPEFY !",
				"Level up : Severus Rogue became Headmaster"
		};
		
		assertEquals(actualMessages.length, expectedMessages.length);
		assertArrayEquals(expectedMessages, actualMessages);
	}
}
