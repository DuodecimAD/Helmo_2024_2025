package zanzibar.supervisors;

import java.util.*;

import zanzibar.domains.GameFactory;

public class GameOverSupervisor {
	private final GameFactory factory;
	private GameOverView view;

	public GameOverSupervisor(GameFactory factory) {
		this.factory = Objects.requireNonNull(factory);
	}
	
	public void setView(GameOverView view) {
		this.view = Objects.requireNonNull(view);		
	}
	
	public void onEnter(String fromView) {
		//TODO: récupérer la dernière partie
		this.view.clear();
		this.view.addScores(List.of(62, 122, 28));//Les scores de trois joueurs
		this.view.setWinner(1); // Le joueur 2 est le vainqueur
		this.view.addRoll(List.of(4, 5, 2), 11); // Les lancers du vainqueur
		this.view.addRoll(List.of(6, 5, 2), 107);
		this.view.addRoll(List.of(1, 5, 2), 8);
	}
	
	public void onGoToMain() {
		this.view.goTo(MainMenuView.class.getSimpleName());
	}

}
