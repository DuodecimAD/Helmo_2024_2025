package poo.lecon05;

import java.time.Duration;

public class Song {
	private final String title;
	private final Duration duration;
	
	public Song(String title) {
		this(title, 0); 
	}
	
	public Song(String title, int seconds) {
		this.title = title == null ? "?" : title;
		this.duration = Duration.ofSeconds(seconds).abs();
	}
	
	public String getTitle() {
		return title;
	}
	
	public Duration getDuration() {
		return duration;
	}
	
	public String toString() {
//		int minutes = (int) (duration.getSeconds() / 60);
//		int secondes = (int) (duration.getSeconds() % 60);
		return String.format("Song(title: %s, duration: %02d:%02d)", title, duration.toMinutes(), duration.toSecondsPart());
	}
	

}

	
