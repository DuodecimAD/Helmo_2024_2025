package poo.lecon04;

import java.util.Objects;

public class VideoGame {
	private final String name;
	private final PEGIAge pegiAge;

	public VideoGame() {
//		this.name = "";
//		this.pegiAge = PEGIAge.PEGI_3;
		
		this("");
	}
	
	public VideoGame(String name) {
//		this.name = name;
//		this.pegiAge = PEGIAge.PEGI_3;	
		
		this(name, PEGIAge.PEGI_3);
	}
	
	public VideoGame(String name, PEGIAge pegiAge) {
		this.name = name;
		this.pegiAge = pegiAge;
		
	}
	
	public VideoGame(VideoGame copy) {
//		VideoGame newCopy = Objects.requireNonNullElse(copy, new VideoGame());
//		name = newCopy.name;
//		pegiAge = newCopy.pegiAge;	
		
		this(copy != null ? copy.name : "", copy != null ? copy.pegiAge : PEGIAge.PEGI_3);
	}
	
	//DONE: exercice 1
	
	public String getName() {
		return name;
	}

	public PEGIAge getPegiAge() {
		return pegiAge;
	}
	
	public boolean isAllowed(int age) {
		return this.pegiAge.isAllowed(age);
	}

	public String toString() {
		return String.format("VideoGame(name: %s, PEGI: %s)", name, pegiAge);
	}
 }
