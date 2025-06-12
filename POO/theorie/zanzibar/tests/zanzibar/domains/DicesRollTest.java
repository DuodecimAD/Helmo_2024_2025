package zanzibar.domains;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DicesRollTest {

	@ParameterizedTest
	@MethodSource("makeDicesRoll")
	void compute_points_based_on_given_dices(int dice1, int dice2, int dice3, int expectedPoints) {
		var roll = new DicesRoll(dice1, dice2, dice3);
		
		var actual = roll.getPoints();
		
		assertEquals(expectedPoints, actual);
	}

	static List<Arguments> makeDicesRoll() {
		return List.of(
			Arguments.of(2,3,4,9), // Happy path == un cas simple, sans branchement
			Arguments.of(1,2,3, 105), // Un premier cas de branchement
			Arguments.of(1, 6, 2, 162),// Un second cas de branchement
			Arguments.of(6, 6, 1, 220)// Une combinaison de cas
		);
	}
	
}

