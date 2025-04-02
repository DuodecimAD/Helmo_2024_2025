package poo.lecon07;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class HtmlFormatterTest {

	@Test
	void handleHtml() {
		var formatter = new HtmlFormatter();
		
		assertFalse(formatter.canHandle("MD"));
		assertTrue(formatter.canHandle("html"));
	}

	@Test
	void formatsToHtml() {
		var formatter = new HtmlFormatter();
		
		var actual = formatter.format(
				"Bonjour", 
				List.of(
						"Je m'appelle Nicolas.",
						"J'ai dix ans... Et toutes mes dents.")).strip();
		
		var expected = """
<section>
<h1>Bonjour</h1>
<p>Je m'appelle Nicolas.</p>
<p>J'ai dix ans... Et toutes mes dents.</p>
</section>				
				""".strip();
		
		assertEquals(expected, actual);
	}
}
