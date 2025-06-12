package poo.labo06;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/**
 * 
 */
public class ChannelByTagIterator implements Iterator<Channel> {
	
	private List<Channel> channels;
	private Tag tag;
	private int current = -1;

	public ChannelByTagIterator(Collection<Channel> channels, Tag tag) {
		Objects.requireNonNull(channels);
		Objects.requireNonNull(tag);
		
		this.channels = new ArrayList<>(channels);
		this.tag = tag;
	}

	@Override
	public boolean hasNext() {
		for (int i = current+1; i < channels.size(); i++) {
			if(channels.get(i).hasTag(tag)) {
				return true;
			}
		}

		return false;

	}

	@Override
	public Channel next() {

		for (int i = ++current; i < channels.size(); i++) {
			if(channels.get(current).hasTag(tag)) {
				return channels.get(current);
			}
			current++;
		}
		throw new NoSuchElementException();
	}

}
