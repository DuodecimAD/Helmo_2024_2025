package zanzibar.supervisors;

import java.util.Objects;

import zanzibar.domains.GameFactory;

public class MainMenuSupervisor {
	private final GameFactory factory;
	private MainMenuView view;

	public MainMenuSupervisor(GameFactory factory) {
		this.factory = Objects.requireNonNull(factory);
	}

	public void setView(MainMenuView view) {
		this.view = Objects.requireNonNull(view);
		
	}

	public void onExitRequested() {
		Objects.requireNonNull(view);
		
		view.exitConfirmed();
	}

	public void onNewGameRequested(int playersCount) {
		this.factory.newGame(playersCount);
		this.view.goTo(PlayGameView.class.getSimpleName());
	}


}
