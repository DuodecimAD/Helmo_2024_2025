package zanzibar.domains;

import java.util.List;

public class Player {
	private int score;
	
	public void roll(Dices dices) {
		List<Integer> d = dices.roll();
		DicesRoll newRoll = new DicesRoll(d.get(0), d.get(1), d.get(2));
		score += newRoll.getPoints();
		
	}

	public int getScore() {
		return score;
	}

}
