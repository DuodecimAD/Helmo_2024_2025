package poo.lecon07;

public class YoutubeProgram {

	public static void main(String[] args) {
		
		YoutubeChannel channel1 = new YoutubeChannel("CodeAesthetic");
		YoutubeChannel channel2 = new YoutubeChannel("MIT 6.006");
		
		YoutubeSubscriber COMAR = new DefaultYoutubeSubscriber("COMAR");
		YoutubeSubscriber HENNI = new DefaultYoutubeSubscriber("HENNI");
		YoutubeSubscriber LIESI = new DefaultYoutubeSubscriber("LIESI");
		
		
		channel1.subscribe(COMAR);
		channel1.subscribe(HENNI);
		
		channel2.subscribe(HENNI);
		channel2.subscribe(LIESI);
		
		channel1.publish("PHP ça craint");
		channel2.publish("Codage en binaire");
		
		channel1.unsubscribe(HENNI);
		channel1.publish("PHP sucks");

	}

}
