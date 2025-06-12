package zanzibar.views;

import java.awt.FlowLayout;
import java.util.Objects;

import javax.swing.JButton;

import zanzibar.supervisors.MainMenuSupervisor;

public class MainMenuView extends SwingView implements zanzibar.supervisors.MainMenuView {
	private final MainMenuSupervisor supervisor;

	public MainMenuView(MainMenuSupervisor supervisor) {
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.add(makeNewGameButton("Nouvelle partie 2", () -> supervisor.onNewGameRequested(2)));
		this.add(makeNewGameButton("Nouvelle partie 3", () -> supervisor.onNewGameRequested(3)));
		this.add(makeNewGameButton("Nouvelle partie 4", () -> supervisor.onNewGameRequested(4)));
		this.add(makeNewGameButton("Quitter", () -> supervisor.onExitRequested()));
		
		this.supervisor = Objects.requireNonNull(supervisor);
		this.supervisor.setView(this);
	}

	public JButton makeNewGameButton(String label, Runnable action) {
		var button = new JButton(label);
		button.addActionListener((evt) -> action.run());
		return button;
	}
	
	@Override
	public void exitConfirmed() {
		System.exit(0);
	}

}
