package zanzibar.supervisors;

import java.util.*;

import zanzibar.domains.*;

public class PlayGameSupervisor {
	private PlayGameView view;
	private GameFactory factory;
	private ZanzibarGame currentGame;
	private int rollCount = 0;
	
	public PlayGameSupervisor(GameFactory factory) {
		this.factory = Objects.requireNonNull(factory);
	}

	public void setView(PlayGameView view) {
		this.view = Objects.requireNonNull(view);
	}
	
	public void onEnter(String fromView) {
		this.view.setRound(1, 3);
		this.view.setPlayersScores(List.of(0, 0, 0));
		this.view.setActivePlayer(1);
		this.view.resetRoll();
	}
	
	public void onRollRequested() {
		this.view.setRoll(List.of(5, 4, 2), 11);
		this.view.setRound(1, 3);
		this.view.setPlayersScores(List.of(0, 0, 0));
		this.view.setActivePlayer(1);
		//TODO si le jeu est terminé, passer à l'écran de fin de partie
		++rollCount;
		if(rollCount == 2) {
			this.rollCount = 0;
			this.view.goTo(GameOverView.class.getSimpleName());
		}
	}

}
