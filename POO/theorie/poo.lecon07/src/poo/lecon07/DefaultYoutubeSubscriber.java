package poo.lecon07;

public class DefaultYoutubeSubscriber implements YoutubeSubscriber  {

	public DefaultYoutubeSubscriber(String string) {
		
	}

	@Override
	public void onNewVideo(String channelName, String videoName) {
		
		System.out.println(videoName + ", " + channelName + " has released " + videoName);
		
	}

}
