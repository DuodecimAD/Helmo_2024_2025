package poo.lecon07;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
//TODO relire pour comprendre souscription publish fonctionnement
public class YoutubeChannel {
	private String name;
	private Set<YoutubeSubscriber> subscribers;
	
	public YoutubeChannel(String channelName) {
		this(channelName, new HashSet<>());
	}
	
	// La dépendance est injectée
	// la dépendance est detype abstrait => inversée
	public YoutubeChannel(String channelName, Collection<YoutubeSubscriber> subscribers) {
		this.name = channelName;
		this.subscribers = new HashSet<YoutubeSubscriber>(subscribers);
	}
	

	public void subscribe(YoutubeSubscriber sub) {
		Objects.requireNonNull(sub);
		subscribers.add(sub);
	}
	

	public void unsubscribe(YoutubeSubscriber sub) {
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
