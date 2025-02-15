package utils;

public class WordsFrequencies {
	public static Object[][] computeWordsFrequencies(String[] words, String t) {
		if(words == null || words.length == 0) {
			return new Object[0][];
		}
		
		int[] frequencies = new int[words.length];
		t = (t == null ? "" : t);
		
		for(String word : t.split("(\\s|\\p{Punct})+")) {
			int wordIndex = indexOf(word, words);
			if(wordIndex >= 0) {
				frequencies[wordIndex]++;
			}
		}
		
		return makePairs(words, frequencies);
	}

	private static Object[][] makePairs(String[] words, int[] frequencies) {
		Object[][] result = new Object[words.length][2];
		for(int i=0; i < result.length; ++i) {
			result[i][0] = words[i];
			result[i][1] = frequencies[i];
		}
		return result;
	}

	private static int indexOf(String key, String[] array) {
		int position = -1;
		
		for(int i=0; i < array.length && position == -1; ++i) {
			if(key.equals(array[i])) {
				position = i;
			}
		}
		
		return position;
	}
}
