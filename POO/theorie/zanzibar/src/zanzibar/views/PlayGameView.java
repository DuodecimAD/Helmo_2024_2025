package zanzibar.views;

import java.awt.FlowLayout;
import java.util.*;

import javax.swing.*;

import zanzibar.supervisors.PlayGameSupervisor;

public class PlayGameView extends SwingView implements zanzibar.supervisors.PlayGameView {
	private PlayGameSupervisor supervisor;
	private JLabel roundLabel;
	private JPanel playersPanel;
	private JLabel currentPlayerLabel;
	private JLabel rollLabel;
	private JButton launchButton;
	
	public PlayGameView(PlayGameSupervisor supervisor) {
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setFont(this.getFont().deriveFont(32f));
		this.add(playersPanel = new JPanel());
		playersPanel.setSize(getWidth(), 128);
		this.add(roundLabel = new JLabel("Tour 0 sur 3"));
		this.add(currentPlayerLabel = new JLabel("Au tour du joueur 1"));
		currentPlayerLabel.setFont(currentPlayerLabel.getFont().deriveFont(24f));
		this.add(launchButton = new JButton("Lancer"));
		this.add(rollLabel = new JLabel("Aucun lancer"));
		rollLabel.setFont(rollLabel.getFont().deriveFont(32f));
		this.supervisor = Objects.requireNonNull(supervisor);
		this.supervisor.setView(this);
		
		launchButton.addActionListener(evt -> this.supervisor.onRollRequested());
	}
	
	@Override
	public void onEnter(String fromView) {
		supervisor.onEnter(fromView);
	}
	
	@Override
	public void setRound(int round, int total) {
		roundLabel.setText(String.format("Tour %d sur %d", round, total));
	}

	@Override
	public void setPlayersScores(List<Integer> scores) {
		this.playersPanel.removeAll();
		for(int i=0; i < scores.size(); ++i) {
			var msg = String.format("Joueur %d : %d points", i+1, scores.get(i));
			var label = new JLabel(msg);
			playersPanel.add(label);
		}
		
	}
	
	@Override
	public void setActivePlayer(int playerIndex) {
		currentPlayerLabel.setText("Au tour du joueur "+playerIndex);		
	}

	@Override
	public void resetRoll() {
		this.rollLabel.setText("Aucun lancer");
		
	}

	@Override
	public void setRoll(List<Integer> roll, int rollScore) {
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
		
		rollLabel.setText(result.toString());
	}
}

