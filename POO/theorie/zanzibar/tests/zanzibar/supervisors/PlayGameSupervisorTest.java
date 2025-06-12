package zanzibar.supervisors;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import zanzibar.domains.FakeGameFactory;
import zanzibar.views.FakePlayGameView;

class PlayGameSupervisorTest {

	@Test
	void should_get_the_last_created_game_on_enter() {
		var factory = new FakeGameFactory();
		var view = new FakePlayGameView();
		var supervisor = new PlayGameSupervisor(factory);
		supervisor.setView(view);
		
		supervisor.onEnter("MainMenuView");
		
		//TODO: complète-moi
	}

	@Test
	void should_refresh_view_on_enter() {
		//TODO: complète-moi
	}
}
