package poo.lecon07;

import java.util.ArrayList;
import java.util.List;

public class FakeYouTubeSubscriber implements YouTubeSubscriber {

	private List<String> videos = new ArrayList<String>();
	
	public boolean videoReceived(String channelName, String videoName) {
		String entry = channelName+videoName;
		return videos.contains(entry);
	}

	@Override
	public void onNewVideo(String channelName, String videoName) {
		String entry = channelName+videoName;
		videos.add(entry);
		
	}

	
}
