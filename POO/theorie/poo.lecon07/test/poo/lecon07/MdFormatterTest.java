package poo.lecon07;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class MdFormatterTest {

	@Test
	void handleMarkdown() {
		var formatter = new MdFormatter();
		
		assertTrue(formatter.canHandle("markdown"));
		assertTrue(formatter.canHandle("md"));
		assertTrue(formatter.canHandle("MD"));
		assertFalse(formatter.canHandle("html"));
	}
	
	@Test
	void formatToMarkdown() {
		var formatter = new MdFormatter();
		
		var actual = formatter.format(
				"Bonjour", 
				List.of(
						"Je m'appelle Nicolas.",
						"J'ai dix ans... Et toutes mes dents.")).strip();
		
		var expected = """
# Bonjour
Je m'appelle Nicolas.
J'ai dix ans... Et toutes mes dents.				
				""".strip();
		
		assertEquals(expected, actual);
	}

}
