package zanzibar.views;

import java.util.List;

import zanzibar.FakeObject;
import zanzibar.supervisors.PlayGameView;

public class FakePlayGameView extends FakeObject implements PlayGameView {

	@Override
	public void setRound(int round, int total) {
		addCall("setRound("+round+","+total+")");
		
	}

	@Override
	public void setActivePlayer(int playerIndex) {
		addCall("setActivePlayer("+playerIndex+")");
		
	}

	@Override
	public void resetRoll() {
		addCall("resetRoll()");
		
	}

	@Override
	public void setPlayersScores(List<Integer> scores) {
		addCall("setPlayersScores("+scores+")");
		
	}

	@Override
	public void setRoll(List<Integer> roll, int rollScore) {
		addCall("setRoll("+roll+","+rollScore+")");
	}

	@Override
	public void goTo(String viewName) {
		addCall("goTo("+viewName+")");
	}

}
