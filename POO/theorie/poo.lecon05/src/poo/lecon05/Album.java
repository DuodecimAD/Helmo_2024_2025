package poo.lecon05;

import java.time.Duration;
import java.util.Arrays;
import java.util.Objects;


public class Album {

	public final static Artist DEFAULT_ARTIST = new Artist("Inconnu");
	private final String title;
	private final Artist artist;
	//private Duration duration;
	private final Song[] songs;
	
	public Album(String title, Artist artist, Song[] songs) {
		this.title = title == null ? "" : title;
		//this.artist = artist == null ? DEFAULT_ARTIST : artist;
		this.artist = Objects.requireNonNullElse(artist, DEFAULT_ARTIST);
		//this.songs = songs == null ? new Song[] {} : songs; // on donne la réfarence, pas bien
		this.songs = Arrays.copyOf(songs, songs.length);
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getArtistName() {
		return this.artist.getName();
	}
	
	public Duration getDuration() {
		Duration total = Duration.ZERO;
		for (Song song : songs) {
			total = total.plus(song.getDuration());
		}
		return total;
	}
	
	public Song getSongAt(int pos) {
//		if(pos >= 0 && pos < songs.length) {
//			return songs[pos];
//		} else {
//			return new Song(null);
//		}
		
		Objects.checkIndex(pos, songs.length);
		return songs[pos];
		
	}
}
