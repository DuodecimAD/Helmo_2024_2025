package zanzibar;

import java.util.List;

import javax.swing.SwingUtilities;

import zanzibar.views.MainWindow;
import zanzibar.views.PlayGameView;
import zanzibar.domains.DefaultGameFactory;
import zanzibar.supervisors.GameOverSupervisor;
import zanzibar.supervisors.MainMenuSupervisor;
import zanzibar.supervisors.PlayGameSupervisor;
import zanzibar.views.GameOverView;
import zanzibar.views.MainMenuView;

/**
 * Construit le réseaux d'objets représentant l'application.
 * <p>
 * Démarre ensuite l'application
 * </p>
 * */
public class Program {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			final DefaultGameFactory factory = new DefaultGameFactory();
			var mainMenuSupervisor = new MainMenuSupervisor(factory);
			var playGameSupervisor = new PlayGameSupervisor(factory);
			var gameOverSupervisor = new GameOverSupervisor(factory);
			
			var window = new MainWindow("Zanzibar", List.of(
				new MainMenuView(mainMenuSupervisor),
				new PlayGameView(playGameSupervisor),
				new GameOverView(gameOverSupervisor)
			));
			
			window.setDefaultCloseOperation(MainWindow.EXIT_ON_CLOSE);
			window.goTo("MainMenuView");
			window.setVisible(true);
		});
	}
}
