package zanzibar.views;

import java.awt.GridLayout;
import java.util.List;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JLabel;

import zanzibar.supervisors.GameOverSupervisor;

public class GameOverView extends SwingView implements zanzibar.supervisors.GameOverView {
	private GameOverSupervisor supervisor;
	private JButton goToMainButton;
	public GameOverView(GameOverSupervisor supervisor) {
		setLayout(new GridLayout(0, 1));		
		
		goToMainButton = new JButton("Retour au menu principal");
		
		this.supervisor = Objects.requireNonNull(supervisor);
		this.supervisor.setView(this);
		
		goToMainButton.addActionListener(evt -> this.supervisor.onGoToMain());
	}
	
	@Override
	public void clear() {
		this.removeAll();
		this.add(goToMainButton);
		this.add(new JLabel("Fin de la partie"));		
	}

	@Override
	public void addScores(List<Integer> playersScores) {
		for(int i=0; i < playersScores.size(); ++i) {
			this.add(new JLabel(String.format("Joueur %d : %d points", i + 1, playersScores.get(i))));
		}
		
	}

	@Override
	public void setWinner(int playerIndex) {
		this.add(new JLabel("Le vainqueur est le joueur "+(playerIndex+1)));
		
	}

	@Override
	public void addRoll(List<Integer> roll, int rollScore) {
		StringBuilder result = new StringBuilder();
		for(var dice : roll) {
			result.append(switch(dice) {
			case 1 ->'\u2680';
			case 2 ->'\u2681';
			case 3 ->'\u2682';
			case 4 ->'\u2683';
			case 5 ->'\u2684';
			case 6 ->'\u2685';
			default -> '?';
			});
		}
		result.append("| Score : "+rollScore);
		this.add(new JLabel(result.toString()));
		
	}
	
	@Override
	public void onEnter(String fromView) {
		this.supervisor.onEnter(fromView);
	}

}
