package zanzibar.supervisors;

import java.util.List;

public interface PlayGameView {

	void setRound(int round, int total);

	void setActivePlayer(int playerIndex);

	void resetRoll();

	void setPlayersScores(List<Integer> scores);

	void setRoll(List<Integer> roll, int rollScore);

	void goTo(String viewName);
}
