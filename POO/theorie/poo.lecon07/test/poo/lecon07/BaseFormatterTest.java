package poo.lecon07;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class BaseFormatterTest {

	@Test
	void test() {
		BaseFormatter formatter = new HtmlFormatter();
		String formatted = formatter.format("coucour", List.of(
				"Je suis en POO.",
				"Quelle galère !"
				));
	}

}
