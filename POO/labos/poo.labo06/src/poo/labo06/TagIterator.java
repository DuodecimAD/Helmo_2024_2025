package poo.labo06;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * 
 */
public class TagIterator implements Iterator<Tag> {

	private final List<Tag> tagList;
	private int nextPosition;
	
	/**
	 * 
	 * @param tags
	 */
	public TagIterator(Collection<Tag> tags) {
		this.tagList = new ArrayList<>(tags);
		nextPosition = 0;
	}

	@Override
	public boolean hasNext() {
		return nextPosition < tagList.size();
	}

	@Override
	public Tag next() {
		if(!hasNext()) {
			throw new NoSuchElementException();
		}
		return tagList.get(nextPosition++);
	}

}
