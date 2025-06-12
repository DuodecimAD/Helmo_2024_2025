package poo.labo06;

import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/**
 * class implementant des objets de channels
 */
public class Channel implements Iterable<Tag>{
	
	private final String channelName;
	private final Set<Tag> tags;
	
	/**
	 * constructor initializing channelName and tags linked to this channel
	 * @param channelName
	 * @param tags
	 */
	public Channel(String channelName, Collection<Tag> tags) {
		if(Objects.requireNonNull(channelName).isBlank()) {
			throw new IllegalArgumentException("LE nom ne peut pas être vide");
		}
		this.channelName = channelName;
		//this.tags = new HashSet<>(Objects.requireNonNull(tags));
		this.tags = EnumSet.copyOf(Objects.requireNonNull(tags));
	}
	
	/**
	 * 
	 * @return channel name
	 */
	public String getName() {
		return this.channelName;
	}
	
	/**
	 * 
	 * @param tag
	 * @return true if tag is linked tho this channel
	 */
	public boolean hasTag(Tag tag) {
		return tags.contains(Objects.requireNonNull(tag));
	}

	@Override
	public Iterator<Tag> iterator() {
		return Collections.unmodifiableCollection(tags).iterator();//new TagIterator(tags);
	}

	@Override
	public int hashCode() {
		return Objects.hash(channelName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Channel)) {
			return false;
		}
		Channel other = (Channel) obj;
		return Objects.equals(channelName, other.channelName);
	}
	
	

	
}
