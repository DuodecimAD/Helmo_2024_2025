package poo.labo06;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.*;

/**
 * Valide la classe Channel
 * */
class ChannelTest {
	private static final String LA_UNE = "La une";

	@Test
	void hasAName() {
		var channel = new Channel(LA_UNE, List.of(Tag.GENERAL, Tag.FRENCH,Tag.PUBLIC));
		assertEquals(LA_UNE, channel.getName());

	}
	
	@Test
	void containsTags() {
		var channel = new Channel(LA_UNE, List.of(Tag.GENERAL, Tag.FRENCH,Tag.PUBLIC));
		
		assertTrue(channel.hasTag(Tag.GENERAL));
		assertTrue(channel.hasTag(Tag.PUBLIC));		
		assertFalse(channel.hasTag(Tag.PRIVATE));
		
		assertFalse(channel.hasTag(Tag.DUTCH));
		assertThrows(NullPointerException.class, () -> {channel.hasTag(null);});

	}
	
	@Test
	void makesACopyOfTheCollection() {
		var mutableList = new ArrayList<>(List.of(Tag.GENERAL, Tag.FRENCH,Tag.PUBLIC));
		var channel = new Channel(LA_UNE, mutableList);
		
		mutableList.clear();
		
		assertTrue(channel.hasTag(Tag.GENERAL));
		assertTrue(channel.hasTag(Tag.FRENCH));
		assertTrue(channel.hasTag(Tag.PUBLIC));	

	}
	
	@Test
	void makesIterators() {
		var channel = new Channel(LA_UNE, List.of(Tag.GENERAL, Tag.FRENCH,Tag.PUBLIC));
		
		final Iterator<Tag> tagIt1 = channel.iterator();
		final Iterator<Tag> tagIt2 = channel.iterator();
		
		assertNotNull(tagIt1);
		assertNotNull(tagIt2);
		assertNotSame(tagIt1, tagIt2,"iterator should provide a new TagIterator object.");

	}
	
	@Test
	void iteratesTroughTags() {
		var channel = new Channel(LA_UNE, List.of(Tag.GENERAL, Tag.FRENCH,Tag.PUBLIC));
		
		var expected = new Tag[] { Tag.GENERAL, Tag.FRENCH,Tag.PUBLIC };
		var got = new Tag[3];
		int pos = 0;
		
		for(Tag t : channel) {
			got[pos++] = t;
		}
		
		assertArrayEquals(expected, got);

	}
	

	// Ecrire des tests pour l'exercice 4
	@Test
	void test() {
		// TODO récupérer solutions
	}
	
}
