package poo.labo06;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

import org.junit.jupiter.api.Test;

/**
 * Valide l'itérateur filtrant les balises
 * */
class ChannelByTagIteratorTest {
	private static final Channel LA_UNE = new Channel("La Une", List.of(Tag.PUBLIC, Tag.FRENCH));
	private static final Channel LA_DEUX = new Channel("La Deux", List.of(Tag.PUBLIC, Tag.FRENCH));
	private static final Channel RTL_TVI = new Channel("RTL-TVI", List.of(Tag.PRIVATE, Tag.FRENCH));
	private static final Channel CLUB_RTL = new Channel("Club RTL", List.of(Tag.PRIVATE, Tag.FRENCH));
	private static final Channel VTM = new Channel("VTM", List.of(Tag.PRIVATE, Tag.DUTCH));
	private static final Channel VRT = new Channel("VRT", List.of( Tag.PUBLIC, Tag.DUTCH));
	private static final List<Channel> CHANNELS = List.of(LA_UNE, LA_DEUX, VTM, RTL_TVI, CLUB_RTL, VRT);
	
	@Test
	void iteratesTroughChannelBasedOnTag() {
		final ChannelByTagIterator it = new ChannelByTagIterator(CHANNELS, Tag.PUBLIC);
		final List<Channel> got = new LinkedList<Channel>();

		while (it.hasNext()) {
			got.add(it.next());
		}

		assertEquals(List.of(LA_UNE, LA_DEUX, VRT), got);

	}
	
	@Test
	void throwsExceptionOnNullCollection() {
		assertThrows(NullPointerException.class, () -> { 
			new ChannelByTagIterator(null, Tag.PUBLIC); 
		});

	}
	
	@Test
	void iteratesWithoutMatch() {
		final ChannelByTagIterator it = new ChannelByTagIterator(CHANNELS, Tag.GENERAL);
		
		assertFalse(it.hasNext());
		assertThrows(NoSuchElementException.class, () -> {
			it.next();
		});

	}

}
