package poo.lecon05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SongTest {
	//DONE : exercice 1 partie a.
	@Test
	public void initsASongWithAName() {
		Song song2 = new Song("Song 2");
		Song unknownTitle = new Song(null);
		
		assertEquals("Song(title: Song 2, duration: 00:00)", song2.toString());
		assertEquals("Song(title: ?, duration: 00:00)", unknownTitle.toString());	
	}
	
	//DONE : exercice 2 partie b.
	@Test
	public void initsASongWithANameAndSeconds() {
		Song song2 = new Song("Song 2", 122);
		Song unknownTitle = new Song(null, 195);
		Song wrongDuration = new Song("Do you know what I mean ?", -1);
		
		assertEquals("Song(title: Song 2, duration: 02:02)", song2.toString());
		assertEquals("Song(title: ?, duration: 03:15)", unknownTitle.toString());
		assertEquals("Song(title: Do you know what I mean ?, duration: 00:01)", wrongDuration.toString());	
	}
	
}
