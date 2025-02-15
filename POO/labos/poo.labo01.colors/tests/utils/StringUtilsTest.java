package utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringUtilsTest {

	@Test
	void min_test() {
		assertEquals("abc", StringUtils.min("abc", "def"));
		assertEquals("Abc", StringUtils.min("Abc", "Abc"));
		assertEquals("Def", StringUtils.min("def", "Def"));
	}
	
	@Test
	void minNull_test() {
		assertEquals("", StringUtils.min(null, "abc"));
		assertEquals("", StringUtils.min("def", null));
		assertEquals("", StringUtils.min(null, null));
	}
	
	@Test
	void max_test() {
		assertEquals("def", StringUtils.max("abc", "def"));
		assertEquals("Abc", StringUtils.max("Abc", "Abc"));
		assertEquals("def", StringUtils.max("def", "Def"));
	}
	
	@Test
	void maxNull_test() {
		assertEquals("abc", StringUtils.max(null, "abc"));
		assertEquals("def", StringUtils.max("def", null));
		assertEquals("", StringUtils.max(null, null));
	}
	
	@Test
	void wordToTitleCase_test() {
		assertEquals("Abc", StringUtils.wordToTitleCase("abc"));
		assertEquals("Abc", StringUtils.wordToTitleCase("aBC"));
		assertEquals("Def", StringUtils.wordToTitleCase("DEF"));
		assertEquals("Def", StringUtils.wordToTitleCase(" \tDEF"));
		assertEquals("Def", StringUtils.wordToTitleCase("def \n"));
		assertEquals("Abc", StringUtils.wordToTitleCase("\t abc \t"));
	}
	
	@Test
	void wordToTitleCaseNull_test() {
		assertEquals("", StringUtils.wordToTitleCase(null));
		assertEquals("", StringUtils.wordToTitleCase(" \t "));
		assertEquals("", StringUtils.wordToTitleCase(""));
	}
	
	@Test
	void sentenceToTitleCase_test() {
		assertEquals("Bonjour Tout Va Bien", StringUtils.sentenceToTitleCase("bonjour TOUT va BiEN"));
		assertEquals("Bonjour Tout Va Bien", StringUtils.sentenceToTitleCase("BONJOUR, TOUT VA BIEN !"));
		assertEquals("\u0391 \u0392 \u0393", StringUtils.sentenceToTitleCase("\u03b1, \u03b2, \u03b3."));
		assertEquals("", StringUtils.sentenceToTitleCase(" \t \n"));
		assertEquals("", StringUtils.sentenceToTitleCase(null));
		
	}
	
	@Test
	void sentenceToTitleCase_test1() {
		assertEquals("Bonjour Tout Va Bien", StringUtils.sentenceToTitleCase("bonjour TOUT va BiEN"));
	}
	
	@Test
	void sentenceToTitleCase_test2() {
		assertEquals("Bonjour Tout Va Bien", StringUtils.sentenceToTitleCase("BONJOUR, TOUT VA BIEN !"));
	}
	
	@Test
	void sentenceToTitleCase_test3() {
		assertEquals("\u0391 \u0392 \u0393", StringUtils.sentenceToTitleCase("\u03b1, \u03b2, \u03b3."));
	}
	
	@Test
	void sentenceToTitleCase_test4() {
		assertEquals("", StringUtils.sentenceToTitleCase(" \t \n"));
	}
	
	@Test
	void sentenceToTitleCase_test5() {
		assertEquals("", StringUtils.sentenceToTitleCase(null));
	}

}
