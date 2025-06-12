package poo.labo06;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class ChannelPackage implements Iterable<Channel> {

	private Set<Channel> channels;
	
	public ChannelPackage() {
		this(new ArrayList<>());
	}
	
	public ChannelPackage(Collection<Channel> channels) {
		Objects.requireNonNull(channels);
		
		this.channels = new LinkedHashSet<>(channels);
	}

	@Override
	public Iterator<Channel> iterator() {
		return Collections.unmodifiableCollection(channels).iterator();
	}
	
	public void add(Channel...newChannels) {
		channels.addAll(channels);
	}
	
	public int getChannelCount() {
		return channels.size();
	}
	
	public Iterator<Channel> iteratorForTag(Tag tag){
		return new ChannelByTagIterator(channels, tag);
	}

	@Override
	public String toString() {
		return "ChannelPackage [channels=" + channels + "]";
	}
	
	

}
