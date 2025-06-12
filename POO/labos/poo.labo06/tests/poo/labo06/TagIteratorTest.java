package poo.labo06;


import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

/**
 * Valide l'implémentation de l'itérateur.
 * */
class TagIteratorTest {
	@Test
	void indicatesWhetherItHasANextElement() {
		TagIterator it1 = new TagIterator(List.of(Tag.FRENCH));
		
		assertTrue(it1.hasNext());
		assertEquals(Tag.FRENCH, it1.next());

	}
	
	
	@Test
	void browseAsCollection() {
		Iterator<Tag> it = new TagIterator(List.of(Tag.FRENCH, Tag.DUTCH, Tag.GENERAL));
		
		List<Tag> toArray = new ArrayList<Tag>();
		
		while(it.hasNext()){
			toArray.add(it.next());
		}
		
		assertArrayEquals(new Tag[] {Tag.FRENCH, Tag.DUTCH, Tag.GENERAL}, toArray.toArray(new Tag[] {}) );
		
		
	}
}
