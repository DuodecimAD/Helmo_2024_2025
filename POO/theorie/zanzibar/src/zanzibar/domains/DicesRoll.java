package zanzibar.domains;

import java.util.List;

public class DicesRoll {

	private final List<Integer> dices;

	public DicesRoll(int dice1, int dice2, int dice3) {
		this.dices = List.of(dice1, dice2, dice3);
	}

	public int getPoints() {
		int sum = 0;
		
		for(var dice : this.dices) {
			sum += switch(dice) {
			case 1 -> 100;
			case 6 -> 60;
			default -> dice;
			};
		}
		
		return sum;
	}

}
