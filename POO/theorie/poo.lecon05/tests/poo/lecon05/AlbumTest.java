package poo.lecon05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class AlbumTest {
	@Test
	void computesDuration() {
		var artist = new Artist("J. Hendrix",
				LocalDate.of(1942, 11, 27));
		var songs = new Song[] {
			new Song("Foxy Lady", 190),
			new Song("Maniac Depression", 211),
			new Song("Red House", 225)
		};
		var album = new Album("Are you experienced",
				artist, songs);
		
		var got = album.getDuration();
		
		assertEquals(10, got.toMinutes());
		assertEquals(26, got.toSecondsPart());
	}
}

