package zanzibar.supervisors;

import java.util.List;

public interface GameOverView {

	void clear();

	void addScores(List<Integer> playersScores);

	void setWinner(int playerIndex);

	void addRoll(List<Integer> roll, int rollScore);

	void goTo(String simpleName);

}
