package poo.labo06;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

/**
 * tests sur ChannelPackage
 */
class ChannelPackageTest {
	
	private static final Channel LA_UNE = new Channel("La Une", List.of(Tag.PUBLIC, Tag.FRENCH));
	private static final Channel LA_DEUX = new Channel("La Deux", List.of(Tag.PUBLIC, Tag.FRENCH));
	private static final Channel RTL_TVI = new Channel("RTL-TVI", List.of(Tag.PRIVATE, Tag.FRENCH));
	private static final Channel CLUB_RTL = new Channel("Club RTL", List.of(Tag.PRIVATE, Tag.FRENCH));
	private static final Channel VTM = new Channel("VTM", List.of(Tag.PRIVATE, Tag.DUTCH));
	private static final Channel VRT = new Channel("VRT", List.of( Tag.PUBLIC, Tag.DUTCH));
	private static final List<Channel> CHANNELS = List.of(LA_UNE, LA_DEUX, VTM, RTL_TVI, CLUB_RTL, VRT);

	@Test
	void itterationSurChannelPackqage() {
		
		Set<Channel> channels = new HashSet<>();
		channels.addAll(List.of(
						new Channel("RTBF", List.of(Tag.FRENCH, Tag.GENERAL, Tag.PUBLIC)), 
						new Channel("VTM", List.of(Tag.DUTCH, Tag.GENERAL, Tag.PRIVATE))
						));
		
		ChannelPackage package1 = new ChannelPackage(CHANNELS);	
		ChannelPackage package2 = new ChannelPackage(CHANNELS);
		
		assertIterableEquals(package1, package2);
	}
	
	@Test
	void itterationSurTags() {
		
		ChannelPackage package1 = new ChannelPackage(CHANNELS);		
		
		Iterator<Channel> iterable = package1.iteratorForTag(Tag.FRENCH);
		
		final List<Channel> got = new LinkedList<Channel>();
		
		while (iterable.hasNext()) {
			got.add(iterable.next());
		}
		
		assertEquals(List.of(LA_UNE, LA_DEUX, RTL_TVI, CLUB_RTL), got);
	}
	
	@Test
	void itterationSurTagsNull() {
		
		ChannelPackage package1 = new ChannelPackage(CHANNELS);		
		
		assertThrows(NullPointerException.class, () -> {
					package1.iteratorForTag(null);
				});
	}

}
