package lecon09.cards;

import java.util.Objects;


/**
 * Liste de carte unique avec Set
 * Deck list avec une Map
 */
public class YGHCard extends BaseCard implements Comparable<YGHCard>{
	private String name;
	private final Frame frame;
	/* Other attributes possibles */
	
	public YGHCard(String originalName, Frame cardType) {
		super(false); // Not visisble
		name = Objects.requireNonNull(originalName);
		frame = Objects.requireNonNull(cardType);
	}
	
	public String getName() {
		return name; // Could be more complex.
	}
	
	public String getColor() {
		return frame.getColor();
	}
	
	public String toString() {
		return "%s [%s]".formatted(name, frame);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(frame, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof YGHCard))
			return false;
		YGHCard other = (YGHCard) obj;
		return frame == other.frame && Objects.equals(name, other.name);
	}
	
	@Override
	public int compareTo(YGHCard other) {
		return this.name.compareTo(other.name);
	}
}
