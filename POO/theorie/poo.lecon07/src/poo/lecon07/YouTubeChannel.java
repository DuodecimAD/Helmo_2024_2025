package poo.lecon07;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class YouTubeChannel {
	private String name;
	private Set<YouTubeSubscriber> subscribers;
	
	public YouTubeChannel(String channelName) {
		this(channelName, new HashSet<>());
	}
	
	// La dépendance est injectée
	// la dépendance est detype abstrait => inversée
	public YouTubeChannel(String channelName, Collection<YouTubeSubscriber> subscribers) {
		this.name = channelName;
		this.subscribers = new HashSet<YouTubeSubscriber>(subscribers);
	}
	

	public void subscribe(YouTubeSubscriber sub) {
		Objects.requireNonNull(sub);
		subscribers.add(sub);
	}
	

	public void unsubscribe(YouTubeSubscriber sub) {
		Objects.requireNonNull(sub);
		subscribers.remove(sub);
	}
	

	public int getSubscribersCount() {
		return subscribers.size();
	}
	
	public void publish(String videoName) {
		for(var subscriber : this.subscribers) {
			subscriber.onNewVideo(name, videoName);
		}
	}

}
