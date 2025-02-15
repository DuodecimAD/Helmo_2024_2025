package utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class WordFrequenciesTest {
	private static final String CHICKEN_SONG = 	"quand trois poules vont aux champs, la première va devant."+
												"la deuxieme suit la premiere."+
												"la troisieme vient en derniere."+
												"quand trois poules vont aux champs, la première va devant.";
	
	private static final String LOVE_SONG = 	"il y a longtemps que je t'aime."+
												"jamais je ne t'oublierai.";

	@Test
	void computesWordsFrequenciesWhenEachWordsAppearsInTheSentenceA() {
		String[] words = {"quand", "poules", "la"};
		
		Object[][] frequencies = WordsFrequencies.computeWordsFrequencies(words, CHICKEN_SONG);
		
		assertEquals(3, frequencies.length);
		assertEquals("quand", frequencies[0][0]);
		assertEquals(2, frequencies[0][1]);
		assertEquals("poules", frequencies[1][0]);
		assertEquals(2, frequencies[1][1]);
		assertEquals("la", frequencies[2][0]);
		assertEquals(5, frequencies[2][1]);
	}
	
	@Test
	void computesWordsFrequenciesWhenEachWordsAppearsInTheSentenceB() {
		String[] words = {"je", "t"};
		
		Object[][] frequencies = WordsFrequencies.computeWordsFrequencies(words, LOVE_SONG);
		
		assertEquals(2, frequencies.length);
		assertEquals("je", frequencies[0][0]);
		assertEquals(2, frequencies[0][1]);
		assertEquals("t", frequencies[1][0]);
		assertEquals(2, frequencies[1][1]);
	}
	
	@Test
	void computesWordsFrequenciesWhenEachWordsDoesNotAppearInTheSentence() {
		String[] words = {"quand", "coq", "la"};
		
		Object[][] frequencies = WordsFrequencies.computeWordsFrequencies(words, CHICKEN_SONG);
		
		assertEquals(3, frequencies.length);
		assertEquals("quand", frequencies[0][0]);
		assertEquals(2, frequencies[0][1]);
		assertEquals("coq", frequencies[1][0]);
		assertEquals(0, frequencies[1][1]);
		assertEquals("la", frequencies[2][0]);
		assertEquals(5, frequencies[2][1]);
	}
	
	@Test
	void computesNoFrequencyWhenNoWords() {
		String[] words = {};
		
		Object[][] frequencies = WordsFrequencies.computeWordsFrequencies(words, CHICKEN_SONG);
		
		assertEquals(0, frequencies.length);
	}
	
	@Test
	void computesNoFrequencyWhenNullWord() {
		Object[][] frequencies = WordsFrequencies.computeWordsFrequencies(null, CHICKEN_SONG);
		
		assertEquals(0, frequencies.length);
	}
	
	@Test
	void computesZeroFrequenciesWhenNullSentence() {
		String[] words = {"quand", "coq", "la"};
		
		Object[][] frequencies = WordsFrequencies.computeWordsFrequencies(words, null);
		
		assertEquals(3, frequencies.length);		
		
		assertEquals("quand", frequencies[0][0]);
		assertEquals(0, frequencies[0][1]);
		assertEquals("coq", frequencies[1][0]);
		assertEquals(0, frequencies[1][1]);
		assertEquals("la", frequencies[2][0]);
		assertEquals(0, frequencies[2][1]);
	}
	
	
}
