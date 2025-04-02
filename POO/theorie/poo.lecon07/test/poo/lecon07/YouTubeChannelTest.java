package poo.lecon07;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;


class YouTubeChannelTest {

	@Test
	void acceptSubscriber() {
		var channel = new YouTubeChannel("POO");
		
		channel.subscribe(new FakeYouTubeSubscriber());
		assertEquals(1, channel.getSubscribersCount());
	}
	
	@Test
	void removeSubscriber() {
		var FakeYouTubeSubscriber = new FakeYouTubeSubscriber();
		var channel = new YouTubeChannel("POO", List.of(FakeYouTubeSubscriber));
		
		channel.unsubscribe(new FakeYouTubeSubscriber());
		assertEquals(0, channel.getSubscribersCount());
	}

	@Test
	void notifiesSubscribersOnNewVideo() {
		var FakeYouTubeSubscriber1 = new FakeYouTubeSubscriber();
		var FakeYouTubeSubscriber2 = new FakeYouTubeSubscriber();
		var channel = new YouTubeChannel("POO", List.of(FakeYouTubeSubscriber1));
		
		channel.publish("Leçon 07");
		assertTrue(FakeYouTubeSubscriber1.videoReceived("POO", "Leçon 07"));
		assertFalse(FakeYouTubeSubscriber2.videoReceived("POO", "Leçon 07"));
	}
}
