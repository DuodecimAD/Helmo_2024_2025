package poo.lecon05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class ArtistTest {
	
	@Test
	public void initsWithValidArgs() {
		Artist artist = new Artist("Mozart", LocalDate.of(1756, 1, 27));
		
		assertEquals("Mozart", artist.getName());
		assertEquals(269, artist.getAge());
	}
	
	@Test
	public void initsWithNull() {
		Artist artist = new Artist("Unix", null);
		
		assertEquals("Unix", artist.getName());
		assertEquals(55, artist.getAge());
	}
	
	@Test
	public void initsWithAFutureDate() {
		Artist artist = new Artist("Unix", LocalDate.now().plusDays(1));
		
		assertEquals("Unix", artist.getName());
		assertEquals(55, artist.getAge());
	}
}
