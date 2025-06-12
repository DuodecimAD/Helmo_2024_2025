package zanzibar.supervisors;

import org.junit.jupiter.api.Test;

import zanzibar.domains.FakeGameFactory;
import zanzibar.views.FakeMainMenuView;

class MainMenuSupervisorTest {

	@Test
	void should_accept_exit_request() {
		var fakedFactory = new FakeGameFactory();
		var fakedView = new FakeMainMenuView();
		var supervisor = new MainMenuSupervisor(fakedFactory);
		supervisor.setView(fakedView);
		
		supervisor.onExitRequested();
		
		fakedView.received("exitConfirmed()");
	}
	
	@Test
	void should_create_a_new_game_on_new_game_requested() {
		var fakedFactory = new FakeGameFactory();
		var fakedView = new FakeMainMenuView();
		var supervisor = new MainMenuSupervisor(fakedFactory);
		supervisor.setView(fakedView);
		
		supervisor.onNewGameRequested(2);
		
		fakedFactory.received("newGame(2)");
	}
	
	@Test
	void should_navigate_to_play_game_view_on_new_game_requested() {
		var fakedFactory = new FakeGameFactory();
		var fakedView = new FakeMainMenuView();
		var supervisor = new MainMenuSupervisor(fakedFactory);
		supervisor.setView(fakedView);
		
		supervisor.onNewGameRequested(3);
		
		fakedView.received("goTo(PlayGameView)");
	}

}
